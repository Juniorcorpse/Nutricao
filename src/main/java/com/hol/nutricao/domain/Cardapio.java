package com.hol.nutricao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Cardapio extends GenericDomain {
	@Column(length = 80, nullable = false)
	private String descricao;

	@Column(nullable = false)
	private Short quantidade;

	@Transient
	private String caminho;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

}
