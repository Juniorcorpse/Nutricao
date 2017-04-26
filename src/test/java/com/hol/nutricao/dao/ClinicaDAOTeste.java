package com.hol.nutricao.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hol.nutricao.domain.Clinica;


public class ClinicaDAOTeste {

	@Test
	
	public void salvar() {
		Clinica clinica = new Clinica();
		clinica.setNome("excluir");
		ClinicaDAO clinicaDAO = new ClinicaDAO();
		clinicaDAO.salvar(clinica);
	}

	@Test
	@Ignore
	public void listar() {
		ClinicaDAO clinicaDAO = new ClinicaDAO();
		List<Clinica> resultado = clinicaDAO.listar();
		System.out.println("Total de registros encontrados: "
				+ resultado.size());
		for (Clinica clinica : resultado) {
			System.out.println(clinica.getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 4L;
		ClinicaDAO clinicaDAO = new ClinicaDAO();
		Clinica clinica = clinicaDAO.buscar(codigo);
		if (clinica == null) {
			System.out.println("Registro não encontrado");
		} else {
			System.out.println(clinica.getCodigo() + " - " + clinica.getNome());
		}

	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 4L;
		ClinicaDAO clinicaDAO = new ClinicaDAO();
		Clinica clinica = clinicaDAO.buscar(codigo);
		if (clinica == null) {
			System.out.println("Registro não encontrado");
		} else {
			clinicaDAO.excluir(clinica);
		}
		
	}
	
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 1L;
		ClinicaDAO clinicaDAO = new ClinicaDAO();
		Clinica clinica = clinicaDAO.buscar(codigo);
		//clinica.setNome("testeeditado");//teste
        //clinicaDAO.editar(clinica);
		if (clinica == null) {
			System.out.println("Registro não encontrado");
		} else {
			clinica.setNome("testeeditado");
			clinicaDAO.editar(clinica);
		}
		
	}

}
