package carrent.core.ejb.dao.person.employee;

import java.util.List;

import javax.ejb.Local;

import carrent.core.model.person.customer.UnconfirmedCustomer;
import carrent.core.model.person.employee.Employee;

@Local
public interface EmployeeDAO {
	
	void removeEmployee(Employee employee);

	void persistEmployee(Employee employee);

	Employee mergeEmployee(Employee employee);

	Employee findEmployee(Long id);

	List<Employee> findAllEmployees();

	Employee findEmployeeByPeselAndPassword(String pesel, String password);

}
