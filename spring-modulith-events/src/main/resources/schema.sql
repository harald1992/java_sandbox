-- src/main/resources/schema.sql
CREATE TABLE IF NOT EXISTS user_details (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL,
                          phone VARCHAR(20)
);
