package Artikelverwaltung.service;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.jboss.logging.Logger;

import util.Mock;
import util.interceptor.Log;
import Artikelverwaltung.domain.AbstractArtikel;
import Artikelverwaltung.domain.Ersatzteile;
import Artikelverwaltung.domain.Fahrrad;

@Log
public class ArtikelService implements Serializable {
	private static final long serialVersionUID = 3330465848834099609L;
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	@PostConstruct
	private void postConstruct() {
		LOGGER.debugf("CDI-faehiges Bean %s wurde erzeugt", this);
	}
	
	@PreDestroy
	private void preDestroy() {
		LOGGER.debugf("CDI-faehiges Bean %s wird geloescht", this);
	}
		
	public AbstractArtikel findeArtikelById(Long id) {
		if (id == null) {
			return null;
		}
		// TODO Datenbanzugriffsschicht statt Mock
		final AbstractArtikel kunde = Mock.findArtikelById(id);
		return kunde;
	}
	
	public List<AbstractArtikel> findeAlleArtikel() {
		// TODO Datenbanzugriffsschicht statt Mock
		final List<AbstractArtikel> kunden = Mock.findAllArtikel();
		return kunden;
	}
	
	public  Fahrrad createFahrrad(Fahrrad fahrrad) {
		if (fahrrad == null) {
			return fahrrad;
		}
		
		//TODO Prüfen ob schon vorhanden

		fahrrad = Mock.createFahrrad(fahrrad);

		return fahrrad;
	}
	
	public  Ersatzteile createErsatzteile(Ersatzteile ersatzteile) {
		if (ersatzteile == null) {
			return ersatzteile;
		}

		//TODO Prüfen ob schon vorhanden
		
		ersatzteile = Mock.createErsatzteile(ersatzteile);

		return ersatzteile;
	}
	
	public <A extends AbstractArtikel> A updateArtikel(A artikel) {
		if (artikel == null) {
			return null;
		}
		
		//TODO Prüfen ob Artikel vorhanden
		
		// TODO Datenbanzugriffsschicht statt Mock
		Mock.updateArtikel(artikel);
		
		return artikel;
	}
	

}
