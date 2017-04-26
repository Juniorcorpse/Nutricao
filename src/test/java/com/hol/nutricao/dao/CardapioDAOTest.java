package com.hol.nutricao.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hol.nutricao.domain.Cardapio;

public class CardapioDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Cardapio cardapio = new Cardapio();
		cardapio.setDescricao("Lanche");
		cardapio.setQuantidade(new Short("2"));

		CardapioDAO cardapioDAO = new CardapioDAO();
		cardapioDAO.salvar(cardapio);

	}

	@Test

	public void listar() {
		CardapioDAO cardapioDAO = new CardapioDAO();
		List<Cardapio> resultado = cardapioDAO.listar();
		for (Cardapio cardapio : resultado) {
			System.out.println("Cardapio: " + cardapio.getDescricao());

		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		CardapioDAO cardapioDAO = new CardapioDAO();
		Cardapio cardapio = cardapioDAO.buscar(codigo);

		System.out.println("Produto: " + cardapio.getDescricao());

	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 4L;
		CardapioDAO cardapioDAO = new CardapioDAO();
		Cardapio cardapio = cardapioDAO.buscar(codigo);
		cardapioDAO.excluir(cardapio);
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 2L;

		CardapioDAO cardapioDAO = new CardapioDAO();
		Cardapio cardapio = cardapioDAO.buscar(codigo);
		cardapio.setDescricao("editando");

		cardapio.setQuantidade(new Short("2"));

		cardapioDAO.salvar(cardapio);

	}

}
