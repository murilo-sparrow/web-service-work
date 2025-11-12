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

import com.msparrow.web_service.dto.CanetaDto;
import com.msparrow.web_service.model.Caneta;
import com.msparrow.web_service.model.CoresType;
import com.msparrow.web_service.repository.CanetaRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@RestController
@RequestMapping("/caneta")
public class CanetaController {

    private final CanetaRepository repository;

    @PutMapping
    public Caneta criar(@RequestParam CoresType cor) {
        final Caneta caneta = new Caneta();
        caneta.setCor(cor);

        return repository.save(caneta);
    }

    @GetMapping("/{index}")
    public ResponseEntity<CanetaDto> ver(@PathVariable Integer index) {
        Caneta caneta = repository.findById(index).orElse(null);
        Integer estojoId = caneta.getEstojo() != null ? caneta.getEstojo().getId() : null;
        CanetaDto dto = new CanetaDto(caneta.getId(), caneta.getCor(), caneta.getTinta(), caneta.isTampada(), estojoId);
        return ResponseEntity.ok(dto);
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
