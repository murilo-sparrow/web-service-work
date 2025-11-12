package com.msparrow.web_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msparrow.web_service.model.Caneta;
import com.msparrow.web_service.model.Cores;
import com.msparrow.web_service.repository.CanetaRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@RestController
@RequestMapping("/caneta")
public class CanetaController {

    private final CanetaRepository repository;

    @PutMapping
    public Caneta criar(@RequestParam Cores cor) {
        final Caneta caneta = new Caneta();
        caneta.setCor(cor);

        return repository.save(caneta);
    }

    @GetMapping("/{index}")
    public ResponseEntity<Caneta> ver(@PathVariable Integer index) {
        return ResponseEntity.of(repository.findById(index));
    }

    @GetMapping("/escrever")
    public String escrever(@RequestParam("caneta") Integer index, String texto) {
        Caneta caneta = repository.findById(index).orElse(null);
        return caneta.escrever(texto);
    }

    @GetMapping("/altTampa")
    public void destampar(@RequestParam("caneta") Integer index) {
        Caneta caneta = repository.getReferenceById(index);
        caneta.setTampada(!caneta.isTampada());
    }

    @DeleteMapping("/excluir")
    public void excluir(@RequestParam("caneta") Integer index) {
        repository.deleteById(index);
    }

}
