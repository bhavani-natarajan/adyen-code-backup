package com.shopping.cart.handler;


import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.shopping.cart.bean.BaseResponse;

public class AdyenResponseHandler implements HttpClientResponseHandler<BaseResponse> {

    @Override
    public BaseResponse handleResponse(ClassicHttpResponse httpResponse) throws IOException, ParseException {
    	BaseResponse response = new BaseResponse();
    	response.setStatus(httpResponse.getCode());
    	response.setHeaders(getHeaders(httpResponse.getHeaders()));
    	 HttpEntity entity = httpResponse.getEntity();
         if (entity != null) {
        	 response.setBody(EntityUtils.toString(entity));
         }
        return response;
    }

    private Map<String, List<String>> getHeaders(Header[] allHeaders) {
        Map<String, List<String>> headers = new HashMap<>();
        for (Header header : allHeaders) {
            headers.put(header.getName(), Collections.singletonList(header.getValue()));
        }
        return headers;
    }
}