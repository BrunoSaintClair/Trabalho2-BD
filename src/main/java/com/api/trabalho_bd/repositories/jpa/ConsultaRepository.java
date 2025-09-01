package com.api.trabalho_bd.repositories.jpa;

import com.api.trabalho_bd.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
}
