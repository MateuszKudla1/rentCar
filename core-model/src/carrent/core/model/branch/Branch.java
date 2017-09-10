package carrent.core.model.branch;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "Branch.find", query = "SELECT c FROM Branch c")
public class Branch implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branch_sequence")
	@SequenceGenerator(name = "branch_sequence", sequenceName = "branch_sequence", allocationSize = 1)
	private Long id;
	private String city;
	private String phone;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
    @Override
    public boolean equals(Object other) {
        return (other instanceof Branch) && (id != null)
            ? id.equals(((Branch) other).id)
            : (other == this);
    }

    @Override
    public int hashCode() {
        return (id != null)
            ? (this.getClass().hashCode() + id.hashCode())
            : super.hashCode();
    }
	
    @Override
    public String toString() {
        return  city;
    }
}
