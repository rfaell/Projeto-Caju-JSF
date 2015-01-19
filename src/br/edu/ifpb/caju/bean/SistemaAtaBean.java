package br.edu.ifpb.caju.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.edu.ifpb.caju.controller.SistemaAta;
import br.edu.ifpb.caju.model.Ata;

@ManagedBean(name = "ataBean")
@SessionScoped
public class SistemaAtaBean {
	
	private Ata ata = new Ata();	
	private DataModel<Ata> atas;
	
	public DataModel<Ata> getAtas() {
		SistemaAta sisAta = new SistemaAta();
		
		try {
			List<Ata> lista = sisAta.getAllAta();
			atas = new ListDataModel<Ata>(lista);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return atas;
	}
	
	public void setAtas(DataModel<Ata> a){
		this.atas = a;
	}

	public Ata getAta() {
		return ata;
	}

	public void setAta(Ata ata) {
		this.ata = ata;
	}
	
	
	public String cadastraAta(){
		String retorno = "erro";
		
		FacesContext context = FacesContext.getCurrentInstance();		
		SistemaAta sisAta = new SistemaAta();		
		
		try{
			sisAta.cadastraAta(ata);
			FacesMessage faceMessage = new FacesMessage("Ata salva com Sucesso");
			context.addMessage(null,faceMessage);
			retorno = "sucesso";			
		}catch(Exception e){
			
		}
		
		return retorno;		
	}

	
	public String excluirAta(){
		String retorno = "erro";		
		SistemaAta sisAta = new SistemaAta();

		//mensagem
//		FacesContext context = FacesContext.getCurrentInstance();					
		
		try{
			
			sisAta.removeAta(ata);
//			FacesMessage faceMessage = new FacesMessage("Ata removida com Sucesso");
//			context.addMessage(null,faceMessage);
			retorno = "lista_ata";			
		}catch(Exception e){
			
		}
		
		return retorno;		
	}	

	public String atualizarAta(){
		String retorno = "erro";
		
//		FacesContext context = FacesContext.getCurrentInstance();		
		SistemaAta sisAta = new SistemaAta();		
		
		try{
			sisAta.editaAta(ata);
//			FacesMessage faceMessage = new FacesMessage("Ata atualizada com Sucesso");
//			context.addMessage(null,faceMessage);
			retorno = "lista_ata";			
		}catch(Exception e){
			
		}
		
		return retorno;		
	}	
	
	public void selecionarAta(){
		this.ata = atas.getRowData();
	}
	
	public void novo(){
		this.ata = new Ata();
	}
}
