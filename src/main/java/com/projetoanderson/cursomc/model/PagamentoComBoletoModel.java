package com.projetoanderson.cursomc.model;

import java.util.Date;

import javax.persistence.Entity;

import com.projetoanderson.cursomc.model.enums.EstadoPagamento;

@Entity
public class PagamentoComBoletoModel extends PagamentoModel{
	private static final long serialVersionUID = 1L;
	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoComBoletoModel() {
		
	}

	public PagamentoComBoletoModel(Integer id, EstadoPagamento estado, PedidoModel pedido,Date dataVencimento,Date dataPagamento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
	
	
	
	
}
