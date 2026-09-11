# Índice de Módulos — Sistema Web Integral para la Gestión Hospitalaria

Resumen de los 16 módulos descritos en la **Evaluación N° 01** (Desarrollo de Aplicaciones Web Avanzado: Implementación de Persistencia — Spring Boot, IoC/DI, APIs REST, Hibernate/JPA, Thymeleaf).

Documento completo: [Evaluacion-01.md](Evaluacion-01.md)

---

## Escala de dificultad

Estimación de esfuerzo para implementar el módulo en Spring Boot + JPA + Thymeleaf, considerando cantidad de entidades, relaciones, reglas de negocio y dependencias de otros módulos.

| Estrellas | Nivel | Qué implica |
| --- | --- | --- |
| ★☆☆☆☆ | Muy fácil | CRUD simple, 1-2 entidades, sin reglas especiales |
| ★★☆☆☆ | Fácil | CRUD con validaciones y algunas relaciones |
| ★★★☆☆ | Medio | Varias entidades relacionadas, estados o lógica de negocio propia |
| ★★★★☆ | Difícil | Máquina de estados, validaciones cruzadas, integra con otros módulos |
| ★★★★★ | Muy difícil | Lógica transaccional crítica, muchas entidades, depende de varios módulos |

---

## Tabla resumen

| # | Módulo | Dificultad | Propósito en una línea | Entidades núcleo |
| --- | --- | --- | --- | --- |
| 1 | Login / Usuarios y Roles | ★★★☆☆ | Autenticación, gestión de usuarios, roles, permisos y auditoría | Usuario, Rol, Permiso, Bitácora |
| 2 | Pacientes | ★★☆☆☆ | Registro y mantenimiento del padrón de pacientes | Paciente, Contacto emergencia, Seguro, Antecedente |
| 3 | Citas Médicas | ★★★★☆ | Programación, agenda, check-in y seguimiento de citas | Cita, Agenda, Horario |
| 4 | Médicos y Especialidades | ★★★☆☆ | Personal médico, especialidades, horarios y consultorios | Médico, Especialidad, Consultorio, Horario |
| 5 | Historia Clínica | ★★★★☆ | Registro clínico longitudinal del paciente | Historia, Consulta, Diagnóstico, Tratamiento, Receta |
| 6 | Admisión y Emergencias | ★★★☆☆ | Admisión, triaje y atención de urgencias | Admisión, Triaje, Emergencia, Derivación |
| 7 | Hospitalización | ★★★★★ | Internamiento: camas, evolución, indicaciones y alta | Hospitalización, Cama, Evolución, Indicación |
| 8 | Enfermería | ★★★★☆ | Ejecución y registro de los cuidados de enfermería | Valoración, Signos vitales, Plan de cuidados, Nota |
| 9 | Farmacia y Medicamentos | ★★★★★ | Ciclo del medicamento: receta, stock, dispensación | Medicamento, Lote, Receta, Dispensación, Kardex |
| 10 | Laboratorio Clínico | ★★★★☆ | Órdenes de análisis, muestras, resultados y validación | Orden, Muestra, Examen, Resultado |
| 11 | Diagnóstico por Imágenes | ★★★★☆ | Estudios radiológicos, imágenes e informes | Estudio, Imagen (DICOM), Informe, Equipo |
| 12 | Quirófano / Cirugía | ★★★★★ | Solicitud, programación y registro operatorio | Solicitud quirúrgica, Quirófano, Cirugía, Insumo |
| 13 | Facturación y Caja | ★★★★★ | Cargos, comprobantes, pagos y arqueo de caja | Cargo, Cuenta, Comprobante, Pago, Caja |
| 14 | Seguros | ★★★★★ | Aseguradoras, coberturas, autorizaciones y liquidaciones | Aseguradora, Póliza, Cobertura, Autorización |
| 15 | Inventario y Almacén | ★★★★☆ | Stock de insumos: entradas, salidas, lotes, trazabilidad | Producto, Almacén, Lote, Movimiento, Kardex |
| 16 | Reportes y Estadísticas | ★★★☆☆ | Información gerencial: indicadores, dashboards y exportación | Reporte, Indicador, Dashboard |

### Orden sugerido de implementación

De menor a mayor dificultad y respetando las dependencias entre módulos:

1. **Base (★★–★★★):** Pacientes → Médicos y Especialidades → Login/Usuarios y Roles
2. **Núcleo asistencial (★★★–★★★★):** Citas Médicas → Historia Clínica → Admisión y Emergencias
3. **Avanzados (★★★★–★★★★★):** Hospitalización → Enfermería → Laboratorio → Imágenes → Cirugía
4. **Logística y dinero (★★★★–★★★★★):** Inventario → Farmacia → Facturación y Caja → Seguros
5. **Cierre (★★★):** Reportes y Estadísticas (se apoya en todo lo anterior)

> Si el alcance de la evaluación permite elegir, los módulos 2, 4 y 3 dan un CRUD completo con relaciones `OneToMany`/`ManyToMany` reales —suficiente para cubrir todos los criterios de la rúbrica— sin el costo de los módulos de cinco estrellas.

---

## Módulo 1 — Login / Usuarios y Roles

**Dificultad: ★★★☆☆ (3/5)** — Autenticación y RBAC no son un CRUD: hay que cifrar contraseñas, manejar la sesión, el bloqueo por intentos fallidos, la expiración del token de recuperación y validar permisos en el backend. Spring Security resuelve buena parte, pero la matriz rol × permiso agrega una capa extra.

Controla el acceso al sistema. Inicio de sesión con usuario o correo y contraseña, validación de credenciales, mensajes de error, bloqueo temporal tras varios intentos fallidos, cierre de sesión y redirección al módulo según el rol. Incluye recuperación de contraseña por enlace/código con expiración.

El administrador registra, modifica, consulta y activa/desactiva usuarios, les asigna roles, área y los asocia a un empleado o profesional de salud. Define 10 roles tipo (Administrador, Director, Médico, Enfermería, Recepcionista, Farmacia, Laboratorio, Contabilidad, Almacén, Consulta) y permisos granulares (Ver, Crear, Editar, Eliminar, Anular, Exportar, Imprimir, Aprobar), con una matriz módulo × rol.

Control de acceso: solo muestra módulos autorizados, impide el acceso directo por URL, **valida permisos en el backend y no solo en el frontend**, cierra sesión por inactividad y registra en bitácora las operaciones críticas.

**Requerimientos:** RF-LOGIN-01…05, RF-USR-01…05, RF-ROL-01…04, RF-AUD-01…02

---

## Módulo 2 — Pacientes

**Dificultad: ★★☆☆☆ (2/5)** — El más accesible: CRUD con validaciones (documento único, código autogenerado) y relaciones `OneToMany` hacia contactos, seguros y antecedentes. Ideal para arrancar y para demostrar la persistencia con Hibernate.

Padrón de pacientes con datos de identificación (tipo y número de documento, nombres, apellidos, fecha de nacimiento, edad calculada, sexo, estado civil), contacto, domicilio (distrito/provincia/departamento), ocupación, tipo de sangre y estado.

Genera un código único de paciente, valida que el documento no esté duplicado y permite búsquedas por DNI, código, nombres, apellidos, teléfono o historia clínica. Registra contactos de emergencia (con parentesco y contacto principal), datos de seguro (aseguradora, póliza, afiliación, vigencia) y antecedentes personales, familiares y alergias.

Estados: Activo, Inactivo, Fallecido. **Regla clave:** no se elimina físicamente a un paciente con historial de atenciones; se cambia el estado y se conserva la información histórica.

**Requerimientos:** RF-PAC-01…13

---

## Módulo 3 — Citas Médicas

**Dificultad: ★★★★☆ (4/5)** — La dificultad está en el control de disponibilidad: cruzar médico, consultorio, fecha y hora para impedir solapamientos, generar los horarios disponibles a partir de la configuración del médico y manejar la máquina de estados de la cita con su historial de reprogramaciones.

Programación de citas seleccionando paciente, especialidad, médico, consultorio, fecha y hora, con verificación de disponibilidad: el sistema no permite reservar un horario ocupado ni dos citas del mismo médico a la misma hora.

Incluye agenda médica visualizable por día, semana y mes; configuración de horarios de atención por médico; confirmación, reprogramación (conservando el historial del cambio) y cancelación con motivo y usuario responsable — sin borrado físico. Maneja el ciclo de estados PROGRAMADA → CONFIRMADA → EN ESPERA → EN ATENCIÓN → ATENDIDA, más CANCELADA y NO ASISTIÓ.

Contempla check-in en recepción, pantalla de llamado de pacientes, historial de citas por paciente y reportes de asistencia (atendidas, canceladas, inasistencias, horarios de mayor demanda).

**Requerimientos:** RF-CIT-01…21

---

## Módulo 4 — Médicos y Especialidades

**Dificultad: ★★★☆☆ (3/5)** — CRUD de médicos y especialidades con relación `ManyToMany`, más la configuración de horarios por día y la asignación de consultorios. La lógica es contenida, pero es la base que alimenta la disponibilidad de Citas.

Registro de médicos con código interno, documento, CMP, RNE, contacto, fecha de ingreso, especialidad y subespecialidad. Mantiene el catálogo de especialidades (19 ejemplos, de Medicina General a Radiología) con duración estándar de consulta, admitiendo que un médico tenga varias especialidades.

Administra horarios de atención, duración de citas, consultorios y su asignación, disponibilidad del médico, bloqueo de horarios, vacaciones y permisos, estado del médico, perfil profesional, búsqueda y reportes. Es el módulo que alimenta la disponibilidad usada por Citas Médicas.

**Estructura de relación:** Especialidad → Médico → (Horarios, Consultorios, Citas)

---

## Módulo 5 — Historia Clínica

**Dificultad: ★★★★☆ (4/5)** — Muchas entidades hijas (consultas, diagnósticos, tratamientos, recetas, exámenes, evolución, adjuntos) colgando de una historia única, con vista cronológica, control de acceso por rol y auditoría. El reto es el modelo de datos y el rendimiento de las consultas.

Registro clínico longitudinal del paciente. Crea una historia única por paciente y acumula consultas con motivo, anamnesis, examen físico, signos vitales, evaluación médica, diagnósticos (CIE), tratamiento, recetas, solicitudes de exámenes y sus resultados, evolución y procedimientos.

Ofrece historial cronológico, documentos clínicos adjuntos, control de acceso por rol, auditoría de consultas y modificaciones, y cierre formal de la consulta. Es el módulo que integra la información producida por Citas, Emergencias, Hospitalización, Laboratorio, Imágenes y Farmacia.

**Requerimientos:** sección 22 del módulo

---

## Módulo 6 — Admisión y Emergencias

**Dificultad: ★★★☆☆ (3/5)** — Flujo claro con triaje por niveles de prioridad y derivaciones internas. Se complica por los casos borde: paciente no identificado (NN), control de tiempos de atención y el enlace hacia Hospitalización.

Gestiona la entrada del paciente al hospital por vía ambulatoria o de urgencia. Registra la admisión, distingue los tipos de admisión y aplica **triaje** con clasificación por niveles de prioridad de emergencia.

Maneja sala de espera, atención de emergencia, derivación interna, paso a hospitalización, alta de emergencia, referencias externas, registro de acompañante y el caso especial de **paciente no identificado (NN)**. Controla tiempos de atención (indicador clave de urgencias), búsqueda de admisiones y reportes.

**Requerimientos:** sección 18 del módulo

---

## Módulo 7 — Hospitalización

**Dificultad: ★★★★★ (5/5)** — Uno de los más pesados: jerarquía piso–habitación–cama con estados y concurrencia en la asignación, traslados internos, evolución diaria, indicaciones médicas, interconsultas, alta y fallecimiento. Depende de Admisión, Enfermería y Facturación.

Administra todo el proceso del paciente internado, desde la solicitud de hospitalización hasta el alta médica.

Cubre solicitud e ingreso hospitalario, gestión de pisos, habitaciones y camas, asignación y liberación de cama, listado de pacientes hospitalizados, movimientos y traslados internos, evolución médica diaria, indicaciones médicas, interconsultas, procedimientos, integración con Enfermería, alta hospitalaria y registro de fallecimiento. Incluye reportes de ocupación y una propuesta de diseño de base de datos.

**Flujo:** Paciente → Admisión/Emergencia → Solicitud → Ingreso → Cama → Evolución/Indicaciones → Alta

---

## Módulo 8 — Enfermería

**Dificultad: ★★★★☆ (4/5)** — Depende por completo de Hospitalización: recibe las indicaciones médicas y las convierte en tareas ejecutadas por turno. El balance hídrico, la hoja de administración de medicamentos y el reporte de cambio de turno exigen un modelo temporal cuidadoso.

Convierte las indicaciones médicas en actividades de cuidado y registra todo lo realizado al paciente, principalmente durante la hospitalización.

Incluye panel de enfermería, asignación de pacientes por turno, valoración de enfermería, toma de signos vitales, plan de cuidados, recepción de indicaciones médicas, administración de medicamentos, procedimientos, balance hídrico, notas de enfermería, reporte de cambio de turno y alertas. Trae reportes y diseño de base de datos propios.

**Flujo:** Hospitalización → Indicaciones médicas → Enfermería → Ejecución y registro → Historia Clínica

---

## Módulo 9 — Farmacia y Medicamentos

**Dificultad: ★★★★★ (5/5)** — El inventario con lotes, vencimientos y FEFO obliga a lógica transaccional: descontar del lote correcto, evitar stock negativo, registrar el kardex y manejar devoluciones y ajustes. Además se conecta con Recetas, Enfermería, Facturación y Almacén.

Administra el ciclo completo del medicamento: Médico → Prescripción/Receta → Farmacia → Dispensación → Enfermería → Administración → Historia Clínica.

Mantiene el maestro de medicamentos (principio activo, presentaciones, categorías, laboratorios, proveedores), inventario con lotes y fechas de vencimiento y **control FEFO** (primero el que vence antes). Gestiona recetas y sus estados, dispensación ambulatoria y para hospitalizados, devoluciones, ajustes de inventario, kardex, alertas de stock y vencimiento, y reportes.

**Separación de responsabilidades:** Inventario y Almacén (Módulo 15) maneja compras, recepción y distribución general; Farmacia se concentra en el manejo clínico y la dispensación.

---

## Módulo 10 — Laboratorio Clínico

**Dificultad: ★★★★☆ (4/5)** — Ciclo largo orden → muestra → procesamiento → resultado → validación, con valores de referencia por examen, detección de resultados fuera de rango y alerta de resultados críticos. Lo más exigente es modelar exámenes con múltiples parámetros.

Administra el proceso completo de los exámenes de laboratorio, desde la orden médica hasta la validación y entrega de resultados.

Incluye catálogo de exámenes, tipos de muestra, orden de laboratorio y sus estados, programación, recepción y toma de muestra, identificación y rechazo de muestras, procesamiento, registro de resultados contra valores de referencia, marcado de resultados fuera de rango y **resultados críticos**, validación y corrección de resultados, informe de laboratorio, equipos e incidencias.

**Integra con:** Pacientes, Historia Clínica, Citas, Hospitalización, Farmacia, Facturación y Reportes.

---

## Módulo 11 — Diagnóstico por Imágenes

**Dificultad: ★★★★☆ (4/5)** — Flujo parecido al de Laboratorio, pero suma el manejo de archivos de imagen y el informe radiológico con validación. Baja bastante de dificultad si se guarda solo la referencia al estudio y se deja el PACS/DICOM fuera del alcance, como sugiere el propio documento.

Gestiona los estudios de imágenes médicas (radiografía, ecografía, tomografía, entre otros) desde la solicitud del médico hasta la generación, validación y entrega del informe.

Cubre catálogo de estudios, solicitud médica, programación, recepción del paciente, realización del estudio, almacenamiento de imágenes, informe radiológico, validación, resultados críticos, integración con Historia Clínica, equipos, mantenimiento e incidencias.

**Recomendación de arquitectura del documento:** dejar preparada la separación entre el sistema hospitalario (pacientes, órdenes, programación, informes, permisos, auditoría) y un **servidor PACS/DICOM** para las imágenes, aunque no se implemente el PACS completo en la primera versión.

---

## Módulo 12 — Quirófano / Cirugía

**Dificultad: ★★★★★ (5/5)** — Agenda de quirófanos (solapamientos, como en Citas, pero además con equipo quirúrgico y sala), evaluación preoperatoria, consumo de insumos y medicamentos descontados del stock, y registro operatorio completo. Es el módulo con más requisitos funcionales del documento.

Gestiona integralmente los procedimientos quirúrgicos: solicitud quirúrgica y sus estados, evaluación preoperatoria, autorización, programación y agenda de quirófanos, equipo quirúrgico y preparación del paciente.

Registra el ingreso a quirófano, anestesia, registro operatorio, procedimientos realizados, insumos y medicamentos utilizados, complicaciones e incidencias, recuperación y evolución postoperatoria, cierre de la cirugía e historial quirúrgico del paciente. Incluye requisitos funcionales extensos, propuesta de base de datos e integración con los demás módulos.

---

## Módulo 13 — Facturación y Caja

**Dificultad: ★★★★★ (5/5)** — El concepto cargo ≠ pago ≠ comprobante obliga a modelar tres entidades separadas y mantenerlas consistentes. Pagos parciales, cuentas por cobrar, anulaciones, devoluciones y arqueo de caja exigen transacciones correctas: aquí un error se traduce en descuadre de dinero.

Gestiona los cargos generados por las atenciones y servicios (consultas, emergencias, hospitalización, farmacia, laboratorio, imágenes, cirugía) y los pagos de pacientes, familiares, empresas o aseguradoras.

**Concepto central del módulo: cargo ≠ pago ≠ comprobante.** Maneja tarifario, cargos, cuenta del paciente y cuenta hospitalaria, facturación, tipos y estados de comprobante, pagos totales y parciales, créditos y cuentas por cobrar, caja con sus movimientos, arqueo y cierre, devoluciones y anulaciones, además de la integración con Seguros.

---

## Módulo 14 — Seguros

**Dificultad: ★★★★★ (5/5)** — Reglas económicas densas: coberturas con límites y exclusiones, copagos, deducibles, autorizaciones con estados, cartas de garantía, liquidación y conciliación. No se puede implementar bien sin tener Facturación resuelta antes.

Gestiona la relación entre hospital, pacientes y compañías aseguradoras: aseguradoras, planes, pólizas y afiliación del paciente, con validación de afiliación al momento de la atención.

Administra coberturas, límites, exclusiones, autorizaciones y sus estados, cartas de garantía, prestaciones, copagos y deducibles, liquidación a la aseguradora, rechazos y conciliación de pagos. Incluye requisitos funcionales, base de datos propuesta y una arquitectura económica recomendada en conjunto con Facturación.

---

## Módulo 15 — Inventario y Almacén

**Dificultad: ★★★★☆ (4/5)** — Múltiples almacenes y ubicaciones, entradas, salidas, requisiciones, transferencias, ajustes e inventario físico, todo con trazabilidad por lote y kardex. Dificultad técnica parecida a Farmacia, pero con menos reglas clínicas.

Controla medicamentos, insumos médicos, materiales quirúrgicos y de laboratorio, productos de limpieza y demás bienes, manteniendo trazabilidad de entradas, salidas, transferencias, lotes, vencimientos y stock por almacén y ubicación.

Incluye gestión de productos, categorías, unidades de medida, almacenes y ubicaciones, entradas, lotes y vencimientos, salidas, requisiciones, transferencias, ajustes, kardex, alertas, devoluciones e inventario físico.

**Reglas de negocio destacadas:** no eliminar movimientos, control por lote, no permitir despachar productos vencidos, trazabilidad completa, y separación clara de responsabilidades con Farmacia y con Facturación.

---

## Módulo 16 — Reportes y Estadísticas

**Dificultad: ★★★☆☆ (3/5)** — No introduce reglas de negocio nuevas: consulta lo que los demás módulos ya guardaron. La dificultad viene de las consultas agregadas, los filtros y la exportación. Solo escala a cinco estrellas si se implementa el ETL y el Data Warehouse que recomienda el documento.

Centro de información gerencial y operativa: transforma los datos de los demás módulos en reportes, indicadores y gráficos para la toma de decisiones.

Cubre dashboard general y gráficos, y reportes por área: pacientes, citas, productividad médica, emergencias, hospitalización, diagnósticos, laboratorio, imágenes, cirugía, farmacia, inventario, financieros y seguros. Añade indicadores hospitalarios, filtros, exportación, reportes personalizados y programados, y seguridad de reportes por rol.

**Recomendación de arquitectura del documento:** para una versión profesional, separar la operación del análisis mediante un proceso ETL/ELT hacia un Data Warehouse que alimente los dashboards (Gerencial, Médico, Financiero, Farmacia, Inventario).

---

## Criterios de evaluación

| Criterio | Qué se califica |
| --- | --- |
| Arquitectura (IoC y DI) | Aplicación correcta de IoC y DI en todas las capas; código estructurado |
| Backend (APIs REST – CRUD) | Endpoints CRUD completos y buen uso de REST |
| Base de datos y relaciones | Modelo correcto con relaciones bien implementadas (OneToMany, etc.) |
| Frontend (Thymeleaf) | Interfaces funcionales, claras e integradas con el backend |
| Pruebas (Postman y validación) | Evidencia completa de pruebas y endpoints verificados |

Escala: Excelente (20-18) · Bueno (17-14) · Regular (13-11) · Deficiente (10-0)
