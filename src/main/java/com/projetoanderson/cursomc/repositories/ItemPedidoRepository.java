package com.projetoanderson.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projetoanderson.cursomc.model.ItemPedidoModel;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedidoModel, Integer> {

}
