package com.hol.nutricao.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.hol.nutricao.domain.Paciente;
import com.hol.nutricao.uitl.HibernateUtil;


public class PacienteDAO extends GenericDAO<Paciente> {
	@SuppressWarnings("unchecked")
	public List<Paciente> listarOrdenado() {
		Session sessao = HibernateUtil.getFabricadesessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Paciente.class);
			consulta.createAlias("pessoa", "p");
			// ordenar os dados
			consulta.addOrder(Order.asc("p.nome"));
			List<Paciente> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}

	}

}
