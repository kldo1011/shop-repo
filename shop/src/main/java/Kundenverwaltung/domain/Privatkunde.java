package Kundenverwaltung.domain;

import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Privatkunde extends AbstractKunde {
	
	private Set<Kategorie> kategorie;
	private Date geburtsdatum;
	public Set<Kategorie> getKategorie() {
		return kategorie;
	}
	public void setKategorie(Set<Kategorie> kategorie) {
		this.kategorie = kategorie;
	}
	public Date getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	@Override
	public String toString() {
		return "Privatkunde ["+super.toString()+"kategorie=" + kategorie + ", geburtsdatum="
				+ geburtsdatum + "]";
	}
	
	
}