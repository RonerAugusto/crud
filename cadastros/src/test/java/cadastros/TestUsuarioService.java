package cadastros;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.fabricadeprogramador.model.entidade.Usuario;
import br.com.fabricadeprogramador.model.service.exception.Service_Exception;
import br.com.fabricadeprogramador.model.service.exception.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional

public class TestUsuarioService {


	
	@Autowired private UsuarioService usuarioservice;  //uma instancia do usuario service que tem meu novo metodo salvar
	
	@Test
	public void testSalvar() throws Service_Exception {
		Usuario usuario=new Usuario();
		usuario.setLogin("carlos");
		usuario.setSenha("123");
		usuario.setNome("carlos");
		
		
	usuarioservice.salvar(usuario);
		
	}
	
	
}
