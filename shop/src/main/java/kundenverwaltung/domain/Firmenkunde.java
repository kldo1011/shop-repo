package kundenverwaltung.domain;

import static kundenverwaltung.domain.AbstractKunde.FIRMENKUNDE;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
@Entity
@Cacheable
@DiscriminatorValue(FIRMENKUNDE)
public class Firmenkunde extends AbstractKunde {
	private static final long serialVersionUID = 2702189321993589808L;


}
