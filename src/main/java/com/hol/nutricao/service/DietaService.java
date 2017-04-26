package com.hol.nutricao.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;
import com.hol.nutricao.dao.DietaDAO;
import com.hol.nutricao.domain.Dieta;

@Path("dieta")
public class DietaService {
	// http://localhost:8080/Nutricao/rest/dieta
	@GET
	public String listar() {
		DietaDAO dietaDAO = new DietaDAO();
		List<Dieta> dietas = dietaDAO.listar("descricao");

		Gson gson = new Gson();
		String json = gson.toJson(dietas);
		return json;
	}

	// http://localhost:8080/Nutricao/rest/dieta/10
	@GET
	@Path("{codigo}")
	public String buscar(@PathParam("codigo") Long codigo) {
		DietaDAO dietaDAO = new DietaDAO();
		Dieta dieta = dietaDAO.buscar(codigo);

		Gson gson = new Gson();
		String json = gson.toJson(dieta);

		return json;
	}
	
	// http://localhost:8080/Nutricao/rest/dieta
	@POST
	public String salvar(String json) {
		Gson gson = new Gson();
		Dieta dieta = gson.fromJson(json, Dieta.class);

		DietaDAO dietaDAO = new DietaDAO();
		dietaDAO.merge(dieta);

		String jsonSaida = gson.toJson(dieta);
		return jsonSaida;

	}
	
	// http://localhost:8080/Nutricao/rest/dieta
	@PUT
	@Path("{codigo}")//
	public String editar(@PathParam("codigo") Long codigo) {
		
		DietaDAO dietaDAO = new DietaDAO();
		Dieta dieta = dietaDAO.buscar(codigo);
		dietaDAO.editar(dieta);
		
		Gson gson = new Gson();
		String jsonSaida = gson.toJson(dieta);
		return jsonSaida;

	}

	// http://localhost:8080/Nutricao/rest/dieta/10
	@DELETE
	@Path("{codigo}")
	public String excluir(@PathParam("codigo") Long codigo) {

		DietaDAO dietaDAO = new DietaDAO();
		Dieta dieta = dietaDAO.buscar(codigo);
		dietaDAO.excluir(dieta);
		
		Gson gson = new Gson();
		String jsonSaida = gson.toJson(dieta);
		return jsonSaida;
	}
			
		
}
