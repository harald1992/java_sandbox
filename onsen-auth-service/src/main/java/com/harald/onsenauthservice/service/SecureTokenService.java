// package com.harald.jwtauth.service;
//
// // import com.harald.jwtauth.entity.SecureToken;
// // import com.harald.jwtauth.repository.SecureTokenRepository;
// import lombok.RequiredArgsConstructor;
// import org.apache.tomcat.util.codec.binary.Base64;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.security.crypto.keygen.BytesKeyGenerator;
// import org.springframework.security.crypto.keygen.KeyGenerators;
// import org.springframework.stereotype.Service;
//
// import java.nio.charset.Charset;
// import java.nio.charset.StandardCharsets;
// import java.time.LocalDateTime;
// import java.util.Optional;
//
// @Service
// @RequiredArgsConstructor
// public class SecureTokenService {
//
//     private static final BytesKeyGenerator DEFAULT_TOKEN_GENERATOR = KeyGenerators.secureRandom(20);
//
//     private static final Charset US_ASCII = StandardCharsets.US_ASCII;
//
//     @Value("${app.secure_token_validity_sec}")
//     private int tokenValidityinSeconds;
//
//
//     private final SecureTokenRepository secureTokenRepository;
//
//     public SecureToken createSecureToken() {
//         String tokenValue = Base64.encodeBase64URLSafeString(DEFAULT_TOKEN_GENERATOR.generateKey());
//         SecureToken secureToken = new SecureToken();
//         secureToken.setToken(tokenValue);
//         secureToken.setExpireAt(LocalDateTime.now().plusSeconds(tokenValidityinSeconds));
//         // saveToken(secureToken); // in course needed but registration already saves this after adding user to it?
//         return secureToken;
//     }
//
//     public void saveToken(SecureToken secureToken) {
//         secureTokenRepository.save(secureToken);
//     }
//
//     public Optional<SecureToken> findByToken(String token) {
//         return secureTokenRepository.findByToken(token);
//     }
//
//     public void removeToken(SecureToken secureToken) {
//          secureTokenRepository.delete(secureToken);
//     }
//
//     public void removeByToken(String token) {
//         secureTokenRepository.removeByToken(token);
//     }
//
// }
