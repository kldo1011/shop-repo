package bestellverwaltung.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import bestellverwaltung.domain.Bestellung;
import kundenverwaltung.domain.AbstractKunde;
import util.Mock;
import util.interceptor.Log;

@Dependent
@Log
public class BestellungServiceImpl implements BestellungService, Serializable {


	private static final long serialVersionUID = 1227089317428319158L;
	
	@Inject
	@NeueBestellung
	private transient Event<Bestellung> event;
	
	private static final int MAX_BESTELLUNGEN=10;
	
   @Override
   @NotNull(message = "{bestellung.notFound.id}")
   public Bestellung findBestellungById(Long id) {
	
	   return Mock.findBestellungById(id);
   
   }
   
   @Override
   @Size(min = 1, message = "{bestellung.notFound.kunde}")
   public List<Bestellung> findBestellungenByKunde(AbstractKunde kunde) {
           // TODO Datenbanzugriffsschicht statt Mock
           return Mock.findBestellungenByKunde(kunde);
   }
   
   @Override
   public List<Bestellung> findAllBestellungen() {
           final int anzahl = MAX_BESTELLUNGEN;
           final List<Bestellung> bestellungList = new ArrayList<>(anzahl);
           for (int i = 1; i <= anzahl; i++) {
                   final Bestellung bestellung = Mock.findBestellungById(Long.valueOf(i));
                   bestellungList.add(bestellung);
           }
           return bestellungList;
   }
   
   @Override
   public Bestellung createBestellung(Bestellung bestellung) {
           // TODO Datenbanzugriffsschicht statt Mock
           bestellung = Mock.createBestellung(bestellung);
           event.fire(bestellung);
           
           return bestellung;
   }
	
	
	
	

}