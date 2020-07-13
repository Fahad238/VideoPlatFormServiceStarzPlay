package org.starzplay.payment.paymentmethod.junit;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.starzplay.payment.paymentmethod.model.PaymentMethodParent;
import org.starzplay.payment.paymentmethod.repository.PaymentRepositoryImpl;

import com.google.gson.Gson;

/**
 * 
 * @author Fahad
 * JUnit class for testing implementation
 *
 */
@RunWith(SpringRunner.class)

public class PaymentRepositoryTest {


	
	private static final int ID = 1;

	@InjectMocks
	private  PaymentRepositoryImpl paymentRepo;
	
	@MockBean
	private   EntityManager em;
	
	@Before
	public  void onlyOnce()
	{
		paymentRepo=new PaymentRepositoryImpl();
		paymentRepo.setEm(em);
		

	}
/**
 * 
 */
	
	
	@Test
	public void whenValidJSON_thenSaveTheDataInDatabase() {
		
		String json = "{\"paymentMethods\":[{\"name\":\"_lb\",\"displayName\":\"Alfa Lebanon\",\"paymentType\":\"MOBILE_CARRIER\",\"paymentPlans\":[{\"id\":72,\"netAmount\":5.99,\"taxAmount\":0,\"grossAmount\":5.99,\"currency\":\"USD\",\"duration\":\"Month\"}]}]}";
		Gson gson = new Gson();
		PaymentMethodParent paymentMethodPar = gson.fromJson(json, PaymentMethodParent.class);
		
		
		PaymentMethodParent pay=	paymentRepo.save(paymentMethodPar);
	
		
		Assert.assertTrue(paymentMethodPar.getPaymentMethods().get(0).getName().equalsIgnoreCase(pay.getPaymentMethods().get(0).getName()));
	}
	
	
	
}
