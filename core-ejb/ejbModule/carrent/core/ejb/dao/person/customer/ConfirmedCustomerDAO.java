package carrent.core.ejb.dao.person.customer;

import java.util.List;
import javax.ejb.Local;

import carrent.core.model.person.customer.ConfirmedCustomer;

@Local
public interface ConfirmedCustomerDAO {

	void removeConfirmedCustomer(ConfirmedCustomer customer);

	void persistConfirmedCustomer(ConfirmedCustomer customer);

	ConfirmedCustomer mergeConfirmedCustomer(ConfirmedCustomer customer);

	ConfirmedCustomer findConfirmedCustomer(Long id);

	List<ConfirmedCustomer> findAllConfirmedCustomers();

	ConfirmedCustomer findConfirmedCustomerByPeselAndPassword(String pesel, String password);

}
