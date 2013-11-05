package Artikelverwaltung.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import java.net.URI;
import java.net.URISyntaxException;

import Artikelverwaltung.domain.Artikel;

@Path("/artikelService")
//@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75",TEXT_XML + ";qs=0.75"})
@Consumes
public class ArtikelService {

	
	@GET
	@Path("{id:[1-9][0-9]*}")
	public Artikel findArtikelById(@PathParam ("id") Long id) {
		//for(int zl = 0; zl < 1000; zl++) {
			//if(id == Artikel.class)
		
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
	public void artikelupdate(Artikel artikel){
		//TODO sdfs
	  }
	
	@POST
	//@Consumes({ APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public Response createArtikel(Artikel artikel) {
		
		Artikel neuerArtikel = new Artikel(artikel.getArtikelUri(),artikel.getBezeichnung(),artikel.getPreis(),artikel.getId());
		URI uri = null;
		try {
			uri = new URI("https://github.com/kldo1011/shop-repo/Artikelverwaltung.domain/artikel/" + neuerArtikel.getId());
			return Response.created(uri)		
				       .build();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
		
	     
      }
	
	
	
}
