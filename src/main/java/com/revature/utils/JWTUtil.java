package com.revature.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTUtil {
	
    private static final String secret ="Jack Black is invited to our presentation";
    private static final Algorithm algorithm = Algorithm.HMAC256(secret);

  
    public static String generate(String username, String password){

        // builder design pattern
        String token = JWT.create()
                .withClaim("username", username) 
                .withClaim("password", password) 
                .sign(algorithm); 

        return  token;
    }

    public static DecodedJWT isValidJWT(String token){
            DecodedJWT jwt = JWT.require(algorithm).build().verify(token);
            return  jwt;
    }
    
    public static DecodedJWT decode(String token) {
    	DecodedJWT jwt = JWT.decode(token);
    	System.out.println(jwt);
    	return jwt;
    }
}
