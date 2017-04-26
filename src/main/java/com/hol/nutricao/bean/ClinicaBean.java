package com.hol.nutricao.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.hol.nutricao.dao.ClinicaDAO;
import com.hol.nutricao.domain.Clinica;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClinicaBean implements Serializable {
	private Clinica clinica;
	private List<Clinica> clinicas;

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public List<Clinica> getClinicas() {
		return clinicas;
	}

	public void setClinica(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}

	@PostConstruct
	public void listar() {
		try {
			ClinicaDAO clinicaDAO = new ClinicaDAO();
			clinicas = clinicaDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		clinica = new Clinica();
	}

	public void salvar() {
		// String texto = "Programação Java Web";
		// FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
		// texto, texto);
		// // Capituraar o cotexto do jsf
		// FacesContext contexto = FacesContext.getCurrentInstance();
		// // Adicionar a mensagem
		// contexto.addMessage(null, mensagem);
		try {
			ClinicaDAO clinicaDAO = new ClinicaDAO();
			clinicaDAO.merge(clinica);

			novo();// pra limpar os campos atualizando o form na visao
			// atualizo a lista
			clinicas = clinicaDAO.listar();
			// usando o OmniFaces
			Messages.addGlobalInfo("Estado salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			clinica = (Clinica) evento.getComponent().getAttributes()
					.get("estadoSelecionado");
			
			ClinicaDAO clinicaDAO = new ClinicaDAO();
			clinicaDAO.excluir(clinica);
			
			clinicas = clinicaDAO.listar();
			
			Messages.addGlobalInfo("Clinica removido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao excluir um clinica!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		clinica = (Clinica) evento.getComponent().getAttributes()
				.get("clinicaSelecionada");
	}

}
