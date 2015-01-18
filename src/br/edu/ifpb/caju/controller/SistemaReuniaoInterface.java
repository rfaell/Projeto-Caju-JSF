package br.edu.ifpb.caju.controller;

import java.util.List;

import br.edu.ifpb.caju.model.Reuniao;


public interface SistemaReuniaoInterface {
	
	public void cadastraReuniao();
	public void removeReuniao();
	public void editaReuniao();
	public List<Reuniao> getAllReunioes();

}
