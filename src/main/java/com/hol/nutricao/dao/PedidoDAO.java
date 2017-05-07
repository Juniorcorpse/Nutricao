package com.hol.nutricao.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hol.nutricao.domain.ItemPedido;
import com.hol.nutricao.domain.Pedido;
import com.hol.nutricao.uitl.HibernateUtil;

public class PedidoDAO extends GenericDAO<Pedido>{
	public void salvar(Pedido pedido, List<ItemPedido> itensPedido){
		Session sessao = HibernateUtil.getFabricadesessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			
			sessao.save(pedido);
			
			for(int posicao = 0; posicao < itensPedido.size();posicao++){
				ItemPedido itemPedido = itensPedido.get(posicao);//pegando o item da linha corrente
				itemPedido.setPedido(pedido);//seto a venda a ser salva, o codigo o banco seta...
				
				sessao.save(itemPedido);
			}
			
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
		
	}
	
	public void editar(Pedido pedido, List<ItemPedido> itensPedido){
		Session sessao = HibernateUtil.getFabricadesessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			
			sessao.update(pedido);
			
			for(int posicao = 0; posicao < itensPedido.size();posicao++){
				ItemPedido itemPedido = itensPedido.get(posicao);//pegando o item da linha corrente
				itemPedido.setPedido(pedido);//seto a venda a ser atualizada, o codigo o banco seta...
				
				sessao.update(itemPedido);
			}
			
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
		
	}

}
