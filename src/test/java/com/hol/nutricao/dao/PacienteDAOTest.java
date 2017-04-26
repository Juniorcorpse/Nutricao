package com.hol.nutricao.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hol.nutricao.domain.Enfermaria;
import com.hol.nutricao.domain.Paciente;
import com.hol.nutricao.domain.Pessoa;

public class PacienteDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		EnfermariaDAO enfermariaDAO = new EnfermariaDAO();
		Enfermaria enfermaria = enfermariaDAO.buscar(1L);
		
		
		Paciente paciente = new Paciente();
		// cliente.setDataCadastro(new Date());
		paciente.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy")
				.parse("09/04/2016"));
		
		paciente.setDataNacimento(new SimpleDateFormat("dd/MM/yyyy")
				.parse("09/04/1969"));
		
	
		paciente.setInternado(true);
		paciente.setAcompanhate(true);
		paciente.setPessoa(pessoa);
		paciente.setEnfermaria(enfermaria);
		paciente.setLeito("201-a");

		PacienteDAO pacienteDAO = new PacienteDAO();
		pacienteDAO.salvar(paciente);
	}

	@Test
	
	public void listar() {
		PacienteDAO pacienteDAO = new PacienteDAO();
		List<Paciente> resultado = pacienteDAO.listar();
		for (Paciente paciente : resultado) {
			System.out.println(paciente);
		}

	}
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		PacienteDAO pacienteDAO = new PacienteDAO();
		Paciente paciente = pacienteDAO.buscar(codigo);
		System.out.println(paciente);
		
	}
	// não usar esse metodo 
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		PacienteDAO pacienteDAO = new PacienteDAO();
		Paciente paciente = pacienteDAO.buscar(codigo);
		pacienteDAO.excluir(paciente);
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 2L;
		Long coditoPess = 3L;
		Long codigoEnfermaria = 3L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(coditoPess);
		
		EnfermariaDAO enfermariaDAO = new EnfermariaDAO();
		Enfermaria enfermaria = enfermariaDAO.buscar(codigoEnfermaria);
		
		PacienteDAO pacienteDAO = new PacienteDAO();
		Paciente paciente = pacienteDAO.buscar(codigo);
				
		paciente.setDataAdmissao(new Date());
		paciente.setDataNacimento(new Date());
		
		paciente.setInternado(true);
		paciente.setAcompanhate(false);
		
		paciente.setPessoa(pessoa);
		
		paciente.setEnfermaria(enfermaria);
		
		paciente.setLeito("202-a");
		
		pacienteDAO.editar(paciente);
	}
		

}
