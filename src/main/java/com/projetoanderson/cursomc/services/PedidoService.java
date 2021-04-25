package com.projetoanderson.cursomc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetoanderson.cursomc.model.PedidoModel;
import com.projetoanderson.cursomc.repositories.PedidoRepository;
import com.projetoanderson.cursomc.services.exception.ObjectNotFoundExecption;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public PedidoModel buscar(Integer id) {
		Optional<PedidoModel> obj = repository.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundExecption("Objeto não encontrado! Id: " + id + ", Tipo: " + PedidoModel.class.getName())); 

	}
}
