package br.com.fabricadeprogramador.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fabricadeprogramador.model.entidade.Usuario;
import br.com.fabricadeprogramador.model.service.exception.Service_Exception;
import br.com.fabricadeprogramador.model.service.exception.UsuarioService;
import br.com.fabricadeprogramador.web.util.MensagemUtil;


//apos colocar a anotaçao controller configurar o no facesconfig.xml para oxhtml conseguir enxergar o controler 
//colocar o spring web no pom

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;// injeçao de dependecia do
											// usuarioservice

	private Usuario usuario; // abro classe privada gerando get e set instancia de usuario

	private List<Usuario> listaUsuarios;
	
	

	public UsuarioController() {

		// usuario=new Usuario();

		System.out.println("intanciando o usuariocontroller");

	}

	// o postconstruct serve para inicializar sempre o init para que sempre haja
	// uma lista sempre que iniciar
	@PostConstruct
	public void init() {

		usuario = new Usuario();

		listaUsuarios = usuarioService.buscarTodos();
	}

	public void salvar() { // esse metodo ja contem to string pra imprimir id
							// nome id tal

		try {

			usuarioService.salvar(usuario);

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

	public void excluir(Usuario usuario) throws Service_Exception {

		usuarioService.excluir(usuario);
		init();

	}
   
	
	public void alterar(Usuario usuario) throws Service_Exception {
		try {
			
			if(usuario !=null){

			usuarioService.alterar(usuario);
			
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
