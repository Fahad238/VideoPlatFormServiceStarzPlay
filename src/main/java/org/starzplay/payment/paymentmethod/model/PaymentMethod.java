/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.starzplay.payment.paymentmethod.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * The POJO class acts as Entity and TO
 * 
 * @author Fahad
 */
@Entity(name = "paymentMethods")
@Table(name = "payment_methods")
@JsonRootName(value = "paymentMethods")
@Component
public class PaymentMethod implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param name
	 * @param displayName
	 * @param paymentType
	 * @param paymentPlans
	 */
	public PaymentMethod(String name, String displayName, String paymentType, List<PaymentPlan> paymentPlans) {
		super();
		this.name = name;
		this.displayName = displayName;
		this.paymentType = paymentType;
		this.paymentPlans = paymentPlans;
	}

	public PaymentMethod() {
		super();
	}

	@Id
	@SequenceGenerator(name = "idGeneratorSeq", sequenceName = "idSequence")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "idGeneratorSeq")
	@Column(name = "paymentId")
	private long paymentId;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false, unique = true)

	private String displayName;

	@Column(nullable = false)

	private String paymentType;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "paymentId", referencedColumnName = "paymentId")

	private List<PaymentPlan> paymentPlans = new ArrayList<PaymentPlan>();

	@JsonIgnore
	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	@JsonProperty("name")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("displayName")

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@JsonProperty("paymentType")

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public List<PaymentPlan> getPaymentPlans() {
		return paymentPlans;
	}

	public void setPaymentPlans(List<PaymentPlan> paymentPlans) {
		this.paymentPlans = paymentPlans;
	}

}
