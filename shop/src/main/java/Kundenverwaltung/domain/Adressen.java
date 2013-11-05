package Kundenverwaltung.domain;


import javax.xml.bind.annotation.XmlTransient;




public class Adressen  {

	
	
	
	private String plz;
	private String ort;
	private int hausnummer;
	private String bundesland;
	@XmlTransient
	private AbstractKunde kunde;
	
	public AbstractKunde getKunde() {
		return kunde;
	}
	public void setKunde(AbstractKunde kunde) {
		this.kunde = kunde;
	}

	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public int getHausnummer() {
		return hausnummer;
	}
	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}
	public String getBundesland() {
		return bundesland;
	}
	public void setBundesland(String bundesland) {
		this.bundesland = bundesland;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bundesland == null) ? 0 : bundesland.hashCode());
		result = prime * result + hausnummer;
		result = prime * result + ((ort == null) ? 0 : ort.hashCode());
		result = prime * result + ((plz == null) ? 0 : plz.hashCode());
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
		if (bundesland == null) {
			if (other.bundesland != null)
				return false;
		} else if (!bundesland.equals(other.bundesland))
			return false;
		if (hausnummer != other.hausnummer)
			return false;
		
		if (ort == null) {
			if (other.ort != null)
				return false;
		} else if (!ort.equals(other.ort))
			return false;
		if (plz == null) {
			if (other.plz != null)
				return false;
		} else if (!plz.equals(other.plz))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Adressen [plz=" + plz + ", ort=" + ort
				+ ", hausnummer=" + hausnummer + ", bundesland=" + bundesland
				+ "]";
	}
	

	
	
	
}
