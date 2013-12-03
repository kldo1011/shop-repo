package Bestellverwaltung.service;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_XML;
import static util.Constants.SELF_LINK;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.net.URI;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;

import Bestellverwaltung.domain.Bestellung;
import Bestellverwaltung.rest.BestellungResource;
import Kundenverwaltung.domain.AbstractKunde;
import util.Mock;
import util.interceptor.Log;
import util.rest.NotFoundException;

@Log
public class BestellungService implements Serializable{
	private static final long serialVersionUID = -48716630483597787L;
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	@PostConstruct
	private void postConstruct() {
		LOGGER.debugf("CDI-faehiges Bean %s wurde erzeugt", this);
	}
	
	@PreDestroy
	private void preDestroy() {
		LOGGER.debugf("CDI-faehiges Bean %s wird geloescht", this);
	}

	
	public Response findBestellungById(@PathParam("id") Long id) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		final Bestellung bestellung = Mock.findBestellungById(id);
		if (bestellung == null) {
			throw new NotFoundException("Keine Bestellung mit der ID " + id
					+ " gefunden.");
		}

		setStructuralLinks(bestellung, uriInfo);

		// Link-Header setzen
		final Response response = Response.ok(bestellung)
				.links(getTransitionalLinks(bestellung, uriInfo)).build();

		return response;
	}


	public Response createBestellung(Bestellung bestellung) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		bestellung = Mock.createBestellung(bestellung);
		return Response.created(getUriBestellung(bestellung, uriInfo)).build();
	}

	public void updateBestellung(Bestellung bestellung) {
		Mock.updateBestellung(bestellung);
	}

	public void deleteBestellung(@PathParam("id") Long id) {
		Mock.deleteBestellung(id);
	}

}
