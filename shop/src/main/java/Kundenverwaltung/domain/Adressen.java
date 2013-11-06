package Kundenverwaltung.domain;


import javax.xml.bind.annotation.XmlTransient;




public class Adressen  {

	
	
	private Long id;
	private String plz;
	private String ort;
	private int hausnummer;
	private String bundesland;
	private String strasse;
	@XmlTransient
	private AbstractKunde kunde;
	
	public AbstractKunde getKunde() {
		return kunde;
	}
	
	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public void setKunde(AbstractKunde kunde) {
		this.kunde = kunde;
	}
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
		if (bundesland == null) {
			if (other.bundesland != null)
				return false;
		} else if (!bundesland.equals(other.bundesland))
			return false;
		if (hausnummer != other.hausnummer)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kunde == null) {
			if (other.kunde != null)
				return false;
		} else if (!kunde.equals(other.kunde))
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
		if (strasse == null) {
			if (other.strasse != null)
				return false;
		} else if (!strasse.equals(other.strasse))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Adressen [id=" + id + ", plz=" + plz + ", ort=" + ort
				+ ", hausnummer=" + hausnummer + ", bundesland=" + bundesland
				+ ", strasse=" + strasse + ", kunde=" + kunde + "]";
	}
	

	
	
	
}
