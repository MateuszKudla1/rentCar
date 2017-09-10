package carrent.core.ejb.dao.rent;

import java.util.List;

import carrent.core.model.branch.Branch;
import carrent.core.model.person.customer.ConfirmedCustomer;
import carrent.core.model.person.employee.Employee;
import carrent.core.model.rent.Rent;

public interface RentDAO {
	
	void removeRent(Rent rent);

	void persistRent(Rent rent);

	Rent findRent(Long id);
	Rent mergeRent(Rent rent);

	List<Rent> findAllRentsByCustomerId(ConfirmedCustomer customer);
	List<Rent> findRentsWithBookedStatusById(Branch branch);
	List<Rent> findRentsWithRentedStatusById(Branch Branch);
}
