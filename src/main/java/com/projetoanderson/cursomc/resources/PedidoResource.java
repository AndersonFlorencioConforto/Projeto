package com.projetoanderson.cursomc.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetoanderson.cursomc.model.PedidoModel;
import com.projetoanderson.cursomc.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	@Autowired
	private PedidoService service;
	
	/*@RequestMapping(method=RequestMethod.GET)
	public List<PedidoModel> listar() {
		PedidoModel cat1 = new PedidoModel(1,"Informática");
		PedidoModel cat2 = new PedidoModel(2,"Escritório");
		
		List<PedidoModel> lista = new ArrayList<>();
		lista.add(cat2);
		lista.add(cat1);
		return lista;
	}*/
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		PedidoModel obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}


}
