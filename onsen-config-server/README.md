org.springframework.boot spring-boot-docker-compose is used to automatically create a postgres image on load.

JWT: 
    Header: { alg: HS256, typ: JWT}
    Payload (data): {
            sub: alibou,        // sub = subject
            authorities: "ADMIN", "MANAGER" // roles 
    claims:
       - registered claims (iss (issurer), subject, expiration duration 
        - private claims:
        - public claims: 

Signed by jwt signature

/* JWT:
Part before the first .: $2a$10$xiV3TXfER6r4J7 -> This is just base64 encoded header, containing alg(algorithm HS256) and typ(type jwt)
Part after the first ..gsjfY5uwRO3R6Mt2UJxAuChwH: -> This is the data/payload, containing sub(subject id), iat (issued at) etc

               Last part, now not there since the used jwt here is not signed: Verifies that is was not being manipulated
               Hashes the header and payload using base64encoding of header and payload and adding in the secret key.
               This way if the data in first or 2nd section is changed (because hit is just base64 encoded),
                    you can use the hashing signature to hash it again with the key and check if the result is the same as the signature.
                */


Usecase JWT: Scenario 1: Als je bijv bij een bank ingelogd bent in het banking systeem, en dan naar de andere applicatie voor retirements gaat, zou je opnieuw in moeten loggen.
            Scenario 2: Als je meerdere horizontaal geschaalde servers hebt, zouden die ook allemaal de sessie moeten inloggen.
            Scenario 3: Meerdere stateless microservices, dan kan je ook de jwt overal gebruiken.
Een jwt kan je gewoon hergebruiken, zolang alle servers toegang hebben tot de private key.


where we keep the backend stateless as RESTful services, that validate the Token before sending any data back to the browser.

RISKS RWT:
- You cannot revoke a JWT, since it is stored in the browser. So if you close the browser and use the Jwt somewhere else it works
- You need to add functionality to refresh the Jwt often

- CSRF attacks: add samesite attribute to http-only cookie, so the cookie only works when the same site is used for the website and not coming from a different url.