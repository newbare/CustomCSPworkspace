package com.mkyong.rest;

import java.util.Base64;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
@Path("/inventory")
public class OrderInventoryService {
 
    @GET
    @Path("/order/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getUserById(@PathParam("orderId") Integer orderId,
                            @HeaderParam("authorization") String authString){
         
        if(!isUserAuthenticated(authString)){
            return "{\"error\":\"User not authenticated\"}";
        }
        Order ord = new Order();
        ord.setName("Java2Love");
        ord.setAddress("DELHI");
        ord.setAmount("$300");
        return ord;
    }
    private boolean isUserAuthenticated(String authString){
        
        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
        if (null == authString)
			return false;
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];
        // Decode the data back to original string
        byte[] bytes = null;
        try {
            bytes = Base64.getDecoder().decode(authInfo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        decodedAuth = new String(bytes);
        System.out.println("decodedAuth=="+decodedAuth);
        String [] authStr=decodedAuth.split(":");
        String user=authStr[0];
        String password=authStr[1];
        /**
         * here you include your logic to validate user authentication.
         * it can be using ldap, or token exchange mechanism or your
         * custom authentication mechanism.
         */
        boolean authenticationStatus = "vishwa".equals(user)
				&& "vishwa".equals(password);
		return authenticationStatus;
    }
} 
