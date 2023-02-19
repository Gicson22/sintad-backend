package com.challenge.sintad.repository;

import com.challenge.sintad.model.TipoDocumento;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("tipo_documento")
@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
}
