package com.hol.nutricao.uitl;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

//http://localhost:8080/Nutricao/rest
@ApplicationPath("rest")
public class NutricaoResourceConfig extends ResourceConfig {
	public NutricaoResourceConfig(){
		packages("com.hol.nutricao.service");
	}

}
