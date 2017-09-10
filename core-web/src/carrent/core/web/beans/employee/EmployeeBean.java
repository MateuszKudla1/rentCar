package carrent.core.web.beans.employee;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import carrent.core.ejb.dao.person.employee.EmployeeDAO;
import carrent.core.model.person.EntityFactory;
import carrent.core.model.person.employee.Employee;
import carrent.core.web.beans.customer.ConfirmedCustomerBean;

@ManagedBean(name = "employeeBean")
@SessionScoped
public class EmployeeBean implements Serializable {

	@EJB
	private EmployeeDAO employeeDAO;

	@ManagedProperty(value="#{confirmedCustomerBean}")
	private ConfirmedCustomerBean confirmedCustomerBean;
	
	private Employee employee;

	public EmployeeBean() {
		employee = (Employee) new EntityFactory().PersonEntity("employee");
	}
	
	public ConfirmedCustomerBean getConfirmedCustomerBean() {
		return confirmedCustomerBean;
	}

	public void setConfirmedCustomerBean(ConfirmedCustomerBean confirmedCustomerBean) {
		this.confirmedCustomerBean = confirmedCustomerBean;
	}

	public Long getIdBranch() {
		return employee.getIdBranch();
	}

	public void setIdBranch(Long id_Branch) {
		employee.setIdBranch(id_Branch);
	}

	public String getPassword() {
		return employee.getPassword();
	}

	public void setPassword(String customerPassword) {
		employee.setPassword(customerPassword);
	}

	public String getFirstName() {
		return employee.getFirstName();
	}

	public Long getId() {
		return employee.getId();
	}

	public String getLastName() {
		return employee.getLastName();
	}

	public String getPesel() {
		return employee.getPesel();
	}

	public void setPesel(String pesel) {
		employee.setPesel(pesel);
	}

	public void setId(Long id) {
		employee.setId(id);
	}

	public void setFirstName(String firstName) {
		employee.setFirstName(firstName);
	}

	public void setLastName(String lastName) {
		employee.setLastName(lastName);
	}

	private void changeContextTo(String context) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(context);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void isEmployeeRegistered() {
		String pesel = employee.getPesel();
		String password = employee.getPassword();
		System.out.println(":" + pesel + ":"+ ":" + password + ":");
		Employee fetchedEmployee = employeeDAO.findEmployeeByPeselAndPassword(pesel, password);
		System.out.println(fetchedEmployee);
		if(fetchedEmployee == null) {
			confirmedCustomerBean.setPassword(password);
			confirmedCustomerBean.setPesel(pesel);
			confirmedCustomerBean.isConfirmedUserRegistered();
		}
		else {
			this.employee = fetchedEmployee;
			changeContextTo("employee.mainpage.xhtml");
		}
	}

}
