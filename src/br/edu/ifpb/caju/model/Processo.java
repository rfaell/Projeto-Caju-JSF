package br.edu.ifpb.caju.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Processo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int idProcesso;
	private int matRequerente;
	private String nomeRequerente;
	private String dataDoc;
	private String assunto;
	private String periodo;
	@ManyToOne
	private Reuniao reuniao;
	@OneToOne
	private Voto voto;
	@ManyToOne
	private Membro relator;
	
	public Processo(){}
	
	
	
	public Membro getRelator() {
		return relator;
	}



	public void setRelator(Membro relator) {
		this.relator = relator;
	}



	public Voto getVoto() {
		return voto;
	}



	public void setVoto(Voto voto) {
		this.voto = voto;
	}



	public Reuniao getReuniao() {
		return reuniao;
	}



	public void setReuniao(Reuniao reuniao) {
		this.reuniao = reuniao;
	}



	public int getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}

	public int getMatRequerente() {
		return matRequerente;
	}

	public void setMatRequerente(int matRequerente) {
		this.matRequerente = matRequerente;
	}

	public String getNomeRequerente() {
		return nomeRequerente;
	}

	public void setNomeRequerente(String nomeRequerente) {
		this.nomeRequerente = nomeRequerente;
	}

	public String getDataDoc() {
		return dataDoc;
	}

	public void setDataDoc(String dataDoc) {
		String[] quebra = dataDoc.split(" ");
		this.dataDoc = String.format("%s/%s/%s", quebra[2], quebra[1], quebra[quebra.length-1]);
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Processo [id=" + id + ", idProcesso=" + idProcesso
				+ ", matRequerente=" + matRequerente + ", nomeRequerente="
				+ nomeRequerente + ", dataDoc=" + dataDoc + ", assunto="
				+ assunto + ", periodo=" + periodo + ", reuniao=" + reuniao
				+ ", voto=" + voto + ", relator=" + relator + "]";
	}
	
	
	
	
	
}
