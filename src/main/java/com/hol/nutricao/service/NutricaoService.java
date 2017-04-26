package com.hol.nutricao.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

//teste
//http://localhost:8080/Nutricao/rest/nutricao
@Path("nutricao")
public class NutricaoService {
	@GET
	public String exibir(){
		return "Dietoterápia";
	}
	
}
