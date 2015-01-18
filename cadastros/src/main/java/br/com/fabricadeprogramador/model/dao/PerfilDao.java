package br.com.fabricadeprogramador.model.dao;

import java.util.List;

import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Perfil;

public interface PerfilDao {
	
	
	
	 void salvar (Perfil perfil) throws DAOException;
	 void excluir(Perfil perfil)throws DAOException;
	 
	 List<Perfil> buscarperfil() throws DAOException;
	 
	 
	  Perfil buscarporid (Integer id)throws DAOException;
	  
	 
	  
	  void alterar(Perfil perfil)throws DAOException;
		
		
	

}
