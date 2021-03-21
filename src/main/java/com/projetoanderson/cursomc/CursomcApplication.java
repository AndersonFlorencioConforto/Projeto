package com.projetoanderson.cursomc;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.projetoanderson.cursomc.model.CategoriaModel;
import com.projetoanderson.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CategoriaModel cat1 = new CategoriaModel(null,"Informática");
		CategoriaModel cat2 = new CategoriaModel(null,"Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	}

}
