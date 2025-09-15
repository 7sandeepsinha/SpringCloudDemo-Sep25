package dev.sandeep.springcloud.order.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.Map;

@FeignClient(name = "product-service")
public interface ProductClient {
    @GetMapping("/product/{id}")
    Map<String, Object> getProduct(@PathVariable("id") String id);
}
