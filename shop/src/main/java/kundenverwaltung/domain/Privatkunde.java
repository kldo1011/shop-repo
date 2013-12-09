package kundenverwaltung.domain;

import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Privatkunde extends AbstractKunde {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4816467594027084622L;
	
	@NotNull(message = "{kundenverwaltung.privatkunde.vorname.notNull}")
    @Size(min = 2, max = 32, message = "{kundenverwaltung.privatkunde.vorname.size}")
    @Pattern(regexp = "[A-Z\u00C4\u00D6\u00DC][a-z\u00E4\u00F6\u00FC\u00DF]+",
    message = "{kundenverwaltung.privatkunde.vorname.pattern}")
    private String vorname;

	private Set<Kategorie> kategorie;

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Set<Kategorie> getKategorie() {
		return kategorie;
	}

	public void setKategorie(Set<Kategorie> kategorie) {
		this.kategorie = kategorie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((kategorie == null) ? 0 : kategorie.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
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
		Privatkunde other = (Privatkunde) obj;
		if (kategorie == null) {
			if (other.kategorie != null)
				return false;
		} 
		else if (!kategorie.equals(other.kategorie))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} 
		else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Privatkunde [vorname=" + vorname + ", kategorie=" + kategorie
				+ "]";
	}

}
