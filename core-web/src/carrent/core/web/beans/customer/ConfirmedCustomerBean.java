package carrent.core.web.beans.customer;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import carrent.core.ejb.dao.person.customer.ConfirmedCustomerDAO;
import carrent.core.model.person.EntityFactory;
import carrent.core.model.person.customer.ConfirmedCustomer;


@ManagedBean(name = "confirmedCustomerBean")
@SessionScoped
public class ConfirmedCustomerBean implements Serializable{

	private ConfirmedCustomer confirmedCustomer;

	@EJB
	private ConfirmedCustomerDAO confirmedCustomerDAO;

	public ConfirmedCustomerBean() {
		confirmedCustomer = (ConfirmedCustomer) new EntityFactory().PersonEntity("confirmedCustomer");
	}

	public ConfirmedCustomer getConfirmedCustomer() {
		return confirmedCustomer;
	}

	public void setConfirmedCustomer(ConfirmedCustomer confirmedCustomer) {
		this.confirmedCustomer = confirmedCustomer;
	}

	public String getPassword() {
		return confirmedCustomer.getPassword();
	}

	public void setPassword(String customerPassword) {
		confirmedCustomer.setPassword(customerPassword);
	}

	public String getFirstName() {
		return confirmedCustomer.getFirstName();
	}

	public Long getId() {
		return confirmedCustomer.getId();
	}

	public String getLastName() {
		return confirmedCustomer.getLastName();
	}

	public String getPesel() {
		return confirmedCustomer.getPesel();
	}

	public void setPesel(String pesel) {
		confirmedCustomer.setPesel(pesel);
	}

	public void setId(Long id) {
		confirmedCustomer.setId(id);
	}

	public void setFirstName(String firstName) {
		confirmedCustomer.setFirstName(firstName);
	}

	public void setLastName(String lastName) {
		confirmedCustomer.setLastName(lastName);
	}

	public void setAccountBalance(Long accountBalance) {
		confirmedCustomer.setAccountBalance(accountBalance);
	}

	public Long getAccountBalance() {
		return confirmedCustomer.getAccountBalance();
	}

	public void setMail(String mail) {
		confirmedCustomer.setMail(mail);
	}
	
	public String getMail() {
		return confirmedCustomer.getMail();
	}


	private void changeContextTo(String context) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(context);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void isConfirmedUserRegistered() {
		String pesel = confirmedCustomer.getPesel();
		String password = confirmedCustomer.getPassword();
		ConfirmedCustomer fetchedConfirmedCustomer = confirmedCustomerDAO.findConfirmedCustomerByPeselAndPassword(pesel,
				password);
		if (fetchedConfirmedCustomer == null) {
			changeContextTo("fail.xhtml");
			return;
		} else
			this.confirmedCustomer = fetchedConfirmedCustomer;
		changeContextTo("customer.mainpage.xhtml");
		return;
	}

	public void updateCustomerPersonalData() {
		confirmedCustomer.setFirstName(getFirstName());
		confirmedCustomer.setLastName(getLastName());
		confirmedCustomer.setPassword(getPassword());

		confirmedCustomerDAO.mergeConfirmedCustomer(confirmedCustomer);
	}




	
}
