# order-service

A Spring Boot REST service exposing `/orders/{id}` that calls `product-service`
via **OpenFeign**. Includes **Resilience4j** circuit breaker + retry.

## Run
```bash
./mvnw spring-boot:run
```
Service starts on port **8082** by default.

## Configure product-service endpoint
- **With Eureka** (optional): run a registry on `localhost:8761` and run `product-service`. The Feign client will use discovery by `name = "product-service"`.

## Endpoints
- `GET /orders/{id}` → returns order JSON that embeds product details
- `GET /actuator/health`

## Resilience
Circuit breaker + retry are configured in `application.yml` under `resilience4j`.
