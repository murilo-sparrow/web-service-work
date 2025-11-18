package com.msparrow.web_service.controller;

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

import com.msparrow.web_service.dto.UserDto;
import com.msparrow.web_service.model.Estojo;
import com.msparrow.web_service.model.User;
import com.msparrow.web_service.repository.EstojoRepository;
import com.msparrow.web_service.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository repository;
    private final EstojoRepository estojoRepository;

    @PutMapping
    public User criar(@RequestParam String nome) {
        final User user = new User();
        user.setNome(nome);

        return repository.save(user);
    }

    @PostMapping("/adicionarEstojo")
    public void AdicionarEstojo(@RequestParam("estojo") Integer estojoId, @RequestParam("user") Integer index) {
        final User user = repository.findById(index).orElse(null);
        final Estojo estojo = estojoRepository.findById(estojoId).orElse(null);

        if (user == null || estojo == null)
            return;

        estojo.setUser(user);
        user.getEstojos().add(estojo);
        estojoRepository.save(estojo);
    }

    @GetMapping("/{index}")
    public ResponseEntity<UserDto> ver(@PathVariable Integer index) {
        User user = repository.findById(index).orElse(null);
        if (user == null) {
            return null;
        }
        List<Integer> EstojoIds = user.getEstojos().stream().map(e -> e.getId()).toList();
        UserDto dto = new UserDto(user.getId(), user.getNome(), EstojoIds);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/excluir")
    public void excluir(@RequestParam("user") Integer index) {
        repository.deleteById(index);
    }

}
