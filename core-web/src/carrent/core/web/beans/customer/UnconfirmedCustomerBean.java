package carrent.core.web.beans.customer;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.MessagingException;

import carrent.core.ejb.dao.person.customer.UnconfirmedCustomerDAO;
import carrent.core.ejb.mail.MailManager;
import carrent.core.ejb.mail.Token;
import carrent.core.model.person.EntityFactory;
import carrent.core.model.person.customer.UnconfirmedCustomer;

@ManagedBean
@javax.faces.bean.RequestScoped
public class UnconfirmedCustomerBean {
	
	private UnconfirmedCustomer unconfirmedCustomer;
	
	@EJB
	private UnconfirmedCustomerDAO dd;
	
	@EJB
	private Token token;
	
	@EJB
	private MailManager mailManager;

	public UnconfirmedCustomerBean() {
		unconfirmedCustomer = (UnconfirmedCustomer) new EntityFactory().PersonEntity("unconfirmedCustomer");
	}
	
	public String getPassword() {
		return unconfirmedCustomer.getPassword();
	}


	public void setPassword(String customerPassword) {
		unconfirmedCustomer.setPassword(customerPassword);
	}

	public String getFirstName() {
		return unconfirmedCustomer.getFirstName();
	}

	public Long getId() {
		return unconfirmedCustomer.getId();
	}


	public String getLastName() {
		return unconfirmedCustomer.getLastName();
	}

	public String getPesel() {
		return unconfirmedCustomer.getPesel();
	}

	public void setPesel(String pesel) {
		unconfirmedCustomer.setPesel(pesel);
	}


	public void setId(Long id) {
		unconfirmedCustomer.setId(id);
	}


	public void setFirstName(String firstName) {
		unconfirmedCustomer.setFirstName(firstName);
	}


	public void setLastName(String lastName) {
		unconfirmedCustomer.setLastName(lastName);
	}
	
	public void setMail(String mail) {
		unconfirmedCustomer.setMail(mail);
	}
	
	public String getMail() {
		return unconfirmedCustomer.getMail();
	}
	
	public String getToken() {
		return unconfirmedCustomer.getToken();
	}

	public void setToken(String token) {
		this.unconfirmedCustomer.setToken(token);
	}
	
	private String generateToken() {
		return token.getToken();
	}
	
	private void sendMail(){
		try {
			mailManager.send(unconfirmedCustomer.getFirstName()+ " " + unconfirmedCustomer.getLastName(), unconfirmedCustomer.getToken(), unconfirmedCustomer.getMail());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void save() {
		unconfirmedCustomer.setToken(generateToken());
		dd.persistUnconfirmedCustomer(unconfirmedCustomer);
		
		sendMail();
	}
}
