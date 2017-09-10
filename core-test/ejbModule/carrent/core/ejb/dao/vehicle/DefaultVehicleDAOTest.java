package carrent.core.ejb.dao.vehicle;

import javax.annotation.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import carrent.core.model.vehicle.Vehicle;

@Generated(value = "org.junit-tools-1.0.6")
public class DefaultVehicleDAOTest {

	private DefaultVehicleDAO createTestSubject() {
		return new DefaultVehicleDAO();
	}

	@MethodRef(name = "findVehicleById", signature = "(QLong;)QVehicle;")
	@Test
	public void testFindVehicleById() throws Exception {
		DefaultVehicleDAO testSubject;
		Long id = null;
		Vehicle result;;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findVehicleById(id);
	}
}