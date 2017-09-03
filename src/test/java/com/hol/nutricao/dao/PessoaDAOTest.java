package com.hol.nutricao.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hol.nutricao.domain.Pessoa;

public class PessoaDAOTest {
// todos os metodos foram testados
	@Test
	@Ignore
	public void salvar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("jrsouza");
		pessoa.setCpf("12312312312");
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);
	}

	@Test
	@Ignore
	public void listar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();
		for (Pessoa pessoa : resultado) {
			System.out.println("nome: " + pessoa.getNome());
			System.out.println("nome: " + pessoa.getCpf());
			

		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		System.out.println("nome: " + pessoa.getNome());
		System.out.println("nome: " + pessoa.getCpf());
		

	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 3L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		pessoaDAO.excluir(pessoa);

	}
	
	@Test
	//@Ignore
	public void editar(){
		Long codigo = 1L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		
		pessoa.setNome("fulanoeditado");
		pessoa.setCpf("123.123.123-12");	
		pessoaDAO.editar(pessoa);
	}

}
