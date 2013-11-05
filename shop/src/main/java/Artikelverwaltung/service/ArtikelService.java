package Artikelverwaltung.service;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import Artikelverwaltung.domain.Artikel;

@XmlRootElement
public class ArtikelService {
	
	
	/**
	 * Suche nach verfuegbaren Artikeln.
	 * @return Liste der verfuegbaren Artikel.
	 */
	public List<Artikel> findVerfuegbareArtikel() {
		//TODO Alle verfügbaren Artikel finden 
				return null;
	}

	
	/**
	 * Suche den Artikel zu gegebener ID.
	 * @param id ID des gesuchten Artikels.
	 * @return Der gefundene Artikel, null sonst.
	 */
	public Artikel findArtikelById(Long id) {
		//TODO Artikel mit Hilfe von Id finden 
				return null;
	}
	
	/**
	 * Suche die Artikel zu gegebenen IDs. 
	 * @param ids Liste der IDs
	 * @return Liste der gefundenen Artikel
	 */
	public List<Artikel> findArtikelByIds(List<Long> ids) {
		
		//TODO mehrer Artikel mit Hilfe von Id finden 
		return null;
	}

	
	/**
	 * Suche die Artikel mit gleicher Bezeichnung
	 * @param bezeichnung Gemeinsame Bezeichnung der gesuchten Artikel
	 * @return Liste der gefundenen Artikel
	 */
	public List<Artikel> findArtikelByBezeichnung(String bezeichnung) {
		//TODO mehrer Artikel mit Hilfe von Bezeichnung finden 
				return null;
		}
}
