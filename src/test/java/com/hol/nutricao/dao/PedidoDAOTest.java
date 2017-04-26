package com.hol.nutricao.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hol.nutricao.domain.Funcionario;
import com.hol.nutricao.domain.Paciente;
import com.hol.nutricao.domain.Pedido;

public class PedidoDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		Long codigoFun = 1L;
		Long codigoPac = 1L;
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigoFun);
		
		PacienteDAO pacienteDAO = new PacienteDAO();
		Paciente paciente = pacienteDAO.buscar(codigoPac);
		
		Pedido pedido = new Pedido();
		pedido.setHorario(new Date());
		pedido.setFuncionario(funcionario);
		pedido.setPaciente(paciente);
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		pedidoDAO.salvar(pedido);
		
		
	}
	
	@Test
	@Ignore
	public void listar(){
		PedidoDAO pedidoDAO = new PedidoDAO();
		List<Pedido> resultado = pedidoDAO.listar();
		for(Pedido pedido : resultado){
			System.out.println(pedido);
			
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.buscar(codigo);
		System.out.println(pedido);
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 2L;
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.buscar(codigo);
		pedidoDAO.excluir(pedido);
		
	}
	
	@Test	
	public void editar(){
		Long codigo = 1L;
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.buscar(codigo);
		
		pedido.setHorario(new Date());
		
		pedidoDAO.editar(pedido);
		
	}

}
