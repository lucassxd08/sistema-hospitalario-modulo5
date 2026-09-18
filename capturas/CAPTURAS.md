# Capturas de pantalla — Módulo 5: Historia Clínica

Capturas reales de la aplicación corriendo en `http://localhost:8080`, recortadas para dejar solo el contenido de cada pantalla (sin la barra del navegador ni la barra de tareas de Windows).

Datos de prueba usados en todas las capturas: paciente **Juan Carlos Perez Lopez**, DNI **72456891**, historia clínica **HC-000001-8326**.

---

## 01-panel.png

**Ruta:** `/panel`
**Qué muestra:** el panel de navegación del módulo, con los enlaces a Pacientes, Historias clínicas, Antecedentes personales, Antecedentes familiares y Alergias.

---

## 02-pacientes-rfhc03.png

**Ruta:** `/pacientes`
**Requerimiento:** RF-HC-03 (mostrar los datos básicos del paciente)
**Qué muestra:** la tabla de pacientes registrados, con ID, nombres, apellidos y DNI.

## 03-pacientes-nuevo.png

**Ruta:** `/pacientes/nuevo`
**Qué muestra:** el formulario de registro de un paciente nuevo (nombres, apellidos, DNI).

---

## 04-historias-rfhc01.png

**Ruta:** `/historias`
**Requerimiento:** RF-HC-01 (generar un número único de historia clínica)
**Qué muestra:** la tabla de historias clínicas, con el número único ya generado (`HC-000001-8326`), el paciente asociado, la fecha de apertura y el estado.

## 05-historias-nueva.png

**Ruta:** `/historias/nueva`
**Qué muestra:** el formulario para generar una historia clínica, donde solo se elige el paciente de una lista — el número de historia se genera automáticamente al guardar.

## 06-historia-detalle-rfhc02-03.png

**Ruta:** `/historias/1`
**Requerimientos:** RF-HC-02 (consultar la historia clínica) y RF-HC-03 (mostrar los datos básicos del paciente)
**Qué muestra:** la ficha completa de la historia clínica: número de historia, datos del paciente (nombre, DNI), fecha de apertura, estado, y las tres tablas con los antecedentes personales, familiares y alergias ya registrados. Es la captura que mejor demuestra que las relaciones entre entidades funcionan, porque todo lo que aparece aquí proviene de tablas distintas relacionadas por la historia clínica.

---

## 07-antecedentes-rfhc05.png

**Ruta:** `/antecedentes`
**Requerimiento:** RF-HC-05 (registrar antecedentes personales)
**Qué muestra:** la tabla de antecedentes personales, con el registro de la cirugía (apendicectomía) asociado a la historia `HC-000001-8326`.

## 08-antecedentes-nuevo.png

**Ruta:** `/antecedentes/nuevo`
**Qué muestra:** el formulario de registro de un antecedente personal (ID de historia clínica, categoría, descripción, fecha de registro, observaciones).

---

## 09-antecedentes-familiares-rfhc06.png

**Ruta:** `/antecedentes-familiares`
**Requerimiento:** RF-HC-06 (registrar antecedentes familiares)
**Qué muestra:** la tabla de antecedentes familiares, con el registro de diabetes (parentesco: padre) asociado a la misma historia clínica.

## 10-antecedentes-familiares-nuevo.png

**Ruta:** `/antecedentes-familiares/nuevo`
**Qué muestra:** el formulario de registro de un antecedente familiar (ID de historia clínica, enfermedad, parentesco, fecha de registro, observaciones).

---

## 11-alergias-rfhc07.png

**Ruta:** `/alergias`
**Requerimiento:** RF-HC-07 (registrar alergias)
**Qué muestra:** la tabla de alergias, con el registro de la alergia a la penicilina (reacción: erupción cutánea) asociado a la misma historia clínica.

## 12-alergias-nuevo.png

**Ruta:** `/alergias/nuevo`
**Qué muestra:** el formulario de registro de una alergia (ID de historia clínica, nombre, tipo, reacción, fecha de registro, observaciones).
