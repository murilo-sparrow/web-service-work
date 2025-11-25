package com.msparrow.web_service.service;

import com.msparrow.web_service.dto.EstojoDto;
import com.msparrow.web_service.model.Caneta;
import com.msparrow.web_service.model.CoresType;
import com.msparrow.web_service.model.Estojo;
import com.msparrow.web_service.repository.BaseRepository;
import com.msparrow.web_service.repository.CanetaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstojoService extends BaseService<Estojo, EstojoDto> {

    private final CanetaRepository canetaRepository;

    public EstojoService(BaseRepository<Estojo, Integer> repository, CanetaRepository canetaRepository) {
        super(repository);
        this.canetaRepository = canetaRepository;
    }

    @Override
    Estojo preCriar(Estojo estojo) {
        estojo.setCanetas(new ArrayList<>());
        estojo.setCor(CoresType.AZUL);
        return estojo;
    }

    @Override
    EstojoDto addDto(Estojo estojo) {
        if (estojo == null) {
            return null;
        }
        Integer userId = estojo.getUser() != null ? estojo.getUser().getId() : null;
        List<Integer> canetaIds = estojo.getCanetas().stream().map(Caneta::getId).toList();
        return new EstojoDto(
                estojo.getId(), estojo.getCreatedDate(), estojo.getModifiedDate(), estojo.getCor(), canetaIds, userId);
    }

    public void AdicionarCaneta(Integer canetaId, Integer index) {
        final Estojo estojo = repository.findById(index).orElse(null);
        final Caneta caneta = canetaRepository.findById(canetaId).orElse(null);

        if (estojo == null || caneta == null) return;

        caneta.setEstojo(estojo);
        estojo.getCanetas().add(caneta);
        canetaRepository.save(caneta);
    }

}
