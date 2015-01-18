package cadastros;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fabricadeprogramador.model.dao.UsuarioDAO;
import br.com.fabricadeprogramador.model.dao.UsuarioDAOJPA;
import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Usuario;

public class TestDataSource {
	
	public static void main(String[] args) throws DAOException {
		
		ClassPathXmlApplicationContext contextoSpring= new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
		 
		//preciso de um serviço dao com os metodos do usuarioDAOJPA  poderia ser jdbc ou qualquer outro
		UsuarioDAO usuarioDAO=(UsuarioDAO)contextoSpring.getBean("usuarioDAOJPA");
		
		//aqui nao preciso criar o entity maneget pois ja esta no metodo salvar 
		 //crio um usuario do tipo entity
		    Usuario usuario= new Usuario();
	          usuario.setNome("jao");
	          usuario.setLogin("jao");
	          usuario.setSenha("123");
		    
	          usuarioDAO.salvar(usuario);
	          
	         // System.out.println(usuarioDAO);
		
		
	
	
			
			
}

	private static void testEntityManager() {
		//contexto do spring sempre
		ClassPathXmlApplicationContext contextoSpring= new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
       //fabrica entidade de gerenciamento
	    EntityManagerFactory emf =(EntityManagerFactory) contextoSpring.getBean("entityManagerFactory");
	    //fabricado um gerenciador de entidade
	    EntityManager em= emf.createEntityManager();
	    
	    //crio um usuario do tipo entity
//	    Usuario usuario= new Usuario();
//          usuario.setNome("jao");
//	      usuario.setLogin("jao");
//          usuario.setSenha("123");
//	    
	    
	    
	    em.getTransaction().begin();//incio da minha transaçao no banco  
	   // em.persist(usuario);
	     Usuario  u=em.find(Usuario.class, 1);
	     System.out.println(u.getLogin());
	     
	    	
	    em.getTransaction().commit();//faço a transaçao de fato
	}

	private static void testDataSource() {
		//contexto do spring 
		ClassPathXmlApplicationContext contextoSpring= new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
		
		//instanciando um objeto do  contexto spring
		BasicDataSource basicDataSource=(BasicDataSource)contextoSpring.getBean("BasicDataSource");
		
		//acessando o objeto 
		System.out.println(basicDataSource.getDriverClassName());
		System.out.println(basicDataSource.getUsername());
		System.out.println(basicDataSource.getPassword());
		System.out.println(basicDataSource.getUrl());
		
		contextoSpring.close();
	}
}
