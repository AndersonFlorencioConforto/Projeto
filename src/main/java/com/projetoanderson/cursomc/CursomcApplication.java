package com.projetoanderson.cursomc;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.projetoanderson.cursomc.model.CategoriaModel;
import com.projetoanderson.cursomc.model.ProdutoModel;
import com.projetoanderson.cursomc.repositories.CategoriaRepository;
import com.projetoanderson.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CategoriaModel cat1 = new CategoriaModel(null,"Informática");
		CategoriaModel cat2 = new CategoriaModel(null,"Escritório");
		
		ProdutoModel p1 = new ProdutoModel(null,"Computador",2000.00);
		ProdutoModel p2 = new ProdutoModel(null,"Impressora",800.00);
		ProdutoModel p3 = new ProdutoModel(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}
