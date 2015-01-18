package br.com.fabricadeprogramador.model.service.exception;


public class Service_Exception extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Service_Exception(String msg) {
		super(msg);
		
	}

	public Service_Exception(String msg,Throwable causa) {
		super(msg,causa);
	
	}

	public Service_Exception(Throwable causa) {
		super(causa);
	
	

}
}