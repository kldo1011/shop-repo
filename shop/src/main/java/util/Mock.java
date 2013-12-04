package util;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jboss.logging.Logger;

import Bestellverwaltung.domain.Bestellung;
import Bestellverwaltung.domain.Position;
import Kundenverwaltung.domain.AbstractKunde;
import Kundenverwaltung.domain.Adressen;
import Kundenverwaltung.domain.Firmenkunde;
import Kundenverwaltung.domain.Kategorie;
import Kundenverwaltung.domain.Privatkunde;
import Artikelverwaltung.domain.AbstractArtikel;
import Artikelverwaltung.domain.Ersatzteile;
import Artikelverwaltung.domain.Fahrrad;


public class Mock {
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	private static final int MAX_ID = 99;
	private static final int MAX_KUNDEN = 8;
	private static final int MAX_BESTELLUNGEN = 4;
	private static final int MAX_ARTIKEL = 10;
	private static final int MAX_POSITIONEN = 10;

	public static AbstractKunde findKundeById(Long id) {
		if (id > MAX_ID) {
			return null;
		}

		final AbstractKunde kunde;
		if (id % 2 == 0) {

			kunde = new Privatkunde();
			((Privatkunde) kunde).setVorname("Hans");

		} else
		{
			kunde = new Firmenkunde();
			((Firmenkunde) kunde).setFirmenname("Benz");
		}
		kunde.setId(id);
		kunde.setNachname("Maier");

		final Adressen adresse = new Adressen();
		adresse.setId(id + 1); // andere ID fuer die Adresse
		adresse.setPlz("12345");
		adresse.setOrt("Testort");
		adresse.setHausnummer(4);
		adresse.setStrasse("TestStrasse");
		kunde.setAdresse(adresse);
		if (kunde.getClass().equals(Privatkunde.class)) {
			final Privatkunde privatkunde = (Privatkunde) kunde;
			final Set<Kategorie> kategorie = new HashSet<>();
			kategorie.add(Kategorie.ELEKTRO);
			kategorie.add(Kategorie.MOUNTAINBIKE);
			privatkunde.setKategorie(kategorie);
		}

		return kunde;
	}

	public static List<AbstractKunde> findAllKunden() {
		final int anzahl = MAX_KUNDEN;
		final List<AbstractKunde> kunden = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final AbstractKunde kunde = findKundeById(Long.valueOf(i));
			kunden.add(kunde);
		}
		return kunden;
	}

	public static List<AbstractKunde> findKundenByNachname(String nachname) {
		final int anzahl = nachname.length();
		final List<AbstractKunde> kunden = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final AbstractKunde kunde = findKundeById(Long.valueOf(i));
			kunde.setNachname(nachname);
			kunden.add(kunde);
		}
		return kunden;
	}
	
	
	
	public static AbstractKunde findKundeByEmail(String email) {
		if (email.startsWith("x")) {
			return null;
		}
		
		final AbstractKunde kunde = email.length() % 2 == 1 ? new Privatkunde() : new Firmenkunde();
		kunde.setId(Long.valueOf(email.length()));
		kunde.setNachname("Nachname");
		kunde.setEmail(email);
		
		final Adressen adresse = new Adressen();
		adresse.setId(kunde.getId() + 1);        // andere ID fuer die Adresse
		adresse.setPlz("12345");
		adresse.setOrt("Testort");
		adresse.setKunde(kunde);
		kunde.setAdresse(adresse);
		
		if (kunde.getClass().equals(Privatkunde.class)) {
			final Privatkunde privatkunde = (Privatkunde) kunde;
			final Set<Kategorie> kategorie = new HashSet<>();
			kategorie.add(Kategorie.ELEKTRO);
			kategorie.add(Kategorie.MOUNTAINBIKE);
			privatkunde.setKategorie(kategorie);
		}
		
		return kunde;
	}
	
	public static <T extends AbstractKunde> T createKunde(T kunde) {
		// Neue IDs fuer Kunde und zugehoerige Adresse
		// Ein neuer Kunde hat auch keine Bestellungen
		final String nachname = kunde.getNachname();
		kunde.setId(Long.valueOf(nachname.length()));
		final Adressen adresse = kunde.getAdresse();
		adresse.setId((Long.valueOf(nachname.length())) + 1);
		adresse.setKunde(kunde);
		kunde.setBestellungen(null);
		
		LOGGER.infof("Neuer Kunde: %s", kunde);
		return kunde;
	}
	
	
/*
	public static Privatkunde createPrivatkunde(Privatkunde pkunde) {

		final String nachname = pkunde.getNachname();
		pkunde.setId(Long.valueOf(nachname.length()));
		final Adressen adresse = pkunde.getAdresse();
		adresse.setId(Long.valueOf(nachname.length()));
		System.out.println("Neuer Kunde:" + pkunde);
		return pkunde;

	}

	public static Firmenkunde createFirmenkunde(Firmenkunde fkunde) {

		final String nachname = fkunde.getNachname();
		fkunde.setId(Long.valueOf(nachname.length()));
		final Adressen adresse = fkunde.getAdresse();
		adresse.setId(Long.valueOf(nachname.length()));
		System.out.println("Neuer Kunde:" + fkunde);
		return fkunde;

	}
	*/
/*
	public static void updateKunde(AbstractKunde kunde) {


		final AbstractKunde kundeAlt = findKundeById(kunde.getId());
		kundeAlt.setNachname(kunde.getNachname());
		kundeAlt.setAdresse(kunde.getAdresse());
		if (kunde.getId() % 2 == 0) {
			((Privatkunde) kundeAlt).setVorname(((Privatkunde) kunde)
					.getVorname());

		} else 
		{
			((Firmenkunde) kundeAlt).setFirmenname(((Firmenkunde) kunde)
					.getFirmenname());

		}
		System.out.println("Aktualisierter Kunde: " + kunde);
	}*/
	
	public static void updateKunde(AbstractKunde kunde) {
		
		LOGGER.infof("Aktualisierter Kunde: %s", kunde);
	}

	public static void deleteKunde(AbstractKunde kunde) {
		LOGGER.infof("Geloeschter Kunde: %s", kunde);
	}

	public static List<Bestellung> findBestellungenByKunde(AbstractKunde kunde) {
		// Beziehungsgeflecht zwischen Kunde und Bestellungen aufbauen
		final int anzahl = kunde.getId().intValue() % MAX_BESTELLUNGEN + 1; // 1,
																			// 2,
																			// 3
																			// oder
																			// 4
																			// Bestellungen
		final List<Bestellung> bestellungen = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Bestellung bestellung = findBestellungById(Long.valueOf(i));
			bestellung.setKunde(kunde);
			bestellungen.add(bestellung);
		}
		kunde.setBestellungen(bestellungen);

		return bestellungen;
	}

	public static Bestellung findBestellungById(Long id) {
		if (id > MAX_ID) {
			return null;
		}

		final AbstractKunde kunde = findKundeById(id + 1); // andere ID fuer den
															// Kunden

		final Bestellung bestellung = new Bestellung();
		bestellung.setId(id);
		bestellung.setBestelldatum("06.11.13");
		bestellung.setAusgeliefert(false);
		bestellung.setKunde(kunde);

		return bestellung;
	}

	public static List<Bestellung> findAllBestellungen() {

		final int anzahl = MAX_BESTELLUNGEN;
		final List<Bestellung> bestellungsList = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Bestellung bestellung = findBestellungById(Long.valueOf(i));
			bestellungsList.add(bestellung);

		}
		return bestellungsList;

	}

	public static Position findPositionById(long id, long bestellid) {
		if (id > MAX_ID) {
			return null;
		}

		final Position position = new Position();
		position.setId(id);
		position.setAnzahl((int) id + 3);
		position.setArtikel(findArtikelById(id));
		position.setBestellid(bestellid);
		return position;

	}

	public static List<Position> findAllPositionen(Long id) {

		final int anzahl = MAX_POSITIONEN;
		final List<Position> positionList = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Position position = findPositionById(i, id);
			positionList.add(position);
		}
		return positionList;

	}
      /*
	public static Bestellung createBestellung(Bestellung bestellung) {

		final int nummer = bestellung.getBestelldatum().hashCode();
		bestellung.setId(Long.valueOf(nummer));
		System.out.println("Neue Bestellung:" + bestellung);
		return bestellung;
	}
*/
	
	public static Bestellung createBestellung(Bestellung bestellung, AbstractKunde kunde) {
		LOGGER.infof("Neue Bestellung: %s fuer Kunde: %s", bestellung, kunde);
		return bestellung;
	}
	
	public static AbstractArtikel findArtikelById(Long id) {
		if (id > MAX_ARTIKEL) {
			return null;
		}
		final AbstractArtikel artikel;

		if (id % 2 == 0) {

			artikel = new Fahrrad();

			artikel.setTyp("Rennrad");
			((Fahrrad) artikel).setRahmen("Carbon");
			((Fahrrad) artikel).setBezeichnung("Cube");
		}

		else {

			artikel = new Ersatzteile();
			artikel.setTyp("Bremse");
		}

		artikel.setId(id);
		artikel.setPreis(821.41);
		return artikel;
	}

	
	public static List<AbstractArtikel> findAllArtikel() {

		final int anzahl = MAX_ARTIKEL;
		final List<AbstractArtikel> artikelList = new ArrayList<>(anzahl);

		for (int i = 1; i <= anzahl; i++) {
			final AbstractArtikel artikel = findArtikelById(Long.valueOf(i));
			artikelList.add(artikel);
		}
		return artikelList;
	}

	public static Fahrrad createFahrrad(Fahrrad fahrrad) {

		final String bezeichnung = fahrrad.getBezeichnung();
		fahrrad.setId(bezeichnung.length());
		System.out.println("Neues Fahrrad" + fahrrad);
		return fahrrad;
	}

	public static Ersatzteile createErsatzteile(Ersatzteile ersatz) {

		final String typ = ersatz.getTyp();
		ersatz.setId(typ.length());
		System.out.println("Neues Ersatzteil" + ersatz);
		return ersatz;
	}

	public static void updateArtikel(AbstractArtikel artikel) {

		final AbstractArtikel artikelAlt = findArtikelById(artikel.getId());
		artikelAlt.setPreis(artikel.getPreis());
		artikelAlt.setTyp(artikel.getTyp());
		if (artikel.getId() % 2 == 0) {

			((Fahrrad) artikelAlt).setBezeichnung(((Fahrrad) artikel)
					.getBezeichnung());
			((Fahrrad) artikelAlt).setRahmen(((Fahrrad) artikel).getRahmen());
		} else 
		{

			((Ersatzteile) artikelAlt).setFahrrad(((Ersatzteile) artikel)
					.getFahrrad());
		}
		
		System.out.println("Aktualisierter Artikel  " + artikel);

	}

	public static void updateBestellung(Bestellung bestellung) {
		System.out.println("Aktualisierte Bestellung: " + bestellung);
	}

	public static void deleteBestellung(Long id) {
		System.out.println("Bestellung mit ID=" + id + " geloescht");
	}

	private Mock() { /**/
	}

}
