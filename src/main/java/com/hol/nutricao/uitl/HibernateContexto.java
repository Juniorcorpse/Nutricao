package com.hol.nutricao.uitl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContexto implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent evento) {
		HibernateUtil.getFabricadesessoes().close();
		
	}

	@Override
	public void contextInitialized(ServletContextEvent evento) {
		HibernateUtil.getFabricadesessoes();
		
	}

}
