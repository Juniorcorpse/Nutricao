package com.hol.nutricao.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hol.nutricao.domain.VariacaoDieta;

public class VariacaoDietaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		VariacaoDieta variacao = new VariacaoDieta();
		variacao.setDescricao("Hipossódica");
		variacao.setCodigodiet("4");

		VariacaoDietaDAO variacaoDAO = new VariacaoDietaDAO();
		variacaoDAO.salvar(variacao);
	}

	@Test
	@Ignore
	public void listar() {
		VariacaoDietaDAO variacaoDAO = new VariacaoDietaDAO();
		List<VariacaoDieta> resultado = variacaoDAO.listar();
		for (VariacaoDieta variacao : resultado) {
			System.out.println(variacao.getDescricao());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 5L;

		VariacaoDietaDAO variacaoDAO = new VariacaoDietaDAO();
		VariacaoDieta variacao = variacaoDAO.buscar(codigo);
		if (variacao == null) {
			System.out.println("Registro não encontrado");
		} else {
			System.out.println("Codigo: " + variacao.getCodigo()
					+ "\nVariação da Dienta: " + variacao.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 4L;
		VariacaoDietaDAO variacaoDAO = new VariacaoDietaDAO();
		VariacaoDieta variacao = variacaoDAO.buscar(codigo);
		if (variacao == null) {
			System.out.println("Registro não encontrado");
		} else {
			variacaoDAO.excluir(variacao);
		}
	}
	
	@Test

	public void editar(){
		Long codigo = 11L;
		VariacaoDietaDAO variacaoDAO = new VariacaoDietaDAO();
		VariacaoDieta variacao = variacaoDAO.buscar(codigo);
		if (variacao == null) {
			System.out.println("Registro não encontrado");
		} else {
			variacao.setDescricao("testando1");
			variacaoDAO.editar(variacao);
		}
	}
	@Test
	@Ignore
	public void merge() {
		//salvar
		//Dieta dieta = new Dieta();
		//dieta.setDescricao("Dieta A");
		//DietaDAO dietaDAO = new DietaDAO();
		//dietaDAO.merge(dieta);
		
		//editar
		VariacaoDietaDAO variacaoDAO = new VariacaoDietaDAO();
		VariacaoDieta variacao = variacaoDAO.buscar(3L);
		variacao.setDescricao("Dieta B");
		variacaoDAO.merge(variacao);
	}

}
