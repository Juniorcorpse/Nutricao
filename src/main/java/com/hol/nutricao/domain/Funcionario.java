package com.hol.nutricao.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Funcionario extends GenericDomain {
	
	@Column(length = 19, nullable = false)
	private String registro;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Funcionario [registro=" + registro + ", dataAdmissao=" + dataAdmissao + ", pessoa=" + pessoa + "]";
	}

	
}
