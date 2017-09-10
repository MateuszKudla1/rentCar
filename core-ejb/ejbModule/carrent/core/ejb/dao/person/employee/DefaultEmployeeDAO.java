package carrent.core.ejb.dao.person.employee;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import carrent.core.ejb.dao.person.employee.EmployeeDAO;
import carrent.core.model.person.customer.ConfirmedCustomer;
import carrent.core.model.person.employee.Employee;

@Stateless
public class DefaultEmployeeDAO implements EmployeeDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void removeEmployee(Employee employee) {
		entityManager.remove(employee);
	}

	@Override
	public void persistEmployee(Employee employee) {
		entityManager.persist(employee);
	}

	@Override
	public Employee mergeEmployee(Employee employee) {
		return entityManager.merge(employee);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Employee findEmployee(Long id) {
		return entityManager.find(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAllEmployees() {
		return entityManager.createNamedQuery("Employee.find").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Employee findEmployeeByPeselAndPassword(String pesel, String password) {
		Query query = entityManager.createNamedQuery("Employee.findByPeselAndPassword")
				.setParameter("pesel", pesel).setParameter("password", password);
		System.out.println(query.getResultList().size());
		if (query.getResultList().size() == 0)
			return null;
		Employee employee = (Employee) query.getResultList().get(0);
		return employee;
	}

}
