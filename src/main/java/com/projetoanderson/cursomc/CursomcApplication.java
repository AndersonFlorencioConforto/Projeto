package com.projetoanderson.cursomc;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.projetoanderson.cursomc.model.CategoriaModel;
import com.projetoanderson.cursomc.model.CidadeModel;
import com.projetoanderson.cursomc.model.ClienteModel;
import com.projetoanderson.cursomc.model.EnderecoModel;
import com.projetoanderson.cursomc.model.EstadoModel;
import com.projetoanderson.cursomc.model.ProdutoModel;
import com.projetoanderson.cursomc.model.enums.TipoCliente;
import com.projetoanderson.cursomc.repositories.CategoriaRepository;
import com.projetoanderson.cursomc.repositories.CidadeRepository;
import com.projetoanderson.cursomc.repositories.ClienteRepository;
import com.projetoanderson.cursomc.repositories.EnderecoRepository;
import com.projetoanderson.cursomc.repositories.EstadoRepository;
import com.projetoanderson.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired private ProdutoRepository produtoRepository;
	@Autowired  private EstadoRepository estadoRepository;
	@Autowired private CidadeRepository cidadeRepository;
	@Autowired private ClienteRepository clienteRepository;
	@Autowired private EnderecoRepository enderecoRepository;

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
		
		EstadoModel est1 = new EstadoModel(null,"Minas Gerais");
		EstadoModel est2 = new EstadoModel(null,"São Paulo");
		
		CidadeModel c1 = new CidadeModel(null, "Uberlândia", est1);
		CidadeModel c2 = new CidadeModel(null, "São Paulo", est2);
		CidadeModel c3 = new CidadeModel(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		ClienteModel cli1 = new ClienteModel(null,"Maria Silva", "Maria@gmail.com","36378912377",TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		EnderecoModel e1 =  new EnderecoModel(null,"Rua Flores","300","Apto 300","Jardim","38220834",cli1,c1);
		EnderecoModel e2 =  new EnderecoModel(null,"Avenida Matos","105","Sala 800","Centro","38777012",cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}

}
