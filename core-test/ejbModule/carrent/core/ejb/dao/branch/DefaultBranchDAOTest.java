package carrent.core.ejb.dao.branch;

import java.util.List;

import javax.annotation.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import carrent.core.model.branch.Branch;

@Generated(value = "org.junit-tools-1.0.6")
public class DefaultBranchDAOTest {

	private DefaultBranchDAO createTestSubject() {
		return new DefaultBranchDAO();
	}

	@MethodRef(name = "fetchAllBranches", signature = "()QList<QBranch;>;")
	@Test
	public void testFetchAllBranches() throws Exception {
		DefaultBranchDAO testSubject;
		List<Branch> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.fetchAllBranches();
	}

	@MethodRef(name = "findBranchById", signature = "(QLong;)QBranch;")
	@Test
	public void testFindBranchById() throws Exception {
		DefaultBranchDAO testSubject;
		Long id = null;
		Branch result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findBranchById(id);
	}
}