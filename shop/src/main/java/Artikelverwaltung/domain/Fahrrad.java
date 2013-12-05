package Artikelverwaltung.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Fahrrad extends AbstractArtikel {
	private static final long serialVersionUID = 8523531902178696161L;

	@NotNull
	@Size(min = 2, max = 32 , message ="{fahrrad.bezeichnung.pattern}")
	@Pattern(regexp = "[A-ZÄÖÜ][a-zäöüß]+")
	private String bezeichnung;
	
	@NotNull
	@Size(min = 0, max = 32 , message ="{fahrrad.rahmen.pattern}")
	@Pattern(regexp = "[A-ZÄÖÜ][a-zäöüß]+")
	private String rahmen;

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getRahmen() {
		return rahmen;
	}

	public void setRahmen(String rahmen) {
		this.rahmen = rahmen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
		result = prime * result + ((rahmen == null) ? 0 : rahmen.hashCode());
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
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		if (rahmen == null) {
			if (other.rahmen != null)
				return false;
		} else if (!rahmen.equals(other.rahmen))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fahrrad [bezeichnung=" + bezeichnung + ", rahmen=" + rahmen
				+ "]";
	}

}
