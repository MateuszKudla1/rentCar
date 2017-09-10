package carrent.core.ejb.manager.person.customer;

import java.util.List;

import javax.annotation.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import carrent.core.model.person.customer.UnconfirmedCustomer;

@Generated(value = "org.junit-tools-1.0.6")
public class DefaultUnconfirmedCustomerManagerTest {

	private DefaultUnconfirmedCustomerManager createTestSubject() {
		return new DefaultUnconfirmedCustomerManager();
	}

	@MethodRef(name = "removeUnconfirmedCustomer", signature = "(QUnconfirmedCustomer;)V")
	@Test
	public void testRemoveUnconfirmedCustomer() throws Exception {
		DefaultUnconfirmedCustomerManager testSubject;
		UnconfirmedCustomer unconfirmedCustomer = null;

		// default test
		testSubject = createTestSubject();
		testSubject.removeUnconfirmedCustomer(unconfirmedCustomer);
	}

	@MethodRef(name = "persistUnconfirmedCustomer", signature = "(QUnconfirmedCustomer;)V")
	@Test
	public void testPersistUnconfirmedCustomer() throws Exception {
		DefaultUnconfirmedCustomerManager testSubject;
		UnconfirmedCustomer unconfirmedCustomer = null;

		// default test
		testSubject = createTestSubject();
		testSubject.persistUnconfirmedCustomer(unconfirmedCustomer);
	}

	@MethodRef(name = "mergeUnconfirmedCustomer", signature = "(QUnconfirmedCustomer;)QUnconfirmedCustomer;")
	@Test
	public void testMergeUnconfirmedCustomer() throws Exception {
		DefaultUnconfirmedCustomerManager testSubject;
		UnconfirmedCustomer unconfirmedCustomer = null;
		UnconfirmedCustomer result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.mergeUnconfirmedCustomer(unconfirmedCustomer);
	}

	@MethodRef(name = "findUnconfirmedCustomer", signature = "(QLong;)QUnconfirmedCustomer;")
	@Test
	public void testFindUnconfirmedCustomer() throws Exception {
		DefaultUnconfirmedCustomerManager testSubject;
		Long id = null;
		UnconfirmedCustomer result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findUnconfirmedCustomer(id);
	}

	@MethodRef(name = "findAllUnconfirmedCustomers", signature = "()QList<QUnconfirmedCustomer;>;")
	@Test
	public void testFindAllUnconfirmedCustomers() throws Exception {
		DefaultUnconfirmedCustomerManager testSubject;
		List<UnconfirmedCustomer> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findAllUnconfirmedCustomers();
	}

	@MethodRef(name = "findUnconfirmedCustomerByToken", signature = "(QString;)QUnconfirmedCustomer;")
	@Test
	public void testFindUnconfirmedCustomerByToken() throws Exception {
		DefaultUnconfirmedCustomerManager testSubject;
		String token = "";
		UnconfirmedCustomer result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findUnconfirmedCustomerByToken(token);
	}
}