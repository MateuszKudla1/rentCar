package carrent.core.ejb.manager.person.customer;

import java.util.List;

import javax.ejb.Remote;

import carrent.core.model.person.customer.ConfirmedCustomer;


@Remote
public interface ConfirmedCustomerManager {

	void removeConfirmedCustomer(ConfirmedCustomer customer);

	void persistConfirmedCustomer(ConfirmedCustomer customer);

	ConfirmedCustomer mergeConfirmedCustomer(ConfirmedCustomer customer);

	ConfirmedCustomer findConfirmedCustomer(Long id);

	List<ConfirmedCustomer> findAllConfirmedCustomers();

	ConfirmedCustomer findConfirmedCustomerByPeselAndPassword(String pesel, String password);

}
