package com.vishwa.utility;

import java.util.Base64;

public class BasicAuthChecking {
	
	  public static boolean isUserAuthenticated(String authString) throws RuntimeException{
	        
	        String decodedAuth = "";
	        // Header is in the format "Basic 5tyc0uiDat4"
	        // We need to extract data before decoding it back to original string
	        if (null == authString)
				return false;
	        System.out.println("authString is:::"+authString);
	        String[] authParts = authString.split("\\s+");
	        String authInfo = authParts[1];
	        // Decode the data back to original string
	        byte[] bytes = null;
	        try {
	            bytes = Base64.getDecoder().decode(authInfo);
	        } catch (Exception e) {
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
