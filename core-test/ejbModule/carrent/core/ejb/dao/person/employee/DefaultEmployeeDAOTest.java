package carrent.core.ejb.dao.person.employee;

import java.util.List;

import javax.annotation.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import carrent.core.model.person.employee.Employee;

@Generated(value = "org.junit-tools-1.0.6")
public class DefaultEmployeeDAOTest {

	private DefaultEmployeeDAO createTestSubject() {
		return new DefaultEmployeeDAO();
	}

	@MethodRef(name = "removeEmployee", signature = "(QEmployee;)V")
	@Test
	public void testRemoveEmployee() throws Exception {
		DefaultEmployeeDAO testSubject;
		Employee employee = null;

		// default test
		testSubject = createTestSubject();
		testSubject.removeEmployee(employee);
	}

	@MethodRef(name = "persistEmployee", signature = "(QEmployee;)V")
	@Test
	public void testPersistEmployee() throws Exception {
		DefaultEmployeeDAO testSubject;
		Employee employee = null;

		// default test
		testSubject = createTestSubject();
		testSubject.persistEmployee(employee);
	}

	@MethodRef(name = "mergeEmployee", signature = "(QEmployee;)QEmployee;")
	@Test
	public void testMergeEmployee() throws Exception {
		DefaultEmployeeDAO testSubject;
		Employee employee = null;
		Employee result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.mergeEmployee(employee);
	}

	@MethodRef(name = "findEmployee", signature = "(QLong;)QEmployee;")
	@Test
	public void testFindEmployee() throws Exception {
		DefaultEmployeeDAO testSubject;
		Long id = null;
		Employee result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findEmployee(id);
	}

	@MethodRef(name = "findAllEmployees", signature = "()QList<QEmployee;>;")
	@Test
	public void testFindAllEmployees() throws Exception {
		DefaultEmployeeDAO testSubject;
		List<Employee> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findAllEmployees();
	}

	@MethodRef(name = "findEmployeeByPeselAndPassword", signature = "(QString;QString;)QEmployee;")
	@Test
	public void testFindEmployeeByPeselAndPassword() throws Exception {
		DefaultEmployeeDAO testSubject;
		String pesel = "";
		String password = "";
		Employee result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findEmployeeByPeselAndPassword(pesel, password);
	}
}