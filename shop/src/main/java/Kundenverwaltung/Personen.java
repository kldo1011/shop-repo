package Kundenverwaltung;

import java.util.Date;

public abstract class Personen {
	
	private String vorname;
	private String nachname;
	private Adressen adresse;
	private Date geburtsdatum;
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public Adressen getAdresse() {
		return adresse;
	}
	public void setAdresse(Adressen adresse) {
		this.adresse = adresse;
	}
	public Date getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	
	
	

}
