package br.edu.ifpb.caju.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifpb.caju.dao.DAO;
import br.edu.ifpb.caju.dao.DAOAta;
import br.edu.ifpb.caju.model.Ata;

@ManagedBean
@ViewScoped
public class SistemaAta implements SistemaAtaInterface {

	private DAOAta dao;
	
	private Ata ata = new Ata();
	
	public SistemaAta() {
		this.dao = new DAOAta();
	}
	@Override
	public void cadastraAta() {
		
		DAO.open();
		DAO.begin();
		this.dao.persist(this.ata);
		DAO.commit();
		DAO.close();
	}

	@Override
	public void removeAta() {
	
		DAO.open();
		DAO.begin();
		this.dao.remove(this.ata);
		DAO.commit();
		DAO.close();
	}

	@Override
	public void editaAta() {
		
		DAO.open();
		DAO.begin();
		this.dao.merge(this.ata);
		DAO.commit();
		DAO.close();
	}

	@Override
	public List<Ata> getAllAta() {
		List<Ata> ata;
		DAO.open();
		DAO.begin();
		ata = this.dao.findAll();
		DAO.commit();
		DAO.close();
		return ata;
	}
	
	public Ata getAta() {
		return ata;
	}
	
	public void setAta(Ata ata) {
		this.ata = ata;
	}



}
