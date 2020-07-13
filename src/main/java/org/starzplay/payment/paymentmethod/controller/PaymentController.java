/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.starzplay.payment.paymentmethod.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.starzplay.payment.paymentmethod.model.PaymentMethod;
import org.starzplay.payment.paymentmethod.model.PaymentMethodParent;
import org.starzplay.payment.paymentmethod.repository.PaymentRepositoryImpl;

/**
 *
 * @author Fahad
 * The Spring Controller class responsible for handling all the request and serving the responses 
 * 
 */
@RestController()
@RequestMapping(PaymentController.END_POINTS)

public class PaymentController {

	static final String END_POINTS = "/api/v1.0/configuration/payment-methods";

	@Value("${spring.application.name}")
	String appName;

	@Autowired
	PaymentMethod paymentMethod;

	@Autowired
	private PaymentRepositoryImpl paymentRepo;

	@PostMapping()
	public PaymentMethodParent newPaymentMethod(@RequestBody PaymentMethodParent paymentMethod) {
		return paymentRepo.save(paymentMethod);
	}
/**
 * 
 * @param id
 * @param paymentMethod
 * @return
 */
	@PutMapping("/{id}")

	public PaymentMethodParent updatePaymentMethod(@PathVariable(value = "id") long id,
			@Valid @RequestBody PaymentMethodParent paymentMethod) {
		return paymentRepo.update(id, paymentMethod);

	}
/**
 * 
 * @param id
 * @param name
 * @return
 */
	@GetMapping()
	public ResponseEntity<PaymentMethodParent> getAllPaymentMethods(@RequestParam(required = false) Long id,
			@RequestParam(required = false) String name)

	{
		PaymentMethodParent paymentMethodParent = null;
		if (StringUtils.isNotEmpty(name)) {
			paymentMethodParent = paymentRepo.getPaymentMethodByName(name);

		} else if (id != null) {
			paymentMethodParent = paymentRepo.getPaymentMethodById(id);
		} else {
			paymentMethodParent = paymentRepo.getAllPaymentMethod();
		}

		return new ResponseEntity<PaymentMethodParent>(paymentMethodParent, new HttpHeaders(), HttpStatus.OK);
	}

}
