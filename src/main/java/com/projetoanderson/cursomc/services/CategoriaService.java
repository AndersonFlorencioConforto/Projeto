package com.projetoanderson.cursomc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetoanderson.cursomc.model.CategoriaModel;
import com.projetoanderson.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public CategoriaModel buscar(Integer id) {
		Optional<CategoriaModel> obj = repository.findById(id); 
		return obj.orElse(null); 

	}
}
