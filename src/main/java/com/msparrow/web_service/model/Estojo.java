package com.msparrow.web_service.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Estojo {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Cores cor;

    @OneToMany(mappedBy = "estojo")
    public List<Caneta> canetas;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
