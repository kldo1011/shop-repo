package Artikelverwaltung.domain;

import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Artikel 
{
	private URI artikelUri;
	private String bezeichnung;
	private int preis;
	private Long id;
	
	
	public Artikel(URI artikelUri, String bezeichnung, int preis, Long id) {
		super();
		this.artikelUri = artikelUri;
		this.bezeichnung = bezeichnung;
		this.preis = preis;
		this.id = id;
	}

	public URI getArtikelUri() {
		return artikelUri;
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

	public void setPreis(int preis) {
		this.preis = preis;
	}

	public int getPreis() {
		return preis;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Artikel [id=" + id + "]";
	}
	
	
	
	
	
	
}
