# Guion de sustentación — RF-HC-01, RF-HC-02, RF-HC-03
**Autor:** Lucas Inga · **Módulo:** Historia Clínica (Módulo 5) · **Estado:** Terminado

Requisitos que voy a explicar:
- **RF-HC-01** — Generar un número único de historia clínica
- **RF-HC-02** — Consultar la historia clínica de un paciente
- **RF-HC-03** — Mostrar los datos básicos del paciente

## Temas principales que el profesor quiere ver

1. **Decir el requerimiento** (leer el RF tal cual, con su código RF-HC-0X)
2. **Diagrama / relación de la base de datos** (sección 2.1)
3. **Postman** — probar los endpoints REST en vivo (sección 6)
4. **Que funcione** — demo real en el navegador (secciones 3.3, 4.3, 5.3)

Orden recomendado: (1) decir el requerimiento → (2) mostrar el diagrama de BD → (3) mostrar el código clave → (4) demo en navegador → (5) demo en Postman.

---

## 1. Introducción (30 seg)

"Buenas tardes profesor. Voy a explicar los tres requisitos funcionales que me correspondieron: generar el número único de historia clínica, consultar la historia clínica de un paciente, y mostrar los datos básicos del paciente. Estos tres RF son la base sobre la cual mi compañero Renzo construyó antecedentes, antecedentes familiares y alergias — todo cuelga de la `HistoriaClinica` y el `Paciente` que yo implementé."

---

## 2. Arquitectura común

Mismo patrón en capas que el resto del proyecto (Spring Boot + Thymeleaf + API REST):

| Capa | Archivo |
|---|---|
| Modelo | `model/Paciente.java`, `model/HistoriaClinica.java` |
| Repositorio | `repository/PacienteRepository.java`, `repository/HistoriaClinicaRepository.java` |
| Servicio | `service/PacienteService.java`, `service/HistoriaClinicaService.java` |
| Controlador MVC | `controller/PacienteController.java`, `controller/HistoriaClinicaController.java` |
| Controlador REST | `controller/PacienteRestController.java`, `controller/HistoriaClinicaRestController.java` |
| Vistas | `templates/pacientes.html`, `paciente-form.html`, `templates/historias.html`, `historia-detalle.html` |

### 2.1 Diagrama de base de datos (mostrar esto primero)

```
PACIENTE                    HISTORIA_CLINICA                  CONDICION_MEDICA
+------------+   1     1    +--------------------+   N     M   +----------------+
| id (PK)    |<------------>| id (PK)            |<----------->| id (PK)        |
| nombres    |  paciente_id | numero_historia UQ  |  (tabla     | nombre UQ      |
| apellidos  |              | paciente_id (FK) UQ |   puente:   +----------------+
| dni UQ     |              | fecha_apertura       |   historia_
+------------+              | estado               |   condicion)
                             +--------------------+
                                    | 1
                     +--------------+--------------+---------------+
                     | N                            | N             | N
              +------------------+        +---------------------+   +------------------+
              | ANTECEDENTE      |        | ANTECEDENTE_        |   | ALERGIA          |
              | (Renzo)          |        | FAMILIAR (Renzo)    |   | (Renzo)          |
              +------------------+        +---------------------+   +------------------+
```

**Explicación oral:**
- `PACIENTE` 1—1 `HISTORIA_CLINICA`: es la relación que genero yo — cada paciente tiene exactamente una historia clínica (`@OneToOne`, columna `paciente_id` con `unique = true`, así la base de datos impide crear dos historias para el mismo paciente).
- `numero_historia` también es `unique = true`: mi RF-HC-01 garantiza que ese número nunca se repita.
- `HISTORIA_CLINICA` 1—N hacia `Antecedente`, `AntecedenteFamiliar` y `Alergia`: esas tres tablas son el trabajo de mi compañero Renzo, pero todas dependen de la historia clínica que yo genero — por eso en la ficha del paciente (RF-HC-02) se muestran juntas.

**Tablas involucradas directamente en mi parte:**

| Tabla | Columnas clave |
|---|---|
| `paciente` | `id`, `nombres`, `apellidos`, `dni` (unique) |
| `historia_clinica` | `id`, `numero_historia` (unique), `paciente_id` (FK, unique → 1-1), `fecha_apertura`, `estado` |

---

## 3. RF-HC-01 — Generar un número único de historia clínica

### 3.1 Qué hace

Cuando se crea una historia clínica para un paciente, el sistema genera automáticamente un código único — el usuario no lo escribe a mano.

### 3.2 Código clave (`HistoriaClinicaService.crear`)

```java
public HistoriaClinica crear(Long pacienteId) {
    Paciente paciente = pacienteRepository.findById(pacienteId)
            .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + pacienteId));

    // Genera un número único simple basado en el id del paciente y la fecha
    String numeroHistoria = "HC-" + String.format("%06d", pacienteId) + "-" + System.currentTimeMillis() % 10000;

    HistoriaClinica historia = new HistoriaClinica(numeroHistoria, paciente, LocalDate.now(), "ACTIVA");
    return historiaClinicaRepository.save(historia);
}
```

**Explicación para el profe:** "El número tiene el formato `HC-<id del paciente con 6 dígitos>-<últimos 4 dígitos del timestamp actual>`. Por ejemplo, para el paciente con id 7, algo como `HC-000007-4821`. Primero valido que el paciente exista (`findById().orElseThrow()`); si no existe, no se genera nada. Además, la columna `numero_historia` tiene una restricción `unique = true` en la base de datos, así que aunque el algoritmo generara dos códigos iguales por coincidencia, la base de datos rechazaría el segundo insert — es una doble protección."

**Nota honesta si preguntan por mejoras:** el generador no tiene reintento automático en caso de colisión (no hay un `while` que regenere si ya existe); se apoya en la baja probabilidad de coincidencia del timestamp más la restricción `unique` de la BD como red de seguridad.

### 3.3 Endpoints

- **MVC:** `GET /historias/nueva` (formulario, lista de pacientes disponibles), `POST /historias/guardar` (recibe `pacienteId`, llama a `crear`, redirige a `/historias`)
- **REST:** `POST /api/historias` con body `{"pacienteId": 7}` → `201 Created`

### 3.4 Demo en vivo

1. Ir a `/pacientes`, verificar que existe un paciente sin historia clínica aún
2. Ir a `/historias/nueva`, seleccionar ese paciente, guardar
3. Mostrar en `/historias` el nuevo registro con su `numeroHistoria` generado automáticamente
4. (Opcional) Repetir con otro paciente y mostrar que el número es distinto

---

## 4. RF-HC-02 — Consultar la historia clínica de un paciente

### 4.1 Qué hace

Permite buscar y ver la historia clínica completa de un paciente, incluyendo todo lo asociado (antecedentes, antecedentes familiares y alergias).

### 4.2 Código clave (`HistoriaClinicaService`)

```java
buscarPorId(Long id)                       // Optional<HistoriaClinica>, via findById
buscarPorPacienteId(Long pacienteId)       // via historiaClinicaRepository.findByPacienteId(pacienteId)
```

La vista principal de este RF es `HistoriaClinicaController.verHistoria()`, que responde `GET /historias/{id}`: carga la historia clínica y además consulta sus `antecedentes`, `familiares` y `alergias` relacionados, y arma todo en `historia-detalle.html`.

### 4.3 Endpoints

- **MVC:** `GET /historias` (listado de todas), `GET /historias/{id}` (ficha completa — esta ruta es el corazón de RF-HC-02 y RF-HC-03 juntos)
- **REST:** `GET /api/historias` (listar todas), `GET /api/historias/{id}` (por id de historia, 200/404), `GET /api/historias/paciente/{pacienteId}` (por id de paciente, 200/404), además `PUT /api/historias/{id}` (actualizar estado), `DELETE /api/historias/{id}`, y endpoints extra para condiciones médicas (`POST/GET /api/historias/{id}/condiciones...`)

### 4.4 Demo en vivo

1. Ir a `/historias`, mostrar el listado
2. Clic en una historia → mostrar `/historias/{id}` con la ficha completa: datos del paciente, número de historia, fecha de apertura, estado, y las tres tablas de antecedentes/alergias de Renzo
3. "Aquí se ve la integración de todo el módulo 5 en una sola pantalla."

---

## 5. RF-HC-03 — Mostrar los datos básicos del paciente

### 5.1 Qué hace

Muestra la información básica registrada de cada paciente: nombres, apellidos y DNI.

### 5.2 Entidad (`Paciente`, tabla `paciente`)

- `id` — clave primaria autogenerada
- `nombres` — String, obligatorio, máx. 100 caracteres
- `apellidos` — String, obligatorio, máx. 100 caracteres
- `dni` — String, obligatorio y **único**, máx. 20 caracteres

`PacienteService` es un passthrough simple (`crear`, `listarTodos`, `buscarPorId`) sin lógica de validación adicional más allá de las restricciones de la entidad — la unicidad del DNI la garantiza la base de datos.

### 5.3 Endpoints

- **MVC:** `GET /pacientes` (listado — la vista literalmente incluye el rótulo "RF-HC-03: datos básicos del paciente"), `GET /pacientes/nuevo` (formulario), `POST /pacientes/guardar` (guarda y redirige a `/pacientes`)
- **REST:** `POST /api/pacientes` (crear, 201), `GET /api/pacientes` (listar), `GET /api/pacientes/{id}` (200/404)

### 5.4 Demo en vivo

1. Ir a `/pacientes/nuevo`, registrar un paciente con nombres, apellidos y DNI
2. Guardar → mostrar que aparece en `/pacientes`
3. (Opcional) Intentar registrar el mismo DNI dos veces → mostrar el error por la restricción `unique`

---

## 6. Demo en Postman (probar la API REST)

"Cada uno de mis tres requerimientos también tiene su API REST. Lo pruebo directamente en Postman."

> Antes de la demo: la app corriendo (`./mvnw spring-boot:run`, por defecto `http://localhost:8080`).

### 6.1 RF-HC-03 primero — crear un paciente

`POST http://localhost:8080/api/pacientes`
```json
{
  "nombres": "Maria",
  "apellidos": "Torres Diaz",
  "dni": "45678912"
}
```
→ `201 Created`, anotar el `id` devuelto.

`GET http://localhost:8080/api/pacientes` → `200 OK`, arreglo con el paciente creado.
`GET http://localhost:8080/api/pacientes/{id}` → `200 OK` con sus datos básicos.

### 6.2 RF-HC-01 — generar historia clínica para ese paciente

`POST http://localhost:8080/api/historias`
```json
{ "pacienteId": 1 }
```
→ `201 Created`, mostrar en la respuesta el `numeroHistoria` generado automáticamente (formato `HC-000001-XXXX`).

**Probar la restricción 1-1:** repetir el mismo POST con el mismo `pacienteId` → debe fallar (no se puede crear una segunda historia para el mismo paciente, por el `unique = true` en `paciente_id`).

### 6.3 RF-HC-02 — consultar la historia clínica

`GET http://localhost:8080/api/historias` → `200 OK`, lista todas.
`GET http://localhost:8080/api/historias/{id}` → `200 OK`, la historia por su propio id.
`GET http://localhost:8080/api/historias/paciente/{pacienteId}` → `200 OK`, la historia asociada a ese paciente.
`GET http://localhost:8080/api/historias/999999` → `404 Not Found` (probar el caso de error).

### 6.4 Resumen de endpoints para Postman

| Recurso | Método | URL |
|---|---|---|
| Pacientes | POST | `/api/pacientes` |
| Pacientes | GET | `/api/pacientes` |
| Pacientes | GET | `/api/pacientes/{id}` |
| Historias | POST | `/api/historias` |
| Historias | GET | `/api/historias` |
| Historias | GET | `/api/historias/{id}` |
| Historias | GET | `/api/historias/paciente/{pacienteId}` |
| Historias | PUT | `/api/historias/{id}` |
| Historias | DELETE | `/api/historias/{id}` |

**Tip:** arma una colección de Postman "Historia Clínica - Lucas" con estas peticiones ya guardadas antes de la sustentación.

---

## 7. Preguntas frecuentes que puede hacer el profesor (y respuestas)

**¿Cómo garantizan que el número de historia clínica no se repita?**
Dos capas: el algoritmo combina el id del paciente (único) con el timestamp actual en milisegundos, y además la columna `numero_historia` tiene `unique = true` en la base de datos como respaldo final.

**¿Puede un paciente tener dos historias clínicas?**
No — `paciente_id` en `historia_clinica` tiene `unique = true` además de ser `@OneToOne`, así que la base de datos lo impide.

**¿Qué pasa si consultan una historia clínica que no existe?**
El servicio usa `Optional` (`findById`) y el REST responde `404 Not Found`; en la vista MVC se maneja para no romper la página.

**¿Por qué separan `PacienteController` de `PacienteRestController`?**
Uno sirve HTML con Thymeleaf para el navegador, el otro expone JSON para consumo externo (Postman, otro frontend), mismo patrón que usó Renzo en sus tres RF.

**¿Dónde se ve todo integrado (RF-HC-02 con el trabajo de Renzo)?**
En `/historias/{id}`: esa única vista junta los datos básicos del paciente (RF-HC-03), el número de historia (RF-HC-01), y las tablas de antecedentes/alergias que implementó Renzo — es el punto de encuentro de todo el módulo 5.

---

## 8. Notas para mí (no decir en la sustentación, son para entender el proyecto)

- El generador de `numeroHistoria` no tiene reintento en caso de colisión; funciona por baja probabilidad + constraint `unique` de respaldo. Si el profesor pide "mejorarlo en vivo", la respuesta honesta es que se podría envolver en un `while(existsByNumeroHistoria(...))` regenerando el número.
- `application.properties` usa `spring.jpa.hibernate.ddl-auto=create-drop`: los datos se pierden en cada reinicio de la app — hay que recordar volver a crear paciente + historia antes de cada demo, o cambiar a `update` antes de la entrega final.
- La relación `@ManyToMany` entre `HistoriaClinica` y `CondicionMedica` (tabla puente `historia_condicion`) no es parte de mis 3 RF, pero vive en el mismo archivo `HistoriaClinica.java` — si preguntan, aclarar que es un catálogo aparte, pensado como alternativa reutilizable, no directamente uno de mis requerimientos.
