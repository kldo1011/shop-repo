package Artikelverwaltung.domain;

import java.io.Serializable;
import java.net.URI;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

@XmlRootElement
@XmlSeeAlso({ Fahrrad.class, Ersatzteile.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = Fahrrad.class, name = AbstractArtikel.FAHRRAD),
		@Type(value = Ersatzteile.class, name = AbstractArtikel.ERSATZTEILE) })
public abstract class  AbstractArtikel implements Serializable{
	private static final long serialVersionUID = 6487111749377747617L;

	private long id;
	
	@NotNull
	@Min(0)
	@Max(100)
	private double preis;
	
	@NotNull
	@Size(min = 1, max = 32)
	@Pattern(regexp = "[A-ZÄÖÜ][a-zäöüß]+")
	private String typ;

	private URI artikelUri;
	
	public static final String ERSATZTEILE = "E";
	public static final String FAHRRAD = "F";

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((artikelUri == null) ? 0 : artikelUri.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (artikelUri == null) {
			if (other.artikelUri != null)
				return false;
		} 
		else if (!artikelUri.equals(other.artikelUri))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(preis) != Double
				.doubleToLongBits(other.preis))
			return false;
		if (typ == null) {
			if (other.typ != null)
				return false;
		}
		else if (!typ.equals(other.typ))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AbstractArtikel [id=" + id + ", preis=" + preis + ", typ="
				+ typ + ", artikelUri=" + artikelUri + "]";
	}

}