package com.projetoanderson.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetoanderson.cursomc.model.CategoriaModel;
import com.projetoanderson.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	@Autowired
	private CategoriaService service;
	
	/*@RequestMapping(method=RequestMethod.GET)
	public List<CategoriaModel> listar() {
		CategoriaModel cat1 = new CategoriaModel(1,"Informática");
		CategoriaModel cat2 = new CategoriaModel(2,"Escritório");
		
		List<CategoriaModel> lista = new ArrayList<>();
		lista.add(cat2);
		lista.add(cat1);
		return lista;
	}*/
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		CategoriaModel obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}


}
