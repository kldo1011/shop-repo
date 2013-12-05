package Kundenverwaltung.service;


import util.AbstractShopException;

public abstract class AbstractKundeServiceException extends AbstractShopException {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7615074349793955652L;

	public AbstractKundeServiceException(String msg) {
		super(msg);
	}
	
	public AbstractKundeServiceException(String msg, Throwable t) {
		super(msg, t);
	}
}
