package dev.sandeep.springcloud.order.controller;

import dev.sandeep.springcloud.order.client.ProductClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class OrderController {
    private final ProductClient productClient;

    public OrderController(ProductClient productClient) {
        this.productClient = productClient;
    }

    @GetMapping("/order/{id}")
    @CircuitBreaker(name = "productClient", fallbackMethod = "fallback")
    @Retry(name = "productClient")
    public Map<String, Object> get(@PathVariable("id") String id) {
        Map<String, Object> product = productClient.getProduct(id);
        return Map.of(
                "orderId", id,
                "product", product
        );
    }

    public Map<String, Object> fallback(String id, Throwable t) {
        return Map.of(
                "orderId", id,
                "product", Map.of("id", "N/A", "name", "Unavailable"),
                "reason", t.getClass().getSimpleName()
        );
    }
}
