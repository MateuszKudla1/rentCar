package carrent.core.ejb.mail.service;

import javax.annotation.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

@Generated(value = "org.junit-tools-1.0.6")
public class AuthorizationServiceTest {

	private AuthorizationService createTestSubject() {
		return new AuthorizationService();
	}

	@MethodRef(name = "authorizeCustomer", signature = "(QString;)V")
	@Test
	public void testAuthorizeCustomer() throws Exception {
		AuthorizationService testSubject;
		String token = "";

		// default test
		testSubject = createTestSubject();
		testSubject.authorizeCustomer(token);
	}
}