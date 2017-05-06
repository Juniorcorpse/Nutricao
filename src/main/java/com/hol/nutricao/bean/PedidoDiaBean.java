package com.hol.nutricao.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import com.hol.nutricao.dao.ItemPedidoDAO;
import com.hol.nutricao.domain.Cardapio;
import com.hol.nutricao.domain.Dieta;
import com.hol.nutricao.domain.Funcionario;
import com.hol.nutricao.domain.ItemPedido;
import com.hol.nutricao.domain.Paciente;
import com.hol.nutricao.domain.Pedido;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PedidoDiaBean implements Serializable {
	private Pedido pedido;
	private List<Pedido> pedidos;
	private List<Cardapio> cardapios;
	private List<Dieta> dietas;
	
	private List<ItemPedido> itensPedido;
	private List<Paciente> pacientes;
	private List<Funcionario> funcionarios;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Cardapio> getCardapios() {
		return cardapios;
	}

	public List<Dieta> getDietas() {
		return dietas;
	}

	public void setDietas(List<Dieta> dietas) {
		this.dietas = dietas;
	}

	

	public void setCardapios(List<Cardapio> cardapios) {
		this.cardapios = cardapios;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	
	@PostConstruct
	public void pedidoDiaListar() {
		try {
			ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
			itensPedido = itemPedidoDAO.listar();
//			pedido = new Pedido();
//			pedido.setQuantidadeTotal(new Short("0"));
//
//			DietaDAO dietaDAO = new DietaDAO();
//			dietas = dietaDAO.listar("descricao");
//
//			itensPedido = new ArrayList<>();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar listar tela de pedidos");
			erro.printStackTrace();

		}

	}


//	public void adicionar(ActionEvent evento) {
//
//		Dieta dieta = (Dieta) evento.getComponent().getAttributes().get("dietaSelecionada");
//
//		int achou = -1;
//		for (int posicao = 0; posicao < itensPedido.size(); posicao++) {
//			// capiturar o item na linha corrente e verificar se é igual
//			if (itensPedido.get(posicao).getDieta().equals(dieta)) {
//				achou = posicao;
//			}
//
//		}
//
//		if (achou < 0) {
//			ItemPedido itemPedido = new ItemPedido();
//			itemPedido.setDieta(dieta);
//			itemPedido.setQuantidade(new Short("1"));
//
//			itensPedido.add(itemPedido);
//		} // else{
//			// ItemPedido itemPedido = itensPedido.get(achou);
//			// itemPedido.setQuantidade(new
//			// Short(itemPedido.getQuantidade()+1+""));
//			// }
//			calcular();
//
//	}
//
//	public void excluir(ActionEvent evento) {
//		ItemPedido itemPedido = (ItemPedido) evento.getComponent().getAttributes().get("itemSelecionado");
//
//		int achou = -1;
//		for (int posicao = 0; posicao < itensPedido.size(); posicao++) {
//			if (itensPedido.get(posicao).getDieta().equals(itemPedido.getDieta())) {
//				achou = posicao;
//			}
//		}
//		// if(achou > -1 && itemVenda.getQuantidade() > 1){//pra remover um por
//		// um das quantidades
//		// itemVenda.setQuantidade(new Short(itemVenda.getQuantidade() - 1 +
//		// ""));
//		// itemVenda.setValorParcial(itemVenda.getValorParcial().subtract(itemVenda.getProduto().getPreco()));
//		//
//		// } else{
//		// itensVenda.remove(achou);
//		// }
//		//
//		// }﻿
//
//		if (achou > -1) {
//			itensPedido.remove(achou);
//		}
//		calcular();
//
//	}
//
//	public void calcular() {
//		pedido.setQuantidadeTotal(new Short("0"));
//		for (int posicao = 0; posicao < itensPedido.size(); posicao++) {
//			ItemPedido itemPedido = itensPedido.get(posicao);
//			pedido.setQuantidadeTotal((short) (pedido.getQuantidadeTotal()+(itemPedido.getQuantidade())));
//		}
//	}
//
//	public void finalizar() {
//		try {
//
//			pedido.setHorario(new Date());
//			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
//			funcionarios = funcionarioDAO.listarOrdenado();
//
//			PacienteDAO pacienteDAO = new PacienteDAO();
//			pacientes = pacienteDAO.listarOrdenado();
//
//		} catch (RuntimeException erro) {
//			Messages.addGlobalError("Ocorreu um erro ao tentar finalizar o pedido");
//			erro.printStackTrace();
//		}
//	}
//
//	public void salvar() {
//		try {
//			if (pedido.getQuantidadeTotal() == 0) {
//				Messages.addGlobalError("Informe pelo menos um item para o pedido");
//				return;
//			}
//			PedidoDAO pedidoDAO = new PedidoDAO();
//			pedidoDAO.savar(pedido, itensPedido);
//
//			pedidoDiaListar();
//
//			Messages.addGlobalInfo("Pedido realizada com sucesso");
//		} catch (RuntimeException erro) {
//			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o pedido");
//			erro.printStackTrace();
//		}
//	}
}
