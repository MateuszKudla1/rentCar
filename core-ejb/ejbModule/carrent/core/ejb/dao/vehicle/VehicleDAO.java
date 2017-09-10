package carrent.core.ejb.dao.vehicle;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import carrent.core.model.vehicle.Vehicle;


@Local
public interface VehicleDAO {
	
	void mergeVehicle(Vehicle vehicle);
	Vehicle findVehicleById(Long id);
	List<Vehicle> findAllAvailableCarsByCityAndDate(String rentDate,String returnDate,String id); 
	void persistVehicle(Vehicle vehicle);
}
