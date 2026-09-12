# Sistema Hospitalario — Módulo 5: Historia Clínica

Proyecto de la Evaluación N° 01 del curso Desarrollo de Aplicaciones Web (Semana 4).

**Integrantes:**
- Renzo León
- Lucas Inga

La especificación completa del módulo está en [MODULO-5-HISTORIA-CLINICA.md](MODULO-5-HISTORIA-CLINICA.md).

---

## Tecnologías

Spring Boot · Spring Data JPA (Hibernate) · MariaDB · Thymeleaf · Bootstrap · Postman

Arquitectura por capas: Entidad → Repository → Service → Controller.

---

## Reparto del trabajo

| Requerimiento | Descripción | Responsable | Estado |
|---|---|---|---|
| RF-HC-01 | Generar un número único de historia clínica | Lucas Inga | Pendiente |
| RF-HC-02 | Consultar la historia clínica de un paciente | Lucas Inga | Pendiente |
| RF-HC-03 | Mostrar los datos básicos del paciente | Lucas Inga | Pendiente |
| RF-HC-05 | Registrar antecedentes personales | Renzo León | **Terminado** |
| RF-HC-06 | Registrar antecedentes familiares | Renzo León | **Terminado** |
| RF-HC-07 | Registrar alergias | Renzo León | **Terminado** |

---

## Avance hasta el momento

### RF-HC-05 — Antecedentes personales

Entidad `Antecedente` con las cuatro capas completas y vistas Thymeleaf.

Campos: `id`, `historiaClinicaId`, `categoria`, `descripcion`, `fechaRegistro`, `observaciones`.

Las categorías que maneja el formulario salen del documento del módulo: enfermedad previa, cirugía, hospitalización, enfermedad crónica, traumatismo, transfusión y otro.

### RF-HC-06 — Antecedentes familiares

Entidad `AntecedenteFamiliar` con las cuatro capas completas y vistas Thymeleaf.

Campos: `id`, `historiaClinicaId`, `enfermedad`, `parentesco`, `fechaRegistro`, `observaciones`.

Las enfermedades del formulario son las del documento: diabetes, hipertensión, enfermedad cardiovascular, cáncer, enfermedad hereditaria y otro. El parentesco permite padre, madre, hermano, hermana, abuelo, abuela y otro.

### RF-HC-07 — Alergias

Entidad `Alergia` con las cuatro capas completas y vistas Thymeleaf.

Campos: `id`, `historiaClinicaId`, `alergia`, `tipo`, `reaccion`, `fechaRegistro`, `observaciones`.

Los tipos que maneja el formulario son medicamento, alimento, ambiental y otro. El ejemplo del documento del módulo es una alergia a la penicilina con erupción cutánea como reacción.

---

## Endpoints de la API REST

### Antecedentes personales

| Verbo | Ruta | Respuesta |
|---|---|---|
| GET | `/api/antecedentes` | Lista completa |
| POST | `/api/antecedentes` | 201 con el registro creado |
| GET | `/api/antecedentes/{id}` | 200 con el registro, o 404 |
| PUT | `/api/antecedentes/{id}` | 200 con el actualizado, o 404 |
| DELETE | `/api/antecedentes/{id}` | 204 sin contenido, o 404 |

### Antecedentes familiares

| Verbo | Ruta | Respuesta |
|---|---|---|
| GET | `/api/antecedentes-familiares` | Lista completa |
| POST | `/api/antecedentes-familiares` | 201 con el registro creado |
| GET | `/api/antecedentes-familiares/{id}` | 200 con el registro, o 404 |
| PUT | `/api/antecedentes-familiares/{id}` | 200 con el actualizado, o 404 |
| DELETE | `/api/antecedentes-familiares/{id}` | 204 sin contenido, o 404 |

### Alergias

| Verbo | Ruta | Respuesta |
|---|---|---|
| GET | `/api/alergias` | Lista completa |
| POST | `/api/alergias` | 201 con el registro creado |
| GET | `/api/alergias/{id}` | 200 con el registro, o 404 |
| PUT | `/api/alergias/{id}` | 200 con el actualizado, o 404 |
| DELETE | `/api/alergias/{id}` | 204 sin contenido, o 404 |

### Ejemplos para Postman

```
POST http://localhost:8080/api/antecedentes
{
  "historiaClinicaId": 125,
  "categoria": "Cirugia",
  "descripcion": "Apendicectomia",
  "fechaRegistro": "11/09/2026",
  "observaciones": "Sin complicaciones"
}

POST http://localhost:8080/api/antecedentes-familiares
{
  "historiaClinicaId": 125,
  "enfermedad": "Diabetes",
  "parentesco": "Padre",
  "fechaRegistro": "11/09/2026",
  "observaciones": "Diagnosticado a los 50 anios"
}

POST http://localhost:8080/api/alergias
{
  "historiaClinicaId": 125,
  "alergia": "Penicilina",
  "tipo": "Medicamento",
  "reaccion": "Erupcion cutanea",
  "fechaRegistro": "11/09/2026",
  "observaciones": "Reaccion reportada por el paciente"
}
```

---

## Vistas web

| Ruta | Qué muestra |
|---|---|
| `/antecedentes` | Tabla con los antecedentes personales |
| `/antecedentes/nuevo` | Formulario de registro de antecedente personal |
| `/antecedentes-familiares` | Tabla con los antecedentes familiares |
| `/antecedentes-familiares/nuevo` | Formulario de registro de antecedente familiar |
| `/alergias` | Tabla con las alergias |
| `/alergias/nuevo` | Formulario de registro de alergia |

---

## Base de datos

La base se llama `historia_clinica_db`. Hay que crearla una sola vez:

```sql
CREATE DATABASE historia_clinica_db;
```

Las tablas las genera Hibernate solo al arrancar, porque `application.properties` tiene `ddl-auto=update`. Hasta ahora se crean `antecedente`, `antecedente_familiar` y `alergia`.

La configuración de conexión está en `src/main/resources/application.properties` y usa el usuario `root` sin contraseña.

---

## Cómo ejecutar el proyecto

```
mvnw.cmd spring-boot:run
```

La aplicación queda en http://localhost:8080

---

## Pendiente

- Los tres requerimientos de Lucas Inga: entidad `Paciente`, entidad `HistoriaClinica` y el número único de historia clínica.
- Cuando exista la entidad `HistoriaClinica`, cambiar el campo `historiaClinicaId` de los antecedentes y las alergias por una relación real entre entidades, porque la rúbrica evalúa las relaciones de la base de datos.
- Vista de panel con el menú de navegación del módulo.
