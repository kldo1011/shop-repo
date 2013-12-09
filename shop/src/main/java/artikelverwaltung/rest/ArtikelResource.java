package artikelverwaltung.rest;

import static util.Constants.SELF_LINK;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_XML;

import java.net.URI;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
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

import artikelverwaltung.domain.AbstractArtikel;
import artikelverwaltung.domain.Ersatzteil;

import artikelverwaltung.domain.Fahrrad;
import artikelverwaltung.service.ArtikelService;
import util.interceptor.Log;
import util.rest.UriHelper;

@Path("/artikel")
@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75",
		TEXT_XML + ";qs=0.5" })
@Consumes
@RequestScoped
@Log
public class ArtikelResource {
	
	public static final String ARTIKEL_ID_PATH_PARAM = "id";
	public static final String ARTIKEL_NOT_FOUND = "artikel.notFound.all";
	public static final String ARTIKEL_NOT_FOUND_ID = "artikel.notFound.id";
	
	@Inject 
	private ArtikelService as;
	
	@Context
	private UriInfo uriInfo;
	
	@Inject
	private UriHelper uriHelper;
	

	@GET
	public Response findAllArtikel() {
		// TODO Anwendungskern statt Mock, Verwendung von Locale

		final List<AbstractArtikel> artikelList = as.findeAlleArtikel();
		return Response
				.ok(new GenericEntity<List<? extends AbstractArtikel>>(
						artikelList) {
				}).build();

	}

	@GET
	@Path("{" + ARTIKEL_ID_PATH_PARAM + ":[1-9][0-9]*}")
	public Response findArtikelById(@PathParam(ARTIKEL_ID_PATH_PARAM) long id) {
		final AbstractArtikel artikel = as.findeArtikelById(id);
		return Response.ok(artikel)
				.links(getTransitionalLinks(artikel, uriInfo)).build();
	}

	private Link[] getTransitionalLinks(AbstractArtikel artikel, UriInfo uriInfo) {
		final Link self = Link.fromUri(getUriArtikel(artikel, uriInfo))
				.rel(SELF_LINK).build();

		return new Link[] {self };
	}

	public URI getUriArtikel(AbstractArtikel artikel, UriInfo uriInfo) {
		return uriHelper.getUri(ArtikelResource.class, "findArtikelById",
				artikel.getId(), uriInfo);
	}

	@POST
	@Path("/fahrrad")
	@Consumes({ APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public Response createFahrrad(@Valid Fahrrad fahrrad) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		fahrrad = as.createFahrrad(fahrrad);
		return Response.created(getUriArtikel(fahrrad, uriInfo)).build();
	}

	@POST
	@Path("/ersatzteil")
	@Consumes({ APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public Response createErsatzteil(@Valid Ersatzteil ersatzteil) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		ersatzteil = as.createErsatzteile(ersatzteil);
		return Response.created(getUriArtikel(ersatzteil, uriInfo)).build();
	}

	@PUT
	@Consumes({ APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public void updateArtikel(@Valid AbstractArtikel artikel) {
		as.updateArtikel(artikel);
	}

}
