package com.hol.nutricao.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;
import com.hol.nutricao.dao.VariacaoDietaDAO;
import com.hol.nutricao.domain.VariacaoDieta;

@Path("variacao")
public class VariacaoDietaService {
	// http://localhost:8080/Nutricao/rest/variacao
	@GET
	public String listar() {
		VariacaoDietaDAO variacaoDAO = new VariacaoDietaDAO();
		List<VariacaoDieta> variacoes = variacaoDAO.listar("descricao");

		Gson gson = new Gson();
		String json = gson.toJson(variacoes);
		return json;
	}

	// http://localhost:8080/Nutricao/rest/variacao/10
	@GET
	@Path("{codigo}")
	public String buscar(@PathParam("codigo") Long codigo) {
		VariacaoDietaDAO variacaoDAO = new VariacaoDietaDAO();
		VariacaoDieta variacao = variacaoDAO.buscar(codigo);

		Gson gson = new Gson();
		String json = gson.toJson(variacao);

		return json;
	}
	
	// http://localhost:8080/Nutricao/rest/variacao
	@POST
	public String salvar(String json) {
		Gson gson = new Gson();
		VariacaoDieta variacao = gson.fromJson(json, VariacaoDieta.class);

		VariacaoDietaDAO variacaoDAO = new VariacaoDietaDAO();
		variacaoDAO.merge(variacao);

		String jsonSaida = gson.toJson(variacao);
		return jsonSaida;

	}
	
	// http://localhost:8080/Nutricao/rest/variacao
	@PUT
	@Path("{codigo}")//
	public String editar(@PathParam("codigo") Long codigo) {
		
		VariacaoDietaDAO variacaoDAO = new VariacaoDietaDAO();
		VariacaoDieta variacao = variacaoDAO.buscar(codigo);
		variacaoDAO.editar(variacao);
		
		Gson gson = new Gson();
		String jsonSaida = gson.toJson(variacao);
		return jsonSaida;

	}

	// http://localhost:8080/Nutricao/rest/variacao/10
	@DELETE
	@Path("{codigo}")
	public String excluir(@PathParam("codigo") Long codigo) {

		VariacaoDietaDAO variacaoDAO = new VariacaoDietaDAO();
		VariacaoDieta variacao = variacaoDAO.buscar(codigo);
		variacaoDAO.excluir(variacao);
		
		Gson gson = new Gson();
		String jsonSaida = gson.toJson(variacao);
		return jsonSaida;
	}
			
		
}
