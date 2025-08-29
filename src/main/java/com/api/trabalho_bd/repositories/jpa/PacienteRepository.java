package com.api.trabalho_bd.repositories.jpa;

import com.api.trabalho_bd.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Paciente findByIdPaciente(long id);
}
