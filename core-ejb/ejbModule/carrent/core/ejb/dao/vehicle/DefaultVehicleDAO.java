package carrent.core.ejb.dao.vehicle;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import carrent.core.model.branch.Branch;
import carrent.core.model.person.customer.ConfirmedCustomer;
import carrent.core.model.vehicle.Vehicle;

@Stateless
public class DefaultVehicleDAO implements VehicleDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> findAllAvailableCarsByCityAndDate(String rentDate,String returnDate, String id) {

		DateFormat df = new SimpleDateFormat("yyyy/MM/dd"); 
		Date rent = null;
		try {
			rent = df.parse(rentDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date rent2 = null;
		try {
			rent2 = df.parse(returnDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int i = Integer.parseInt(id);
		String query = "SELECT * FROM VEHICLE c WHERE NOT EXISTS (SELECT 1 FROM RENT r"
                  						+" WHERE r.ID_VEHICLE = c.ID"+
                  							" AND r.RENT_DATE <= :returnDate"
                  						 +" AND r.RETURN_DATE >= :startDate)"
										 + "  AND c.ID_BRANCH = :id";
		Query q =entityManager.createNativeQuery(query,Vehicle.class);
		
		q.setParameter("returnDate", rent).setParameter("startDate", rent2).setParameter("id", i);
		List<Vehicle> list = q.getResultList();

		
		return list;
	}
	
	@Override
	public void persistVehicle(Vehicle vehicle) {
		entityManager.persist(vehicle);
	}

	@Override
	public Vehicle findVehicleById(Long id) {
		return entityManager.find(Vehicle.class, id);
	}
	

	@Override
	public void mergeVehicle(Vehicle vehicle) {
		entityManager.merge(vehicle);
		
	}

}
