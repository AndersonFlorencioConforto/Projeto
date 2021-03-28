package com.projetoanderson.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projetoanderson.cursomc.model.EstadoModel;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoModel, Integer> {

}
