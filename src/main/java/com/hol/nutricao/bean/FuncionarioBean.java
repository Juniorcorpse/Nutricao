package com.hol.nutricao.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.hol.nutricao.dao.FuncionarioDAO;
import com.hol.nutricao.dao.PessoaDAO;
import com.hol.nutricao.domain.Funcionario;
import com.hol.nutricao.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable {
	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private List<Pessoa> pessoas;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	@PostConstruct
	private void listar() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarios = funcionarioDAO.listar("dataAdmissao");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar listar funcionários");

		}
	}

	public void novo() {
		try {
			funcionario = new Funcionario();
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar criar um novo Funcionário");
			erro.printStackTrace();

		}
	}

	public void salvar() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.merge(funcionario);

			funcionario = new Funcionario();
			funcionarios = funcionarioDAO.listar("dataAdmissao");

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");

			Messages.addGlobalInfo("Funcionário salvo com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar criar um novo Funcionário");
			erro.printStackTrace();

		}
	}

	public void excluir(ActionEvent evento) {
		try {
			
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcionarioSelecionado");
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.excluir(funcionario);
			
			funcionarios = funcionarioDAO.listar("dataAdmissao");

			Messages.addGlobalInfo("Funcionário excluido com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar exluir um Funcionário");
			erro.printStackTrace();

		}

	}
	
	public void editar(ActionEvent evento){
		try {
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcionarioSelecionado");
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar editar um Funcionário");
			erro.printStackTrace();
		}
		
	}

}
