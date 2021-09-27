package com.shopping.cart.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.shopping.cart.client.RestClient;

@Component
public class PaymentService {
	@Autowired
	RestClient client;

	public String retrievePaymentMethods() throws Exception {
		String request = "{ \"merchantAccount\": \"AdyenRecruitmentCOM\", \"countryCode\": \"CN\"}";
		System.out.println(request);
		String response = client.invokeService(request, HttpMethod.POST,
				new ParameterizedTypeReference<String>() {
				}, "paymentMethods");
		System.out.println(response);
		return response;
	}
	
	public String makePayment(String request) throws Exception {
		System.out.println(request);
		String response = client.invokeService(request, HttpMethod.POST,
				new ParameterizedTypeReference<String>() {
				}, "payments");
		System.out.println(response);
		return response;
	}
	
	public String paymentDetails(String request) throws Exception {
			System.out.println(request);
			String response = client.invokeService(request, HttpMethod.POST,
					new ParameterizedTypeReference<String>() {
					}, "payments/details");
			System.out.println(response);
			return response;
		}

}
