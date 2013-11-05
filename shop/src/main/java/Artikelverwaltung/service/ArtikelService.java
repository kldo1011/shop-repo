package Artikelverwaltung.service;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_XML;
import static util.Constants.FIRST_LINK;
import static util.Constants.LAST_LINK;
import util.Mock;
import util.rest.UriHelper;
import Artikelverwaltung.domain.Artikel;
import Kundenverwaltung.domain.AbstractKunde;

@Path("/artikelService")
@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75",TEXT_XML + ";qs=0.75"})
@Consumes
public class ArtikelService {

	@Context
	private UriInfo uriInfo;
	
	@Inject
	private UriHelper uriHelper;
	
	public URI getUriArtikel(Artikel artikel, UriInfo uriInfo) {
		return uriHelper.getUri(ArtikelService.class, "findArtikelById", artikel.getId(), uriInfo);
	}
	
	private Link[] getTransitionalLinksArtikel(List<? extends Artikel> artikel, UriInfo uriInfo) {
		if (artikel == null || artikel.isEmpty()) {
			return null;
		}
		
		final Link first = Link.fromUri(getUriArtikel(artikel.get(0), uriInfo))
	                           .rel(FIRST_LINK)
	                           .build();
		final int lastPos = artikel.size() - 1;
		final Link last = Link.fromUri(getUriArtikel(artikel.get(lastPos), uriInfo))
                              .rel(LAST_LINK)
                              .build();
		
		return new Link[] { first, last };
	}
	
	@GET
	@Path("{id:[1-9][0-9]*}")
	public Artikel findArtikelById(@PathParam ("id") Long id) {
		return null;
	}
	
	@GET
	@Path("{Bezeichnung:[A-Z][a-z]*}")
	public Response findArtikelByBezeichnung(@PathParam ("Bezeichnung") String bezeichnung) {
			List<? extends Artikel> artikel = null;
			if (bezeichnung != null) {
				// TODO Anwendungskern statt Mock
				artikel = Mock.findArtikelByBezeichnung(bezeichnung);
				if (artikel.isEmpty()) {
					throw new NotFoundException("Kein Artikel mit Bezeichnung " + bezeichnung + " gefunden.");
				}
			}
			else {
				// TODO Anwendungskern statt Mock
				artikel = Mock.findAllArtikel();
				if (artikel.isEmpty()) {
					throw new NotFoundException("Keine Artikel vorhanden.");
				}
			}
			
			return Response.ok(new GenericEntity<List<? extends Artikel>>(artikel){})
	                       .links(getTransitionalLinksArtikel(artikel, uriInfo))
	                       .build();
		}
		
	
	@POST
	@Consumes({ APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public Response createArtikel(Artikel artikel) {
		// TODO Anwendungskern statt Mock
				artikel = Mock.createArtikel(artikel);
				return Response.created(getUriArtikel(artikel, uriInfo))
					           .build();
     
      }
	
	@PUT
	@Consumes({APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public void updateArtikel(Artikel artikel) {
		// TODO Anwendungskern statt Mock
		Mock.updateArtikel(artikel);
	}
	
	
	
}
