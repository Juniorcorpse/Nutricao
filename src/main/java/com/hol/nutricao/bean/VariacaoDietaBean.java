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
import com.hol.nutricao.domain.VariacaoDieta;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VariacaoDietaBean implements Serializable {
	private VariacaoDieta variacao;
	private List<VariacaoDieta> variacoes;

	public VariacaoDieta getVariacao() {
		return variacao;
	}

	public void setVariacao(VariacaoDieta variacao) {
		this.variacao = variacao;
	}

	public List<VariacaoDieta> getVariacoes() {
		return variacoes;
	}

	public void setVariacoes(List<VariacaoDieta> variacoes) {
		this.variacoes = variacoes;
	}

	@PostConstruct
	public void listar() {
		try {
			// DietaDAO dietaDAO = new DietaDAO();
			// dietas = dietaDAO.listar();

			Client cliente = ClientBuilder.newClient();
			WebTarget caminho = cliente.target("http://localhost:8080/Nutricao/rest/variacao");
			String json = caminho.request().get(String.class);

			Gson gson = new Gson();
			VariacaoDieta[] vetor = gson.fromJson(json, VariacaoDieta[].class);

			variacoes = Arrays.asList(vetor);
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar variações das dietas!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		variacao = new VariacaoDieta();
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
			WebTarget caminho = cliente.target("http://localhost:8080/Nutricao/rest/variacao");

			Gson gson = new Gson();

			String json = gson.toJson(variacao);

			caminho.request().post(Entity.json(json));

			variacao = new VariacaoDieta();

			json = caminho.request().get(String.class);

			VariacaoDieta[] vetor = gson.fromJson(json, VariacaoDieta[].class);

			variacoes = Arrays.asList(vetor);

			Messages.addGlobalInfo("Variação de dieta salva com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar variação de dieta!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			variacao = (VariacaoDieta) evento.getComponent().getAttributes().get("variacaoDietaSelecionada");

			Client cliente = ClientBuilder.newClient();

			WebTarget caminho = cliente.target("http://localhost:8080/Nutricao/rest/variacao");
			WebTarget caminhoExcl = caminho.path("{codigo}").resolveTemplate("codigo", variacao.getCodigo());

			caminhoExcl.request().delete();
			String json = caminho.request().get(String.class);

			Gson gson = new Gson();
			VariacaoDieta[] vetor = gson.fromJson(json, VariacaoDieta[].class);

			variacoes = Arrays.asList(vetor);
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
			variacao = (VariacaoDieta) evento.getComponent().getAttributes().get("variacaoDietaSelecionada");
			Client cliente = ClientBuilder.newClient();

			WebTarget caminho = cliente.target("http://localhost:8080/Nutricao/rest/variacao");
			WebTarget caminhoEd = caminho.path("{codigo}").resolveTemplate("codigo", variacao.getCodigo());
			Gson gson = new Gson();

			String json = gson.toJson(variacao);
			caminhoEd.request().put(Entity.json(json));
			json = caminho.request().get(String.class);

			VariacaoDieta[] vetor = gson.fromJson(json, VariacaoDieta[].class);
			variacoes = Arrays.asList(vetor);
			// DietaDAO dietaDAO = new DietaDAO();
			// dietas = dietaDAO.listar("descricao");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar editar uma dieta!");
			erro.printStackTrace();
		}
	}

}
