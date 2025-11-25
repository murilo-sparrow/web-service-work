package com.msparrow.web_service.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Estojo extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CoresType cor;

    @OneToMany(mappedBy = "estojo")
    private List<Caneta> canetas;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
