package carrent.core.model.rent;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import carrent.core.model.branch.Branch;
import carrent.core.model.person.customer.ConfirmedCustomer;
import carrent.core.model.vehicle.Vehicle;

@Entity
@Table(name="rent")
@NamedQueries({
	@NamedQuery(
			name = "Rent.findRentsWithBookedStatus", 
			query = "SELECT c FROM Rent c WHERE (c.state='booked' or c.state='changed') AND c.rentBranch =:id"),
	@NamedQuery(
			name = "Rent.findRentsWithRentedStatus", 
			query = "SELECT c FROM Rent c WHERE c.state='rented' AND c.returnBranch =:id"),
	@NamedQuery(
			name = "Rent.find",
			query = "SELECT c FROM Rent c WHERE c.customer = :id")
})
public class Rent implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rent_sequence")
	@SequenceGenerator(name = "rent_sequence", sequenceName = "rent_sequence", allocationSize = 1)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_CUSTOMER")
	private ConfirmedCustomer customer;

	@ManyToOne
	@JoinColumn(name="ID_VEHICLE", nullable = false)
	private Vehicle vehicle;
	
	
	@Column(name="ID_RENT_EMP")
	private Long rentEmployee;
	
	
	@Column(name="ID_RETURN_EMP")
	private Long returnEmployee;
	
	@ManyToOne
	@JoinColumn(name="ID_RENT_BRANCH", nullable = false)
	private Branch rentBranch;
	
	@ManyToOne
	@JoinColumn(name="ID_RETURN_BRANCH", nullable = false)
	private Branch returnBranch;
	
	
	@Column(name="STATE", nullable = false)
	private String state;
	@Column(name="COST", nullable = false)
	private Long cost;
	@Column(name="RENT_DATE", nullable = false)
	private Date rentDate;
	@Column(name="RETURN_DATE", nullable = false)
	private Date returnDate;

	
	public Rent() {

	}
	
	public ConfirmedCustomer getCustomer() {
		return customer;
	}
	
	public void setCustomer(ConfirmedCustomer customer) {
		this.customer = customer;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}
	


	public Long getRentEmployee() {
		return rentEmployee;
	}

	public void setRentEmployee(Long rentEmployee) {
		this.rentEmployee = rentEmployee;
	}

	public Long getReturnEmployee() {
		return returnEmployee;
	}

	public void setReturnEmployee(Long returnEmployee) {
		this.returnEmployee = returnEmployee;
	}

	public Branch getRentBranch() {
		return rentBranch;
	}

	public void setRentBranch(Branch rentBranch) {
		this.rentBranch = rentBranch;
	}

	public Branch getReturnBranch() {
		return returnBranch;
	}

	public void setReturnBranch(Branch returnBranch) {
		this.returnBranch = returnBranch;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
}
