package com.shopping.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.shopping.cart.handler.ErrorResponseHandler;

@SpringBootApplication
public class CartApplication {
	
   /***
    * Creating Rest Client Bean.
    * 
    * @return
    */
	@Bean
	public RestTemplate getRestClient()
	{
		RestTemplate template = new RestTemplate();
		template.setErrorHandler(new ErrorResponseHandler());
		return template;
	}

	public static void main(String[] args) {
		SpringApplication.run(CartApplication.class, args);
	}

}
