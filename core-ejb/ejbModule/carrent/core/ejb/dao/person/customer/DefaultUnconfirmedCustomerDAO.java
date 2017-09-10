package carrent.core.ejb.dao.person.customer;

import java.util.List;

import javax.ejb.Stateless;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import carrent.core.model.person.customer.UnconfirmedCustomer;



@Stateless
public class DefaultUnconfirmedCustomerDAO implements UnconfirmedCustomerDAO {

	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public UnconfirmedCustomer findUnconfirmedCustomer(Long id) {
		return entityManager.find(UnconfirmedCustomer.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UnconfirmedCustomer> findAllUnconfirmedCustomers() {
		return entityManager.createNamedQuery("UnconfirmedCustomer.find").getResultList();
	}

	@Override
	public UnconfirmedCustomer mergeUnconfirmedCustomer(UnconfirmedCustomer unconfirmedCustomer) {
		return entityManager.merge(unconfirmedCustomer);
	}

	@Override
	public void persistUnconfirmedCustomer(UnconfirmedCustomer unconfirmedCustomer) {
		entityManager.persist(unconfirmedCustomer);
	}

	@Override
	public void removeUnconfirmedCustomer(UnconfirmedCustomer unconfirmedCustomer) {
		entityManager.remove(unconfirmedCustomer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public UnconfirmedCustomer findUnconfirmedCustomerByToken(String token){
		Query query = entityManager.createNamedQuery("UnconfirmedCustomer.findByToken").setParameter("token", token);
		if(query.getResultList().size() == 0)
			return null;
		UnconfirmedCustomer unconfirmedCustomer = (UnconfirmedCustomer) query.getResultList().get(0);
		return unconfirmedCustomer;
	}

}
