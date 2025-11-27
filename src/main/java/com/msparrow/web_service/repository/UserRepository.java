package com.msparrow.web_service.repository;

import com.msparrow.web_service.model.User;
import com.msparrow.web_service.model.UserName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<User, Integer> {
    @Query("select class from User class where class.nome = ?1")
    List<User> findByName(String nome);

    @Query("select class from User class where class.nome = ?1")
    List<UserName> findByNameProjection(String nome);
}
