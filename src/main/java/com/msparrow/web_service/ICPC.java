package com.msparrow.web_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ICPC")
public class ICPC {

    @GetMapping("/Watermelon")
    public String Watermelon(@RequestParam Integer peso) {
        if (peso % 2 == 0 && peso != 2) {
            return "YES";
        }
        return "NO";
    }

    @GetMapping("/Fisica")
    public Integer[] Fisica(@RequestParam Integer n) {
        Integer[] Vetores = new Integer[n];
        for (int i = 0; i < Vetores.length; i++) {
            Vetores[i] = i + 1;
        }
        return Vetores;
    }

}
