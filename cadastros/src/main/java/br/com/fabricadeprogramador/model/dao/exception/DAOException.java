package br.com.fabricadeprogramador.model.dao.exception;

public class DAOException extends Exception {
	
	//aqui crio minhas exception que receberei dos meus metodos 
	//e inviarei uma mensagem e causa do tipo throwable que e uma mais generica
	//extendendo a exception que ja tem metodos para tratar erros 

	

//crio minhas excptions
	private static final long serialVersionUID = 1L;


public DAOException(String msg, Throwable causa) {
	
	super(msg,causa);

}

public DAOException(String msg) {
	
	super(msg);

}
public DAOException(Throwable causa) {
	
	super(causa);

}

}