package Artikelverwaltung.domain;

import java.net.URI;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
@XmlRootElement
@XmlSeeAlso({ Zubehoer.class, Fahrrad.class, Ersatzteil.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = Zubehoer.class, name = AbstractArtikel.ZUBEHOER),
                @Type(value = Fahrrad.class, name = AbstractArtikel.FAHRRAD),
                @Type(value = Ersatzteil.class, name = AbstractArtikel.ERSATZTEIL) })

public class AbstractArtikel {
	
	private long artikelNr;
	private double preis;
	private String typ;
	private URI artikelUri;
	public static final String ZUBEHOER="Z";
	public static final String ERSATZTEIL="E";
	public static final String FAHRRAD="F";
	public long getArtikelNr() {
		return artikelNr;
	}
	public void setArtikelNr(long artikelNr) {
		this.artikelNr = artikelNr;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	public URI getArtikelUri() {
		return artikelUri;
	}
	public void setArtikelUri(URI artikelUri) {
		this.artikelUri = artikelUri;
	}
	public static String getZubehör() {
		return zubehör;
	}
	public static String getErsatzteile() {
		return ersatzteile;
	}
	public static String getFahrrad() {
		return fahrrad;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (artikelNr ^ (artikelNr >>> 32));
		result = prime * result
				+ ((artikelUri == null) ? 0 : artikelUri.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preis);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((typ == null) ? 0 : typ.hashCode());
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
		AbstractArtikel other = (AbstractArtikel) obj;
		if (artikelNr != other.artikelNr)
			return false;
		if (artikelUri == null) {
			if (other.artikelUri != null)
				return false;
		} else if (!artikelUri.equals(other.artikelUri))
			return false;
		if (Double.doubleToLongBits(preis) != Double
				.doubleToLongBits(other.preis))
			return false;
		if (typ == null) {
			if (other.typ != null)
				return false;
		} else if (!typ.equals(other.typ))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AbstractArtikel [artikelNr=" + artikelNr + ", preis=" + preis
				+ ", typ=" + typ + ", artikelUri=" + artikelUri + "]";
	}
	

	
	
	
}