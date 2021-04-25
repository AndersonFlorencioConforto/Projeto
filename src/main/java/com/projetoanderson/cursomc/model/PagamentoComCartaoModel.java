package com.projetoanderson.cursomc.model;

import javax.persistence.Entity;

import com.projetoanderson.cursomc.model.enums.EstadoPagamento;

@Entity
public class PagamentoComCartaoModel extends PagamentoModel {
	private static final long serialVersionUID = 1L;
	private Integer numeroDeParcelas;
	
	public PagamentoComCartaoModel() {
		
	}

	public PagamentoComCartaoModel(Integer id, EstadoPagamento estado, PedidoModel pedido,Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
	
	

}
