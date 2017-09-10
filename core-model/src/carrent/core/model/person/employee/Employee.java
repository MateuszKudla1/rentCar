package carrent.core.model.person.employee;

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
@Table(name="employee")
@NamedQueries({
	@NamedQuery(
			name = "Employee.findByPeselAndPassword", 
			query = "SELECT c FROM Employee c WHERE c.pesel=:pesel AND c.password=:password")
})
public class Employee implements PersonEntity, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
	@SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)
	private Long id;

	private String password;

	private String first_Name;

	private String last_Name;

	private String pesel;

	private Long id_Branch;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return first_Name;
	}

	public void setFirstName(String firstName) {
		this.first_Name = firstName;
	}

	public String getLastName() {
		return last_Name;
	}

	public void setLastName(String lastName) {
		this.last_Name = lastName;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public Long getIdBranch() {
		return id_Branch;
	}

	public void setIdBranch(Long id_Branch) {
		this.id_Branch = id_Branch;
	}

}
