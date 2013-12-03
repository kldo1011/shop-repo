package Artikelverwaltung.rest;

import org.jboss.logging.Logger;

import static util.Constants.SELF_LINK;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_XML;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import Artikelverwaltung.domain.AbstractArtikel;
import Artikelverwaltung.domain.Ersatzteile;
import Artikelverwaltung.domain.Fahrrad;
import Artikelverwaltung.service.ArtikelService;
import util.interceptor.Log;
import util.rest.NotFoundException;
import util.rest.UriHelper;

@Path("/artikel")
@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75",
		TEXT_XML + ";qs=0.5" })
@Consumes
@Log
public class ArtikelResource {
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());

	@Inject 
	private ArtikelService as;
	
	@Context
	private UriInfo uriInfo;
	
	@Inject
	private UriHelper uriHelper;
	
	@PostConstruct
	private void postConstruct() {
		LOGGER.debugf("CDI-faehiges Bean %s wurde erzeugt", this);
	}
	
	@PreDestroy
	private void preDestroy() {
		LOGGER.debugf("CDI-faehiges Bean %s wird geloescht", this);
	}

	@GET
	public Response findAllArtikel() {
		// TODO Anwendungskern statt Mock, Verwendung von Locale

		final List<AbstractArtikel> artikelList = as.findeAlleArtikel();
		if (artikelList.isEmpty())
			throw new NotFoundException("Es Wurden keine Artikel geunden");
		return Response
				.ok(new GenericEntity<List<? extends AbstractArtikel>>(
						artikelList) {
				}).build();

	}

	@GET
	@Path("{id:[1-9][0-9]*}")
	public Response findArtikelById(@PathParam("id") long id) {
		final AbstractArtikel artikel = as.findeArtikelById(id);
		if (artikel == null)
			throw new NotFoundException("Es Wurden keine Artikel mit der " + id
					+ "geunden");
		return Response.ok(artikel)
				.links(getTransitionalLinks(artikel, uriInfo)).build();
	}

	private Link[] getTransitionalLinks(AbstractArtikel artikel, UriInfo uriInfo) {
		final Link self = Link.fromUri(getUriArtikel(artikel, uriInfo))
				.rel(SELF_LINK).build();

		return new Link[] { self };
	}

	public URI getUriArtikel(AbstractArtikel artikel, UriInfo uriInfo) {
		return uriHelper.getUri(ArtikelResource.class, "findArtikelById",
				artikel.getId(), uriInfo);
	}

	@POST
	@Path("/fahrrad")
	@Consumes({ APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public Response createFahrrad(Fahrrad fahrrad) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		fahrrad = as.createFahrrad(fahrrad);
		return Response.created(getUriArtikel(fahrrad, uriInfo)).build();
	}

	@POST
	@Path("/ersatzteil")
	@Consumes({ APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public Response createErsatzteil(Ersatzteile ersatzteil) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		ersatzteil = as.createErsatzteile(ersatzteil);
		return Response.created(getUriArtikel(ersatzteil, uriInfo)).build();
	}

	@PUT
	@Consumes({ APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public void updateArtikel(AbstractArtikel artikel) {
		as.updateArtikel(artikel);
	}

}
