package com.projetoanderson.cursomc;

import java.text.SimpleDateFormat;
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
import com.projetoanderson.cursomc.model.ItemPedidoModel;
import com.projetoanderson.cursomc.model.PagamentoComBoletoModel;
import com.projetoanderson.cursomc.model.PagamentoComCartaoModel;
import com.projetoanderson.cursomc.model.PagamentoModel;
import com.projetoanderson.cursomc.model.PedidoModel;
import com.projetoanderson.cursomc.model.ProdutoModel;
import com.projetoanderson.cursomc.model.enums.EstadoPagamento;
import com.projetoanderson.cursomc.model.enums.TipoCliente;
import com.projetoanderson.cursomc.repositories.CategoriaRepository;
import com.projetoanderson.cursomc.repositories.CidadeRepository;
import com.projetoanderson.cursomc.repositories.ClienteRepository;
import com.projetoanderson.cursomc.repositories.EnderecoRepository;
import com.projetoanderson.cursomc.repositories.EstadoRepository;
import com.projetoanderson.cursomc.repositories.ItemPedidoRepository;
import com.projetoanderson.cursomc.repositories.PagamentoRepository;
import com.projetoanderson.cursomc.repositories.PedidoRepository;
import com.projetoanderson.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired private ProdutoRepository produtoRepository;
	@Autowired private EstadoRepository estadoRepository;
	@Autowired private CidadeRepository cidadeRepository;
	@Autowired private ClienteRepository clienteRepository;
	@Autowired private EnderecoRepository enderecoRepository;
	@Autowired private PedidoRepository pedidoRepository;
	@Autowired private PagamentoRepository pagamentoRepository;
	@Autowired private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CategoriaModel cat1 = new CategoriaModel(null,"Inform??tica");
		CategoriaModel cat2 = new CategoriaModel(null,"Escrit??rio");
		
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
		EstadoModel est2 = new EstadoModel(null,"S??o Paulo");
		
		CidadeModel c1 = new CidadeModel(null, "Uberl??ndia", est1);
		CidadeModel c2 = new CidadeModel(null, "S??o Paulo", est2);
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		PedidoModel ped1 = new PedidoModel(null,sdf.parse("22/05/1998 12:00"),cli1,e1);
		PedidoModel ped2 = new PedidoModel(null,sdf.parse("14/09/1993 12:00"),cli1,e2);
		
		PagamentoModel pagto1 = new PagamentoComCartaoModel(null,EstadoPagamento.QUITADO,ped1,6);
		ped1.setPagamento(pagto1);
		
		PagamentoModel pagto2 = new PagamentoComBoletoModel(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("22/05/1998 12:00"),null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		
		ItemPedidoModel ip1 = new ItemPedidoModel(ped1,p1,0.00,1,2000.00);
		ItemPedidoModel ip2 = new ItemPedidoModel(ped1,p3,0.00,2,80.00);
		ItemPedidoModel ip3 = new ItemPedidoModel(ped2,p2,100.00,1,800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
		
		
		
		
	}

}
