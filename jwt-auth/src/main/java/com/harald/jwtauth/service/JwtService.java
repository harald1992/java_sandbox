package com.harald.jwtauth.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
public class JwtService {

    // from https://acte.ltd/utils/randomkeygen
    // private static final String SECRET_KEY =
    //         "N7cUCzPyPD33WkjbGcPQoz2n2eSnUkpwwXUg6jGSwrYpzYH8AaNoybNoDJqgHf3TL7nn4EfJayGmkwJQCgBJcw3NhGD3pyapBmFn9LMbH7Jjo7X3TRroCwbh8NyqYU72gUB5Ntfek9oQhpWTGmS7D2B3Nhg9j6W93j3byGbs2ZBfDFpMfrXF7dZa4dAjy2dhfebG4o5SjkcFKpRKKCStM5Dt9rq9GPEk5ZZT4ThEmmdFqtJHjy7wfMCtpxsbknnN";
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    @Value("${app.cookie_expiration_ms}")
    private int COOKIE_EXPIRATION_MS;

    public String extractUsername(String jwt) {
        return extractClaim(jwt, Claims::getSubject);
    }

    public Date extractExpiration(String jwt) {
        return extractClaim(jwt, Claims::getExpiration);
    }

    /**
     * Gets all claims and then find the claim
     *
     * @param jwt            The jwt token, with header.data.signature
     * @param claimsResolver i.e. using Claims::getSubject (Method reference that means c -> c.getSubject())
     * @return The claim as defined in the claimsResolver function.
     */
    public <T> T extractClaim(String jwt, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(jwt);

        claims.forEach((claimName, claimValue) -> System.out.println("Claim Name: " + claimName + ", Claim Value: " + claimValue));

        return claimsResolver.apply(claims);
    }

    /**
     * Returns all claims from a Jwt token
     *
     * @param jwt The jwt token, with header.data.signature
     * @return The claims, a claim is basically a key value pair in the jwt token. This gets all claims from the body, not the header.
     */
    private Claims extractAllClaims(String jwt) {
        return Jwts
                .parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }

    private Boolean isTokenExpired(String jwt) {
        return extractExpiration(jwt).before(new Date());
    }

    public Boolean isTokenValid(String jwt, User user) {
        final String username = extractUsername(jwt);
        return (username.equals(user.getUsername()) && !isTokenExpired(jwt));
    }

    public String CreateJwt(String username) {
        Map<String, Object> claims = new HashMap<>();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + COOKIE_EXPIRATION_MS);

        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expiryDate)
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256).compact();
    }

}
