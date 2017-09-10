package carrent.core.ejb.dao.rent;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import carrent.core.model.branch.Branch;
import carrent.core.model.person.customer.ConfirmedCustomer;
import carrent.core.model.person.employee.Employee;
import carrent.core.model.rent.Rent;
import carrent.core.model.vehicle.Vehicle;

@Stateless
public class DefaultRentDao implements RentDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void removeRent(Rent rent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void persistRent(Rent rent) {
		entityManager.persist(rent);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rent findRent(Long id) {
		return entityManager.find(Rent.class, id);
	}


	@Override
	public List<Rent> findAllRentsByCustomerId(ConfirmedCustomer customer) {
		
		return entityManager.createNamedQuery("Rent.find").setParameter("id", customer).getResultList();
	}

	@Override
	public List<Rent> findRentsWithBookedStatusById(Branch branch) {
		return entityManager.createNamedQuery("Rent.findRentsWithBookedStatus").setParameter("id", branch).getResultList();
	}

	@Override
	public List<Rent> findRentsWithRentedStatusById(Branch branch) {
		return entityManager.createNamedQuery("Rent.findRentsWithRentedStatus").setParameter("id", branch).getResultList();
	}


	@Override
	public Rent mergeRent(Rent rent) {
		return entityManager.merge(rent);
	}

}
