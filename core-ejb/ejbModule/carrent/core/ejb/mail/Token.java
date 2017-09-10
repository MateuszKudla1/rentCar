package carrent.core.ejb.mail;


import java.security.SecureRandom;

import javax.ejb.Stateless;

@Stateless
public class Token {
	
	public String getToken() {
		 SecureRandom random = new SecureRandom();
		    byte bytes[] = new byte[20];
		    random.nextBytes(bytes);
		    return bytes.toString();
	}

}