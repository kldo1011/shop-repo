package Artikelverwaltung.domain;

import java.net.URI;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Fahrrad extends Artikel
{
	private URI artikelUri;
	private String rahmen;
	private String farbe;
	private String hersteller;
	private int rahmengr��e;
	
	@Override
	public URI getArtikelUri() {
		return artikelUri;
	}
	@Override
	public void setArtikelUri(URI fahrradUri) {
		this.artikelUri = fahrradUri;
	}
	public String getRahmen() {
		return rahmen;
	}
	public void setRahmen(String rahmen) {
		this.rahmen = rahmen;
	}
	public String getFarbe() {
		return farbe;
	}
	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}
	public String getHersteller() {
		return hersteller;
	}
	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}
	public int getRahmengr��e() {
		return rahmengr��e;
	}
	public void setRahmengr��e(int rahmengr��e) {
		this.rahmengr��e = rahmengr��e;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((farbe == null) ? 0 : farbe.hashCode());
		result = prime * result
				+ ((hersteller == null) ? 0 : hersteller.hashCode());
		result = prime * result + ((rahmen == null) ? 0 : rahmen.hashCode());
		result = prime * result + rahmengr��e;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fahrrad other = (Fahrrad) obj;
		if (farbe == null) {
			if (other.farbe != null)
				return false;
		} else if (!farbe.equals(other.farbe))
			return false;
		if (hersteller == null) {
			if (other.hersteller != null)
				return false;
		} else if (!hersteller.equals(other.hersteller))
			return false;
		if (rahmen == null) {
			if (other.rahmen != null)
				return false;
		} else if (!rahmen.equals(other.rahmen))
			return false;
		if (rahmengr��e != other.rahmengr��e)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Fahrrad [rahmen=" + rahmen + ", farbe=" + farbe
				+ ", hersteller=" + hersteller + ", rahmengr��e=" + rahmengr��e
				+ "]";
	}

	

}
