package bestellverwaltung.rest;

import static util.Constants.SELF_LINK;
import static util.Constants.ADD_LINK;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_XML;



import java.net.URI;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;




import bestellverwaltung.domain.Bestellung;
import bestellverwaltung.service.BestellungService;
import kundenverwaltung.domain.AbstractKunde;
import kundenverwaltung.rest.KundeResource;
import util.interceptor.Log;
import util.rest.UriHelper;

@Path("/bestellungen")
@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75",
		TEXT_XML + ";qs=0.5" })
@Consumes
@RequestScoped
@Log
public class BestellungResource {
	
    public static final String BESTELLUNG_ID_PATH_PARAM = "id";

    public static final String BESTELLUNG_NOT_FOUND = "bestellung.notFound.all";
    public static final String BESTELLUNG_NOT_FOUND_ID = "bestellung.notFound.id";

	@Context
	private UriInfo uriInfo;

	@Inject
	private UriHelper uriHelper;

	@Inject
	private KundeResource kundeResource;

	@Inject
	private BestellungService bs;
	
	@GET
	public Response findAllBestellungen() {
		
		final List<Bestellung> bestellung = bs.findAllBestellungen();
		return Response.ok(new GenericEntity<List<Bestellung>>(bestellung) {
        }).build();

}
	


	@GET
	@Path("{" + BESTELLUNG_ID_PATH_PARAM + ":[1-9][0-9]*}")
	public Response findBestellungById(@PathParam(BESTELLUNG_ID_PATH_PARAM) Long id) {
		final Bestellung bestellung = bs.findBestellungById(id);
		setStructuralLinks(bestellung, uriInfo);

		// Link-Header setzen
		final Response response = Response.ok(bestellung)
				.links(getTransitionalLinks(bestellung, uriInfo)).build();

		return response;
	}

	public void setStructuralLinks(Bestellung bestellung, UriInfo uriInfo) {
		// URI fuer Kunde setzen
		final AbstractKunde kunde = bestellung.getKunde();
		if (kunde != null) {
			final URI kundeUri = kundeResource.getUriKunde(
					bestellung.getKunde(), uriInfo);
			bestellung.setKundeUri(kundeUri);
		}
	}

	private Link[] getTransitionalLinks(Bestellung bestellung, UriInfo uriInfo) {
		final Link self = Link.fromUri(getUriBestellung(bestellung, uriInfo))
                              .rel(SELF_LINK)
                              .build();
		final Link add = Link.fromUri(uriHelper.getUri(BestellungResource.class, uriInfo))
                             .rel(ADD_LINK)
                             .build();

		return new Link[] {self, add };
	}

	public URI getUriBestellung(Bestellung bestellung, UriInfo uriInfo) {
		return uriHelper.getUri(BestellungResource.class, "findBestellungById",
				bestellung.getId(), uriInfo);
	}

	
	@POST
	@Consumes({ APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public Response createBestellung(Bestellung bestellung) {
		bestellung = bs.createBestellung(bestellung);
		return Response.created(getUriBestellung(bestellung, uriInfo)).build();
	}
	/*

	@PUT
	@Consumes({ APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public void updateBestellung(Bestellung bestellung) {
		bs.updateBestellung(bestellung);
	}

	@DELETE
	@Path("{id:[1-9][0-9]*}")
	@Produces
	public void deleteBestellung(@PathParam("id") Long id) {
		bs.deleteBestellung(id);
	}
	*/
}
