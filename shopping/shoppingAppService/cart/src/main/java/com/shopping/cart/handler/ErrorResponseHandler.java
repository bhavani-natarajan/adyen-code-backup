package com.shopping.cart.handler;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class ErrorResponseHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		HttpStatus.Series series = response.getStatusCode().series();
		return (HttpStatus.Series.CLIENT_ERROR.equals(series)
				|| HttpStatus.Series.SERVER_ERROR.equals(series));
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		System.out.println("Response error: " + response.getStatusCode() + " - " + response.getStatusText());

	}

}
