package Bestellverwaltung.service;

import java.util.List;


import javax.enterprise.context.Dependent;

import util.interceptor.Log;
import Bestellverwaltung.domain.Bestellung;
import Kundenverwaltung.domain.AbstractKunde;

@Log
@Dependent
public interface BestellungService {
	
	Bestellung findBestellungById(Long id);
	List<Bestellung> findBestellungenByKunde(AbstractKunde kunde);
	Bestellung createBestellung(Bestellung bestellung);
	List<Bestellung> findAllBestellungen();
}
