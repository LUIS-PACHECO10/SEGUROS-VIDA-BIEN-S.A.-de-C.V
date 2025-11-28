# Prueba Técnica – Microservicios de Seguros

Este proyecto contiene dos microservicios independientes desarrollados con **Spring Boot 3**, **Java 17**, **H2**, y **Spring Cloud OpenFeign**.  
El objetivo es consultar información de seguros y validar si un usuario es apto para contratarlos.

---

## 🧩 Microservicios

### 1. `mso-es-consulta-seguros-v1`
Microservicio encargado de exponer la **información de seguros** disponibles (VIDA, INFARTO, MUJER).

**Tecnologías:**
- Spring Boot Web  
- Spring Data JPA  
- H2 (en memoria)  

**Endpoints:**

| Método | URL                         | Descripción |
|--------|------------------------------|-------------|
| GET    | `/seguros`                   | Obtiene la lista completa de seguros |
| GET    | `/seguros/{idSeguro}`        | Obtiene un seguro específico por id |

Los datos se cargan automáticamente desde el archivo `data.sql` al iniciar el microservicio.

---

### 2. `mso-ts-validaciones-v1`
Microservicio encargado de **validar** si un cliente cumple las condiciones para contratar un seguro.

**Tecnologías:**
- Spring Boot Web  
- Spring Cloud OpenFeign (para consumir MS1)  
- Validaciones con Java Time y reglas de negocio  

**Endpoint:**

| Método | URL             | Descripción |
|--------|------------------|-------------|
| POST   | `/validaciones`  | Valida si un cliente puede contratar un seguro |

**Reglas implementadas:**
- Validar rango de edad definido por el seguro.  
- Validar género solo si el seguro lo requiere (ej. “MUJER”).  
- Respuesta diferenciada:
  - `201` → Cumple los requisitos.  
  - `401` → No cumple los requisitos.  

---

## ▶️ Ejecución

### Levantar Microservicio 1 (consulta de seguros)
```bash
cd mso-es-consulta-seguros-v1
mvn spring-boot:run
