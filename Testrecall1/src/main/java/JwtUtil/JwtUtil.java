package JwtUtil;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.xml.crypto.Data;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final Key key= Keys.hmacShaKeyFor("This the key for jwt token generation".getBytes());
    private static final long EXPIRATION_TIME = (long) 30 * 60 * 1000;

    public static String generateToken(String username,String role){
        return (Jwts.builder()
                .setSubject(username)
                .claim("role",role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact());
    }
    public static Claims validateToken(String token){
//        return Jwts.parser()
//                .verifyWith(key)
    }

}
