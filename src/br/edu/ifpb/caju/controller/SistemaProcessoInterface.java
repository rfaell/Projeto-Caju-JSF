package br.edu.ifpb.caju.controller;

import java.util.HashMap;

public interface SistemaProcessoInterface {
	
	public void cadastraProcesso();
	public void removeProcesso();
	public void editaProcesso();
	public void getAllProcessos();
	public void getProcessosByAtributes(HashMap<String, String> dados);

}
