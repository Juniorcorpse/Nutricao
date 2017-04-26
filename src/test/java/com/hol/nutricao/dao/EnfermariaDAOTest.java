package com.hol.nutricao.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hol.nutricao.domain.Clinica;
import com.hol.nutricao.domain.Enfermaria;

public class EnfermariaDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		Long codeclinica = 2L; 
		ClinicaDAO clinicaDAO = new ClinicaDAO();
		Clinica clinica = clinicaDAO.buscar(codeclinica);
		
		Enfermaria enfermaria = new Enfermaria();
		enfermaria.setNumero("200");
		enfermaria.setClinica(clinica);
		
		EnfermariaDAO enfermariaDAO = new EnfermariaDAO();
		enfermariaDAO.salvar(enfermaria);
	}
	
	@Test
	@Ignore
	public void listar(){
		EnfermariaDAO enfermariaDAO = new EnfermariaDAO();
		List<Enfermaria> resultado = enfermariaDAO.listar();
		for(Enfermaria enfermaria : resultado){
			System.out.println("Enfermaria: "+enfermaria.getNumero());
			System.out.println("Clinica: "+enfermaria.getClinica().getNome());
			System.out.println("---------------------------");
		}
				
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 3L;
		EnfermariaDAO enfermariaDAO = new EnfermariaDAO();
		Enfermaria enfermaria = enfermariaDAO.buscar(codigo);
		System.out.println("Enfermaria: "+enfermaria.getNumero());
		System.out.println("Clinica: "+enfermaria.getClinica().getNome());
		System.out.println("---------------------------");
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 4L;
		EnfermariaDAO enfermariaDAO = new EnfermariaDAO();
		Enfermaria enfermaria = enfermariaDAO.buscar(codigo);
		enfermariaDAO.excluir(enfermaria);
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 3L;
		Long codeclinica = 2L;
		
		ClinicaDAO clinicaDAO = new ClinicaDAO();
		Clinica clinica = clinicaDAO.buscar(codeclinica);
		
		EnfermariaDAO enfermariaDAO = new EnfermariaDAO();
		Enfermaria enfermaria = enfermariaDAO.buscar(codigo);
		System.out.println("Enfermaria: "+enfermaria.getNumero());
		
		enfermaria.setNumero("30-a");
		
		enfermaria.setClinica(clinica);
		
		enfermariaDAO.editar(enfermaria);
		
		System.out.println("Enfermaria: "+enfermaria.getNumero());
		
	}
	// falta testar###
	// listar as enfermaria da clinica selecionada
	@Test
	
		public void buscarPorClinica(){
		Long clinicaCodigo = 2L;
		EnfermariaDAO enfermariaDAO = new EnfermariaDAO();
		List<Enfermaria> resultado = enfermariaDAO.buscarPorClinica(clinicaCodigo);
		for(Enfermaria enfermaria : resultado){
			System.out.println("Enfermaria: "+ enfermaria.getNumero());
			System.out.println("Clinica: "+enfermaria.getClinica().getNome());
			System.out.println("---------------------------");
		}
				
	}

}
