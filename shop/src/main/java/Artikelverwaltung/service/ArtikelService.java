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
		return Mock.findArtikelById(id);
		
	}
	
	@NotNull(message="{artikel.notFound.all}")
	public List<AbstractArtikel> findeAlleArtikel() {
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findAllArtikel();
		
	}
	
	public  Fahrrad createFahrrad(Fahrrad fahrrad) {
		

		
		//TODO Prüfen ob schon vorhanden

		return Mock.createFahrrad(fahrrad);

		
	}
	
	public  Ersatzteile createErsatzteile(Ersatzteile ersatzteile) {


		//TODO Prüfen ob schon vorhanden
		
		return Mock.createErsatzteile(ersatzteile);

		
	}
	
  public void updateArtikel (AbstractArtikel artikel) {
	  
	  Mock.updateArtikel(artikel);
  }
	

}
