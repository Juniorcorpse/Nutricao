package com.hol.nutricao.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Paciente extends GenericDomain {

	// criar o campo registro pra pegar da pessoa que vai receber esse campo:
	// funcionaio, paciente

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataNacimento;

	@Column(length = 2, nullable = false)
	private int idade;

	@Column(nullable = false)
	private Boolean internado;

	@Column(nullable = false)
	private String observacao;

	@Column(nullable = false)
	private Boolean acompanhate;

	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;// chave estrangeira

	@ManyToOne
	@JoinColumn(nullable = false)
	private Enfermaria enfermaria;// chave estrangeira

	@Column(length = 19, nullable = false)
	private String registro;

	@Column(length = 5, nullable = false)
	private String leito;

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getDataNacimento() {
		return dataNacimento;
	}

	public void setDataNacimento(Date dataNacimento) {
		this.dataNacimento = dataNacimento;
	}
	
	public int getIdade() {

        Calendar nascimento= new GregorianCalendar();

        nascimento.setTime(dataNacimento);

        // Cria um objeto calendar com a data atual

        Calendar dataAtual= Calendar.getInstance();

        // Obtém a idade baseado no ano

        int idade = dataAtual.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);

        nascimento.add(Calendar.YEAR, idade);

        // se a data de hoje é antes da data de Nascimento, então diminui 1. PRECISO MUDAR PRA UMA MENSAGEM DE ERRO - JRSOUZA

        if (dataAtual.before(nascimento)) {

            idade --;

        }

        return idade ;

    }

//	public int getIdade() {
//		if (dataNacimento != null) {
//			Calendar nascimento = Calendar.getInstance();
//			Calendar dataAtual = Calendar.getInstance();
//			nascimento.setTime(dataNacimento);
//			return dataAtual.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);
//
//		}
//		return idade;
//	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	// @Transient
	//
	// public static int idade(final Date dataNacimento) {
	// return idade(LocalDateTime.ofInstant(dataNacimento.toInstant(),
	// ZoneOffset.UTC).toLocalDate());
	// }
	//
	// @Transient
	//
	//
	// public static int idade(final LocalDate dataNacimento) {
	// final LocalDate dataAtual = LocalDate.now();
	// final Period periodo = Period.between(dataNacimento, dataAtual);
	// return periodo.getYears();
	// }

	public Boolean getInternado() {
		return internado;
	}

	public void setInternado(Boolean internado) {
		this.internado = internado;
	}

	@Transient
	public String getInternadoFormatado() {
		String internadoFormatado = "De alta";
		if (internado) {
			internadoFormatado = "Sim";
		}
		return internadoFormatado;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Boolean getAcompanhate() {
		return acompanhate;
	}

	public void setAcompanhate(Boolean acompanhate) {
		this.acompanhate = acompanhate;
	}

	@Transient
	public String getAcompanhateFormatado() {
		String acompanhateFormatado = "Não";
		if (acompanhate) {
			acompanhateFormatado = "Sim";
		}
		

		return acompanhateFormatado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Enfermaria getEnfermaria() {
		return enfermaria;
	}

	public void setEnfermaria(Enfermaria enfermaria) {
		this.enfermaria = enfermaria;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getLeito() {
		return leito;
	}

	public void setLeito(String leito) {
		this.leito = leito;
	}

	@Override
	public String toString() {
		return "Paciente [dataAdmissao=" + dataAdmissao + ", internado=" + internado + ", pessoa=" + pessoa
				+ ", Enfermaira=" + enfermaria + ", Registro=" + registro + ", Observação=" + observacao + ", Leito="
				+ leito + "]";
	}

}
