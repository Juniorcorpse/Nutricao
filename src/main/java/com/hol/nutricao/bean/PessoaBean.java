package com.hol.nutricao.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.hol.nutricao.dao.PessoaDAO;
import com.hol.nutricao.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	

	@PostConstruct
	public void listar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao listar");
			erro.printStackTrace();

		}
	}

	public void novo() {
		try {
			pessoa = new Pessoa();
			
			} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma nova pessoa");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.merge(pessoa);
			pessoas = pessoaDAO.listar("nome");
			pessoa = new Pessoa();

			Messages.addGlobalInfo("Pessoa salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar salvar!");
			erro.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes()
					.get("pessoaSelecionada");
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.excluir(pessoa);
			pessoas = pessoaDAO.listar();
			Messages.addGlobalInfo("Pessoa removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao excluir uma pessoa!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");
			PessoaDAO pessoaDAO = new PessoaDAO();
			
			pessoas = pessoaDAO.listar("nome");
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar um novo pessoa");
			erro.printStackTrace();
		}
	}
}
