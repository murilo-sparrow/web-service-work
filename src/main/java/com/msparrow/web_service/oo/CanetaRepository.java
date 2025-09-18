package com.msparrow.web_service.oo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CanetaRepository {

    private final List<Caneta> canetas = new ArrayList<>();

    public Caneta insert(Caneta caneta) {
        canetas.add(caneta);
        caneta.setId(canetas.indexOf(caneta));
        return caneta;
    }

    public Caneta change(Integer index, Caneta caneta) {
        canetas.set(index, caneta);
        return caneta;
    }

    public Caneta get(Integer index) {
        return canetas.get(index);
    }

    public void delete(Integer index) {
        canetas.set(index, null);
    }

}
