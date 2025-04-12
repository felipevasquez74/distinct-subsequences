# 🚀 Appgate distinct-subsequences

Aplicación para calcular la cantidad de subsecuencias distintas de un string origen que coincidan exactamente con un string objetivo.

---

## 📦 Descripción del Proyecto

Esta aplicación expone un endpoint REST que recibe dos cadenas de texto (source y target) y devuelve la cantidad de subsecuencias distintas que forman la cadena objetivo a partir de la cadena de origen, sin alterar el orden de los caracteres.

Ideal para resolver desafíos algorítmicos relacionados con subsecuencias, combinatoria, y optimización de recursos mediante técnicas de programación dinámica.

## ⚙️ Tecnologías usadas

☕ Java 21

🧩 Spring Boot 3.3.4

✨ Lombok

📝 SLF4J + MDC logging

🔍 JUnit + Mockito para tests unitarios

📖 Swagger OpenAPI para documentación de la API

🐳 Preparada para contenerización con Docker y docker-compose

## 🗄️ Arquitectura de Contenedores

Al levantar el proyecto con Docker Compose, se levanta:

distinct-subsequences: Aplicación Java Spring Boot

# 🚀 Cómo ejecutar

#### ✅ Requisitos previos

- Tener Docker y Docker Compose instalados.

- Git instalado en tu equipo.

### 🖥️ Linux / MacOS
```bash
1. Clonar el repositorio
gh repo clone felipevasquez74/distinct-subsequences

2. Ingresar al directorio del proyecto
cd distinct-subsequences/

3. Construir y levantar el contenedor
sudo docker-compose up --build
```

### 🖥️ Windows (CMD)
```bash
1. Clonar el repositorio
gh repo clone felipevasquez74/distinct-subsequences

2. Ingresar al directorio del proyecto
cd distinct-subsequences/

3. Construir y levantar el contenedor
docker-compose up --build
```

## 📖 Acceso a la documentación de la API (Swagger)

Una vez levantada la app, accede a:

`http://localhost:8080/swagger-ui/index.html`

Desde Swagger puedes:

Ver la documentación

Probar los endpoints directamente

## 🔌 Endpoints principales

**POST** `http://localhost:8080/api/v1/subsequence/count`

Analiza una mención social y devuelve el nivel de riesgo del contenido.

### 📤 Request Body

```json
{
    "source": "rabbbit",
    "target": "rabbit"
}
```

### 📤 Response Body Exitoso

```json
{
    "timestamp": "2025-04-11T23:42:47.110210484",
    "status": 200,
    "message": "Subsequences counted successfully",
    "data": {
        "subsequenceCount": 3
    },
    "path": "/api/v1/subsequence/count"
}

```

### 📤 Response Body Erroneo

```json
{
    "timestamp": "2025-04-11T23:43:03.526303133",
    "status": 400,
    "message": "Source must be between 1 and 100 characters.",
    "data": null,
    "path": "/api/v1/subsequence/count"
}

```

## 👨‍💻 Autor

Andres Felipe Vasquez Ortiz - Ingeniero de Software

LinkedIn: https://www.linkedin.com/in/andres-felipe-vasquez-ortiz/



