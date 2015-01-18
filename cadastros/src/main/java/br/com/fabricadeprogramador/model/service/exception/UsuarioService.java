package br.com.fabricadeprogramador.model.service.exception;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.model.dao.UsuarioDAO;
import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Usuario;

@Service
public class UsuarioService {
@Autowired
@Qualifier("usuarioDAOJPA")  //qualifico pra dizer que usuario dao sera usado que no caso sera  O JPA

private UsuarioDAO usuarioDAO; //faço o injeçao de dependencia do usuarioDAO pq irei usar seus mentodos

public void salvar (Usuario usuario) throws Service_Exception{
	
	try {
		
	Usuario	usuariobuscado=usuarioDAO.buscarporlogin(usuario.getLogin());
	
	if(usuariobuscado != null){
		System.out.println(usuariobuscado);
		
	 throw  new 	Service_Exception("login existente escolha outro ");
		
	}else {
		
		usuarioDAO.salvar(usuario);
	}	
		
		
	} catch (DAOException causa) {
		
		 throw  new Service_Exception(causa);
	}
	
	

	
	
}	

  public List<Usuario>    buscarTodos() {
	  
	  
	return  usuarioDAO.buscartodos();
	  
  }

  public void excluir(Usuario usuario) throws Service_Exception  {
	
  // Usuario usuariosetado=usuarioDAO.buscarporid(usuario.setId(id););
   
	  try {
		  
		usuarioDAO.excluir(usuario);
		
	} catch (DAOException e) {
		
		throw new Service_Exception("nao foi possivel excluir"+e.getMessage());
		
	}
	
}

public void alterar(Usuario usuario) throws Service_Exception {
	try {
		
		usuarioDAO.alterar(usuario);
		
	} catch (DAOException e) {
		
		throw new Service_Exception("nao foi possivel alterar"+e.getMessage());
	}
	
}






	
	
}
