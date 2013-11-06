package util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Bestellverwaltung.domain.Bestellung;
import Kundenverwaltung.domain.AbstractKunde;
import Kundenverwaltung.domain.Adressen;
import Kundenverwaltung.domain.Firmenkunde;
import Kundenverwaltung.domain.Kategorie;
import Kundenverwaltung.domain.Privatkunde;
import Artikelverwaltung.domain.Artikel;

public class Mock {
	private static final int MAX_ID = 99;
	private static final int MAX_KUNDEN = 8;
	private static final int MAX_BESTELLUNGEN = 4;
	private static final int MAX_ARTIKEL = 10;

	public static AbstractKunde findKundeById(Long id) {
		if (id > MAX_ID) {
			return null;
		}
		
		final AbstractKunde kunde;
		if(id%2==0) {
			
			kunde=new Privatkunde();
			((Privatkunde)kunde).setVorname("Hans");
			
		}
		else {
			kunde=new Firmenkunde();
			((Firmenkunde)kunde).setFirmenname("Benz");
		}
		kunde.setId(id);
		kunde.setNachname("Maier");
		
		final Adressen adresse = new Adressen();
		adresse.setId(id + 1);        // andere ID fuer die Adresse
		adresse.setPlz("12345");
		adresse.setOrt("Testort");
		adresse.setBundesland("BW");
		adresse.setHausnummer(4);
		adresse.setStrasse("TestStraﬂe");
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
	
	
	
	
	public static Privatkunde createPrivatkunde(Privatkunde pkunde) {
		
		final String nachname = pkunde.getNachname();
		pkunde.setId(Long.valueOf(nachname.length()));
		final Adressen adresse= pkunde.getAdresse();
		adresse.setId(Long.valueOf(nachname.length()));
		adresse.setKunde(pkunde);
		pkunde.setBestellungen(null);
		System.out.println("Neuer Kunde:"+pkunde);
		return pkunde;
		
	
	}
	
	public static Firmenkunde createFirmenkunde(Firmenkunde fkunde) {
		
		final String nachname=fkunde.getNachname();
		fkunde.setId(Long.valueOf(nachname.length()));
		final Adressen adresse= fkunde.getAdresse();
		adresse.setId(Long.valueOf(nachname.length()));
		adresse.setKunde(fkunde);
		fkunde.setBestellungen(null);
		System.out.println("Neuer Kunde:"+fkunde);
		return fkunde;
		
	}
	public static List<Bestellung> findBestellungenByKunde(AbstractKunde kunde) {
		// Beziehungsgeflecht zwischen Kunde und Bestellungen aufbauen
		final int anzahl = kunde.getId().intValue()% MAX_BESTELLUNGEN+1;  // 1, 2, 3 oder 4 Bestellungen
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

		final AbstractKunde kunde = findKundeById(id + 1);  // andere ID fuer den Kunden

		final Bestellung bestellung = new Bestellung();
		bestellung.setId(id);
		bestellung.setAusgeliefert(false);
		bestellung.setKunde(kunde);
		
		return bestellung;
	}



	public static void updateKunde(AbstractKunde kunde) {
		
		final AbstractKunde kundeAlt= findKundeById(kunde.getId());
		kundeAlt.setNachname(kunde.getNachname());
		kundeAlt.setAdresse(kunde.getAdresse());
		if(kunde.getId()%2 == 0) {
			((Privatkunde)kundeAlt).setVorname(((Privatkunde)kunde).getVorname());
			
		}
		else {
			((Firmenkunde)kundeAlt).setFirmenname(((Firmenkunde)kunde).getFirmenname());
			
		}
		System.out.println("Aktualisierter Kunde: " + kunde);
	}

	public static void deleteKunde(Long kundeId) {
		System.out.println("Kunde mit ID=" + kundeId + " geloescht");
	}

	public static Artikel findArtikelById(Long id) {
		final Artikel artikel = new Artikel();
		artikel.setId(id);
		artikel.setBezeichnung("Bezeichnung_" + id);
		artikel.setPreis(Long.valueOf(20));
		artikel.setLieferant("REX");
		return artikel;
	}
	
	public static List<Artikel> findArtikelByBezeichnung(String bezeichnung) {
		final int anzahl = bezeichnung.length();
		final List<Artikel> listArtikel = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Artikel artikel = findArtikelById(Long.valueOf(i));
			listArtikel.add(artikel);			
		}
		return listArtikel;
	}
	
	public static Artikel createArtikel(Artikel artikel) {
		final String bezeichnung = artikel.getBezeichnung();
		artikel.setId(Long.valueOf(bezeichnung.length()));
		
		System.out.println("Neuer Artikel: " + artikel);
		return artikel;
	}
	
	public static List<Artikel> findAllArtikel() {
		final int anzahl = MAX_ARTIKEL;
		final List<Artikel> listArtikel = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Artikel artikel = findArtikelById(Long.valueOf(i));
			listArtikel.add(artikel);			
		}
		return listArtikel;
	}
	
	public static void updateArtikel(Artikel artikel) {
		System.out.println("Aktualisierter Artikel: " + artikel);
	}
	
	public static void deleteArtikel(Long Id) {
		System.out.println("Artikel mit ID=" + Id + " geloescht");
	}
	
	private Mock() { /**/ }
	
	

}
