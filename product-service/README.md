# product-service

A minimal Spring Boot REST service exposing `/products/{id}`.

## Run
```bash
./mvnw spring-boot:run
```
Service starts on port **8081** by default.

## Endpoints
- `GET /products/{id}` → returns product JSON
- `GET /actuator/health`

## Service Discovery (optional)
If you run a Eureka server on `localhost:8761`, this service will auto-register (thanks to the `spring-cloud-starter-netflix-eureka-client` dependency).
