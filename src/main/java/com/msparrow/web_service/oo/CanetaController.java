package com.msparrow.web_service.oo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caneta")
public class CanetaController {

    private final CanetaRepository repository;

    public CanetaController(CanetaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/criar")
    public Caneta criar(@RequestParam Cores cor) {
        return repository.insert(new Caneta(cor));
    }

    @GetMapping("/ver")
    public Caneta verCaneta(@RequestParam("caneta") Integer index) {
        return repository.get(index);
    }

    @GetMapping("/escrever")
    public String escrever(@RequestParam("caneta") Integer index, String texto) {
        Caneta caneta = repository.get(index);
        return caneta.escrever(texto);
    }

    @GetMapping("/destampar")
    public void destampar(@RequestParam("caneta") Integer index) {
        Caneta caneta = repository.get(index);
        caneta.setTampada();
    }

    @GetMapping("/excluir")
    public void excluir(@RequestParam("caneta") Integer index) {
        repository.delete(index);
    }

}
