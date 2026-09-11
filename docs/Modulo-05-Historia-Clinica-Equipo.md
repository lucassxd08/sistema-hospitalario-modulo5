# Módulo 5 — Historia Clínica · Reparto del equipo

Evaluación N° 01 — Desarrollo de Aplicaciones Web Avanzado (Spring Boot · IoC/DI · REST · Hibernate/JPA · Thymeleaf)

Documento fuente: [Evaluacion-01.md](Evaluacion-01.md) · Índice general: [Indice-Modulos.md](Indice-Modulos.md)

---

## 1. Contexto del módulo

> El módulo permitirá crear, consultar y gestionar la historia clínica del paciente, registrando sus antecedentes, consultas, signos vitales, diagnósticos, tratamientos, procedimientos, recetas y evolución médica.

La relación principal definida en el documento:

```
PACIENTE
   │
   ▼
HISTORIA CLÍNICA
   │
   ├── Antecedentes      ← Parte A (Renzo)
   ├── Consultas
   ├── Signos vitales
   ├── Diagnósticos
   ├── Tratamientos
   ├── Medicamentos
   ├── Procedimientos
   ├── Exámenes
   └── Evolución
```

**Dificultad del módulo: ★★★★☆ (4/5)** — pero el recorte asignado al equipo (6 de los 24 RF) se queda en la parte estructural y de antecedentes, que es la más abordable: son CRUD con relaciones `OneToMany` y `ManyToOne`, sin máquinas de estado ni lógica transaccional.

---

## 2. Reparto acordado

| Responsable | Grupo de RF | Requerimientos | Alcance |
| --- | --- | --- | --- |
| **Renzo** | Antecedentes (los 3 primeros) | RF-HC-05, RF-HC-06, RF-HC-07 | Antecedentes personales, familiares y alergias |
| **Compañero/a** | Historia clínica (los 3 primeros) | RF-HC-01, RF-HC-02, RF-HC-03 | Número único de HC, consulta de la HC y datos básicos del paciente |

**Nota sobre el orden de trabajo:** la Parte B es prerrequisito de la Parte A — los antecedentes cuelgan de una `HistoriaClinica` que debe existir primero. Conviene acordar la entidad `HistoriaClinica` entre ambos **antes** de empezar (ver §5, Contrato compartido) y que la Parte B la cree en las primeras horas del trabajo.

**Fuera del alcance del equipo** (del mismo grupo de RF, no asignados): RF-HC-04 (mantener el historial de atenciones) y RF-HC-08 en adelante (consultas médicas, signos vitales, diagnósticos, tratamientos, recetas, exámenes, seguridad y auditoría).

---

# PARTE A — Antecedentes (Renzo)

## RF-HC-05 · Registrar antecedentes personales

> **RF-HC-05:** El sistema deberá permitir registrar antecedentes personales.

### Contenido según el documento (sección 4)

Antecedentes personales a registrar:

- Enfermedades previas
- Cirugías
- Hospitalizaciones
- Enfermedades crónicas
- Traumatismos
- Transfusiones
- Otros antecedentes relevantes

### Decisión de diseño recomendada

En lugar de crear 7 tablas (una por tipo), usar **una sola entidad** `AntecedentePersonal` con un campo `tipo` de tipo `enum`. Es más simple, más fácil de consultar y evita duplicar el mismo CRUD siete veces.

```java
public enum TipoAntecedentePersonal {
    ENFERMEDAD_PREVIA, CIRUGIA, HOSPITALIZACION, ENFERMEDAD_CRONICA,
    TRAUMATISMO, TRANSFUSION, OTRO
}
```

### Entidad

| Campo | Tipo | Notas |
| --- | --- | --- |
| id | Long | PK autogenerada |
| historiaClinica | HistoriaClinica | `@ManyToOne`, obligatorio |
| tipo | TipoAntecedentePersonal | `@Enumerated(EnumType.STRING)`, obligatorio |
| descripcion | String (255) | Obligatorio |
| fechaEvento | LocalDate | Opcional (cuándo ocurrió), no puede ser futura |
| observaciones | String (500) | Opcional |
| fechaRegistro | LocalDateTime | Automático al crear |
| activo | Boolean | Para baja lógica, por defecto `true` |

```java
@Entity
@Table(name = "antecedente_personal")
public class AntecedentePersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "historia_clinica_id", nullable = false)
    private HistoriaClinica historiaClinica;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TipoAntecedentePersonal tipo;

    @NotBlank
    @Column(nullable = false, length = 255)
    private String descripcion;

    @PastOrPresent
    private LocalDate fechaEvento;

    @Column(length = 500)
    private String observaciones;

    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(nullable = false)
    private Boolean activo = true;

    @PrePersist
    void prePersist() {
        this.fechaRegistro = LocalDateTime.now();
    }
    // getters y setters
}
```

### Endpoints REST

| Método | Ruta | Descripción |
| --- | --- | --- |
| GET | `/api/historias/{hcId}/antecedentes-personales` | Listar los antecedentes de una HC |
| GET | `/api/antecedentes-personales/{id}` | Obtener uno |
| POST | `/api/historias/{hcId}/antecedentes-personales` | Registrar |
| PUT | `/api/antecedentes-personales/{id}` | Modificar |
| DELETE | `/api/antecedentes-personales/{id}` | Baja lógica (`activo = false`) |

### Validaciones

- La historia clínica referida debe existir → si no, `404 Not Found`.
- `tipo` y `descripcion` son obligatorios → si faltan, `400 Bad Request`.
- `fechaEvento` no puede ser posterior a hoy.
- No se borra físicamente: el `DELETE` marca `activo = false` (coherente con la regla del documento de no eliminar información clínica).

### Criterios de aceptación

- [ ] Se puede registrar un antecedente personal indicando tipo y descripción, y queda asociado a la historia clínica correcta.
- [ ] Al consultar la historia clínica se listan solo sus antecedentes activos, agrupados por tipo.
- [ ] Intentar registrar sin descripción devuelve error de validación y no guarda nada.
- [ ] Eliminar oculta el registro de la lista pero el dato sigue en la base de datos.

---

## RF-HC-06 · Registrar antecedentes familiares

> **RF-HC-06:** El sistema deberá permitir registrar antecedentes familiares.

### Contenido según el documento (sección 4)

Antecedentes familiares a registrar:

- Diabetes
- Hipertensión
- Enfermedades cardiovasculares
- Cáncer
- Enfermedades hereditarias
- Otros

### Decisión de diseño recomendada

Misma estrategia que RF-HC-05: una entidad con `enum` de tipo. La diferencia respecto a los personales es el campo **parentesco**, que es lo que da valor clínico al antecedente familiar (no es lo mismo diabetes en la madre que en un tío).

```java
public enum TipoAntecedenteFamiliar {
    DIABETES, HIPERTENSION, CARDIOVASCULAR, CANCER, HEREDITARIA, OTRO
}

public enum Parentesco {
    PADRE, MADRE, HERMANO, ABUELO, TIO, HIJO, OTRO
}
```

### Entidad

| Campo | Tipo | Notas |
| --- | --- | --- |
| id | Long | PK autogenerada |
| historiaClinica | HistoriaClinica | `@ManyToOne`, obligatorio |
| tipo | TipoAntecedenteFamiliar | `@Enumerated(EnumType.STRING)`, obligatorio |
| parentesco | Parentesco | Obligatorio |
| descripcion | String (255) | Opcional (detalle libre) |
| observaciones | String (500) | Opcional |
| fechaRegistro | LocalDateTime | Automático |
| activo | Boolean | Baja lógica |

```java
@Entity
@Table(name = "antecedente_familiar")
public class AntecedenteFamiliar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "historia_clinica_id", nullable = false)
    private HistoriaClinica historiaClinica;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TipoAntecedenteFamiliar tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Parentesco parentesco;

    @Column(length = 255)
    private String descripcion;

    @Column(length = 500)
    private String observaciones;

    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(nullable = false)
    private Boolean activo = true;
    // getters y setters
}
```

### Endpoints REST

| Método | Ruta | Descripción |
| --- | --- | --- |
| GET | `/api/historias/{hcId}/antecedentes-familiares` | Listar |
| GET | `/api/antecedentes-familiares/{id}` | Obtener uno |
| POST | `/api/historias/{hcId}/antecedentes-familiares` | Registrar |
| PUT | `/api/antecedentes-familiares/{id}` | Modificar |
| DELETE | `/api/antecedentes-familiares/{id}` | Baja lógica |

### Validaciones

- `tipo` y `parentesco` obligatorios.
- Evitar duplicados exactos: no registrar dos veces el mismo `tipo` + `parentesco` activos en la misma historia → `409 Conflict`.

### Criterios de aceptación

- [ ] Se registra un antecedente familiar indicando enfermedad y parentesco.
- [ ] El listado muestra la combinación legible, p. ej. *"Diabetes — Madre"*.
- [ ] Registrar dos veces "Diabetes / Madre" en la misma historia devuelve conflicto.

---

## RF-HC-07 · Registrar alergias

> **RF-HC-07:** El sistema deberá permitir registrar alergias.

### Contenido según el documento (sección 5)

Campos que el documento pide registrar:

- Alergia
- Tipo
- Reacción
- Observaciones
- Fecha de registro

Ejemplo del documento:

```
ALERGIAS
Medicamento: Penicilina
Reacción: Erupción cutánea
Observación: Reacción alérgica reportada por paciente
```

El documento añade una nota importante: *esta información debería ser visible para el personal médico autorizado durante la atención*. En la práctica eso significa mostrar las alergias **destacadas** (banner rojo o similar) en la cabecera de la historia clínica, no escondidas en una pestaña.

### Entidad

| Campo | Tipo | Notas |
| --- | --- | --- |
| id | Long | PK autogenerada |
| historiaClinica | HistoriaClinica | `@ManyToOne`, obligatorio |
| tipo | TipoAlergia | MEDICAMENTO, ALIMENTO, AMBIENTAL, OTRO |
| nombre | String (150) | La alergia en sí (p. ej. "Penicilina") |
| reaccion | String (255) | Reacción presentada |
| severidad | Severidad | LEVE, MODERADA, SEVERA — opcional pero muy recomendable |
| observaciones | String (500) | Opcional |
| fechaRegistro | LocalDateTime | Automático |
| activo | Boolean | Baja lógica |

```java
public enum TipoAlergia { MEDICAMENTO, ALIMENTO, AMBIENTAL, OTRO }
public enum Severidad { LEVE, MODERADA, SEVERA }

@Entity
@Table(name = "alergia")
public class Alergia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "historia_clinica_id", nullable = false)
    private HistoriaClinica historiaClinica;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoAlergia tipo;

    @NotBlank
    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(length = 255)
    private String reaccion;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Severidad severidad;

    @Column(length = 500)
    private String observaciones;

    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(nullable = false)
    private Boolean activo = true;
    // getters y setters
}
```

### Endpoints REST

| Método | Ruta | Descripción |
| --- | --- | --- |
| GET | `/api/historias/{hcId}/alergias` | Listar alergias de la HC |
| GET | `/api/historias/{hcId}/alergias/activas` | Solo activas — la que consume la cabecera de la HC |
| POST | `/api/historias/{hcId}/alergias` | Registrar |
| PUT | `/api/alergias/{id}` | Modificar |
| DELETE | `/api/alergias/{id}` | Baja lógica |

### Validaciones

- `tipo` y `nombre` obligatorios.
- No duplicar la misma alergia activa (`nombre` ignorando mayúsculas) en una misma historia → `409 Conflict`.
- Nunca borrado físico: una alergia es información de seguridad del paciente.

### Criterios de aceptación

- [ ] Se registra una alergia con tipo, nombre y reacción.
- [ ] Las alergias activas aparecen destacadas en la cabecera de la historia clínica.
- [ ] Registrar "penicilina" cuando ya existe "Penicilina" activa devuelve conflicto.
- [ ] Un paciente sin alergias muestra el mensaje "Sin alergias registradas" y no una tabla vacía.

---

## Vistas Thymeleaf — Parte A

```
templates/historia/antecedentes/
├── lista.html        → pestañas: Personales | Familiares | Alergias
├── form-personal.html
├── form-familiar.html
└── form-alergia.html
```

Detalles que suman en la rúbrica (criterio *Frontend*):

- Cabecera fija con los datos del paciente (viene de la Parte B) en las tres pestañas, para que el médico nunca pierda de vista de quién es la historia.
- Banner de alergias activas siempre visible, con color según severidad.
- Formularios con `th:object` y `th:field`, mostrando los errores de validación con `th:errors`.
- Selects de `tipo`, `parentesco` y `severidad` poblados desde los `enum`, no escritos a mano en el HTML.

---

# PARTE B — Historia clínica (compañero/a)

## RF-HC-01 · Número único de historia clínica

> **RF-HC-01:** El sistema deberá generar un número único de historia clínica para cada paciente.

### Contenido según el documento (sección 2)

> Al registrar un paciente, el sistema podrá generar automáticamente su historia clínica. […] La historia clínica deberá tener un número único.

Formato del ejemplo del documento: **`HC-000125`** (prefijo `HC-` + correlativo de 6 dígitos).

### Entidad

| Campo | Tipo | Notas |
| --- | --- | --- |
| id | Long | PK autogenerada |
| numeroHistoria | String (15) | **UNIQUE**, formato `HC-000000` |
| paciente | Paciente | `@OneToOne`, único — un paciente, una historia |
| fechaApertura | LocalDate | Fecha de creación |
| estado | EstadoHistoria | ACTIVA / INACTIVA |
| observaciones | String (500) | Opcional |

```java
public enum EstadoHistoria { ACTIVA, INACTIVA }

@Entity
@Table(name = "historia_clinica",
       uniqueConstraints = @UniqueConstraint(columnNames = "numero_historia"))
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_historia", nullable = false, unique = true, length = 15)
    private String numeroHistoria;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paciente_id", nullable = false, unique = true)
    private Paciente paciente;

    @Column(nullable = false)
    private LocalDate fechaApertura;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private EstadoHistoria estado = EstadoHistoria.ACTIVA;

    @Column(length = 500)
    private String observaciones;

    @OneToMany(mappedBy = "historiaClinica", cascade = CascadeType.ALL)
    private List<AntecedentePersonal> antecedentesPersonales = new ArrayList<>();

    @OneToMany(mappedBy = "historiaClinica", cascade = CascadeType.ALL)
    private List<AntecedenteFamiliar> antecedentesFamiliares = new ArrayList<>();

    @OneToMany(mappedBy = "historiaClinica", cascade = CascadeType.ALL)
    private List<Alergia> alergias = new ArrayList<>();
    // getters y setters
}
```

### Generación del correlativo

```java
@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    private final HistoriaClinicaRepository repository;

    // Inyección por constructor: es lo que evalúa el criterio de IoC/DI de la rúbrica
    public HistoriaClinicaServiceImpl(HistoriaClinicaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public HistoriaClinica aperturar(Paciente paciente) {
        if (repository.existsByPacienteId(paciente.getId())) {
            throw new NegocioException("El paciente ya tiene una historia clínica");
        }
        HistoriaClinica hc = new HistoriaClinica();
        hc.setPaciente(paciente);
        hc.setNumeroHistoria(siguienteNumero());
        hc.setFechaApertura(LocalDate.now());
        hc.setEstado(EstadoHistoria.ACTIVA);
        return repository.save(hc);
    }

    private String siguienteNumero() {
        long correlativo = repository.count() + 1;
        return String.format("HC-%06d", correlativo);
    }
}
```

> ⚠️ `count() + 1` es suficiente para la evaluación, pero se rompe si se elimina una historia o con dos usuarios creando a la vez. Si quieren la versión robusta: una tabla `correlativo` con bloqueo, o `@Query("select max(...)")` dentro de la transacción. Vale la pena mencionarlo en la exposición.

### Criterios de aceptación

- [ ] Al registrar un paciente se crea su historia clínica automáticamente.
- [ ] El número sigue el formato `HC-000001`, `HC-000002`, …
- [ ] Un mismo paciente no puede tener dos historias clínicas (restricción `unique` en BD, no solo en Java).

---

## RF-HC-02 · Consultar la historia clínica de un paciente

> **RF-HC-02:** El sistema deberá permitir consultar la historia clínica de un paciente.

### Alcance

Buscar y abrir la historia clínica. Según la estructura de menú del documento, el punto de entrada es **"Buscar paciente"** → **"Historia clínica"**.

Criterios de búsqueda coherentes con el Módulo 2: número de historia, DNI, código de paciente, nombres y apellidos.

### Endpoints REST

| Método | Ruta | Descripción |
| --- | --- | --- |
| GET | `/api/historias` | Listar / buscar con filtros `?dni=`&`?numero=`&`?nombre=` |
| GET | `/api/historias/{id}` | Obtener por id |
| GET | `/api/historias/numero/{numeroHistoria}` | Obtener por número de HC |
| GET | `/api/pacientes/{pacienteId}/historia` | Obtener la historia de un paciente |

```java
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Long> {
    Optional<HistoriaClinica> findByNumeroHistoria(String numeroHistoria);
    Optional<HistoriaClinica> findByPacienteId(Long pacienteId);
    boolean existsByPacienteId(Long pacienteId);
    List<HistoriaClinica> findByPacienteNumeroDocumentoContaining(String documento);
}
```

### Validaciones

- Historia inexistente → `404 Not Found` con mensaje claro, no una página de error genérica.
- Búsqueda sin resultados → lista vacía con mensaje, no error.

### Criterios de aceptación

- [ ] Se encuentra la historia buscando por DNI del paciente.
- [ ] Se encuentra la historia buscando por número `HC-…`.
- [ ] Buscar un DNI inexistente muestra "No se encontraron resultados".

---

## RF-HC-03 · Mostrar los datos básicos del paciente

> **RF-HC-03:** El sistema deberá mostrar los datos básicos del paciente asociados a su historia clínica.

### Contenido según el documento (sección 3)

Al ingresar a la historia clínica el sistema deberá mostrar:

- Código de paciente
- Número de historia clínica
- DNI
- Nombres y apellidos
- Fecha de nacimiento
- Edad
- Sexo
- Teléfono
- Dirección
- Tipo de seguro
- Contacto de emergencia

> **Regla explícita del documento:** *"Los datos personales deberán provenir del Módulo Pacientes, evitando duplicarlos innecesariamente."*

Esto es una indicación directa de diseño: **no copiar** nombre, DNI ni dirección dentro de `HistoriaClinica`. Se leen por la relación `@OneToOne` hacia `Paciente`. Es justo el tipo de detalle que evalúa el criterio *Base de datos y relaciones* de la rúbrica.

### DTO de respuesta

```java
public record HistoriaClinicaDetalleDTO(
        Long id,
        String numeroHistoria,
        LocalDate fechaApertura,
        String estado,
        String codigoPaciente,
        String numeroDocumento,
        String nombreCompleto,
        LocalDate fechaNacimiento,
        Integer edad,              // calculada, NO almacenada
        String sexo,
        String telefono,
        String direccion,
        String tipoSeguro,
        String contactoEmergencia
) {}
```

La **edad se calcula**, no se guarda (si se guardara quedaría desactualizada):

```java
int edad = Period.between(paciente.getFechaNacimiento(), LocalDate.now()).getYears();
```

### Criterios de aceptación

- [ ] La cabecera de la historia muestra los 11 datos listados.
- [ ] La edad mostrada es correcta y coherente con la fecha de nacimiento.
- [ ] Al actualizar el teléfono en el Módulo Pacientes, la historia clínica refleja el cambio sin necesidad de editarla (prueba de que no hay duplicación de datos).
- [ ] Ningún dato personal está duplicado como columna en la tabla `historia_clinica`.

---

## Vistas Thymeleaf — Parte B

```
templates/historia/
├── buscar.html      → buscador por DNI / número HC / nombre
├── detalle.html     → cabecera con datos del paciente + pestañas hacia Parte A
└── fragments/
    └── cabecera-paciente.html   ← fragmento reutilizable
```

`cabecera-paciente.html` debe ser un **fragmento Thymeleaf** (`th:fragment`), porque la Parte A lo reutiliza en las tres pestañas de antecedentes. Es el punto de integración visual entre ambas partes.

---

# 5. Contrato compartido entre las dos partes

Acuerden esto antes de escribir código; es lo que permite trabajar en paralelo sin pisarse.

| Elemento | Lo define | Lo consume |
| --- | --- | --- |
| Entidad `HistoriaClinica` | Parte B | Parte A (`@ManyToOne` desde las 3 entidades) |
| `HistoriaClinicaRepository` | Parte B | Parte A (para validar que la HC existe) |
| Fragmento `cabecera-paciente.html` | Parte B | Parte A (en sus 3 vistas) |
| Colecciones `antecedentesPersonales`, `antecedentesFamiliares`, `alergias` | Parte A (las entidades) | Parte B (las declara como `@OneToMany(mappedBy=…)`) |
| Ruta base `/api/historias/{hcId}/…` | Acordada | Ambas |

**Riesgo a evitar:** que ambos creen su propia versión de `HistoriaClinica`. Sugerencia práctica — que la Parte B suba primero la entidad y el repositorio a la rama principal, y recién entonces la Parte A cree las suyas encima.

### Modelo de datos resultante

```
paciente (Módulo 2)
    │ 1
    │
    │ 1
historia_clinica ── numero_historia UNIQUE
    │ 1
    ├──────────────┬──────────────────┐
    │ N            │ N                │ N
antecedente_    antecedente_       alergia
  personal        familiar
```

---

# 6. Estructura de paquetes sugerida

Refleja las capas que exige el criterio de *Arquitectura (IoC y DI)* de la rúbrica:

```
com.hospital.sistema
├── model/          → HistoriaClinica, AntecedentePersonal, AntecedenteFamiliar, Alergia + enums
├── repository/     → interfaces JpaRepository
├── service/        → interfaces
│   └── impl/       → implementaciones anotadas con @Service
├── controller/
│   ├── api/        → @RestController  (los endpoints REST del CRUD)
│   └── web/        → @Controller      (las vistas Thymeleaf)
├── dto/            → DTOs y records de request/response
└── exception/      → NegocioException + @ControllerAdvice
```

**Puntos de la rúbrica que esto cubre directamente:**

- *IoC y DI* → inyección **por constructor** en services y controllers, nunca `@Autowired` sobre el campo, y controllers que dependen de la **interfaz** del service, no de la implementación.
- *Backend REST* → un `@RestController` por entidad con los 5 verbos y códigos HTTP correctos (`201` al crear, `204` al eliminar, `404` si no existe, `400` en validación).
- *Base de datos y relaciones* → `@OneToOne` paciente–historia y `@OneToMany`/`@ManyToOne` historia–antecedentes, con `mappedBy` y `fetch = LAZY`.

---

# 7. Evidencia de pruebas (Postman)

El criterio *Pruebas* de la rúbrica pide evidencia de endpoints verificados. Colección mínima sugerida:

| # | Petición | Resultado esperado |
| --- | --- | --- |
| 1 | `POST /api/pacientes` | `201` — se crea paciente y su HC |
| 2 | `GET /api/pacientes/{id}/historia` | `200` — devuelve `HC-000001` |
| 3 | `GET /api/historias/numero/HC-000001` | `200` — datos básicos completos, edad calculada |
| 4 | `GET /api/historias/numero/HC-999999` | `404` |
| 5 | `POST /api/historias/1/antecedentes-personales` | `201` — antecedente creado |
| 6 | `POST` el mismo sin `descripcion` | `400` — error de validación |
| 7 | `POST /api/historias/1/antecedentes-familiares` (Diabetes/Madre) | `201` |
| 8 | Repetir la #7 | `409` — duplicado |
| 9 | `POST /api/historias/1/alergias` (Penicilina) | `201` |
| 10 | `GET /api/historias/1/alergias/activas` | `200` — la alergia aparece |
| 11 | `DELETE /api/alergias/1` → repetir la #10 | `204`, luego lista vacía (baja lógica) |
| 12 | `POST /api/historias/9999/alergias` | `404` — HC inexistente |

Capturar cada respuesta con su código de estado. Exportar la colección como `.json` y adjuntarla a la entrega.

---

# 8. Checklist de entrega

**Parte A — Renzo**

- [ ] Entidades `AntecedentePersonal`, `AntecedenteFamiliar`, `Alergia` + sus enums
- [ ] Los 3 repositorios
- [ ] Services con interfaz + implementación e inyección por constructor
- [ ] `@RestController` con CRUD completo para las 3 entidades
- [ ] Vistas Thymeleaf de antecedentes (3 formularios + listado con pestañas)
- [ ] Validaciones y baja lógica funcionando
- [ ] Pruebas Postman 5–12

**Parte B — Compañero/a**

- [ ] Entidad `HistoriaClinica` con `numeroHistoria` único
- [ ] Generación automática del correlativo `HC-000000`
- [ ] Repositorio con búsquedas por número, paciente y documento
- [ ] Service de apertura y consulta
- [ ] `@RestController` de consulta
- [ ] Vistas `buscar.html` y `detalle.html` + fragmento `cabecera-paciente.html`
- [ ] Datos del paciente leídos por relación, sin duplicar columnas
- [ ] Pruebas Postman 1–4

**Conjunto**

- [ ] La aplicación levanta y navega de extremo a extremo: buscar paciente → abrir HC → registrar antecedente → verlo listado
- [ ] Script o `data.sql` con datos de prueba
- [ ] Colección Postman exportada
- [ ] Capturas de las pruebas
