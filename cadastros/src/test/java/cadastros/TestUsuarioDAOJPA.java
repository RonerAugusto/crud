package cadastros;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.fabricadeprogramador.model.dao.UsuarioDAO;
import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)

public class TestUsuarioDAOJPA {
	
	//Obtendo uma instancia de UsuarioDAO por meio de injecao de dependencia
	@Autowired
	@Qualifier("usuarioDAOJPA") //pra dizer que tipo de usuario dao estou usando poderia ser JDBC ou outro
	private UsuarioDAO usuarioDAO;

	//@Test
	public void testSalvar() throws DAOException {
		
		// Criando uma nova Instancia de usuário para ser salvo
		Usuario usuario = new Usuario();
		usuario.setNome("jao");
		usuario.setLogin("jao");
		usuario.setSenha("123");
		// Salvando
		usuarioDAO.salvar(usuario);
	}
	
	

	//@Test
	public void testexcluir () throws DAOException{
		
		Usuario usuario = new Usuario();
		usuario.setId(55);
		
	//Usuario	usuario=entityManager.find(Usuario.class, 1);
		
		usuarioDAO.excluir(usuario);
		
		
	}
	 // @Test
	public void testbuscarTodos(){
	
		
		List<Usuario> lista=usuarioDAO.buscartodos();
		assertTrue(lista.size()>0);
		
		System.out.println(lista);
		
	
		

		
	
		
		
		
	} //@Test
	public void testbuscarPorId() throws DAOException{
		
  Usuario	usuario=usuarioDAO.buscarporid(56);

  System.out.println(usuario);
	
	assertNotNull(usuario.getLogin());
	
	 throw new	DAOException("erro ao buscar por id");
		
	}
	
	//@Test
	public void testbuscarPorLogin() throws DAOException{
		
	Usuario	usuario=usuarioDAO.buscarporlogin("manu");
	
	System.out.println(usuario);
	}
	
	public void testeAlterar () throws DAOException{
		
     
	
	}
	
	
	
}
