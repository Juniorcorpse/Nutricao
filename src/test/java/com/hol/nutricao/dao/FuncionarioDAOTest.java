package com.hol.nutricao.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hol.nutricao.domain.Funcionario;
import com.hol.nutricao.domain.Pessoa;

public class FuncionarioDAOTest {
	// todos os metodos testados
	@Test
	@Ignore
	public void salvar(){// verificar esta metodo, pois esta salvando funcionarios diferentes pra mesma pessa (esta permitindo)
		Long codigo = 5L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setDataAdmissao(new Date());
		funcionario.setRegistro("89244-0");
		funcionario.setPessoa(pessoa);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.salvar(funcionario);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> resultado = funcionarioDAO.listar();
		for(Funcionario funcionario : resultado){
			System.out.println(funcionario.getDataAdmissao()+"");
			System.out.println(funcionario.getRegistro()+"");
			System.out.println(funcionario.getPessoa()+"");
			System.out.println("*------*------*");
		}
		
		
		
	}
	@Test
	
	public void buscar() {
		// verificar
		Long codigo = 1L;
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);
		System.out.println(funcionario);
		
	}

	@Test
	@Ignore
	public void excluir(){
		Long codigo = 2L;
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);
		funcionarioDAO.excluir(funcionario);
		System.out.println(funcionario);
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 1L;
		Long codigoPess = 4L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPess);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);
		
		funcionario.setDataAdmissao(new Date());
		funcionario.setRegistro("89255-5");
		funcionario.setPessoa(pessoa);
		
		funcionarioDAO.editar(funcionario);
	}
}
