package com.mkyong.client;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class HMACClient {
	
	private final static String DATE_FORMAT = "EEE, d MMM yyyy HH:mm:ss z";
	private final static String HMAC_SHA1_ALGORITHM = "HmacSHA1";
 
	private final static String SECRET = "secretsecret";
	private final static String USERNAME = "jos";
 
 
	public static void main(String[] args) throws HttpException, IOException, NoSuchAlgorithmException {
		HMACClient client = new HMACClient();
		client.makeHTTPCallUsingHMAC(USERNAME);
	}
 
	public void makeHTTPCallUsingHMAC(String username) throws HttpException, IOException, NoSuchAlgorithmException {
		String contentToEncode = "{\"comment\" : {\"message\":\"blaat\" , \"from\":\"blaat\" , \"commentFor\":123}}";
		String contentType = "application/vnd.geo.comment+json";
		//String contentType = "text/plain";
		String currentDate = new SimpleDateFormat(DATE_FORMAT).format(new Date());
 
		HttpPost post = new HttpPost("http://localhost:9999/RestfullWebserviceBasicAuth/rest/inventory/order/111");
		StringEntity data = new StringEntity(contentToEncode,contentType,"UTF-8");
		post.setEntity(data);
 
		String verb = post.getMethod();
		String contentMd5 = calculateMD5(contentToEncode);
		String toSign = verb + "\n" + contentMd5 + "\n"
				+ data.getContentType().getValue() + "\n" + currentDate + "\n"
				+ post.getURI().getPath();
 
		String hmac = calculateHMAC(SECRET, toSign);
 
		post.addHeader("hmac", username + ":" + hmac);
		post.addHeader("Date", currentDate);
		post.addHeader("Content-Md5", contentMd5);
 
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(post);
 
		System.out.println("client response:" + response.getStatusLine().getStatusCode());
	}
 
	private String calculateHMAC(String secret, String data) {
		try {
			SecretKeySpec signingKey = new SecretKeySpec(secret.getBytes(),	HMAC_SHA1_ALGORITHM);
			Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
			mac.init(signingKey);
			byte[] rawHmac = mac.doFinal(data.getBytes());
			String result = new String(Base64.getEncoder().encode(rawHmac));
			return result;
		} catch (GeneralSecurityException e) {
			throw new IllegalArgumentException();
		}
	}
 
	private String calculateMD5(String contentToEncode) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(contentToEncode.getBytes());
		String result = new String(Base64.getEncoder().encode(digest.digest()));
		return result;
	}

}
