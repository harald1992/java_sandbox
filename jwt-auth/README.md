Security Flow with Spring Security:


Database with encrypted passwords
-> Login Form -> Enter plaintext password
    -> Spring Security Filters
        -> Retrieve password from db for user
        -> Read encoding algorith (bcrypt, noop etc)
        -> If bcrypt, encrypt plaintext password from login form using the salt from db password
            -> Compare encrypted password from login from with encrypted password from DB.
                -> If match, successfull, if no match unsucessful

Password from db is never decrypted, because it is a one-way encryption algorithm (=Hashing?).


Kill port:
netstat -vanp tcp | grep 8082
kill -9 <PID>
