package com.hol.nutricao.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Pedido extends GenericDomain{
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horario;
	
	@Column(nullable = false)
	private Short quantidadeTotal;
		
	@ManyToOne // nao estou pegando o pedido do paciente
	@JoinColumn(nullable= false)
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(nullable= false)
	private Funcionario funcionario;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pedido")
	private List<ItemPedido> itensPedido;

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}
	
	public Short getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public void setQuantidadeTotal(Short quantidadeTotal) {
		this.quantidadeTotal = quantidadeTotal;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}
	
	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	@Override
	public String toString() {
		return "Pedido [horario=" + horario + ", precoTotal=" 
				+ ", paciente=" + paciente + ", funcionario=" + funcionario + "]";
	}
	

}
