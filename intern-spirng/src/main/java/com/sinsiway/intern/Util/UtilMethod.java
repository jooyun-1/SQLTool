package com.sinsiway.intern.Util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sinsiway.intern.domain.SW_Database;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class UtilMethod {
	private String secretKey = "secret";
	
	public String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {                    
		     ip = request.getHeader("Proxy-Client-IP");
		}
		 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		     ip = request.getHeader("WL-Proxy-Client-IP");
		}
		 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		     ip = request.getHeader("HTTP_CLIENT_IP");
		}
		 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		     ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		     ip = request.getRemoteAddr();
		}
	    
		if(ip.equals("127.0.0.1")) {
			InetAddress addr;
			try {
				addr = InetAddress.getLocalHost();
				ip = addr.getHostAddress();
			} catch (UnknownHostException e) {
				
				e.printStackTrace();
			}
			
		}
		return ip;
	}
	
	public String createToken(SW_Database db) {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
		Claims claims = Jwts.claims().setSubject("connection");
		claims.put("db", db);
		Date date = new Date();
		
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(date)
				.signWith(SignatureAlgorithm.HS256,secretKey)
				.compact();
	}
	
	public JSONObject decodeToken(LinkedHashMap<String, Connection> conMap) throws ParseException {
		Base64.Decoder decoder = Base64.getUrlDecoder();
		String encodedToken = (String)conMap.keySet().toArray()[conMap.size()-1];		
		String[] token = encodedToken.split("\\.");
		String payload = new String(decoder.decode(token[1]));
		JSONParser jsonParser = new JSONParser();		
		JSONObject jsonObj = (JSONObject) jsonParser.parse(payload);		
		JSONObject db = (JSONObject) jsonObj.get("db");
		return db;
	}
	
	public String getMessage(String type) {
		JSONObject obj = new JSONObject();
		switch (type) {
		case "delete":
			return "삭제 완료";
		case "exit":
			return "접속 종료";
		case "reject":
			return "차단된 IP";
		default:
			return "none";
		}
	}
}
