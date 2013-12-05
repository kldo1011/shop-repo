package Artikelverwaltung.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.validation.constraints.NotNull;

import util.Mock;
import util.interceptor.Log;
import Artikelverwaltung.domain.AbstractArtikel;
import Artikelverwaltung.domain.Ersatzteile;
import Artikelverwaltung.domain.Fahrrad;

@Dependent
@Log
public class ArtikelService implements Serializable {
	private static final long serialVersionUID = 3330465848834099609L;
	
	@NotNull(message = "{artikel.notFound.id}")
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
