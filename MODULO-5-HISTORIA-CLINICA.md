# Módulo 5: Historia Clínica

**Fuente:** `Evaluacion 01-1.docx` — Evaluación N° 01, Desarrollo de Aplicaciones Web
**Docente:** Coello Palomino, Ricardo · Semana 4
**Proyecto:** Desarrollo de un Sistema Web Integral para la Gestión Hospitalaria
**Repositorio:** `sistema-hospitalario-modulo5` (Spring Boot + MariaDB)
**Equipo:** 2 integrantes

---

## 1. Objetivo del módulo

El módulo permitirá crear, consultar y gestionar la historia clínica del paciente, registrando sus antecedentes, consultas, signos vitales, diagnósticos, tratamientos, procedimientos, recetas y evolución médica.

La relación principal es:

```
PACIENTE
   │
   ▼
HISTORIA CLÍNICA
   │
   ├── Antecedentes
   ├── Consultas
   ├── Signos vitales
   ├── Diagnósticos
   ├── Tratamientos
   ├── Medicamentos
   ├── Procedimientos
   ├── Exámenes
   └── Evolución
```

---

## 2. Reparto del trabajo (equipo de 2)

| Integrante | Requerimientos | Alcance |
|---|---|---|
| **Compañero** | RF-HC-01, RF-HC-02, RF-HC-03 | Creación de la historia clínica, número único, consulta de la historia y visualización de los datos básicos del paciente |
| **Yo (Renzo)** | RF-HC-05, RF-HC-06, RF-HC-07 | Antecedentes personales, antecedentes familiares y alergias |

### Lo que hará mi compañero

- **RF-HC-01:** El sistema deberá generar un número único de historia clínica para cada paciente.
- **RF-HC-02:** El sistema deberá permitir consultar la historia clínica de un paciente.
- **RF-HC-03:** El sistema deberá mostrar los datos básicos del paciente asociados a su historia clínica.

### Lo que haré yo

- **RF-HC-05:** El sistema deberá permitir registrar antecedentes personales.
- **RF-HC-06:** El sistema deberá permitir registrar antecedentes familiares.
- **RF-HC-07:** El sistema deberá permitir registrar alergias.

### Punto de acople entre los dos

Mi parte depende de la suya: los antecedentes y las alergias se registran **sobre una historia clínica que ya existe**. Por eso la entidad `HistoriaClinica` y su relación con `Paciente` la define él primero, y yo engancho mis entidades a esa historia clínica mediante su ID. Conviene acordar desde el inicio el nombre de la entidad, el nombre del campo identificador y el paquete donde vive, para no chocar al unir el código.

---

## 3. Creación de la historia clínica (contexto de RF-HC-01)

Al registrar un paciente, el sistema podrá generar automáticamente su historia clínica, con un **número único**.

Ejemplo de la cabecera que se muestra:

| Campo | Valor de ejemplo |
|---|---|
| N.º Historia | HC-000125 |
| Paciente | Juan Carlos Pérez López |
| DNI | 72456891 |
| Fecha de nacimiento | 15/04/1985 |
| Sexo | Masculino |
| Fecha de apertura | 06/09/2026 |
| Estado | ACTIVA |

---

## 4. Datos generales del paciente (contexto de RF-HC-03)

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

Los datos personales deberán provenir del **Módulo Pacientes**, evitando duplicarlos innecesariamente.

---

## 5. Antecedentes médicos — RF-HC-05 y RF-HC-06 (mi parte)

El sistema deberá permitir registrar los antecedentes del paciente.

### Antecedentes personales (RF-HC-05)

- Enfermedades previas
- Cirugías
- Hospitalizaciones
- Enfermedades crónicas
- Traumatismos
- Transfusiones
- Otros antecedentes relevantes

### Antecedentes familiares (RF-HC-06)

- Diabetes
- Hipertensión
- Enfermedades cardiovasculares
- Cáncer
- Enfermedades hereditarias
- Otros

> Ambos tipos pueden resolverse con **una sola entidad `Antecedente`** que tenga un campo de tipo (personal o familiar), o con dos entidades separadas. Lo primero es más simple y evita duplicar el CRUD.

### Campos sugeridos para la entidad Antecedente

| Campo | Descripción |
|---|---|
| id | Identificador único |
| historia clínica | Historia a la que pertenece (relación con la entidad del compañero) |
| tipo | Personal o Familiar |
| categoría | Enfermedad previa, cirugía, hospitalización, diabetes, hipertensión, etc. |
| descripción | Detalle del antecedente |
| parentesco | Solo para los familiares (padre, madre, hermano, abuelo) |
| fecha de registro | Cuándo se registró |
| observaciones | Información adicional |

---

## 6. Alergias — RF-HC-07 (mi parte)

Se deberá registrar:

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

Esta información debería ser visible para el personal médico autorizado durante la atención.

### Campos sugeridos para la entidad Alergia

| Campo | Descripción |
|---|---|
| id | Identificador único |
| historia clínica | Historia a la que pertenece |
| alergia | Nombre del agente (penicilina, polen, mariscos) |
| tipo | Medicamento, alimento, ambiental, otro |
| reacción | Qué le produce al paciente |
| observaciones | Información adicional |
| fecha de registro | Cuándo se registró |

---

## 7. Resto del módulo (no nos toca, pero es el contexto)

Estos puntos están en el documento y forman parte del Módulo 5 completo. No entran en nuestro reparto, pero conviene conocerlos porque explican por qué el modelo se separa en varias tablas.

| Punto | Contenido |
|---|---|
| 6. Hábitos | Alimentación, actividad física, tabaco, alcohol, otros hábitos relevantes |
| 7. Consultas médicas | Cada atención genera un registro: fecha, médico, especialidad, cita, motivo, anamnesis, examen físico, diagnóstico, tratamiento |
| 8. Signos vitales | Peso, talla, presión arterial, frecuencia cardíaca, frecuencia respiratoria, temperatura, saturación de oxígeno; el sistema puede calcular el IMC |
| 9. Evaluación médica | Motivo de consulta, anamnesis, examen físico, evaluación clínica, observaciones |
| 10. Diagnósticos | Uno o varios por consulta; se recomienda usar un catálogo basado en CIE-10 |
| 11. Tratamiento | Tratamiento indicado, indicaciones, duración, recomendaciones, fechas de inicio y fin, observaciones |
| 12. Recetas médicas | Recetas asociadas a una consulta, con medicamento, dosis, frecuencia y duración; las usará el Módulo Farmacia |
| 13. Solicitud de exámenes | Laboratorio, radiografías, ecografías, tomografías, resonancias, otros |
| 14. Resultados de exámenes | Quedan vinculados a la historia clínica; pueden vivir en su propio módulo y relacionarse por ID |
| 15. Evolución médica | Notas cronológicas del avance del paciente |
| 16. Procedimientos | Curaciones, suturas, inyecciones, procedimientos quirúrgicos; con fecha, médico responsable, observaciones y resultado |
| 17. Historial cronológico | Mostrar toda la historia ordenada por fecha |
| 18. Documentos clínicos | Adjuntos: resultados, informes, radiografías digitalizadas, certificados |
| 19. Control de acceso | Cada rol ve solo lo que le corresponde; se valida en frontend y en backend |
| 20. Auditoría | Registrar quién consultó, quién modificó, qué modificó, fecha y hora |
| 21. Cierre de consulta | Una consulta pasa de ABIERTA a CERRADA y ya no debería modificarse libremente |

### Signos vitales — valores de referencia del documento

| Signo | Ejemplo |
|---|---|
| Peso | 72 kg |
| Talla | 1.70 m |
| Presión arterial | 120/80 mmHg |
| Frecuencia cardíaca | 75 lpm |
| Frecuencia respiratoria | 18 rpm |
| Temperatura | 36.5 °C |
| Saturación de oxígeno | 98% |

### Control de acceso por rol

| Usuario | Acceso |
|---|---|
| Médico | Historia clínica de sus atenciones |
| Enfermería | Signos vitales y cuidados |
| Laboratorio | Solicitudes y resultados |
| Farmacia | Recetas |
| Recepción | Datos básicos, no información clínica completa |
| Administrador | Según política institucional |
| Paciente | Información autorizada mediante portal |

---

## 8. Requerimientos funcionales completos del módulo

Marcados los que nos tocan.

### Historia clínica

| Código | Requerimiento | Responsable |
|---|---|---|
| RF-HC-01 | Generar un número único de historia clínica para cada paciente | **Compañero** |
| RF-HC-02 | Permitir consultar la historia clínica de un paciente | **Compañero** |
| RF-HC-03 | Mostrar los datos básicos del paciente asociados a su historia clínica | **Compañero** |
| RF-HC-04 | Mantener el historial de las atenciones realizadas al paciente | — |

### Antecedentes

| Código | Requerimiento | Responsable |
|---|---|---|
| RF-HC-05 | Permitir registrar antecedentes personales | **Yo** |
| RF-HC-06 | Permitir registrar antecedentes familiares | **Yo** |
| RF-HC-07 | Permitir registrar alergias | **Yo** |

### Atención médica

| Código | Requerimiento |
|---|---|
| RF-HC-08 | Permitir registrar consultas médicas |
| RF-HC-09 | Permitir registrar el motivo de consulta |
| RF-HC-10 | Permitir registrar la anamnesis |
| RF-HC-11 | Permitir registrar el examen físico |
| RF-HC-12 | Permitir registrar signos vitales |
| RF-HC-13 | Permitir registrar diagnósticos |
| RF-HC-14 | Permitir registrar tratamientos |
| RF-HC-15 | Permitir registrar evoluciones médicas |

### Recetas

| Código | Requerimiento |
|---|---|
| RF-HC-16 | Permitir registrar recetas médicas |
| RF-HC-17 | Permitir asociar medicamentos a una receta |
| RF-HC-18 | Permitir consultar las recetas asociadas al paciente |

### Exámenes

| Código | Requerimiento |
|---|---|
| RF-HC-19 | Permitir solicitar exámenes médicos |
| RF-HC-20 | Permitir consultar los resultados de los exámenes asociados al paciente |

### Seguridad

| Código | Requerimiento |
|---|---|
| RF-HC-21 | Restringir el acceso a la historia clínica según el rol y permisos del usuario |
| RF-HC-22 | Registrar las consultas y modificaciones realizadas sobre la historia clínica |
| RF-HC-23 | Impedir la eliminación no autorizada de información clínica |
| RF-HC-24 | Mantener el historial de modificaciones realizadas sobre información clínica |

---

## 9. Estructura del menú del módulo

```
HISTORIA CLÍNICA
│
├── Buscar paciente
├── Historia clínica
│
├── Antecedentes
│   ├── Personales
│   ├── Familiares
│   └── Alergias
│
├── Consultas
│   ├── Nueva consulta
│   ├── Consultas anteriores
│   └── Evolución
│
├── Signos vitales
│
├── Diagnósticos
│
├── Tratamientos
│
├── Recetas
│
├── Exámenes
│   ├── Solicitudes
│   └── Resultados
│
├── Procedimientos
│
├── Documentos clínicos
│
└── Auditoría
```

La rama **Antecedentes** con sus tres hojas es exactamente mi parte. Las dos primeras entradas del menú son la parte de mi compañero.

---

## 10. Relación con los módulos anteriores

```
                    PACIENTE
                       │
                       ▼
                     CITA
                       │
                       ▼
                  MÉDICO
                       │
                       ▼
               HISTORIA CLÍNICA
                       │
       ┌───────────────┼────────────────┐
       ▼               ▼                ▼
  SIGNOS VITALES   DIAGNÓSTICOS      EVOLUCIÓN
                       │
             ┌─────────┴─────────┐
             ▼                   ▼
          RECETA              EXÁMENES
             │                   │
             ▼                   ▼
         FARMACIA            LABORATORIO
```

---

## 11. Diseño de la base de datos — advertencia del documento

El documento dice expresamente que **no conviene crear una única tabla gigante** llamada `historia_clinica` con todos los campos. Es mejor separar las entidades:

```
paciente
   │
   └── historia_clinica
          │
          ├── consulta_medica
          │      ├── signos_vitales
          │      ├── diagnostico
          │      ├── tratamiento
          │      ├── receta
          │      ├── solicitud_examen
          │      └── evolucion
          │
          ├── antecedente
          └── alergia
```

Así el modelo será más escalable para implementar después Laboratorio, Farmacia, Hospitalización y Emergencias.

Para nuestro alcance las tablas mínimas son: `paciente`, `historia_clinica`, `antecedente` y `alergia`. Las tres últimas tienen relación con la historia clínica: una historia clínica tiene muchos antecedentes y muchas alergias.

---

## 12. Lo que pide la evaluación (requisitos generales)

### Capacidad evaluada

Desarrollar una aplicación web con Spring Boot, aplicando correctamente los principios de **Inversión de Control (IoC)** e **Inyección de Dependencias (DI)**, implementando **APIs RESTful con operaciones CRUD**, gestionando la **persistencia con Hibernate (JPA)** y construyendo **interfaces web con Thymeleaf**, evidenciando el funcionamiento mediante **pruebas**.

### Arquitectura exigida

| Capa | Responsabilidad |
|---|---|
| Controller | Manejo de rutas: endpoints REST y vistas |
| Service | Lógica de negocio, usando inyección de dependencias |
| Repository | Acceso a datos con JPA |

### Tecnologías

Spring Boot · Spring Data JPA (Hibernate) · MariaDB / MySQL · Thymeleaf · Postman

### Pruebas

- Probar los endpoints con Postman
- Validar las operaciones CRUD
- Verificar las relaciones entre entidades
- Presentar capturas de pantalla del código y de las pruebas

### Rúbrica (sobre 20)

| Criterio | Excelente (20-18) | Bueno (17-14) | Regular (13-11) | Deficiente (10-0) |
|---|---|---|---|---|
| Arquitectura (IoC y DI) | Aplica correctamente IoC y DI en todas las capas; código bien estructurado y organizado | Aplica IoC y DI con pequeños errores; estructura clara | Uso parcial de IoC y DI; organización mejorable | No aplica IoC/DI o está mal implementado |
| Backend (APIs REST - CRUD) | Todos los endpoints funcionan correctamente; buen uso de REST | CRUD casi completo, pequeños errores en endpoints | CRUD incompleto o con fallas | No funciona o está mal implementado |
| Base de datos y relaciones | Modelo correcto con relaciones bien implementadas | Relaciones correctas con pequeños errores | Relaciones incompletas o mal definidas | No hay relaciones o están incorrectas |
| Frontend (Thymeleaf) | Interfaces funcionales, claras y bien integradas con el backend | Interfaces funcionales con detalles menores | Interfaces incompletas o poco funcionales | No implementa vistas o no funcionan |
| Pruebas (Postman y validación) | Evidencia completa de pruebas, endpoints verificados | Pruebas realizadas con pocos errores | Pruebas incompletas | No presenta pruebas |

Los cinco criterios pesan igual. Las pruebas de Postman valen lo mismo que todo el backend, así que hay que documentarlas sí o sí.

---

## 13. Plan de trabajo

### Acuerdos previos con el compañero

1. Definir juntos las entidades `Paciente` e `HistoriaClinica` antes de repartirse el código, porque las dos partes dependen de ellas.
2. Fijar los nombres de paquetes y de tablas para evitar conflictos al unir.
3. Trabajar en ramas separadas del repositorio y unir al final.

### Mis tareas (RF-HC-05, RF-HC-06, RF-HC-07)

1. Crear la entidad `Antecedente` con su relación hacia la historia clínica.
2. Crear la entidad `Alergia` con su relación hacia la historia clínica.
3. Crear los repositorios de ambas entidades.
4. Crear los servicios con la lógica de registro, listado, actualización y eliminación.
5. Crear los controladores REST para las dos entidades.
6. Crear las vistas Thymeleaf: formulario de antecedentes personales, formulario de antecedentes familiares, formulario de alergias y sus listados.
7. Validar que no se pueda registrar un antecedente o una alergia sin historia clínica asociada.
8. Probar todos los endpoints en Postman y tomar capturas.
9. Verificar en la base de datos que las llaves foráneas hacia la historia clínica se crearon.

### Tareas de mi compañero (RF-HC-01, RF-HC-02, RF-HC-03)

1. Crear la entidad `HistoriaClinica` con su relación hacia `Paciente`.
2. Generar el número único de historia clínica al registrar un paciente.
3. Crear el repositorio, el servicio y el controlador de la historia clínica.
4. Implementar la búsqueda de la historia clínica por paciente.
5. Crear la vista que muestra la cabecera con los datos básicos del paciente.
6. Probar los endpoints en Postman y tomar capturas.

### Entregables

- Código fuente en el repositorio `sistema-hospitalario-modulo5`
- Capturas de pantalla del código
- Capturas de pantalla de las pruebas en Postman
- Evidencia de la base de datos con las tablas y relaciones creadas

---

## 14. Estado actual del proyecto

El repositorio ya tiene el proyecto Spring Boot creado y la conexión a MariaDB configurada. La base de datos `historia_clinica_db` ya existe y la aplicación arranca correctamente en el puerto 8080. Todavía no hay entidades, repositorios, servicios ni controladores: eso es lo que toca construir.
