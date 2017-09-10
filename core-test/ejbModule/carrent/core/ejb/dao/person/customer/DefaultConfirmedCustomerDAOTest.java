package carrent.core.ejb.dao.person.customer;

import java.util.List;

import javax.annotation.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import carrent.core.model.person.customer.ConfirmedCustomer;

@Generated(value = "org.junit-tools-1.0.6")
public class DefaultConfirmedCustomerDAOTest {

	private DefaultConfirmedCustomerDAO createTestSubject() {
		return new DefaultConfirmedCustomerDAO();
	}

	@MethodRef(name = "removeConfirmedCustomer", signature = "(QConfirmedCustomer;)V")
	@Test
	public void testRemoveConfirmedCustomer() throws Exception {
		DefaultConfirmedCustomerDAO testSubject;
		ConfirmedCustomer customer = null;

		// default test
		testSubject = createTestSubject();
		testSubject.removeConfirmedCustomer(customer);
	}

	@MethodRef(name = "persistConfirmedCustomer", signature = "(QConfirmedCustomer;)V")
	@Test
	public void testPersistConfirmedCustomer() throws Exception {
		DefaultConfirmedCustomerDAO testSubject;
		ConfirmedCustomer customer = null;

		// default test
		testSubject = createTestSubject();
		testSubject.persistConfirmedCustomer(customer);
	}

	@MethodRef(name = "mergeConfirmedCustomer", signature = "(QConfirmedCustomer;)QConfirmedCustomer;")
	@Test
	public void testMergeConfirmedCustomer() throws Exception {
		DefaultConfirmedCustomerDAO testSubject;
		ConfirmedCustomer customer = null;
		ConfirmedCustomer result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.mergeConfirmedCustomer(customer);
	}

	@MethodRef(name = "findConfirmedCustomer", signature = "(QLong;)QConfirmedCustomer;")
	@Test
	public void testFindConfirmedCustomer() throws Exception {
		DefaultConfirmedCustomerDAO testSubject;
		Long id = null;
		ConfirmedCustomer result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findConfirmedCustomer(id);
	}

	@MethodRef(name = "findAllConfirmedCustomers", signature = "()QList<QConfirmedCustomer;>;")
	@Test
	public void testFindAllConfirmedCustomers() throws Exception {
		DefaultConfirmedCustomerDAO testSubject;
		List<ConfirmedCustomer> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findAllConfirmedCustomers();
	}

	@MethodRef(name = "findConfirmedCustomerByPeselAndPassword", signature = "(QString;QString;)QConfirmedCustomer;")
	@Test
	public void testFindConfirmedCustomerByPeselAndPassword() throws Exception {
		DefaultConfirmedCustomerDAO testSubject;
		String pesel = "";
		String password = "";
		ConfirmedCustomer result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findConfirmedCustomerByPeselAndPassword(pesel, password);
	}
}