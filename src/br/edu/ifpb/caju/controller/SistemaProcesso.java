package br.edu.ifpb.caju.controller;

import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpb.caju.dao.DAO;
import br.edu.ifpb.caju.dao.DAOProcesso;
import br.edu.ifpb.caju.model.Processo;


@ManagedBean (name ="sistemaProcesso")
@ViewScoped
public class SistemaProcesso implements SistemaProcessoInterface{

	private DAOProcesso dao;
	private Processo processo = new Processo();
	
	
	
	public DAOProcesso getDao() {
		return dao;
	}

	public void setDao(DAOProcesso dao) {
		this.dao = dao;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public SistemaProcesso() {
		this.dao = new DAOProcesso();
	}
	
	@Override
	public void cadastraProcesso() {
		DAO.open();
		DAO.begin();
		this.dao.persist(processo);
		DAO.commit();
		DAO.close();
		
		FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Processo: Nº " + this.processo.getIdProcesso() + ". Cadastrado com Sucesso!"));
		this.processo = new Processo();
		
		
	}

	@Override
	public void removeProcesso() {
		DAO.open();
		DAO.begin();
		this.dao.remove(processo);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public void editaProcesso() {
		DAO.open();
		DAO.begin();
		this.dao.merge(processo);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public List<Processo> getAllProcessos() {
		List<Processo> processos;
		DAO.open();
		DAO.begin();
		processos = this.dao.findAll();
		DAO.commit();
		DAO.close();
		return processos;
	}


	@Override
	public List<Processo> getProcessosByAtributes(HashMap<String, String> dados) {
		List<Processo> processos;
		DAO.open();
		DAO.begin();
		processos = this.dao.findByAtributes((HashMap<String, String>) dados);
		DAO.commit();
		DAO.close();
		return processos;
	}

}
