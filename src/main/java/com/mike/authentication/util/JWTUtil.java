package com.mike.authentication.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/12/1 15:08.
 */
public class JWTUtil {
    public static final String SECRET_KEY = "123456"; //private key
    public static final long TOKEN_EXPIRE_TIME = 30 * 60 * 1000; //token expiration time 5 minutes
    public static final long REFRESH_TOKEN_EXPIRE_TIME = 30 * 60 * 1000; //refreshToken expiration time
    private static final String ISSUER = "mike"; //签发人

    /**
     * To generate the signature
     */
    public static String generateToken(String username) {
        Date now = new Date();
        Algorithm algorithm = null; // Algorithm
        try {
            algorithm = Algorithm.HMAC256(SECRET_KEY);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String token = JWT.create()
                .withIssuer(ISSUER) //签发人
                .withIssuedAt(now) //签发时间
                .withExpiresAt(new Date(now.getTime() + TOKEN_EXPIRE_TIME)) //过期时间
                .withClaim("username", username) //保存身份标识
                .sign(algorithm);
        return token;
    }

    /**
     * verify token
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY); //算法
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build();
            verifier.verify(token);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * 从token获取username
     */
    public static String getUsername(String token){
        try{
            return JWT.decode(token).getClaim("username").asString();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "";
    }
}
