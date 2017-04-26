package com.hol.nutricao.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hol.nutricao.domain.Dieta;

public class DietaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Dieta dieta = new Dieta();
		dieta.setDescricao("geral");
		dieta.setCodigodiet("4ª");

		DietaDAO dietaDAO = new DietaDAO();
		dietaDAO.salvar(dieta);
	}

	@Test
	@Ignore
	public void listar() {
		DietaDAO dietaDAO = new DietaDAO();
		List<Dieta> resultado = dietaDAO.listar();
		for (Dieta dieta : resultado) {
			System.out.println(dieta.getDescricao());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 5L;

		DietaDAO dietaDAO = new DietaDAO();
		Dieta dieta = dietaDAO.buscar(codigo);
		if (dieta == null) {
			System.out.println("Registro não encontrado");
		} else {
			System.out.println("Codigo: " + dieta.getCodigo()
					+ "\nDienta: " + dieta.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 4L;
		DietaDAO dietaDAO = new DietaDAO();
		Dieta dieta = dietaDAO.buscar(codigo);
		if (dieta == null) {
			System.out.println("Registro não encontrado");
		} else {
			dietaDAO.excluir(dieta);
		}
	}
	
	@Test

	public void editar(){
		Long codigo = 11L;
		DietaDAO dietaDAO = new DietaDAO();
		Dieta dieta = dietaDAO.buscar(codigo);
		if (dieta == null) {
			System.out.println("Registro não encontrado");
		} else {
			dieta.setDescricao("testando1");
			dietaDAO.editar(dieta);
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
		DietaDAO dietaDAO = new DietaDAO();
		Dieta dieta = dietaDAO.buscar(3L);
		dieta.setDescricao("Dieta B");
		dietaDAO.merge(dieta);
	}

}
