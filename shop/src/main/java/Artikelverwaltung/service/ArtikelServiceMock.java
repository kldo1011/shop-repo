package Artikelverwaltung.service;

import static javax.interceptor.Interceptor.Priority.APPLICATION;

import javax.annotation.Priority;

import Artikelverwaltung.domain.Artikel;
import util.cdi.MockService;
import util.interceptor.Log;

@MockService
@Priority(APPLICATION + 100)
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

