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

import com.msparrow.web_service.model.Estojo;
import com.msparrow.web_service.repository.EstojoRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@RestController
@RequestMapping("/estojo")
public class EstojoController {

    private final EstojoRepository repository;
    // private final CanetaRepository canetaRepository;

    @PutMapping
    public Estojo criar(@RequestParam Integer caneta) {
        final Estojo estojo = new Estojo();
        estojo.canetas = new java.util.ArrayList<>();

        return repository.save(estojo);
    }

    @GetMapping("/{index}")
    public ResponseEntity<Estojo> ver(@PathVariable Integer index) {
        return ResponseEntity.of(repository.findById(index));
    }

    @DeleteMapping("/excluir")
    public void excluir(@RequestParam("estojo") Integer index) {
        repository.deleteById(index);
    }

}
