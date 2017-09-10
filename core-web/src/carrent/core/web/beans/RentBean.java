package carrent.core.web.beans;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.mail.MessagingException;

import org.primefaces.context.RequestContext;

import com.itextpdf.text.DocumentException;

import carrent.core.ejb.dao.branch.BranchDAO;
import carrent.core.ejb.dao.rent.RentDAO;
import carrent.core.ejb.dao.vehicle.VehicleDAO;
import carrent.core.ejb.mail.MailManager;
import carrent.core.ejb.pdf.PDFgenerator;
import carrent.core.model.branch.Branch;
import carrent.core.model.rent.Rent;
import carrent.core.model.vehicle.Vehicle;
import carrent.core.web.beans.customer.ConfirmedCustomerBean;

@ManagedBean(name = "rentBean")
@SessionScoped
public class RentBean implements Serializable{
	
	private Branch branch;
	public Branch getBranch() {
		return branch;
	}

	private Date rentDate;
	private Date returnDate;
	private List<Branch> allBranches;
	private List<Vehicle> availableCars;
	private Vehicle selectedCar;
	private Vehicle rentCar;
	
	
	public Vehicle getRentCar(String id) {
		return rentCar;
	}





	public void setRentCar(Vehicle rentCar) {
		this.rentCar = rentCar;
	}

	private String branchid;
	private String returnBranchid;
	private List<Rent> allRents;
	private Rent selectedRent;
	
	
	public Rent getSelectedRent() {
		return selectedRent;
	}





	public void setSelectedRent(Rent selectedRent) {
		this.selectedRent = selectedRent;
	}





	public List<Rent> getAllRents() {
		return rentDAO.findAllRentsByCustomerId(customerBean.getConfirmedCustomer());
	}





	public void setAllRents(List<Rent> allRents) {
		this.allRents = allRents;
	}





	public String getReturnBranchid() {
		return returnBranchid;
	}





	public void setReturnBranchid(String returnBranchid) {
		this.returnBranchid = returnBranchid;
	}

	private long price;
	private Rent rent;
	
	@ManagedProperty(value="#{confirmedCustomerBean}")
	private ConfirmedCustomerBean customerBean;
	
	
	
	public ConfirmedCustomerBean getCustomerBean() {
		return customerBean;
	}





	public void setCustomerBean(ConfirmedCustomerBean customerBean) {
		this.customerBean = customerBean;
	}





	public Rent getRent() {
		return rent;
	}





	public void setRent(Rent rent) {
		this.rent = rent;
	}

	public long getPrice() {
		long diff = getDifferenceDays(rentDate,returnDate);
		price = (diff * selectedCar.getDprice());
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getBranchid() {
		return branchid;
	}

	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}

	public Vehicle getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Vehicle selectedCar) {
		this.selectedCar = selectedCar;
	}

	public List<Vehicle> getAvailableCars() {
		return availableCars;
	}
	
	public void redirect(){
		changeContextTo("details.xhtml");
	}

	

	public void setAvailableCars(List<Vehicle> availableCars) {
		this.availableCars = availableCars;
	}



	public RentBean(){
		allBranches = new ArrayList<Branch>();
		availableCars = new ArrayList<Vehicle>();
		allRents = new ArrayList<Rent>();
	}
	
	@EJB
	private BranchDAO branchDAO;
	
	@EJB
	private VehicleDAO vehicleDAO;
	
	@EJB
	private RentDAO rentDAO;
	
	
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





	public void setBranch(Branch branch) {
		this.branch = branch;
	}


	
	public void setAllBranches(List<Branch> allBranches) {
		this.allBranches = allBranches;
	}

	
	@EJB
	PDFgenerator pdfGenerator;
	
	@EJB
	MailManager mailManager;
	
	public void rentVehicle(){
		rent = new Rent();
	
		rent.setRentBranch(branchDAO.findBranchById(Long.parseLong(getBranchid())));
		
		Long l = Long.parseLong(getReturnBranchid());
		Branch b = new Branch();
		b = branchDAO.findBranchById(l);
	
		rent.setReturnBranch(b);
		rent.setRentDate(getRentDate());
		rent.setReturnDate(getReturnDate());
		rent.setVehicle(getSelectedCar());
		rent.setCost(getPrice());
		rent.setState("booked");
		rent.setCustomer(customerBean.getConfirmedCustomer());
		getSelectedCar().setIs_Free(0);
		vehicleDAO.mergeVehicle(getSelectedCar());
		rentDAO.persistRent(rent);
		
		try {
		pdfGenerator.createPdf(customerBean.getConfirmedCustomer(), rent);

			mailManager.sendInvoice(customerBean.getFirstName() + customerBean.getLastName(),
				customerBean.getMail());

	} catch (IOException | DocumentException | MessagingException e) {

		}
		changeContextTo("rent.success.xhtml");
		
	}
		

	public void findAvailableCars(){
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd"); 
		Date one = getRentDate();
		Date two = getReturnDate();
		String oneS = df.format(one); 
		String twoS = df.format(two);
		
		
	availableCars = vehicleDAO.findAllAvailableCarsByCityAndDate(oneS,twoS,branchid);
		changeContextTo("rent.xhtml");
		 
	}
	
	public List<Branch> getAllBranches() {
		return branchDAO.fetchAllBranches();
	}

	private void changeContextTo(String context) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(context);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static long getDifferenceDays(Date d1, Date d2) {
	    long diff = d2.getTime() - d1.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	
	public void findRent(){
		if(!(selectedRent.getState().equals("changed") || selectedRent.getState().equals("returned")) ){
			Long l = Long.parseLong(branchid);
			Branch b = new Branch();
			b = branchDAO.findBranchById(l);
		selectedRent.setReturnBranch(b);
		selectedRent.setState("changed");
		rentDAO.mergeRent(selectedRent);
		Vehicle vehicle = new Vehicle();
		vehicle = vehicleDAO.findVehicleById(selectedRent.getVehicle().getId());
		vehicle.setIs_Free(2);
		vehicleDAO.mergeVehicle(vehicle);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "you have changed destination");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		changeContextTo("customer.history.xhtml");
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "STOP", "you have already once changed destination");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
	}

	
	
	
	
	

}
