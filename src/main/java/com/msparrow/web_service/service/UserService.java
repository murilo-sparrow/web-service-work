package com.msparrow.web_service.service;

import com.msparrow.web_service.dto.UserDto;
import com.msparrow.web_service.model.Estojo;
import com.msparrow.web_service.model.User;
import com.msparrow.web_service.repository.BaseRepository;
import com.msparrow.web_service.repository.EstojoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseService<User, UserDto> {

    private final EstojoRepository estojoRepository;

    public UserService(BaseRepository<User, Integer> repository, EstojoRepository estojoRepository) {
        super(repository);
        this.estojoRepository = estojoRepository;
    }

    @Override
    User preCriar(User obj) {
        obj.setNome("Murilo");
        return obj;
    }

    @Override
    UserDto addDto(User user) {
        if (user == null) {
            return null;
        }
        List<Integer> EstojoIds = user.getEstojos().stream().map(e -> e.getId()).toList();
        return new UserDto(user.getId(), user.getCreatedDate(), user.getModifiedDate(), user.getNome(), EstojoIds);
    }

    public void AdicionarEstojo(Integer estojoId, Integer index) {
        final User user = repository.findById(index).orElse(null);
        final Estojo estojo = estojoRepository.findById(estojoId).orElse(null);

        if (user == null || estojo == null) return;

        estojo.setUser(user);
        user.getEstojos().add(estojo);
        estojoRepository.save(estojo);
    }

}
