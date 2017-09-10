package carrent.core.model.vehicle;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Vehicle implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_sequence")
	@SequenceGenerator(name = "vehicle_sequence", sequenceName = "vehicle_sequence", allocationSize = 1)
	private Long id;
	@Column(name="BRAND")
	private String brand;
	@Column(name="MODEL")
	private String model;
	@Column(name="TYPE")
	private String type;
	@Column(name="PROD_YEAR")
	private String prod_year;
	@Column(name="COLOR")
	private String color;
	@Column(name="MILEAGE")
	private Integer mileage;
	@Column(name="IS_FREE")
	private Integer is_Free; 
	@Column(name="PHOTO")
	private String photo;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="ID_BRANCH")
	private Long id_Branch;
	@Column(name="DPRICE")
	private Integer dprice;
	
	





	public Integer getDprice() {
		return dprice;
	}

	public void setDprice(Integer dprice) {
		this.dprice = dprice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Brand: " + brand + ", model: " + model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProd_year() {
		return prod_year;
	}

	public void setProd_year(String prod_year) {
		this.prod_year = prod_year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public Integer getIs_Free() {
		return is_Free;
	}

	public void setIs_Free(Integer is_Free) {
		this.is_Free = is_Free;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId_Branch() {
		return id_Branch;
	}

	public void setId_Branch(Long id_Branch) {
		this.id_Branch = id_Branch;
	}
	
	
}
