package util.mail;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;


@ApplicationScoped
public class Producers implements Serializable {
	

	
	
	
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
