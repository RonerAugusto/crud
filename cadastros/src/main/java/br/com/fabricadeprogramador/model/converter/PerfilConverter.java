package br.com.fabricadeprogramador.model.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Perfil;
import br.com.fabricadeprogramador.model.service.exception.PerfilService;
@Component("perfilConverter")

public class PerfilConverter implements Converter {
     
	@Autowired
	private PerfilService perfilservice;
	@Override
	
	// recebo o objeto  inteiro
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		
		try {
			
			//recebo uma string da tela converto pra inteiro 
		return	perfilservice.buscarPorid(Integer.parseInt(value));
			
		} catch (NumberFormatException e) {
		
			return null;
		} catch (DAOException e) {
			
			return null;
		}
		
		
		
	
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		// aqui eu pego a string e converto para objeto e logo 
		//passo para cima para o getasobject um id para ele consultar no banco
		
		if(value instanceof Perfil ){ //se for uma instacia de perfil 
			
		Perfil perfil=(Perfil)value;    //pego o valor e tranformo num perfil 
			
		return perfil.getId().toString();
			
		//System.out.println(value);
		
		}
		return "";
	}

	public PerfilService getPerfilservice() {
		return perfilservice;
	}

	public void setPerfilservice(PerfilService perfilservice) {
		this.perfilservice = perfilservice;
	}

}
