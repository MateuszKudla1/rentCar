package carrent.core.ejb.dao.rent;

import java.util.List;

import javax.annotation.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import carrent.core.model.branch.Branch;
import carrent.core.model.order.Rent;
import carrent.core.model.person.customer.ConfirmedCustomer;

@Generated(value = "org.junit-tools-1.0.6")
public class DefaultRentDaoTest {

	private DefaultRentDao createTestSubject() {
		return new DefaultRentDao();
	}

	@MethodRef(name = "removeRent", signature = "(QRent;)V")
	@Test
	public void testRemoveRent() throws Exception {
		DefaultRentDao testSubject;
		Rent rent = null;

		// default test
		testSubject = createTestSubject();
		testSubject.removeRent(rent);
	}

	@MethodRef(name = "persistRent", signature = "(QRent;)V")
	@Test
	public void testPersistRent() throws Exception {
		DefaultRentDao testSubject;
		Rent rent = null;

		// default test
		testSubject = createTestSubject();
		testSubject.persistRent(rent);
	}

	@MethodRef(name = "findRent", signature = "(QLong;)QRent;")
	@Test
	public void testFindRent() throws Exception {
		DefaultRentDao testSubject;
		Long id = null;
		Rent result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findRent(id);
	}

	@MethodRef(name = "findAllRentsByCustomerId", signature = "(QConfirmedCustomer;)QList<QRent;>;")
	@Test
	public void testFindAllRentsByCustomerId() throws Exception {
		DefaultRentDao testSubject;
		ConfirmedCustomer customer = null;
		List<Rent> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findAllRentsByCustomerId(customer);
	}

	@MethodRef(name = "findRentsWithBookedStatusById", signature = "(QBranch;)QList<QRent;>;")
	@Test
	public void testFindRentsWithBookedStatusById() throws Exception {
		DefaultRentDao testSubject;
		Branch branch = null;
		List<Rent> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findRentsWithBookedStatusById(branch);
	}

	@MethodRef(name = "findRentsWithRentedStatusById", signature = "(QBranch;)QList<QRent;>;")
	@Test
	public void testFindRentsWithRentedStatusById() throws Exception {
		DefaultRentDao testSubject;
		Branch branch = null;
		List<Rent> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findRentsWithRentedStatusById(branch);
	}

	@MethodRef(name = "mergeRent", signature = "(QRent;)QRent;")
	@Test
	public void testMergeRent() throws Exception {
		DefaultRentDao testSubject;
		Rent rent = null;
		Rent result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.mergeRent(rent);
	}
}