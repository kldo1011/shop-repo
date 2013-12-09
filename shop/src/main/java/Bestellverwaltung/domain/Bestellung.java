package Bestellverwaltung.domain;

import java.io.Serializable;
import java.net.URI;
import java.util.List;



import javax.validation.constraints.NotNull;



import javax.validation.constraints.AssertFalse;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import Kundenverwaltung.domain.AbstractKunde;
//test
@XmlRootElement
public class Bestellung implements Serializable {
	private static final long serialVersionUID = -4453553403647894462L;
	
	private Long id;
	

	@NotNull(message = "{Bestellverwaltung.bestellung.bestelldatum.notNull}")
	private String bestelldatum;


	

	@AssertFalse(message = "{Bestellverwaltung.bestellung.ausgeliefert.assertFalse}")
	private boolean ausgeliefert;
	
	private List<Position> positionen;
	@XmlTransient
	private AbstractKunde kunde;

	private URI kundeUri;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBestelldatum() {
		return bestelldatum;
	}

	public void setBestelldatum(String bestelldatum) {
		this.bestelldatum = bestelldatum;
	}

	public List<Position> getPositionen() {
		return positionen;
	}

	public void setPositionen(List<Position> positionen) {
		this.positionen = positionen;
	}

	public boolean isAusgeliefert() {
		return ausgeliefert;
	}

	public void setAusgeliefert(boolean ausgeliefert) {
		this.ausgeliefert = ausgeliefert;
	}

	public AbstractKunde getKunde() {
		return kunde;
	}

	public void setKunde(AbstractKunde kunde) {
		this.kunde = kunde;
	}

	public URI getKundeUri() {
		return kundeUri;
	}

	public void setKundeUri(URI kundeUri) {
		this.kundeUri = kundeUri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ausgeliefert ? 1231 : 1237);
		result = prime * result
				+ ((bestelldatum == null) ? 0 : bestelldatum.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kunde == null) ? 0 : kunde.hashCode());
		result = prime * result
				+ ((kundeUri == null) ? 0 : kundeUri.hashCode());
		result = prime * result
				+ ((positionen == null) ? 0 : positionen.hashCode());
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
		Bestellung other = (Bestellung) obj;
		if (ausgeliefert != other.ausgeliefert)
			return false;
		if (bestelldatum == null) {
			if (other.bestelldatum != null)
				return false;
		} 
		else if (!bestelldatum.equals(other.bestelldatum))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} 
		else if (!id.equals(other.id))
			return false;
		if (kunde == null) {
			if (other.kunde != null)
				return false;
		} 
		else if (!kunde.equals(other.kunde))
			return false;
		if (kundeUri == null) {
			if (other.kundeUri != null)
				return false;
		} 
		else if (!kundeUri.equals(other.kundeUri))
			return false;
		if (positionen == null) {
			if (other.positionen != null)
				return false;
		} 
		else if (!positionen.equals(other.positionen))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bestellung [id=" + id + ", ausgeliefert=" + ausgeliefert
				+ ", bestelldatum=" + bestelldatum + ", positionen="
				+ positionen + ", kunde=" + kunde + ", kundeUri=" + kundeUri
				+ "]";
	}

}
