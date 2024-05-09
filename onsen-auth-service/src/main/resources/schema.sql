DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    enabled  BOOLEAN      NOT NULL,

    created_at TIMESTAMP,
    created_by VARCHAR(255),
    updated_at TIMESTAMP,
    updated_by VARCHAR(255)
);

CREATE TABLE roles
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);


-- DROP TABLE IF EXISTS "users" CASCADE; -- CASCADE also deletes the dependent data (since users and authorities are linked).
-- DROP TABLE IF EXISTS "roles";
--
-- CREATE TABLE "users"
-- (
--     id BIGINT,
--     username VARCHAR(100) NOT NULL,
--     password CHAR(68) DEFAULT NULL,
--     enabled BOOLEAN NOT NULL,
--
--     PRIMARY KEY (id)
-- );
--
--
-- CREATE TABLE "roles"
-- (
--     id BIGINT NOT NULL,
--     name VARCHAR(50) NOT NULL
--
-- --     username  VARCHAR(50) NOT NULL,
-- --     authority VARCHAR(50) NOT NULL,
--
-- --     CONSTRAINT fk_authorities_users
-- --     FOREIGN KEY (username)
-- --     REFERENCES users (username)
-- );
--
-- -- create unique index ix_auth_username on authorities (username, authority);
--
