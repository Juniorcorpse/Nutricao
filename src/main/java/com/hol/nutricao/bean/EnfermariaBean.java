package com.hol.nutricao.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.hol.nutricao.dao.ClinicaDAO;
import com.hol.nutricao.dao.EnfermariaDAO;
import com.hol.nutricao.domain.Clinica;
import com.hol.nutricao.domain.Enfermaria;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EnfermariaBean implements Serializable {
	private Enfermaria enfermaria;
	private List<Enfermaria> enfermarias;
	private List<Clinica> clinicas;

	public Enfermaria getEnfermaria() {
		return enfermaria;
	}

	public void setEnfermaria(Enfermaria enfermaria) {
		this.enfermaria = enfermaria;
	}

	public List<Enfermaria> getEnfermarias() {
		return enfermarias;
	}

	public void setEnfermarias(List<Enfermaria> enfermarias) {
		this.enfermarias = enfermarias;
	}

	public List<Clinica> getClinicas() {
		return clinicas;
	}

	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}

	@PostConstruct
	public void listar() {
		try {
			EnfermariaDAO enfermariaDAO = new EnfermariaDAO();
			enfermarias = enfermariaDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao listar");
			erro.printStackTrace();

		}
	}

	public void novo() {
		try {			
		
		enfermaria = new Enfermaria();

		ClinicaDAO clinicaDAO = new ClinicaDAO();
		clinicas = clinicaDAO.listar("nome");
		
		
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar gerar uma nova enfermaria!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EnfermariaDAO enfermariaDAO = new EnfermariaDAO();
			enfermariaDAO.merge(enfermaria);

			enfermaria = new Enfermaria();

			ClinicaDAO clinicaDAO = new ClinicaDAO();
			clinicas = clinicaDAO.listar();

			enfermarias = enfermariaDAO.listar();

			Messages.addGlobalInfo("Enfermaria salva com sucesso");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar salvar!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			enfermaria = (Enfermaria) evento.getComponent().getAttributes()
					.get("enfermariaSelecionada");
			
			EnfermariaDAO enfermariaDAO = new EnfermariaDAO();
			enfermariaDAO.excluir(enfermaria);
			
			enfermarias = enfermariaDAO.listar();
			
			Messages.addGlobalInfo("Enfermaria removida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao excluir uma enfermaria!");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		try {
			enfermaria = (Enfermaria) evento.getComponent().getAttributes().get("enfermariaSelecionada");

			ClinicaDAO clinicaDAO = new ClinicaDAO();
			clinicas = clinicaDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar uma nova enfermaria");
			erro.printStackTrace();
		}
	}

}
