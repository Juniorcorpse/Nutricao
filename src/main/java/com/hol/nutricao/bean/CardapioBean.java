package com.hol.nutricao.bean;

//import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.hol.nutricao.dao.CardapioDAO;
import com.hol.nutricao.dao.DietaDAO;
import com.hol.nutricao.domain.Cardapio;
import com.hol.nutricao.domain.Dieta;

//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperPrintManager;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CardapioBean implements Serializable {
	private Cardapio cardapio;
	private List<Cardapio> cardapios;
	private List<Dieta> dietas;

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public List<Cardapio> getCardapios() {
		return cardapios;
	}

	public void setCardapios(List<Cardapio> cardapios) {
		this.cardapios = cardapios;
	}

	public List<Dieta> getDietas() {
		return dietas;
	}

	public void setDietas(List<Dieta> dietas) {
		this.dietas = dietas;
	}

	@PostConstruct
	public void listar() {
		try {
			CardapioDAO cardapioDAO = new CardapioDAO();
			cardapios = cardapioDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao listar");
			erro.printStackTrace();

		}

	}

	public void novo() {
		try {
			cardapio = new Cardapio();
			DietaDAO dietaDAO = new DietaDAO();
			dietas = dietaDAO.listar("descricao");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar gerar uma nova dieta!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {

			CardapioDAO cardapioDAO = new CardapioDAO();
			cardapioDAO.merge(cardapio);


			cardapio = new Cardapio();

			DietaDAO dietaDAO = new DietaDAO();
			dietas = dietaDAO.listar();

			cardapios = cardapioDAO.listar();

			Messages.addGlobalInfo("Cardapio salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar salvar o cadapio!");
			erro.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {
		try {
			cardapio = (Cardapio) evento.getComponent().getAttributes().get("cardapioSelecionado");
			CardapioDAO cardapioDAO = new CardapioDAO();
			cardapioDAO.excluir(cardapio);
			
			cardapios = cardapioDAO.listar();

			Messages.addGlobalInfo("Cardapio removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao excluir um cardapio!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			cardapio = (Cardapio) evento.getComponent().getAttributes().get("cardapioSelecionado");
			DietaDAO dietaDAO = new DietaDAO();
			dietas = dietaDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar um novo prouduto");
			erro.printStackTrace();
		}
	}

	
//	public void imprimir() {
//		try {
//			DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formListagem:tabela");//pegando a arvore de componente da aplicação
//			Map<String, Object> fitros = tabela.getFilters();
//			String proDescricao = (String) fitros.get("descricao");
//			String fabDescricao = (String)fitros.get("dieta.descricao");
//			String caminho = Faces.getRealPath("/reports/cardapios.jasper");
//
//			Map<String, Object> parametros = new HashMap<>();
//			if(proDescricao == null){
//				parametros.put("CARDAPIO_DESCRICAO", "%%");
//				
//			}else{
//				parametros.put("CARDAPIO_DESCRICAO","%" + carDescricao + "%");
//			}
//		
//			if(fabDescricao == null){
//				parametros.put("DIETA_DESCRICAO", "%%");
//			}else{
//				parametros.put("DIETA_DESCRICAO", "%" + dieDescricao + "%");
//			}
//			
//
//			Connection conexao = HibernateUtil.getConexao();
//
//			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
//			
//			JasperPrintManager.printReport(relatorio, true);
//		} catch (JRException erro) {
//			Messages.addGlobalError("Ocorreu um erro ao tentar gerar o relatório");
//			erro.printStackTrace();
//		}
//	}

}
