package com.hol.nutricao.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.hol.nutricao.domain.Enfermaria;
import com.hol.nutricao.uitl.HibernateUtil;

public class EnfermariaDAO extends GenericDAO<Enfermaria> {
	@SuppressWarnings("unchecked")
	public List<Enfermaria> buscarPorClinica(Long clinicaCodigo){
		Session sessao = HibernateUtil.getFabricadesessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Enfermaria.class);
			consulta.add(Restrictions.eq("clinica.codigo", clinicaCodigo));
			//ordenar os dados
			consulta.addOrder(Order.asc("numero"));
			List<Enfermaria> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		}finally {
			sessao.close();
		}
	}


}
