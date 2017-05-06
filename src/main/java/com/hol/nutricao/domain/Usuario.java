package com.hol.nutricao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain {

	@Column(length = 32, nullable = false)//usando md5 de tamanho 32
	private String senha;
	
	@Transient
	private String senhaSemCripritografia;

	@Column(nullable = false)
	private Character tipo;

	@Column(nullable = false)
	private Boolean ativo;

	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public String getSenhaSemCripritografia() {
		return senhaSemCripritografia;
	}

	public void setSenhaSemCripritografia(String senhaSemCripritografia) {
		this.senhaSemCripritografia = senhaSemCripritografia;
	}

	public Character getTipo() {
		return tipo;
	}
	
	@Transient // pra informar pro hibernate que nao é uma campo fisico do banco 
	public String getTipoFormatado(){
		String tipoFormatado = null;
		if(tipo == 'A'){
			tipoFormatado = "Administrador";
		}else if(tipo == 'G'){
			tipoFormatado = "Administrativo";
		}else if(tipo == 'N'){
			tipoFormatado = "Nutricionista";
		}
		return tipoFormatado;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public Boolean getAtivo() {
		return ativo;
	}
	
	@Transient
	public String getAtivoFormatado(){
		String ativoFormatado = "Não";
		if(ativo){
			ativoFormatado = "Sim";
		}
		return ativoFormatado;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Usuario [senha=" + senha + ", tipo=" + tipo + ", ativo="
				+ ativo + ", pessoa=" + pessoa + "]";
	}

}
