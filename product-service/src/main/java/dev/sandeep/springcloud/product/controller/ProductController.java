package dev.sandeep.springcloud.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ProductController {

    @GetMapping("/product/{id}")
    public Map<String, Object> get(@PathVariable("id") String id) {

        return Map.of(
                "id", id,
                "name", "Demo Product " + id,
                "price", 999
        );
    }
}
