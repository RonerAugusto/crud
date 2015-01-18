package br.com.fabricadeprogramador.model.service.exception;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.model.dao.PerfilDao;
import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Perfil;

@Service
public class PerfilService {
@Autowired
@Qualifier("perfilDAOJPA")  //qualifico pra dizer que usuario dao sera usado que no caso sera  O JPA

private PerfilDao  perfilDAO; //faço o injeçao de dependencia do usuarioDAO pq irei usar seus mentodos

public void salvar (Perfil perfil) throws Service_Exception{
	
	try {
		perfilDAO.salvar(perfil);

		
	
		
		
	} catch (DAOException causa) {
		
		 throw  new Service_Exception(causa);
	}
	
	

	
	
}	

  public List<Perfil>    buscarperfil() throws DAOException {
	  
	  
	return  perfilDAO.buscarperfil();
	  
  }

  public void excluir(Perfil perfil) throws Service_Exception  {
	
  // Usuario usuariosetado=usuarioDAO.buscarporid(usuario.setId(id););
   
	  try {
		  
		perfilDAO.excluir(perfil);
		
	} catch (DAOException e) {
		
		throw new Service_Exception("nao foi possivel excluir"+e.getMessage());
		
	}
	
}

public void alterar(Perfil perfil) throws Service_Exception, DAOException {
	
	perfilDAO.alterar(perfil);
	
}



public Perfil  buscarPorid(Integer id) throws DAOException {
	
return	perfilDAO.buscarporid(id);
	
}






	
	
}
