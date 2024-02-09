-- init.sql

CREATE TABLE IF NOT EXISTS user (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL
    );

INSERT INTO user (username, email) VALUES ('user1', 'user1@example.com');
INSERT INTO user (username, email) VALUES ('user2', 'user2@example.com');
