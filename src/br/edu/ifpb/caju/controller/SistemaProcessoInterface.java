package br.edu.ifpb.caju.controller;

import java.util.HashMap;
import java.util.List;

import br.edu.ifpb.caju.model.Processo;

public interface SistemaProcessoInterface {
	
	public void cadastraProcesso();
	public void removeProcesso();
	public void editaProcesso();
	public List<Processo> getAllProcessos();
	public List<Processo> getProcessosByAtributes(HashMap<String, String> dados);

}
