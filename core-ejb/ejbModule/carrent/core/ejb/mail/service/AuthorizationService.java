package carrent.core.ejb.mail.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import carrent.core.model.person.customer.UnconfirmedCustomer;
import carrent.core.ejb.dao.person.customer.ConfirmedCustomerDAO;
import carrent.core.ejb.dao.person.customer.UnconfirmedCustomerDAO;
import carrent.core.ejb.manager.person.customer.ConfirmedCustomerManager;
import carrent.core.ejb.manager.person.customer.UnconfirmedCustomerManager;
import carrent.core.model.person.customer.ConfirmedCustomer;

@Stateless
public class AuthorizationService {
	
	private UnconfirmedCustomer unconfirmedCustomer;
	
	private ConfirmedCustomer confirmedCustomer;
	
	@EJB
	private UnconfirmedCustomerDAO unconfirmedCustomerDAO;
	
	@EJB
	private ConfirmedCustomerDAO confirmedCustomerDAO;
	
	public AuthorizationService() {
		// TODO Auto-generated constructor stub
	}

	public void authorizeCustomer(String token) {
		unconfirmedCustomer = unconfirmedCustomerDAO.findUnconfirmedCustomerByToken(token);
		
		unconfirmedCustomerDAO.removeUnconfirmedCustomer(unconfirmedCustomer);
		
		confirmedCustomer = new ConfirmedCustomer();
		
		confirmedCustomer.setFirstName(unconfirmedCustomer.getFirstName());
		confirmedCustomer.setLastName(unconfirmedCustomer.getLastName());
		confirmedCustomer.setAccountBalance(0L);
		confirmedCustomer.setPassword(unconfirmedCustomer.getPassword());
		confirmedCustomer.setPesel(unconfirmedCustomer.getPesel());
		confirmedCustomer.setMail(unconfirmedCustomer.getMail());
		
		confirmedCustomerDAO.persistConfirmedCustomer(confirmedCustomer);
		
	}

}
