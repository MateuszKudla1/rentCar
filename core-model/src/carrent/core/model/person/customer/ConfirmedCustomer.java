package carrent.core.model.person.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import carrent.core.model.person.PersonEntity;
import carrent.core.model.rent.Rent;
import carrent.core.model.vehicle.Vehicle;


@Entity
@Table(name="customer")
@NamedQueries({
	@NamedQuery(
			name = "ConfirmedCustomer.findByPeselAndPassword", 
			query = "SELECT c FROM ConfirmedCustomer c WHERE c.pesel=:pesel AND c.password=:password")
})
public class ConfirmedCustomer implements PersonEntity, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
	@SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", allocationSize = 1)
	private Long id;
	
	private String password;
	
	private String first_Name;
	
	private String last_Name;
	
	private String pesel;
	
	private String mail;
	
	private Long account_Balance;
	
	public Long getAccountBalance() {
		return account_Balance;
	}

	public void setAccountBalance(Long accountBalance) {
		this.account_Balance = accountBalance;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String customerPassword) {
		this.password = customerPassword;
	}

	@Override
	public String getFirstName() {
		return first_Name;
	}

	@Override
	public Long getId() {
		return id;
	}


	@Override
	public String getLastName() {
		return last_Name;
	}

	@Override
	public String getPesel() {
		return pesel;
	}

	@Override
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public void setFirstName(String firstName) {
		this.first_Name = firstName;
	}

	@Override
	public void setLastName(String lastName) {
		this.last_Name = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Override
	public String toString(){
		return first_Name + " " + last_Name + " Pesel:" + pesel;
	}
}
