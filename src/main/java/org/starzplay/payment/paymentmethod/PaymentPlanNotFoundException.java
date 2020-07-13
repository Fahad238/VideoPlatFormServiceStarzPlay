package org.starzplay.payment.paymentmethod;
/**
 * 
 * @author Fahad
 *
 */

public class PaymentPlanNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PaymentPlanNotFoundException(Long id) {
    super("Could not find Payment Plan " + id);
  }
}