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
	private Processo processo;
	private List<Processo> processos;
	
	public SistemaProcesso() {
		this.dao = new DAOProcesso();
		processo = new Processo();
        getAllProcessos();
	}
	
	
	
	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

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

	
	
	@Override
	public void cadastraProcesso() {
		DAO.open();
		DAO.begin();
		this.dao.persist(processo);
		DAO.commit();
		DAO.close();
		getAllProcessos();
		FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Processo: Nº " + this.processo.getIdProcesso() + ". Cadastrado com Sucesso!"));
		this.processo = new Processo();
		
		
	}

	@Override
	public void removeProcesso() {
		DAO.open();
		DAO.begin();
		int valor = processo.getIdProcesso();
		this.dao.remove(dao.merge(processo));
		DAO.commit();
		DAO.close();
		getAllProcessos();
		this.processo = new Processo();
		FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Processo: Nº " + valor + ". Removido com Sucesso!"));
		
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
		this.processos = processos;
		return this.processos;
	}
	
	 

	@Override
	public void getProcessosByAtributes(HashMap<String, String> dados) {
		List<Processo> processos;
		DAO.open();
		DAO.begin();
		processos = this.dao.findByAtributes((HashMap<String, String>) dados);
		DAO.commit();
		DAO.close();
		this.processos = processos;
	}
	
	public void getProcessoPorProcesso(){
		DAO.open();
		DAO.begin();
		processo = this.dao.find(processo);
		DAO.commit();
		DAO.close();
	}

}
