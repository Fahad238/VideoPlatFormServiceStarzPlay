package org.starzplay.payment.paymentmethod.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Fahad 
 * The Entity and the TO object
 *
 */
@Entity(name = PaymentPlan.ENTITY_NAME)
@Table(name = PaymentPlan.TABLE_NAME)

@Component
public class PaymentPlan {
	static final String TABLE_NAME = "payment_plan";

	static final String ENTITY_NAME = "paymentPlan";

	public PaymentPlan() {
		super();
	}

	@Id
	@SequenceGenerator(name = "idGeneratorSeq", sequenceName = "idSequence")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "idGeneratorSeq")
	@Column(name = "planId")
	@JsonIgnore
	private long planId;


	@Column(name = "id")

	private long id;


	private PaymentMethod paymentMethods;

	@Column(nullable = false)

	private Double netAmount;

	@Column(nullable = false)
	@JsonProperty("taxAmount")
	@JsonIgnore

	private Double taxAmount;

	@Column(nullable = false)
	@JsonProperty("grossAmount")
	@JsonIgnore

	private Double grossAmount;

	@Column(nullable = false)

	private String currency;

	@Column(nullable = false)

	private String duration;

	public PaymentMethod getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(PaymentMethod paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	@JsonProperty("netAmount")

	public Double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}
	@JsonProperty("taxAmount")

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}
	@JsonProperty("grossAmount")

	public Double getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(Double grossAmount) {
		this.grossAmount = grossAmount;
	}

	@JsonProperty("id")

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	@JsonProperty("currency")

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@JsonProperty("duration")

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}
