package carrent.core.ejb.manager.person.customer;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;

import carrent.core.ejb.dao.person.customer.ConfirmedCustomerDAO;
import carrent.core.ejb.manager.person.customer.ConfirmedCustomerManager;
import carrent.core.model.person.customer.ConfirmedCustomer;

@Stateless
public class DefaultConfirmedCustomerManager implements ConfirmedCustomerManager{
	
	@EJB
	private ConfirmedCustomerDAO customerDAO;

	@Override
	public List<ConfirmedCustomer> findAllConfirmedCustomers() {
		return customerDAO.findAllConfirmedCustomers();
	}

	@Override
	public ConfirmedCustomer findConfirmedCustomer(Long id) {
		return customerDAO.findConfirmedCustomer(id);
	}

	@Override
	public ConfirmedCustomer mergeConfirmedCustomer(ConfirmedCustomer customer) {
		return customerDAO.mergeConfirmedCustomer(customer);
	}

	@Override
	public void persistConfirmedCustomer(ConfirmedCustomer customer) {
		customerDAO.persistConfirmedCustomer(customer);
	}
	
	@Override
	public ConfirmedCustomer findConfirmedCustomerByPeselAndPassword(String pesel, String password){
		return customerDAO.findConfirmedCustomerByPeselAndPassword(pesel, password);
	}

	@Override
	public void removeConfirmedCustomer(ConfirmedCustomer customer) {
		customerDAO.removeConfirmedCustomer(customer);
	}

}
