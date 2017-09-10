package carrent.core.ejb.manager.person.customer;

import java.util.List;

import javax.annotation.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import carrent.core.model.person.customer.ConfirmedCustomer;

@Generated(value = "org.junit-tools-1.0.6")
public class DefaultConfirmedCustomerManagerTest {

	private DefaultConfirmedCustomerManager createTestSubject() {
		return new DefaultConfirmedCustomerManager();
	}

	@MethodRef(name = "findAllConfirmedCustomers", signature = "()QList<QConfirmedCustomer;>;")
	@Test
	public void testFindAllConfirmedCustomers() throws Exception {
		DefaultConfirmedCustomerManager testSubject;
		List<ConfirmedCustomer> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findAllConfirmedCustomers();
	}

	@MethodRef(name = "findConfirmedCustomer", signature = "(QLong;)QConfirmedCustomer;")
	@Test
	public void testFindConfirmedCustomer() throws Exception {
		DefaultConfirmedCustomerManager testSubject;
		Long id = null;
		ConfirmedCustomer result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findConfirmedCustomer(id);
	}

	@MethodRef(name = "mergeConfirmedCustomer", signature = "(QConfirmedCustomer;)QConfirmedCustomer;")
	@Test
	public void testMergeConfirmedCustomer() throws Exception {
		DefaultConfirmedCustomerManager testSubject;
		ConfirmedCustomer customer = null;
		ConfirmedCustomer result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.mergeConfirmedCustomer(customer);
	}

	@MethodRef(name = "persistConfirmedCustomer", signature = "(QConfirmedCustomer;)V")
	@Test
	public void testPersistConfirmedCustomer() throws Exception {
		DefaultConfirmedCustomerManager testSubject;
		ConfirmedCustomer customer = null;

		// default test
		testSubject = createTestSubject();
		testSubject.persistConfirmedCustomer(customer);
	}

	@MethodRef(name = "findConfirmedCustomerByPeselAndPassword", signature = "(QString;QString;)QConfirmedCustomer;")
	@Test
	public void testFindConfirmedCustomerByPeselAndPassword() throws Exception {
		DefaultConfirmedCustomerManager testSubject;
		String pesel = "";
		String password = "";
		ConfirmedCustomer result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findConfirmedCustomerByPeselAndPassword(pesel, password);
	}

	@MethodRef(name = "removeConfirmedCustomer", signature = "(QConfirmedCustomer;)V")
	@Test
	public void testRemoveConfirmedCustomer() throws Exception {
		DefaultConfirmedCustomerManager testSubject;
		ConfirmedCustomer customer = null;

		// default test
		testSubject = createTestSubject();
		testSubject.removeConfirmedCustomer(customer);
	}
}