package com.msparrow.web_service.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
@Data
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity {

    private String nome;

    @OneToMany(mappedBy = "user")
    private List<Estojo> estojos;

}
