package carrent.core.model.person.customer;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import carrent.core.model.person.PersonEntity;



@Entity
@Table(name = "unconfirmed_customer")
@NamedQueries({
	
		@NamedQuery(name = "UnconfirmedCustomer.find", query = "SELECT u FROM UnconfirmedCustomer u"),
		@NamedQuery(name = "UnconfirmedCustomer.findByToken", query = "SELECT uc FROM UnconfirmedCustomer uc WHERE uc.token=:token")})
public class UnconfirmedCustomer implements PersonEntity, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unconfirmed_customer_sequence")
	@SequenceGenerator(name = "unconfirmed_customer_sequence", sequenceName = "unconfirmed_customer_sequence", allocationSize = 1)
	private Long id;

	private String password;

	private String first_Name;

	private String last_Name;

	private String pesel;

	private String mail;

	private String token;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getFirstName() {
		return first_Name;
	}

	@Override
	public void setFirstName(String firstName) {
		this.first_Name = firstName;
	}

	@Override
	public String getLastName() {
		return last_Name;
	}

	@Override
	public void setLastName(String lastName) {
		this.last_Name = lastName;
	}

	@Override
	public String getPesel() {
		return pesel;
	}

	@Override
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
