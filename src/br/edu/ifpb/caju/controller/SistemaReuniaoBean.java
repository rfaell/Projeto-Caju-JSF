package br.edu.ifpb.caju.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.edu.ifpb.caju.model.Colegiado;
import br.edu.ifpb.caju.model.Membro;
import br.edu.ifpb.caju.model.Reuniao;

@ManagedBean(name = "reuniaoBean")
@ViewScoped
public class SistemaReuniaoBean {
	
	private Reuniao reuniao = new Reuniao();	
	private DataModel<Reuniao> reunioes;
	private List<Membro> membrosSelecionados;
	private List<Membro> membros;
	private Membro membro;

	//construtor
	public SistemaReuniaoBean() {
		this.membros = getListaDeMembrosAtivos();
	}

		
	public Membro getMembro() {
		return membro;
	}


	public void setMembro(Membro membro) {
		this.membro = membro;
	}

	public void addMembroSelecionado(){
		this.membrosSelecionados.add(this.membro);
	}

	public List<Membro> getMembros() {
		return membros;
	}

	public void setMembros(List<Membro> membros) {
		this.membros = membros;
	}	
	
	public List<Membro> getMembrosSelecionados() {
		return membrosSelecionados;
	}

	public void setMembrosSelecionados(List<Membro> membrosSelecionados) {
		this.membrosSelecionados = membrosSelecionados;
	}

	public List<Membro> getListaDeMembrosAtivos(){
		
		//pegar a lista do colegiado
		SistemaColegiadoBean colegiado = new SistemaColegiadoBean();
		List<Colegiado> col = colegiado.getAllColegiado();
				
		Colegiado c = new Colegiado();
		//pegar o colegiado ativo
		for(Colegiado coleg: col){
			if(coleg.isAtivo()){
				c = coleg;				
			}
			break;
		}
		
		//Criar um array de membros
		List<Membro> membros = new ArrayList<Membro>();
		for(Membro m : c.getMembros()){
			membros.add(m);			
		}		
		return membros;
	}
	
	
	
	public DataModel<Reuniao> getReunioes() {
		SistemaReuniao sisReuniao = new SistemaReuniao();
		
		try {
			List<Reuniao> lista = sisReuniao.getAllReunioes();
			reunioes = new ListDataModel<Reuniao>(lista);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return reunioes;
	}
	
	public void setReunioes(DataModel<Reuniao> r){
		this.reunioes = r;
	}

	public Reuniao getReuniao() {
		return reuniao;
	}

	public void setReuniao(Reuniao reuniao) {
		this.reuniao = reuniao;
	}
	
	
	public String cadastraReuniao(){
		String retorno = "erro";
		
		FacesContext context = FacesContext.getCurrentInstance();		
		SistemaReuniao sisReuniao = new SistemaReuniao();		
		
		try{
			sisReuniao.cadastraReuniao(reuniao);
			FacesMessage faceMessage = new FacesMessage("Reuniao salva com Sucesso");
			context.addMessage(null,faceMessage);
			retorno = "sucesso";			
		}catch(Exception e){
			
		}
		
		return retorno;		
	}

	
	public String excluirReuniao(){
		String retorno = "erro";		
		SistemaReuniao sisReuniao = new SistemaReuniao();

		//mensagem
//		FacesContext context = FacesContext.getCurrentInstance();					
		
		try{
			
			sisReuniao.removeReuniao(reuniao);
//			FacesMessage faceMessage = new FacesMessage("Reuniao removida com Sucesso");
//			context.addMessage(null,faceMessage);
			retorno = "lista_reuniao";			
		}catch(Exception e){
			
		}
		
		return retorno;		
	}	

	public String atualizarReuniao(){
		String retorno = "erro";
		
//		FacesContext context = FacesContext.getCurrentInstance();		
		SistemaReuniao sisReuniao = new SistemaReuniao();		
		
		try{
			sisReuniao.editaReuniao(reuniao);
//			FacesMessage faceMessage = new FacesMessage("Reuniao atualizada com Sucesso");
//			context.addMessage(null,faceMessage);
			retorno = "lista_reuniao";			
		}catch(Exception e){
			
		}
		
		return retorno;		
	}	
	
	public void selecionarReuniao(){
		this.reuniao = reunioes.getRowData();
	}
	
	public void novo(){
		this.reuniao = new Reuniao();
	}
}
