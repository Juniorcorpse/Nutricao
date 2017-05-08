package com.hol.nutricao.dao;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;

import com.hol.nutricao.domain.Pessoa;
import com.hol.nutricao.domain.Usuario;

public class UsuarioDAOTest {
	//todos os metodos testados
	@Test
	
	public void salvar(){
		Long codigo = 4L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getCpf());
		
		
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setPessoa(pessoa);
		usuario.setSenhaSemCripritografia("123456");
		
		SimpleHash hash = new SimpleHash("md5", usuario.getSenhaSemCripritografia());
		usuario.setSenha(hash.toHex());
		
		usuario.setTipo('G');
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
	}
	
	@Test
	@Ignore
	public void autenticar(){
		String cpf = "454.654.656-76";
		String senha = "1234";
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.autenticar(cpf, senha);
		
		System.out.println("Usuario autenticado" + usuario);
	}
	
	@Test
	@Ignore
	public void listar(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();
		for(Usuario usuario : resultado){
			System.out.println(usuario);
		}
		
	}
	
	@Test
	@Ignore 		
	public void buscar(){
		Long codigo = 1L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);
		System.out.println(usuario);
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);
		usuarioDAO.excluir(usuario);

	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 1L;
		Long codigoPess = 3L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPess);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);
		
		usuario.setAtivo(true);
		usuario.setTipo('A');
		usuario.setPessoa(pessoa);
		
		usuarioDAO.editar(usuario);
	}
		


}
