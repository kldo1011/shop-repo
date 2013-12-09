package bestellverwaltung.service;

import java.util.List;


import javax.enterprise.context.Dependent;

import util.interceptor.Log;
import bestellverwaltung.domain.Bestellung;
import kundenverwaltung.domain.AbstractKunde;

@Log
@Dependent
public interface BestellungService {
	
	Bestellung findBestellungById(Long id);
	List<Bestellung> findBestellungenByKunde(AbstractKunde kunde);
	Bestellung createBestellung(Bestellung bestellung);
	List<Bestellung> findAllBestellungen();
}
