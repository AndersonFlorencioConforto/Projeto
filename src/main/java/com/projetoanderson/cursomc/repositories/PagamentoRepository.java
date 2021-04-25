package com.projetoanderson.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projetoanderson.cursomc.model.PagamentoModel;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoModel, Integer> {

}
