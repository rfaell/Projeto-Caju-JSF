package br.edu.ifpb.caju.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpb.caju.dao.DAO;
import br.edu.ifpb.caju.dao.DAOVoto;
import br.edu.ifpb.caju.model.Voto;

@ManagedBean (name = "sistemaVoto")
@ViewScoped
public class SistemaVotoBean implements SistemaVotoInterface {
	
	private DAOVoto dao;
	private Voto voto;
	private List<Voto> votos = new ArrayList<Voto>();
	
	
	public SistemaVotoBean(){
		this.dao = new DAOVoto();
		this.voto = new Voto();
	}
						
	public void cadastraVoto() {
		DAO.open();
		DAO.begin();
		this.dao.persist(voto);
		DAO.commit();
		DAO.close();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Voto registrado com Sucesso!"));
		this.voto = new Voto();

	}

	@Override
	public void removeVoto(Voto voto) {
		
		DAO.open();
		DAO.begin();
		this.dao.remove(dao.merge(voto));
		DAO.commit();
		DAO.close();
		//getAllVotos();
		
		FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Voto removido com Sucesso!"));
		this.voto = new Voto();

	}

	@Override
	public void editaVoto(Voto voto) {
		//Precisa?
		DAO.open();
		DAO.begin();
		this.dao.merge(voto);
		DAO.commit();
		DAO.close();

	}

	@Override
	public List<Voto> getAllVoto() {
		DAO.open();
		DAO.begin();
		this.votos = this.dao.findAll();
		DAO.commit();
		DAO.close();
		return votos;
	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}
	
}
