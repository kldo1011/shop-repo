package bestellverwaltung.service;



import util.AbstractShopException;


public abstract class AbstractBestellungServiceException extends AbstractShopException {
	private static final long serialVersionUID = 5168577914947393904L;

	public AbstractBestellungServiceException(String msg) {
		super(msg);
	}
}
