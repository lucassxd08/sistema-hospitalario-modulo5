# Guion de sustentación — RF-HC-05, RF-HC-06, RF-HC-07
**Autor:** Renzo León · **Módulo:** Historia Clínica (Módulo 5) · **Estado:** Terminado

Requisitos que voy a explicar:
- **RF-HC-05** — Registrar antecedentes personales
- **RF-HC-06** — Registrar antecedentes familiares
- **RF-HC-07** — Registrar alergias

## Temas principales que el profesor quiere ver

1. **Decir el requerimiento** (leer el RF tal cual está, con su código RF-HC-0X)
2. **Diagrama / relación de la base de datos** (sección 2.1)
3. **Postman** — probar los endpoints REST en vivo (sección 9)
4. **Que funcione** — demo real en el navegador guardando datos (secciones 3.4, 4.3, 5.4)

Orden recomendado de la exposición: (1) decir el requerimiento → (2) mostrar el diagrama de BD → (3) mostrar el código clave → (4) demo en navegador → (5) demo en Postman.

---

## 1. Introducción (30 seg)

"Buenas tardes profesor. Voy a explicar los tres requisitos funcionales que me correspondieron dentro del módulo de Historia Clínica: registrar antecedentes personales, antecedentes familiares y alergias del paciente. Los tres siguen exactamente el mismo patrón de arquitectura en capas (Entity → Repository → Service → Controller), así que voy a explicar el patrón una vez a fondo con Antecedentes Personales, y luego mostrar las diferencias puntuales en Familiares y Alergias."

---

## 2. Arquitectura común a los tres RF

Explica que el proyecto es un **Spring Boot** (Java) con **Thymeleaf** para las vistas y una **API REST** paralela. Cada uno de los tres requisitos tiene 7 archivos:

| Capa | Archivo | Función |
|---|---|---|
| Modelo (Entity) | `model/Antecedente.java`, `AntecedenteFamiliar.java`, `Alergia.java` | Define la tabla y sus columnas (JPA/Hibernate) |
| Repositorio | `repository/...Repository.java` | Interfaz que extiende `JpaRepository`, acceso a BD sin SQL manual |
| Servicio | `service/...Service.java` | Reglas de negocio y validaciones antes de guardar |
| Controlador MVC | `controller/...Controller.java` | Maneja las vistas HTML (formularios, listas) |
| Controlador REST | `controller/...RestController.java` | Expone endpoints `/api/...` en JSON |
| Vista formulario | `templates/...-form.html` | Formulario Thymeleaf para registrar |
| Vista listado | `templates/...s.html` | Tabla con los registros existentes |

"Cada antecedente, antecedente familiar o alergia **pertenece siempre a una Historia Clínica** — es una relación `@ManyToOne`: una historia clínica puede tener muchos antecedentes, pero cada antecedente pertenece a una sola historia clínica."

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
              +------------------+       +-------------------+   +------------------+
              | ANTECEDENTE      |        | ANTECEDENTE_       |   | ALERGIA          |
              +------------------+        | FAMILIAR            |   +------------------+
              | id (PK)          |        +---------------------+   | id (PK)          |
              | historia_        |        | id (PK)             |   | historia_        |
              |  clinica_id (FK) |        | historia_           |   |  clinica_id (FK) |
              | categoria        |        |  clinica_id (FK)    |   | nombre           |
              | descripcion      |        | enfermedad          |   | tipo             |
              | fecha_registro   |        | parentesco          |   | reaccion         |
              | observaciones    |        | fecha_registro      |   | fecha_registro   |
              +------------------+        | observaciones       |   | observaciones    |
                                            +---------------------+   +------------------+
```

**Explicación oral del diagrama:**
- `PACIENTE` 1—1 `HISTORIA_CLINICA`: cada paciente tiene exactamente una historia clínica (`@OneToOne`, `paciente_id` con `unique = true`).
- `HISTORIA_CLINICA` 1—N `ANTECEDENTE`, `ANTECEDENTE_FAMILIAR` y `ALERGIA`: una historia clínica puede tener muchos registros de cada tipo (mis tres RF), todos con FK obligatoria `historia_clinica_id`.
- `HISTORIA_CLINICA` M—N `CONDICION_MEDICA` (tabla puente `historia_condicion`): catálogo aparte de condiciones médicas reutilizables, **no es mi RF pero está relacionado** — si el profesor pregunta, se explica que es otra forma (muchos-a-muchos) de modelar antecedentes, usada por otro compañero del equipo.

**Tablas y columnas reales (nombres en la BD):**

| Tabla | Columnas clave |
|---|---|
| `paciente` | `id`, `nombres`, `apellidos`, `dni` (unique) |
| `historia_clinica` | `id`, `numero_historia` (unique), `paciente_id` (FK, unique → 1-1), `fecha_apertura`, `estado` |
| `antecedente` | `id`, `historia_clinica_id` (FK, not null), `categoria`, `descripcion`, `fecha_registro`, `observaciones` |
| `antecedente_familiar` | `id`, `historia_clinica_id` (FK, not null), `enfermedad`, `parentesco`, `fecha_registro`, `observaciones` |
| `alergia` | `id`, `historia_clinica_id` (FK, not null), `nombre`, `tipo`, `reaccion`, `fecha_registro`, `observaciones` |
| `condicion_medica` | `id`, `nombre` (unique) |
| `historia_condicion` (puente) | `historia_clinica_id`, `condicion_id` |

---

## 3. RF-HC-05 — Antecedentes personales

### 3.1 Qué guarda (entidad `Antecedente`, tabla `antecedente`)

- `id` — clave primaria autogenerada
- `historiaClinica` — relación `@ManyToOne` obligatoria (`nullable=false`) hacia `HistoriaClinica`
- `categoria` — texto de una lista fija: *Enfermedad previa, Cirugía, Hospitalización, Enfermedad crónica, Traumatismo, Transfusión, Otro*
- `descripcion` — texto libre
- `fechaRegistro` — fecha en formato texto (ej. `11/09/2026`)
- `observaciones` — texto libre opcional

### 3.2 Validación de negocio (lo más importante para explicar)

En `AntecedenteService.guardar()`:

```java
if (a.getHistoriaClinica() == null || a.getHistoriaClinica().getId() == null) {
    throw new RuntimeException("El antecedente debe estar asociado a una historia clinica");
}
HistoriaClinica historia = historiaClinicaRepository.findById(a.getHistoriaClinica().getId())
        .orElseThrow(() -> new RuntimeException("Historia clinica no existe"));
a.setHistoriaClinica(historia);
return repo.save(a);
```

**Explicación para el profe:** "No basta con que el formulario mande un ID de historia clínica: el servicio vuelve a consultar la base de datos para confirmar que esa historia clínica realmente existe antes de guardar. Si no existe, o si no se envió ningún ID, se lanza una excepción y no se guarda nada. Esto evita antecedentes 'huérfanos' sin paciente asociado."

### 3.3 Endpoints

- **Vistas (MVC):**
  - `GET /antecedentes` → lista todos
  - `GET /antecedentes/nuevo` → formulario de registro
  - `POST /antecedentes/guardar` → procesa el formulario
  - `GET /antecedentes/eliminar/{id}` → elimina
- **API REST:**
  - `GET/POST /api/antecedentes`
  - `GET/PUT/DELETE /api/antecedentes/{id}` (con manejo de 404 si no existe)

### 3.4 Demo en vivo (qué mostrar)

1. Ir al panel principal (`/panel`) → clic en "Antecedentes"
2. Mostrar el listado vacío o con datos
3. Clic en "Nuevo" → llenar formulario: elegir categoría del `<select>`, escribir descripción, fecha, observaciones, e **ID de la historia clínica** existente
4. Guardar → mostrar que aparece en la tabla, junto con el número de historia clínica del paciente (`a.historiaClinica?.numeroHistoria`, usando *safe navigation* de Thymeleaf para evitar error si viene null)
5. (Opcional) Probar guardar sin historia clínica válida → mostrar el error controlado

---

## 4. RF-HC-06 — Antecedentes familiares

### 4.1 Qué cambia respecto a Antecedentes personales

Misma estructura de 7 archivos (`AntecedenteFamiliar`, su repositorio, servicio, 2 controladores, 2 vistas). La diferencia está en los **campos de la entidad** (tabla `antecedente_familiar`):

- `enfermedad` — lista fija: *Diabetes, Hipertensión, Enfermedad cardiovascular, Cáncer, Enfermedad hereditaria, Otro*
- `parentesco` — lista fija: *Padre, Madre, Hermano, Hermana, Abuelo, Abuela, Otro*
- `fechaRegistro`, `observaciones` — igual que antes

La relación `@ManyToOne` a `HistoriaClinica` y la validación en el servicio son **idénticas** en lógica a Antecedentes personales (misma comprobación de existencia antes de guardar).

**Dato a mencionar si preguntan:** originalmente esta entidad guardaba solo un número suelto (`historiaClinicaId`) en vez de una relación real; se refactorizó a `@ManyToOne` para tener integridad referencial de verdad con JPA.

### 4.2 Endpoints

- `GET /antecedentes-familiares`, `GET /antecedentes-familiares/nuevo`, `POST /antecedentes-familiares/guardar`, `GET /antecedentes-familiares/eliminar/{id}`
- API: `/api/antecedentes-familiares` y `/api/antecedentes-familiares/{id}`

### 4.3 Demo

Igual que en 3.4 pero mostrando los dos `<select>` (enfermedad y parentesco).

---

## 5. RF-HC-07 — Alergias

### 5.1 Qué guarda (entidad `Alergia`, tabla `alergia`)

- `nombre` — el alérgeno (texto libre, ej. "Penicilina")
- `tipo` — lista fija: *Medicamento, Alimento, Ambiental, Otro*
- `reaccion` — texto libre (ej. "Erupción cutánea")
- `fechaRegistro`, `observaciones`
- `historiaClinica` — misma relación `@ManyToOne` obligatoria

### 5.2 Validación

Idéntica a las anteriores: `AlergiaService.guardar()` rechaza alergias sin historia clínica válida, verificando existencia contra la base antes de persistir.

### 5.3 Endpoints

- `GET /alergias`, `GET /alergias/nuevo`, `POST /alergias/guardar`, `GET /alergias/eliminar/{id}`
- API: `/api/alergias`, `/api/alergias/{id}`

### 5.4 Demo

Formulario con nombre del alérgeno, tipo, reacción y fecha.

---

## 6. Cómo se integra todo (para cerrar la explicación)

"Estos tres registros no viven aislados: en la vista de **ficha del paciente** (`HistoriaClinicaController`, ruta `/historias/{id}`), se muestran juntos — los antecedentes personales, familiares y alergias de esa historia clínica específica — usando consultas derivadas como `findByHistoriaClinicaId` en cada repositorio. Así el médico ve todo el historial del paciente en una sola pantalla."

También se puede mencionar el `PanelController`, que arma el menú de navegación (`/panel`) con enlaces a estas tres secciones.

---

## 9. Demo en Postman (probar la API REST)

"Además de las vistas web, cada requerimiento tiene su propia API REST. Voy a probarlo directamente en Postman."

> Antes de la demo: asegúrate de que la app esté corriendo (`./mvnw spring-boot:run`, por defecto en `http://localhost:8080`) y de tener a mano el `id` de una historia clínica ya creada (consulta `GET http://localhost:8080/api/... ` o revisa la tabla `historia_clinica`).

### 9.1 Antecedentes personales — RF-HC-05

**1) Listar** → `GET http://localhost:8080/api/antecedentes` → debe responder `200 OK` con un arreglo JSON.

**2) Crear** → `POST http://localhost:8080/api/antecedentes`
Body → raw → JSON:
```json
{
  "categoria": "Cirugia",
  "descripcion": "Apendicectomia",
  "fechaRegistro": "10/03/2020",
  "observaciones": "Sin complicaciones",
  "historiaClinica": { "id": 1 }
}
```
→ debe responder `201 Created` (o `200`) con el objeto guardado, incluyendo su nuevo `id`.

**3) Obtener uno** → `GET http://localhost:8080/api/antecedentes/{id}` (usar el id devuelto) → `200 OK`.

**4) Probar el error controlado** → repetir el POST sin el campo `historiaClinica` o con un `id` que no exista (ej. `999999`) → debe responder un error (no guarda nada), demostrando la validación del `AntecedenteService`.

**5) Eliminar** → `DELETE http://localhost:8080/api/antecedentes/{id}` → confirmar con un GET posterior que ya no existe (`404`).

### 9.2 Antecedentes familiares — RF-HC-06

Mismo flujo, cambiando la ruta a `/api/antecedentes-familiares` y el body:
```json
{
  "enfermedad": "Diabetes",
  "parentesco": "Padre",
  "fechaRegistro": "05/01/2019",
  "observaciones": "Diagnosticado a los 50 años",
  "historiaClinica": { "id": 1 }
}
```

### 9.3 Alergias — RF-HC-07

Ruta `/api/alergias`, body:
```json
{
  "nombre": "Penicilina",
  "tipo": "Medicamento",
  "reaccion": "Erupcion cutanea",
  "fechaRegistro": "20/02/2021",
  "observaciones": "Reaccion moderada",
  "historiaClinica": { "id": 1 }
}
```

### 9.4 Resumen de endpoints para tener a la mano en Postman

| Recurso | Método | URL |
|---|---|---|
| Antecedentes | GET | `/api/antecedentes` |
| Antecedentes | POST | `/api/antecedentes` |
| Antecedentes | GET/PUT/DELETE | `/api/antecedentes/{id}` |
| Ant. familiares | GET | `/api/antecedentes-familiares` |
| Ant. familiares | POST | `/api/antecedentes-familiares` |
| Ant. familiares | GET/PUT/DELETE | `/api/antecedentes-familiares/{id}` |
| Alergias | GET | `/api/alergias` |
| Alergias | POST | `/api/alergias` |
| Alergias | GET/PUT/DELETE | `/api/alergias/{id}` |

**Tip:** crea una colección de Postman llamada "Historia Clínica - Renzo" con estas 9 peticiones guardadas, así en la sustentación solo das clic en "Send" sin escribir nada en vivo (menos riesgo de error tipográfico frente al profesor).

---

## 7. Preguntas frecuentes que puede hacer el profesor (y respuestas)

**¿Por qué usan `@ManyToOne` y no simplemente guardar el ID como número?**
Porque JPA/Hibernate así mantiene la integridad referencial automáticamente, permite hacer `join` fácil con la historia clínica, y facilita las consultas derivadas (`findByHistoriaClinicaId`).

**¿Qué pasa si intento guardar un antecedente sin historia clínica?**
El servicio lanza una excepción antes de tocar la base de datos — está validado en la capa de negocio, no solo en el formulario.

**¿Por qué hay dos controladores por cada entidad (Controller y RestController)?**
Uno sirve las vistas HTML con Thymeleaf (uso desde navegador), el otro expone una API REST en JSON para integraciones externas o consumo por JavaScript/otro frontend.

**¿Usan DTOs?**
No — actualmente las entidades se bindean directamente en los formularios y en el REST (`@ModelAttribute` / `@RequestBody`). Es una simplificación válida para el alcance del proyecto, aunque en un sistema productivo se recomendaría separar DTOs de las entidades JPA.

**¿Dónde está definida la lista de categorías/tipos (por qué son fijas)?**
Están hardcodeadas como opciones `<option>` en los formularios Thymeleaf (`antecedente-form.html`, `antecedente-familiar-form.html`, `alergia-form.html`), siguiendo la propuesta original del documento de especificación `MODULO-5-HISTORIA-CLINICA.md`.

**¿`fechaRegistro` es un tipo Date real?**
No, actualmente es un `String` (texto), no un `LocalDate`. Es una limitación conocida — funciona para el alcance actual pero no valida formato de fecha a nivel de tipo.

---

## 8. Notas para mí (no decir en la sustentación, son para entender el proyecto)

- `application.properties` tiene `spring.jpa.hibernate.ddl-auto=create-drop`, lo que borra y recrea las tablas en cada arranque — bien para desarrollo/demo, pero antes de una entrega final debería cambiarse a `update` para no perder datos.
- Existe una entidad aparte `CondicionMedica` relacionada `@ManyToMany` con `HistoriaClinica`, pensada como catálogo reutilizable — el equipo aún no decidió si debe unificarse con `AntecedenteFamiliar`. Si el profesor pregunta por solapamiento de conceptos, esta es la respuesta honesta.
- Los tres servicios (`AntecedenteService`, `AntecedenteFamiliarService`, `AlergiaService`) comparten literalmente el mismo patrón de validación — buen ejemplo de consistencia de diseño en el proyecto.
