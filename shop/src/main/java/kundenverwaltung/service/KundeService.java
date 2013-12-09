package kundenverwaltung.service;
import java.io.Serializable;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_XML;

import javax.enterprise.context.Dependent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Produces;

import util.Mock;
import util.interceptor.Log;
import kundenverwaltung.domain.AbstractKunde;
import kundenverwaltung.domain.Firmenkunde;
import kundenverwaltung.domain.Privatkunde;

@Dependent
@Log
@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75",
    TEXT_XML + ";qs=0.5" })
public class KundeService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1270405445685064366L;

    public static final String KUNDE_NOT_FOUND = "kunde.notFound.all";
    public static final String KUNDE_NOT_FOUND_ID = "kunde.notFound.id";
    public static final String KUNDE_NOT_FOUND_NACHNAME = "kunde.notFound.nachname";
    public static final String KUNDE_NOT_FOUND_MAIL = "kunde.notFound.email";

	@NotNull(message = KUNDE_NOT_FOUND_ID)
	public AbstractKunde findKundeById(Long id) {
		if (id == null) {
			return null;
		}
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findKundeById(id);
	}

	@NotNull(message = KUNDE_NOT_FOUND_MAIL)
	public AbstractKunde findKundeByEmail(String email) {
		if (email == null) {
			return null;
		}
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findKundeByEmail(email);
	}
	
    @NotNull(message=KUNDE_NOT_FOUND)
	public List<AbstractKunde> findAllKunden() {
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findAllKunden();
	}

	@Size(min = 1, message = KUNDE_NOT_FOUND_NACHNAME)
	public List<AbstractKunde> findKundenByNachname(String nachname) {
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findKundenByNachname(nachname);
	}
	
    public Firmenkunde createFirmenkunde(Firmenkunde kunde) {
        if (kunde == null) {
                return kunde;
        }

        // Pruefung, ob die Email-Adresse schon existiert
        // TODO Datenbanzugriffsschicht statt Mock
//        if (findKundeByEmail(kunde.getEmail()) != null) {
//                throw new EmailExistsException(kunde.getEmail());
//        }

        kunde = Mock.createFirmenkunde(kunde);

        return kunde;
}

public Privatkunde createPrivatkunde(Privatkunde kunde) {
        if (kunde == null) {
                return kunde;
        }

        // Pruefung, ob die Email-Adresse schon existiert
        // TODO Datenbanzugriffsschicht statt Mock
//        if (findKundeByEmail(kunde.getEmail()) != null) {
//                throw new EmailExistsException(kunde.getEmail());
//        }

        kunde = Mock.createPrivatkunde(kunde);

        return kunde;
}
	
	
	
/*
	public <T extends AbstractKunde> T createKunde(T kunde) {
		if (kunde == null) {
			return kunde;
		}

		final AbstractKunde tmp = findKundeByEmail(kunde.getEmail()); // Kein
																		// Aufruf
																		// als
																		// Business-Methode
		if (tmp != null) {
			throw new EmailExistsException(kunde.getEmail());
		}
		// TODO Datenbanzugriffsschicht statt Mock
		kunde = Mock.createKunde(kunde);

		return kunde;
	}
	*/

	public <T extends AbstractKunde> T updateKunde(T kunde) {
		if (kunde == null) {
			return null;
		}

		// Pruefung, ob die Email-Adresse schon existiert
		final AbstractKunde vorhandenerKunde = findKundeByEmail(kunde
				.getEmail()); // Kein Aufruf als Business-Methode
		if (vorhandenerKunde != null) {
			// Gibt es die Email-Adresse bei einem anderen, bereits vorhandenen
			// Kunden?
			if (vorhandenerKunde.getId().longValue() != kunde.getId()
					.longValue()) {
				throw new EmailExistsException(kunde.getEmail());
			}
		}

		// TODO Datenbanzugriffsschicht statt Mock
		Mock.updateKunde(kunde);

		return kunde;
	}

	public void deleteKunde(Long kundeId) {
		AbstractKunde kunde = findKundeById(kundeId); // Kein Aufruf als
														// Business-Methode
		if (kunde == null) {
			return;
		}

		// Gibt es Bestellungen?
		if (!kunde.getBestellungen().isEmpty()) {
			throw new KundeDeleteBestellungException(kunde);
		}

		// TODO Datenbanzugriffsschicht statt Mock
		Mock.deleteKunde(kunde);
	}

}
