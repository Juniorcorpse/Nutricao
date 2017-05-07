package com.hol.nutricao.bean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import com.hol.nutricao.dao.UsuarioDAO;
import com.hol.nutricao.domain.Pessoa;
import com.hol.nutricao.domain.Usuario;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {
	private Usuario usuario;
	private Usuario usuarioLogado;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
		usuario.setPessoa(new Pessoa());
	}

	public void autenticar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioLogado = usuarioDAO.autenticar(usuario.getPessoa().getCpf(), usuario.getSenha());
			if (usuarioLogado == null) {
				Messages.addGlobalError("CPF OU SENHA incorretos");
				return;
			}
			Faces.redirect("./pages/index.xhtml");
		} catch (IOException erro) {
			erro.printStackTrace();
			Messages.addGlobalError(erro.getMessage());
		}
	}
	
//	public void deslogar() {
//		HttpSession autentica = Faces.getSession();
//		  autentica.invalidate();
//		  Faces.navigate("/pages/autenticacao.xhtml");// <--- navegar para sua tela de login 
//		
//	}

}
