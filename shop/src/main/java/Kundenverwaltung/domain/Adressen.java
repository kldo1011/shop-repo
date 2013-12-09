package Kundenverwaltung.domain;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Adressen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3918745441308095708L;

	private Long id;
	
    @NotNull (message = "{Kundenverwaltung.adressen.plz.notNull}")
    @Pattern(regexp = "\\d{5}", message = "{Kundenverwaltung.adressen.plz.pattern}")
	private String plz;

    @Size(min = 1, max = 4, message = "{Kundenverwaltung.adressen.length}")
    @Pattern(regexp = "[1-9][0-9]{0,2}[a-z]?", message = "{Kundenverwaltung.adressen.hausnummer.pattern}")
	private int hausnummer;

	@Pattern(regexp = "[A-Z\u00C4\u00D6\u00DC][a-z\u00E4\u00F6\u00FC\u00DF]+", message = "{Kundenverwaltung.adressen.strasse.pattern}")
	@Size(min = 2, max = 40, message = "{Kundenverwaltung.adressen.strasse.length}")
	private String strasse;

    @Size(min = 1, max = 32, message = "{Kundenverwaltung.adressen.ort.length}")
    @Pattern(regexp = "[A-Z\u00C4\u00D6\u00DC][a-z\u00E4\u00F6\u00FC\u00DF]+"
                    + "(-[A-Z\u00C4\u00D6\u00DC][a-z\u00E4\u00F6\u00FC\u00DF]+)?",
                    message = "{Kundenverwaltung.adressen.ort.pattern}")
	private String ort;

	
	@Valid
	
	private AbstractKunde kunde;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public int getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}
	

	public AbstractKunde getKunde() {
		return kunde;
	}

	public void setKunde(AbstractKunde kunde) {
		this.kunde = kunde;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hausnummer;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kunde == null) ? 0 : kunde.hashCode());
		result = prime * result + ((ort == null) ? 0 : ort.hashCode());
		result = prime * result + ((plz == null) ? 0 : plz.hashCode());
		result = prime * result + ((strasse == null) ? 0 : strasse.hashCode());
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
		Adressen other = (Adressen) obj;
		if (hausnummer != other.hausnummer)
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
		if (ort == null) {
			if (other.ort != null)
				return false;
		} 
		else if (!ort.equals(other.ort))
			return false;
		if (plz == null) {
			if (other.plz != null)
				return false;
		} 
		else if (!plz.equals(other.plz))
			return false;
		if (strasse == null) {
			if (other.strasse != null)
				return false;
		} 
		else if (!strasse.equals(other.strasse))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Adressen [id=" + id + ", plz=" + plz + ", hausnummer="
				+ hausnummer + ", strasse=" + strasse + ", ort=" + ort
				+ ", kunde=" + kunde + "]";
	}

}
