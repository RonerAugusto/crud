package br.com.fabricadeprogramador.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Perfil;
import br.com.fabricadeprogramador.model.service.exception.PerfilService;
import br.com.fabricadeprogramador.model.service.exception.Service_Exception;
import br.com.fabricadeprogramador.web.util.MensagemUtil;


//apos colocar a anotaçao controller configurar o no facesconfig.xml para oxhtml conseguir enxergar o controler 
//colocar o spring web no pom

@Controller
public class PerfilController {

	@Autowired
	private PerfilService perfilService;// injeçao de dependecia do
											// usuarioservice
//pq nao gerou get e set ???

	private List<Perfil> listaPerfil;
	 

	private Perfil perfil;
	

	public PerfilController() {

		// usuario=new Usuario();

		System.out.println("intanciando o perfilcontroller");

	}

	// o postconstruct serve para inicializar sempre o init para que sempre haja
	// uma lista sempre que iniciar
	@PostConstruct
	public void init() throws DAOException {

		perfil = new Perfil();

		setListaPerfil(perfilService.buscarperfil());
	}

	public void salvar() throws DAOException { // esse metodo ja contem to string pra imprimir id
							// nome id tal

		try {

			perfilService.salvar(perfil);

			System.out.println();

			MensagemUtil.mensagemInfo("salvo com sucesso");// isso vai pra tela
			init(); // do usuario

		} catch (Service_Exception e) {

			// isso vai para
			// o console

			MensagemUtil.mensagemErro("nao foi possivel salvar \n"
					+ e.getMessage());

			// e.printStackTrace();
		}
	}

	public void excluir(Perfil perfil) throws Service_Exception, DAOException {

		perfilService.excluir(perfil);
		init();

	}
   
	
	public void alterar(Perfil perfil) throws Service_Exception, DAOException {
		try {
			
			if(perfil !=null){

			perfilService.alterar(perfil);
			
			}
			MensagemUtil.mensagemInfo("alterado com sucesso");// isso vai pra tela
			init(); // do usuario

		} catch (Service_Exception e) {

			// isso vai para
			// o console

			MensagemUtil.mensagemErro("nao foi possivel alterar \n"
					+ e.getMessage());

		
		}
		
		
		
		
		
		

	}

	public List<Perfil> getListaPerfil() {
		return listaPerfil;
	}

	public void setListaPerfil(List<Perfil> listaPerfil) {
		this.listaPerfil = listaPerfil;
	}

	

}
