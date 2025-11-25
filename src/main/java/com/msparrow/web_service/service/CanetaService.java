package com.msparrow.web_service.service;

import com.msparrow.web_service.dto.CanetaDto;
import com.msparrow.web_service.model.Caneta;
import com.msparrow.web_service.model.CoresType;
import com.msparrow.web_service.model.Registro;
import com.msparrow.web_service.repository.CanetaRepository;
import com.msparrow.web_service.repository.RegistroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CanetaService extends BaseService<Caneta, CanetaDto> {
    private final RegistroRepository registroRepository;

    public CanetaService(CanetaRepository repository, RegistroRepository registroRepository) {
        super(repository);
        this.registroRepository = registroRepository;
    }

    @Override
    public Caneta preCriar(Caneta caneta) {
        caneta.setCor(CoresType.AZUL);
        caneta.setTinta(2000);
        caneta.setTampada(true);

        return caneta;
    }

    @Override
    CanetaDto addDto(Caneta caneta) {
        if (caneta == null)
            return null;
        Integer estojoId = caneta.getEstojo() != null ? caneta.getEstojo().getId() : null;
        return new CanetaDto(caneta.getId(), caneta.getCreatedDate(), caneta.getModifiedDate(), caneta.getCor(), caneta.getTinta(), caneta.isTampada(), estojoId);
    }

    public ResponseEntity<Registro> verRegistro(Integer index) {
        Registro registro = registroRepository.findById(index).orElse(null);
        if (registro == null) return null;
        return ResponseEntity.ok(registro);
    }

    public String escrever(Integer index, String texto, Date writeDate) {
        Caneta caneta = repository.findById(index).orElse(null);
        if (caneta == null) {
            return null;
        }
        if (!caneta.isTampada()) {
            Registro registro = new Registro();
            registro.setCor(caneta.getCor());
            registro.setTexto(caneta.escrever(texto));
            registroRepository.save(registro);
        }
        return "Data: " + writeDate.toString() + "\n" + caneta.escrever(texto);
    }

    public void destampar(Integer index) {
        Caneta caneta = super.repository.getReferenceById(index);
        caneta.setTampada(!caneta.isTampada());
    }
}
