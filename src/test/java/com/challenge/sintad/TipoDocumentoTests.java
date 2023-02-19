package com.challenge.sintad;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.challenge.sintad.model.TipoDocumento;
import com.challenge.sintad.repository.TipoDocumentoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TipoDocumentoTests {

    @Autowired
    private TipoDocumentoRepository tipoContribuyenteRepository;

    @Test
    public void testGuardadoEntidad() {
        TipoDocumento tipoD = new TipoDocumento(1, "Codigo", "nombre", "description", true);
        TipoDocumento tipoDSaved = tipoContribuyenteRepository.save(tipoD);
        assertNotNull(tipoDSaved);
    }
}
