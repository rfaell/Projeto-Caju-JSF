package br.edu.ifpb.caju.controller;

import java.util.ArrayList;

import br.edu.ifpb.caju.model.Colegiado;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifpb.caju.model.Membro;

@ManagedBean(name="membroColegiadoBean")
@ViewScoped
public class SistemaMembroColegiadoBean {
	private List<Membro> membros = new ArrayList<Membro>();
	private List<Membro> selecionados = new ArrayList<Membro>();
	private Membro membro;
	private List<Membro> filtrados;
	private SistemaMembro sm;
	private Colegiado colegiado;

	
	
	public SistemaMembroColegiadoBean() {
		
		sm = new SistemaMembro();
		membros = sm.getAllMembros();
		colegiado = new Colegiado();
		filtrados = membros;
		
	}
	public void adicionaMembro(){
		selecionados.add(membro);
		membros.remove(membro);
		filtrados.remove(membro);

	}
	public void removeMembro(){
		Membro m = membro;
		selecionados.remove(m);
		membros.add(m);

	}
	public void salvarMembros(){
		
	}

	public List<Membro> getMembros() {
		return membros;
	}


	public void setMembros(List<Membro> membros) {
		this.membros = membros;
	}


	public List<Membro> getSelecionados() {
		return selecionados;
	}


	public void setSelecionados(List<Membro> selecionados) {
		this.selecionados = selecionados;
	}


	public Membro getMembro() {
		return membro;
	}


	public void setMembro(Membro membro) {
		this.membro = membro;
	}


	public List<Membro> getFiltrados() {
		return filtrados;
	}


	public void setFiltrados(List<Membro> filtrados) {
		this.filtrados = filtrados;
	}
	public Colegiado getColegiado() {
		return colegiado;
	}
	public void setColegiado(Colegiado colegiado) {
		this.colegiado = colegiado;
	}
	
	
}

