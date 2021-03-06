package br.com.fabricadeprogramador.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagemUtil {


	public static void mensagemInfo(String msg) {
		//carrega o contexto de facescontext com uma classe com objetos que mandam mensagem na tela
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg , null));
	}
	
	public static void mensagemErro(String msg ) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg , null));
	}
	
	public static void mensagemAviso(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, msg , null));
	}
}
