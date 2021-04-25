package com.projetoanderson.cursomc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetoanderson.cursomc.model.ClienteModel;
import com.projetoanderson.cursomc.repositories.ClienteRepository;
import com.projetoanderson.cursomc.services.exception.ObjectNotFoundExecption;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public ClienteModel buscar(Integer id) {
		Optional<ClienteModel> obj = repository.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundExecption("Objeto não encontrado! Id: " + id + ", Tipo: " + ClienteModel.class.getName())); 

	}
}
