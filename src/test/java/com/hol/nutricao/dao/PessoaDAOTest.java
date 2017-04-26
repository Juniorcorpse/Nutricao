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
		pessoa.setNome("testexcluir");
		pessoa.setCpf("123.030.103.30");
		
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
		Long codigo = 4L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		
		pessoa.setNome("fulanoeditado");
				
		pessoaDAO.editar(pessoa);
	}

}
