package com.hol.nutricao.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.hol.nutricao.dao.ClinicaDAO;
import com.hol.nutricao.dao.EnfermariaDAO;
import com.hol.nutricao.dao.PacienteDAO;
import com.hol.nutricao.dao.PessoaDAO;
import com.hol.nutricao.domain.Clinica;
import com.hol.nutricao.domain.Enfermaria;
import com.hol.nutricao.domain.Paciente;
import com.hol.nutricao.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PacienteBean implements Serializable {
	private Paciente paciente;
	private List<Paciente> pacientes;	
	private List<Pessoa> pessoas;
	private Clinica clinica;// variavel temporaria
	private List<Clinica> clinicas;
	private List<Enfermaria> enfermarias;
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public List<Clinica> getClinicas() {
		return clinicas;
	}

	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}

	
	public List<Enfermaria> getEnfermarias() {
		return enfermarias;
	}

	public void setEnfermarias(List<Enfermaria> enfermarias) {
		this.enfermarias = enfermarias;
	}

	@PostConstruct
	public void listar() {
		try {
			PacienteDAO pacienteDAO = new PacienteDAO();
			pacientes = pacienteDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao listar");
			erro.printStackTrace();

		}
	}
	
	public void novo(){
		try{
		paciente = new Paciente();
		clinica = new Clinica();
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoas = pessoaDAO.listar("nome");
		
		ClinicaDAO clinicaDAO = new ClinicaDAO();
		clinicas = clinicaDAO.listar("nome");

		enfermarias = new ArrayList<Enfermaria>();
		
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar criar um novo cliente");
			erro.printStackTrace();

		}
		
			
		
	}
	public void salvar(){
		try{
			PacienteDAO pacienteDAO = new PacienteDAO();
			pacienteDAO.merge(paciente);
		
			paciente = new Paciente();		
			pacientes = pacienteDAO.listar("registro");
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");
			
			clinica = new Clinica();

			ClinicaDAO clinicaDAO = new ClinicaDAO();
			clinicas = clinicaDAO.listar("nome");

			enfermarias = new ArrayList<>();//<Enfermaria>
			
			Messages.addGlobalInfo("Paciente salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar criar um novo paciente");
			erro.printStackTrace();

		}
	}
	
	public void excluir(ActionEvent evento){
		try{
		paciente = (Paciente) evento.getComponent().getAttributes().get("pacienteSelecionado");
		
		PacienteDAO pacienteDAO = new PacienteDAO();
		pacienteDAO.excluir(paciente);
		
		pacientes = pacienteDAO.listar("registro");
		
		Messages.addGlobalInfo("Paciente excluido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar excluir um paciente");
			erro.printStackTrace();

		}
	}
	
	public void editar(ActionEvent evento){
		try {
			paciente = (Paciente) evento.getComponent().getAttributes().get("pacienteSelecionado");
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");
			
			clinica = paciente.getEnfermaria().getClinica();
			
			ClinicaDAO clinicaDAO = new ClinicaDAO();
			clinicas = clinicaDAO.listar("nome");

			EnfermariaDAO enfermariaDAO = new EnfermariaDAO();
			enfermarias = enfermariaDAO.buscarPorClinica(clinica.getCodigo());	
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar editar um paciente");
			erro.printStackTrace();

		}
	}
	
	public void popular() {
		try {
		if(clinica != null){
			EnfermariaDAO enfermariaDAO = new EnfermariaDAO();
			enfermarias = enfermariaDAO.buscarPorClinica(clinica.getCodigo());
		}else{
			enfermarias = new ArrayList<>();
		}
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar filtrar uma enfermaria");
			erro.printStackTrace();
		}
	}
	
}
