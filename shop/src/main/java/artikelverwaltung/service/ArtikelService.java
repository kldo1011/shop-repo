package artikelverwaltung.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.validation.constraints.NotNull;

import util.Mock;
import util.interceptor.Log;
import artikelverwaltung.domain.AbstractArtikel;
import artikelverwaltung.domain.Ersatzteil;
import artikelverwaltung.domain.Fahrrad;

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
	
	@NotNull(message = "{artikel.notFound.all}")
	public List<AbstractArtikel> findeAlleArtikel() {
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findAllArtikel();
		
	}
	
	public  Fahrrad createFahrrad(Fahrrad fahrrad) {
		

		
		//TODO Prüfen ob schon vorhanden

		return Mock.createFahrrad(fahrrad);

		
	}
	
	public  Ersatzteil createErsatzteile(Ersatzteil ersatzteil) {


		//TODO Prüfen ob schon vorhanden
		
		return Mock.createErsatzteile(ersatzteil);

		
	}
	
  public void updateArtikel (AbstractArtikel artikel) {
	  
	  Mock.updateArtikel(artikel);
  }
	

}
