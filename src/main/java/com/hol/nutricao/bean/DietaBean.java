package com.hol.nutricao.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.omnifaces.util.Messages;

import com.google.gson.Gson;
import com.hol.nutricao.domain.Dieta;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DietaBean implements Serializable {
	private Dieta dieta;
	private List<Dieta> dietas;

	public Dieta getDieta() {
		return dieta;
	}

	public void setDieta(Dieta dieta) {
		this.dieta = dieta;
	}

	public List<Dieta> getDietas() {
		return dietas;
	}

	public void setDietas(List<Dieta> dietas) {
		this.dietas = dietas;
	}

	@PostConstruct
	public void listar() {
		try {
			// DietaDAO dietaDAO = new DietaDAO();
			// dietas = dietaDAO.listar();

			Client cliente = ClientBuilder.newClient();
			WebTarget caminho = cliente.target("http://localhost:8080/Nutricao/rest/dieta");
			String json = caminho.request().get(String.class);

			Gson gson = new Gson();
			Dieta[] vetor = gson.fromJson(json, Dieta[].class);

			dietas = Arrays.asList(vetor);
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar dietas!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		dieta = new Dieta();
	}

	public void salvar() {
		try {
			// DietaDAO dietaDAO = new DietaDAO();
			// dietaDAO.salvar(dieta);
			//
			// novo();
			// // atualizo a lista
			// dietas = dietaDAO.listar();

			Client cliente = ClientBuilder.newClient();
			WebTarget caminho = cliente.target("http://localhost:8080/Nutricao/rest/dieta");

			Gson gson = new Gson();

			String json = gson.toJson(dieta);

			caminho.request().post(Entity.json(json));

			dieta = new Dieta();

			json = caminho.request().get(String.class);

			Dieta[] vetor = gson.fromJson(json, Dieta[].class);

			dietas = Arrays.asList(vetor);

			Messages.addGlobalInfo("Dieta salva com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			dieta = (Dieta) evento.getComponent().getAttributes().get("dietaSelecionada");

			Client cliente = ClientBuilder.newClient();
			
			WebTarget caminho = cliente.target("http://localhost:8080/Nutricao/rest/dieta");
			WebTarget caminhoExcl = caminho.path("{codigo}").resolveTemplate("codigo", dieta.getCodigo());
			
			caminhoExcl.request().delete();
			String json = caminho.request().get(String.class);

			Gson gson = new Gson();
			Dieta[] vetor = gson.fromJson(json, Dieta[].class);

			dietas = Arrays.asList(vetor);
			// DietaDAO dietaDAO = new DietaDAO();
			// dietaDAO.excluir(dieta);
			// dietas = dietaDAO.listar();
			Messages.addGlobalInfo("Dieta removida com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao excluir uma dieta!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
		dieta = (Dieta) evento.getComponent().getAttributes().get("dietaSelecionada");
		Client cliente = ClientBuilder.newClient();
		
		WebTarget caminho = cliente.target("http://localhost:8080/Nutricao/rest/dieta");
		WebTarget caminhoEd = caminho.path("{codigo}").resolveTemplate("codigo", dieta.getCodigo());
		Gson gson = new Gson();
		
		String json = gson.toJson(dieta);
		caminhoEd.request().put(Entity.json(json));
		json = caminho.request().get(String.class);

		
		Dieta[] vetor = gson.fromJson(json, Dieta[].class);
		dietas = Arrays.asList(vetor);
//		DietaDAO dietaDAO = new DietaDAO();
//		dietas = dietaDAO.listar("descricao");
	} catch (RuntimeException erro) {
		Messages.addFlashGlobalError("Ocorreu um erro ao tentar editar uma dieta!");
		erro.printStackTrace();
	}
	}

}
