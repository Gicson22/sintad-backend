package com.challenge.sintad;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.challenge.sintad.model.TipoContribuyente;
import com.challenge.sintad.repository.TipoContribuyenteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TipoContribuyenteTests {

    @Autowired
    private TipoContribuyenteRepository  tipoContribuyenteRepository;

    @Test
    public void testGuardadoEntidad() {
        TipoContribuyente tipoC = new TipoContribuyente(1, "3213", true);
        TipoContribuyente tipoCSaved = tipoContribuyenteRepository.save(tipoC);
        assertNotNull(tipoCSaved);
    }
}
