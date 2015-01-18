package br.com.fabricadeprogramador.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Usuario;

@Repository("usuarioDAOJPA")
public class UsuarioDAOJPA implements UsuarioDAO {

	@PersistenceContext
	// metodo salvar evitando de eu mandar SQL na unha
	private EntityManager entityManager; // meu entidade de gerenciamento que e
											// necessario
	
	
	
	@Transactional
	public void alterar(Usuario usuario){
		
		
	
		entityManager.merge(usuario);
		  
		     
		
		
	}
		

	@Transactional
	// faz pra mim abertura e transaçao evitando de eu digitar
	// em.transaction.begin e tal
	// transactional so usarei quando for autera algo no banco updates tal
	// consulta nao precisa
	public void salvar(Usuario usuario) throws DAOException {

		try {
			entityManager.merge(usuario);

		} catch (Exception causa) {

			throw new DAOException("nao foi possivel salvar", causa);
		}

	}


	// faz pra mim abertura e transaçao evitando de eu digitar
	// em.transaction.begin e tal
	@Transactional
	public void excluir(Usuario usuario) throws DAOException {//digo pro metodo que ele pode gerar uma exception

		try {
					Usuario usuario_excluir = buscarporid(usuario.getId());
		
					entityManager.remove(usuario_excluir);
		
				} catch (Exception causa) {
					
					throw new DAOException("erro ao excluir",causa);
					
		
				}

	}

			@SuppressWarnings("unchecked")
			@Override
			public List<Usuario> buscartodos() {
		
				javax.persistence.Query consulta = entityManager
						.createQuery("SELECT u FROM Usuario u  ORDER BY id");// jpql ver oque e essa  porra
																
				return consulta.getResultList();

				}

			@Override
			
			public Usuario buscarporid(Integer id) {
		
				return entityManager.find(Usuario.class, id);

	         }
	

			@Override
			public Usuario buscarporlogin(String login) throws DAOException {
		
					try {
						
						  String jpql="SELECT u FROM Usuario u WHERE u.login=:loginParam";//comando pra selecionar  o login 
						  
							 javax.persistence.Query consulta=entityManager.createQuery(jpql);//crio uma consulta no banco e guardo em uma variavel
							 
							 consulta.setParameter("loginParam", login);//digo que o loginParam sera substituido por login que chegar
							 consulta.setMaxResults(1);
							 
							  return (Usuario)consulta.getSingleResult();
						
						
					} catch (NoResultException causa) {
						
						
						return null;
						
						
						
					}
					
	
	         }
			
			 

}
