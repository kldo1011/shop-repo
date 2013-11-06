package Artikelverwaltung.domain;

import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Artikel {
	private URI artikelUri;
	private String bezeichnung;
	private Long preis;
	private Long id;
	private String lieferant;

	public URI getArtikelUri() {
		return artikelUri;
	}

	@Override
	public String toString() {
		return "Artikel [artikelUri=" + artikelUri + ", bezeichnung="
				+ bezeichnung + ", preis=" + preis + ", id=" + id
				+ ", lieferant=" + lieferant + "]";
	}

	public void setLieferant(String lieferant) {
		this.lieferant = lieferant;
	}

	public void setArtikelUri(URI artikelUri) {
		this.artikelUri = artikelUri;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public void setPreis(Long preis) {
		this.preis = preis;
	}

	public Long getPreis() {
		return preis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLieferant() {
		return lieferant;
<<<<<<< HEAD
=======
	}

	public void setLieferant(String lieferant) {
		this.lieferant = lieferant;
>>>>>>> branch 'master' of https://github.com/kldo1011/shop-repo.git
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((artikelUri == null) ? 0 : artikelUri.hashCode());
		result = prime * result
				+ ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lieferant == null) ? 0 : lieferant.hashCode());
		result = prime * result + ((preis == null) ? 0 : preis.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artikel other = (Artikel) obj;
		if (artikelUri == null) {
			if (other.artikelUri != null)
				return false;
		} else if (!artikelUri.equals(other.artikelUri))
			return false;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lieferant == null) {
			if (other.lieferant != null)
				return false;
		} else if (!lieferant.equals(other.lieferant))
			return false;
		if (preis == null) {
			if (other.preis != null)
				return false;
		} else if (!preis.equals(other.preis))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artikel [artikelUri=" + artikelUri + ", bezeichnung="
				+ bezeichnung + ", preis=" + preis + ", id=" + id
				+ ", lieferant=" + lieferant + "]";
	}
	
	
	
}
