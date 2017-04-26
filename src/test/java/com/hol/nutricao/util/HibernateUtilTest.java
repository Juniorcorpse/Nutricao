package com.hol.nutricao.util;

import org.hibernate.Session;
import org.junit.Test;

import com.hol.nutricao.uitl.HibernateUtil;

public class HibernateUtilTest {
	
	@Test
	public void conectar(){
		Session sessao = HibernateUtil.getFabricadesessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricadesessoes().close();
	}

}
