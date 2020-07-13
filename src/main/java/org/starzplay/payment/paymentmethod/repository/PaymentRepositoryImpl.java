package org.starzplay.payment.paymentmethod.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.starzplay.payment.paymentmethod.model.PaymentMethod;
import org.starzplay.payment.paymentmethod.model.PaymentMethodParent;

/**
 * 
 * @author Fahad The Repository class for executing and retrieving the result
 */
@Repository
public class PaymentRepositoryImpl {

	/**
	 * 
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @param paymentMethods
	 * @return
	 */
	@Transactional
	public PaymentMethodParent save(PaymentMethodParent paymentMethods) {

		for (PaymentMethod paymentMethod : paymentMethods.getPaymentMethods()) {

			em.persist(paymentMethod);

		}

		return paymentMethods;

	}

	/**
	 * 
	 * @param id
	 * @param paymentMethod
	 * @return
	 */

	@Transactional
	public PaymentMethodParent update(long id, PaymentMethodParent paymentMethod) {

		PaymentMethod paymentMethodUpdated = em.find(PaymentMethod.class, id);
		paymentMethodUpdated.setDisplayName(paymentMethod.getPaymentMethods().get(0).getDisplayName());
		paymentMethodUpdated.setName(paymentMethod.getPaymentMethods().get(0).getName());
		paymentMethodUpdated.setPaymentType(paymentMethod.getPaymentMethods().get(0).getPaymentType());
		paymentMethodUpdated.setPaymentPlans(paymentMethod.getPaymentMethods().get(0).getPaymentPlans());
		PaymentMethodParent payment = new PaymentMethodParent();
		List<PaymentMethod> paymentMethodList = new ArrayList<PaymentMethod>();
		paymentMethodList.add(paymentMethodUpdated);
		payment.setPaymentMethods(paymentMethodList);
		return payment;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public PaymentMethodParent getPaymentMethodById(long id) {
		@SuppressWarnings("unchecked")
		List<PaymentMethod> listOfPaymentMethods = em
				.createQuery("SELECT e FROM paymentMethods e LEFT JOIN FETCH e.paymentPlans where e.id = :id")
				.setParameter("id", id).getResultList();
		PaymentMethodParent parent = new PaymentMethodParent();
		parent.setPaymentMethods(listOfPaymentMethods);
		return parent;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public PaymentMethodParent getPaymentMethodByName(String name) {
		// SELECT a FROM Author a LEFT JOIN FETCH a.books

		@SuppressWarnings("unchecked")
		List<PaymentMethod> listOfPaymentMethods = em
				.createQuery("SELECT e FROM paymentMethods e LEFT JOIN FETCH e.paymentPlans where e.name = :name")
				.setParameter("name", name).getResultList();
		PaymentMethodParent parent = new PaymentMethodParent();
		parent.setPaymentMethods(listOfPaymentMethods);
		return parent;
	}

	/**
	 * 
	 * @return
	 */
	public PaymentMethodParent getAllPaymentMethod() {
		@SuppressWarnings("unchecked")

		List<PaymentMethod> listOfPaymentMethods = em
				.createQuery("SELECT e FROM paymentMethods e LEFT JOIN FETCH e.paymentPlans").getResultList();
		PaymentMethodParent parent = new PaymentMethodParent();
		parent.setPaymentMethods(listOfPaymentMethods);
		return parent;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
