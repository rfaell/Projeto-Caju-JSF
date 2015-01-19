package br.edu.ifpb.caju.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.caju.model.Presidente;

public class DAOPresidente extends DAO<Presidente>{
	
	public Presidente findByLogin(String email) {
		Query q = getManager().createQuery("select m from Presidente m where m.login like :login" );
		q.setParameter("login", email);
		try{
			Presidente aux =  (Presidente) q.getSingleResult();
			return aux;
		}catch(NoResultException e){
			return null;
		}
	}
}
