package carrent.core.ejb.dao.branch;

import java.util.List;

import javax.ejb.Local;

import carrent.core.model.branch.Branch;
import carrent.core.model.person.customer.ConfirmedCustomer;

@Local
public interface BranchDAO {
	
	List<Branch> fetchAllBranches();
	Branch findBranchById(Long id);
}
