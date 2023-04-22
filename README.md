# kotlin-spring-boot-projects
Kotlin Spring Boot Project

## Tech Stack
- Kotlin
- Spring Boot 3.0.6
- Gradle
- PostgreSQL
- Flyway, Mapstruct

### Implementation Summary

###### 01. setup database, add Customer entity and create few basic endpoints
- add dependencies in build.gradle.kts
- setup docker-compose for PostgeSQL
- configure application.yml
- add sql file for Flyway migrations
- Customer Entity
  - add model, controller, service, repository, dto, mapper
  - add endpoint: GET `/api/v1/customers?sort=id&size=5&page=0`
  - add endpoint: GET `/api/v1/customers/{customerId}`
  - add endpoint: POST `/api/v1/customers`
- Add MapperConfig, PagedResponseDto

### Run locally
- On the host, from IDE:
```
select appropriate branch and run:
  1 -> docker-compose.yml
  2 -> JavaSpringBootProjectsApplication.main