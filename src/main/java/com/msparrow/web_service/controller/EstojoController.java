package com.msparrow.web_service.controller;

import com.msparrow.web_service.dto.EstojoDto;
import com.msparrow.web_service.model.Estojo;
import com.msparrow.web_service.service.EstojoService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
@RequestMapping("/estojo")
public class EstojoController {

    private final EstojoService service;

    public EstojoController(EstojoService service) {
        this.service = service;
    }

    @PutMapping

    public Estojo criar() {
        return service.criar(new Estojo());
    }

    @GetMapping("/{index}")
    public ResponseEntity<EstojoDto> ver(@PathVariable Integer index) {
        return service.ver(index);
    }

    @PostMapping("/adicionarCaneta")
    public void AdicionarCaneta(@RequestParam("caneta") Integer canetaId, @RequestParam("estojo") Integer index) {
        service.AdicionarCaneta(canetaId, index);
    }

    @DeleteMapping("/excluir")
    public void excluir(@RequestParam("estojo") Integer index) {
        service.excluir(index);
    }
}
