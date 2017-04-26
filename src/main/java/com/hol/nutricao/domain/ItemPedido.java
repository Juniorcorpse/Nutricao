package com.hol.nutricao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class ItemPedido extends GenericDomain{
	
	@Column(nullable = false)
	private Short quantidade;
		
	@ManyToOne
	@JoinColumn(nullable = false)
	private Dieta dieta;
		
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pedido pedido;
	
	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public Dieta getDieta() {
		return dieta;
	}

	public void setDieta(Dieta dieta) {
		this.dieta = dieta;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
