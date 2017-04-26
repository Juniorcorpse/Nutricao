package com.hol.nutricao.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.hol.nutricao.dao.PessoaDAO;
import com.hol.nutricao.dao.UsuarioDAO;
import com.hol.nutricao.domain.Pessoa;
import com.hol.nutricao.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {
	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<Pessoa> pessoas;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar("tipo");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar listar usuários");

		}
	}

	public void novo() {
		try {
			usuario = new Usuario();
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar criar um novo Usuário");
			erro.printStackTrace();

		}
	}

	public void salvar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.merge(usuario);

			usuario = new Usuario();
			usuarios = usuarioDAO.listar("tipo");

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");

			Messages.addGlobalInfo("Usuário salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar criar um novo usuário");
			erro.printStackTrace();

		}
	}

	public void excluir(ActionEvent evento) {
		try {

			usuario = (Usuario) evento.getComponent().getAttributes()
					.get("usuarioSelecionado");

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.excluir(usuario);

			usuarios = usuarioDAO.listar("tipo");

			Messages.addGlobalInfo("Usuário excluido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar excluir um usuário");
			erro.printStackTrace();

		}
	}

	public void editar(ActionEvent evento) {
		try {
			usuario = (Usuario) evento.getComponent().getAttributes()
					.get("usuarioSelecionado");
		
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar editar um usuário");
			erro.printStackTrace();

		}
	}
}
