package com.projetoanderson.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetoanderson.cursomc.model.ClienteModel;
import com.projetoanderson.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	@Autowired
	private ClienteService service;
	
	/*@RequestMapping(method=RequestMethod.GET)
	public List<ClienteModel> listar() {
		ClienteModel cat1 = new ClienteModel(1,"Informática");
		ClienteModel cat2 = new ClienteModel(2,"Escritório");
		
		List<ClienteModel> lista = new ArrayList<>();
		lista.add(cat2);
		lista.add(cat1);
		return lista;
	}*/
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		ClienteModel obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}


}
