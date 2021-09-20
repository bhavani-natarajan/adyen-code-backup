package com.shopping.cart.client;

import java.io.IOException;
import java.util.Map;

import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.shopping.cart.handler.AdyenResponseHandler;


@Component
public class RestClient {
	
	@Autowired
	RestTemplate template;
	
	public <T> T invokeService(Object inPostObject, HttpMethod type, ParameterizedTypeReference<T> inResponseType,
			final String serviceName, final Object... inParameters) throws Exception {
		ResponseEntity<T> resultModel = null;
		try {
			HttpHeaders headers = setHeader();
			HttpEntity<Object> entity = new HttpEntity<>(inPostObject, headers);
			resultModel = template.exchange(getUrl(serviceName), type, entity, inResponseType, inParameters);
		}
		catch(Exception ex) {
			throw new Exception("Service is unavailable : " + ex.getMessage());
		}
		return resultModel.getBody();
	}
	
	private String getUrl(final String methodName) {
		return "https://checkout-test.adyen.com/v67/".concat(methodName);
	}
	
	private HttpHeaders setHeader() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("x-api-key", "AQEyhmfxKonIYxZGw0m/n3Q5qf3VaY9UCJ14XWZE03G/k2NFikzVGEiYj+4vtN01BchqAcwQwV1bDb7kfNy1WIxIIkxgBw==-JtQ5H0iXtu8rqQMD6iAb33gf2qZeGKGhrMpyQAt9zsw=-3wAkV)*$kP%bCcSf");
		return httpHeaders;
	}
}
