-- Crear base de datos
CREATE DATABASE IF NOT EXISTS adopcion_mascotas;
USE adopcion_mascotas;

-- Tabla: refugio
CREATE TABLE refugio (
  id_refugio INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL UNIQUE,
  direccion VARCHAR(200) NOT NULL,
  telefono VARCHAR(20)
);

-- Tabla: adoptante
CREATE TABLE adoptante (
  id_adoptante INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  telefono VARCHAR(20),
  correo VARCHAR(100) UNIQUE
);

-- Tabla: mascota
CREATE TABLE mascota (
  id_mascota INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  especie VARCHAR(50),
  raza VARCHAR(50),
  edad INT,
  estado_salud VARCHAR(100),
  descripcion TEXT,
  foto VARCHAR(255),
  estado ENUM('DISPONIBLE','ADOPTADA') DEFAULT 'DISPONIBLE',
  id_refugio INT,
  FOREIGN KEY (id_refugio) REFERENCES refugio(id_refugio)
);

-- Tabla: solicitud_adopcion
CREATE TABLE solicitud_adopcion (
  id_solicitud INT AUTO_INCREMENT PRIMARY KEY,
  id_adoptante INT,
  id_mascota INT,
  fecha_solicitud DATETIME DEFAULT CURRENT_TIMESTAMP,
  estado ENUM('PENDIENTE','APROBADA','RECHAZADA') DEFAULT 'PENDIENTE',
  FOREIGN KEY (id_adoptante) REFERENCES adoptante(id_adoptante),
  FOREIGN KEY (id_mascota) REFERENCES mascota(id_mascota)
);

-- Tabla: adopcion
CREATE TABLE adopcion (
  id_adopcion INT AUTO_INCREMENT PRIMARY KEY,
  id_solicitud INT,
  fecha_adopcion DATE,
  FOREIGN KEY (id_solicitud) REFERENCES solicitud_adopcion(id_solicitud)
);