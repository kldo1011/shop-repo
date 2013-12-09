package bestellverwaltung.domain;

import java.io.Serializable;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;



import org.hibernate.validator.constraints.NotEmpty;

import artikelverwaltung.domain.AbstractArtikel;

@XmlRootElement
public class Position implements Serializable{
	private static final long serialVersionUID = -8814289873349242733L;
	
	private Long id;
	private Long bestellid;
	
	@Valid
	private AbstractArtikel artikel;
	
    @NotEmpty(message="{bestellverwaltung.position.anzahl.notNull}")
	private int anzahl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBestellid() {
		return bestellid;
	}

	public void setBestellid(Long bestellid) {
		this.bestellid = bestellid;
	}

	public AbstractArtikel getArtikel() {
		return artikel;
	}

	public void setArtikel(AbstractArtikel artikel) {
		this.artikel = artikel;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anzahl;
		result = prime * result + ((artikel == null) ? 0 : artikel.hashCode());
		result = prime * result
				+ ((bestellid == null) ? 0 : bestellid.hashCode());
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
		Position other = (Position) obj;
		if (anzahl != other.anzahl)
			return false;
		if (artikel == null) {
			if (other.artikel != null)
				return false;
		} 
		else if (!artikel.equals(other.artikel))
			return false;
		if (bestellid == null) {
			if (other.bestellid != null)
				return false;
		} 
		else if (!bestellid.equals(other.bestellid))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} 
		else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", bestellid=" + bestellid + ", artikel="
				+ artikel + ", anzahl=" + anzahl + "]";
	}

}
