package com.msparrow.web_service;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora/op")
public class Calculadora {

    @GetMapping("/somar")
    public Double somar(@RequestParam Double a, @RequestParam Double b) {
        return a + b;
    }

    @GetMapping("/multi")
    public Map<String, Double> multiplicacao(
            @RequestParam Double a,
            @RequestParam Double b) {

        Double resultado = a * b;
        return Map.of("resultado", resultado);
    }

}
