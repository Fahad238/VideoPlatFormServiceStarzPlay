package org.starzplay.payment.paymentmethod.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
/**
 * 
 * @author Fahad
 * 
 * The Parent TO class for Root Elemets in JSON
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"paymentMethods"
})

@Component
public class PaymentMethodParent {
	

@JsonProperty("paymentMethods")
private List<PaymentMethod> paymentMethods = null;

public List<PaymentMethod> getPaymentMethods() {
	return paymentMethods;
}

public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
	this.paymentMethods = paymentMethods;
}






}
