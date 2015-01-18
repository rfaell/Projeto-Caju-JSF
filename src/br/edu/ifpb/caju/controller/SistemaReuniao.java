package br.edu.ifpb.caju.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifpb.caju.dao.DAO;
import br.edu.ifpb.caju.dao.DAOReuniao;
import br.edu.ifpb.caju.model.Reuniao;

@ManagedBean
@ViewScoped
public class SistemaReuniao implements SistemaReuniaoInterface{

	private DAOReuniao dao;
	
	private Reuniao reuniao = new Reuniao();
	
	public SistemaReuniao() {
		this.dao = new DAOReuniao();
	}
	
	@Override
	public void cadastraReuniao() {
		DAO.open();
		DAO.begin();
		this.dao.persist(this.reuniao);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public void removeReuniao() {
		DAO.open();
		DAO.begin();
		this.dao.remove(this.reuniao);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public void editaReuniao() {
		DAO.open();
		DAO.begin();
		this.dao.merge(this.reuniao);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public List<Reuniao> getAllReunioes() {
		DAO.open();
		DAO.begin();
		List<Reuniao> reunioes = this.dao.findAll();
		DAO.commit();
		DAO.close();
		return reunioes;
	}

	public Reuniao getReuniao() {
		return reuniao;
	}

	public void setReuniao(Reuniao reuniao) {
		this.reuniao = reuniao;
	}

	
	
}
