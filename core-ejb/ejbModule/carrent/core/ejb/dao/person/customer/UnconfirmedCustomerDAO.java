package carrent.core.ejb.dao.person.customer;

import java.util.List;

import javax.ejb.Local;

import carrent.core.model.person.customer.UnconfirmedCustomer;



@Local
public interface UnconfirmedCustomerDAO {

	void removeUnconfirmedCustomer(UnconfirmedCustomer unconfirmedCustomer);

	void persistUnconfirmedCustomer(UnconfirmedCustomer unconfirmedCustomer);

	UnconfirmedCustomer mergeUnconfirmedCustomer(UnconfirmedCustomer unconfirmedCustomer);

	UnconfirmedCustomer findUnconfirmedCustomer(Long id);

	List<UnconfirmedCustomer> findAllUnconfirmedCustomers();
	
	UnconfirmedCustomer findUnconfirmedCustomerByToken(String token);

}
