package kundenverwaltung.service;

import javax.ejb.ApplicationException;
import javax.enterprise.context.Dependent;

import util.interceptor.Log;
import kundenverwaltung.domain.AbstractKunde;


@Log
@Dependent
@ApplicationException(rollback = true)
public class KundeDeleteBestellungException extends AbstractKundeServiceException {
	private static final long serialVersionUID = 2237194289969083093L;
	
	private static final String MESSAGE_KEY = "kunde.deleteMitBestellung";
	private final Long kundeId;
	private final int anzahlBestellungen;
	
	public KundeDeleteBestellungException(AbstractKunde kunde) {
		super("Kunde mit ID=" + kunde.getId() + " kann nicht geloescht werden: "
			  + kunde.getBestellungen().size() + " Bestellung(en)");
		this.kundeId = kunde.getId();
		this.anzahlBestellungen = kunde.getBestellungen().size();
	}

	public Long getKundeId() {
		return kundeId;
	}
	public int getAnzahlBestellungen() {
		return anzahlBestellungen;
	}
	
	@Override
	public String getMessageKey() {
		return MESSAGE_KEY;
	}
}
