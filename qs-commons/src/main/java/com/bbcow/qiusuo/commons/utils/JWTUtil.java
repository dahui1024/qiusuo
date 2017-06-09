package com.bbcow.qiusuo.commons.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTUtil {
	private static String issuer = "http://www.bbcow.com";
	private static String secret = "!!!!aAaA!!!!";
	
	/**
	 * 
	 * 生成用户令牌
	 * 
	 * @param user_id
	 * @param sign_time
	 * @param valid_seconds
	 * @return
	 */
	public static String signUserToken(String user_id, Date sign_time, long valid_seconds) {
		JWTCreator.Builder builder = JWT.create();

		builder.withIssuer(issuer);
		builder.withSubject("user");
		builder.withIssuedAt(sign_time);
		builder.withExpiresAt(sign_time);
		builder.withClaim("uid", user_id);
		
		try {
			return builder.sign(Algorithm.HMAC256(secret));
		} catch (IllegalArgumentException | JWTCreationException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * 解密用户令牌
	 * 
	 * @param token
	 * @return
	 * @throws IllegalArgumentException
	 * @throws UnsupportedEncodingException
	 */
	public static Map<String, Claim> unsignToken(String token) throws IllegalArgumentException, UnsupportedEncodingException{
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();

		DecodedJWT jwt = verifier.verify(token);
		return jwt.getClaims();
	}
	
	public static void main(String[] args) {
//		System.out.println(JWTUtil.userSign("123", new Date(), 10000));
		
		try {
			JWTUtil.unsignToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwidWlkIjoiMTIzIiwiaXNzIjoiaHR0cDovL3d3dy5xaW5nb28uY24iLCJleHAiOjE0OTY5MTk1NTksImlhdCI6MTQ5NjkxOTU1OX0.MKcIqRlolsmTHsKpvTXzqf_fPGmwj2GWnic5xfRIdDc");
		} catch (IllegalArgumentException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
}
