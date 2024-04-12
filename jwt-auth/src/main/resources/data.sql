-- Roles
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

-- Users
INSERT INTO users (username, password, enabled) VALUES ('user1', '{noop}password1', true);
INSERT INTO users (username, password, enabled) VALUES ('user2', '{noop}password2', true);

-- User Roles
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1); -- user1 has ROLE_USER
INSERT INTO user_roles (user_id, role_id) VALUES (2, 1); -- user2 has ROLE_USER
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2); -- user2 has ROLE_ADMIN


--
-- INSERT INTO "users"(id, username, password, enabled)
-- VALUES (9999, 'postgres_default', '{bcrypt}$2a$10$WFQ7RFC97fD5NnvYlALZtOnvhwmWaupzne1mjd/0kY.rq.v0mX81a', true); -- =root
-- --        ('john', '{bcrypt}$2a$10$LMffTADB/vT6LRZKzPRL8.TkQx9khyjKR654nFOpu2/qrsitMNNCu', true), -- =root
-- --        ('mary', '{bcrypt}$2a$10$iNaK4ZVX/ecTcE8gCtLKkebuBd803Hq1M/EFTfz7zQI616LGp5a3O', true), -- =root
-- --        ('susan', '{bcrypt}$2a$10$QuFL1WawQtTCOSx3i0iXA.Gfp6RlBHk8eQ4bZ9p.fi4cNEXrfcnGS', true), -- =root
-- --        ('unencryptedBoy', '{noop}root', true);
-- --
-- -- INSERT INTO "roles"(name)
-- -- VALUES ('john', 'ROLE_EMPLOYEE'),   -- SPRING SECURITY expects ROLE_ before
-- --        ('mary', 'ROLE_EMPLOYEE'),
-- --        ('mary', 'ROLE_MANAGER'),
-- --        ('susan', 'ROLE_EMPLOYEE'),
-- --        ('susan', 'ROLE_MANAGER'),
-- --        ('susan', 'ROLE_ADMIN'),
-- --        ('postgres', 'ROLE_EMPLOYEE'),
-- --        ('postgres', 'ROLE_MANAGER'),
-- --        ('postgres', 'ROLE_ADMIN');
-- --
--
-- -- INSERT INTO ROLES (name) VALUES ('ROLE_USER');
-- -- INSERT INTO ROLES (name) VALUES ('ROLE_ADMIN');
-- --
-- -- -- Insert a user
-- -- INSERT INTO USERS (username, password, enabled) VALUES ('john_doe', 'password123', true);
-- --
-- -- -- Find the IDs of the roles you want to associate with the user
-- -- SELECT id FROM ROLES WHERE name = 'ROLE_USER' OR name = 'ROLE_ADMIN';
-- --
-- -- -- Associate roles with the user
-- -- INSERT INTO USER_ROLES (user_id, role_id) VALUES (<user_id>, <role_id>);