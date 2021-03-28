package com.projetoanderson.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projetoanderson.cursomc.model.CidadeModel;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeModel, Integer> {

}
