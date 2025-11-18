package com.msparrow.web_service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msparrow.web_service.dto.EstojoDto;
import com.msparrow.web_service.model.Caneta;
import com.msparrow.web_service.model.CoresType;
import com.msparrow.web_service.model.Estojo;
import com.msparrow.web_service.repository.CanetaRepository;
import com.msparrow.web_service.repository.EstojoRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@RestController
@RequestMapping("/estojo")
public class EstojoController {

    private final EstojoRepository repository;
    private final CanetaRepository canetaRepository;

    @PutMapping
    public Estojo criar(@RequestParam CoresType cor) {
        final Estojo estojo = new Estojo();
        estojo.setCanetas(new ArrayList<>());
        estojo.setCor(cor);

        return repository.save(estojo);
    }

    @GetMapping("/{index}")
    public ResponseEntity<EstojoDto> ver(@PathVariable Integer index) {
        Estojo estojo = repository.findById(index).orElse(null);
        if (estojo == null) {
            return null;
        }
        Integer userId = estojo.getUser() != null ? estojo.getUser().getId() : null;
        List<Integer> canetaIds = estojo.getCanetas().stream().map(c -> c.getId()).toList();
        EstojoDto dto = new EstojoDto(estojo.getId(), estojo.getCor(),
                canetaIds, userId);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/adicionarCaneta")
    public void AdicionarCaneta(@RequestParam("caneta") Integer canetaId, @RequestParam("estojo") Integer index) {
        final Estojo estojo = repository.findById(index).orElse(null);
        final Caneta caneta = canetaRepository.findById(canetaId).orElse(null);

        if (estojo == null || caneta == null)
            return;

        caneta.setEstojo(estojo);
        estojo.getCanetas().add(caneta);
        canetaRepository.save(caneta);
    }

    @DeleteMapping("/excluir")
    public void excluir(@RequestParam("estojo") Integer index) {
        repository.deleteById(index);
    }

}
