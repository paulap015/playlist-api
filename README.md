# Playlist API

Este proyecto es una API REST desarrollada en **Java 17** con **Spring Boot**, diseñada para gestionar listas de reproducción.

## 📁 Estructura general

- `/lists` Endpoint principal para crear, listar, buscar y eliminar playlists.
- Seguridad básica (HTTP Basic Auth) activada para los endpoints.
- Soporte para CORS (con origen `http://localhost:4200` habilitado por defecto).

---

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Security
- Spring Data JPA (si se usa persistencia)
- H2 Database (modo archivo)
- Maven

---

## Requisitos previos

- JDK 17
- Maven 3.8+
- IntelliJ IDEA / VS Code
- Postman 
- Frontend corriendo en `http://localhost:4200`

---

El servidor estará disponible en:
http://localhost:8080

