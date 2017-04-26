package com.hol.nutricao.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.hol.nutricao.domain.Funcionario;
import com.hol.nutricao.uitl.HibernateUtil;

public class FuncionarioDAO extends GenericDAO<Funcionario> {
	@SuppressWarnings("unchecked")
	public List<Funcionario> listarOrdenado() {
		Session sessao = HibernateUtil.getFabricadesessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Funcionario.class);
			// alias
			consulta.createAlias("pessoa", "p");
			// ordenar os dados
			consulta.addOrder(Order.asc("p.nome"));
			List<Funcionario> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}

	}
}
