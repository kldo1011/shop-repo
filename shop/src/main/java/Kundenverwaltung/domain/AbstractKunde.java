package Kundenverwaltung.domain;

import java.io.Serializable;
import java.net.URI;











import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import Bestellverwaltung.domain.Bestellung;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.hibernate.validator.constraints.Email;


@XmlRootElement
@XmlSeeAlso({ Firmenkunde.class, Privatkunde.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
		@Type(value = Privatkunde.class, name = AbstractKunde.PRIVATKUNDE),
		@Type(value = Firmenkunde.class, name = AbstractKunde.FIRMENKUNDE) })
public abstract class AbstractKunde implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3893137497122036519L;
	public static final String PRIVATKUNDE = "P";
	public static final String FIRMENKUNDE = "F";
	
	//Pattern mit UTF-8 (statt Latin-1 bzw. ISO-8859-1) Schreibweise fuer Umlaute:
	public static final String NACHNAME_PATTERN = "[A-Z\u00C4\u00D6\u00DC][a-z\u00E4\u00F6\u00FC\u00DF]+";
	private static final int NACHNAME_LENGTH_MIN = 2;
	private static final int NACHNAME_LENGTH_MAX = 32;
	private static final int EMAIL_LENGTH_MAX = 128;
	
	

	private Long id;
	
	@NotNull(message = "{Kundenverwaltung.kunde.nachname.notNull}")
	@Size(min = NACHNAME_LENGTH_MIN, max = NACHNAME_LENGTH_MAX,
	      message = "{Kundenverwaltung.kunde.nachname.length}")
	@Pattern(regexp = NACHNAME_PATTERN, message = "{kunde.nachname.pattern}")
	private String nachname;
	
	@Email(message = "{kunde.email.pattern}")
	@NotNull(message = "{kunde.email.notNull}")
	@Size(max = EMAIL_LENGTH_MAX, message = "{kunde.email.length}")
	private String email;
	
	@Valid
	@NotNull(message = "{Kundenverwaltung.kunde.adresse.notNull}")
	private Adressen adresse;
	
	@XmlTransient
	private List<Bestellung> bestellungen;
	private URI bestellungenUri;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Adressen getAdresse() {
		return adresse;
	}

	public void setAdresse(Adressen adresse) {
		this.adresse = adresse;
	}

	public URI getBestellungenUri() {
		return bestellungenUri;
	}

	public void setBestellungenUri(URI bestellungenUri) {
		this.bestellungenUri = bestellungenUri;
	}
	
	

	public List<Bestellung> getBestellungen() {
		return bestellungen;
	}

	public void setBestellungen(List<Bestellung> bestellungen) {
		this.bestellungen = bestellungen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result
				+ ((bestellungen == null) ? 0 : bestellungen.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((nachname == null) ? 0 : nachname.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "AbstractKunde [id=" + id + ", nachname=" + nachname
				+ ", email=" + email + ", adresse=" + adresse
				+ ", bestellungen=" + bestellungen + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractKunde other = (AbstractKunde) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} 
		else if (!adresse.equals(other.adresse))
			return false;
		if (bestellungen == null) {
			if (other.bestellungen != null)
				return false;
		} 
		else if (!bestellungen.equals(other.bestellungen))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} 
		else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} 
		else if (!id.equals(other.id))
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} 
		else if (!nachname.equals(other.nachname))
			return false;
		return true;
	}
	

}
