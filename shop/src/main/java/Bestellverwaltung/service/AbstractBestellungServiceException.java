package Bestellverwaltung.service;

import javax.enterprise.context.Dependent;

import util.AbstractShopException;
import util.interceptor.Log;

@Log
@Dependent
public abstract class AbstractBestellungServiceException extends AbstractShopException {
        private static final long serialVersionUID = -2849585609393128387L;

        public AbstractBestellungServiceException(String msg) {
                super(msg);
        }
        
        public AbstractBestellungServiceException(String msg, Throwable t) {
                super(msg, t);
        }
}