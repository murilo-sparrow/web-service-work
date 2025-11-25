package com.msparrow.web_service.controller;

import com.msparrow.web_service.dto.CanetaDto;
import com.msparrow.web_service.model.Caneta;
import com.msparrow.web_service.model.Registro;
import com.msparrow.web_service.service.CanetaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Transactional
@RestController
@RequestMapping("/caneta")
public class CanetaController {

    private final CanetaService service;

    public CanetaController(CanetaService service) {
        this.service = service;
    }

    @PutMapping
    public Caneta criar() {
        return service.criar(new Caneta());
    }

    @GetMapping("/{index}")
    public ResponseEntity<CanetaDto> ver(@PathVariable Integer index) {
        if (service.ver(index) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return service.ver(index);
        }
    }

    @GetMapping("/registro/{index}")
    public ResponseEntity<Registro> verRegistro(@PathVariable Integer index) {
        if (service.verRegistro(index) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return service.verRegistro(index);
        }
    }

    @GetMapping("/escrever")
    public String escrever(@RequestParam("caneta") Integer index, @RequestBody String texto, @RequestHeader Date writeDate) {
        return service.escrever(index, texto, writeDate);
    }

    @GetMapping("/altTampa")
    public void destampar(@RequestParam("caneta") Integer index) {
        service.destampar(index);
    }

    @DeleteMapping("/excluir")
    public void excluir(@RequestParam("caneta") Integer index) {
        service.excluir(index);
    }

}
