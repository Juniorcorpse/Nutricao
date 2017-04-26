package com.hol.nutricao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Enfermaria extends GenericDomain {
	@Column(length = 4, nullable = false)
	private String numero;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Clinica clinica;//chave estrangeira 

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}
	
	

}
