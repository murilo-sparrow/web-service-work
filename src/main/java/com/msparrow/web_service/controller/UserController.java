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

import com.msparrow.web_service.model.User;
import com.msparrow.web_service.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository repository;

    @PutMapping
    public User criar(@RequestParam String nome) {
        final User user = new User();
        user.setNome(nome);

        return repository.save(user);
    }

    @GetMapping("/{index}")
    public ResponseEntity<User> ver(@PathVariable Integer index) {
        return ResponseEntity.of(repository.findById(index));
    }

    @DeleteMapping("/excluir")
    public void excluir(@RequestParam("user") Integer index) {
        repository.deleteById(index);
    }

}
