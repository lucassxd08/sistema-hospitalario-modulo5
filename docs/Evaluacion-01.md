# EVALUACIÓN N° 01 — Desarrollo de Aplicaciones Web

EVALUACION N° 01

Desarrollo de aplicaciones Web: Sistema de Gestión Empresarial.

Coello Palomino, Ricardo

Desarrollo de aplicaciones Web

4 - C24 - Sección A - B

 DESARROLLO DE APLICACIONES WEB AVANZADO: IMPLEMENTACIÓN DE PERSISTENCIA
- Capacidades

 El estudiante desarrolla una aplicación web para la gestión de empresas utilizando Spring Boot, aplicando correctamente los principios de Inversión de Control (IoC) e Inyección de Dependencias (DI), implementando APIs RESTful con operaciones CRUD, gestionando la persistencia de datos con Hibernate (JPA) y construyendo interfaces web funcionales mediante Thymeleaf, evidenciando el funcionamiento del sistema a través de pruebas.
- Seguridad
- En este laboratorio está prohibida la manipulación del hardware, conexiones eléctricas o de red. Así como la ingesta de alimentos y bebidas.
- Ubicar maletines y/o mochilas en lugar destinado para tal fin.
- Dejar la mesa de trabajo y la silla utilizada limpias y ordenadas.
- Fundamento teórico
- Revise el material de la semana correspondiente antes del desarrollo del laboratorio.
- Normas empleadas
- No aplica
- Recursos
- En este laboratorio, cada estudiante trabajará con una computadora con Windows 10.
- La instalación del software requerido se realizará en el equipo virtual.
- Metodología para el desarrollo de la tarea
- El desarrollo del laboratorio es individual.
- Procedimiento

| Criterio | Excelente (20-18) | Bueno (17-14) | Regular (13-11) | Deficiente (10-0) |
| --- | --- | --- | --- | --- |
| Arquitectura (IoC y DI) | Aplica correctamente IoC y DI en todas las capas. Código bien estructurado y organizado. | Aplica IoC y DI con pequeños errores. Estructura clara. | Uso parcial de IoC/DI. Organización mejorable. | No aplica IoC/DI o está mal implementado. |
| Backend (APIs REST - CRUD) | Todos los endpoints funcionan correctamente (CRUD completo). Buen uso de REST. | CRUD casi completo, pequeños errores en endpoints. | CRUD incompleto o con fallas. | No funciona o está mal implementado. |
| Base de datos y relaciones | Modelo correcto con relaciones bien implementadas (OneToMany, etc.). | Relaciones correctas con pequeños errores. | Relaciones incompletas o mal definidas. | No hay relaciones o están incorrectas. |
| Frontend (Thymeleaf) | Interfaces funcionales, claras y bien integradas con backend. | Interfaces funcionales con detalles menores. | Interfaces incompletas o poco funcionales. | No implementa vistas o no funcionan. |
| Pruebas (Postman y validación) | Evidencia completa de pruebas, endpoints verificados. | Pruebas realizadas con pocos errores. | Pruebas incompletas. | No presenta pruebas. |

Desarrollo de un Sistema Web Integral para la Gestión Hospitalaria

## Módulo: Login / Usuarios y Roles

### 1. Inicio de sesión

El sistema deberá permitir que los usuarios registrados puedan acceder mediante:
- Usuario o correo electrónico.
- Contraseña.
- Botón Iniciar sesión.
- Validación de credenciales.
- Mensajes de error cuando las credenciales sean incorrectas.
- Bloqueo temporal después de varios intentos fallidos.
- Opción Cerrar sesión.
- Redirección automática al módulo correspondiente según el rol.

### 2. Recuperación de contraseña

El sistema deberá permitir:
- Solicitar recuperación de contraseña.
- Ingresar correo electrónico registrado.
- Enviar enlace o código de recuperación.
- Registrar una nueva contraseña.
- Validar que la nueva contraseña cumpla las políticas de seguridad.
- Invalidar el enlace/código después de un determinado tiempo.

### 3. Gestión de usuarios

El administrador podrá:
- Registrar usuarios.
- Modificar usuarios.
- Consultar usuarios.
- Activar/desactivar usuarios.
- Cambiar contraseña.
- Asignar roles.
- Asignar área o departamento.
- Asociar usuario con un empleado/profesional de salud.
- Buscar usuarios por nombre, documento, correo o rol.
- Filtrar usuarios por estado.

#### El registro de usuario podría contener:

| Campo | Descripción |
| --- | --- |
| ID | Identificador único |
| Nombres | Nombres del usuario |
| Apellidos | Apellidos |
| DNI | Documento de identidad |
| Correo | Correo institucional/personal |
| Teléfono | Número de contacto |
| Usuario | Nombre para iniciar sesión |
| Contraseña | Almacenada de forma segura |
| Rol | Rol asignado |
| Área | Departamento al que pertenece |
| Estado | Activo/Inactivo |
| Fecha de registro | Fecha de creación |
| Último acceso | Último inicio de sesión |

5. Gestión de roles

El sistema deberá permitir crear y administrar diferentes roles.

| Rol | Acceso principal |
| --- | --- |
| Administrador | Acceso total al sistema |
| Director | Gestión y consulta general |
| Médico | Historias clínicas, consultas, diagnósticos |
| Enfermería | Atención, signos vitales, cuidados |
| Recepcionista | Pacientes, citas, admisión |
| Farmacia | Medicamentos, recetas, despacho |
| Laboratorio | Solicitudes y resultados de análisis |
| Contabilidad | Pagos, facturación, reportes |
| Almacén | Inventario y movimientos |
| Usuario/Consulta | Acceso únicamente a información autorizada |

### 6. Permisos

Cada rol deberá tener permisos específicos.

Los permisos pueden dividirse en:
- Ver
- Crear
- Editar
- Eliminar
- Anular
- Exportar
- Imprimir
- Aprobar

Por ejemplo:

| Módulo | Médico | Enfermería | Recepción | Administrador |
| --- | --- | --- | --- | --- |
| Pacientes | Ver/Editar | Ver | Crear/Editar | Total |
| Citas | Ver/Crear | Ver | Crear/Editar | Total |
| Historia clínica | Total | Ver/Registrar | Ver limitado | Total |
| Farmacia | Ver | Ver | — | Total |
| Reportes | Ver | Ver | Ver | Total |
| Usuarios | — | — | — | Total |

### 7. Control de acceso

El sistema deberá:
- Mostrar únicamente los módulos autorizados para cada usuario.
- Impedir el acceso directo mediante URL a módulos no autorizados.
- Validar permisos en el backend, no solamente en el frontend.
- Controlar las operaciones permitidas según el rol.
- Mantener la sesión segura.
- Cerrar la sesión después de un período de inactividad.
- Permitir cerrar sesión manualmente.

#### Requerimientos funcionales resumidos

RF-LOGIN-01: El sistema deberá permitir el inicio de sesión mediante usuario/correo y contraseña.

RF-LOGIN-02: El sistema deberá validar las credenciales antes de permitir el acceso.

RF-LOGIN-03: El sistema deberá mostrar un mensaje cuando las credenciales sean incorrectas.

RF-LOGIN-04: El sistema deberá permitir recuperar la contraseña.

RF-LOGIN-05: El sistema deberá permitir cerrar sesión.

RF-USR-01: El administrador deberá registrar usuarios.

RF-USR-02: El administrador deberá modificar los datos de los usuarios.

RF-USR-03: El administrador deberá activar o desactivar usuarios.

RF-USR-04: El administrador deberá asignar uno o más roles a un usuario.

RF-USR-05: El sistema deberá permitir consultar y buscar usuarios.

RF-ROL-01: El administrador deberá registrar y modificar roles.

RF-ROL-02: El administrador deberá asignar permisos a cada rol.

RF-ROL-03: El sistema deberá controlar el acceso a los módulos según los permisos asignados.

RF-ROL-04: El sistema deberá impedir que un usuario acceda a funcionalidades no autorizadas.

RF-AUD-01: El sistema deberá registrar las operaciones críticas realizadas por los usuarios.

RF-AUD-02: El administrador deberá poder consultar la bitácora de auditoría.

## Módulo: Pacientes

1. Registro de pacientes

El sistema deberá permitir registrar un nuevo paciente con información como:

| Campo | Descripción |
| --- | --- |
| ID Paciente | Identificador único |
| Tipo documento | DNI, CE, Pasaporte, etc. |
| N.º documento | Documento de identidad |
| Nombres | Nombres del paciente |
| Apellido paterno | Apellido |
| Apellido materno | Apellido |
| Fecha nacimiento | Fecha de nacimiento |
| Edad | Calculada automáticamente |
| Sexo | Masculino/Femenino/Otro |
| Estado civil | Soltero, casado, viudo, etc. |
| Teléfono | Número de contacto |
| Correo electrónico | Email |
| Dirección | Domicilio |
| Distrito | Distrito de residencia |
| Provincia | Provincia |
| Departamento | Departamento |
| Ocupación | Actividad laboral |
| Tipo de sangre | A+, A-, B+, B-, O+, O-, etc. |
| Estado | Activo/Inactivo |

### 2. Identificación del paciente

El sistema deberá:
- Buscar al paciente por DNI/documento.
- Verificar que el documento no esté registrado previamente.
- Generar automáticamente un código de paciente.
- Evitar pacientes duplicados.
- Permitir consultar rápidamente los datos del paciente.
- Mostrar fotografía del paciente, si el hospital lo requiere.

### 3. Contacto de emergencia

El sistema deberá permitir registrar una o varias personas de contacto:
- Nombre completo.
- Parentesco.
- Teléfono.
- Dirección.
- Correo.
- Contacto principal.

### 4. Datos del seguro

El paciente puede tener diferentes tipos de cobertura.

El sistema deberá permitir registrar:
- Tipo de seguro.
- Empresa aseguradora.
- Número de póliza.
- Número de afiliación.
- Fecha de inicio.
- Fecha de vencimiento.
- Estado de cobertura.

### 5. Antecedentes del paciente

Dependiendo del alcance del sistema, se puede registrar información relevante como:

#### Antecedentes personales

- Enfermedades previas.
- Cirugías.
- Hospitalizaciones.
- Enfermedades crónicas.

#### Antecedentes familiares

- Diabetes.
- Hipertensión.
- Enfermedades cardiovasculares.
- Enfermedades hereditarias.

#### Alergias

- Medicamentos.
- Alimentos.
- Otras alergias.
- Reacción presentada.

### 6. Búsqueda de pacientes

El sistema deberá permitir buscar por:
- DNI.
- Código de paciente.
- Nombres.
- Apellidos.
- Teléfono.
- Historia clínica.

### 7. Edición de pacientes

El usuario autorizado podrá:
- Modificar datos personales.
- Actualizar dirección.
- Actualizar teléfono.
- Actualizar correo.
- Actualizar contactos de emergencia.
- Actualizar información del seguro.
- Modificar el estado del paciente.

### 8. Estado del paciente

El sistema puede manejar:
- Activo
- Inactivo
- Fallecido

En caso de fallecimiento, recomiendo no eliminar físicamente al paciente, sino cambiar su estado y conservar su información histórica.

#### Requerimientos funcionales

#### Registro

RF-PAC-01: El sistema deberá permitir registrar pacientes.

RF-PAC-02: El sistema deberá validar que el número de documento no esté registrado previamente.

RF-PAC-03: El sistema deberá generar automáticamente un código único para cada paciente.

RF-PAC-04: El sistema deberá permitir registrar información personal y de contacto del paciente.

#### Consulta

RF-PAC-05: El sistema deberá permitir buscar pacientes por documento, código, nombres y apellidos.

RF-PAC-06: El sistema deberá mostrar la información completa del paciente.

RF-PAC-07: El sistema deberá mostrar un resumen de las atenciones realizadas al paciente.

#### Actualización

RF-PAC-08: El sistema deberá permitir modificar los datos del paciente.

RF-PAC-09: El sistema deberá permitir actualizar la información del seguro.

RF-PAC-10: El sistema deberá permitir registrar y actualizar contactos de emergencia.

#### Seguridad

RF-PAC-11: El sistema deberá restringir el acceso a la información de pacientes según el rol del usuario.

RF-PAC-12: El sistema deberá registrar en una bitácora las modificaciones realizadas sobre los datos del paciente.

RF-PAC-13: El sistema no deberá permitir eliminar físicamente pacientes que tengan historial de atenciones.

#### Estructura del menú

PACIENTES

Registrar paciente

Listar pacientes

Buscar paciente

Editar paciente

Contactos de emergencia

Seguros

Antecedentes

Historial de atenciones

Estado del paciente

## Módulo 3: Citas Médicas

### 1. Registro de citas

El sistema deberá permitir registrar una cita con:

| Campo | Descripción |
| --- | --- |
| ID Cita | Identificador único |
| Código cita | Código generado automáticamente |
| Paciente | Paciente que será atendido |
| DNI | Documento del paciente |
| Especialidad | Especialidad médica |
| Médico | Profesional que atenderá |
| Consultorio | Consultorio asignado |
| Fecha | Fecha de atención |
| Hora | Hora de atención |
| Tipo de atención | Presencial/Teleconsulta, si aplica |
| Motivo | Motivo de la consulta |
| Observaciones | Información adicional |
| Estado | Programada, atendida, cancelada, etc. |

Ejemplo:

CITA: CIT-000125

```
Paciente:       Juan Pérez López
Especialidad:   Medicina General
Médico:         Dr. Carlos Ramírez
Consultorio:    C-205
Fecha:          08/09/2026
Hora:           10:30 AM
Estado:         PROGRAMADA
```

### 2. Programación de citas

El sistema deberá permitir:
- Seleccionar al paciente.
- Seleccionar especialidad.
- Seleccionar médico.
- Consultar disponibilidad.
- Seleccionar fecha.
- Seleccionar horario disponible.
- Asignar consultorio.
- Registrar la cita.

El sistema no deberá permitir reservar un horario que ya esté ocupado.

### 3. Agenda médica

Cada médico deberá contar con una agenda donde pueda visualizar sus citas.

Ejemplo:

AGENDA MÉDICA

Dr. Carlos Ramírez

Medicina General

Martes 08/09/2026

```
08:00  Juan Pérez       PROGRAMADA
08:30  María López    CONFIRMADA
09:00  Pedro García   ATENDIDA
09:30  Ana Torres      CANCELADA
10:00  Luis Díaz          PROGRAMADA
```

También debería poder visualizarse por:
- Día.
- Semana.
- Mes.

### 4. Horarios médicos

El administrador deberá poder configurar la disponibilidad de cada médico.

Ejemplo:

MÉDICO: Dr. Carlos Ramírez

ESPECIALIDAD: Medicina General

Lunes:

08:00 - 13:00

Miércoles:

14:00 - 18:00

Viernes:

08:00 - 13:00

El sistema generará los horarios disponibles de acuerdo con esta configuración.

### 5. Estados de la cita

Recomiendo utilizar los siguientes estados:

PROGRAMADA

     ↓

CONFIRMADA

     ↓

EN ESPERA

     ↓

EN ATENCIÓN

     ↓

ATENDIDA

También:

```
PROGRAMADA → CANCELADA
PROGRAMADA → NO ASISTIÓ
CONFIRMADA → NO ASISTIÓ
```

Esto permitirá posteriormente obtener estadísticas de asistencia.

### 6. Confirmación de citas

El sistema podrá permitir registrar la confirmación del paciente.

Por ejemplo:

Cita: CIT-000125

Paciente: Juan Pérez López

Fecha: 08/09/2026

Hora: 10:30 AM

Estado: PROGRAMADA

[ Confirmar ] [ Cancelar ] [ Reprogramar ]

En una segunda etapa se podría integrar el envío de recordatorios mediante correo, SMS o WhatsApp.

### 7. Reprogramación

El sistema deberá permitir cambiar:
- Fecha.
- Hora.
- Médico, si corresponde.
- Consultorio, si corresponde.

Debe conservarse el historial de la modificación.

Ejemplo:

Cita original:

08/09/2026 - 10:30 AM

Nueva cita:

10/09/2026 - 03:00 PM

Motivo:

Solicitud del paciente

Modificado por:

Recepcionista01

### 8. Cancelación

El sistema deberá permitir cancelar una cita.

Se recomienda solicitar:
- Motivo de cancelación.
- Usuario que realiza la cancelación.
- Fecha y hora de cancelación.

No recomiendo eliminar físicamente una cita.

Debe quedar:

CIT-000125

Estado: CANCELADA

Motivo: Paciente solicitó cancelación

### 9. Control de disponibilidad

Antes de registrar una cita, el sistema deberá verificar:
- Médico disponible.
- Horario disponible.
- Consultorio disponible.
- Fecha válida.
- Que el médico no tenga otra cita en el mismo horario.
- Que el consultorio no esté ocupado.

Por ejemplo:

08/09/2026

```
09:00  ❌ Ocupado
09:30  ❌ Ocupado
10:00  ✅ Disponible
10:30  ✅ Disponible
11:00  ❌ Ocupado
```

### 10. Búsqueda de citas

El sistema deberá permitir buscar citas por:
- Código de cita.
- DNI del paciente.
- Nombre del paciente.
- Médico.
- Especialidad.
- Fecha.
- Estado.

Ejemplo:

Buscar: [ Juan Pérez____________ ]

Fecha: [08/09/2026]

```
Especialidad: [Todas ▼]
Estado: [Todas ▼]
Código      Paciente          Médico          Hora       Estado
CIT-001     Juan Pérez        Carlos Ramírez   10:00     CONFIRMADA
CIT-002     Juan Pérez        Ana Torres       15:00     PROGRAMADA
```

### 12. Recepción / Check-in

Cuando el paciente llegue al hospital, recepción podrá registrar su llegada.

Flujo:

CITA PROGRAMADA

       ↓

PACIENTE LLEGA

       ↓

CHECK-IN

       ↓

EN ESPERA

       ↓

LLAMADO POR MÉDICO

       ↓

EN ATENCIÓN

Esto permitirá conocer qué pacientes están esperando.

### 12. Llamado de pacientes

Opcionalmente, el sistema puede incluir una pantalla para mostrar:

LLAMADO DE PACIENTES

CONSULTORIO 205

JUAN PÉREZ LÓPEZ

Pase al consultorio

### 13. Historial de citas del paciente

Desde el módulo Pacientes se podrá consultar:

PACIENTE: Juan Pérez López

Historial de citas

```
Fecha       Especialidad       Médico          Estado
05/08/26    Medicina General   Carlos Ramírez  Atendida
20/08/26    Cardiología        Ana Torres      Atendida
08/09/26    Medicina General   Carlos Ramírez  Programada
```

### 14. Reportes

El módulo podrá generar reportes como:
- Citas del día.
- Citas de la semana.
- Citas del mes.
- Citas por médico.
- Citas por especialidad.
- Citas atendidas.
- Citas canceladas.
- Pacientes que no asistieron.
- Porcentaje de asistencia.
- Horarios con mayor demanda.

Ejemplo:

REPORTE DE CITAS

```
Total citas:       250
Atendidas:         190
Canceladas:         25
No asistieron:      20
Programadas:        15
```

Requerimientos funcionales

#### Registro

RF-CIT-01: El sistema deberá permitir registrar citas médicas.

RF-CIT-02: El sistema deberá generar automáticamente un código único para cada cita.

RF-CIT-03: El sistema deberá permitir seleccionar paciente, especialidad, médico, consultorio, fecha y hora.

RF-CIT-04: El sistema deberá verificar la disponibilidad del médico antes de registrar una cita.

RF-CIT-05: El sistema deberá impedir registrar dos citas para un mismo médico en el mismo horario.

#### Agenda

RF-CIT-06: El sistema deberá permitir configurar los horarios de atención de los médicos.

RF-CIT-07: El sistema deberá mostrar la agenda de cada médico.

RF-CIT-08: El sistema deberá permitir consultar la agenda por día, semana y mes.

#### Gestión

RF-CIT-09: El sistema deberá permitir modificar una cita.

RF-CIT-10: El sistema deberá permitir reprogramar una cita.

RF-CIT-11: El sistema deberá permitir cancelar una cita.

RF-CIT-12: El sistema deberá registrar el motivo de cancelación o reprogramación.

RF-CIT-13: El sistema deberá permitir cambiar el estado de la cita.

#### Atención

RF-CIT-14: El sistema deberá permitir registrar la llegada del paciente.

RF-CIT-15: El sistema deberá cambiar el estado de la cita a "En espera" cuando el paciente realice el check-in.

RF-CIT-16: El sistema deberá permitir registrar que el paciente no asistió.

#### Consultas

RF-CIT-17: El sistema deberá permitir buscar citas por paciente, médico, especialidad, fecha y estado.

RF-CIT-18: El sistema deberá permitir consultar el historial de citas de un paciente.

#### Reportes

RF-CIT-19: El sistema deberá generar reportes de citas por período.

RF-CIT-20: El sistema deberá generar reportes de citas por médico y especialidad.

RF-CIT-21: El sistema deberá generar estadísticas de citas atendidas, canceladas y no asistidas.

#### Estructura del menú

CITAS MÉDICAS

Nueva cita

Agenda médica

Calendario

Citas del día

Citas pendientes

Confirmaciones

Reprogramaciones

Cancelaciones

Check-in / Recepción

Historial de citas

Reportes

## Módulo 4: Médicos y Especialidades

### 1. Objetivo

El módulo permitirá administrar la información de los médicos y profesionales de salud, así como las especialidades médicas, horarios de atención y consultorios asignados.

La relación principal será:

ESPECIALIDAD

```
      │
      ▼
    MÉDICO
      │
      ├── Horarios
      ├── Consultorios
      └── Citas
```

### 2. Gestión de médicos

El sistema deberá permitir registrar médicos con información como:

| Campo | Descripción |
| --- | --- |
| ID Médico | Identificador único |
| Código médico | Código interno |
| Tipo documento | DNI, CE, etc. |
| N.º documento | Documento |
| Nombres | Nombres del médico |
| Apellido paterno | Apellido |
| Apellido materno | Apellido |
| CMP | Colegio Médico del Perú |
| RNE | Registro de especialista, si corresponde |
| Teléfono | Número de contacto |
| Correo | Correo profesional |
| Fecha ingreso | Fecha de incorporación |
| Especialidad | Especialidad médica |
| Subespecialidad | Si corresponde |
| Estado | Activo/Inactivo |

Ejemplo:

MÉDICO

--------------------------------

Código: MED-00025

CMP: 45872

Médico: Carlos Ramírez López

Especialidad: Cardiología

Subespecialidad: Cardiología intervencionista

Estado: ACTIVO

### 3. Especialidades médicas

El administrador podrá registrar las diferentes especialidades.

Ejemplos:
- Medicina General
- Medicina Interna
- Pediatría
- Cardiología
- Neurología
- Dermatología
- Ginecología
- Obstetricia
- Traumatología
- Oftalmología
- Otorrinolaringología
- Urología
- Gastroenterología
- Endocrinología
- Oncología
- Psiquiatría
- Cirugía General
- Anestesiología
- Radiología

Cada especialidad podría tener:

| Campo | Descripción |
| --- | --- |
| ID | Identificador |
| Código | Código de especialidad |
| Nombre | Nombre |
| Descripción | Descripción |
| Duración de consulta | Ej. 30 minutos |
| Estado | Activa/Inactiva |

### 4. Relación médico-especialidad

Un médico puede tener una o varias especialidades.

Por ejemplo:

Dr. Carlos Ramírez

Especialidades:

Medicina Interna

Cardiología

Por ello, para una base de datos flexible, recomiendo:

MEDICO

```
   │
   │ 1:N
   ▼
```

MEDICO_ESPECIALIDAD

```
   │
   │ N:1
   ▼
```

ESPECIALIDAD

Esto es mejor que colocar simplemente especialidad_id dentro de la tabla médico, especialmente si el hospital puede tener médicos con múltiples especialidades.

### 5. Horarios de atención

El sistema deberá permitir configurar los horarios de cada médico.

Ejemplo:

Dr. Carlos Ramírez

Cardiología

Lunes

08:00 - 13:00

Miércoles

08:00 - 13:00

Viernes

14:00 - 18:00

El horario deberá permitir configurar:
- Día de la semana.
- Hora de inicio.
- Hora de finalización.
- Duración de la cita.
- Estado.
- Consultorio.

### 6. Duración de las citas

La duración puede depender de la especialidad.

Por ejemplo:

```
Medicina General     → 20 minutos
Pediatría              → 30 minutos
Cardiología          → 30 minutos
Psicología             → 45 minutos
Nutrición             → 30 minutos
```

Esto permitirá generar automáticamente los horarios disponibles.

Por ejemplo, si un médico trabaja de 08:00 a 10:00 y las consultas duran 30 minutos:

```
08:00 - 08:30  ✅
08:30 - 09:00  ✅
09:00 - 09:30  ✅
09:30 - 10:00  ✅
```

### 7. Consultorios

El sistema deberá permitir administrar los consultorios.

Datos:

| Campo | Descripción |
| --- | --- |
| ID | Identificador |
| Código | C-101 |
| Nombre | Consultorio 101 |
| Piso | Piso 1 |
| Área | Consultorios externos |
| Especialidad | Especialidad asignada, si aplica |
| Estado | Disponible/Ocupado/Inactivo |

Ejemplo:

CONSULTORIO

Código: C-205

Nombre: Consultorio 205

Piso: 2

Área: Consultorios externos

Estado: ACTIVO

### 8. Asignación de consultorios

El sistema deberá permitir asignar consultorios a los médicos según sus horarios.

Ejemplo:

Dr. Carlos Ramírez

Cardiología

Lunes:

08:00 - 13:00

Consultorio C-205

Miércoles:

08:00 - 13:00

Consultorio C-205

Viernes:

14:00 - 18:00

Consultorio C-301

El sistema deberá evitar que dos médicos tengan asignado el mismo consultorio en el mismo horario.

### 9. Disponibilidad del médico

El sistema deberá determinar automáticamente si el médico está disponible.

Se deberán considerar:
- Horario laboral.
- Citas existentes.
- Vacaciones.
- Permisos.
- Días no laborables.
- Bloqueos de agenda.
- Consultorio disponible.

Ejemplo:

Dr. Carlos Ramírez

08/09/2026

```
08:00  ❌ Ocupado
08:30  ❌ Ocupado
09:00  ✅ Disponible
09:30  ✅ Disponible
10:00  ❌ Ocupado
10:30  ✅ Disponible
```

### 10. Bloqueo de horarios

El médico o administrador podrá bloquear determinados horarios.

Ejemplo:

Fecha: 15/09/2026

Hora: 10:00 - 12:00

Motivo:

Reunión médica

Estado:

BLOQUEADO

Durante ese período no se podrán registrar nuevas citas.

### 11. Vacaciones y permisos

El sistema deberá permitir registrar períodos donde el médico no estará disponible.

Ejemplo:

Médico: Carlos Ramírez

Desde: 20/09/2026

Hasta: 30/09/2026

Motivo:

Vacaciones

Estado:

NO DISPONIBLE

El módulo de citas deberá utilizar esta información para impedir nuevas reservas.

### 12. Estado del médico

El sistema podrá manejar:
- Activo
- Inactivo
- Vacaciones
- Permiso
- Suspendido

No se recomienda eliminar médicos que ya tengan citas o historias clínicas relacionadas.

### 13. Perfil profesional

Se puede incluir información adicional:
- Fotografía profesional.
- Universidad.
- CMP.
- RNE.
- Especialidades.
- Subespecialidades.
- Años de experiencia.
- Servicios que realiza.
- Horarios.
- Consultorios.

Esto puede ser útil posteriormente para una agenda pública o portal de pacientes.

### 14. Búsqueda de médicos

El sistema deberá permitir buscar por:
- Código.
- DNI.
- CMP.
- Nombres.
- Apellidos.
- Especialidad.
- Estado.

Ejemplo:

Buscar médico: [___________________]

```
Especialidad: [Cardiología ▼]
Estado:       [Activo ▼]
Código       Médico              Especialidad        Estado
MED-001     Carlos Ramírez      Cardiología         Activo
MED-002     Ana Torres        Cardiología         Activo
MED-003     Luis Pérez          Medicina Interna    Activo
```

### 15. Reportes

El módulo deberá permitir generar:
- Médicos registrados.
- Médicos por especialidad.
- Médicos activos/inactivos.
- Horarios por médico.
- Consultorios asignados.
- Disponibilidad de médicos.
- Médicos con mayor número de citas.
- Especialidades con mayor demanda.

Ejemplo:

DEMANDA POR ESPECIALIDAD

```
Cardiología           185 citas
Medicina General     320 citas
Pediatría             245 citas
Ginecología          210 citas
Traumatología         175 citas
```

### 16. Requerimientos funcionales

#### Médicos

RF-MED-01: El sistema deberá permitir registrar médicos.

RF-MED-02: El sistema deberá permitir modificar los datos de los médicos.

RF-MED-03: El sistema deberá permitir consultar médicos.

RF-MED-04: El sistema deberá permitir activar o desactivar médicos.

RF-MED-05: El sistema deberá validar que el CMP no se encuentre duplicado.

RF-MED-06: El sistema deberá permitir asociar uno o más especialidades a un médico.

#### Especialidades

RF-MED-07: El sistema deberá permitir registrar especialidades médicas.

RF-MED-08: El sistema deberá permitir modificar especialidades.

RF-MED-09: El sistema deberá permitir activar o desactivar especialidades.

RF-MED-10: El sistema deberá permitir configurar la duración de la consulta por especialidad.

#### Horarios

RF-MED-11: El sistema deberá permitir registrar los horarios de atención de cada médico.

RF-MED-12: El sistema deberá permitir modificar los horarios de atención.

RF-MED-13: El sistema deberá permitir bloquear determinados horarios.

RF-MED-14: El sistema deberá considerar vacaciones y permisos en la disponibilidad del médico.

#### Consultorios

RF-MED-15: El sistema deberá permitir registrar consultorios.

RF-MED-16: El sistema deberá permitir asignar consultorios a los médicos.

RF-MED-17: El sistema deberá impedir la asignación simultánea de un consultorio a dos médicos.

#### Disponibilidad

RF-MED-18: El sistema deberá determinar automáticamente la disponibilidad de los médicos.

RF-MED-19: El sistema deberá considerar las citas existentes para determinar la disponibilidad.

RF-MED-20: El sistema deberá proporcionar al módulo Citas Médicas los horarios disponibles.

#### Reportes

RF-MED-21: El sistema deberá generar reportes de médicos por especialidad.

RF-MED-22: El sistema deberá generar reportes de horarios y disponibilidad.

RF-MED-23: El sistema deberá generar estadísticas de demanda por especialidad.

### 17. Estructura del menú

MÉDICOS Y ESPECIALIDADES

```
│
├── Médicos
│   ├── Registrar médico
│   ├── Listar médicos
│   ├── Editar médico
│   └── Estado
│
├── Especialidades
│   ├── Registrar especialidad
│   ├── Listar especialidades
│   └── Editar especialidad
│
├── Horarios
│   ├── Configurar horarios
│   ├── Bloquear horario
│   └── Disponibilidad
│
├── Consultorios
│   ├── Registrar
│   ├── Listar
│   └── Asignaciones
│
├── Vacaciones y permisos
│
└── Reportes
```

### 18. Relación con los módulos anteriores

Hasta este punto, la arquitectura funcional quedaría:

```
┌───────────────────────────────┐
│  1. LOGIN / USUARIOS / ROLES  │
└───────────────┬───────────────┘
                │
                ▼
┌───────────────────────────────┐
│       2. PACIENTES            │
└───────────────┬───────────────┘
                │
                ▼
┌───────────────────────────────┐
│       3. CITAS MÉDICAS        │
└───────────────┬───────────────┘
                │
                ▼
┌───────────────────────────────┐
│ 4. MÉDICOS Y ESPECIALIDADES   │
│                               │
│ Médicos                       │
│ Especialidades                │
│ Horarios                      │
│ Consultorios                  │
│ Disponibilidad                │
└───────────────┬───────────────┘
                │
                ▼
┌───────────────────────────────┐
│       5. HISTORIA CLÍNICA     │
└───────────────────────────────┘
```

## Módulo 5: Historia Clínica

### 1. Objetivo

El módulo permitirá crear, consultar y gestionar la historia clínica del paciente, registrando sus antecedentes, consultas, signos vitales, diagnósticos, tratamientos, procedimientos, recetas y evolución médica.

La relación principal será:

PACIENTE

```
   │
   ▼
```

HISTORIA CLÍNICA

```
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

### 2. Creación de historia clínica

Al registrar un paciente, el sistema podrá generar automáticamente su historia clínica.

Ejemplo:

HISTORIA CLÍNICA

N.º Historia: HC-000125

Paciente:

Juan Carlos Pérez López

DNI:

72456891

Fecha nacimiento:

15/04/1985

Sexo:

Masculino

Fecha de apertura:

06/09/2026

Estado:

ACTIVA

La historia clínica deberá tener un número único.

### 3. Datos generales del paciente

Al ingresar a la historia clínica, el sistema deberá mostrar:
- Código de paciente.
- Número de historia clínica.
- DNI.
- Nombres y apellidos.
- Fecha de nacimiento.
- Edad.
- Sexo.
- Teléfono.
- Dirección.
- Tipo de seguro.
- Contacto de emergencia.

Los datos personales deberán provenir del Módulo Pacientes, evitando duplicarlos innecesariamente.

### 4. Antecedentes médicos

El sistema deberá permitir registrar los antecedentes del paciente.

#### Antecedentes personales

- Enfermedades previas.
- Cirugías.
- Hospitalizaciones.
- Enfermedades crónicas.
- Traumatismos.
- Transfusiones.
- Otros antecedentes relevantes.

#### Antecedentes familiares

- Diabetes.
- Hipertensión.
- Enfermedades cardiovasculares.
- Cáncer.
- Enfermedades hereditarias.
- Otros.

### 5. Alergias

Se deberá registrar:
- Alergia.
- Tipo.
- Reacción.
- Observaciones.
- Fecha de registro.

Ejemplo:

ALERGIAS

Medicamento: Penicilina

Reacción: Erupción cutánea

Observación: Reacción alérgica reportada por paciente

Esta información debería ser visible para el personal médico autorizado durante la atención.

### 6. Hábitos y antecedentes relevantes

Dependiendo del alcance del hospital, se podrá registrar:
- Alimentación.
- Actividad física.
- Consumo de tabaco.
- Consumo de alcohol.
- Otros hábitos relevantes.

Estos datos pueden formar parte de la evaluación clínica.

### 7. Consultas médicas

Cada atención médica deberá generar un registro dentro de la historia clínica.

Ejemplo:

CONSULTA MÉDICA

Fecha: 06/09/2026

Médico: Dr. Carlos Ramírez

Especialidad: Medicina General

Cita: CIT-000125

Motivo de consulta:

Dolor abdominal

Anamnesis:

Paciente refiere dolor abdominal desde hace 2 días.

Examen físico:

...

Diagnóstico:

...

Tratamiento:

...

### 8. Signos vitales

El personal autorizado podrá registrar:

| Signo | Ejemplo |
| --- | --- |
| Peso | 72 kg |
| Talla | 1.70 m |
| Presión arterial | 120/80 mmHg |
| Frecuencia cardíaca | 75 lpm |
| Frecuencia respiratoria | 18 rpm |
| Temperatura | 36.5 °C |
| Saturación O₂ | 98% |

El sistema puede calcular automáticamente:

IMC = Peso / Talla²

y mostrar su interpretación según los parámetros clínicos configurados.

### 9. Evaluación médica

El médico podrá registrar:

#### Motivo de consulta

Razón principal por la cual el paciente solicita atención.

#### Anamnesis

Descripción de los síntomas y evolución del problema.

#### Examen físico

Resultados encontrados durante la evaluación.

#### Evaluación clínica

Valoración realizada por el médico.

#### Observaciones

Información adicional.

### 10. Diagnósticos

El sistema deberá permitir registrar uno o varios diagnósticos.

Ejemplo:

DIAGNÓSTICOS

Principal:

J06.9 - Infección respiratoria aguda

Secundario:

R50.9 - Fiebre, no especificada

Es recomendable utilizar un catálogo basado en CIE-10 para estandarizar los diagnósticos.

### 11. Tratamiento

El médico podrá registrar:
- Tratamiento indicado.
- Indicaciones.
- Duración.
- Recomendaciones.
- Fecha de inicio.
- Fecha de finalización.
- Observaciones.

Ejemplo:

TRATAMIENTO

Reposo: 3 días

Hidratación abundante

Control médico: 7 días

### 12. Recetas médicas

La historia clínica deberá permitir generar recetas asociadas a una consulta.

Ejemplo:

RECETA MÉDICA

```
Medicamento        Dosis         Frecuencia        Duración
Paracetamol        500 mg       Cada 8 horas      5 días
Medicamento B      10 mg         Cada 12 horas     7 días
```

La receta podrá posteriormente ser utilizada por el Módulo Farmacia.

### 13. Solicitud de exámenes

Desde la consulta médica se podrá solicitar:
- Análisis de laboratorio.
- Radiografías.
- Ecografías.
- Tomografías.
- Resonancias.
- Otros procedimientos.

Flujo:

Consulta médica

      ↓

Solicitud de examen

      ↓

Laboratorio / Imágenes

      ↓

Resultado

      ↓

Historia clínica

### 14. Resultados de exámenes

Los resultados deberán quedar vinculados a la historia clínica.

Ejemplo:

EXAMEN

Tipo: Hemograma

Fecha: 06/09/2026

Solicitado por: Dr. Carlos Ramírez

Estado: RESULTADO DISPONIBLE

[Ver resultado]

No necesariamente se deben almacenar todos los detalles directamente en Historia Clínica; pueden pertenecer al módulo correspondiente y relacionarse mediante su ID.

### 15. Evolución médica

El médico deberá poder registrar la evolución del paciente.

Ejemplo:

EVOLUCIÓN

Fecha: 08/09/2026

Paciente presenta mejoría de los síntomas.

Temperatura dentro de valores normales.

Plan:

Continuar tratamiento.

Médico:

Dr. Carlos Ramírez

Esto permitirá construir una línea cronológica de la evolución del paciente.

### 16. Procedimientos médicos

El sistema deberá permitir registrar procedimientos realizados:
- Curaciones.
- Suturas.
- Inyecciones.
- Procedimientos quirúrgicos.
- Otros procedimientos.

Se deberá registrar:
- Procedimiento.
- Fecha.
- Médico responsable.
- Observaciones.
- Resultado.

### 17. Historial cronológico

Una funcionalidad muy útil sería mostrar toda la historia clínica en forma cronológica:

HISTORIAL DEL PACIENTE

2026-09-06

```
│
├── Consulta - Medicina General
│   ├── Diagnóstico
│   ├── Tratamiento
│   └── Receta
│
```

2026-08-20

```
│
├── Consulta - Cardiología
│   ├── Diagnóstico
│   └── Exámenes
│
```

2026-07-15

```
│
└── Consulta - Medicina General
    └── Tratamiento
```

Esto facilita enormemente la consulta por parte del médico.

### 18. Documentos clínicos

El sistema puede permitir adjuntar documentos relacionados con el paciente:
- Resultados de laboratorio.
- Informes médicos.
- Radiografías digitalizadas.
- Informes de imágenes.
- Certificados.
- Otros documentos clínicos.

Se debe implementar control de acceso porque contienen información médica sensible.

### 19. Control de acceso

No todos los usuarios deben tener acceso a toda la historia clínica.

Ejemplo:

| Usuario | Acceso |
| --- | --- |
| Médico | Historia clínica de sus atenciones |
| Enfermería | Signos vitales y cuidados |
| Laboratorio | Solicitudes/resultados |
| Farmacia | Recetas |
| Recepción | Datos básicos, no información clínica completa |
| Administrador | Según política institucional |
| Paciente | Información autorizada mediante portal |

El acceso debe validarse tanto en frontend como en backend.

### 20. Auditoría

Toda operación clínica importante debería quedar registrada.

Ejemplo:

AUDITORÍA

Usuario: medicos01

Acción: Registro de diagnóstico

Paciente: HC-000125

Fecha: 06/09/2026 10:35

También conviene registrar:
- Quién consultó la historia.
- Quién modificó información.
- Qué información fue modificada.
- Fecha y hora.
- Usuario responsable.

### 21. Cierre de una consulta

Una vez finalizada la atención, el médico podrá cerrar la consulta.

CONSULTA

Estado:

[ ABIERTA ]

              ↓

[ FINALIZAR CONSULTA ]

              ↓

Estado:

[ CERRADA ]

Una consulta cerrada debería tener restricciones para evitar modificaciones posteriores no autorizadas.

Si se necesita corregir información, puede utilizarse un mecanismo de rectificación/auditoría, en lugar de modificar silenciosamente el registro original.

### 22. Requerimientos funcionales

#### Historia clínica

RF-HC-01: El sistema deberá generar un número único de historia clínica para cada paciente.

RF-HC-02: El sistema deberá permitir consultar la historia clínica de un paciente.

RF-HC-03: El sistema deberá mostrar los datos básicos del paciente asociados a su historia clínica.

RF-HC-04: El sistema deberá mantener el historial de las atenciones realizadas al paciente.

#### Antecedentes

RF-HC-05: El sistema deberá permitir registrar antecedentes personales.

RF-HC-06: El sistema deberá permitir registrar antecedentes familiares.

RF-HC-07: El sistema deberá permitir registrar alergias.

#### Atención médica

RF-HC-08: El sistema deberá permitir registrar consultas médicas.

RF-HC-09: El sistema deberá permitir registrar el motivo de consulta.

RF-HC-10: El sistema deberá permitir registrar la anamnesis.

RF-HC-11: El sistema deberá permitir registrar el examen físico.

RF-HC-12: El sistema deberá permitir registrar signos vitales.

RF-HC-13: El sistema deberá permitir registrar diagnósticos.

RF-HC-14: El sistema deberá permitir registrar tratamientos.

RF-HC-15: El sistema deberá permitir registrar evoluciones médicas.

#### Recetas

RF-HC-16: El sistema deberá permitir registrar recetas médicas.

RF-HC-17: El sistema deberá permitir asociar medicamentos a una receta.

RF-HC-18: El sistema deberá permitir consultar las recetas asociadas al paciente.

#### Exámenes

RF-HC-19: El sistema deberá permitir solicitar exámenes médicos.

RF-HC-20: El sistema deberá permitir consultar los resultados de los exámenes asociados al paciente.

#### Seguridad

RF-HC-21: El sistema deberá restringir el acceso a la historia clínica según el rol y permisos del usuario.

RF-HC-22: El sistema deberá registrar las consultas y modificaciones realizadas sobre la historia clínica.

RF-HC-23: El sistema deberá impedir la eliminación no autorizada de información clínica.

RF-HC-24: El sistema deberá mantener el historial de modificaciones realizadas sobre información clínica.

### 23. Estructura del menú

HISTORIA CLÍNICA

```
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

### 24. Relación con los módulos anteriores

Aquí empieza a tomar forma el núcleo del sistema:

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

#### Punto importante para el diseño de la base de datos

No recomiendo crear una única tabla gigante llamada historia_clinica con todos estos campos. Es mejor separar las entidades:

paciente

```
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

Así el modelo será mucho más escalable para posteriormente implementar Laboratorio, Farmacia, Hospitalización y Emergencias.

## Módulo 6: Admisión y Emergencias

### 1. Objetivo

El módulo permitirá gestionar el ingreso de pacientes al hospital, identificando el motivo de atención, tipo de atención, servicio, médico responsable y estado del paciente.

Debe permitir diferenciar principalmente:
- Atención ambulatoria.
- Emergencia.
- Hospitalización.
- Referencia/derivación.
- Atención programada.

El flujo general sería:

PACIENTE

```
   │
   ▼
```

ADMISIÓN

```
   │
   ├── Atención ambulatoria
   │       ↓
   │     Consulta
   │
   ├── Emergencia
   │       ↓
   │    Triaje
   │       ↓
   │    Atención médica
   │
   └── Hospitalización
           ↓
       Internamiento
```

### 2. Registro de admisión

El personal autorizado deberá registrar el ingreso del paciente.

#### Datos principales

| Campo | Descripción |
| --- | --- |
| ID Admisión | Identificador |
| Código admisión | Código generado |
| Paciente | Paciente ingresante |
| Fecha | Fecha de ingreso |
| Hora | Hora de ingreso |
| Tipo atención | Ambulatoria/Emergencia/Hospitalización |
| Servicio | Servicio solicitado |
| Especialidad | Especialidad |
| Médico | Médico responsable |
| Motivo | Motivo de atención |
| Prioridad | Según corresponda |
| Estado | Abierta/Cerrada |
| Usuario | Usuario que registra |

Ejemplo:

ADMISIÓN: ADM-000125

```
Paciente:       Juan Pérez López
Fecha:          06/09/2026
Hora:           10:25
Tipo:           Emergencia
Motivo:         Dolor abdominal
Prioridad:      Urgente
Estado:         ABIERTA
```

### 3. Tipos de admisión

El sistema debería manejar diferentes tipos:

#### Atención ambulatoria

Paciente que acude a una consulta sin necesidad de internamiento.

Paciente → Admisión → Consulta → Alta

#### Emergencia

Paciente que requiere atención inmediata.

Paciente → Admisión → Triaje → Emergencia → Atención médica

#### Hospitalización

Paciente que requiere permanecer internado.

Paciente → Admisión → Hospitalización → Alta hospitalaria

#### Referencia

Paciente derivado desde otro establecimiento.

Establecimiento origen

```
        ↓
   Referencia
        ↓
     Admisión
        ↓
     Atención
```

### 4. Emergencias

El módulo deberá permitir registrar pacientes que llegan directamente a emergencia, incluso cuando no tengan una cita previa.

Esto es importante porque en una emergencia el flujo no debe depender del módulo Citas Médicas.

EMERGENCIA

Paciente llega

      ↓

Identificación

      ↓

Registro de emergencia

      ↓

Triaje

      ↓

Clasificación

      ↓

Atención médica

### 5. Triaje

El personal de emergencia deberá realizar el triaje inicial.

Se podrá registrar:
- Fecha y hora.
- Enfermero(a) responsable.
- Motivo de atención.
- Signos vitales.
- Nivel de prioridad.
- Observaciones.

Ejemplo:

TRIAJE

Paciente: Juan Pérez López

Presión arterial: 150/95

Frecuencia cardíaca: 105

Temperatura: 38.5 °C

Saturación: 94%

Prioridad: URGENTE

Observaciones:

Paciente presenta dolor abdominal intenso.

### 6. Clasificación de emergencia

Se puede implementar un sistema de prioridades.

Por ejemplo:

PRIORIDAD 1 - CRÍTICA

Atención inmediata

PRIORIDAD 2 - URGENTE

Atención prioritaria

PRIORIDAD 3 - MODERADA

Puede esperar

PRIORIDAD 4 - LEVE

Atención no urgente

La nomenclatura exacta debería configurarse de acuerdo con el protocolo que utilice el establecimiento.

### 7. Sala de espera de emergencia

El sistema podrá mostrar una lista de pacientes esperando atención:

EMERGENCIA - PACIENTES EN ESPERA

```
Prioridad   Paciente          Hora       Estado
URGENTE     Juan Pérez        10:25      Esperando
MODERADA    María Torres      10:30      Esperando
LEVE        Pedro García      10:42      Esperando
```

Esto puede integrarse posteriormente con una pantalla de llamado.

### 8. Atención de emergencia

El médico podrá seleccionar al paciente y comenzar la atención.

Se deberá registrar:
- Motivo de consulta.
- Antecedentes relevantes.
- Evaluación médica.
- Signos vitales.
- Diagnóstico.
- Tratamiento.
- Medicamentos.
- Procedimientos.
- Solicitud de exámenes.
- Observaciones.
- Evolución.

La información clínica deberá quedar asociada a la Historia Clínica.

### 9. Derivación dentro del hospital

Dependiendo de la evaluación, el paciente puede ser derivado a otro servicio.

Ejemplo:

Emergencia

    ↓

Evaluación médica

```
    ↓
┌──────────────┬───────────────┐
↓              ↓               ↓
Alta       Hospitalización   Cirugía
             ↓
         Habitación/Cama
```

El sistema deberá registrar:
- Servicio origen.
- Servicio destino.
- Médico responsable.
- Fecha y hora.
- Motivo de derivación.
- Observaciones.

### 10. Hospitalización

Si el médico determina que el paciente requiere internamiento, se generará una solicitud de hospitalización.

Datos:
- Paciente.
- Médico solicitante.
- Especialidad.
- Diagnóstico.
- Servicio.
- Fecha de ingreso.
- Tipo de hospitalización.
- Prioridad.
- Observaciones.

Posteriormente el módulo de hospitalización podrá asignar:
- Habitación.
- Cama.
- Piso.
- Servicio.

### 11. Alta de emergencia

Cuando finaliza la atención de emergencia, el sistema deberá permitir registrar el resultado:

RESULTADO DE EMERGENCIA

☑ Alta médica

☐ Hospitalización

☐ Referencia

☐ Traslado

☐ Fallecimiento

Debe registrarse:
- Fecha y hora de salida.
- Médico responsable.
- Diagnóstico.
- Indicaciones.
- Tratamiento.
- Recomendaciones.
- Próximo control, si corresponde.

### 12. Referencias y derivaciones

El sistema deberá permitir registrar pacientes enviados a otros establecimientos.

Datos:
- Establecimiento destino.
- Motivo.
- Diagnóstico.
- Médico responsable.
- Fecha.
- Hora.
- Condición del paciente.
- Observaciones.
- Documentación asociada.

### 13. Acompañante

En emergencia puede ser necesario registrar información del acompañante:
- Nombre completo.
- Documento.
- Parentesco.
- Teléfono.
- Observaciones.

Ejemplo:

ACOMPAÑANTE

Nombre: María López García

Parentesco: Esposa

Teléfono: 987654321

### 14. Paciente no identificado

Para emergencia, es recomendable contemplar un caso especial:

PACIENTE NO IDENTIFICADO

Cuando una persona llega inconsciente o sin documentación, el sistema podría generar temporalmente:

EMG-000025

Paciente: NO IDENTIFICADO

Posteriormente, cuando se confirme su identidad, el registro deberá asociarse al paciente correcto.

### 15. Control de tiempos

El sistema podrá registrar automáticamente:
- Hora de llegada.
- Hora de triaje.
- Hora de inicio de atención.
- Hora de finalización.
- Hora de alta.
- Tiempo de espera.

Ejemplo:

```
Llegada:            10:25
Triaje:                10:30
Inicio atención:       10:42
Fin atención:         11:20
Alta:                  11:30
Tiempo de espera:    12 minutos
```

Esto permitirá generar posteriormente indicadores de calidad y atención.

### 16. Búsqueda de admisiones

El sistema deberá permitir buscar por:
- Código de admisión.
- DNI.
- Paciente.
- Fecha.
- Tipo de atención.
- Servicio.
- Médico.
- Estado.

Ejemplo:

```
Código      Paciente        Tipo            Fecha         Estado
ADM-001    Juan Pérez      Emergencia     06/09/26     Cerrada
ADM-002    María Torres    Ambulatoria    06/09/26     Abierta
ADM-003    Pedro García    Hospital.      06/09/26     Activa
```

### 17. Reportes

El módulo podrá generar:
- Atenciones de emergencia por día.
- Emergencias por especialidad.
- Emergencias por prioridad.
- Tiempo promedio de espera.
- Pacientes hospitalizados desde emergencia.
- Altas médicas.
- Referencias.
- Atenciones por médico.
- Atenciones por período.
- Pacientes no atendidos.
- Pacientes que abandonaron la espera.

### 18. Requerimientos funcionales

#### Admisión

RF-ADM-01: El sistema deberá permitir registrar una admisión.

RF-ADM-02: El sistema deberá generar un código único para cada admisión.

RF-ADM-03: El sistema deberá permitir seleccionar el tipo de atención.

RF-ADM-04: El sistema deberá asociar la admisión con un paciente.

RF-ADM-05: El sistema deberá registrar fecha y hora de ingreso.

RF-ADM-06: El sistema deberá permitir registrar el motivo de atención.

#### Emergencia

RF-ADM-07: El sistema deberá permitir registrar pacientes que ingresen directamente por emergencia.

RF-ADM-08: El sistema deberá permitir registrar el triaje inicial.

RF-ADM-09: El sistema deberá permitir registrar signos vitales durante el triaje.

RF-ADM-10: El sistema deberá permitir asignar una prioridad de atención.

RF-ADM-11: El sistema deberá mostrar los pacientes pendientes de atención.

RF-ADM-12: El sistema deberá registrar la atención médica de emergencia.

#### Derivaciones

RF-ADM-13: El sistema deberá permitir derivar pacientes a otros servicios.

RF-ADM-14: El sistema deberá registrar el motivo de la derivación.

RF-ADM-15: El sistema deberá permitir generar una solicitud de hospitalización.

RF-ADM-16: El sistema deberá registrar referencias hacia otros establecimientos.

#### Alta

RF-ADM-17: El sistema deberá permitir registrar el alta del paciente.

RF-ADM-18: El sistema deberá registrar la fecha y hora de salida.

RF-ADM-19: El sistema deberá registrar las indicaciones médicas al momento del alta.

#### Control

RF-ADM-20: El sistema deberá registrar los tiempos de llegada, triaje y atención.

RF-ADM-21: El sistema deberá permitir consultar el historial de admisiones del paciente.

RF-ADM-22: El sistema deberá mantener la trazabilidad de las modificaciones realizadas.

#### Reportes

RF-ADM-23: El sistema deberá generar reportes de admisiones.

RF-ADM-24: El sistema deberá generar reportes de atenciones de emergencia.

RF-ADM-25: El sistema deberá generar estadísticas de tiempos de espera.

### 19. Estructura del menú

ADMISIÓN Y EMERGENCIAS

```
│
├── Admisiones
│   ├── Nueva admisión
│   ├── Listar admisiones
│   └── Buscar admisión
│
├── Emergencias
│   ├── Nuevo ingreso
│   ├── Pacientes en espera
│   ├── Triaje
│   ├── Atención de emergencia
│   └── Alta de emergencia
│
├── Derivaciones
│   ├── Derivación interna
│   └── Referencia externa
│
├── Hospitalización
│   └── Solicitudes
│
├── Acompañantes
│
└── Reportes
```

### 20. Relaciones con los módulos anteriores

En este punto el sistema ya comienza a tener un flujo bastante completo:

```
                    PACIENTE
                       │
                       ▼
              ┌────────────────┐
              │    ADMISIÓN     │
              └───────┬────────┘
                      │
             ┌────────┴─────────┐
             ▼                  ▼
         AMBULATORIA        EMERGENCIA
             │                  │
             ▼                  ▼
            CITA              TRIAJE
             │                  │
             ▼                  ▼
         CONSULTA          ATENCIÓN MÉDICA
             │                  │
             └────────┬─────────┘
                      ▼
               HISTORIA CLÍNICA
                      │
              ┌───────┼────────┐
              ▼       ▼        ▼
          FARMACIA  EXÁMENES  EVOLUCIÓN
                      │
                      ▼
                HOSPITALIZACIÓN
```

#### Una consideración importante para tu diseño

Yo manejaría Admisión como una entidad independiente de Cita.

Una cita representa:

"El paciente tiene programada una atención."

Una admisión representa:

"El paciente ingresó al establecimiento para recibir atención."

Por eso puede existir:

Cita → Admisión → Consulta

pero también:

Emergencia → Admisión → Triaje → Consulta

sin que exista previamente una cita.

## MÓDULO 7 – HOSPITALIZACIÓN

El Módulo de Hospitalización administra todo el proceso de un paciente que requiere permanecer internado en el hospital, desde la solicitud de hospitalización hasta el alta médica.

### 1. Flujo general

PACIENTE

   ↓

ADMISIÓN / EMERGENCIA

   ↓

EVALUACIÓN MÉDICA

   ↓

¿REQUIERE HOSPITALIZACIÓN?

   ↓ SÍ

SOLICITUD DE HOSPITALIZACIÓN

   ↓

ASIGNACIÓN DE HABITACIÓN Y CAMA

   ↓

INGRESO HOSPITALARIO

   ↓

EVOLUCIÓN MÉDICA

   ↓

INDICACIONES MÉDICAS

   ↓

ENFERMERÍA / MEDICAMENTOS / PROCEDIMIENTOS

   ↓

¿ALTA?

   ↓

ALTA HOSPITALARIA

### 2. Submódulos de Hospitalización

El menú podría organizarse así:

Hospitalización

```
│
├── Solicitudes de hospitalización
├── Ingresos hospitalarios
├── Habitaciones
├── Camas
├── Pacientes hospitalizados
├── Movimientos de pacientes
├── Evolución médica
├── Indicaciones médicas
├── Interconsultas
├── Procedimientos
├── Traslados
├── Alta hospitalaria
├── Fallecimientos
└── Reportes
```

### 3. Solicitud de hospitalización

La hospitalización normalmente comienza cuando un médico determina que el paciente necesita permanecer internado.

#### Datos

- Código de solicitud
- Paciente
- Historia clínica
- Médico solicitante
- Especialidad
- Fecha y hora
- Diagnóstico
- Motivo de hospitalización
- Tipo de hospitalización
- Servicio solicitado
- Prioridad
- Observaciones
- Estado

#### Estados

SOLICITADA

   ↓

APROBADA

   ↓

PENDIENTE DE CAMA

   ↓

INGRESADA

También puede ser:

RECHAZADA

CANCELADA

#### Requerimientos

RF-HOSP-01: El sistema deberá permitir registrar una solicitud de hospitalización.

RF-HOSP-02: El sistema deberá asociar la solicitud con el paciente y su historia clínica.

RF-HOSP-03: El sistema deberá registrar al médico que solicita la hospitalización.

RF-HOSP-04: El sistema deberá registrar el diagnóstico y motivo de hospitalización.

RF-HOSP-05: El sistema deberá permitir aprobar, rechazar o cancelar una solicitud.

### 4. Ingreso hospitalario

Una vez aprobada la hospitalización, se genera el ingreso.

#### Información

- Código de hospitalización
- Paciente
- Historia clínica
- Solicitud relacionada
- Fecha y hora de ingreso
- Médico responsable
- Especialidad
- Servicio
- Diagnóstico de ingreso
- Motivo de ingreso
- Tipo de ingreso
- Usuario que registra

#### Tipos

- Programado
- Emergencia
- Referencia
- Traslado interno

RF-HOSP-06: El sistema deberá generar un código único de hospitalización.

RF-HOSP-07: El sistema deberá registrar la fecha y hora exacta del ingreso.

RF-HOSP-08: El sistema deberá asociar al paciente con el médico responsable.

### 5. Gestión de pisos, habitaciones y camas

Esta es una parte fundamental.

La estructura recomendada es:

HOSPITAL

   ↓

PISO

   ↓

HABITACIÓN

   ↓

CAMA

Por ejemplo:

Piso 2

```
│
├── Habitación 201
│   ├── Cama 201-A
│   └── Cama 201-B
│
├── Habitación 202
│   ├── Cama 202-A
│   └── Cama 202-B
│
└── Habitación 203
    └── Cama 203-A
```

#### Habitaciones

Datos:
- Código
- Número
- Piso
- Servicio
- Tipo
- Capacidad
- Estado

Tipos:
- Individual
- Doble
- Triple
- UCI
- Aislamiento
- Emergencia
- Otros

#### Camas

Datos:
- Código
- Número
- Habitación
- Tipo
- Estado

Estados:

DISPONIBLE

OCUPADA

RESERVADA

MANTENIMIENTO

BLOQUEADA

#### Requerimientos

RF-HOSP-09: El sistema deberá permitir registrar pisos.

RF-HOSP-10: El sistema deberá permitir registrar habitaciones.

RF-HOSP-11: El sistema deberá permitir registrar camas.

RF-HOSP-12: El sistema deberá mostrar la disponibilidad de camas en tiempo real.

RF-HOSP-13: El sistema deberá impedir asignar una cama que se encuentre ocupada.

### 6. Asignación de cama

Cuando el paciente ingresa, se debe asignar una cama.

Ejemplo:

Paciente: Juan Pérez

Hospitalización: HOSP-000125

Piso: 2

Habitación: 205

Cama: 205-B

Fecha ingreso:

06/09/2026 14:35

Médico responsable:

Dr. Carlos García

El sistema debe actualizar automáticamente:

Cama 205-B

     ↓

OCUPADA

RF-HOSP-14: El sistema deberá permitir asignar una cama disponible a un paciente hospitalizado.

RF-HOSP-15: El sistema deberá registrar quién realizó la asignación.

RF-HOSP-16: El sistema deberá registrar fecha y hora de asignación.

### 7. Pacientes hospitalizados

Debe existir una pantalla para conocer quiénes están actualmente hospitalizados.

Ejemplo:

| Habitación | Cama | Paciente | Médico | Diagnóstico | Ingreso |
| --- | --- | --- | --- | --- | --- |
| 201 | A | Juan Pérez | Dr. García | Neumonía | 05/09 |
| 201 | B | María López | Dra. Torres | Infección | 06/09 |
| 202 | A | Pedro Díaz | Dr. Ruiz | Fractura | 04/09 |

Debe permitir buscar por:
- Paciente
- DNI
- Historia clínica
- Habitación
- Cama
- Médico
- Servicio
- Fecha de ingreso

### 8. Movimientos del paciente

Durante la hospitalización un paciente puede cambiar de cama o habitación.

Por ejemplo:

Habitación 201

Cama A

   ↓

Traslado

   ↓

Habitación 305

Cama B

Se debe conservar el historial.

#### Datos

- Paciente
- Cama origen
- Cama destino
- Fecha/hora
- Motivo
- Médico responsable
- Usuario que realizó el traslado
- Observaciones

RF-HOSP-17: El sistema deberá permitir trasladar un paciente entre camas.

RF-HOSP-18: El sistema deberá registrar el historial completo de movimientos.

RF-HOSP-19: El sistema deberá actualizar automáticamente el estado de las camas involucradas.

### 9. Evolución médica

Durante la hospitalización el médico debe registrar la evolución del paciente.

#### Datos

- Fecha y hora
- Paciente
- Médico
- Diagnóstico
- Evolución
- Signos vitales
- Examen físico
- Resultados relevantes
- Evaluación
- Plan médico
- Observaciones

Ejemplo:

06/09/2026 - 08:30

Paciente estable.

Temperatura: 37.2 °C

Presión: 120/80

FC: 78 lpm

Evolución:

Paciente presenta mejoría clínica.

Plan:

Continuar tratamiento y control.

RF-HOSP-20: El sistema deberá permitir registrar evoluciones médicas durante la hospitalización.

RF-HOSP-21: Cada evolución deberá estar asociada a un médico y fecha/hora.

### 10. Indicaciones médicas

El médico puede dejar órdenes para el personal asistencial.

Por ejemplo:

MEDICACIÓN

Paracetamol 500 mg

Cada 8 horas

DIETA

Dieta blanda

CONTROL

Signos vitales cada 6 horas

PROCEDIMIENTO

Curación de herida

Las indicaciones pueden incluir:
- Medicamentos
- Dosis
- Frecuencia
- Vía de administración
- Dieta
- Reposo
- Exámenes
- Procedimientos
- Controles
- Restricciones
- Otras indicaciones

RF-HOSP-22: El sistema deberá permitir registrar indicaciones médicas.

RF-HOSP-23: Las indicaciones deberán quedar asociadas a la hospitalización.

RF-HOSP-24: El sistema deberá registrar médico, fecha y hora de cada indicación.

### 11. Interconsultas

Un paciente puede necesitar la evaluación de otro especialista.

Ejemplo:

Paciente hospitalizado

       ↓

Médico tratante

       ↓

Solicita interconsulta

       ↓

Cardiología

       ↓

Cardiólogo evalúa

       ↓

Registra informe

Datos:
- Paciente
- Médico solicitante
- Especialidad solicitada
- Motivo
- Fecha
- Prioridad
- Médico interconsultor
- Evaluación
- Recomendaciones
- Estado

Estados:

SOLICITADA

ASIGNADA

ATENDIDA

CANCELADA

RF-HOSP-25: El sistema deberá permitir solicitar interconsultas.

RF-HOSP-26: El sistema deberá permitir registrar la respuesta del especialista.

### 12. Procedimientos

Durante la hospitalización pueden realizarse procedimientos.

Ejemplos:
- Curaciones
- Suturas
- Cateterización
- Procedimientos menores
- Terapias
- Otros procedimientos médicos

Datos:
- Paciente
- Procedimiento
- Médico/profesional
- Fecha y hora
- Motivo
- Resultado
- Observaciones

RF-HOSP-27: El sistema deberá permitir registrar procedimientos realizados durante la hospitalización.

### 13. Integración con Enfermería

Aquí es importante no duplicar funcionalidades.

Hospitalización administra:

Paciente hospitalizado

Habitación

Cama

Movimientos

Evolución médica

Indicaciones

El Módulo 8 – Enfermería administrará:

Recepción de indicaciones

Signos vitales

Administración de medicamentos

Cuidados

Notas de enfermería

Balance hídrico

Turnos

Por tanto:

HOSPITALIZACIÓN

       ↓

INDICACIONES MÉDICAS

       ↓

ENFERMERÍA

       ↓

EJECUCIÓN

Esto permitirá una buena separación de responsabilidades.

### 14. Alta hospitalaria

Cuando el médico determina que el paciente puede salir del hospital, se registra el alta.

#### Datos

- Código de alta
- Paciente
- Hospitalización
- Médico responsable
- Fecha/hora
- Diagnóstico de egreso
- Condición del paciente
- Resumen clínico
- Tratamiento
- Medicamentos
- Recomendaciones
- Próxima cita
- Observaciones

#### Tipos de egreso

- Alta médica
- Alta voluntaria
- Traslado
- Referencia
- Fallecimiento

RF-HOSP-28: El sistema deberá permitir registrar el alta hospitalaria.

RF-HOSP-29: El sistema deberá registrar el diagnóstico de egreso.

RF-HOSP-30: El sistema deberá registrar las recomendaciones y tratamiento al alta.

RF-HOSP-31: Al registrar el alta, la cama deberá cambiar automáticamente a DISPONIBLE.

### 15. Fallecimiento

Debe existir un proceso específico para registrar el fallecimiento del paciente.

Datos:
- Paciente
- Hospitalización
- Fecha/hora
- Médico responsable
- Causa registrada
- Observaciones
- Documentación correspondiente

Al finalizar:

```
Hospitalización → CERRADA
Cama → DISPONIBLE
Paciente → Estado correspondiente
```

RF-HOSP-32: El sistema deberá permitir registrar el fallecimiento de un paciente hospitalizado, con control de permisos y auditoría.

### 16. Reportes

El módulo debe generar reportes como:

#### Reportes de ocupación

- Camas disponibles
- Camas ocupadas
- Camas bloqueadas
- Porcentaje de ocupación
- Ocupación por piso
- Ocupación por servicio

#### Reportes de pacientes

- Pacientes hospitalizados actualmente
- Ingresos por período
- Altas por período
- Traslados
- Estancia hospitalaria
- Pacientes por médico
- Pacientes por especialidad

#### Indicadores

```
Total camas:               100
Camas ocupadas:            72
Camas disponibles:         20
Camas mantenimiento:        8
Ocupación:                  72%
```

RF-HOSP-33: El sistema deberá generar reportes de ocupación hospitalaria.

RF-HOSP-34: El sistema deberá generar reportes de ingresos y egresos.

RF-HOSP-35: El sistema deberá permitir filtrar reportes por fechas, servicio, médico y especialidad.

RF-HOSP-36: El sistema deberá permitir exportar reportes a PDF y Excel.

### 17. Requerimientos consolidados

| Código | Requerimiento |
| --- | --- |
| RF-HOSP-01 | Registrar solicitud de hospitalización |
| RF-HOSP-02 | Asociar solicitud con paciente |
| RF-HOSP-03 | Registrar médico solicitante |
| RF-HOSP-04 | Registrar diagnóstico de ingreso |
| RF-HOSP-05 | Aprobar/rechazar/cancelar solicitud |
| RF-HOSP-06 | Generar código de hospitalización |
| RF-HOSP-07 | Registrar ingreso |
| RF-HOSP-08 | Asociar médico responsable |
| RF-HOSP-09 | Gestionar pisos |
| RF-HOSP-10 | Gestionar habitaciones |
| RF-HOSP-11 | Gestionar camas |
| RF-HOSP-12 | Consultar disponibilidad |
| RF-HOSP-13 | Impedir doble asignación |
| RF-HOSP-14 | Asignar cama |
| RF-HOSP-15 | Registrar usuario responsable |
| RF-HOSP-16 | Registrar fecha/hora |
| RF-HOSP-17 | Trasladar paciente |
| RF-HOSP-18 | Mantener historial de movimientos |
| RF-HOSP-19 | Actualizar estado de camas |
| RF-HOSP-20 | Registrar evolución médica |
| RF-HOSP-21 | Identificar médico y fecha |
| RF-HOSP-22 | Registrar indicaciones |
| RF-HOSP-23 | Asociar indicaciones a hospitalización |
| RF-HOSP-24 | Registrar autor y fecha |
| RF-HOSP-25 | Solicitar interconsultas |
| RF-HOSP-26 | Registrar respuesta del especialista |
| RF-HOSP-27 | Registrar procedimientos |
| RF-HOSP-28 | Registrar alta |
| RF-HOSP-29 | Registrar diagnóstico de egreso |
| RF-HOSP-30 | Registrar tratamiento y recomendaciones |
| RF-HOSP-31 | Liberar cama al alta |
| RF-HOSP-32 | Registrar fallecimiento |
| RF-HOSP-33 | Reportes de ocupación |
| RF-HOSP-34 | Reportes de ingresos/egresos |
| RF-HOSP-35 | Filtros de reportes |
| RF-HOSP-36 | Exportación PDF/Excel |

### 18. Diseño de base de datos recomendado

Para tu proyecto, no recomiendo una sola tabla hospitalizacion con todos los datos.

Una estructura inicial podría ser:

PACIENTE

```
   │
   ├──── ADMISION
   │
   └──── HISTORIA_CLINICA
             │
             └──── HOSPITALIZACION
                       │
          ┌────────────┼─────────────┐
          ↓            ↓             ↓
     HABITACION       CAMA      MOVIMIENTO
          │
          └── CAMA
```

HOSPITALIZACION

```
       │
       ├── EVOLUCION_MEDICA
       ├── INDICACION_MEDICA
       ├── INTERCONSULTA
       ├── PROCEDIMIENTO
       └── ALTA_HOSPITALARIA
```

Una posible estructura:

hospitalizacion

habitacion

cama

movimiento_hospitalario

evolucion_hospitalaria

indicacion_medica

interconsulta

procedimiento_hospitalario

alta_hospitalaria

Esto te permitirá posteriormente integrar correctamente Enfermería, Farmacia, Laboratorio, Imágenes y Facturación sin tener que rediseñar todo el sistema.

#### 🔗 Integración de los módulos hasta ahora

1. USUARIOS

       ↓

2. PACIENTES

```
       ↓
3. CITAS ───────────────┐
       ↓                │
4. MÉDICOS              │
       ↓                │
5. HISTORIA CLÍNICA      │
       ↓                │
6. ADMISIÓN/EMERGENCIA ←┘
       ↓
```

7. HOSPITALIZACIÓN

       ↓

8. ENFERMERÍA

       ↓

9. FARMACIA

       ↓

10. LABORATORIO

       ↓

11. IMÁGENES

       ↓

12. CIRUGÍA

       ↓

13. FACTURACIÓN

## Módulo 8 – Enfermería

El Módulo de Enfermería permite gestionar las actividades asistenciales realizadas por el personal de enfermería durante la atención ambulatoria, emergencia y principalmente durante la hospitalización.

Su función principal es convertir las indicaciones médicas en actividades de cuidado y registrar todo lo realizado al paciente.

#### Flujo principal

HOSPITALIZACIÓN

      ↓

INDICACIONES MÉDICAS

      ↓

ENFERMERÍA

      ↓

VALORACIÓN DEL PACIENTE

      ↓

SIGNOS VITALES

      ↓

PLAN DE CUIDADOS

      ↓

ADMINISTRACIÓN DE MEDICAMENTOS

      ↓

PROCEDIMIENTOS / CUIDADOS

      ↓

NOTA DE ENFERMERÍA

      ↓

CAMBIO DE TURNO

### 1. Menú del módulo

Una propuesta para el sistema:

ENFERMERÍA

```
│
├── Panel de Enfermería
├── Pacientes hospitalizados
├── Valoración de pacientes
├── Signos vitales
├── Plan de cuidados
├── Indicaciones médicas
├── Administración de medicamentos
├── Procedimientos
├── Balance hídrico
├── Notas de enfermería
├── Cambio de turno
├── Interconsultas
├── Alertas
└── Reportes
```

### 2. Panel de Enfermería

Al ingresar, la enfermera debería visualizar los pacientes que tiene asignados.

Ejemplo:

| Cama | Paciente | Diagnóstico | Prioridad | Medicamentos | Pendientes |
| --- | --- | --- | --- | --- | --- |
| 201-A | Juan Pérez | Neumonía | Alta | 2 | 3 |
| 201-B | María López | Infección | Media | 3 | 1 |
| 202-A | Pedro Díaz | Fractura | Alta | 1 | 2 |

El sistema podría mostrar indicadores:

```
Pacientes asignados:         12
Medicamentos pendientes:     8
Signos vitales pendientes:    4
Procedimientos pendientes:    3
Alertas:                       2
```

#### Requerimientos

RF-ENF-01: El sistema deberá mostrar al personal de enfermería los pacientes asignados.

RF-ENF-02: El sistema deberá mostrar las actividades pendientes por paciente.

RF-ENF-03: El sistema deberá mostrar alertas relacionadas con la atención de los pacientes.

### 3. Asignación de pacientes a enfermería

Debe existir una relación entre:

TURNO

   ↓

ENFERMERA

   ↓

SERVICIO

   ↓

PACIENTES

   ↓

CAMAS

Por ejemplo:

Turno: Mañana

Fecha: 06/09/2026

Enfermera: Ana Torres

Servicio: Medicina Interna

Pacientes:

```
├── Hab. 201-A
├── Hab. 201-B
├── Hab. 202-A
└── Hab. 203-B
```

RF-ENF-04: El sistema deberá permitir asignar pacientes a personal de enfermería.

RF-ENF-05: El sistema deberá registrar el turno correspondiente.

RF-ENF-06: El sistema deberá permitir consultar los pacientes asignados a cada enfermera.

### 4. Valoración de enfermería

La enfermera realiza una valoración inicial y periódica del paciente.

Puede registrar:
- Estado general
- Estado de conciencia
- Dolor
- Movilidad
- Alimentación
- Higiene
- Estado de piel
- Riesgo de caída
- Riesgo de lesiones por presión
- Necesidades de cuidado
- Observaciones

Ejemplo:

Paciente: Juan Pérez

Estado general: Estable

Conciencia: Orientado

Dolor: 3/10

Movilidad: Parcial

Alimentación: Vía oral

Riesgo de caída: Medio

Observación:

Paciente refiere dolor moderado.

RF-ENF-07: El sistema deberá permitir registrar la valoración de enfermería.

RF-ENF-08: El sistema deberá permitir registrar valoraciones periódicas.

RF-ENF-09: El sistema deberá conservar el historial de valoraciones.

### 5. Signos vitales

Esta funcionalidad debe integrarse con Historia Clínica y Hospitalización.

La enfermera puede registrar:
- Temperatura
- Presión arterial
- Frecuencia cardíaca
- Frecuencia respiratoria
- Saturación de oxígeno
- Peso
- Talla
- Dolor
- Glucosa, cuando corresponda

Ejemplo:

| Fecha/Hora | Temp. | PA | FC | FR | SpO₂ |
| --- | --- | --- | --- | --- | --- |
| 08:00 | 37.2 | 120/80 | 78 | 18 | 97% |
| 14:00 | 37.5 | 118/78 | 82 | 19 | 96% |
| 20:00 | 38.1 | 125/82 | 95 | 22 | 93% |

El sistema podría generar una alerta cuando un valor esté fuera de los parámetros configurados.

RF-ENF-10: El sistema deberá permitir registrar signos vitales.

RF-ENF-11: El sistema deberá registrar fecha, hora y profesional responsable.

RF-ENF-12: El sistema deberá mantener el historial de signos vitales.

RF-ENF-13: El sistema podrá generar alertas ante valores fuera de rangos configurados.

### 6. Plan de cuidados de enfermería

Permite definir las actividades que deben realizarse al paciente.

Ejemplo:

Paciente: Juan Pérez

Problema:

Dificultad respiratoria

Objetivo:

Mantener saturación adecuada.

Actividades:

✓ Control de SpO₂ cada 4 horas

✓ Control de frecuencia respiratoria

✓ Administrar oxígeno según indicación

✓ Vigilar dificultad respiratoria

✓ Registrar evolución

RF-ENF-14: El sistema deberá permitir registrar planes de cuidados.

RF-ENF-15: El sistema deberá permitir definir actividades de cuidado.

RF-ENF-16: El sistema deberá registrar el cumplimiento de las actividades.

### 7. Indicaciones médicas

Aquí se produce una integración importante con el Módulo 7 – Hospitalización.

El médico registra:

Paracetamol 500 mg

Cada 8 horas

Vía oral

La enfermera visualiza:

INDICACIÓN MÉDICA

Medicamento: Paracetamol

Dosis: 500 mg

Vía: Oral

Frecuencia: Cada 8 horas

08:00  ✓ Administrado

16:00  ✓ Administrado

00:00  Pendiente

La enfermera no debería modificar la indicación médica. Debe registrar su ejecución.

RF-ENF-17: El sistema deberá mostrar las indicaciones médicas activas.

RF-ENF-18: El sistema deberá permitir registrar el cumplimiento de las indicaciones.

RF-ENF-19: El sistema deberá registrar fecha, hora y profesional que ejecutó la indicación.

### 8. Administración de medicamentos

Esta es una de las funciones más importantes.

Debe existir una trazabilidad:

MÉDICO

   ↓

PRESCRIPCIÓN

   ↓

FARMACIA

   ↓

DISPENSACIÓN

   ↓

ENFERMERÍA

   ↓

ADMINISTRACIÓN

   ↓

REGISTRO

La enfermera debe poder registrar:
- Medicamento
- Dosis
- Vía
- Fecha
- Hora programada
- Hora real
- Profesional
- Observaciones
- Estado

Estados:

PENDIENTE

ADMINISTRADO

NO ADMINISTRADO

RECHAZADO POR PACIENTE

SUSPENDIDO

#### Importante

No se debe considerar simplemente:

Medicamento = Administrado

Debe existir una administración individual por cada dosis.

Ejemplo:

Paracetamol 500 mg cada 8 horas

```
06/09 08:00 → Administrado
06/09 16:00 → Administrado
07/09 00:00 → No administrado
```

Esto proporciona trazabilidad.

RF-ENF-20: El sistema deberá mostrar los medicamentos pendientes de administración.

RF-ENF-21: El sistema deberá registrar cada administración de medicamento.

RF-ENF-22: El sistema deberá registrar dosis, vía, fecha y hora.

RF-ENF-23: El sistema deberá registrar al profesional que administró el medicamento.

RF-ENF-24: El sistema deberá permitir registrar la causa cuando un medicamento no sea administrado.

### 9. Procedimientos de enfermería

Se pueden registrar procedimientos como:
- Curaciones
- Cambios de posición
- Higiene
- Control de glucosa
- Administración de oxígeno
- Colocación de dispositivos
- Retiro de dispositivos
- Otros cuidados

Datos:
- Paciente
- Procedimiento
- Fecha/hora
- Enfermera
- Resultado
- Observaciones

RF-ENF-25: El sistema deberá permitir registrar procedimientos de enfermería.

RF-ENF-26: El sistema deberá registrar al profesional responsable.

RF-ENF-27: El sistema deberá mantener el historial de procedimientos.

### 10. Balance hídrico

Especialmente importante en determinados pacientes hospitalizados.

#### Ingresos

- Agua
- Sueros
- Medicamentos intravenosos
- Alimentación
- Otros líquidos

#### Egresos

- Orina
- Vómitos
- Drenajes
- Otros

Ejemplo:

BALANCE HÍDRICO

INGRESOS

```
Suero             1,000 ml
Agua                500 ml
Medicamentos        100 ml
                    ------
Total             1,600 ml
```

EGRESOS

```
Orina             1,200 ml
Drenaje             100 ml
                    ------
Total             1,300 ml
Balance             +300 ml
```

RF-ENF-28: El sistema deberá permitir registrar ingresos y egresos de líquidos.

RF-ENF-29: El sistema deberá calcular automáticamente el balance hídrico.

RF-ENF-30: El sistema deberá mantener el historial de balances.

### 11. Notas de enfermería

La enfermera debe registrar las actividades y observaciones realizadas durante su turno.

Ejemplo:

06/09/2026 - 14:30

Paciente consciente y orientado.

Se realiza control de signos vitales.

Paciente tolera alimentación.

Se administra medicación según indicación médica.

Se mantiene vía periférica permeable.

Enfermera:

Ana Torres

RF-ENF-31: El sistema deberá permitir registrar notas de enfermería.

RF-ENF-32: Cada nota deberá registrar fecha, hora y profesional.

RF-ENF-33: El sistema deberá conservar las notas como parte de la historia clínica.

### 12. Cambio de turno

Este proceso es fundamental para garantizar continuidad del cuidado.

La enfermera que termina su turno debe dejar información para la siguiente.

ENFERMERA TURNO MAÑANA

          ↓

ENTREGA DE TURNO

          ↓

ENFERMERA TURNO TARDE

Información:
- Pacientes
- Estado actual
- Medicamentos pendientes
- Procedimientos pendientes
- Alertas
- Observaciones
- Incidencias

Ejemplo:

PACIENTE: Juan Pérez

Cama: 201-A

Estado: Estable

Pendientes:

• Control de signos vitales 18:00

• Medicamento 20:00

• Curación 21:00

Observación:

Paciente presenta dolor moderado.

RF-ENF-34: El sistema deberá permitir registrar la entrega de turno.

RF-ENF-35: El sistema deberá mostrar las actividades pendientes al siguiente turno.

RF-ENF-36: El sistema deberá identificar al personal que entrega y recibe el turno.

### 13. Alertas de enfermería

El sistema puede generar alertas para:
- Medicamento pendiente
- Signos vitales pendientes
- Valor crítico
- Procedimiento pendiente
- Paciente con riesgo de caída
- Paciente con alergia registrada
- Cambio de turno
- Indicaciones médicas nuevas

Ejemplo:

⚠ ALERTAS

🔴 SpO₂ fuera del rango configurado

🟠 Medicamento pendiente

🟡 Signos vitales pendientes

🟡 Procedimiento pendiente

RF-ENF-37: El sistema deberá generar alertas relacionadas con actividades pendientes.

RF-ENF-38: El sistema deberá registrar la atención de las alertas.

### 14. Reportes de Enfermería

#### Reportes principales

- Pacientes por enfermera
- Pacientes por turno
- Signos vitales
- Medicamentos administrados
- Medicamentos no administrados
- Procedimientos
- Notas de enfermería
- Balance hídrico
- Actividades pendientes
- Incidencias

#### Indicadores

```
Pacientes atendidos              35
Medicamentos administrados       86
Medicamentos no administrados     3
Procedimientos realizados        42
Actividades pendientes            5
```

RF-ENF-39: El sistema deberá generar reportes de actividades de enfermería.

RF-ENF-40: El sistema deberá permitir filtrar información por paciente, enfermera, turno y fecha.

RF-ENF-41: El sistema deberá permitir exportar reportes.

### 15. Requerimientos consolidados

| Código | Requerimiento |
| --- | --- |
| RF-ENF-01 | Panel de enfermería |
| RF-ENF-02 | Mostrar actividades pendientes |
| RF-ENF-03 | Mostrar alertas |
| RF-ENF-04 | Asignar pacientes a enfermería |
| RF-ENF-05 | Gestionar turnos |
| RF-ENF-06 | Consultar pacientes asignados |
| RF-ENF-07 | Registrar valoración |
| RF-ENF-08 | Registrar valoraciones periódicas |
| RF-ENF-09 | Historial de valoraciones |
| RF-ENF-10 | Registrar signos vitales |
| RF-ENF-11 | Registrar profesional y fecha/hora |
| RF-ENF-12 | Historial de signos vitales |
| RF-ENF-13 | Alertas por valores fuera de rango |
| RF-ENF-14 | Crear plan de cuidados |
| RF-ENF-15 | Registrar actividades |
| RF-ENF-16 | Registrar cumplimiento |
| RF-ENF-17 | Consultar indicaciones médicas |
| RF-ENF-18 | Registrar ejecución |
| RF-ENF-19 | Trazabilidad de ejecución |
| RF-ENF-20 | Consultar medicamentos pendientes |
| RF-ENF-21 | Registrar administración |
| RF-ENF-22 | Registrar dosis, vía y horario |
| RF-ENF-23 | Identificar profesional |
| RF-ENF-24 | Registrar medicamentos no administrados |
| RF-ENF-25 | Registrar procedimientos |
| RF-ENF-26 | Identificar responsable |
| RF-ENF-27 | Historial de procedimientos |
| RF-ENF-28 | Registrar balance hídrico |
| RF-ENF-29 | Calcular balance |
| RF-ENF-30 | Historial de balances |
| RF-ENF-31 | Registrar notas de enfermería |
| RF-ENF-32 | Identificar fecha/profesional |
| RF-ENF-33 | Integrar notas a historia clínica |
| RF-ENF-34 | Entrega de turno |
| RF-ENF-35 | Mostrar pendientes |
| RF-ENF-36 | Identificar entrega/recepción |
| RF-ENF-37 | Generar alertas |
| RF-ENF-38 | Gestionar alertas |
| RF-ENF-39 | Reportes de enfermería |
| RF-ENF-40 | Filtros |
| RF-ENF-41 | Exportación |

### 16. Diseño de base de datos

Para mantener el sistema escalable, recomiendo separar las principales entidades:

ENFERMERA

```
   │
   └── TURNO_ENFERMERIA
             │
             └── ASIGNACION_PACIENTE
                       │
                       ↓
                   PACIENTE
                       │
              ┌────────┼─────────┐
              ↓        ↓         ↓
        VALORACION   SIGNOS    PLAN_CUIDADOS
              │
              ├── PROCEDIMIENTO
              │
              ├── NOTA_ENFERMERIA
              │
              └── BALANCE_HIDRICO
```

Para medicamentos:

INDICACION_MEDICA

       ↓

ADMINISTRACION_MEDICAMENTO

       ↓

ENFERMERA

Una posible estructura:

enfermera

turno_enfermeria

asignacion_enfermeria

valoracion_enfermeria

signo_vital

plan_cuidado

actividad_cuidado

administracion_medicamento

procedimiento_enfermeria

balance_hidrico

nota_enfermeria

entrega_turno

alerta_enfermeria

#### 🔗 Integración de los módulos

La arquitectura empieza a tomar una forma bastante completa:

1. LOGIN / USUARIOS / ROLES

              ↓

2. PACIENTES

              ↓

3. CITAS MÉDICAS

              ↓

4. MÉDICOS / ESPECIALIDADES

              ↓

5. HISTORIA CLÍNICA

              ↓

6. ADMISIÓN / EMERGENCIAS

              ↓

7. HOSPITALIZACIÓN

              ↓

8. ENFERMERÍA

              ↓

9. FARMACIA / MEDICAMENTOS

              ↓

10. LABORATORIO

              ↓

11. DIAGNÓSTICO POR IMÁGENES

              ↓

12. QUIRÓFANO / CIRUGÍA

              ↓

13. FACTURACIÓN / CAJA

              ↓

14. SEGUROS

              ↓

15. INVENTARIO / ALMACÉN

              ↓

16. REPORTES / ESTADÍSTICAS

El siguiente módulo lógico es el Módulo 9 – Farmacia y Medicamentos, donde conviene definir la gestión de medicamentos, recetas médicas, stock, dispensación a pacientes hospitalizados/ambulatorios y la integración con las administraciones registradas por Enfermería.

## Módulo 9 – Farmacia y Medicamentos

El Módulo de Farmacia y Medicamentos administra todo el ciclo del medicamento dentro del hospital:

MÉDICO

  ↓

PRESCRIPCIÓN / RECETA

  ↓

FARMACIA

  ↓

VALIDACIÓN

  ↓

DISPENSACIÓN

  ↓

PACIENTE

  ↓

ENFERMERÍA

  ↓

ADMINISTRACIÓN

Además, controla inventario, lotes, vencimientos, stock, devoluciones y trazabilidad.

### 1. Menú del módulo

Una estructura recomendable:

FARMACIA

```
│
├── Dashboard
├── Medicamentos
├── Categorías
├── Presentaciones
├── Laboratorios
├── Proveedores
├── Inventario
├── Lotes y vencimientos
├── Recetas médicas
├── Dispensación
├── Devoluciones
├── Transferencias
├── Ajustes de inventario
├── Kardex
├── Alertas
└── Reportes
```

### 2. Dashboard de Farmacia

Al ingresar, el usuario debería visualizar información importante.

```
┌──────────────────────────────────────┐
│       DASHBOARD DE FARMACIA          │
├──────────────────────────────────────┤
│ Medicamentos registrados       850   │
│ Stock disponible              4,250  │
│ Stock bajo                       18  │
│ Próximos a vencer               25   │
│ Recetas pendientes              32   │
│ Dispensaciones del día          86   │
└──────────────────────────────────────┘
```

También puede mostrar:
- Medicamentos con stock crítico.
- Medicamentos próximos a vencer.
- Recetas pendientes.
- Medicamentos más dispensados.
- Consumo por servicio.
- Consumo por período.

RF-FAR-01: El sistema deberá mostrar un dashboard con indicadores de farmacia.

RF-FAR-02: El sistema deberá mostrar alertas de stock bajo y vencimiento.

### 3. Maestro de medicamentos

Es el catálogo principal.

#### Datos

- Código del medicamento
- Código interno
- Nombre comercial
- Principio activo
- Concentración
- Forma farmacéutica
- Presentación
- Laboratorio
- Categoría
- Unidad de medida
- Requiere receta
- Control especial, si corresponde
- Estado

Ejemplo:

| Código | Medicamento | Concentración | Forma | Presentación |
| --- | --- | --- | --- | --- |
| MED-001 | Paracetamol | 500 mg | Tableta | Caja x 100 |
| MED-002 | Amoxicilina | 500 mg | Cápsula | Caja x 20 |
| MED-003 | Ibuprofeno | 400 mg | Tableta | Caja x 100 |

RF-FAR-03: El sistema deberá permitir registrar medicamentos.

RF-FAR-04: El sistema deberá permitir modificar la información del medicamento.

RF-FAR-05: El sistema deberá permitir activar o desactivar medicamentos.

RF-FAR-06: El código del medicamento deberá ser único.

### 4. Principio activo

Es recomendable separar el medicamento de su principio activo.

Por ejemplo:

Principio activo:

PARACETAMOL

Medicamentos:

```
├── Paracetamol 500 mg - Laboratorio A
├── Paracetamol 500 mg - Laboratorio B
└── Paracetamol 1 g - Laboratorio C
```

Esto permitirá posteriormente generar reportes de consumo por principio activo.

### 5. Presentaciones

Un mismo medicamento puede tener diferentes presentaciones.

Ejemplo:

Paracetamol 500 mg

```
├── Tableta x 20
├── Tableta x 100
└── Frasco x 100
```

RF-FAR-07: El sistema deberá permitir administrar diferentes presentaciones de un medicamento.

### 6. Categorías

Permite clasificar medicamentos.

Ejemplos:
- Analgésicos
- Antibióticos
- Antiinflamatorios
- Antihistamínicos
- Cardiovasculares
- Antidiabéticos
- Antisépticos
- Otros

RF-FAR-08: El sistema deberá permitir administrar categorías de medicamentos.

### 7. Laboratorios

Debe registrarse el fabricante del medicamento.

Datos:
- Código
- Razón social
- RUC
- Dirección
- Teléfono
- Email
- Estado

RF-FAR-09: El sistema deberá permitir registrar laboratorios fabricantes.

### 8. Proveedores

Farmacia puede recibir medicamentos provenientes del almacén o directamente de proveedores, dependiendo del modelo del hospital.

Datos:
- RUC
- Razón social
- Contacto
- Teléfono
- Email
- Dirección
- Estado

RF-FAR-10: El sistema deberá permitir registrar proveedores de medicamentos.

### 9. Inventario

El inventario debe manejar cantidades y lotes.

Ejemplo:

Paracetamol 500 mg

Lote: PA2026001

Vencimiento: 05/2028

Stock: 500

Lote: PA2026002

Vencimiento: 09/2027

Stock: 200

No recomiendo guardar simplemente:

paracetamol.stock = 700

Es mejor manejar:

MEDICAMENTO

     ↓

LOTE

     ↓

MOVIMIENTOS

     ↓

STOCK

### 10. Lotes y fechas de vencimiento

Esta es una función crítica.

Cada ingreso debe registrar:
- Medicamento
- Lote
- Fecha de fabricación
- Fecha de vencimiento
- Cantidad
- Costo
- Proveedor
- Fecha de ingreso

Ejemplo:

| Medicamento | Lote | Vencimiento | Stock |
| --- | --- | --- | --- |
| Paracetamol | PA001 | 05/2027 | 500 |
| Paracetamol | PA002 | 11/2027 | 300 |
| Amoxicilina | AM001 | 02/2027 | 150 |

RF-FAR-11: El sistema deberá registrar lotes de medicamentos.

RF-FAR-12: El sistema deberá registrar fechas de vencimiento.

RF-FAR-13: El sistema deberá generar alertas de medicamentos próximos a vencer.

RF-FAR-14: El sistema deberá impedir la dispensación de medicamentos vencidos.

### 11. Control FEFO

Para farmacia recomiendo implementar FEFO:

First Expired, First Out

Es decir, debe salir primero el lote que vence primero.

Ejemplo:

Paracetamol

```
Lote A → vence 03/2027 → 100 unidades
Lote B → vence 08/2027 → 200 unidades
Lote C → vence 12/2027 → 300 unidades
```

Dispensación:

       ↓

Primero Lote A

       ↓

Luego Lote B

       ↓

Luego Lote C

Esto ayuda a reducir pérdidas por vencimiento.

### 12. Receta médica

La receta debe estar vinculada a la consulta médica.

HISTORIA CLÍNICA

      ↓

CONSULTA

      ↓

PRESCRIPCIÓN

      ↓

RECETA

      ↓

FARMACIA

Datos:
- Número de receta
- Paciente
- Historia clínica
- Médico
- Consulta
- Fecha
- Medicamento
- Dosis
- Frecuencia
- Duración
- Vía
- Cantidad
- Indicaciones
- Estado

Ejemplo:

RECETA Nº REC-000125

Paciente:

Juan Pérez

Medicamento:

Paracetamol 500 mg

Dosis:

1 tableta

Frecuencia:

Cada 8 horas

Duración:

5 días

Cantidad:

15 tabletas

RF-FAR-15: El sistema deberá recibir recetas generadas por los médicos.

RF-FAR-16: Cada receta deberá estar asociada al paciente.

RF-FAR-17: La receta deberá identificar al médico prescriptor.

RF-FAR-18: El sistema deberá registrar medicamentos, dosis, frecuencia, duración y cantidad.

### 13. Estados de la receta

PENDIENTE

    ↓

VALIDADA

    ↓

DISPENSADA

También:

PARCIALMENTE DISPENSADA

CANCELADA

RECHAZADA

Ejemplo:

Receta:

10 medicamentos

Farmacia:

6 disponibles

4 no disponibles

Estado:

PARCIALMENTE DISPENSADA

RF-FAR-19: El sistema deberá gestionar el estado de las recetas.

RF-FAR-20: El sistema deberá permitir dispensación parcial cuando corresponda.

### 14. Dispensación

El farmacéutico selecciona una receta y realiza la entrega.

Ejemplo:

RECETA REC-000125

Paracetamol 500 mg

Solicitado: 15

Disponible: 100

Entregar: 15

Lote:

PA2026001

Vencimiento:

05/2027

Al confirmar:

Stock anterior: 100

Cantidad entregada: 15

Stock nuevo: 85

RF-FAR-21: El sistema deberá permitir dispensar medicamentos asociados a una receta.

RF-FAR-22: El sistema deberá registrar cantidad dispensada.

RF-FAR-23: El sistema deberá registrar el lote utilizado.

RF-FAR-24: El sistema deberá actualizar automáticamente el stock.

RF-FAR-25: El sistema deberá identificar al usuario que realizó la dispensación.

### 15. Dispensación para pacientes hospitalizados

Aquí aparece una integración muy importante con los módulos anteriores.

MÉDICO

   ↓

INDICACIÓN

   ↓

FARMACIA

   ↓

DISPENSACIÓN

   ↓

ENFERMERÍA

   ↓

ADMINISTRACIÓN

Por ejemplo:

Hospitalización HOSP-00125

Paciente: Juan Pérez

Cama: 201-A

Paracetamol 500 mg

Cantidad dispensada: 10

       ↓

ENFERMERÍA

```
08:00 → Administrado
16:00 → Administrado
00:00 → Pendiente
```

Farmacia dispensa.

Enfermería administra.

Son procesos diferentes.

### 16. Devolución de medicamentos

Puede ocurrir que un medicamento dispensado no sea utilizado.

Ejemplo:

Dispensado: 20

Utilizado: 15

Devuelto: 5

La devolución debe registrar:
- Receta
- Paciente
- Medicamento
- Lote
- Cantidad
- Motivo
- Fecha
- Usuario

RF-FAR-26: El sistema deberá permitir registrar devoluciones de medicamentos.

RF-FAR-27: El sistema deberá actualizar el stock según las condiciones de devolución.

### 17. Ajustes de inventario

Puede existir diferencia entre stock físico y stock del sistema.

Ejemplo:

Stock sistema: 100

```
Stock físico:   98
Diferencia:     -2
```

El ajuste debe requerir:
- Medicamento
- Lote
- Stock sistema
- Stock físico
- Diferencia
- Motivo
- Usuario
- Fecha
- Autorización, si corresponde

RF-FAR-28: El sistema deberá permitir registrar ajustes de inventario.

RF-FAR-29: El sistema deberá solicitar un motivo para cada ajuste.

RF-FAR-30: El sistema deberá registrar auditoría de los ajustes.

### 18. Kardex de medicamentos

El Kardex permitirá conocer todos los movimientos.

Ejemplo:

| Fecha | Movimiento | Lote | Entrada | Salida | Saldo |
| --- | --- | --- | --- | --- | --- |
| 01/09 | Compra | A001 | 500 | 0 | 500 |
| 02/09 | Dispensación | A001 | 0 | 50 | 450 |
| 03/09 | Dispensación | A001 | 0 | 30 | 420 |
| 04/09 | Devolución | A001 | 10 | 0 | 430 |

RF-FAR-31: El sistema deberá registrar todos los movimientos de inventario.

RF-FAR-32: El sistema deberá generar Kardex por medicamento y lote.

### 19. Alertas

El sistema debe generar alertas para:

🔴 STOCK AGOTADO

🟠 STOCK MÍNIMO

🟡 PRÓXIMO A VENCER

🔴 MEDICAMENTO VENCIDO

🟡 RECETA PENDIENTE

🟠 DISPENSACIÓN PARCIAL

RF-FAR-33: El sistema deberá generar alertas de stock mínimo.

RF-FAR-34: El sistema deberá generar alertas de vencimiento.

### 20. Reportes

#### Reportes de inventario

- Stock actual
- Stock mínimo
- Stock crítico
- Medicamentos vencidos
- Próximos a vencer
- Inventario valorizado

#### Reportes de dispensación

- Dispensaciones diarias
- Dispensaciones por paciente
- Dispensaciones por médico
- Dispensaciones por servicio
- Medicamentos más utilizados

#### Reportes de consumo

Medicamento       Cantidad

--------------------------------

```
Paracetamol          2,500
Amoxicilina            850
Ibuprofeno           1,200
```

RF-FAR-35: El sistema deberá generar reportes de inventario.

RF-FAR-36: El sistema deberá generar reportes de dispensación.

RF-FAR-37: El sistema deberá generar reportes de consumo.

RF-FAR-38: El sistema deberá permitir exportar reportes a PDF y Excel.

### 21. Requerimientos consolidados

| Código | Requerimiento |
| --- | --- |
| RF-FAR-01 | Dashboard de farmacia |
| RF-FAR-02 | Alertas generales |
| RF-FAR-03 | Registrar medicamentos |
| RF-FAR-04 | Modificar medicamentos |
| RF-FAR-05 | Activar/desactivar medicamentos |
| RF-FAR-06 | Código único |
| RF-FAR-07 | Gestionar presentaciones |
| RF-FAR-08 | Gestionar categorías |
| RF-FAR-09 | Gestionar laboratorios |
| RF-FAR-10 | Gestionar proveedores |
| RF-FAR-11 | Registrar lotes |
| RF-FAR-12 | Registrar vencimientos |
| RF-FAR-13 | Alertar vencimientos |
| RF-FAR-14 | Bloquear medicamentos vencidos |
| RF-FAR-15 | Recibir recetas médicas |
| RF-FAR-16 | Asociar receta al paciente |
| RF-FAR-17 | Identificar médico |
| RF-FAR-18 | Registrar prescripción |
| RF-FAR-19 | Gestionar estados de receta |
| RF-FAR-20 | Dispensación parcial |
| RF-FAR-21 | Dispensar medicamentos |
| RF-FAR-22 | Registrar cantidad |
| RF-FAR-23 | Registrar lote |
| RF-FAR-24 | Actualizar stock |
| RF-FAR-25 | Identificar dispensador |
| RF-FAR-26 | Registrar devoluciones |
| RF-FAR-27 | Actualizar stock por devolución |
| RF-FAR-28 | Ajustar inventario |
| RF-FAR-29 | Registrar motivo |
| RF-FAR-30 | Auditar ajustes |
| RF-FAR-31 | Registrar movimientos |
| RF-FAR-32 | Generar Kardex |
| RF-FAR-33 | Alertas de stock |
| RF-FAR-34 | Alertas de vencimiento |
| RF-FAR-35 | Reportes de inventario |
| RF-FAR-36 | Reportes de dispensación |
| RF-FAR-37 | Reportes de consumo |
| RF-FAR-38 | Exportar reportes |

### 22. Diseño de base de datos recomendado

Para este módulo recomiendo como mínimo:

MEDICAMENTO

```
   │
   ├── PRINCIPIO_ACTIVO
   ├── PRESENTACION
   ├── CATEGORIA
   └── LABORATORIO
          │
          ↓
        LOTE
          │
          ↓
    MOVIMIENTO_STOCK
```

Para recetas:

PACIENTE

   ↓

HISTORIA_CLINICA

   ↓

CONSULTA_MEDICA

   ↓

RECETA

   ↓

DETALLE_RECETA

   ↓

MEDICAMENTO

Para dispensación:

RECETA

   ↓

DISPENSACION

   ↓

DETALLE_DISPENSACION

   ↓

LOTE

   ↓

MOVIMIENTO_STOCK

Y para hospitalización:

INDICACION_MEDICA

       ↓

SOLICITUD_FARMACIA

       ↓

DISPENSACION

       ↓

ENFERMERÍA

       ↓

ADMINISTRACION_MEDICAMENTO

### 23. Tablas principales

Una propuesta inicial sería:

medicamento

principio_activo

categoria_medicamento

presentacion_medicamento

laboratorio

proveedor

lote_medicamento

stock_medicamento

movimiento_stock

receta

detalle_receta

dispensacion

detalle_dispensacion

devolucion_medicamento

detalle_devolucion

ajuste_inventario

detalle_ajuste

#### ⚠️ Recomendación importante

No mezclar Farmacia con Almacén.

La separación puede ser:

ALMACÉN

   ↓

Recepción de medicamentos

   ↓

Ingreso de lote

   ↓

Transferencia

   ↓

FARMACIA

   ↓

Stock de farmacia

   ↓

Dispensación

   ↓

ENFERMERÍA

De esta manera, el Módulo 15 – Inventario y Almacén podrá administrar las compras, recepción y distribución general, mientras que Farmacia se concentra en el manejo clínico y dispensación de medicamentos.

#### 🔗 Integración con los módulos anteriores

MÓDULO 2 – PACIENTES

          ↓

MÓDULO 5 – HISTORIA CLÍNICA

          ↓

MÓDULO 7 – HOSPITALIZACIÓN

```
          ↓
MÉDICO → INDICACIÓN / RECETA
          ↓
```

MÓDULO 9 – FARMACIA

          ↓

DISPENSACIÓN

          ↓

MÓDULO 8 – ENFERMERÍA

          ↓

ADMINISTRACIÓN DEL MEDICAMENTO

          ↓

HISTORIA CLÍNICA

#### 🧪 Módulo 10 – Laboratorio Clínico

El Módulo de Laboratorio Clínico administra el proceso completo de los exámenes de laboratorio solicitados a un paciente, desde la orden médica hasta la validación y entrega de resultados.

Este módulo debe integrarse principalmente con:
- Pacientes
- Historia Clínica
- Citas Médicas
- Hospitalización
- Farmacia, cuando corresponda
## Módulo 10 – Laboratorio Clínico
- Reportes

### 1. Flujo general

PACIENTE

   ↓

CONSULTA MÉDICA

   ↓

MÉDICO SOLICITA EXAMEN

   ↓

ORDEN DE LABORATORIO

   ↓

PROGRAMACIÓN / RECEPCIÓN

   ↓

TOMA DE MUESTRA

   ↓

PROCESAMIENTO

   ↓

REGISTRO DE RESULTADOS

   ↓

VALIDACIÓN

   ↓

INFORME DE LABORATORIO

   ↓

HISTORIA CLÍNICA

   ↓

MÉDICO CONSULTA RESULTADOS

Para un paciente hospitalizado:

HOSPITALIZACIÓN

      ↓

INDICACIÓN MÉDICA

      ↓

LABORATORIO

      ↓

TOMA DE MUESTRA

      ↓

RESULTADO

      ↓

HISTORIA CLÍNICA

### 2. Menú del módulo

Una estructura recomendable sería:

LABORATORIO

```
│
├── Dashboard
├── Órdenes de laboratorio
├── Solicitudes pendientes
├── Agenda / Programación
├── Toma de muestras
├── Muestras
├── Procesamiento
├── Resultados
├── Validación
├── Catálogo de exámenes
├── Perfiles / Paquetes
├── Valores de referencia
├── Laboratoristas
├── Equipos
├── Incidencias
├── Resultados críticos
└── Reportes
```

### 3. Dashboard del laboratorio

El dashboard permitirá conocer rápidamente el estado del laboratorio.

```
┌───────────────────────────────────────┐
│       DASHBOARD DE LABORATORIO        │
├───────────────────────────────────────┤
│ Órdenes del día                 85    │
│ Pendientes de toma              18    │
│ Muestras recibidas              65    │
│ En procesamiento                32    │
│ Resultados pendientes           24    │
│ Pendientes de validación         8    │
│ Resultados críticos              2    │
└───────────────────────────────────────┘
```

También puede mostrar:
- Exámenes realizados por día.
- Exámenes pendientes.
- Muestras rechazadas.
- Resultados críticos.
- Tiempo promedio de procesamiento.
- Exámenes más solicitados.

RF-LAB-01: El sistema deberá mostrar un dashboard del laboratorio.

RF-LAB-02: El sistema deberá mostrar las órdenes y muestras pendientes.

RF-LAB-03: El sistema deberá mostrar alertas de resultados críticos.

### 4. Catálogo de exámenes

Es uno de los maestros principales del módulo.

Ejemplos:

HEMATOLOGÍA

```
├── Hemograma completo
├── Hemoglobina
├── Hematocrito
└── Plaquetas
```

BIOQUÍMICA

```
├── Glucosa
├── Creatinina
├── Urea
└── Colesterol
```

INMUNOLOGÍA

```
├── PCR
├── Factor reumatoide
└── Otros
```

MICROBIOLOGÍA

```
├── Urocultivo
├── Hemocultivo
└── Coprocultivo
```

Cada examen debería tener:
- Código
- Nombre
- Categoría
- Descripción
- Tipo de muestra
- Unidad de medida
- Método
- Tiempo estimado
- Estado
- Requiere ayuno
- Instrucciones para el paciente

RF-LAB-04: El sistema deberá permitir registrar exámenes de laboratorio.

RF-LAB-05: El sistema deberá permitir clasificar los exámenes.

RF-LAB-06: El sistema deberá registrar el tipo de muestra requerido.

RF-LAB-07: El sistema deberá registrar las condiciones necesarias para realizar el examen.

### 5. Tipos de muestras

El sistema debe administrar diferentes tipos de muestras.

Por ejemplo:
- Sangre
- Orina
- Heces
- Esputo
- Secreciones
- Plasma
- Suero
- Otros

Cada examen deberá indicar qué muestra requiere.

Ejemplo:

| Examen | Muestra |
| --- | --- |
| Hemograma | Sangre |
| Glucosa | Sangre |
| Examen de orina | Orina |
| Coprocultivo | Heces |
| Urocultivo | Orina |

RF-LAB-08: El sistema deberá administrar los tipos de muestras.

### 6. Solicitud / orden de laboratorio

La solicitud normalmente es generada por el médico.

Debe estar relacionada con la consulta.

PACIENTE

   ↓

HISTORIA CLÍNICA

   ↓

CONSULTA MÉDICA

   ↓

ORDEN LABORATORIO

#### Datos

- Número de orden
- Paciente
- Historia clínica
- Médico solicitante
- Especialidad
- Consulta
- Fecha
- Prioridad
- Diagnóstico
- Observaciones
- Exámenes solicitados
- Estado

Ejemplo:

ORDEN: LAB-000245

Paciente:

Juan Pérez

Médico:

Dr. Carlos García

Exámenes:

☑ Hemograma

☑ Glucosa

☑ Creatinina

☑ Perfil lipídico

Prioridad:

Normal

#### Prioridades

NORMAL

URGENTE

STAT / CRÍTICA

Los niveles exactos deben ser configurables según el establecimiento.

RF-LAB-09: El sistema deberá permitir registrar órdenes de laboratorio.

RF-LAB-10: La orden deberá estar asociada al paciente.

RF-LAB-11: La orden deberá identificar al médico solicitante.

RF-LAB-12: El sistema deberá permitir seleccionar múltiples exámenes.

RF-LAB-13: El sistema deberá permitir establecer la prioridad.

### 7. Estados de la orden

Una orden puede pasar por diferentes estados:

SOLICITADA

    ↓

PROGRAMADA

    ↓

PENDIENTE DE MUESTRA

    ↓

MUESTRA RECIBIDA

    ↓

EN PROCESAMIENTO

    ↓

RESULTADO REGISTRADO

    ↓

VALIDADA

    ↓

ENTREGADA

También:

CANCELADA

RECHAZADA

Esto permite conocer exactamente en qué etapa se encuentra cada examen.

### 8. Programación del examen

Cuando corresponda, el laboratorio puede programar la atención.

Datos:
- Paciente
- Orden
- Examen
- Fecha
- Hora
- Área
- Personal asignado
- Estado

Para determinados exámenes puede requerirse preparación previa.

Ejemplo:

Paciente:

María López

Examen:

Perfil lipídico

Fecha:

07/09/2026

Hora:

08:00

Preparación:

Ayuno según indicación del establecimiento.

RF-LAB-14: El sistema deberá permitir programar exámenes.

RF-LAB-15: El sistema deberá registrar fecha y hora de atención.

### 9. Recepción y toma de muestra

Este proceso es crítico.

Al recibir al paciente se debe verificar:
- Identidad
- Orden
- Exámenes
- Tipo de muestra
- Preparación
- Fecha y hora

Luego se registra la muestra.

#### Datos de muestra

- Código de muestra
- Orden
- Paciente
- Tipo de muestra
- Fecha/hora de toma
- Personal responsable
- Condición
- Observaciones

Ejemplo:

MUESTRA: MUE-000458

Paciente:

Juan Pérez

Tipo:

Sangre

Toma:

06/09/2026 08:15

Responsable:

Laboratorista Ana Torres

Estado:

RECIBIDA

RF-LAB-16: El sistema deberá registrar la toma de muestras.

RF-LAB-17: El sistema deberá generar un código único para la muestra.

RF-LAB-18: El sistema deberá registrar fecha, hora y responsable.

### 10. Identificación de muestras

Es recomendable que cada muestra tenga un identificador único.

ORDEN

LAB-000245

      ↓

MUESTRA

MUE-000458

Una orden puede tener varias muestras.

Ejemplo:

Orden LAB-000245

```
│
├── MUE-001 → Sangre
├── MUE-002 → Orina
└── MUE-003 → Heces
```

Esto es mejor que colocar toda la información directamente en la orden.

### 11. Rechazo de muestras

Una muestra puede ser rechazada por:
- Muestra insuficiente
- Muestra incorrecta
- Muestra contaminada
- Recipiente incorrecto
- Identificación incorrecta
- Muestra deteriorada
- Tiempo excedido
- Otras causas

Ejemplo:

MUE-000458

Estado:

RECHAZADA

Motivo:

Muestra insuficiente.

Acción:

Solicitar nueva muestra.

RF-LAB-19: El sistema deberá permitir rechazar muestras.

RF-LAB-20: El sistema deberá exigir el motivo del rechazo.

RF-LAB-21: El sistema deberá permitir solicitar una nueva muestra.

### 12. Procesamiento

El laboratorista podrá visualizar los exámenes pendientes.

Ejemplo:

| Muestra | Paciente | Examen | Estado |
| --- | --- | --- | --- |
| MUE-001 | Juan Pérez | Hemograma | Pendiente |
| MUE-002 | María López | Glucosa | Procesando |
| MUE-003 | Pedro Díaz | Creatinina | Pendiente |

El laboratorista selecciona la muestra y registra el procesamiento.

RF-LAB-22: El sistema deberá mostrar las muestras pendientes de procesamiento.

RF-LAB-23: El sistema deberá registrar el inicio del procesamiento.

RF-LAB-24: El sistema deberá registrar la finalización del procesamiento.

### 13. Registro de resultados

Los resultados pueden ser:

#### Numéricos

Glucosa

Resultado: 98

Unidad: mg/dL

#### Texto

Observación:

No se observan alteraciones significativas.

#### Positivo / negativo

Resultado: NEGATIVO

#### Cualitativos

Color: Amarillo

Aspecto: Claro

### 14. Valores de referencia

El sistema debe permitir configurar rangos de referencia.

Ejemplo:

| Examen | Resultado | Unidad | Referencia |
| --- | --- | --- | --- |
| Glucosa | 98 | mg/dL | Según configuración |
| Hemoglobina | 14.2 | g/dL | Según configuración |
| Creatinina | 0.9 | mg/dL | Según configuración |

Importante: los valores de referencia pueden depender de características como edad, sexo, método y laboratorio. Por ello, conviene que sean configurables y no valores rígidos en el código.

RF-LAB-25: El sistema deberá permitir registrar valores de referencia.

RF-LAB-26: El sistema deberá comparar el resultado con el rango configurado cuando corresponda.

RF-LAB-27: El sistema deberá identificar resultados fuera de rango.

### 15. Resultado fuera de rango

El sistema puede marcar:

NORMAL

BAJO

ALTO

CRÍTICO

Ejemplo:

Glucosa

Resultado: 250 mg/dL

Estado:

ALTO

Pero el sistema no debe diagnosticar automáticamente al paciente. La interpretación clínica corresponde al profesional de salud.

### 16. Resultados críticos

Algunos resultados requieren atención inmediata.

Ejemplo:

🔴 RESULTADO CRÍTICO

Paciente:

Juan Pérez

Examen:

Glucosa

Resultado:

420 mg/dL

Fecha:

06/09/2026 10:35

El sistema puede generar una alerta al personal autorizado y registrar que el resultado crítico fue comunicado, según el protocolo del establecimiento.

RF-LAB-28: El sistema deberá permitir identificar resultados críticos según parámetros configurados.

RF-LAB-29: El sistema deberá generar una alerta para resultados críticos.

RF-LAB-30: El sistema deberá registrar la gestión o comunicación del resultado crítico cuando el protocolo lo requiera.

### 17. Validación de resultados

El laboratorista registra el resultado, pero puede requerirse una validación antes de publicarlo.

Flujo:

RESULTADO REGISTRADO

       ↓

REVISIÓN

       ↓

VALIDACIÓN

       ↓

RESULTADO DISPONIBLE

Debe quedar registrado:
- Quién registró
- Quién validó
- Fecha/hora
- Observaciones
- Versión del resultado

RF-LAB-31: El sistema deberá permitir validar resultados.

RF-LAB-32: El sistema deberá registrar al profesional que valida.

RF-LAB-33: El sistema deberá impedir modificar silenciosamente un resultado validado.

### 18. Corrección de resultados

Si existe un error después de la validación, no recomiendo simplemente sobrescribir:

Resultado anterior: 120

Resultado nuevo:     102

Es mejor conservar la trazabilidad:

Versión 1

Resultado: 120

Registrado por: Usuario A

       ↓ Corrección

Versión 2

Resultado: 102

Corregido por: Usuario B

Motivo: Error de digitación

Esto es especialmente importante para auditoría clínica.

### 19. Informe de laboratorio

Una vez validados los resultados, el sistema puede generar un informe.

Ejemplo:

========================================

       INFORME DE LABORATORIO

========================================

Paciente: Juan Pérez

Historia Clínica: HC-000125

Orden: LAB-000245

Fecha: 06/09/2026

EXAMEN             RESULTADO     UNIDAD

------------------------------------------------

```
Glucosa               98         mg/dL
Creatinina             0.9       mg/dL
Hemoglobina           14.2       g/dL
```

Observaciones:

...

Laboratorista:

Ana Torres

Validado por:

Dr./Profesional autorizado

========================================

RF-LAB-34: El sistema deberá generar informes de laboratorio.

RF-LAB-35: El informe deberá incluir paciente, orden, resultados y responsables.

RF-LAB-36: El sistema deberá permitir generar el informe en PDF.

### 20. Integración con Historia Clínica

Este es uno de los puntos más importantes.

HISTORIA CLÍNICA

      ↓

CONSULTA

      ↓

SOLICITUD LABORATORIO

      ↓

RESULTADO

      ↓

HISTORIA CLÍNICA

El médico podrá consultar:

Paciente: Juan Pérez

Laboratorio

────────────────────────

06/09/2026

Hemograma

Glucosa

Creatinina

Ver resultados →

Los resultados validados deben quedar disponibles en la historia clínica del paciente.

RF-LAB-37: El sistema deberá integrar los resultados con la historia clínica.

RF-LAB-38: El médico autorizado deberá poder consultar los resultados del paciente.

### 21. Integración con Hospitalización

Para pacientes internados:

PACIENTE HOSPITALIZADO

       ↓

MÉDICO

       ↓

SOLICITUD DE EXAMEN

       ↓

LABORATORIO

       ↓

MUESTRA

       ↓

RESULTADO

       ↓

HISTORIA CLÍNICA

El laboratorio deberá poder identificar:
- Habitación
- Cama
- Servicio
- Médico tratante
- Hospitalización

Esto facilita la atención de solicitudes urgentes.

### 22. Integración con Facturación

Dependiendo del modelo del hospital:

ORDEN LABORATORIO

       ↓

EXÁMENES

       ↓

COSTOS

       ↓

FACTURACIÓN

Por ejemplo:

```
Hemograma        S/ 25
Glucosa          S/ 15
Creatinina       S/ 18
```

----------------------

Total            S/ 58

En pacientes asegurados, el tratamiento de cobertura debe integrarse posteriormente con Seguros.

### 23. Equipos de laboratorio

Para una versión más avanzada, se pueden administrar los equipos.

Datos:
- Código
- Nombre
- Marca
- Modelo
- Número de serie
- Ubicación
- Estado
- Fecha de calibración
- Próxima calibración
- Responsable

Ejemplo:

Equipo:

Analizador hematológico

Estado:

OPERATIVO

Última calibración:

01/08/2026

Próxima calibración:

01/11/2026

RF-LAB-39: El sistema deberá permitir registrar equipos de laboratorio.

RF-LAB-40: El sistema deberá registrar el mantenimiento/calibración cuando corresponda.

### 24. Incidencias

Debe existir un registro de incidencias.

Ejemplos:
- Equipo fuera de servicio
- Muestra perdida
- Error de identificación
- Reactivo no disponible
- Resultado repetido
- Muestra rechazada

INCIDENCIA #INC-0025

Equipo:

Analizador X

Descripción:

Equipo fuera de servicio.

Fecha:

06/09/2026

Responsable:

Laboratorio

RF-LAB-41: El sistema deberá permitir registrar incidencias.

### 25. Reportes

#### Reportes operativos

- Órdenes del día.
- Muestras pendientes.
- Muestras rechazadas.
- Exámenes procesados.
- Resultados pendientes.
- Resultados validados.

#### Reportes estadísticos

- Exámenes por período.
- Exámenes por especialidad.
- Exámenes por médico.
- Exámenes por servicio.
- Exámenes más solicitados.
- Tiempo promedio de procesamiento.

#### Reportes de calidad

- Muestras rechazadas.
- Resultados corregidos.
- Resultados críticos.
- Incidencias.
- Tiempo de respuesta.

RF-LAB-42: El sistema deberá generar reportes operativos.

RF-LAB-43: El sistema deberá generar reportes estadísticos.

RF-LAB-44: El sistema deberá generar reportes de calidad.

RF-LAB-45: El sistema deberá permitir exportar reportes.

### 26. Requerimientos consolidados

| Código | Requerimiento |
| --- | --- |
| RF-LAB-01 | Dashboard de laboratorio |
| RF-LAB-02 | Mostrar órdenes y muestras pendientes |
| RF-LAB-03 | Alertas |
| RF-LAB-04 | Catálogo de exámenes |
| RF-LAB-05 | Clasificar exámenes |
| RF-LAB-06 | Tipo de muestra |
| RF-LAB-07 | Condiciones del examen |
| RF-LAB-08 | Gestionar tipos de muestras |
| RF-LAB-09 | Registrar órdenes |
| RF-LAB-10 | Asociar orden al paciente |
| RF-LAB-11 | Identificar médico solicitante |
| RF-LAB-12 | Registrar múltiples exámenes |
| RF-LAB-13 | Definir prioridad |
| RF-LAB-14 | Programar exámenes |
| RF-LAB-15 | Registrar fecha/hora |
| RF-LAB-16 | Registrar toma de muestra |
| RF-LAB-17 | Generar código de muestra |
| RF-LAB-18 | Registrar responsable |
| RF-LAB-19 | Rechazar muestras |
| RF-LAB-20 | Registrar motivo de rechazo |
| RF-LAB-21 | Solicitar nueva muestra |
| RF-LAB-22 | Gestionar procesamiento |
| RF-LAB-23 | Registrar inicio |
| RF-LAB-24 | Registrar finalización |
| RF-LAB-25 | Registrar valores de referencia |
| RF-LAB-26 | Comparar resultados |
| RF-LAB-27 | Identificar resultados fuera de rango |
| RF-LAB-28 | Identificar resultados críticos |
| RF-LAB-29 | Generar alertas |
| RF-LAB-30 | Registrar comunicación/gestión |
| RF-LAB-31 | Validar resultados |
| RF-LAB-32 | Registrar validador |
| RF-LAB-33 | Controlar modificaciones |
| RF-LAB-34 | Generar informes |
| RF-LAB-35 | Datos completos del informe |
| RF-LAB-36 | Generar PDF |
| RF-LAB-37 | Integrar con Historia Clínica |
| RF-LAB-38 | Consulta de resultados |
| RF-LAB-39 | Gestionar equipos |
| RF-LAB-40 | Control de calibración/mantenimiento |
| RF-LAB-41 | Registrar incidencias |
| RF-LAB-42 | Reportes operativos |
| RF-LAB-43 | Reportes estadísticos |
| RF-LAB-44 | Reportes de calidad |
| RF-LAB-45 | Exportación |

### 27. Diseño de base de datos recomendado

Aquí conviene separar claramente orden, muestra, examen y resultado.

PACIENTE

```
   │
   ↓
```

CONSULTA_MEDICA

```
   │
   ↓
```

ORDEN_LABORATORIO

```
   │
   ├───────────────┐
   ↓               ↓
DETALLE_ORDEN    MUESTRA
   │               │
   ↓               ↓
EXAMEN          PROCESAMIENTO
   │               │
   └───────┬───────┘
           ↓
        RESULTADO
           ↓
       VALIDACIÓN
           ↓
        INFORME
```

#### Tablas principales

examen_laboratorio

categoria_examen

tipo_muestra

valor_referencia

orden_laboratorio

detalle_orden_laboratorio

muestra

tipo_muestra

rechazo_muestra

procesamiento_muestra

resultado_laboratorio

validacion_resultado

historial_resultado

equipo_laboratorio

mantenimiento_equipo

incidencia_laboratorio

### 28. Una consideración importante para tu diseño

Yo utilizaría esta separación:

#### Médico

SOLICITA

#### Laboratorio

RECIBE

TOMA MUESTRA

PROCESA

REGISTRA RESULTADO

VALIDA

#### Médico

CONSULTA RESULTADO

INTERPRETA CLÍNICAMENTE

Es decir, Laboratorio no debería registrar diagnósticos médicos basándose automáticamente en un resultado. El resultado pertenece al laboratorio y su interpretación clínica corresponde al profesional autorizado.

#### 🔗 Integración general hasta el Módulo 10

```
                    PACIENTE
                       │
             ┌─────────┴─────────┐
             ↓                   ↓
           CITAS              EMERGENCIA
             │                   │
             └─────────┬─────────┘
                       ↓
                HISTORIA CLÍNICA
                       │
             ┌─────────┴──────────┐
             ↓                    ↓
       CONSULTA MÉDICA       HOSPITALIZACIÓN
             │                    │
             ↓                    ↓
       ORDEN LABORATORIO    INDICACIÓN MÉDICA
             │                    │
             └─────────┬──────────┘
                       ↓
                 LABORATORIO
                       │
              ┌────────┼────────┐
              ↓        ↓        ↓
           MUESTRA  PROCESO  RESULTADO
                                │
                                ↓
                         VALIDACIÓN
                                │
                                ↓
                       HISTORIA CLÍNICA
```

## MÓDULO 11 – DIAGNÓSTICO POR IMÁGENES

### 1. Objetivo del módulo

El módulo de Diagnóstico por Imágenes permitirá gestionar todo el proceso relacionado con los estudios de imágenes médicas, desde la solicitud realizada por el médico hasta la generación, validación y entrega del informe.

Permitirá administrar estudios como:
- Radiografía.
- Ecografía.
- Tomografía computarizada.
- Resonancia magnética.
- Mamografía.
- Densitometría ósea.
- Otros estudios configurables.

El módulo deberá integrarse principalmente con:

Paciente → Historia Clínica → Consulta Médica → Solicitud de Estudio → Programación → Realización → Imágenes → Informe → Validación → Historia Clínica

### 2. Flujo principal

MÉDICO

```
   │
   ▼
```

CONSULTA MÉDICA

```
   │
   ▼
```

SOLICITUD DE ESTUDIO

```
   │
   ▼
```

PROGRAMACIÓN

```
   │
   ▼
```

RECEPCIÓN DEL PACIENTE

```
   │
   ▼
```

REALIZACIÓN DEL ESTUDIO

```
   │
   ▼
```

ADQUISICIÓN DE IMÁGENES

```
   │
   ▼
```

INTERPRETACIÓN

```
   │
   ▼
```

INFORME RADIOLÓGICO

```
   │
   ▼
```

VALIDACIÓN

```
   │
   ▼
```

RESULTADO

```
   │
   ├──────────────► HISTORIA CLÍNICA
   │
   └──────────────► PACIENTE / MÉDICO
```

### 3. Menú del módulo

Una propuesta de menú sería:

DIAGNÓSTICO POR IMÁGENES

```
│
├── Dashboard
│
├── Solicitudes de estudios
│
├── Agenda / Programación
│
├── Pacientes
│
├── Estudios realizados
│
├── Radiología
│
├── Ecografía
│
├── Tomografía
│
├── Resonancia Magnética
│
├── Mamografía
│
├── Densitometría
│
├── Imágenes
│
├── Informes radiológicos
│
├── Validación de informes
│
├── Resultados
│
├── Equipos
│
├── Mantenimiento
│
├── Incidencias
│
└── Reportes
```

### 4. Dashboard

El dashboard debe permitir al responsable del área conocer rápidamente el estado del servicio.

#### Indicadores

- Estudios solicitados hoy.
- Estudios programados.
- Pacientes pendientes de atención.
- Estudios realizados.
- Estudios pendientes de informe.
- Informes pendientes de validación.
- Estudios informados.
- Estudios cancelados.
- Estudios urgentes.
- Equipos disponibles.
- Equipos fuera de servicio.

#### Gráficos

Por ejemplo:

Estudios por modalidad

```
Radiografías       ███████████████
Ecografías         █████████
Tomografías        ██████
Resonancias        ████
Mamografías        ███
Densitometrías     ██
```

También:
- Estudios por día.
- Estudios por especialidad.
- Estudios por médico.
- Estudios por modalidad.
- Estudios por estado.

### 5. Catálogo de estudios

El sistema debe permitir configurar los diferentes estudios que ofrece el hospital.

Ejemplo:

| Código | Estudio | Modalidad |
| --- | --- | --- |
| RX001 | Radiografía de tórax | RX |
| RX002 | Radiografía de columna | RX |
| ECO001 | Ecografía abdominal | ECO |
| ECO002 | Ecografía obstétrica | ECO |
| TAC001 | TAC cerebral | TAC |
| TAC002 | TAC abdominal | TAC |
| RM001 | Resonancia cerebral | RM |
| MAM001 | Mamografía bilateral | MAM |
| DEX001 | Densitometría ósea | DEXA |

El catálogo debe ser configurable para que el hospital pueda agregar nuevos estudios.

### 6. Solicitud médica

La solicitud normalmente se genera desde la consulta médica.

Ejemplo:

Paciente:

Juan Pérez

Historia clínica:

HC-000125

Médico:

Dr. Carlos Ramírez

Especialidad:

Neurología

Estudio solicitado:

Tomografía cerebral

Prioridad:

URGENTE

Motivo:

Evaluación solicitada durante la consulta

Observaciones:

...

Fecha:

06/09/2026

La solicitud debe quedar vinculada a la Historia Clínica.

### 7. Programación

El personal encargado podrá programar el estudio.

Debe considerar:
- Paciente.
- Estudio.
- Fecha.
- Hora.
- Modalidad.
- Equipo.
- Sala.
- Técnico responsable.
- Médico solicitante.
- Prioridad.
- Estado.

#### Estados

SOLICITADO

    ↓

PROGRAMADO

    ↓

PACIENTE RECIBIDO

    ↓

EN ATENCIÓN

    ↓

REALIZADO

    ↓

PENDIENTE INFORME

    ↓

INFORMADO

    ↓

VALIDADO

    ↓

ENTREGADO

También:

CANCELADO

REPROGRAMADO

NO ASISTIÓ

RECHAZADO

### 8. Recepción del paciente

Cuando el paciente llega al área:
- Buscar paciente.
- Mostrar estudio programado.
- Confirmar identidad.
- Verificar solicitud.
- Registrar llegada.
- Cambiar estado a PACIENTE RECIBIDO.
- Pasar a la sala de atención.

Esto permitirá medir posteriormente el tiempo de espera.

### 9. Realización del estudio

El técnico podrá visualizar los estudios pendientes.

Ejemplo:

| Hora | Paciente | Estudio | Prioridad | Estado |
| --- | --- | --- | --- | --- |
| 08:00 | Juan Pérez | RX Tórax | Normal | Pendiente |
| 08:30 | María López | TAC Cerebral | Urgente | Pendiente |
| 09:00 | Pedro Díaz | Ecografía | Normal | Pendiente |

Al iniciar:

Iniciar estudio

El sistema registra:
- Fecha.
- Hora de inicio.
- Técnico.
- Equipo.
- Sala.

Al finalizar:

Finalizar estudio

Se registra:
- Hora de finalización.
- Técnico.
- Observaciones.
- Incidencias.

### 10. Imágenes médicas

Una parte importante del módulo es la gestión de las imágenes generadas.

El sistema debe estar preparado para trabajar posteriormente con:

#### DICOM

Digital Imaging and Communications in Medicine

Es el estándar utilizado para intercambio de imágenes médicas.

Por ejemplo:

Tomógrafo

```
    │
    ▼
```

DICOM

```
    │
    ▼
```

Servidor PACS

```
    │
    ▼
```

Sistema Hospitalario

```
    │
    ├── Datos del paciente
    ├── Estudio
    ├── Imágenes
    └── Informe
```

#### Recomendación importante

No es recomendable guardar directamente grandes archivos de imágenes médicas dentro de PostgreSQL.

La base de datos debería guardar principalmente:
- Identificador del estudio.
- UID DICOM.
- Referencia.
- Modalidad.
- Fecha.
- Paciente.
- Equipo.
- Ubicación.
- Estado.

Las imágenes pueden almacenarse en un PACS/DICOM Server.

Esto deja al sistema preparado para una futura integración profesional con infraestructura de imágenes médicas.

### 11. Informe radiológico

Después de realizar el estudio, el médico especialista podrá elaborar el informe.

Ejemplo:

INFORME DE DIAGNÓSTICO POR IMÁGENES

Paciente:

Juan Pérez

Estudio:

Radiografía de tórax

Fecha:

06/09/2026

Médico solicitante:

Dr. Carlos Ramírez

HALLAZGOS:

........................................

........................................

CONCLUSIÓN:

........................................

........................................

Médico informante:

Dr. ....................

Fecha:

06/09/2026

El informe debe permitir:
- Plantillas.
- Hallazgos.
- Conclusión.
- Observaciones.
- Firma/validación.
- Fecha y hora.
- Médico responsable.

### 12. Validación del informe

El informe no debería considerarse definitivo simplemente porque fue escrito.

Flujo:

Estudio realizado

       ↓

Informe redactado

       ↓

Revisión

       ↓

Validación

       ↓

Informe definitivo

Una vez validado:
- Se registra quién lo validó.
- Fecha y hora.
- Usuario responsable.
- Se bloquea la modificación directa.

Si existe un error, debe realizarse una corrección controlada, manteniendo el historial de versiones.

### 13. Resultados críticos

El sistema puede permitir configurar un mecanismo de hallazgos críticos.

Por ejemplo:

INFORME

   ↓

¿Hallazgo crítico?

```
   ↓
   SÍ
   ↓
```

ALERTA

   ↓

Notificación al responsable

   ↓

Registro de comunicación

Debe registrarse, según las reglas del establecimiento:
- Quién identificó el hallazgo.
- Fecha/hora.
- A quién se notificó.
- Medio utilizado.
- Fecha/hora de comunicación.
- Observaciones.

El sistema debe registrar la alerta; no debe realizar diagnósticos automáticos.

### 14. Integración con Historia Clínica

Una vez validado el informe:

Diagnóstico por Imágenes

```
          │
          ▼
```

Informe validado

```
          │
          ▼
```

Historia Clínica

```
          │
          ▼
```

Paciente

Desde la Historia Clínica se debería poder consultar:
- Fecha.
- Estudio.
- Médico solicitante.
- Modalidad.
- Informe.
- Imágenes disponibles.
- Médico informante.

### 15. Equipos

El módulo debe permitir registrar los equipos utilizados.

Ejemplo:

| Código | Equipo | Modalidad | Estado |
| --- | --- | --- | --- |
| EQ-RX-01 | Equipo RX | Radiografía | Disponible |
| EQ-TAC-01 | Tomógrafo | TAC | Disponible |
| EQ-RM-01 | Resonador | RM | Mantenimiento |
| EQ-ECO-01 | Ecógrafo | ECO | Disponible |

Datos:
- Código.
- Nombre.
- Marca.
- Modelo.
- Número de serie.
- Modalidad.
- Ubicación.
- Fecha de adquisición.
- Estado.
- Fecha de instalación.

### 16. Mantenimiento

Registrar:
- Mantenimiento preventivo.
- Mantenimiento correctivo.
- Fecha.
- Equipo.
- Proveedor/técnico.
- Descripción.
- Inicio.
- Fin.
- Costo.
- Observaciones.
- Próximo mantenimiento.

Estados:

PROGRAMADO

EN MANTENIMIENTO

FINALIZADO

CANCELADO

### 17. Incidencias

Ejemplos:
- Equipo averiado.
- Error durante adquisición.
- Imagen no generada.
- Imagen de mala calidad.
- Error de identificación del paciente.
- Problema de almacenamiento.
- Problema de comunicación DICOM.
- Repetición del estudio.

Cada incidencia debe quedar auditada.

### 18. Requisitos funcionales

#### A. Gestión de estudios

#### RF-IMG-01 – Registrar estudio

El sistema permitirá registrar y configurar los estudios de diagnóstico por imágenes disponibles.

#### RF-IMG-02 – Modificar estudio

El sistema permitirá modificar la información de un estudio activo.

#### RF-IMG-03 – Activar/Inactivar estudio

El sistema permitirá activar o desactivar estudios del catálogo.

#### RF-IMG-04 – Configurar modalidad

El sistema permitirá asociar cada estudio con una modalidad de imagen.

#### RF-IMG-05 – Configurar duración

El sistema permitirá establecer la duración estimada de cada estudio.

#### RF-IMG-06 – Configurar requisitos

El sistema permitirá registrar requisitos o indicaciones administrativas asociadas al estudio.

#### B. Solicitudes de estudios

#### RF-IMG-07 – Registrar solicitud

El sistema permitirá registrar una solicitud de diagnóstico por imágenes.

#### RF-IMG-08 – Asociar paciente

La solicitud deberá estar asociada obligatoriamente a un paciente.

#### RF-IMG-09 – Asociar historia clínica

El sistema permitirá asociar la solicitud a la Historia Clínica.

#### RF-IMG-10 – Asociar médico solicitante

El sistema deberá registrar el profesional que solicita el estudio.

#### RF-IMG-11 – Registrar motivo

El sistema permitirá registrar el motivo clínico de la solicitud.

#### RF-IMG-12 – Registrar prioridad

El sistema permitirá establecer la prioridad del estudio.

Valores sugeridos:
- Normal.
- Prioritario.
- Urgente.

#### RF-IMG-13 – Registrar múltiples estudios

Una solicitud podrá contener uno o varios estudios, según la configuración del establecimiento.

#### RF-IMG-14 – Consultar solicitudes

El usuario podrá consultar solicitudes por:
- Paciente.
- DNI.
- Historia clínica.
- Médico.
- Especialidad.
- Fecha.
- Estudio.
- Estado.

#### RF-IMG-15 – Cancelar solicitud

El sistema permitirá cancelar una solicitud indicando el motivo.

#### C. Programación

#### RF-IMG-16 – Programar estudio

El sistema permitirá programar fecha y hora para realizar un estudio.

#### RF-IMG-17 – Consultar disponibilidad

El sistema permitirá consultar disponibilidad de:
- Equipo.
- Sala.
- Técnico.
- Horario.

#### RF-IMG-18 – Evitar doble programación

El sistema impedirá programar dos estudios incompatibles en el mismo equipo y horario.

#### RF-IMG-19 – Reprogramar estudio

El usuario autorizado podrá cambiar la fecha u hora de un estudio.

#### RF-IMG-20 – Registrar motivo de reprogramación

Toda reprogramación deberá registrar su motivo.

#### RF-IMG-21 – Cancelar programación

El sistema permitirá cancelar una programación.

#### RF-IMG-22 – Registrar inasistencia

El sistema permitirá registrar cuando el paciente no se presenta.

#### RF-IMG-23 – Consultar agenda

El personal podrá consultar la agenda diaria, semanal y mensual.

#### D. Recepción

#### RF-IMG-24 – Registrar llegada

El sistema permitirá registrar la llegada del paciente al servicio.

#### RF-IMG-25 – Confirmar identidad

El sistema permitirá verificar los datos del paciente antes de iniciar el procedimiento.

#### RF-IMG-26 – Registrar hora de llegada

El sistema registrará automáticamente fecha y hora de recepción.

#### RF-IMG-27 – Controlar estudios pendientes

El sistema mostrará los estudios que esperan atención.

#### RF-IMG-28 – Actualizar estado

El sistema cambiará el estado del estudio conforme avance el proceso.

#### E. Realización del estudio

#### RF-IMG-29 – Iniciar estudio

El técnico autorizado podrá iniciar un estudio programado.

#### RF-IMG-30 – Registrar técnico

El sistema registrará al técnico responsable de realizar el estudio.

#### RF-IMG-31 – Registrar equipo

El sistema permitirá registrar el equipo utilizado.

#### RF-IMG-32 – Registrar sala

El sistema permitirá registrar la sala donde se realizó el procedimiento.

#### RF-IMG-33 – Registrar hora de inicio

El sistema registrará la hora de inicio.

#### RF-IMG-34 – Finalizar estudio

El técnico podrá finalizar el estudio.

#### RF-IMG-35 – Registrar observaciones técnicas

El sistema permitirá registrar observaciones relacionadas con la realización.

#### RF-IMG-36 – Registrar incidencias

El usuario podrá registrar incidencias ocurridas durante el procedimiento.

#### F. Gestión de imágenes

#### RF-IMG-37 – Asociar imágenes

El sistema permitirá asociar las imágenes obtenidas con el estudio correspondiente.

#### RF-IMG-38 – Registrar identificador DICOM

El sistema podrá registrar el identificador DICOM correspondiente.

#### RF-IMG-39 – Registrar referencia PACS

El sistema permitirá almacenar la referencia hacia las imágenes almacenadas en el PACS.

#### RF-IMG-40 – Consultar imágenes

Los usuarios autorizados podrán consultar las imágenes asociadas a un estudio.

#### RF-IMG-41 – Visualizar estudio

El sistema podrá permitir el acceso al visor de imágenes o al sistema PACS configurado.

#### RF-IMG-42 – Controlar acceso

El sistema deberá controlar los permisos para consultar imágenes médicas.

#### RF-IMG-43 – Registrar acceso

El sistema deberá registrar quién accedió a las imágenes y cuándo.

#### G. Informes

#### RF-IMG-44 – Registrar informe

El médico autorizado podrá registrar el informe del estudio.

#### RF-IMG-45 – Asociar informe

El informe deberá estar asociado al estudio correspondiente.

#### RF-IMG-46 – Registrar hallazgos

El sistema permitirá registrar los hallazgos encontrados durante la interpretación.

#### RF-IMG-47 – Registrar conclusión

El sistema permitirá registrar la conclusión del informe.

#### RF-IMG-48 – Utilizar plantillas

El sistema permitirá utilizar plantillas configurables para los informes.

#### RF-IMG-49 – Identificar médico informante

El sistema registrará al profesional responsable del informe.

#### RF-IMG-50 – Guardar informe preliminar

El médico podrá guardar un informe como borrador.

#### RF-IMG-51 – Finalizar informe

El médico autorizado podrá marcar el informe como finalizado.

#### H. Validación

#### RF-IMG-52 – Validar informe

El usuario autorizado podrá validar un informe.

#### RF-IMG-53 – Registrar fecha de validación

El sistema registrará automáticamente fecha y hora de validación.

#### RF-IMG-54 – Registrar responsable

El sistema registrará al profesional que realizó la validación.

#### RF-IMG-55 – Bloquear informe validado

Un informe validado no podrá modificarse directamente.

#### RF-IMG-56 – Registrar correcciones

El sistema permitirá realizar correcciones controladas.

#### RF-IMG-57 – Mantener historial de versiones

El sistema conservará las versiones anteriores de los informes.

#### I. Hallazgos críticos

#### RF-IMG-58 – Marcar hallazgo crítico

El profesional podrá marcar un resultado como crítico.

#### RF-IMG-59 – Generar alerta

El sistema podrá generar una alerta asociada al hallazgo crítico.

#### RF-IMG-60 – Registrar comunicación

El sistema permitirá registrar la comunicación del hallazgo al profesional correspondiente.

#### RF-IMG-61 – Consultar alertas

Los usuarios autorizados podrán consultar las alertas pendientes y atendidas.

#### J. Integración con Historia Clínica

#### RF-IMG-62 – Asociar resultado a Historia Clínica

El sistema asociará el informe validado con la Historia Clínica.

#### RF-IMG-63 – Consultar estudios anteriores

Los usuarios autorizados podrán consultar estudios anteriores del paciente.

#### RF-IMG-64 – Consultar informes históricos

El sistema permitirá consultar informes anteriores.

#### RF-IMG-65 – Consultar imágenes históricas

El sistema permitirá acceder a imágenes anteriores cuando estén disponibles en el sistema/PACS.

#### K. Equipos

#### RF-IMG-66 – Registrar equipo

El sistema permitirá registrar equipos de diagnóstico por imágenes.

#### RF-IMG-67 – Modificar equipo

El usuario autorizado podrá modificar los datos del equipo.

#### RF-IMG-68 – Cambiar estado del equipo

El sistema permitirá establecer estados:
- Disponible.
- En uso.
- Mantenimiento.
- Fuera de servicio.
- Inactivo.

#### RF-IMG-69 – Registrar mantenimiento

El sistema permitirá registrar mantenimientos.

#### RF-IMG-70 – Consultar historial de mantenimiento

El sistema permitirá consultar el historial de mantenimiento de cada equipo.

#### L. Incidencias

#### RF-IMG-71 – Registrar incidencia

El usuario podrá registrar incidencias relacionadas con estudios o equipos.

#### RF-IMG-72 – Clasificar incidencia

El sistema permitirá clasificar la incidencia.

#### RF-IMG-73 – Dar seguimiento

El sistema permitirá actualizar el estado de una incidencia.

#### RF-IMG-74 – Cerrar incidencia

El usuario autorizado podrá cerrar una incidencia registrando la solución.

#### M. Reportes

#### RF-IMG-75 – Reporte de estudios

Generar estudios realizados por período.

#### RF-IMG-76 – Reporte por modalidad

Mostrar estudios agrupados por:
- RX.
- ECO.
- TAC.
- RM.
- MAM.
- DEXA.

#### RF-IMG-77 – Reporte por médico

Mostrar estudios solicitados por médico.

#### RF-IMG-78 – Reporte por especialidad

Mostrar estudios solicitados por especialidad.

#### RF-IMG-79 – Reporte de productividad

Mostrar cantidad de estudios realizados por técnico/equipo/período.

#### RF-IMG-80 – Reporte de tiempos de atención

Mostrar:
- Hora de llegada.
- Inicio del estudio.
- Finalización.
- Tiempo de espera.
- Tiempo de atención.

#### RF-IMG-81 – Reporte de estudios pendientes

Mostrar estudios pendientes de realización o informe.

#### RF-IMG-82 – Reporte de informes pendientes

Mostrar estudios que todavía no cuentan con informe validado.

#### RF-IMG-83 – Reporte de equipos

Mostrar disponibilidad y estado de los equipos.

#### RF-IMG-84 – Exportar reportes

El sistema permitirá exportar reportes a formatos como PDF y Excel, según permisos.

### 19. Propuesta de base de datos

Las principales tablas podrían ser:

TIPO_ESTUDIO

```
    │
    ├── ESTUDIO_IMAGEN
    │
    └── MODALIDAD
```

PACIENTE

```
    │
    └── ORDEN_IMAGEN
             │
             ├── DETALLE_ORDEN_IMAGEN
             │
             └── CITA_IMAGEN
                       │
                       ▼
                PROCEDIMIENTO_IMAGEN
                       │
                       ├── IMAGEN_ESTUDIO
                       │
                       └── INFORME_RADIOLOGICO
                                  │
                                  └── VALIDACION_INFORME
```

#### Tablas principales

tipo_estudio
- id_tipo_estudio
- codigo
- nombre
- descripcion
- modalidad
- duracion_estimada
- requiere_programacion
- estado

orden_imagen
- id_orden
- numero_orden
- id_paciente
- id_historia_clinica
- id_consulta
- id_medico
- fecha
- prioridad
- motivo
- observaciones
- estado

detalle_orden_imagen
- id_detalle
- id_orden
- id_tipo_estudio
- indicacion
- estado

cita_imagen
- id_cita
- id_detalle
- fecha
- hora
- sala
- equipo
- tecnico
- estado

procedimiento_imagen
- id_procedimiento
- id_detalle
- fecha
- hora_inicio
- hora_fin
- tecnico
- equipo
- observaciones
- incidencias

imagen_estudio
- id_imagen
- id_procedimiento
- identificador_dicom
- study_instance_uid
- series_instance_uid
- sop_instance_uid
- referencia_pacs
- fecha
- estado

informe_radiologico
- id_informe
- id_procedimiento
- medico_informante
- fecha
- hallazgos
- conclusion
- observaciones
- estado

validacion_informe
- id_validacion
- id_informe
- usuario
- fecha
- tipo
- observaciones

equipo_imagen
- id_equipo
- codigo
- nombre
- marca
- modelo
- numero_serie
- modalidad
- ubicacion
- estado

mantenimiento_equipo
- id_mantenimiento
- id_equipo
- tipo
- fecha_inicio
- fecha_fin
- proveedor
- descripcion
- costo
- observaciones

incidencia_imagen
- id_incidencia
- id_procedimiento
- id_equipo
- tipo
- descripcion
- fecha
- responsable
- estado
- solucion

### 20. Integraciones del módulo

Este módulo debería integrarse con prácticamente todo el sistema:

```
                    ┌───────────────┐
                    │    PACIENTE   │
                    └───────┬───────┘
                            │
                    ┌───────▼───────┐
                    │ HISTORIA      │
                    │ CLÍNICA       │
                    └───────┬───────┘
                            │
                    ┌───────▼───────┐
                    │ CONSULTA      │
                    │ MÉDICA        │
                    └───────┬───────┘
                            │
                    ┌───────▼────────┐
                    │ ORDEN IMAGEN   │
                    └───────┬────────┘
                            │
              ┌─────────────▼─────────────┐
              │ DIAGNÓSTICO POR IMÁGENES  │
              └─────────────┬─────────────┘
                            │
                  ┌─────────▼─────────┐
                  │ IMÁGENES / PACS   │
                  └─────────┬─────────┘
                            │
                  ┌─────────▼─────────┐
                  │ INFORME           │
                  └─────────┬─────────┘
                            │
                  ┌─────────▼─────────┐
                  │ VALIDACIÓN        │
                  └─────────┬─────────┘
                            │
                    ┌───────▼───────┐
                    │ HISTORIA      │
                    │ CLÍNICA       │
                    └───────────────┘
```

Además, posteriormente puede integrarse con:

```
- Citas Médicas → programación.
- Admisión/Emergencia → estudios urgentes.
- Hospitalización → órdenes para pacientes internados.
- Facturación → cobro del estudio.
- Seguros → cobertura/autorización.
- Laboratorio → complemento de resultados.
- Reportes → estadísticas institucionales.
```

### 21. Punto importante para tu proyecto

Yo dejaría desde ahora la arquitectura preparada para PACS + DICOM, aunque en la primera versión del sistema no implementes un PACS completo.

La separación recomendable sería:

Sistema hospitalario

→ pacientes → órdenes → programación → estudios → informes → permisos → auditoría

Servidor PACS

→ imágenes DICOM → series → estudios → almacenamiento → visor médico

Así, posteriormente

## MÓDULO 12 – QUIRÓFANO / CIRUGÍA

### 1. Objetivo del módulo

El módulo de Quirófano / Cirugía permitirá gestionar integralmente los procedimientos quirúrgicos realizados en el hospital, desde la solicitud y evaluación preoperatoria, pasando por la programación y ejecución de la cirugía, hasta la recuperación postoperatoria y el registro final en la Historia Clínica.

El módulo debe permitir controlar:
- Solicitudes quirúrgicas.
- Programación de cirugías.
- Quirófanos.
- Pacientes quirúrgicos.
- Equipo médico.
- Evaluación preoperatoria.
- Anestesia.
- Procedimiento quirúrgico.
- Registro operatorio.
- Insumos utilizados.
- Complicaciones e incidencias.
- Recuperación postoperatoria.
- Cierre de cirugía.
- Reportes.

### 2. Flujo general

MÉDICO

```
   │
   ▼
```

SOLICITUD DE CIRUGÍA

```
   │
   ▼
```

EVALUACIÓN PREOPERATORIA

```
   │
   ▼
```

AUTORIZACIÓN / APROBACIÓN

```
   │
   ▼
```

PROGRAMACIÓN

```
   │
   ├── Fecha
   ├── Hora
   ├── Quirófano
   ├── Cirujano
   ├── Anestesiólogo
   └── Equipo quirúrgico
   │
   ▼
```

PREPARACIÓN DEL PACIENTE

```
   │
   ▼
```

INGRESO A QUIRÓFANO

```
   │
   ▼
```

ANESTESIA

```
   │
   ▼
```

PROCEDIMIENTO QUIRÚRGICO

```
   │
   ├── Registro operatorio
   ├── Insumos
   ├── Medicamentos
   └── Incidencias
   │
   ▼
```

FINALIZACIÓN

```
   │
   ▼
```

RECUPERACIÓN POSTOPERATORIA

```
   │
   ▼
```

EVOLUCIÓN

```
   │
   ▼
```

CIERRE DEL PROCEDIMIENTO

```
   │
   ▼
```

HISTORIA CLÍNICA

### 3. Menú del módulo

QUIRÓFANO / CIRUGÍA

```
│
├── Dashboard
│
├── Solicitudes quirúrgicas
├── Evaluaciones preoperatorias
├── Programación de cirugías
├── Agenda de quirófanos
│
├── Pacientes quirúrgicos
├── Quirófanos
├── Equipos quirúrgicos
├── Personal quirúrgico
│
├── Cirugías programadas
├── Cirugías en curso
├── Registro operatorio
├── Anestesia
├── Procedimientos quirúrgicos
│
├── Insumos utilizados
├── Medicamentos utilizados
├── Complicaciones / Incidencias
│
├── Recuperación postoperatoria
├── Evolución postoperatoria
├── Cierre de cirugía
│
├── Historial quirúrgico
└── Reportes
```

### 4. Dashboard

El dashboard permitirá al responsable del área visualizar el estado de los procedimientos quirúrgicos.

#### Indicadores

- Cirugías programadas para hoy.
- Cirugías en espera.
- Cirugías en preparación.
- Cirugías en curso.
- Cirugías finalizadas.
- Cirugías canceladas.
- Cirugías reprogramadas.
- Quirófanos disponibles.
- Quirófanos ocupados.
- Quirófanos en mantenimiento.
- Informes operatorios pendientes.

#### Ejemplo

CIRUGÍAS DE HOY

```
Programadas         12
En preparación       2
En curso              1
Finalizadas           8
Canceladas           1
```

#### Gráficos

- Cirugías por especialidad.
- Cirugías por médico.
- Cirugías por tipo.
- Cirugías por período.
- Uso de quirófanos.
- Tiempo promedio de utilización.

### 5. Solicitud quirúrgica

La solicitud puede generarse desde:
- Consulta médica.
- Hospitalización.
- Emergencia.

Ejemplo:

SOLICITUD QUIRÚRGICA

Paciente: Juan Pérez

Historia Clínica: HC-000125

Médico solicitante:

Dr. Carlos Ramírez

Especialidad:

Cirugía General

Procedimiento:

Colecistectomía

Diagnóstico:

............................

Motivo:

............................

Prioridad:

Programada

Observaciones:

............................

La solicitud debe quedar relacionada con la Historia Clínica.

### 6. Estados de la solicitud

Se pueden utilizar:

SOLICITADA

   ↓

EN EVALUACIÓN

   ↓

APROBADA

   ↓

PROGRAMADA

   ↓

EN PREPARACIÓN

   ↓

REALIZADA

   ↓

CERRADA

También:

CANCELADA

RECHAZADA

REPROGRAMADA

SUSPENDIDA

### 7. Evaluación preoperatoria

Antes de la cirugía se debe registrar la evaluación correspondiente según los protocolos del hospital.

Puede incluir:
- Paciente.
- Procedimiento programado.
- Médico responsable.
- Fecha.
- Antecedentes relevantes.
- Alergias.
- Medicación actual.
- Evaluaciones requeridas.
- Resultados disponibles.
- Observaciones.
- Estado de preparación.

El sistema no debe emitir por sí mismo una autorización médica. Debe permitir registrar el resultado de la evaluación realizada por el profesional autorizado.

### 8. Autorización / aprobación

Dependiendo de las reglas del hospital, una cirugía puede requerir aprobación.

El sistema puede manejar:

PENDIENTE

APROBADA

RECHAZADA

OBSERVADA

Debe registrar:
- Usuario responsable.
- Fecha.
- Hora.
- Observación.
- Motivo cuando corresponda.

### 9. Programación quirúrgica

La programación debe considerar:
- Paciente.
- Procedimiento.
- Fecha.
- Hora de inicio.
- Hora estimada de finalización.
- Quirófano.
- Cirujano.
- Anestesiólogo.
- Enfermería.
- Personal auxiliar.
- Equipamiento necesario.
- Prioridad.

#### Control de conflictos

El sistema debe impedir, según las reglas configuradas:

Mismo quirófano

       +

Mismo horario

       +

Otra cirugía

```
       ↓
   CONFLICTO
```

También debe advertir conflictos de disponibilidad del personal asignado.

### 10. Agenda de quirófanos

La agenda permitirá visualizar:

| Hora | Quirófano | Paciente | Cirugía | Cirujano | Estado |
| --- | --- | --- | --- | --- | --- |
| 08:00 | Q-01 | Juan Pérez | Cirugía A | Dr. X | Programada |
| 10:00 | Q-01 | María López | Cirugía B | Dr. Y | Programada |
| 08:30 | Q-02 | Pedro Díaz | Cirugía C | Dr. Z | En curso |

Visualizaciones:
- Diaria.
- Semanal.
- Mensual.
- Por quirófano.
- Por cirujano.

### 11. Quirófanos

El sistema debe permitir administrar los quirófanos disponibles.

#### Datos

- Código.
- Nombre.
- Piso.
- Área.
- Tipo.
- Capacidad.
- Equipamiento.
- Estado.

#### Estados

DISPONIBLE

RESERVADO

EN USO

MANTENIMIENTO

FUERA DE SERVICIO

### 12. Equipo quirúrgico

Una cirugía puede involucrar diferentes profesionales.

Por ejemplo:

CIRUJANO PRINCIPAL

```
      │
      ├── CIRUJANO ASISTENTE
      │
      ├── ANESTESIÓLOGO
      │
      ├── ENFERMERA INSTRUMENTISTA
      │
      └── ENFERMERA CIRCULANTE
```

El sistema debe permitir registrar el rol de cada integrante.

### 13. Preparación del paciente

Antes de ingresar al quirófano se puede registrar:
- Confirmación de paciente.
- Procedimiento programado.
- Quirófano.
- Equipo quirúrgico.
- Documentación requerida.
- Estado de preparación.
- Hora de ingreso al área.
- Observaciones.

Esto permite tener trazabilidad del proceso.

### 14. Ingreso a quirófano

Cuando el paciente ingresa:

Paciente preparado

       ↓

Ingreso a quirófano

       ↓

Registro de hora

       ↓

Inicio del procedimiento

Se debe registrar:
- Fecha.
- Hora de ingreso.
- Quirófano.
- Personal responsable.
- Estado.

### 15. Anestesia

El módulo puede disponer de un registro específico de anestesia.

Información posible:
- Anestesiólogo.
- Tipo de procedimiento anestésico.
- Hora de inicio.
- Hora de finalización.
- Medicamentos utilizados.
- Observaciones.
- Eventos registrados.

Los datos clínicos específicos deben ser definidos por los profesionales y protocolos del establecimiento.

### 16. Registro operatorio

Es uno de los componentes principales del módulo.

Debe registrar:
- Paciente.
- Cirujano.
- Equipo quirúrgico.
- Procedimiento.
- Diagnóstico preoperatorio.
- Diagnóstico postoperatorio.
- Fecha.
- Hora de inicio.
- Hora de finalización.
- Quirófano.
- Descripción del procedimiento.
- Hallazgos.
- Observaciones.
- Complicaciones.
- Estado final.

### 17. Procedimientos quirúrgicos

El hospital debería disponer de un catálogo.

Ejemplo:

| Código | Procedimiento | Especialidad |
| --- | --- | --- |
| CIR-001 | Procedimiento A | Cirugía General |
| CIR-002 | Procedimiento B | Traumatología |
| CIR-003 | Procedimiento C | Ginecología |
| CIR-004 | Procedimiento D | Urología |

El catálogo debe ser configurable.

### 18. Insumos utilizados

Durante la cirugía se deben registrar los insumos utilizados.

Ejemplos:
- Guantes.
- Gasas.
- Suturas.
- Material quirúrgico.
- Dispositivos médicos.
- Otros insumos.

Cada consumo debe quedar relacionado con la cirugía.

Esto permitirá posteriormente integrarlo con:

Quirófano → Inventario/Almacén → Kardex

### 19. Medicamentos utilizados

Los medicamentos utilizados durante el procedimiento deben poder registrarse y posteriormente relacionarse con Farmacia.

Flujo:

CIRUGÍA

   ↓

MEDICAMENTO UTILIZADO

   ↓

FARMACIA

   ↓

STOCK

   ↓

KARDEX

La cantidad y presentación deben quedar registradas para mantener trazabilidad.

### 20. Complicaciones e incidencias

El sistema permitirá registrar incidencias durante el procedimiento.

Ejemplos de clasificación:
- Incidencia técnica.
- Incidencia administrativa.
- Incidencia relacionada con equipamiento.
- Complicación registrada por el profesional.
- Suspensión del procedimiento.
- Otras.

Debe registrarse:
- Fecha.
- Hora.
- Descripción.
- Responsable.
- Acción registrada.
- Estado.

El sistema debe registrar lo informado por el personal autorizado y no generar diagnósticos automáticamente.

### 21. Recuperación postoperatoria

Después de la cirugía:

CIRUGÍA FINALIZADA

       ↓

RECUPERACIÓN

       ↓

OBSERVACIÓN

       ↓

EVOLUCIÓN

       ↓

DESTINO DEL PACIENTE

El sistema puede registrar:
- Hora de ingreso.
- Hora de salida.
- Responsable.
- Observaciones.
- Evolución.
- Destino.

El destino puede ser:
- Hospitalización.
- UCI/área correspondiente.
- Emergencia.
- Alta.
- Otro servicio.

### 22. Evolución postoperatoria

El profesional autorizado podrá registrar la evolución posterior a la cirugía.

Debe estar relacionada con:
- Paciente.
- Historia Clínica.
- Cirugía.
- Médico.
- Fecha.
- Hora.

Se recomienda mantener las evoluciones como registros históricos y no sobrescribirlas.

### 23. Cierre de cirugía

Para cerrar una cirugía, el sistema deberá verificar que se hayan completado los registros obligatorios configurados.

Por ejemplo:

☑ Procedimiento registrado

☑ Cirujano registrado

☑ Quirófano registrado

☑ Hora inicio

☑ Hora fin

☑ Registro operatorio

☑ Insumos registrados

☑ Incidencias registradas

☑ Recuperación registrada

Luego:

CERRAR CIRUGÍA

El sistema registra:
- Usuario.
- Fecha.
- Hora.
- Estado final.

### 24. Historial quirúrgico

Desde la Historia Clínica se podrá consultar:

HISTORIAL QUIRÚRGICO

```
│
├── Fecha
├── Procedimiento
├── Diagnóstico
├── Cirujano
├── Quirófano
├── Anestesia
├── Registro operatorio
├── Insumos
├── Incidencias
└── Evolución postoperatoria
```

### 25. Requisitos funcionales

#### A. Solicitudes quirúrgicas

#### RF-CIR-01 – Registrar solicitud quirúrgica

El sistema permitirá registrar una solicitud de procedimiento quirúrgico.

#### RF-CIR-02 – Asociar paciente

La solicitud deberá estar asociada a un paciente registrado.

#### RF-CIR-03 – Asociar Historia Clínica

El sistema permitirá relacionar la solicitud con la Historia Clínica.

#### RF-CIR-04 – Registrar médico solicitante

El sistema registrará al profesional que solicita el procedimiento.

#### RF-CIR-05 – Registrar procedimiento

El usuario autorizado podrá seleccionar el procedimiento quirúrgico solicitado.

#### RF-CIR-06 – Registrar diagnóstico

El sistema permitirá registrar el diagnóstico asociado a la solicitud.

#### RF-CIR-07 – Registrar prioridad

El sistema permitirá establecer la prioridad de la cirugía.

#### RF-CIR-08 – Registrar observaciones

El sistema permitirá registrar observaciones de la solicitud.

#### RF-CIR-09 – Consultar solicitudes

Permitirá consultar solicitudes por paciente, médico, especialidad, fecha, procedimiento y estado.

#### RF-CIR-10 – Cancelar solicitud

Permitirá cancelar una solicitud indicando el motivo.

#### B. Evaluación preoperatoria

#### RF-CIR-11 – Registrar evaluación preoperatoria

El sistema permitirá registrar la evaluación preoperatoria realizada por el profesional autorizado.

#### RF-CIR-12 – Asociar evaluación a cirugía

La evaluación deberá estar relacionada con la solicitud correspondiente.

#### RF-CIR-13 – Registrar observaciones preoperatorias

Permitirá registrar observaciones.

#### RF-CIR-14 – Registrar estado de evaluación

El sistema permitirá registrar el estado de la evaluación.

#### RF-CIR-15 – Consultar evaluaciones

Permitirá consultar evaluaciones anteriores asociadas al paciente y procedimiento.

#### C. Aprobación

#### RF-CIR-16 – Registrar aprobación

El usuario autorizado podrá registrar la aprobación de la cirugía.

#### RF-CIR-17 – Registrar rechazo

El sistema permitirá registrar el rechazo de una solicitud.

#### RF-CIR-18 – Registrar observación

Permitirá registrar observaciones relacionadas con la aprobación o rechazo.

#### RF-CIR-19 – Registrar responsable

El sistema registrará automáticamente al usuario responsable.

#### RF-CIR-20 – Controlar estado

El sistema impedirá programar una cirugía que no cumpla las condiciones de aprobación configuradas.

#### D. Programación

#### RF-CIR-21 – Programar cirugía

El sistema permitirá programar fecha y hora de la cirugía.

#### RF-CIR-22 – Asignar quirófano

Permitirá asignar un quirófano disponible.

#### RF-CIR-23 – Asignar cirujano

Permitirá asignar al cirujano principal.

#### RF-CIR-24 – Asignar anestesiólogo

Permitirá registrar el anestesiólogo responsable.

#### RF-CIR-25 – Asignar equipo quirúrgico

Permitirá registrar los integrantes del equipo quirúrgico.

#### RF-CIR-26 – Registrar duración estimada

Permitirá registrar la duración estimada del procedimiento.

#### RF-CIR-27 – Validar disponibilidad

El sistema verificará la disponibilidad del quirófano y recursos configurados.

#### RF-CIR-28 – Evitar doble programación

El sistema impedirá conflictos de programación.

#### RF-CIR-29 – Reprogramar cirugía

Permitirá modificar fecha y hora de una cirugía programada.

#### RF-CIR-30 – Registrar motivo de reprogramación

Toda reprogramación deberá registrar el motivo.

#### RF-CIR-31 – Cancelar cirugía programada

Permitirá cancelar una cirugía programada.

#### RF-CIR-32 – Registrar motivo de cancelación

La cancelación deberá registrar el motivo y responsable.

#### E. Quirófanos

#### RF-CIR-33 – Registrar quirófano

Permitirá registrar los quirófanos del establecimiento.

#### RF-CIR-34 – Modificar quirófano

Permitirá modificar los datos del quirófano.

#### RF-CIR-35 – Cambiar estado

Permitirá cambiar el estado del quirófano.

#### RF-CIR-36 – Consultar disponibilidad

Permitirá consultar la disponibilidad de cada quirófano.

#### RF-CIR-37 – Registrar equipamiento

Permitirá registrar el equipamiento asociado a cada quirófano.

#### F. Equipo quirúrgico

#### RF-CIR-38 – Registrar integrante

Permitirá agregar profesionales al equipo quirúrgico.

#### RF-CIR-39 – Asignar función

Permitirá asignar el rol correspondiente a cada integrante.

#### RF-CIR-40 – Consultar equipo

Permitirá visualizar los integrantes asignados a una cirugía.

#### RF-CIR-41 – Modificar equipo

Permitirá modificar los integrantes antes del cierre del procedimiento.

#### RF-CIR-42 – Registrar participación

El sistema mantendrá el registro histórico de participación del personal.

#### G. Preparación e ingreso

#### RF-CIR-43 – Registrar preparación

Permitirá registrar el estado de preparación del paciente.

#### RF-CIR-44 – Registrar ingreso

Permitirá registrar el ingreso del paciente al área quirúrgica.

#### RF-CIR-45 – Registrar hora de ingreso

El sistema registrará automáticamente la fecha y hora.

#### RF-CIR-46 – Confirmar procedimiento

Permitirá confirmar el procedimiento antes de iniciar la cirugía.

#### RF-CIR-47 – Registrar observaciones

Permitirá registrar observaciones durante la preparación.

#### H. Anestesia

#### RF-CIR-48 – Registrar anestesiólogo

Permitirá registrar al profesional responsable.

#### RF-CIR-49 – Registrar procedimiento anestésico

Permitirá registrar la información correspondiente al procedimiento anestésico.

#### RF-CIR-50 – Registrar inicio de anestesia

Registrará fecha y hora de inicio.

#### RF-CIR-51 – Registrar finalización

Registrará fecha y hora de finalización.

#### RF-CIR-52 – Registrar medicamentos anestésicos

Permitirá registrar los medicamentos utilizados.

#### RF-CIR-53 – Registrar observaciones anestésicas

Permitirá registrar las observaciones correspondientes.

#### I. Procedimiento quirúrgico

#### RF-CIR-54 – Iniciar cirugía

El usuario autorizado podrá registrar el inicio de la cirugía.

#### RF-CIR-55 – Registrar hora de inicio

El sistema registrará automáticamente la hora.

#### RF-CIR-56 – Registrar cirujano

Registrará el cirujano responsable.

#### RF-CIR-57 – Registrar procedimiento realizado

Permitirá registrar el procedimiento efectivamente realizado.

#### RF-CIR-58 – Registrar diagnóstico preoperatorio

Permitirá registrar el diagnóstico previo al procedimiento.

#### RF-CIR-59 – Registrar diagnóstico postoperatorio

Permitirá registrar el diagnóstico posterior registrado por el profesional autorizado.

#### RF-CIR-60 – Registrar hallazgos

Permitirá registrar los hallazgos del procedimiento.

#### RF-CIR-61 – Registrar descripción operatoria

Permitirá registrar la descripción del procedimiento realizado.

#### RF-CIR-62 – Finalizar cirugía

Permitirá registrar la finalización del procedimiento.

#### RF-CIR-63 – Registrar hora de finalización

El sistema registrará automáticamente la hora.

#### J. Insumos y medicamentos

#### RF-CIR-64 – Registrar insumo utilizado

Permitirá registrar los insumos utilizados durante la cirugía.

#### RF-CIR-65 – Registrar cantidad

Permitirá registrar la cantidad utilizada.

#### RF-CIR-66 – Asociar lote

Cuando corresponda, permitirá asociar el lote del insumo o medicamento.

#### RF-CIR-67 – Registrar medicamento utilizado

Permitirá registrar medicamentos utilizados durante el procedimiento.

#### RF-CIR-68 – Integrar con Farmacia

El módulo podrá enviar los consumos correspondientes al módulo de Farmacia.

#### RF-CIR-69 – Integrar con Almacén

Permitirá registrar el consumo de materiales en Inventario/Almacén.

#### K. Incidencias y complicaciones

#### RF-CIR-70 – Registrar incidencia

Permitirá registrar una incidencia ocurrida durante el procedimiento.

#### RF-CIR-71 – Clasificar incidencia

Permitirá clasificar la incidencia.

#### RF-CIR-72 – Registrar descripción

Permitirá registrar la descripción detallada.

#### RF-CIR-73 – Registrar responsable

El sistema registrará al usuario que registra la incidencia.

#### RF-CIR-74 – Registrar acciones

Permitirá registrar las acciones realizadas o documentadas.

#### RF-CIR-75 – Consultar incidencias

Permitirá consultar incidencias asociadas a las cirugías.

#### L. Recuperación postoperatoria

#### RF-CIR-76 – Registrar ingreso a recuperación

Permitirá registrar el ingreso del paciente al área de recuperación.

#### RF-CIR-77 – Registrar salida

Permitirá registrar la salida del área de recuperación.

#### RF-CIR-78 – Registrar evolución

Permitirá registrar la evolución postoperatoria.

#### RF-CIR-79 – Registrar destino

Permitirá registrar el destino del paciente posterior al procedimiento.

#### RF-CIR-80 – Registrar observaciones

Permitirá registrar observaciones del período postoperatorio.

#### M. Cierre

#### RF-CIR-81 – Generar registro operatorio

El sistema permitirá generar el registro operatorio de la cirugía.

#### RF-CIR-82 – Validar información obligatoria

El sistema verificará que los datos requeridos estén completos antes del cierre.

#### RF-CIR-83 – Cerrar cirugía

El usuario autorizado podrá cerrar el procedimiento.

#### RF-CIR-84 – Bloquear edición

Una cirugía cerrada no podrá modificarse directamente.

#### RF-CIR-85 – Registrar correcciones

El sistema permitirá realizar correcciones mediante un proceso controlado.

#### RF-CIR-86 – Mantener historial

El sistema conservará el historial de modificaciones y versiones.

#### N. Historia Clínica

#### RF-CIR-87 – Integrar con Historia Clínica

El sistema asociará la cirugía con la Historia Clínica.

#### RF-CIR-88 – Consultar historial quirúrgico

Permitirá consultar las cirugías anteriores del paciente.

#### RF-CIR-89 – Consultar registro operatorio

Permitirá consultar los registros operatorios autorizados.

#### RF-CIR-90 – Consultar evolución

Permitirá consultar la evolución postoperatoria.

#### O. Reportes

#### RF-CIR-91 – Reporte de cirugías

Permitirá generar reportes de cirugías realizadas por período.

#### RF-CIR-92 – Reporte por especialidad

Permitirá obtener cirugías agrupadas por especialidad.

#### RF-CIR-93 – Reporte por cirujano

Permitirá consultar cirugías realizadas por cirujano.

#### RF-CIR-94 – Reporte por procedimiento

Permitirá consultar la cantidad de procedimientos realizados.

#### RF-CIR-95 – Reporte de utilización de quirófanos

Permitirá analizar la utilización de los quirófanos.

#### RF-CIR-96 – Reporte de cancelaciones

Permitirá consultar cirugías canceladas y sus motivos.

#### RF-CIR-97 – Reporte de reprogramaciones

Permitirá consultar las cirugías reprogramadas.

#### RF-CIR-98 – Reporte de tiempos

Permitirá analizar:
- Tiempo programado.
- Hora de ingreso.
- Inicio.
- Finalización.
- Tiempo de utilización del quirófano.
- Tiempo de recuperación.

#### RF-CIR-99 – Exportar reportes

Permitirá exportar reportes según los permisos del usuario.

### 26. Propuesta de base de datos

Una estructura inicial podría ser:

PACIENTE

```
   │
   ▼
```

SOLICITUD_CIRUGIA

```
   │
   ├── EVALUACION_PREOPERATORIA
   │
   ├── APROBACION_CIRUGIA
   │
   ▼
```

PROGRAMACION_CIRUGIA

```
   │
   ├── QUIROFANO
   ├── EQUIPO_QUIRURGICO
   └── PROCEDIMIENTO
          │
          ▼
     CIRUGIA
       │
       ├── ANESTESIA
       ├── REGISTRO_OPERATORIO
       ├── INSUMOS_CIRUGIA
       ├── MEDICAMENTOS_CIRUGIA
       ├── INCIDENCIA_CIRUGIA
       │
       ▼
```

RECUPERACION_POSTOPERATORIA

```
       │
       ▼
```

EVOLUCION_POSTOPERATORIA

```
       │
       ▼
```

HISTORIA_CLINICA

#### Tablas principales

solicitud_cirugia
- id_solicitud
- numero_solicitud
- paciente_id
- historia_clinica_id
- consulta_id
- medico_solicitante_id
- procedimiento_id
- diagnostico
- prioridad
- motivo
- observaciones
- estado
- fecha

evaluacion_preoperatoria
- id_evaluacion
- solicitud_id
- profesional_id
- fecha
- observaciones
- estado

programacion_cirugia
- id_programacion
- solicitud_id
- fecha
- hora_inicio
- hora_fin_estimada
- quirofano_id
- estado

quirofano
- id_quirofano
- codigo
- nombre
- ubicacion
- estado

equipo_quirofano
- id_equipo
- programacion_id
- profesional_id
- rol

cirugia
- id_cirugia
- programacion_id
- hora_ingreso
- hora_inicio
- hora_fin
- procedimiento_realizado
- diagnostico_preoperatorio
- diagnostico_postoperatorio
- hallazgos
- observaciones
- estado

anestesia
- id_anestesia
- cirugia_id
- anestesiologo_id
- tipo
- hora_inicio
- hora_fin
- observaciones

registro_operatorio
- id_registro
- cirugia_id
- descripcion
- hallazgos
- conclusion
- usuario
- fecha

insumo_cirugia
- id
- cirugia_id
- producto_id
- lote_id
- cantidad

medicamento_cirugia
- id
- cirugia_id
- medicamento_id
- lote_id
- cantidad
- observaciones

incidencia_cirugia
- id
- cirugia_id
- tipo
- descripcion
- fecha
- responsable
- acciones
- estado

recuperacion_postoperatoria
- id
- cirugia_id
- fecha_ingreso
- fecha_salida
- responsable
- observaciones
- destino

evolucion_postoperatoria
- id
- cirugia_id
- profesional_id
- fecha
- evolucion
- observaciones

### 27. Integración con los demás módulos

Este módulo tendrá bastante interacción con los módulos anteriores:

HISTORIA CLÍNICA

```
       │
       ▼
HOSPITALIZACIÓN ───────┐
       │               │
       ▼               ▼
   SOLICITUD ───► QUIRÓFANO
                       │
           ┌───────────┼───────────┐
           ▼           ▼           ▼
       FARMACIA    ALMACÉN     PERSONAL
           │           │
           └─────┬─────┘
                 ▼
              CIRUGÍA
                 │
                 ▼
          RECUPERACIÓN
                 │
                 ▼
          HISTORIA CLÍNICA
```

#### Integraciones importantes

| Módulo | Integración |
| --- | --- |
| Pacientes | Identificación del paciente |
| Historia Clínica | Registro de cirugía y evolución |
| Citas | Puede originar una evaluación/procedimiento programado |
| Médicos | Cirujanos y especialistas |
| Hospitalización | Pacientes internados |
| Enfermería | Preparación, cuidados y recuperación |
| Farmacia | Medicamentos utilizados |
| Almacén | Insumos y materiales |
| Facturación | Cobro del procedimiento |
| Seguros | Autorizaciones/cobertura |
| Reportes | Estadísticas quirúrgicas |

## MÓDULO 13 – FACTURACIÓN Y CAJA

### 1. Objetivo del módulo

El módulo de Facturación y Caja permitirá gestionar los cargos generados por las atenciones y servicios del hospital, así como los pagos realizados por los pacientes, familiares, empresas o aseguradoras.

Debe integrar los servicios de:
- Consultas médicas.
- Emergencias.
- Hospitalización.
- Laboratorio.
- Diagnóstico por imágenes.
- Cirugías.
- Farmacia.
- Procedimientos.
- Otros servicios configurables.

El flujo general será:

ATENCIÓN / SERVICIO

       ↓

GENERACIÓN DE CARGO

       ↓

CUENTA DEL PACIENTE

       ↓

FACTURACIÓN

       ↓

PAGO

       ↓

CAJA

       ↓

COMPROBANTE

       ↓

CIERRE DE CAJA

       ↓

REPORTES

### 2. Concepto importante: cargo ≠ pago ≠ comprobante

Para diseñar correctamente el sistema, recomiendo separar estos conceptos.

#### Cargo

Representa lo que el paciente debe pagar.

Ejemplo:

```
Consulta médica        S/ 80.00
Laboratorio             S/ 50.00
Radiografía            S/ 70.00
Medicamentos           S/ 45.00
```

--------------------------------

TOTAL                   S/245.00

#### Pago

Representa el dinero que efectivamente entregó el paciente.

#### Comprobante

Representa el documento emitido por el sistema por la operación correspondiente.

Esto permitirá manejar correctamente:
- pagos parciales;
- deudas;
- créditos;
- anulaciones;
- devoluciones;
- seguros;
- múltiples pagos.

### 3. Flujo general

PACIENTE

```
   │
   ▼
```

ATENCIÓN MÉDICA

```
   │
   ├── Consulta
   ├── Laboratorio
   ├── Imágenes
   ├── Cirugía
   ├── Hospitalización
   ├── Farmacia
   └── Procedimientos
   │
   ▼
```

GENERACIÓN DE CARGOS

```
   │
   ▼
```

CUENTA DEL PACIENTE

```
   │
   ▼
```

FACTURACIÓN

```
   │
   ├── Boleta
   ├── Factura
   └── Otros documentos
   │
   ▼
```

PAGO

```
   │
   ├── Efectivo
   ├── Tarjeta
   ├── Transferencia
   ├── Yape/Plin
   └── Otros
   │
   ▼
```

CAJA

```
   │
   ▼
```

CIERRE

### 4. Menú principal

FACTURACIÓN Y CAJA

```
│
├── Dashboard
│
├── Cuentas de pacientes
├── Cargos
├── Tarifario
├── Facturación
├── Comprobantes
│
├── Pagos
├── Pagos parciales
├── Créditos / Deudas
├── Devoluciones
├── Anulaciones
│
├── Caja
│   ├── Apertura de caja
│   ├── Movimientos
│   ├── Ingresos
│   ├── Egresos
│   ├── Cierre de caja
│   └── Arqueo
│
├── Métodos de pago
├── Convenios / Empresas
├── Seguros
│
├── Reportes
└── Auditoría
```

### 5. Dashboard

El dashboard permitirá al responsable financiero conocer el estado económico del establecimiento.

#### Indicadores

```
FACTURACIÓN DEL DÍA       S/ 15,850
PAGOS RECIBIDOS           S/ 12,450
CUENTAS PENDIENTES        S/  3,400
DEVOLUCIONES              S/    350
```

También:
- Comprobantes emitidos.
- Boletas.
- Facturas.
- Pagos en efectivo.
- Pagos con tarjeta.
- Transferencias.
- Pagos digitales.
- Créditos otorgados.
- Deudas pendientes.
- Cajas abiertas.
- Cajas cerradas.

#### Gráficos

- Ingresos por día.
- Ingresos por servicio.
- Ingresos por especialidad.
- Métodos de pago.
- Cuentas por cobrar.
- Facturación mensual.

### 6. Tarifario

El hospital debe contar con un catálogo de servicios y precios.

Ejemplo:

| Código | Servicio | Precio |
| --- | --- | --- |
| SER-001 | Consulta médica | S/ 80 |
| SER-002 | Emergencia | S/ 120 |
| SER-003 | Radiografía | S/ 70 |
| SER-004 | Ecografía | S/ 100 |
| SER-005 | Análisis de sangre | S/ 50 |
| SER-006 | Hospitalización/día | S/ 250 |
| SER-007 | Procedimiento quirúrgico | Según tarifario |

El precio puede variar dependiendo de:
- Tipo de paciente.
- Seguro.
- Convenio.
- Empresa.
- Particular.
- Campaña.
- Tarifario vigente.

### 7. Cargos

Los diferentes módulos pueden generar cargos automáticamente.

Ejemplo:

CONSULTA MÉDICA

      ↓

Cargo S/ 80

LABORATORIO

      ↓

Cargo S/ 50

DIAGNÓSTICO POR IMÁGENES

      ↓

Cargo S/ 70

CIRUGÍA

      ↓

Cargo según procedimiento

Esto evita que el personal de caja tenga que registrar manualmente todos los servicios.

### 8. Cuenta del paciente

La cuenta permitirá visualizar todos los cargos del paciente.

Ejemplo:

PACIENTE: Juan Pérez

HC: HC-000125

--------------------------------------

SERVICIO              IMPORTE

--------------------------------------

```
Consulta médica       S/ 80.00
Laboratorio            S/ 50.00
Radiografía            S/ 70.00
Medicamentos           S/ 45.00
```

--------------------------------------

```
TOTAL                  S/245.00
Pagado                 S/200.00
Pendiente               S/45.00
```

Esto es especialmente importante para pacientes hospitalizados.

### 9. Cuenta hospitalaria

Durante una hospitalización pueden generarse cargos diariamente.

HOSPITALIZACIÓN

```
      │
      ├── Habitación
      ├── Alimentación
      ├── Medicamentos
      ├── Laboratorio
      ├── Imágenes
      ├── Procedimientos
      ├── Materiales
      └── Otros servicios
              │
              ▼
        CUENTA HOSPITALARIA
```

La cuenta se va acumulando hasta el alta.

### 10. Facturación

El usuario autorizado podrá generar documentos a partir de los cargos.

Información:
- Paciente.
- Tipo de documento.
- Cliente/pagador.
- DNI/RUC.
- Dirección cuando corresponda.
- Servicios.
- Cantidad.
- Precio.
- Descuentos.
- Impuestos según corresponda.
- Total.
- Forma de pago.
- Fecha.

### 11. Tipos de comprobantes

Para un sistema en Perú, la arquitectura debería permitir trabajar con documentos electrónicos compatibles con la normativa y proveedor/servicio de facturación que utilice el establecimiento.

Por ejemplo:
- Boleta electrónica.
- Factura electrónica.
- Nota de crédito.
- Nota de débito.

También debe contemplarse la posibilidad de integrar posteriormente el sistema con SUNAT mediante el mecanismo de facturación electrónica elegido.

### 12. Estados del comprobante

BORRADOR

   ↓

EMITIDO

   ↓

ACEPTADO

También:

RECHAZADO

ANULADO

OBSERVADO

La situación exacta dependerá de la integración de facturación electrónica utilizada.

### 13. Pagos

El sistema permitirá registrar pagos.

#### Métodos

- Efectivo.
- Tarjeta de crédito.
- Tarjeta de débito.
- Transferencia bancaria.
- Yape.
- Plin.
- Depósito.
- Otros.

Ejemplo:

```
TOTAL               S/ 500.00
Pago efectivo       S/ 200.00
Pago Yape          S/ 300.00
TOTAL PAGADO        S/ 500.00
SALDO               S/   0.00
```

### 14. Pagos parciales

Un paciente puede no cancelar toda su deuda.

Ejemplo:

```
Cuenta total          S/ 1,000
Primer pago         S/   300
Segundo pago       S/   200
```

--------------------------

```
Pagado                S/   500
Saldo                  S/   500
```

Por eso no recomiendo tener simplemente un campo:

pagado = true/false

Es mejor manejar una tabla de pagos.

### 15. Créditos / cuentas por cobrar

El sistema permitirá controlar pacientes que tienen deuda.

Ejemplo:

PACIENTE              DEUDA

--------------------------------

```
Juan Pérez            S/ 500
María López           S/ 250
Pedro Díaz            S/ 850
```

--------------------------------

TOTAL                 S/1,600

Debe permitir:
- Consultar deuda.
- Registrar abonos.
- Ver vencimientos.
- Historial de pagos.
- Estado de cuenta.
- Reporte de morosidad.

### 16. Caja

La caja representa el punto donde se registran los movimientos de dinero.

#### Apertura

El cajero registra:

CAJA: Caja 01

USUARIO: Cajero 01

Monto inicial:

S/ 500.00

Fecha:

06/09/2026

### 17. Movimientos de caja

Se deben registrar:

#### Ingresos

- Pago de consulta.
- Pago de laboratorio.
- Pago de imágenes.
- Pago de hospitalización.
- Pago de cirugía.
- Pago de farmacia.
- Otros.

#### Egresos

- Devoluciones.
- Gastos autorizados.
- Retiros.
- Otros movimientos configurables.

### 18. Arqueo de caja

Al finalizar el turno:

```
MONTO INICIAL        S/ 500
INGRESOS             S/ 4,500
EGRESOS              S/ 300
```

--------------------------------

SALDO ESPERADO      S/ 4,700

El cajero registra el efectivo contado y el sistema compara:

SALDO ESPERADO

       vs

SALDO CONTADO

Resultado:

Sobrante

Faltante

Cuadrado

### 19. Cierre de caja

El cierre deberá registrar:
- Usuario.
- Fecha.
- Hora.
- Caja.
- Monto inicial.
- Total ingresos.
- Total egresos.
- Efectivo esperado.
- Efectivo contado.
- Diferencia.
- Observaciones.

Una caja cerrada no debe poder modificarse directamente.

### 20. Devoluciones

El sistema debe permitir registrar devoluciones de dinero.

Ejemplo:

```
Pago original         S/ 200
Monto devolución      S/  50
Saldo                  S/ 150
```

La devolución debe registrar:
- Motivo.
- Usuario autorizado.
- Fecha.
- Monto.
- Medio de devolución.
- Documento relacionado.

### 21. Anulación

Las operaciones no deberían eliminarse físicamente.

En lugar de:

DELETE factura

se recomienda:

Estado = ANULADO

y guardar:
- Usuario.
- Fecha.
- Hora.
- Motivo.

Esto es fundamental para auditoría.

### 22. Integración con Seguros

El módulo debe estar preparado para trabajar con:

PACIENTE PARTICULAR

```
       │
       ▼
```

PAGO DIRECTO

o:

PACIENTE ASEGURADO

```
       │
       ▼
```

SEGURO

```
       │
       ├── Cobertura
       ├── Copago
       └── Deducible
              │
              ▼
        CUENTA PACIENTE
```

Esto será desarrollado con mayor profundidad en el Módulo 14 – Seguros.

### 23. Requisitos funcionales

#### A. Tarifario

#### RF-FAC-01 – Registrar servicio

El sistema permitirá registrar los servicios facturables del establecimiento.

#### RF-FAC-02 – Modificar servicio

Permitirá modificar los datos de un servicio.

#### RF-FAC-03 – Configurar precio

Permitirá establecer el precio del servicio.

#### RF-FAC-04 – Activar/Inactivar servicio

Permitirá controlar la disponibilidad de los servicios.

#### RF-FAC-05 – Configurar tarifas

Permitirá administrar diferentes tarifas según las condiciones configuradas.

#### RF-FAC-06 – Consultar tarifario

Permitirá consultar los servicios y precios vigentes.

#### B. Cargos

#### RF-FAC-07 – Generar cargo

El sistema permitirá generar un cargo asociado a un servicio realizado.

#### RF-FAC-08 – Asociar cargo al paciente

Todo cargo deberá estar asociado al paciente correspondiente.

#### RF-FAC-09 – Asociar atención

El cargo podrá asociarse a una consulta, hospitalización, laboratorio, imagen, cirugía u otro servicio.

#### RF-FAC-10 – Registrar cantidad

Permitirá registrar la cantidad del servicio.

#### RF-FAC-11 – Calcular importe

El sistema calculará automáticamente el importe.

#### RF-FAC-12 – Aplicar descuento

Permitirá aplicar descuentos de acuerdo con los permisos configurados.

#### RF-FAC-13 – Consultar cargos

Permitirá consultar cargos por paciente, fecha, servicio y estado.

#### RF-FAC-14 – Anular cargo

Permitirá anular un cargo registrando el motivo y responsable.

#### C. Cuenta del paciente

#### RF-FAC-15 – Generar cuenta

El sistema permitirá generar la cuenta económica del paciente.

#### RF-FAC-16 – Acumular cargos

Permitirá acumular los diferentes servicios consumidos.

#### RF-FAC-17 – Consultar saldo

Permitirá consultar el saldo pendiente.

#### RF-FAC-18 – Consultar estado de cuenta

Permitirá visualizar cargos, pagos y saldo.

#### RF-FAC-19 – Registrar responsable de pago

Permitirá registrar al paciente o tercero responsable del pago.

#### RF-FAC-20 – Cerrar cuenta

Permitirá cerrar una cuenta cuando se hayan cumplido las condiciones establecidas.

#### D. Facturación

#### RF-FAC-21 – Generar comprobante

El sistema permitirá generar un comprobante a partir de los cargos.

#### RF-FAC-22 – Registrar tipo de comprobante

Permitirá seleccionar el tipo de comprobante correspondiente.

#### RF-FAC-23 – Registrar datos del cliente

Permitirá registrar los datos requeridos del receptor.

#### RF-FAC-24 – Calcular total

El sistema calculará automáticamente subtotal, descuentos, impuestos cuando correspondan y total.

#### RF-FAC-25 – Emitir comprobante

Permitirá emitir el comprobante.

#### RF-FAC-26 – Consultar comprobantes

Permitirá consultar comprobantes emitidos.

#### RF-FAC-27 – Anular comprobante

Permitirá gestionar la anulación mediante el proceso correspondiente.

#### RF-FAC-28 – Registrar estado de emisión

Permitirá registrar el estado de la emisión electrónica.

#### RF-FAC-29 – Generar representación del comprobante

Permitirá generar la representación correspondiente, como PDF, según la configuración.

#### RF-FAC-30 – Enviar comprobante

Permitirá enviar el comprobante por los medios habilitados.

#### E. Pagos

#### RF-FAC-31 – Registrar pago

El sistema permitirá registrar pagos de los pacientes.

#### RF-FAC-32 – Registrar método de pago

Permitirá seleccionar el método utilizado.

#### RF-FAC-33 – Registrar monto

Permitirá registrar el monto pagado.

#### RF-FAC-34 – Registrar referencia

Permitirá registrar una referencia de operación cuando corresponda.

#### RF-FAC-35 – Registrar pago parcial

Permitirá registrar pagos parciales.

#### RF-FAC-36 – Registrar múltiples pagos

Una cuenta podrá tener múltiples pagos.

#### RF-FAC-37 – Calcular saldo

El sistema calculará automáticamente el saldo pendiente.

#### RF-FAC-38 – Consultar historial de pagos

Permitirá consultar todos los pagos realizados.

#### RF-FAC-39 – Anular pago

Permitirá anular un pago mediante autorización y motivo.

#### F. Créditos y cuentas por cobrar

#### RF-FAC-40 – Registrar crédito

Permitirá registrar una operación a crédito cuando esté autorizada.

#### RF-FAC-41 – Registrar vencimiento

Permitirá establecer la fecha de vencimiento.

#### RF-FAC-42 – Registrar abono

Permitirá registrar abonos a una deuda.

#### RF-FAC-43 – Consultar deuda

Permitirá consultar las deudas pendientes.

#### RF-FAC-44 – Generar estado de cuenta

Permitirá generar el estado de cuenta del paciente o responsable.

#### RF-FAC-45 – Reportar morosidad

Permitirá generar reportes de cuentas vencidas.

#### G. Caja

#### RF-FAC-46 – Registrar caja

Permitirá registrar las cajas disponibles.

#### RF-FAC-47 – Abrir caja

El cajero podrá realizar la apertura de caja.

#### RF-FAC-48 – Registrar monto inicial

Permitirá registrar el fondo inicial.

#### RF-FAC-49 – Registrar ingreso

Permitirá registrar ingresos de dinero.

#### RF-FAC-50 – Registrar egreso

Permitirá registrar egresos autorizados.

#### RF-FAC-51 – Consultar movimientos

Permitirá consultar movimientos de caja.

#### RF-FAC-52 – Realizar arqueo

Permitirá realizar el arqueo de caja.

#### RF-FAC-53 – Calcular saldo esperado

El sistema calculará el saldo esperado.

#### RF-FAC-54 – Registrar saldo contado

Permitirá registrar el dinero efectivamente contado.

#### RF-FAC-55 – Calcular diferencia

El sistema determinará sobrantes o faltantes.

#### RF-FAC-56 – Cerrar caja

Permitirá cerrar la caja.

#### RF-FAC-57 – Bloquear caja cerrada

Una caja cerrada no podrá modificarse directamente.

#### H. Devoluciones

#### RF-FAC-58 – Registrar devolución

Permitirá registrar una devolución de dinero.

#### RF-FAC-59 – Asociar devolución

La devolución deberá asociarse a la operación original.

#### RF-FAC-60 – Registrar motivo

Permitirá registrar el motivo de devolución.

#### RF-FAC-61 – Autorizar devolución

Permitirá establecer niveles de autorización.

#### RF-FAC-62 – Registrar medio de devolución

Permitirá registrar el medio utilizado para devolver el dinero.

#### I. Integración con seguros

#### RF-FAC-63 – Identificar cobertura

El sistema permitirá identificar si el servicio está cubierto.

#### RF-FAC-64 – Registrar copago

Permitirá registrar el copago correspondiente.

#### RF-FAC-65 – Registrar monto aseguradora

Permitirá registrar el monto que corresponde a la aseguradora.

#### RF-FAC-66 – Registrar deducible

Permitirá registrar el deducible cuando corresponda.

#### RF-FAC-67 – Generar cuenta diferenciada

Permitirá diferenciar el importe del paciente y el correspondiente al seguro.

#### J. Integración con módulos clínicos

#### RF-FAC-68 – Integrar consulta médica

Permitirá generar cargos provenientes de consultas.

#### RF-FAC-69 – Integrar laboratorio

Permitirá generar cargos por estudios de laboratorio.

#### RF-FAC-70 – Integrar imágenes

Permitirá generar cargos por diagnóstico por imágenes.

#### RF-FAC-71 – Integrar cirugía

Permitirá generar cargos por procedimientos quirúrgicos.

#### RF-FAC-72 – Integrar hospitalización

Permitirá acumular cargos de hospitalización.

#### RF-FAC-73 – Integrar farmacia

Permitirá generar cargos por medicamentos y productos dispensados.

#### RF-FAC-74 – Integrar otros servicios

Permitirá incorporar nuevos servicios facturables.

#### K. Reportes

#### RF-FAC-75 – Reporte de ingresos

Permitirá consultar ingresos por período.

#### RF-FAC-76 – Reporte de facturación

Permitirá consultar la facturación generada.

#### RF-FAC-77 – Reporte por servicio

Permitirá consultar ingresos por servicio.

#### RF-FAC-78 – Reporte por especialidad

Permitirá consultar ingresos por especialidad.

#### RF-FAC-79 – Reporte por método de pago

Permitirá consultar ingresos según método de pago.

#### RF-FAC-80 – Reporte de cuentas pendientes

Permitirá consultar cuentas por cobrar.

#### RF-FAC-81 – Reporte de pagos

Permitirá consultar pagos realizados.

#### RF-FAC-82 – Reporte de cajas

Permitirá consultar aperturas, movimientos y cierres.

#### RF-FAC-83 – Reporte de arqueos

Permitirá consultar los arqueos realizados.

#### RF-FAC-84 – Reporte de anulaciones

Permitirá consultar documentos y operaciones anuladas.

#### RF-FAC-85 – Reporte de devoluciones

Permitirá consultar devoluciones realizadas.

#### RF-FAC-86 – Exportar reportes

Permitirá exportar los reportes según los permisos establecidos.

### 24. Base de datos propuesta

Una estructura inicial podría ser:

PACIENTE

```
   │
   ▼
```

CUENTA_PACIENTE

```
   │
   ├── CARGO
   │      │
   │      └── SERVICIO
   │
   ├── COMPROBANTE
   │
   └── PAGO
          │
          ▼
        CAJA
          │
          ├── MOVIMIENTO_CAJA
          └── CIERRE_CAJA
```

#### Tablas principales

servicio
- id_servicio
- codigo
- nombre
- descripcion
- categoria
- precio
- estado

tarifa
- id_tarifa
- servicio_id
- nombre
- precio
- vigencia_inicio
- vigencia_fin
- estado

cuenta_paciente
- id_cuenta
- paciente_id
- responsable_pago
- fecha_apertura
- fecha_cierre
- total
- pagado
- saldo
- estado

cargo
- id_cargo
- cuenta_id
- servicio_id
- paciente_id
- modulo_origen
- referencia_id
- cantidad
- precio_unitario
- descuento
- importe
- estado
- fecha

comprobante
- id_comprobante
- tipo
- serie
- numero
- cuenta_id
- cliente
- documento_cliente
- subtotal
- impuesto
- total
- estado
- fecha_emision

pago
- id_pago
- cuenta_id
- comprobante_id
- monto
- metodo_pago
- referencia
- fecha
- usuario
- estado

caja
- id_caja
- codigo
- nombre
- ubicacion
- estado

apertura_caja
- id_apertura
- caja_id
- usuario_id
- fecha
- hora
- monto_inicial
- estado

movimiento_caja
- id_movimiento
- apertura_id
- tipo
- concepto
- monto
- referencia
- fecha
- usuario_id

cierre_caja
- id_cierre
- apertura_id
- monto_esperado
- monto_contado
- diferencia
- observaciones
- fecha
- usuario_id

devolucion
- id_devolucion
- pago_id
- monto
- motivo
- medio
- autorizado_por
- fecha
- estado

### 25. Integración general

El módulo quedaría conectado con prácticamente todo el sistema:

```
                    PACIENTE
                       │
                       ▼
                HISTORIA CLÍNICA
                       │
       ┌───────────────┼────────────────┐
       ▼               ▼                ▼
    CONSULTA       LABORATORIO      IMÁGENES
       │               │                │
       └───────────────┼────────────────┘
                       ▼
                    CARGOS
                       │
       ┌───────────────┼────────────────┐
       ▼               ▼                ▼
    CIRUGÍA       HOSPITALIZACIÓN    FARMACIA
       │               │                │
       └───────────────┼────────────────┘
                       ▼
                 CUENTA PACIENTE
                       │
                       ▼
                  FACTURACIÓN
                       │
                       ▼
                     PAGO
                       │
                       ▼
                     CAJA
                       │
                       ▼
                    REPORTES
```

#### Resultado

## MÓDULO 14 – SEGUROS

### 1. Objetivo del módulo

El Módulo de Seguros permitirá gestionar la relación entre el hospital, los pacientes y las compañías aseguradoras, controlando:
- Aseguradoras.
- Planes y pólizas.
- Afiliación del paciente.
- Coberturas.
- Prestaciones cubiertas.
- Copagos.
- Deducibles.
- Autorizaciones.
- Cartas de garantía.
- Consumos médicos.
- Liquidaciones.
- Cuentas por cobrar a aseguradoras.
- Rechazos y observaciones.
- Historial de atenciones aseguradas.

Este módulo se conectará especialmente con:

Paciente → Seguro → Atención → Cobertura → Autorización → Prestación → Liquidación → Aseguradora

### 2. Flujo general

PACIENTE

```
   │
   ▼
```

REGISTRO DE SEGURO

```
   │
   ▼
```

VALIDACIÓN DE AFILIACIÓN

```
   │
   ▼
```

CONSULTA DE COBERTURA

```
   │
   ▼
```

ATENCIÓN MÉDICA

```
   │
   ▼
```

SOLICITUD DE AUTORIZACIÓN

```
   │
   ▼
```

AUTORIZACIÓN / CARTA DE GARANTÍA

```
   │
   ▼
```

PRESTACIÓN DEL SERVICIO

```
   │
   ├── Consulta
   ├── Laboratorio
   ├── Imágenes
   ├── Cirugía
   ├── Hospitalización
   └── Farmacia
   │
   ▼
```

LIQUIDACIÓN

```
   │
   ├── Monto aseguradora
   ├── Copago paciente
   └── Deducible
   │
   ▼
```

CUENTA POR COBRAR

```
   │
   ▼
```

ASEGURADORA

### 3. Menú principal

SEGUROS

```
│
├── Dashboard
│
├── Aseguradoras
├── Planes de seguro
├── Pólizas
├── Afiliados
├── Coberturas
├── Tarifas / Convenios
│
├── Validación de afiliación
├── Autorizaciones
├── Cartas de garantía
├── Prestaciones
│
├── Copagos
├── Deducibles
├── Cuentas de aseguradoras
├── Liquidaciones
├── Facturación a aseguradoras
│
├── Rechazos / Observaciones
├── Conciliación de pagos
│
├── Reportes
└── Auditoría
```

### 4. Dashboard

El dashboard permitirá conocer rápidamente la situación de las atenciones mediante seguros.

#### Indicadores

```
ASEGURADORAS ACTIVAS                       8
PACIENTES ASEGURADOS                      850
AUTORIZACIONES PENDIENTES                    24
CARTAS DE GARANTÍA                           12
PRESTACIONES DEL MES                       450
POR COBRAR A ASEGURADORAS    S/ 85,400
RECHAZOS                                    18
```

#### Gráficos

- Atenciones por aseguradora.
- Ingresos por aseguradora.
- Prestaciones por tipo.
- Autorizaciones aprobadas/rechazadas.
- Copagos.
- Deducibles.
- Cuentas pendientes.
- Rechazos por aseguradora.

### 5. Aseguradoras

El sistema permitirá registrar las compañías de seguros con las que trabaja el hospital.

#### Datos

- Código.
- RUC.
- Razón social.
- Nombre comercial.
- Dirección.
- Teléfono.
- Correo.
- Contacto.
- Estado.
- Observaciones.

Ejemplo:

| Código | Aseguradora | RUC | Estado |
| --- | --- | --- | --- |
| SEG-001 | Aseguradora A | 20XXXXXXXXX | Activa |
| SEG-002 | Aseguradora B | 20XXXXXXXXX | Activa |
| SEG-003 | Aseguradora C | 20XXXXXXXXX | Inactiva |

### 6. Planes de seguro

Una aseguradora puede tener diferentes planes.

ASEGURADORA

```
    │
    ├── PLAN BÁSICO
    ├── PLAN ESTÁNDAR
    ├── PLAN PREMIUM
    └── PLAN EMPRESARIAL
```

Cada plan puede tener diferentes:
- Coberturas.
- Límites.
- Copagos.
- Deducibles.
- Servicios incluidos.
- Exclusiones.

### 7. Pólizas

La póliza representa el contrato o cobertura del asegurado.

Datos:
- Número de póliza.
- Aseguradora.
- Plan.
- Fecha de inicio.
- Fecha de vencimiento.
- Titular.
- Estado.
- Condiciones.

Estados:

ACTIVA

VENCIDA

SUSPENDIDA

CANCELADA

### 8. Afiliación del paciente

Un paciente puede tener uno o más seguros.

Ejemplo:

PACIENTE

```
   │
   ├── Seguro principal
   │
   └── Seguro secundario
```

Datos:
- Paciente.
- Aseguradora.
- Número de afiliado.
- Número de póliza.
- Plan.
- Titular.
- Parentesco.
- Vigencia.
- Estado.

### 9. Validación de afiliación

Antes de atender al paciente bajo un seguro, el personal debe poder verificar su afiliación.

PACIENTE

   ↓

SEGURO

   ↓

N° AFILIACIÓN

   ↓

VALIDACIÓN

   ↓

¿Vigente?

```
 ┌───────┴───────┐
 SÍ              NO
 ↓                ↓
CONTINUAR       OBSERVAR
```

La validación puede realizarse:
- Manualmente.
- Mediante integración con la aseguradora.
- Mediante API, si la aseguradora dispone de ella.

### 10. Coberturas

El sistema debe definir qué servicios están cubiertos.

Ejemplo:

| Servicio | Cobertura | Copago |
| --- | --- | --- |
| Consulta | 90% | 10% |
| Laboratorio | 80% | 20% |
| Imágenes | 80% | 20% |
| Hospitalización | 90% | 10% |
| Cirugía | Según plan | Según plan |

Importante: estos porcentajes son ejemplos de configuración; el sistema debe utilizar los valores definidos en cada contrato/plan.

### 11. Límites de cobertura

Una cobertura puede tener límites.

Por ejemplo:

Cobertura:

Laboratorio

Límite:

S/ 2,000 anual

Consumido:

S/ 1,500

Disponible:

S/ 500

También puede existir límite:
- Por evento.
- Por año.
- Por procedimiento.
- Por número de atenciones.
- Por afiliado.

### 12. Exclusiones

El sistema puede registrar servicios que no están cubiertos por determinado plan.

Ejemplo:

PLAN PREMIUM

```
│
├── Consulta              ✓
├── Laboratorio           ✓
├── Imágenes              ✓
├── Hospitalización       ✓
└── Servicio excluido     ✗
```

Cuando un servicio no esté cubierto, el sistema debe advertirlo antes de generar la liquidación.

### 13. Autorizaciones

Algunos procedimientos pueden requerir autorización previa de la aseguradora.

Flujo:

MÉDICO

   ↓

SOLICITUD DE PROCEDIMIENTO

   ↓

SEGUROS

   ↓

SOLICITUD DE AUTORIZACIÓN

   ↓

ASEGURADORA

   ↓

APROBADA / RECHAZADA

Datos:
- Número de autorización.
- Aseguradora.
- Paciente.
- Póliza.
- Servicio.
- Procedimiento.
- Médico.
- Fecha de solicitud.
- Fecha de respuesta.
- Estado.
- Observaciones.

### 14. Estados de autorización

PENDIENTE

   ↓

ENVIADA

   ↓

EN REVISIÓN

   ↓

APROBADA

También:

RECHAZADA

OBSERVADA

CANCELADA

VENCIDA

### 15. Carta de garantía

Para determinados servicios, la aseguradora puede emitir una carta de garantía.

El sistema deberá permitir registrar:
- Número.
- Aseguradora.
- Paciente.
- Procedimiento.
- Monto autorizado.
- Fecha de emisión.
- Vigencia.
- Estado.
- Documento adjunto o referencia documental.

Ejemplo:

CARTA DE GARANTÍA

N.º: CG-000125

Paciente:

Juan Pérez

Procedimiento:

Cirugía

Monto autorizado:

S/ 8,500

Vigencia:

10/09/2026 - 20/09/2026

Estado:

APROBADA

### 16. Prestaciones

Una prestación representa un servicio brindado al asegurado.

Puede originarse desde:
- Consulta.
- Emergencia.
- Hospitalización.
- Laboratorio.
- Diagnóstico por imágenes.
- Cirugía.
- Farmacia.
- Procedimiento.

Ejemplo:

PACIENTE

   ↓

ATENCIÓN

   ↓

PRESTACIÓN

   ↓

COBERTURA

   ↓

ASEGURADORA

### 17. Copagos

El sistema debe calcular o registrar el monto que corresponde pagar al paciente.

Ejemplo:

```
Servicio                    S/ 500
Seguro cubre               S/ 450
Copago paciente              S/  50
```

--------------------------------

Total                       S/ 500

El porcentaje o monto debe provenir de la configuración del plan/convenio y de las condiciones aplicables.

### 18. Deducibles

El deducible es un importe que puede corresponder asumir al asegurado antes de aplicar la cobertura, según las condiciones de la póliza.

Ejemplo conceptual:

Deducible configurado: S/ 1,000

Gasto cubierto: S/ 3,000

```
Deducible:       S/ 1,000
Seguro:          S/ 2,000
```

El sistema debe permitir configurar diferentes reglas de deducibles.

### 19. Liquidación a aseguradora

Después de brindar los servicios, el hospital deberá preparar la información para cobrar a la aseguradora.

PRESTACIONES

     ↓

VALIDACIÓN

     ↓

LIQUIDACIÓN

     ↓

ASEGURADORA

     ↓

CUENTA POR COBRAR

La liquidación puede contener:
- Paciente.
- Póliza.
- Autorización.
- Servicio.
- Fecha.
- Código de prestación.
- Monto.
- Copago.
- Deducible.
- Monto aseguradora.
- Documentos sustentatorios.

### 20. Rechazos

La aseguradora puede observar o rechazar una prestación.

El sistema debe permitir registrar:
- Prestación.
- Aseguradora.
- Motivo.
- Fecha.
- Monto observado.
- Responsable.
- Estado.
- Respuesta.
- Subsanación.

Estados:

OBSERVADO

   ↓

EN SUBSANACIÓN

   ↓

REENVIADO

   ↓

ACEPTADO

O:

RECHAZADO

### 21. Conciliación de pagos

Cuando la aseguradora realiza un pago, el hospital debe poder conciliarlo con las liquidaciones.

LIQUIDACIÓN

     ↓

CUENTA POR COBRAR

     ↓

PAGO ASEGURADORA

     ↓

CONCILIACIÓN

     ↓

SALDO

Ejemplo:

```
Liquidación        S/ 50,000
Pago aseguradora   S/ 45,000
```

---------------------------

Saldo               S/ 5,000

### 22. Requisitos funcionales

#### A. Aseguradoras

#### RF-SEG-01 – Registrar aseguradora

El sistema permitirá registrar compañías aseguradoras.

#### RF-SEG-02 – Modificar aseguradora

Permitirá modificar sus datos.

#### RF-SEG-03 – Activar/Inactivar aseguradora

Permitirá cambiar el estado de la aseguradora.

#### RF-SEG-04 – Consultar aseguradoras

Permitirá buscar aseguradoras por código, RUC, nombre o estado.

#### RF-SEG-05 – Registrar contacto

Permitirá registrar los contactos de la aseguradora.

#### B. Planes

#### RF-SEG-06 – Registrar plan

Permitirá registrar planes asociados a una aseguradora.

#### RF-SEG-07 – Modificar plan

Permitirá modificar la información del plan.

#### RF-SEG-08 – Configurar vigencia

Permitirá establecer la vigencia del plan.

#### RF-SEG-09 – Configurar coberturas

Permitirá asociar coberturas al plan.

#### RF-SEG-10 – Configurar exclusiones

Permitirá registrar servicios excluidos.

#### RF-SEG-11 – Configurar límites

Permitirá configurar límites de cobertura.

#### C. Pólizas

#### RF-SEG-12 – Registrar póliza

Permitirá registrar pólizas.

#### RF-SEG-13 – Asociar póliza

Permitirá asociar una póliza a un plan y aseguradora.

#### RF-SEG-14 – Registrar titular

Permitirá registrar al titular de la póliza.

#### RF-SEG-15 – Registrar vigencia

Permitirá registrar fechas de inicio y vencimiento.

#### RF-SEG-16 – Consultar póliza

Permitirá consultar el estado y datos de la póliza.

#### RF-SEG-17 – Actualizar estado

Permitirá cambiar el estado de la póliza.

#### D. Afiliados

#### RF-SEG-18 – Registrar afiliación

Permitirá asociar un paciente a una aseguradora.

#### RF-SEG-19 – Registrar número de afiliado

Permitirá registrar el código o número de afiliación.

#### RF-SEG-20 – Registrar parentesco

Permitirá registrar la relación entre titular y beneficiario.

#### RF-SEG-21 – Asociar plan

Permitirá asociar el afiliado con su plan.

#### RF-SEG-22 – Consultar seguros del paciente

Permitirá consultar los seguros asociados al paciente.

#### RF-SEG-23 – Registrar seguro principal

Permitirá establecer el seguro principal cuando corresponda.

#### RF-SEG-24 – Registrar seguro secundario

Permitirá registrar coberturas secundarias cuando correspondan.

#### E. Validación

#### RF-SEG-25 – Validar afiliación

Permitirá verificar la vigencia de la afiliación.

#### RF-SEG-26 – Registrar resultado de validación

Permitirá registrar el resultado de la validación.

#### RF-SEG-27 – Registrar fecha de validación

El sistema registrará fecha y hora.

#### RF-SEG-28 – Registrar usuario

El sistema registrará quién realizó la validación.

#### RF-SEG-29 – Integrar validación externa

El sistema podrá integrarse con servicios/API de aseguradoras cuando estén disponibles.

#### F. Coberturas

#### RF-SEG-30 – Registrar cobertura

Permitirá registrar coberturas.

#### RF-SEG-31 – Asociar servicio

Permitirá asociar servicios a una cobertura.

#### RF-SEG-32 – Configurar porcentaje

Permitirá configurar el porcentaje de cobertura cuando aplique.

#### RF-SEG-33 – Configurar monto máximo

Permitirá establecer límites monetarios.

#### RF-SEG-34 – Configurar límite por evento

Permitirá establecer límites por atención.

#### RF-SEG-35 – Configurar límite por período

Permitirá establecer límites por período.

#### RF-SEG-36 – Consultar cobertura

Permitirá consultar la cobertura disponible del paciente.

#### G. Autorizaciones

#### RF-SEG-37 – Registrar solicitud de autorización

Permitirá registrar una solicitud de autorización.

#### RF-SEG-38 – Asociar prestación

La autorización deberá estar asociada al servicio correspondiente.

#### RF-SEG-39 – Registrar número de autorización

Permitirá registrar el número otorgado por la aseguradora.

#### RF-SEG-40 – Consultar autorización

Permitirá consultar el estado de una autorización.

#### RF-SEG-41 – Actualizar estado

Permitirá actualizar el estado.

#### RF-SEG-42 – Registrar observaciones

Permitirá registrar observaciones de la aseguradora.

#### RF-SEG-43 – Registrar respuesta

Permitirá registrar la respuesta recibida.

#### RF-SEG-44 – Controlar vencimiento

Permitirá controlar la vigencia de las autorizaciones.

#### H. Cartas de garantía

#### RF-SEG-45 – Registrar carta de garantía

Permitirá registrar cartas de garantía.

#### RF-SEG-46 – Asociar paciente

Permitirá asociar la carta al paciente.

#### RF-SEG-47 – Asociar procedimiento

Permitirá asociar la carta al procedimiento autorizado.

#### RF-SEG-48 – Registrar monto autorizado

Permitirá registrar el importe autorizado.

#### RF-SEG-49 – Registrar vigencia

Permitirá registrar el período de vigencia.

#### RF-SEG-50 – Adjuntar documento

Permitirá asociar el documento digital correspondiente.

#### RF-SEG-51 – Controlar vencimiento

El sistema generará alertas sobre cartas próximas a vencer.

#### I. Prestaciones

#### RF-SEG-52 – Registrar prestación

Permitirá registrar una prestación realizada al asegurado.

#### RF-SEG-53 – Asociar atención

Permitirá asociar la prestación con la atención correspondiente.

#### RF-SEG-54 – Asociar autorización

Permitirá relacionarla con la autorización cuando sea requerida.

#### RF-SEG-55 – Registrar monto

Permitirá registrar el monto de la prestación.

#### RF-SEG-56 – Determinar participación del seguro

Permitirá registrar el importe correspondiente a la aseguradora.

#### RF-SEG-57 – Determinar participación del paciente

Permitirá registrar el importe correspondiente al paciente.

#### J. Copagos y deducibles

#### RF-SEG-58 – Registrar copago

Permitirá registrar el copago del paciente.

#### RF-SEG-59 – Configurar copago

Permitirá establecer reglas de copago según plan/convenio.

#### RF-SEG-60 – Registrar deducible

Permitirá registrar el deducible aplicable.

#### RF-SEG-61 – Configurar deducible

Permitirá establecer las reglas correspondientes.

#### RF-SEG-62 – Calcular participación

El sistema podrá calcular la distribución económica según las reglas configuradas.

#### K. Liquidaciones

#### RF-SEG-63 – Generar liquidación

Permitirá generar liquidaciones de prestaciones.

#### RF-SEG-64 – Agrupar prestaciones

Permitirá agrupar prestaciones por período, aseguradora o lote de liquidación.

#### RF-SEG-65 – Validar liquidación

Permitirá validar la información antes del envío.

#### RF-SEG-66 – Registrar envío

Permitirá registrar el envío de la liquidación.

#### RF-SEG-67 – Registrar respuesta

Permitirá registrar la respuesta de la aseguradora.

#### RF-SEG-68 – Consultar liquidaciones

Permitirá consultar liquidaciones por período, aseguradora y estado.

#### RF-SEG-69 – Adjuntar sustentos

Permitirá asociar documentos requeridos para la liquidación.

#### L. Rechazos

#### RF-SEG-70 – Registrar rechazo

Permitirá registrar prestaciones rechazadas.

#### RF-SEG-71 – Registrar motivo

Permitirá registrar el motivo del rechazo.

#### RF-SEG-72 – Registrar observación

Permitirá registrar observaciones.

#### RF-SEG-73 – Registrar subsanación

Permitirá registrar las acciones de subsanación.

#### RF-SEG-74 – Reenviar prestación

Permitirá reenviar prestaciones corregidas cuando corresponda.

#### RF-SEG-75 – Consultar rechazos

Permitirá consultar rechazos por aseguradora, motivo y período.

#### M. Cuentas por cobrar

#### RF-SEG-76 – Generar cuenta por cobrar

Permitirá generar cuentas por cobrar a las aseguradoras.

#### RF-SEG-77 – Registrar pago

Permitirá registrar pagos recibidos.

#### RF-SEG-78 – Registrar pago parcial

Permitirá registrar pagos parciales.

#### RF-SEG-79 – Consultar saldo

Permitirá consultar el saldo pendiente.

#### RF-SEG-80 – Conciliar pago

Permitirá conciliar los pagos recibidos con las liquidaciones.

#### N. Reportes

#### RF-SEG-81 – Reporte de aseguradoras

Permitirá consultar aseguradoras activas e inactivas.

#### RF-SEG-82 – Reporte de afiliados

Permitirá consultar pacientes asegurados.

#### RF-SEG-83 – Reporte de prestaciones

Permitirá consultar prestaciones por período.

#### RF-SEG-84 – Reporte de autorizaciones

Permitirá consultar autorizaciones aprobadas, pendientes y rechazadas.

#### RF-SEG-85 – Reporte de cartas de garantía

Permitirá consultar cartas vigentes, vencidas y pendientes.

#### RF-SEG-86 – Reporte de copagos

Permitirá consultar copagos generados.

#### RF-SEG-87 – Reporte de deducibles

Permitirá consultar deducibles aplicados.

#### RF-SEG-88 – Reporte de liquidaciones

Permitirá consultar liquidaciones enviadas y procesadas.

#### RF-SEG-89 – Reporte de rechazos

Permitirá analizar prestaciones rechazadas.

#### RF-SEG-90 – Reporte de cuentas por cobrar

Permitirá consultar saldos pendientes de aseguradoras.

#### RF-SEG-91 – Reporte de pagos

Permitirá consultar pagos recibidos de aseguradoras.

#### RF-SEG-92 – Exportar reportes

Permitirá exportar reportes según los permisos del usuario.

### 23. Base de datos propuesta

La estructura principal podría ser:

ASEGURADORA

```
     │
     ▼
```

PLAN_SEGURO

```
     │
     ▼
```

POLIZA

```
     │
     ▼
```

AFILIADO

```
     │
     ▼
```

PACIENTE

```
     │
     ▼
```

PRESTACION

```
     │
     ├── COBERTURA
     ├── AUTORIZACION
     ├── CARTA_GARANTIA
     ├── COPAGO
     └── DEDUCIBLE
             │
             ▼
        LIQUIDACION
             │
             ▼
       CUENTA_COBRAR
             │
             ▼
           PAGO
```

#### Tablas principales

aseguradora
- id_aseguradora
- codigo
- ruc
- razon_social
- nombre_comercial
- direccion
- telefono
- correo
- contacto
- estado

plan_seguro
- id_plan
- aseguradora_id
- codigo
- nombre
- descripcion
- fecha_inicio
- fecha_fin
- estado

poliza
- id_poliza
- numero_poliza
- plan_id
- titular
- fecha_inicio
- fecha_fin
- estado

afiliado
- id_afiliado
- paciente_id
- aseguradora_id
- plan_id
- poliza_id
- numero_afiliado
- parentesco
- es_principal
- fecha_inicio
- fecha_fin
- estado

cobertura
- id_cobertura
- plan_id
- servicio_id
- porcentaje
- monto_maximo
- limite_evento
- limite_periodo
- estado

autorizacion
- id_autorizacion
- numero
- afiliado_id
- prestacion_id
- fecha_solicitud
- fecha_respuesta
- fecha_vencimiento
- monto_autorizado
- estado
- observaciones

carta_garantia
- id_carta
- numero
- afiliado_id
- autorizacion_id
- monto
- fecha_emision
- fecha_vencimiento
- documento
- estado

prestacion_seguro
- id_prestacion
- paciente_id
- afiliado_id
- atencion_id
- servicio_id
- autorizacion_id
- fecha
- monto_total
- monto_aseguradora
- monto_paciente
- estado

copago
- id_copago
- prestacion_id
- tipo
- porcentaje
- monto
- estado

deducible
- id_deducible
- prestacion_id
- monto
- estado

liquidacion_seguro
- id_liquidacion
- aseguradora_id
- numero
- fecha
- periodo
- monto_total
- monto_aceptado
- monto_rechazado
- estado

detalle_liquidacion
- id_detalle
- liquidacion_id
- prestacion_id
- monto
- estado
- observaciones

rechazo_seguro
- id_rechazo
- detalle_liquidacion_id
- motivo
- monto
- fecha
- estado
- observaciones

cuenta_aseguradora
- id_cuenta
- aseguradora_id
- liquidacion_id
- monto
- pagado
- saldo
- estado

pago_aseguradora
- id_pago
- cuenta_id
- fecha
- monto
- medio_pago
- referencia
- usuario_id

### 24. Integración con los módulos anteriores

El Módulo 14 se convierte en un punto importante entre el área clínica y el área financiera:

```
                 PACIENTE
                    │
                    ▼
                 SEGURO
                    │
          ┌─────────┴─────────┐
          ▼                   ▼
       COBERTURA          AUTORIZACIÓN
          │                   │
          └─────────┬─────────┘
                    ▼
                 ATENCIÓN
                    │
       ┌────────────┼────────────┐
       ▼            ▼            ▼
    CONSULTA     LABORATORIO   IMÁGENES
       │            │            │
       └────────────┼────────────┘
                    ▼
                 CIRUGÍA
                    │
                    ▼
              HOSPITALIZACIÓN
                    │
                    ▼
               PRESTACIONES
                    │
                    ▼
                LIQUIDACIÓN
                    │
                    ▼
              ASEGURADORA
```

#### Integraciones

| Módulo | Integración |
| --- | --- |
| Pacientes | Datos del asegurado |
| Historia Clínica | Atención y sustentos clínicos |
| Citas | Identificación del seguro |
| Admisión | Validación de cobertura |
| Hospitalización | Cobertura de estancia |
| Enfermería | Servicios y consumos |
| Farmacia | Medicamentos cubiertos |
| Laboratorio | Prestaciones de laboratorio |
| Imágenes | Estudios cubiertos |
| Cirugía | Procedimientos autorizados |
| Facturación y Caja | Copagos, cargos y pagos |
| Reportes | Estadísticas y cuentas |

### 25. Arquitectura económica recomendada

Una de las decisiones más importantes es no mezclar el monto total de la atención con el monto que paga el paciente.

Por ejemplo:

ATENCIÓN MÉDICA

```
       │
       ▼
```

TOTAL: S/ 1,000

```
       │
       ├──────────────► ASEGURADORA: S/ 800
       │
       └──────────────► PACIENTE: S/ 200
                              │
                              ├── Copago
                              └── Deducible
```

Entonces:

Prestación → Cobertura → Distribución económica → Facturación → Pago

Esto permitirá que posteriormente el Módulo 13 – Facturación y Caja pueda manejar correctamente tanto los pagos del paciente como las cuentas por cobrar a las aseguradoras.

#### Resultado del módulo

## MÓDULO 15 – INVENTARIO Y ALMACÉN

Este módulo permitirá controlar medicamentos, insumos médicos, materiales quirúrgicos, materiales de laboratorio, productos de limpieza y otros bienes utilizados por el hospital, manteniendo trazabilidad de entradas, salidas, transferencias, lotes, vencimientos y stock.

### 1. 🎯 Objetivo

Administrar de forma centralizada el inventario del hospital, permitiendo conocer:
- Qué productos existen.
- Cuánto stock disponible existe.
- En qué almacén y ubicación se encuentran.
- Qué productos están por vencer.
- Qué productos están vencidos.
- Qué productos tienen stock mínimo.
- Quién recibió, retiró o trasladó un producto.
- De qué lote proviene cada producto.
- Cuánto se consumió durante un período.
- Cuál es el movimiento histórico de cada producto.

### 2. 🔄 Flujo general

PROVEEDOR

```
    │
    ▼
```

RECEPCIÓN DE PRODUCTOS

```
    │
    ▼
```

INGRESO A ALMACÉN

```
    │
    ├──► LOTE
    ├──► FECHA VENCIMIENTO
    ├──► CANTIDAD
    └──► COSTO
    │
    ▼
```

STOCK

```
    │
    ├───────────────┬───────────────┐
    ▼               ▼               ▼
REQUISICIÓN     TRANSFERENCIA     AJUSTE
    │               │               │
    ▼               ▼               ▼
SALIDA          OTRO ALMACÉN     KARDEX
    │
    ├──► FARMACIA
    ├──► ENFERMERÍA
    ├──► QUIRÓFANO
    ├──► LABORATORIO
    ├──► IMÁGENES
    └──► OTROS SERVICIOS
```

### 3. 📋 Menú principal

📦 INVENTARIO Y ALMACÉN

```
├── Dashboard
│
├── Productos
│   ├── Listar productos
│   ├── Registrar producto
│   ├── Categorías
│   ├── Unidades de medida
│   └── Presentaciones
│
├── Proveedores
│
├── Almacenes
│   ├── Almacenes
│   ├── Ubicaciones
│   └── Áreas
│
├── Inventario
│   ├── Stock actual
│   ├── Lotes
│   ├── Vencimientos
│   └── Productos reservados
│
├── Movimientos
│   ├── Entradas
│   ├── Salidas
│   ├── Transferencias
│   ├── Devoluciones
│   └── Ajustes
│
├── Requisiciones
│
├── Inventario físico
│
├── Kardex
│
├── Alertas
│   ├── Stock mínimo
│   ├── Próximos a vencer
│   ├── Vencidos
│   └── Stock crítico
│
└── Reportes
```

### 4. 📊 Dashboard de Inventario

El responsable del almacén debe visualizar rápidamente el estado del inventario.

#### Indicadores

| Indicador | Ejemplo |
| --- | --- |
| Productos registrados | 1,250 |
| Productos con stock | 1,120 |
| Stock bajo | 45 |
| Productos vencidos | 12 |
| Próximos a vencer | 38 |
| Entradas del mes | 325 |
| Salidas del mes | 418 |
| Transferencias | 52 |
| Valor del inventario | S/ 185,450 |

#### Gráficos

- Entradas vs salidas.
- Consumo mensual.
- Productos más utilizados.
- Stock por categoría.
- Productos próximos a vencer.
- Valor del inventario por almacén.

### 5. 📦 Gestión de Productos

Aquí se registra el catálogo general de productos.

#### Ejemplos

Medicamentos
- Paracetamol 500 mg
- Amoxicilina 500 mg
- Ibuprofeno 400 mg

Material médico
- Jeringa 5 ml
- Guantes quirúrgicos
- Gasas
- Algodón
- Catéter

Material quirúrgico
- Suturas
- Bisturí
- Campos quirúrgicos

Laboratorio
- Tubos de ensayo
- Reactivos
- Tubos para muestras

Otros
- Productos de limpieza
- Material de oficina

#### Datos principales

Código

Código de barras

Nombre

Descripción

Categoría

Unidad de medida

Presentación

Marca

Fabricante

Tipo de producto

Stock mínimo

Stock máximo

Punto de reposición

¿Maneja lote?

¿Maneja vencimiento?

¿Activo?

### 6. 🗂️ Categorías

Permite organizar los productos.

Medicamentos

Material médico

Material quirúrgico

Reactivos

Laboratorio

Limpieza

Oficina

Equipamiento

Otros

Las categorías deben ser configurables, no estar programadas directamente en el código.

### 7. 📏 Unidades de medida

Ejemplos:

Unidad

Caja

Paquete

Frasco

Litro

Mililitro

Kilogramo

Gramo

Par

Rollos

Esto será importante para evitar inconsistencias en el inventario.

### 8. 🏢 Almacenes

El hospital podría tener varios almacenes:

ALMACÉN CENTRAL

```
      │
      ├── Medicamentos
      ├── Material médico
      ├── Material quirúrgico
      └── Limpieza
```

FARMACIA

```
      │
      └── Medicamentos
```

ALMACÉN QUIRÓFANO

```
      │
      └── Material quirúrgico
```

#### Importante

Almacén general y Farmacia no deberían manejar exactamente el mismo stock.

Farmacia tiene su propio inventario de medicamentos y dispensación clínica.

Inventario/Almacén controla principalmente la recepción, almacenamiento y distribución.

### 9. 📍 Ubicaciones

Dentro de un almacén podemos manejar:

Almacén Central

```
   │
   ├── Pasillo A
   │    ├── Estante 01
   │    ├── Estante 02
   │
   ├── Pasillo B
   │    ├── Estante 01
   │    └── Estante 02
```

Esto permite conocer exactamente dónde está un producto.

### 10. 🚚 Entradas de almacén

Una entrada puede originarse por:
- Compra.
- Donación.
- Transferencia.
- Devolución.
- Ajuste autorizado.
- Otros ingresos.

#### Ejemplo

ENTRADA: EN-000125

Proveedor: Laboratorios XYZ

Fecha: 06/09/2026

Producto:

Paracetamol 500 mg

Lote: ABC123

Vencimiento: 08/2028

Cantidad: 1,000

Costo unitario: S/ 0.15

Total: S/ 150.00

Al confirmar la entrada:

Stock anterior = 500

```
Entrada        = 1,000
Stock nuevo    = 1,500
```

### 11. 🧪 Lotes y vencimientos

Esta es una de las partes más importantes del módulo hospitalario.

No se recomienda almacenar solamente:

Paracetamol → Stock = 1,500

Debe manejarse:

Paracetamol 500 mg

```
Lote A001 → 500 → vence 03/2027
Lote A002 → 700 → vence 08/2027
Lote A003 → 300 → vence 01/2028
```

Así se puede conocer exactamente qué lote fue utilizado.

#### FEFO

Para productos con vencimiento se recomienda:

First Expired, First Out

Es decir:

Primero utilizar el lote que vence primero.

### 12. 📤 Salidas de almacén

Las salidas pueden producirse por:
- Requisición de un servicio.
- Consumo interno.
- Transferencia.
- Entrega a Farmacia.
- Entrega a Quirófano.
- Entrega a Laboratorio.
- Productos dañados.
- Productos vencidos.
- Otros motivos autorizados.

#### Ejemplo

SALIDA: SA-000245

Área solicitante:

Enfermería

Producto:

Guantes quirúrgicos

Cantidad:

200 unidades

Lote:

GUA-2026-001

Responsable:

Usuario del almacén

Fecha:

06/09/2026

### 13. 📝 Requisiciones

Un área puede solicitar productos al almacén.

#### Flujo

ENFERMERÍA

```
     │
     ▼
```

SOLICITUD

```
     │
     ▼
```

ALMACÉN

```
     │
     ├──► APROBAR
     ├──► RECHAZAR
     └──► OBSERVAR
     │
     ▼
```

PREPARACIÓN

```
     │
     ▼
```

DESPACHO

```
     │
     ▼
```

SALIDA DE INVENTARIO

#### Ejemplo

Enfermería solicita:

| Producto | Cantidad |
| --- | --- |
| Guantes | 500 |
| Gasas | 100 |
| Jeringas | 200 |

El almacenero puede entregar parcialmente si no existe suficiente stock.

### 14. 🔄 Transferencias

Permite mover productos entre almacenes.

ALMACÉN CENTRAL

```
       │
       │ 100 unidades
       ▼
```

FARMACIA

El sistema debe generar:

Almacén origen: Central

Almacén destino: Farmacia

Producto: Paracetamol

Lote: A001

Cantidad: 100

Fecha

Usuario

Motivo

Y actualizar ambos stocks.

### 15. 🛠️ Ajustes de inventario

Se utilizará cuando exista una diferencia entre:

Stock físico ≠ Stock del sistema

Ejemplo:

Stock sistema: 100

```
Stock físico:   97
Diferencia:    -3
```

El sistema debe solicitar:
- Motivo.
- Cantidad.
- Responsable.
- Autorización.
- Observación.

No debería permitirse modificar directamente el stock desde la pantalla.

El stock debe cambiar mediante un movimiento de inventario.

### 16. 📒 Kardex

El Kardex permitirá visualizar todos los movimientos de un producto.

#### Ejemplo

| Fecha | Tipo | Entrada | Salida | Saldo |
| --- | --- | --- | --- | --- |
| 01/09 | Saldo inicial | - | - | 500 |
| 02/09 | Compra | 1,000 | - | 1,500 |
| 03/09 | Enfermería | - | 200 | 1,300 |
| 04/09 | Farmacia | - | 300 | 1,000 |
| 05/09 | Compra | 500 | - | 1,500 |

Debe conservarse el historial.

No se deben borrar movimientos históricos.

### 17. 🚨 Alertas

El sistema debe generar alertas para:

#### Stock mínimo

⚠️ Paracetamol

Stock: 50

Mínimo: 100

#### Próximo vencimiento

⚠️ Amoxicilina

Lote: AMX-2026

Vence: 30 días

#### Producto vencido

🔴 Producto vencido

No disponible para despacho

#### Stock crítico

🔴 Guantes quirúrgicos

Stock: 10

Mínimo: 100

### 18. ↩️ Devoluciones

Permite devolver productos al almacén.

Ejemplo:

Quirófano

```
    │
    │ Material no utilizado
    ▼
```

Almacén

Debe registrarse:
- Producto.
- Lote.
- Cantidad.
- Motivo.
- Área.
- Usuario.
- Fecha.
- Estado del producto.

Un producto devuelto puede quedar:

DISPONIBLE

BLOQUEADO

DAÑADO

VENCIDO

No todo producto devuelto debe regresar automáticamente al stock disponible.

### 19. 📋 Inventario físico

Permite realizar conteos físicos.

#### Proceso

GENERAR INVENTARIO FÍSICO

          ↓

SELECCIONAR ALMACÉN

          ↓

CONTEO

          ↓

REGISTRAR CANTIDAD FÍSICA

          ↓

COMPARAR

          ↓

DETECTAR DIFERENCIAS

          ↓

APROBAR AJUSTES

          ↓

ACTUALIZAR INVENTARIO

Ejemplo:

| Producto | Sistema | Físico | Diferencia |
| --- | --- | --- | --- |
| Guantes | 500 | 495 | -5 |
| Gasas | 300 | 300 | 0 |
| Jeringas | 200 | 205 | +5 |

### 20. 🔗 Integración con otros módulos

Este módulo será uno de los módulos centrales del hospital.

```
                 ┌──────────────┐
                 │   COMPRAS    │
                 └──────┬───────┘
                        ↓
                 ┌──────────────┐
                 │  INVENTARIO  │
                 └──────┬───────┘
                        │
       ┌────────────────┼────────────────┐
       ↓                ↓                ↓
   FARMACIA         QUIRÓFANO        ENFERMERÍA
       │                │                │
       ↓                ↓                ↓
 MEDICAMENTOS       INSUMOS          CONSUMOS
```

También:

```
- Laboratorio → reactivos.
- Diagnóstico por imágenes → insumos.
- Hospitalización → materiales.
- Facturación → costos/cargos cuando corresponda.
- Seguros → materiales y servicios asociados.
- Reportes → consumo y costos.
```

### 21. 📌 Requisitos funcionales

#### Gestión de productos

| Código | Requisito |
| --- | --- |
| RF-INV-01 | Registrar productos. |
| RF-INV-02 | Modificar productos. |
| RF-INV-03 | Activar/desactivar productos. |
| RF-INV-04 | Generar código interno de producto. |
| RF-INV-05 | Registrar código de barras. |
| RF-INV-06 | Asociar producto a categoría. |
| RF-INV-07 | Asociar unidad de medida. |
| RF-INV-08 | Registrar presentación. |
| RF-INV-09 | Configurar stock mínimo. |
| RF-INV-10 | Configurar stock máximo. |
| RF-INV-11 | Configurar punto de reposición. |
| RF-INV-12 | Configurar manejo de lotes. |
| RF-INV-13 | Configurar manejo de vencimientos. |
| RF-INV-14 | Buscar y filtrar productos. |

#### Categorías y unidades

| Código | Requisito |
| --- | --- |
| RF-INV-15 | Registrar categorías. |
| RF-INV-16 | Modificar categorías. |
| RF-INV-17 | Registrar unidades de medida. |
| RF-INV-18 | Registrar presentaciones. |
| RF-INV-19 | Activar/desactivar catálogos. |

#### Proveedores

| Código | Requisito |
| --- | --- |
| RF-INV-20 | Registrar proveedores. |
| RF-INV-21 | Modificar proveedores. |
| RF-INV-22 | Consultar proveedores. |
| RF-INV-23 | Asociar productos con proveedores. |
| RF-INV-24 | Consultar historial de compras/recepciones por proveedor. |

#### Almacenes

| Código | Requisito |
| --- | --- |
| RF-INV-25 | Registrar almacenes. |
| RF-INV-26 | Modificar almacenes. |
| RF-INV-27 | Registrar ubicaciones. |
| RF-INV-28 | Asociar ubicaciones a almacenes. |
| RF-INV-29 | Consultar stock por almacén. |
| RF-INV-30 | Consultar stock por ubicación. |

#### Entradas

| Código | Requisito |
| --- | --- |
| RF-INV-31 | Registrar entradas. |
| RF-INV-32 | Registrar proveedor de la entrada. |
| RF-INV-33 | Registrar lote. |
| RF-INV-34 | Registrar fecha de vencimiento. |
| RF-INV-35 | Registrar cantidad recibida. |
| RF-INV-36 | Registrar costo unitario. |
| RF-INV-37 | Adjuntar documento de recepción. |
| RF-INV-38 | Confirmar entrada. |
| RF-INV-39 | Actualizar stock automáticamente. |
| RF-INV-40 | Consultar historial de entradas. |

#### Salidas

| Código | Requisito |
| --- | --- |
| RF-INV-41 | Registrar salidas. |
| RF-INV-42 | Asociar salida a un área solicitante. |
| RF-INV-43 | Asociar lote a la salida. |
| RF-INV-44 | Validar stock disponible. |
| RF-INV-45 | Impedir stock negativo según configuración. |
| RF-INV-46 | Actualizar stock automáticamente. |
| RF-INV-47 | Registrar motivo de salida. |
| RF-INV-48 | Consultar historial de salidas. |

#### Requisiciones

| Código | Requisito |
| --- | --- |
| RF-INV-49 | Registrar requisiciones. |
| RF-INV-50 | Agregar productos a una requisición. |
| RF-INV-51 | Aprobar requisiciones. |
| RF-INV-52 | Rechazar requisiciones. |
| RF-INV-53 | Observar requisiciones. |
| RF-INV-54 | Preparar pedidos. |
| RF-INV-55 | Registrar entrega parcial. |
| RF-INV-56 | Generar salida desde una requisición aprobada. |

#### Transferencias

| Código | Requisito |
| --- | --- |
| RF-INV-57 | Registrar transferencias. |
| RF-INV-58 | Seleccionar almacén origen. |
| RF-INV-59 | Seleccionar almacén destino. |
| RF-INV-60 | Registrar lote transferido. |
| RF-INV-61 | Validar stock de origen. |
| RF-INV-62 | Actualizar stock origen/destino. |
| RF-INV-63 | Consultar historial de transferencias. |

#### Ajustes

| Código | Requisito |
| --- | --- |
| RF-INV-64 | Registrar ajustes. |
| RF-INV-65 | Registrar motivo del ajuste. |
| RF-INV-66 | Registrar diferencias positivas o negativas. |
| RF-INV-67 | Solicitar autorización para ajustes sensibles. |
| RF-INV-68 | Generar movimiento de ajuste. |
| RF-INV-69 | Auditar ajustes. |

#### Lotes y vencimientos

| Código | Requisito |
| --- | --- |
| RF-INV-70 | Registrar lotes. |
| RF-INV-71 | Registrar fecha de vencimiento. |
| RF-INV-72 | Consultar stock por lote. |
| RF-INV-73 | Consultar productos próximos a vencer. |
| RF-INV-74 | Identificar productos vencidos. |
| RF-INV-75 | Bloquear despacho de productos vencidos. |
| RF-INV-76 | Aplicar criterio FEFO cuando corresponda. |

#### Kardex

| Código | Requisito |
| --- | --- |
| RF-INV-77 | Generar Kardex por producto. |
| RF-INV-78 | Consultar entradas. |
| RF-INV-79 | Consultar salidas. |
| RF-INV-80 | Consultar transferencias. |
| RF-INV-81 | Consultar ajustes. |
| RF-INV-82 | Mostrar saldo histórico. |
| RF-INV-83 | Filtrar Kardex por fechas. |
| RF-INV-84 | Exportar Kardex. |

#### Alertas

| Código | Requisito |
| --- | --- |
| RF-INV-85 | Alertar stock mínimo. |
| RF-INV-86 | Alertar stock crítico. |
| RF-INV-87 | Alertar productos próximos a vencer. |
| RF-INV-88 | Alertar productos vencidos. |
| RF-INV-89 | Mostrar alertas en Dashboard. |

#### Inventario físico y reportes

| Código | Requisito |
| --- | --- |
| RF-INV-90 | Crear inventario físico. |
| RF-INV-91 | Registrar conteo físico. |
| RF-INV-92 | Comparar stock físico y sistema. |
| RF-INV-93 | Generar diferencias. |
| RF-INV-94 | Generar ajustes derivados del inventario físico. |
| RF-INV-95 | Generar reporte de stock. |
| RF-INV-96 | Generar reporte de consumo. |
| RF-INV-97 | Generar reporte de vencimientos. |
| RF-INV-98 | Generar reporte de movimientos. |
| RF-INV-99 | Generar reporte de productos más utilizados. |
| RF-INV-100 | Exportar reportes. |

### 22. 🗄️ Propuesta de base de datos

Una estructura inicial podría ser:

producto

categoria_producto

unidad_medida

presentacion_producto

proveedor

almacen

ubicacion_almacen

lote_producto

stock_producto

entrada_inventario

detalle_entrada

salida_inventario

detalle_salida

requisicion

detalle_requisicion

transferencia

detalle_transferencia

ajuste_inventario

detalle_ajuste

devolucion_inventario

detalle_devolucion

inventario_fisico

detalle_inventario_fisico

movimiento_inventario

#### Relación principal

PRODUCTO

```
   │
   ├── CATEGORIA
   ├── UNIDAD
   ├── PRESENTACION
   │
   └── LOTE
         │
         └── STOCK
               │
               └── MOVIMIENTOS
                    ├── ENTRADA
                    ├── SALIDA
                    ├── TRANSFERENCIA
                    ├── DEVOLUCIÓN
                    └── AJUSTE
```

### 23. ⭐ Regla arquitectónica importante

Para este módulo recomiendo no manejar el stock simplemente con un campo stock y modificarlo directamente.

Por ejemplo, evitar:

UPDATE producto

SET stock = stock - 10

como única lógica de inventario.

Es mejor registrar:

MOVIMIENTO_INVENTARIO

Producto: 1001

Lote: L001

Tipo: SALIDA

Cantidad: 10

Almacén: CENTRAL

Motivo: REQUISICIÓN

Referencia: REQ-00025

Usuario: 15

Fecha: 06/09/2026

Y mantener el Kardex como fuente de trazabilidad.

### 24. 🔐 Reglas de negocio fundamentales

### 1. No eliminar movimientos

Una entrada, salida o transferencia confirmada no debe eliminarse físicamente.

### 2. Control por lote

Para medicamentos, reactivos y productos con vencimiento:

PRODUCTO + LOTE + VENCIMIENTO

debe ser controlado.

### 3. No permitir vencidos

Un producto vencido debe pasar a:

VENCIDO / BLOQUEADO

y no poder ser despachado normalmente.

### 4. Trazabilidad

Debe conocerse:

qué producto salió, de qué lote, cuánto salió, para qué área, quién lo autorizó y quién lo entregó.

### 5. Separación con Farmacia

El inventario general no debe reemplazar el módulo de Farmacia.

La integración sería:

ALMACÉN

   ↓

TRANSFERENCIA

   ↓

FARMACIA

   ↓

DISPENSACIÓN

   ↓

PACIENTE

### 6. Separación con Facturación

Inventario controla productos y movimientos.

Facturación controla:

cargos + comprobantes + pagos.

Si un insumo debe generar un cargo al paciente, se realiza mediante una integración entre ambos módulos.

#### 🏥 Arquitectura general hasta el Módulo 15

Con los módulos desarrollados hasta ahora, el sistema empieza a tomar esta estructura:

```
                         ┌─────────────────┐
                         │    PACIENTE     │
                         └────────┬────────┘
                                  ↓
                         ┌─────────────────┐
                         │     ADMISION    │
                         └────────┬────────┘
                                  ↓
          ┌───────────────────────┼───────────────────────┐
          ↓                       ↓                       ↓
      CONSULTA               EMERGENCIA             HOSPITALIZACIÓN
          │                       │                       │
          └───────────────┬───────┴───────────────────────┘
                          ↓
                  ┌───────────────┐
                  │ HISTORIA CLÍNICA│
                  └───────┬───────┘
                          │
        ┌─────────────────┼─────────────────┐
        ↓                 ↓                 ↓
   LABORATORIO       IMÁGENES          QUIRÓFANO
        │                 │                 │
        └─────────────────┼─────────────────┘
                          ↓
                    ENFERMERÍA
                          │
            ┌─────────────┴─────────────┐
            ↓                           ↓
        FARMACIA                  INVENTARIO
            │                           │
            └─────────────┬─────────────┘
                          ↓
                    FACTURACIÓN
                          │
                          ↓
                       SEGUROS
```

## MÓDULO 16 – REPORTES Y ESTADÍSTICAS

Este módulo será el centro de información gerencial y operativo del hospital. Su función es transformar los datos generados por los módulos anteriores en reportes, indicadores, gráficos y estadísticas para facilitar la toma de decisiones.

### 1. 🎯 Objetivo

Permitir que la dirección, administración y responsables de cada área puedan consultar:
- Cantidad de pacientes atendidos.
- Citas programadas y atendidas.
- Atenciones de emergencia.
- Ocupación de camas.
- Hospitalizaciones y altas.
- Consultas por médico y especialidad.
- Diagnósticos más frecuentes.
- Exámenes de laboratorio realizados.
- Estudios de imágenes realizados.
- Cirugías.
- Consumo de medicamentos e insumos.
- Ingresos y pagos.
- Cuentas pendientes.
- Atención por aseguradora.
- Indicadores de productividad.
- Estadísticas históricas.

La característica principal debe ser que los reportes se alimenten automáticamente de los módulos operativos, evitando registrar la misma información nuevamente.

### 2. 🔄 Flujo general

PACIENTES

    │

CITAS

    │

ADMISIÓN

    │

HISTORIA CLÍNICA

    │

EMERGENCIAS

    │

HOSPITALIZACIÓN

    │

ENFERMERÍA

    │

FARMACIA

    │

LABORATORIO

    │

IMÁGENES

    │

QUIRÓFANO

    │

INVENTARIO

    │

FACTURACIÓN

    │

SEGUROS

```
    │
    ▼
┌─────────────────────────────┐
│ REPORTES Y ESTADÍSTICAS     │
└──────────────┬──────────────┘
               │
       ┌───────┼────────┐
       ↓       ↓        ↓
    TABLAS   GRÁFICOS  KPIs
       │       │        │
       └───────┼────────┘
               ↓
        TOMA DE DECISIONES
```

### 3. 📋 Menú principal

📊 REPORTES Y ESTADÍSTICAS

```
├── Dashboard General
│
├── Pacientes
│   ├── Pacientes registrados
│   ├── Pacientes atendidos
│   ├── Pacientes nuevos
│   └── Procedencia
│
├── Citas
│   ├── Citas programadas
│   ├── Citas atendidas
│   ├── Canceladas
│   ├── No asistió
│   └── Productividad médica
│
├── Emergencias
│   ├── Atenciones
│   ├── Triaje
│   ├── Tiempos de espera
│   └── Altas / derivaciones
│
├── Hospitalización
│   ├── Ingresos
│   ├── Altas
│   ├── Ocupación
│   ├── Estancia
│   └── Camas
│
├── Historia Clínica
│   ├── Diagnósticos
│   ├── Consultas
│   ├── Procedimientos
│   └── Evoluciones
│
├── Laboratorio
│   ├── Exámenes
│   ├── Resultados
│   ├── Exámenes críticos
│   └── Productividad
│
├── Imágenes
│   ├── Estudios realizados
│   ├── Informes
│   └── Productividad
│
├── Cirugías
│   ├── Cirugías realizadas
│   ├── Programadas
│   ├── Canceladas
│   └── Indicadores
│
├── Farmacia
│   ├── Medicamentos dispensados
│   ├── Consumo
│   └── Medicamentos más utilizados
│
├── Inventario
│   ├── Stock
│   ├── Consumo
│   ├── Vencimientos
│   └── Kardex
│
├── Facturación
│   ├── Ventas
│   ├── Ingresos
│   ├── Pagos
│   ├── Deudas
│   └── Caja
│
├── Seguros
│   ├── Atenciones
│   ├── Liquidaciones
│   ├── Rechazos
│   └── Cuentas por cobrar
│
├── Indicadores
│
├── Reportes personalizados
│
└── Exportaciones
```

### 4. 📊 Dashboard General

La pantalla principal debería mostrar información de manera visual.

#### Indicadores principales

| Indicador | Resultado |
| --- | --- |
| Pacientes atendidos hoy | 245 |
| Citas del día | 280 |
| Emergencias | 37 |
| Hospitalizados | 82 |
| Camas disponibles | 18 |
| Cirugías del día | 12 |
| Exámenes realizados | 156 |
| Estudios de imágenes | 73 |
| Medicamentos dispensados | 420 |
| Ingresos del día | S/ 28,450 |
| Cuentas pendientes | S/ 84,200 |

### 5. 📈 Gráficos del Dashboard

#### Atención por mes

ENE █████████████

FEB ███████████████

MAR █████████████████

ABR ██████████████

MAY ███████████████████

JUN █████████████████

#### Pacientes por especialidad

- Medicina general
- Pediatría
- Cardiología
- Ginecología
- Traumatología
- Odontología
- etc.

#### Distribución de atención

Consulta externa

Emergencia

Hospitalización

Cirugía

### 6. 👥 Reportes de pacientes

Permitir consultar:
- Total de pacientes registrados.
- Pacientes nuevos.
- Pacientes atendidos.
- Pacientes activos.
- Pacientes por sexo.
- Pacientes por rango de edad.
- Pacientes por distrito.
- Pacientes por procedencia.
- Pacientes con seguro.
- Pacientes particulares.

#### Ejemplo

| Rango de edad | Pacientes |
| --- | --- |
| 0–12 | 520 |
| 13–17 | 180 |
| 18–30 | 850 |
| 31–50 | 1,240 |
| 51–65 | 920 |
| >65 | 450 |

### 7. 📅 Reportes de citas

Permitir analizar:
- Citas programadas.
- Citas confirmadas.
- Citas atendidas.
- Cancelaciones.
- Reprogramaciones.
- Pacientes que no asistieron.
- Citas por especialidad.
- Citas por médico.
- Citas por día.
- Citas por horario.

#### Indicador importante

Tasa de inasistencia

Citas no asistidas

------------------- × 100

Citas programadas

Esto permite detectar especialidades u horarios con alta inasistencia.

### 8. 👨‍⚕️ Productividad médica

Este reporte puede ser muy importante para la administración.

Por médico:

| Médico | Especialidad | Atenciones | Horas |
| --- | --- | --- | --- |
| Dr. Pérez | Cardiología | 32 | 8 |
| Dra. García | Pediatría | 41 | 8 |
| Dr. Torres | Medicina | 38 | 8 |

También:
- Consultas por médico.
- Consultas por especialidad.
- Pacientes atendidos.
- Horas trabajadas.
- Citas canceladas.
- Citas no atendidas.
- Promedio de pacientes por hora.

### 9. 🚑 Reportes de Emergencias

Indicadores:
- Número de emergencias.
- Emergencias por día.
- Emergencias por turno.
- Emergencias por prioridad.
- Tiempo promedio de espera.
- Tiempo hasta triaje.
- Tiempo hasta atención médica.
- Altas.
- Hospitalizaciones.
- Referencias.
- Transferencias.

#### Ejemplo

EMERGENCIAS DEL MES

```
Crítico       █████
Urgente       ███████████
Moderado      █████████████████
Leve          ███████████████████
```

### 10. 🛏️ Reportes de Hospitalización

Indicadores:
- Ingresos.
- Altas.
- Pacientes hospitalizados.
- Camas ocupadas.
- Camas disponibles.
- Camas bloqueadas.
- Ocupación por piso.
- Ocupación por especialidad.
- Promedio de días de estancia.
- Traslados.
- Fallecimientos.

#### Indicador de ocupación

Camas ocupadas

---------------------- × 100

Camas disponibles + ocupadas

### 11. 🧬 Diagnósticos

Este reporte utilizará los diagnósticos registrados en Historia Clínica.

Puede mostrar:
- Diagnósticos más frecuentes.
- Diagnósticos por especialidad.
- Diagnósticos por edad.
- Diagnósticos por sexo.
- Diagnósticos por período.
- Diagnósticos por médico.

Si se utiliza CIE-10, se puede generar una clasificación estandarizada.

#### Ejemplo

| Código | Diagnóstico | Casos |
| --- | --- | --- |
| J06.9 | Infección respiratoria | 235 |
| I10 | Hipertensión | 182 |
| E11.9 | Diabetes | 145 |
| K29.7 | Gastritis | 128 |

### 12. 🧪 Reportes de Laboratorio

Permitir consultar:
- Órdenes realizadas.
- Exámenes procesados.
- Resultados validados.
- Exámenes pendientes.
- Exámenes rechazados.
- Resultados críticos.
- Exámenes por especialidad.
- Exámenes más solicitados.
- Productividad por laboratorista.

#### Indicador

Tiempo promedio:

Solicitud

   ↓

Toma de muestra

   ↓

Procesamiento

   ↓

Resultado

   ↓

Validación

Esto permitirá medir el tiempo de respuesta del laboratorio.

### 13. 🩻 Reportes de Diagnóstico por Imágenes

Mostrar:
- Radiografías.
- Ecografías.
- Tomografías.
- Resonancias.
- Mamografías.
- Estudios pendientes.
- Estudios realizados.
- Informes pendientes.
- Estudios por médico.
- Estudios por especialidad.

También:

Tiempo promedio desde solicitud hasta informe validado.

### 14. 🏥 Reportes de Cirugía

Indicadores:
- Cirugías programadas.
- Cirugías realizadas.
- Cirugías canceladas.
- Cirugías reprogramadas.
- Cirugías por especialidad.
- Cirugías por médico.
- Uso de quirófanos.
- Tiempo promedio de cirugía.
- Complicaciones registradas.
- Materiales utilizados.

#### Utilización de quirófano

Tiempo utilizado

-------------------- × 100

Tiempo disponible

### 15. 💊 Reportes de Farmacia

Permite conocer:
- Medicamentos dispensados.
- Medicamentos más utilizados.
- Medicamentos menos utilizados.
- Consumo por período.
- Consumo por servicio.
- Consumo por paciente cuando corresponda.
- Medicamentos próximos a vencer.
- Medicamentos vencidos.
- Valor del consumo.

#### Ejemplo

| Medicamento | Cantidad | Valor |
| --- | --- | --- |
| Paracetamol | 4,500 | S/ 675 |
| Amoxicilina | 1,250 | S/ 1,875 |
| Ibuprofeno | 1,800 | S/ 1,080 |

### 16. 📦 Reportes de Inventario

Integrado con el Módulo 15.

Reportes:
- Stock actual.
- Stock por almacén.
- Stock por categoría.
- Productos bajo mínimo.
- Productos vencidos.
- Próximos a vencer.
- Entradas.
- Salidas.
- Transferencias.
- Ajustes.
- Devoluciones.
- Consumo por área.
- Kardex.
- Valor del inventario.

### 17. 💰 Reportes financieros

Integrado con Facturación y Caja.

#### Reportes

- Facturación diaria.
- Facturación mensual.
- Ingresos.
- Pagos.
- Pagos pendientes.
- Cuentas por cobrar.
- Pagos por método.
- Caja por período.
- Anulaciones.
- Devoluciones.
- Ingresos por servicio.

#### Ejemplo

| Método | Total |
| --- | --- |
| Efectivo | S/ 8,500 |
| Tarjeta | S/ 12,300 |
| Transferencia | S/ 5,800 |
| Otros | S/ 1,850 |
| Total | S/ 28,450 |

### 18. 🛡️ Reportes de Seguros

Permite conocer:
- Pacientes asegurados.
- Atenciones por aseguradora.
- Atenciones por plan.
- Servicios cubiertos.
- Copagos.
- Deducibles.
- Autorizaciones.
- Cartas de garantía.
- Liquidaciones.
- Rechazos.
- Cuentas por cobrar.
- Pagos recibidos de aseguradoras.

#### Indicador importante

Porcentaje de rechazo de liquidaciones

Liquidaciones rechazadas

------------------------- × 100

Liquidaciones enviadas

### 19. 📊 Indicadores hospitalarios

Esta sección es especialmente importante para la gerencia/dirección.

#### Indicadores asistenciales

- Número de pacientes atendidos.
- Consultas por médico.
- Consultas por especialidad.
- Tasa de inasistencia.
- Tiempo promedio de espera.
- Emergencias.
- Hospitalizaciones.
- Altas.

#### Indicadores hospitalarios

- Tasa de ocupación de camas.
- Estancia promedio.
- Rotación de camas.
- Ingresos hospitalarios.
- Egresos hospitalarios.

#### Indicadores administrativos

- Facturación.
- Ingresos.
- Cuentas por cobrar.
- Deudas.
- Rechazos de seguros.

#### Indicadores logísticos

- Consumo de medicamentos.
- Consumo de insumos.
- Stock crítico.
- Productos vencidos.
- Rotación de inventario.

### 20. 🔎 Filtros de reportes

Todos los reportes importantes deberían permitir filtros.

```
Desde:       01/09/2026
Hasta:       30/09/2026
Especialidad: [Todas ▼]
Médico:       [Todos ▼]
Servicio:     [Todos ▼]
Estado:       [Todos ▼]
Aseguradora:  [Todas ▼]
```

[ 🔍 GENERAR ]

Esto evita crear una pantalla diferente para cada combinación de consulta.

### 21. 📥 Exportación

Los reportes deberían poder exportarse a:
- PDF.
- Excel.
- CSV.

Y algunos reportes pueden permitir:
- Imprimir.
- Descargar.
- Compartir internamente.

### 22. 📊 Reportes personalizados

Una funcionalidad avanzada sería permitir al administrador construir consultas seleccionando:

Módulo

   ↓

Campos

   ↓

Filtros

   ↓

Agrupación

   ↓

Ordenamiento

   ↓

Gráfico

   ↓

Reporte

Por ejemplo:

"Mostrar cantidad de pacientes atendidos por especialidad durante agosto de 2026."

Resultado:

| Especialidad | Pacientes |
| --- | --- |
| Medicina | 1,250 |
| Pediatría | 890 |
| Cardiología | 620 |
| Traumatología | 480 |

### 23. 📅 Reportes programados

Como funcionalidad avanzada, el sistema podría permitir:

Reporte:

Productividad médica

Frecuencia:

Mensual

Día:

Último día del mes

Hora:

18:00

Destinatarios:

Dirección

Administración

El sistema generaría automáticamente el reporte.

### 24. 🔐 Seguridad de reportes

No todos los usuarios deben visualizar todos los reportes.

#### Ejemplo

| Rol | Reportes |
| --- | --- |
| Director | Todos |
| Administrador | Todos |
| Médico | Clínicos propios |
| Enfermería | Enfermería |
| Farmacia | Farmacia |
| Almacén | Inventario |
| Contabilidad | Financieros |
| Recepción | Citas/Pacientes |

Además:

Los reportes deben respetar los permisos del usuario.

Un médico, por ejemplo, no debería poder acceder automáticamente a información financiera sensible.

### 25. 📝 Requisitos funcionales

#### Dashboard

| Código | Requisito |
| --- | --- |
| RF-REP-01 | Mostrar dashboard general. |
| RF-REP-02 | Mostrar indicadores del día. |
| RF-REP-03 | Mostrar indicadores mensuales. |
| RF-REP-04 | Mostrar gráficos estadísticos. |
| RF-REP-05 | Filtrar indicadores por período. |
| RF-REP-06 | Actualizar información según permisos del usuario. |

#### Pacientes y citas

| Código | Requisito |
| --- | --- |
| RF-REP-07 | Generar reporte de pacientes registrados. |
| RF-REP-08 | Generar reporte de pacientes nuevos. |
| RF-REP-09 | Generar reporte de pacientes atendidos. |
| RF-REP-10 | Generar estadísticas por edad. |
| RF-REP-11 | Generar estadísticas por sexo. |
| RF-REP-12 | Generar estadísticas por procedencia. |
| RF-REP-13 | Generar reporte de citas. |
| RF-REP-14 | Mostrar citas atendidas. |
| RF-REP-15 | Mostrar citas canceladas. |
| RF-REP-16 | Mostrar citas no asistidas. |
| RF-REP-17 | Mostrar citas por médico. |
| RF-REP-18 | Mostrar citas por especialidad. |
| RF-REP-19 | Calcular tasa de inasistencia. |

#### Atención y emergencias

| Código | Requisito |
| --- | --- |
| RF-REP-20 | Generar reporte de admisiones. |
| RF-REP-21 | Generar reporte de emergencias. |
| RF-REP-22 | Mostrar emergencias por prioridad. |
| RF-REP-23 | Mostrar emergencias por período. |
| RF-REP-24 | Calcular tiempos promedio de espera. |
| RF-REP-25 | Mostrar altas de emergencia. |
| RF-REP-26 | Mostrar referencias y transferencias. |

#### Hospitalización

| Código | Requisito |
| --- | --- |
| RF-REP-27 | Generar reporte de hospitalizaciones. |
| RF-REP-28 | Generar reporte de altas. |
| RF-REP-29 | Mostrar pacientes hospitalizados. |
| RF-REP-30 | Mostrar ocupación de camas. |
| RF-REP-31 | Mostrar camas disponibles. |
| RF-REP-32 | Mostrar ocupación por piso. |
| RF-REP-33 | Mostrar ocupación por especialidad. |
| RF-REP-34 | Calcular estancia promedio. |
| RF-REP-35 | Mostrar traslados. |
| RF-REP-36 | Mostrar fallecimientos. |

#### Historia clínica

| Código | Requisito |
| --- | --- |
| RF-REP-37 | Generar reporte de consultas médicas. |
| RF-REP-38 | Generar reporte de diagnósticos. |
| RF-REP-39 | Mostrar diagnósticos más frecuentes. |
| RF-REP-40 | Filtrar diagnósticos por período. |
| RF-REP-41 | Filtrar diagnósticos por especialidad. |
| RF-REP-42 | Generar reporte de procedimientos. |
| RF-REP-43 | Generar estadísticas clínicas. |

#### Laboratorio e imágenes

| Código | Requisito |
| --- | --- |
| RF-REP-44 | Generar reporte de exámenes de laboratorio. |
| RF-REP-45 | Mostrar exámenes pendientes. |
| RF-REP-46 | Mostrar resultados críticos. |
| RF-REP-47 | Mostrar exámenes por especialidad. |
| RF-REP-48 | Calcular tiempo promedio de respuesta. |
| RF-REP-49 | Generar reporte de estudios de imágenes. |
| RF-REP-50 | Mostrar estudios por tipo. |
| RF-REP-51 | Mostrar informes pendientes. |
| RF-REP-52 | Calcular productividad de imágenes. |

#### Cirugía

| Código | Requisito |
| --- | --- |
| RF-REP-53 | Generar reporte de cirugías. |
| RF-REP-54 | Mostrar cirugías programadas. |
| RF-REP-55 | Mostrar cirugías realizadas. |
| RF-REP-56 | Mostrar cirugías canceladas. |
| RF-REP-57 | Mostrar cirugías por especialidad. |
| RF-REP-58 | Mostrar utilización de quirófanos. |
| RF-REP-59 | Calcular tiempo promedio de cirugía. |

#### Farmacia e inventario

| Código | Requisito |
| --- | --- |
| RF-REP-60 | Generar reporte de medicamentos dispensados. |
| RF-REP-61 | Mostrar medicamentos más utilizados. |
| RF-REP-62 | Mostrar consumo por servicio. |
| RF-REP-63 | Mostrar productos próximos a vencer. |
| RF-REP-64 | Mostrar productos vencidos. |
| RF-REP-65 | Generar reporte de stock. |
| RF-REP-66 | Generar reporte de entradas. |
| RF-REP-67 | Generar reporte de salidas. |
| RF-REP-68 | Generar reporte de transferencias. |
| RF-REP-69 | Generar reporte de consumo por área. |
| RF-REP-70 | Generar Kardex. |

#### Facturación y seguros

| Código | Requisito |
| --- | --- |
| RF-REP-71 | Generar reporte de facturación. |
| RF-REP-72 | Generar reporte de ingresos. |
| RF-REP-73 | Generar reporte de pagos. |
| RF-REP-74 | Generar reporte de cuentas por cobrar. |
| RF-REP-75 | Generar reporte de caja. |
| RF-REP-76 | Mostrar ingresos por método de pago. |
| RF-REP-77 | Generar reporte de aseguradoras. |
| RF-REP-78 | Mostrar prestaciones por aseguradora. |
| RF-REP-79 | Mostrar liquidaciones. |
| RF-REP-80 | Mostrar rechazos de seguros. |
| RF-REP-81 | Calcular porcentaje de rechazo. |
| RF-REP-82 | Mostrar cuentas por cobrar a aseguradoras. |

#### Indicadores y exportación

| Código | Requisito |
| --- | --- |
| RF-REP-83 | Generar indicadores hospitalarios. |
| RF-REP-84 | Calcular tasa de ocupación de camas. |
| RF-REP-85 | Calcular estancia promedio. |
| RF-REP-86 | Calcular productividad médica. |
| RF-REP-87 | Calcular tasa de inasistencia. |
| RF-REP-88 | Generar reportes personalizados. |
| RF-REP-89 | Aplicar filtros dinámicos. |
| RF-REP-90 | Exportar reportes a PDF. |
| RF-REP-91 | Exportar reportes a Excel. |
| RF-REP-92 | Exportar reportes a CSV. |
| RF-REP-93 | Imprimir reportes. |
| RF-REP-94 | Programar reportes periódicos. |
| RF-REP-95 | Registrar auditoría de generación de reportes. |

### 26. 🗄️ Base de datos

Aquí hay una diferencia importante respecto a los módulos anteriores.

No recomiendo duplicar toda la información en tablas de reportes.

El módulo puede inicialmente consultar las tablas operativas:

paciente

cita

admision

historia_clinica

consulta_medica

diagnostico

hospitalizacion

cama

laboratorio

orden_laboratorio

resultado_laboratorio

estudio_imagen

cirugia

medicamento

dispensacion

producto

movimiento_inventario

factura

pago

caja

aseguradora

liquidacion_seguro

Y generar los reportes mediante consultas SQL, vistas o servicios especializados.

### 27. 🚀 Arquitectura recomendada para una versión profesional

Si el hospital crece y existen millones de registros, podemos separar:

BASE OPERACIONAL

```
       │
       │ ETL / ELT
       ↓
```

DATA WAREHOUSE

```
       │
       ↓
```

REPORTES / BI

```
       │
       ├── Dashboard Gerencial
       ├── Dashboard Médico
       ├── Dashboard Financiero
       ├── Dashboard Farmacia
       └── Dashboard Inventario
```

