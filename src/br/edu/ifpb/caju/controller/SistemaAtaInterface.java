package br.edu.ifpb.caju.controller;

import java.util.List;

import br.edu.ifpb.caju.model.Ata;

public interface SistemaAtaInterface {
	public void cadastraAta();

	public void removeAta();

	public void editaAta();

	public List<Ata> getAllAta();

}
