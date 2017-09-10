package carrent.core.web.beans.branch;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import carrent.core.ejb.dao.branch.BranchDAO;
import carrent.core.model.branch.Branch;

@ManagedBean(name = "branchBean")
@RequestScoped
public class BranchBean {

	private Branch branch;
	//private List<Branch> allBranches;
	
	@EJB
	private BranchDAO branchDAO;
	
	public BranchBean(){
		//allBranches = new ArrayList<Branch>();
	}
	
	public List<Branch> getAllBranches(){
		return branchDAO.fetchAllBranches();
	}

	/*public void setAllBranches(List<Branch> allBranches) {
		this.allBranches = allBranches;
	}*/

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
}
