package com.shopping.cart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.bean.PaymentMethod;
import com.shopping.cart.service.PaymentService;

@RestController
@RequestMapping(value = "web")
public class PaymentController {
	@Autowired
	private PaymentService service;
	
	@RequestMapping(value = "/paymentMethods", method = RequestMethod.GET, headers = {"Accept=application/json"})
	public ResponseEntity<String> retrievePaymentMethods(HttpServletRequest req) throws Exception
	{
		String paymentMethods = service.retrievePaymentMethods();
		return new ResponseEntity<>(paymentMethods, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/payments", method = RequestMethod.POST, headers = {"Accept=application/json"})
	public ResponseEntity<String> makePayment(HttpServletRequest req, @RequestBody String reqString) throws Exception
	{
		String paymentResponse = service.makePayment(reqString);
		return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/paymentDetails", method = RequestMethod.POST, headers = {"Accept=application/json"})
	public ResponseEntity<String> paymentDetails(HttpServletRequest req, @RequestBody String reqString) throws Exception
	{
		String paymentResponse = service.paymentDetails(reqString);
		return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
	}

}
