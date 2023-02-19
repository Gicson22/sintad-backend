package com.challenge.sintad.repository;

import com.challenge.sintad.model.Entidad;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("entidad")
@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Integer> {
}
