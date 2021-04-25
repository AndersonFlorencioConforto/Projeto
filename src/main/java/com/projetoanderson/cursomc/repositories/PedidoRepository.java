package com.projetoanderson.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projetoanderson.cursomc.model.PedidoModel;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Integer> {

}
