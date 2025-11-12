package com.msparrow.web_service.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Estojo {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    // One pencil case has many pens. "mappedBy" points to the field in Caneta that
    // owns the FK.
    @jakarta.persistence.OneToMany(mappedBy = "estojo")
    @lombok.ToString.Exclude
    @lombok.EqualsAndHashCode.Exclude
    public List<Caneta> canetas;

}
