package Bestellverwaltung.service;

import java.util.List;
import java.util.Locale;

import Bestellverwaltung.domain.Bestellung;
import Kundenverwaltung.domain.AbstractKunde;

public interface BestellungService {
	
	Bestellung findBestellungById(Long id);
	List<Bestellung> findBestellungenByKunde(AbstractKunde kunde);
	Bestellung createBestellung(Bestellung bestellung, AbstractKunde kunde, Locale locale);

}
