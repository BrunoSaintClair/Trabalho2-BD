package com.api.trabalho_bd.repositories.jpa;

import com.api.trabalho_bd.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    Medico findByIdMedico(long id);

}
