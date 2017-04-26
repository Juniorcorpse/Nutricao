package com.hol.nutricao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Dieta extends GenericDomain {

	@Column(length = 4)
	private String codigodiet;
	
	@Column(length = 30, nullable = false)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigodiet() {
		return codigodiet;
	}

	public void setCodigodiet(String codigodiet) {
		this.codigodiet = codigodiet;
	}
	
	
}
