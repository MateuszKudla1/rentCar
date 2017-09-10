package carrent.core.ejb.dao.person.customer;

import java.util.List;

import javax.annotation.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import carrent.core.model.person.customer.UnconfirmedCustomer;

@Generated(value = "org.junit-tools-1.0.6")
public class DefaultUnconfirmedCustomerDAOTest {

	private DefaultUnconfirmedCustomerDAO createTestSubject() {
		return new DefaultUnconfirmedCustomerDAO();
	}

	@MethodRef(name = "findUnconfirmedCustomer", signature = "(QLong;)QUnconfirmedCustomer;")
	@Test
	public void testFindUnconfirmedCustomer() throws Exception {
		DefaultUnconfirmedCustomerDAO testSubject;
		Long id = null;
		UnconfirmedCustomer result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findUnconfirmedCustomer(id);
	}

	@MethodRef(name = "findAllUnconfirmedCustomers", signature = "()QList<QUnconfirmedCustomer;>;")
	@Test
	public void testFindAllUnconfirmedCustomers() throws Exception {
		DefaultUnconfirmedCustomerDAO testSubject;
		List<UnconfirmedCustomer> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findAllUnconfirmedCustomers();
	}

	@MethodRef(name = "mergeUnconfirmedCustomer", signature = "(QUnconfirmedCustomer;)QUnconfirmedCustomer;")
	@Test
	public void testMergeUnconfirmedCustomer() throws Exception {
		DefaultUnconfirmedCustomerDAO testSubject;
		UnconfirmedCustomer unconfirmedCustomer = null;
		UnconfirmedCustomer result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.mergeUnconfirmedCustomer(unconfirmedCustomer);
	}

	@MethodRef(name = "persistUnconfirmedCustomer", signature = "(QUnconfirmedCustomer;)V")
	@Test
	public void testPersistUnconfirmedCustomer() throws Exception {
		DefaultUnconfirmedCustomerDAO testSubject;
		UnconfirmedCustomer unconfirmedCustomer = null;

		// default test
		testSubject = createTestSubject();
		testSubject.persistUnconfirmedCustomer(unconfirmedCustomer);
	}

	@MethodRef(name = "removeUnconfirmedCustomer", signature = "(QUnconfirmedCustomer;)V")
	@Test
	public void testRemoveUnconfirmedCustomer() throws Exception {
		DefaultUnconfirmedCustomerDAO testSubject;
		UnconfirmedCustomer unconfirmedCustomer = null;

		// default test
		testSubject = createTestSubject();
		testSubject.removeUnconfirmedCustomer(unconfirmedCustomer);
	}

	@MethodRef(name = "findUnconfirmedCustomerByToken", signature = "(QString;)QUnconfirmedCustomer;")
	@Test
	public void testFindUnconfirmedCustomerByToken() throws Exception {
		DefaultUnconfirmedCustomerDAO testSubject;
		String token = "";
		UnconfirmedCustomer result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findUnconfirmedCustomerByToken(token);
	}
}