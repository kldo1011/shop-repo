package bestellverwaltung.service;

import javax.enterprise.context.Dependent;

import util.AbstractShopException;
import util.interceptor.Log;

@Log
@Dependent
public abstract class AbstractBestellungServiceException extends AbstractShopException {
  

        /**
	 * 
	 */
	private static final long serialVersionUID = 2487454948182083792L;

		public AbstractBestellungServiceException(String msg) {
                super(msg);
        }
        
        public AbstractBestellungServiceException(String msg, Throwable t) {
                super(msg, t);
        }
}
