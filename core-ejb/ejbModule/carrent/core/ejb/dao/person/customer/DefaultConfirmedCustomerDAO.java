package carrent.core.ejb.dao.person.customer;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import carrent.core.ejb.dao.person.customer.ConfirmedCustomerDAO;
import carrent.core.model.person.customer.ConfirmedCustomer;
import carrent.core.model.person.customer.UnconfirmedCustomer;

@Stateless
public class DefaultConfirmedCustomerDAO implements ConfirmedCustomerDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void removeConfirmedCustomer(ConfirmedCustomer customer) {
		entityManager.remove(customer);
	}

	@Override
	public void persistConfirmedCustomer(ConfirmedCustomer customer) {
		entityManager.persist(customer);
	}

	@Override
	public ConfirmedCustomer mergeConfirmedCustomer(ConfirmedCustomer customer) {
		return entityManager.merge(customer);
	}

	@Override
	public ConfirmedCustomer findConfirmedCustomer(Long id) {
		return entityManager.find(ConfirmedCustomer.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConfirmedCustomer> findAllConfirmedCustomers() {
		return entityManager.createNamedQuery("ConfirmedCustomer.find").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ConfirmedCustomer findConfirmedCustomerByPeselAndPassword(String pesel, String password) {
		Query query = entityManager.createNamedQuery("ConfirmedCustomer.findByPeselAndPassword")
				.setParameter("pesel", pesel).setParameter("password", password);
		if (query.getResultList().size() == 0)
			return null;
		ConfirmedCustomer confirmedCustomer = (ConfirmedCustomer) query.getResultList().get(0);
		return confirmedCustomer;
	}

}
