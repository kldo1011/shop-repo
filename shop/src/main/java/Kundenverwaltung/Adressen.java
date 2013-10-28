package Kundenverwaltung;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Adressen {

	private int postleitzahl;
	private String ort;
	private String hausnummer;
	private String bundesland;
	private String land;

	public int getPostleitzahl() {
		return postleitzahl;
	}

	public void setPostleitzahl(int postleitzahl) {
		this.postleitzahl = postleitzahl;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	public String getBundesland() {
		return bundesland;
	}

	public void setBundesland(String bundesland) {
		this.bundesland = bundesland;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	@Override
	public String toString() {
		return "Adressen [postleitzahl=" + postleitzahl + ", ort=" + ort
				+ ", hausnummer=" + hausnummer + ", bundesland=" + bundesland
				+ ", land=" + land + "]";
	}

}
