package carrent.core.model.person;

import carrent.core.model.person.customer.ConfirmedCustomer;
import carrent.core.model.person.customer.UnconfirmedCustomer;
import carrent.core.model.person.employee.Employee;
public class EntityFactory {

	public PersonEntity PersonEntity(String criteria) {
		if (criteria.equals("confirmedCustomer"))
			return new ConfirmedCustomer();
		else if (criteria.equals("employee"))
			return new Employee();
		else if (criteria.equals("unconfirmedCustomer"))
			return new UnconfirmedCustomer();
		return null;
	}
}
