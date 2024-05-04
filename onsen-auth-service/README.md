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
