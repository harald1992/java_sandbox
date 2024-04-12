package com.harald.jwtauthbff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtAuthBFFApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthBFFApplication.class, args);
    }

    // @Bean
    // CommandLineRunner commandLineRunner(SessionRepository sessionRepository) {
    //     SessionEntity sessionEntity = new SessionEntity();
    //     sessionEntity.setDetails("Session detail initial");
    //     // add postgres, root password.
    //     // UserEntity user = UserEntity.builder()
    //     //         .username("postgres")
    //             /* JWT:
    //              Part before the first .: $2a$10$xiV3TXfER6r4J7 -> This is just base64 encoded header, containing alg(algorithm HS256) and typ
    //              (type jwt)
    //             Part after the first ..gsjfY5uwRO3R6Mt2UJxAuChwH: -> This is the data/payload, containing sub(subject id), iat (issued at) etc
    //
    //            Last part, now not there since the used jwt here is not signed: Verifies that is was not being manipulated
    //            Hashes the header and payload using base64encoding of header and payload and adding in the secret key.
    //            This way if the data in first or 2nd section is changed (because hit is just base64 encoded),
    //                 you can use the hashing signature to hash it again with the key and check if the result is the same as the signature.
    //             */
    //             //
    //             // .password("$2a$10$xiV3TXfER6r4J7.gsjfY5uwRO3R6Mt2UJxAuChwH/sq8ETw3kQjNe")
    //             // .email("lala@example.com")
    //             // .role(Role.ADMIN)
    //             // .build();
    //
    //     return args -> {
    //         sessionRepository.save(sessionEntity);
    //         // userRepository.save(user);
    //     };
}

