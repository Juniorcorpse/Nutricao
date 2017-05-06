package com.hol.nutricao.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hol.nutricao.domain.Dieta;
import com.hol.nutricao.domain.ItemPedido;
import com.hol.nutricao.domain.Pedido;

public class ItemPedidoDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		Long codigoPed = 1L;
//		Long codigoCard = 2L;
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.buscar(codigoPed);
		
//		CardapioDAO cardapioDAO = new CardapioDAO();
//		Cardapio cardapio = cardapioDAO.buscar(codigoCard);
		
		ItemPedido itemPedido = new ItemPedido();
		//itemPedido.setCardapio(cardapio);
		itemPedido.setPedido(pedido);
		
		
		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
		itemPedidoDAO.salvar(itemPedido);
	}
	
	@Test
	@Ignore
	public void listar(){
		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
		List<ItemPedido> resultado = itemPedidoDAO.listar();
		for(ItemPedido itemPedido : resultado){
			System.out.println(itemPedido);
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
		ItemPedido itemPedido = itemPedidoDAO.buscar(codigo);
		System.out.println(itemPedido);
		
	}
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 2L;
		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
		ItemPedido itemPedido = itemPedidoDAO.buscar(codigo);
		itemPedidoDAO.excluir(itemPedido);
	}
	
	@Test	
	public void editar(){
		
		Long codigo = 1L;
		Long codigoDieta = 2L;
		
		DietaDAO dietaDAO = new DietaDAO();
		Dieta dieta = dietaDAO.buscar(codigoDieta);
		
		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
		ItemPedido itemPedido = itemPedidoDAO.buscar(codigo);
		itemPedido.setDieta(dieta);
		
		itemPedidoDAO.editar(itemPedido);
	}

}
