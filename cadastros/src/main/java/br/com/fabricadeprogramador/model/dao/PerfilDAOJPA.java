package br.com.fabricadeprogramador.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Perfil;

@Repository("perfilDAOJPA")
public class PerfilDAOJPA implements PerfilDao {

	@PersistenceContext
	// metodo salvar evitando de eu mandar SQL na unha
	private EntityManager entityManager; // meu entidade de gerenciamento que e
											// necessario
	
	
	
	@Transactional
	public void alterar(Perfil perfil){
		
		
	
		entityManager.merge(perfil);
		  
		     
		
		
	}
		

	@Transactional
	// faz pra mim abertura e transaçao evitando de eu digitar
	// em.transaction.begin e tal
	// transactional so usarei quando for autera algo no banco updates tal
	// consulta nao precisa
	public void salvar(Perfil perfil) throws DAOException {

		try {
			entityManager.merge(perfil);

		} catch (Exception causa) {

			throw new DAOException("nao foi possivel salvar", causa);
		}

	}


	// faz pra mim abertura e transaçao evitando de eu digitar
	// em.transaction.begin e tal
	@Transactional
	public void excluir(Perfil perfil) throws DAOException {//digo pro metodo que ele pode gerar uma exception

		try {
					Perfil perfil_excluir = buscarporid(perfil.getId());
		
					entityManager.remove(perfil_excluir);
		
				} catch (Exception causa) {
					
					throw new DAOException("erro ao excluir",causa);
					
		
				}

	}

			@SuppressWarnings("unchecked")
			@Override
			public List<Perfil> buscarperfil() {
		
				javax.persistence.Query consulta = entityManager
						.createQuery("SELECT p FROM Perfil p ORDER BY id");// jpql ver oque e essa  porra
																
				return consulta.getResultList();

				}

			@Override
			
			public Perfil buscarporid(Integer id) {
		
				return entityManager.find(Perfil.class, id);

	         }
	

			
					
	
	         }
			
			 


