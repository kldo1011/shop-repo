package Bestellverwaltung.service;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.jboss.logging.Logger;

import Bestellverwaltung.domain.Bestellung;

import util.Mock;
import util.interceptor.Log;
import util.rest.NotFoundException;

@Log
public class BestellungService implements Serializable{
	private static final long serialVersionUID = -48716630483597787L;
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	@PostConstruct
	private void postConstruct() {
		LOGGER.debugf("CDI-faehiges Bean %s wurde erzeugt", this);
	}
	
	@PreDestroy
	private void preDestroy() {
		LOGGER.debugf("CDI-faehiges Bean %s wird geloescht", this);
	}

	
	public Bestellung findBestellungById(Long id) {
		// TODO Anwendungskern statt Mock
		final Bestellung bestellung = Mock.findBestellungById(id);
		if (bestellung == null) {
			throw new NotFoundException("Keine Bestellung mit der ID " + id
					+ " gefunden.");
		}
		
		return bestellung;

	}


	public Bestellung createBestellung(Bestellung bestellung) {
		// TODO Anwendungskern statt Mock
		bestellung = Mock.createBestellung(bestellung);
		return bestellung;
	}

	public Bestellung updateBestellung(Bestellung bestellung) {
		if (bestellung == null) {
			return null;
		}
		//TODO Prüfen ob Bestellung schon vorhanden
		
		//TODO Anwendungskern statt Mock
		Mock.updateBestellung(bestellung);
		
		return bestellung;
		
	}

	public void deleteBestellung(Long id) {
		//TODO Anwendungskern statt Mock
		Mock.deleteBestellung(id);
	}

}
