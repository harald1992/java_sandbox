Security Flow with Spring Security:


Database with encrypted passwords
-> Login Form -> Enter plaintext password
    -> Spring Security Filters
        -> Retrieve password from db for userDetailsImpl
        -> Read encoding algorith (bcrypt, noop etc)
        -> If bcrypt, encrypt plaintext password from login form using the salt from db password
            -> Compare encrypted password from login from with encrypted password from DB.
                -> If match, successfull, if no match unsucessful

Password from db is never decrypted, because it is a one-way encryption algorithm (=Hashing?).


Kill port:
netstat -vanp tcp | grep 8082
kill -9 <PID>



a remember me cookie is nice, and spring offers 2 ways using userDetailService impl:
- cookie based (not fully reccommended since less safe)
- database persistence token
- -> cookies will have username, password, expiration time and private key

Http vs https:
communication between browser and application. In http this communication happens in a plain text. So anyone can intercept the request and get the data.
Https encrypts the communication through SSL. How to activate https
- Need valid ssl certificate for production, but can create cert in jdk keytool
  - sudo keytool -genkeypair -alias jwt-auth -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore jwt-auth.p12 -validity 3650
    - now configured with everything root and password rootroot. To implement it see application.yaml

# Buildpacks paketo DOCKER IMAGE
mvn spring-boot:build-image

docker run -d -p 8081:8081 harald1992/onsen-auth-service:0.0.1

docker image push docker.io/harald1992/onsen-auth-service:0.0.1

docker run -d -p 8081:8081 --platform linux/amd64 --network=host harald1992/onsen-auth-service:0.0.1


# Manual DOCKER:
docker build . -t 'onsen-auth-service'
docker build . -t 'username/onsen-auth-service:section2'
docker run -p 8081:8081 onsen-auth-service
-> port forwarding: start at 8081, 8081,. The 1st is the port of the host machine and the 2nd is the port inside the container 

om in de DB container te zien wat erin zit, doe docker ps voor de naam van de container en dan docker exec:
docker exec -it onsen-auth-service-db-1  psql -U postgres -d my_db -c "SELECT * FROM users;"
