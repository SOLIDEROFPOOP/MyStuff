-- Create the "users" table
CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(100) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       first_name VARCHAR(100) NOT NULL,
                       last_name VARCHAR(100) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       status VARCHAR(25) NOT NULL DEFAULT 'ACTIVE'
);

-- Create the "roles" table
CREATE TABLE roles (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       status VARCHAR(25) NOT NULL DEFAULT 'ACTIVE'
);

-- Create the "user_roles" table
CREATE TABLE user_roles (
                            user_id BIGINT,
                            role_id BIGINT
);

-- Add a foreign key constraint on "user_roles" referencing "users"
ALTER TABLE user_roles
    ADD CONSTRAINT fk_user_roles_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE CASCADE
            ON UPDATE RESTRICT;

-- Add a foreign key constraint on "user_roles" referencing "roles"
ALTER TABLE user_roles
    ADD CONSTRAINT fk_user_roles_roles
        FOREIGN KEY (role_id)
            REFERENCES roles (id)
            ON DELETE CASCADE
            ON UPDATE RESTRICT;

-- Insert initial data into "roles" table
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
