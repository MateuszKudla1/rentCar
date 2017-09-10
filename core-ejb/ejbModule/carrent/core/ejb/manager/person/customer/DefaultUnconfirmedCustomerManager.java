package carrent.core.ejb.manager.person.customer;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import carrent.core.ejb.dao.person.customer.UnconfirmedCustomerDAO;
import carrent.core.ejb.manager.person.customer.UnconfirmedCustomerManager;
import carrent.core.model.person.customer.UnconfirmedCustomer;

@Stateless
public class DefaultUnconfirmedCustomerManager implements UnconfirmedCustomerManager{
	
	@EJB
	private UnconfirmedCustomerDAO unconfirmedCustomerDAO;

	@Override
	public void removeUnconfirmedCustomer(UnconfirmedCustomer unconfirmedCustomer) {
		unconfirmedCustomerDAO.removeUnconfirmedCustomer(unconfirmedCustomer);
	}

	@Override
	public void persistUnconfirmedCustomer(UnconfirmedCustomer unconfirmedCustomer) {
		unconfirmedCustomerDAO.persistUnconfirmedCustomer(unconfirmedCustomer);
	}

	@Override
	public UnconfirmedCustomer mergeUnconfirmedCustomer(UnconfirmedCustomer unconfirmedCustomer) {
		return unconfirmedCustomerDAO.mergeUnconfirmedCustomer(unconfirmedCustomer);
	}

	@Override
	public UnconfirmedCustomer findUnconfirmedCustomer(Long id) {
		UnconfirmedCustomer unconfirmedCustomer = unconfirmedCustomerDAO.findUnconfirmedCustomer(id);
		return unconfirmedCustomer;
	}

	@Override
	public List<UnconfirmedCustomer> findAllUnconfirmedCustomers() {
		return unconfirmedCustomerDAO.findAllUnconfirmedCustomers();
	}
	
	@Override
	public UnconfirmedCustomer findUnconfirmedCustomerByToken(String token) {
		return unconfirmedCustomerDAO.findUnconfirmedCustomerByToken(token);
	}
}
