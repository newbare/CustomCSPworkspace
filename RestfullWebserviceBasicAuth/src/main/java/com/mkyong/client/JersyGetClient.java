package com.mkyong.client;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JersyGetClient {
 
    public static void main(String a[]) throws UnsupportedEncodingException{
         
        String url = "http://localhost:9999/RestfullWebserviceBasicAuth/rest/inventory/order/123";
        String name = "vishwa";
        String password = "vishwa";
        String authString = name + ":" + password;
        byte[] authEnc = Base64.getEncoder().encode(authString.getBytes());
        String authStringEnc = new String(authEnc, "UTF-8");
        System.out.println("Base64 encoded auth string: " + authStringEnc);
        Client restClient = Client.create();
        WebResource webResource = restClient.resource(url);
        ClientResponse resp = webResource.accept("application/json")
                                         .header("Authorization", "Basic " + authStringEnc)
                                         .get(ClientResponse.class);
        if(resp.getStatus() != 200){
            System.err.println("Unable to connect to the server");
        }
        String output = resp.getEntity(String.class);
        System.out.println("response: "+output);
    }
}
