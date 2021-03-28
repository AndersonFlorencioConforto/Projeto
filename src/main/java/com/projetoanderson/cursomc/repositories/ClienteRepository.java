package com.projetoanderson.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoanderson.cursomc.model.ClienteModel;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

}
