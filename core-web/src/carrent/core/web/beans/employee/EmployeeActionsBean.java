package carrent.core.web.beans.employee;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import carrent.core.ejb.dao.branch.BranchDAO;
import carrent.core.ejb.dao.person.customer.ConfirmedCustomerDAO;
import carrent.core.ejb.dao.rent.RentDAO;
import carrent.core.ejb.dao.vehicle.VehicleDAO;
import carrent.core.model.branch.Branch;
import carrent.core.model.person.customer.ConfirmedCustomer;
import carrent.core.model.rent.Rent;
import carrent.core.model.vehicle.Vehicle;
import carrent.core.web.beans.customer.ConfirmedCustomerBean;

@ManagedBean
@RequestScoped
public class EmployeeActionsBean implements Serializable{

	
	private Vehicle vehicle;
	private Rent rent;
	private Branch branch;
	private ConfirmedCustomer customer;
	private List<Rent> rentsWithBookedStatus;
	private List<Rent> rentsWithRentedStatus;
	private Rent selectedRent;
	private String selectedRentId;
	//private List<UserInfo> userInfo;

	
	@ManagedProperty(value = "#{employeeBean}")
	private EmployeeBean employeeBean;
	
	
	@EJB
	private VehicleDAO vehicleDAO;
	
	@EJB
	private RentDAO rentDAO;
	
	@EJB
	private ConfirmedCustomerDAO customerDAO;
	
	@EJB
	private BranchDAO branchDAO;
	
	public EmployeeActionsBean() {
		vehicle = new Vehicle();
		setCustomer(new ConfirmedCustomer());
		branch = new Branch();
		rentsWithBookedStatus = new ArrayList<Rent>();
		rentsWithRentedStatus = new ArrayList<Rent>();
		setSelectedRent(new Rent());
		//userInfo = new ArrayList<UserInfo>();
	}

	public Long getId() {
		return vehicle.getId();
	}

	public void setId(Long id) {
		vehicle.setId(id);
	}

	public String getBrand() {
		return vehicle.getBrand();
	}

	public void setBrand(String brand) {
		vehicle.setBrand(brand);
	}

	public String getModel() {
		return vehicle.getModel();
	}

	public void setModel(String model) {
		vehicle.setModel(model);
	}

	@Override
	public String toString() {
		return "Brand: " + vehicle.getBrand() + ", model: " + vehicle.getModel();
	}

	public String getType() {
		return vehicle.getType();
	}

	public void setType(String type) {
		vehicle.setType(type);
	}

	public String getProd_year() {
		return vehicle.getProd_year();
	}

	public void setProd_year(String prod_year) {
		vehicle.setProd_year(prod_year);
	}

	public String getColor() {
		return vehicle.getColor();
	}

	public void setColor(String color) {
		vehicle.setColor(color);
	}

	public Integer getMileage() {
		return vehicle.getMileage();
	}

	public void setMileage(Integer mileage) {
		vehicle.setMileage(mileage);
	}

	public Integer getIs_Free() {
		return vehicle.getIs_Free();
	}

	public void setIs_Free(Integer is_Free) {
		vehicle.setIs_Free(is_Free);
	}

	public String getPhoto() {
		return vehicle.getPhoto();
	}

	public void setPhoto(String photo) {
		vehicle.setPhoto(photo);
	}

	public String getDescription() {
		return vehicle.getDescription();
	}

	public void setDescription(String description) {
		vehicle.setDescription(description);
	}

	public Long getId_Branch() {
		return vehicle.getId_Branch();
	}

	public void setId_Branch(Long id_Branch) {
		vehicle.setId_Branch(id_Branch);
	}
	
	public void setDprice(Integer dprice){
		vehicle.setDprice(dprice);
	}
	
	public Integer getDprice(){
		return vehicle.getDprice();
	}
	
	public Integer getPesel(){
		return null;
	}
	
	public Long getRentId(){
		return rent.getId();
	}
	
	public void setRentId(Long id){
		rent.setId(id);
	}
	
	public ConfirmedCustomer getRentCustomer(){
		return rent.getCustomer();
	}
	
	public void setRentCustomer(ConfirmedCustomer cust){
		rent.setCustomer(cust);
	}
	
	
	public void addVehicle(){
		//vehicle.setId(89L);
		vehicle.setId_Branch(employeeBean.getIdBranch());
		vehicle.setIs_Free(1);
		System.out.println(vehicle.toString());
		vehicleDAO.persistVehicle(vehicle);
	}

	public List<Rent> fetchRentsWithBookedStatus(){
		return rentDAO.findRentsWithBookedStatusById(branchDAO.findBranchById(employeeBean.getIdBranch()));
	}
	
	
	public List<Rent> fetchRentsWithRentedStatus(){
		return rentDAO.findRentsWithRentedStatusById(branchDAO.findBranchById(employeeBean.getIdBranch()));
	}
	
	
	public EmployeeBean getEmployeBean() {
		return employeeBean;
	}

	public void setEmployeBean(EmployeeBean employeBean) {
		this.employeeBean = employeBean;
	}
	
	
	public String getSelectedRentId() {
		return selectedRentId;
	}

	public void setSelectedRentId(String selectedRentId) {
		this.selectedRentId = selectedRentId;
	}

	public void changeRentStateToBooked(){
		//System.out.println("adadad"+rentInfo.getRentId());
		//selectedRent = rentDAO.findRent(Long.parseLong(rentInfo.getRentId()));
		selectedRent.setState("rented");
		selectedRent.setRentEmployee(employeeBean.getId());
		
		rentDAO.mergeRent(selectedRent);
		  changeContextTo("employee.mainpage.xhtml");
		//rentDAO.changeRentStateToBooked(selectedRent, employeBean.getId());
	}
	
	public void changeRentStateToReturned(){
		//System.out.println("adadad"+rentInfo.getRentId());
		//selectedRent = rentDAO.findRent(Long.parseLong(rentInfo.getRentId()));
		selectedRent.setState("returned");
		selectedRent.setReturnEmployee(employeeBean.getId());
		
		rentDAO.mergeRent(selectedRent);
		//rentDAO.changeRentStateToBooked(selectedRent, employeBean.getId());
		  vehicle = vehicleDAO.findVehicleById(selectedRent.getVehicle().getId());
		  vehicle.setIs_Free(1);
		  
		  vehicleDAO.mergeVehicle(vehicle);
		  changeContextTo("employee.mainpage.xhtml");
	}
	
	
	private void changeContextTo(String context) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(context);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Rent getSelectedRent() {
		return selectedRent;
	}

	public void setSelectedRent(Rent selectedRent) {
		this.selectedRent = selectedRent;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public ConfirmedCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(ConfirmedCustomer customer) {
		this.customer = customer;
	}
}
