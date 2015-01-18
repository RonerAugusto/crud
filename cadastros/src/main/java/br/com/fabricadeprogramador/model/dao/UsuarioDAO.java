package br.com.fabricadeprogramador.model.dao;

import java.util.List;

import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Usuario;
/**
 * Padrao do Objeto de acesso a dados Usuario
 * @author Virmerson
 *
 */
	public interface UsuarioDAO {
		void salvar(Usuario usuario) throws DAOException  ; 
		//nessa minha interface digo como ele deve salvar e digo que ele pode gerar uma 
		//exception do tipo throrwab tal tem de estar em todas as partes referentes ao metodo throws daoexception
		
		void excluir(Usuario usuario) throws DAOException;
		List<Usuario> buscartodos ();
		Usuario buscarporid (Integer id)throws DAOException;

		Usuario buscarporlogin(String login)throws DAOException;

		void alterar(Usuario usuario)  throws DAOException;

		
		
	}
