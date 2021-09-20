package com.shopping.cart.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.shopping.cart.bean.PaymentMethod;
import com.shopping.cart.client.RestClient;

@Component
public class PaymentService {
	@Autowired
	RestClient client;

	public String retrievePaymentMethods() throws Exception {
		String request = "{ \"merchantAccount\": \"AdyenRecruitmentCOM\", \"countryCode\": \"CN\"}";
		return client.invokeService(request, HttpMethod.POST,
				new ParameterizedTypeReference<String>() {
				}, "paymentMethods");
	}
	
	public String makePayment(String request) throws Exception {
	//	String request = "{ \"merchantAccount\": \"AdyenRecruitmentCOM\"}";
		return client.invokeService(request, HttpMethod.POST,
				new ParameterizedTypeReference<String>() {
				}, "payments");
	}
	
	public String paymentDetails(String request) throws Exception {
		//	String request = "{ \"merchantAccount\": \"AdyenRecruitmentCOM\"}";
			return client.invokeService(request, HttpMethod.POST,
					new ParameterizedTypeReference<String>() {
					}, "payments/details");
		}

}
