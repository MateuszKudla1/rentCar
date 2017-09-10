package carrent.core.ejb.manager.person.customer;

import java.util.List;
import javax.ejb.Remote;
import carrent.core.model.person.customer.UnconfirmedCustomer;

@Remote
public interface UnconfirmedCustomerManager {

	List<UnconfirmedCustomer> findAllUnconfirmedCustomers();

	UnconfirmedCustomer findUnconfirmedCustomer(Long id);

	UnconfirmedCustomer mergeUnconfirmedCustomer(UnconfirmedCustomer unconfirmedCustomer);

	void persistUnconfirmedCustomer(UnconfirmedCustomer unconfirmedCustomer);

	void removeUnconfirmedCustomer(UnconfirmedCustomer unconfirmedCustomer);

	UnconfirmedCustomer findUnconfirmedCustomerByToken(String token);
}
