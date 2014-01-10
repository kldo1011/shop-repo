package artikelverwaltung.service;

import javax.enterprise.context.Dependent;

import artikelverwaltung.domain.Artikel;
import util.cdi.MockService;
import util.interceptor.Log;


@MockService
@Dependent
@Log
public class ArtikelServiceMock extends ArtikelService {
	private static final long serialVersionUID = -2919310633845009282L;

	
	@Override
	public Artikel findArtikelById(Long id) {
		final Artikel artikel = new Artikel();
		artikel.setId(id);
		artikel.setBezeichnung("Bezeichnung" + id);
		return artikel;
	}
}
