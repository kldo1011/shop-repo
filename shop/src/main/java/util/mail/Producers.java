package util.mail;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * @author <a href="mailto:Juergen.Zimmermann@HS-Karlsruhe.de">J&uuml;rgen Zimmermann</a>
 */
@ApplicationScoped
public class Producers implements Serializable {
	

	// In src\webapp\WEB-INF\web.xml koennen die Werte gesetzt bzw. ueberschrieben werden
	
	
	private static final long serialVersionUID = 4876956078345734210L;
 @Resource(name = "absenderMail")
 @Produces
 @AbsenderMail
 private String absenderMail;
 
 @Resource(name = "absenderName")
 @Produces 
 @AbsenderName
 private String absenderName;

}
