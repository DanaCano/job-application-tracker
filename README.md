# Job Application Tracker

![Build](https://github.com/<tu_usuario>/job-application-tracker/actions/workflows/ci.yml/badge.svg)

API REST en **Java 21 + Spring Boot 3** para gestionar candidaturas (empresa, puesto, estado, notas y fechas). Incluye **Docker**, **Flyway**, **MapStruct**, **tests** (JUnit + Testcontainers) y **CI** con GitHub Actions.

## 🚀 Stack
- Java 21, Spring Boot 3
- PostgreSQL + Flyway
- MapStruct, Bean Validation
- JUnit 5 + Testcontainers
- Docker & GitHub Actions

## ⚙️ Fast execution (dev)
```bash
docker compose up -d
mvn spring-boot:run
```

## 🧪 Tests
```bash
mvn -q -DskipTests=false test
```

## 📚 Key endpoints
- `GET /api/applications`
- `GET /api/applications/{id}`
- `GET /api/applications/status/{status}`
- `POST /api/applications`
- `PUT /api/applications/{id}`
- `DELETE /api/applications/{id}`

Example:
```bash
curl -X POST http://localhost:8080/api/applications   -H "Content-Type: application/json"   -d '{"company":"Acme","position":"Backend Java","status":"APPLIED","notes":"contacted by LinkedIn"}'
```

## 📦 Docker (build & run)
```bash
mvn -q -DskipTests package
docker build -t apptracker:1.0.0 .
docker run --rm -p 8080:8080 --network host apptracker:1.0.0
```

## 📝 Structure
```
src/main/java/... (domain, service, web)
src/test/java/... (unit + integration)
src/main/resources/application.yml
src/main/resources/db/migration/V1__init.sql
.github/workflows/ci.yml
Dockerfile, docker-compose.yml, pom.xml
```

## 🔗 How to upload to GitHub
```bash
git init
git add .
git commit -m "feat: initial commit (Job Application Tracker API)"
git branch -M main
git remote add origin https://github.com/<tu_usuario>/job-application-tracker.git
git push -u origin main
```

## 📄 License
MIT
