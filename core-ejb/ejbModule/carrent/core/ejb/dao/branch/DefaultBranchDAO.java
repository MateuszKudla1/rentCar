package carrent.core.ejb.dao.branch;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import carrent.core.model.branch.Branch;

@Stateless
public class DefaultBranchDAO implements BranchDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Branch> fetchAllBranches() {
		// TODO Auto-generated method stub
		return entityManager.createNamedQuery("Branch.find").getResultList();
	}

	@Override
	public Branch findBranchById(Long id) {
		return entityManager.find(Branch.class, id);
	}
	
}
