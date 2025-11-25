package com.msparrow.web_service.controller;

import com.msparrow.web_service.dto.UserDto;
import com.msparrow.web_service.model.User;
import com.msparrow.web_service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PutMapping
    public User criar() {
        return service.criar(new User());
    }

    @PostMapping("/adicionarEstojo")
    public void AdicionarEstojo(@RequestParam("estojo") Integer estojoId, @RequestParam("user") Integer index) {
        service.AdicionarEstojo(estojoId, index);
    }

    @GetMapping("/{index}")
    public ResponseEntity<UserDto> ver(@PathVariable Integer index) {
        return service.ver(index);
    }

    @DeleteMapping("/excluir")
    public void excluir(@RequestParam("user") Integer index) {
        service.excluir(index);
    }

}
