# 🐾 Sistema de Adopción de Mascotas

## 📌 Descripción
Este proyecto consiste en el desarrollo de un sistema de adopción de mascotas que facilita la interacción entre refugios y personas interesadas en adoptar.

El sistema permite registrar refugios, mascotas y adoptantes, así como gestionar solicitudes de adopción y dar seguimiento al proceso hasta su aprobación.

---

## 🎯 Objetivo
Desarrollar una aplicación que optimice el proceso de adopción, permitiendo una gestión eficiente de la información y mejorando la experiencia de los usuarios.

---

## 🧩 Funcionalidades principales

### 🏠 Refugios
- Registro de refugios
- Visualización de refugios registrados

### 🐶 Mascotas
- Registro de mascotas
- Asociación con refugios
- Publicación de mascotas disponibles
- Marcado de mascotas como adoptadas
- Visualización de mascotas adoptadas

### 👤 Adoptantes
- Registro de adoptantes
- Validación de datos (correo único)

### 📄 Solicitudes
- Registro de solicitudes de adopción
- Visualización de solicitudes
- Aprobación o rechazo de solicitudes
- Confirmación de adopción

---

## 🧑‍💻 Tecnologías utilizadas
- Lenguaje: Java
- Frontend: JavaFX
- Backend: Java
- Base de datos: MySQL

---

## 🏗️ Arquitectura del sistema

El sistema está organizado siguiendo una estructura modular basada en capas:

- Modelo (Model): Representa las entidades del sistema (Mascota, Refugio, Adoptante, Solicitud).
- Vista (View): Interfaces gráficas desarrolladas en JavaFX (FXML + CSS).
- Controlador (Controller): Maneja la lógica de interacción entre la vista y el modelo.

---

## 🗂️ Estructura del proyecto

```
plataformaAdopciones/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/adopcion/
│       │       ├── controller/
│       │       ├── model/
│       │       └── app/
│       │
│       └── resources/
│           ├── fxml/
│           └── css/
│
├── out/
├── README.md
```

---

## 🚀 Ejecución del proyecto

1. Clonar repositorio
git clone https://github.com/isaizurita/plataformaAdopciones.git
cd plataformaAdopciones

2. Compilar
Asegúrate de tener Java y JavaFX configurados.

javac --module-path /ruta/javafx/lib --add-modules javafx.controls,javafx.fxml -d out $(find src/main/java -name "*.java")

3. Ejecutar

java --module-path /ruta/javafx/lib --add-modules javafx.controls,javafx.fxml -cp out com.adopcion.app.Main

---

## 🖼️ Interfaz del sistema

El sistema cuenta con una interfaz gráfica amigable desarrollada en JavaFX, organizada en módulos principales:

- Refugios
- Mascotas
- Adoptantes
- Solicitudes

---

## 👨‍👩‍👧‍👦 Equipo de desarrollo

- Isaí Obed Zurita Prado
- Jorge Eduardo Carrillo Lozano
- Díaz Soto Alexis
- Mariana Rangel Angeles

---

## 📌 Notas adicionales
- El sistema está diseñado bajo un enfoque modular para facilitar su escalabilidad.
- Se recomienda el uso de Java 17 o superior.
- Es necesario configurar correctamente JavaFX para la ejecución.
