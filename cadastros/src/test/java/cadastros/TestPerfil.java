package cadastros;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.fabricadeprogramador.model.dao.PerfilDao;
import br.com.fabricadeprogramador.model.dao.UsuarioDAO;
import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Perfil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)



public class TestPerfil {
	
	@Autowired
	@Qualifier("perfilDAOJPA")
	private PerfilDao perfilDAO;

	
    // @Test	
	public void salvar() throws DAOException{
    	 
    	 Perfil perfil=new Perfil();
    	 perfil.setDescricao("Visitante");
    	 perfil.setId(1);
    	 
    	 perfilDAO.salvar(perfil);
    	 
    	 
     }
     @Test
     public  void testlistar() throws DAOException {
    	 
    	 List<Perfil> lista=perfilDAO.buscarperfil();
    	 
    	 System.out.println(lista);
    	 
     }
	
	
}
