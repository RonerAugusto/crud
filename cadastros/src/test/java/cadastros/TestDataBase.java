package cadastros;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fabricadeprogramador.model.entidade.Usuario;

public class TestDataBase {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//Carregando o contexto do Spring
		ClassPathXmlApplicationContext 	ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
		//fabrica 
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean("entityManagerFactory");
	
		//Obtendo um objeto gerenciador de entidades
		EntityManager em = emf.createEntityManager();
		
		//Criando um objeto Usuario
		Usuario usu =  new Usuario();
		usu.setNome("Virmerson");
		usu.setLogin("vir");
		usu.setSenha("123");
	
		//Obtendo um objeto gerenciador de transacoes
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(usu);
		transaction.commit();
	}

	private static void testDataSource() {
		//Código aqui 
		ClassPathXmlApplicationContext 	ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
		BasicDataSource dataSource=   (BasicDataSource) ctx.getBean("dataSource");
		
		System.out.println(dataSource.getDriverClassName());
		System.out.println(dataSource.getPassword());
		System.out.println(dataSource.getUsername());
		System.out.println(dataSource.getUrl());
		
		ctx.close();
	}

}
