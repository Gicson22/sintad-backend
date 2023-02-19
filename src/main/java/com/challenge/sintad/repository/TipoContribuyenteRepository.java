package com.challenge.sintad.repository;

import com.challenge.sintad.model.TipoContribuyente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("tipo_contribuyente")
@Repository
public interface TipoContribuyenteRepository extends JpaRepository<TipoContribuyente, Integer> {
}
