package Artikelverwaltung.service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import util.Mock;
import util.rest.UriHelper;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import Artikelverwaltung.domain.Artikel;
//import Bestellverwaltung.rest.BestellungResource;
import Kundenverwaltung.domain.AbstractKunde;
import Kundenverwaltung.rest.KundeResource;

@Path("/artikelService")
//@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75",TEXT_XML + ";qs=0.75"})
@Consumes
public class ArtikelService {

	@Context
	private UriInfo uriInfo;
	
	@Inject
	private UriHelper uriHelper;
	
	//@Inject
	//private BestellungResource bestellungResource;
	
	@GET
	@Path("{id:[1-9][0-9]*}")
	public Artikel findArtikelById(@PathParam ("id") Long id) {
		return null;
	}
	

	@GET
	@Path("{Bezeichnung:[A-Z][a-z]*}")
	public Artikel findArtikelByBezeichnung(@PathParam ("Bezeichnung") String bezeichnung) {
				return null;
		}
	
	@PUT
	//@Consumes({ APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public void artikelupdate(Artikel artikel){;
	  }
	
	//@POST
	//@Consumes({ APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	//@Produces
	/*
	public Response createArtikel(Artikel artikel) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
				artikel = Mock.createArtikel(artikel);
				return Response.created(getArtikelUri(artikel, uriInfo))
					          // .build();
				return null;
	     
      }*/
	
	
	
}
