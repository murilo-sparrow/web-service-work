package com.msparrow.web_service.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msparrow.web_service.dto.CanetaDto;
import com.msparrow.web_service.model.Caneta;
import com.msparrow.web_service.model.CoresType;
import com.msparrow.web_service.model.Registro;
import com.msparrow.web_service.repository.CanetaRepository;
import com.msparrow.web_service.repository.RegistroRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@RestController
@RequestMapping("/caneta")
public class CanetaController {

    private final CanetaRepository repository;
    private final RegistroRepository registroRepository;

    @PutMapping
    public Caneta criar(@RequestParam CoresType cor) {
        final Caneta caneta = new Caneta();
        caneta.setCor(cor);
        caneta.setTinta(2000);

        return repository.save(caneta);
    }

    @GetMapping("/{index}")
    public ResponseEntity<CanetaDto> ver(@PathVariable Integer index) {
        Caneta caneta = repository.findById(index).orElse(null);
        if (caneta == null)
            return null;
        Integer estojoId = caneta.getEstojo() != null ? caneta.getEstojo().getId() : null;
        CanetaDto dto = new CanetaDto(caneta.getId(), caneta.getCor(), caneta.getTinta(), caneta.isTampada(), estojoId);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/registro/{index}")
    public ResponseEntity<Registro> verRegistro(@PathVariable Integer index) {
        Registro registro = registroRepository.findById(index).orElse(null);
        if (registro == null)
            return null;
        return ResponseEntity.ok(registro);
    }

    @GetMapping("/escrever")
    public String escrever(@RequestParam("caneta") Integer index, @RequestBody String texto,
            @RequestHeader Date writeDate) {
        Caneta caneta = repository.findById(index).orElse(null);
        registroRepository.save(new Registro(caneta.getCor(), caneta.escrever(texto), writeDate));
        return "Data: " + writeDate.toString() + "\n" + caneta.escrever(texto);
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
