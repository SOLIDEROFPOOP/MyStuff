USE user_db;
CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);
INSERT INTO users (name) VALUES
    ("John"),
    ("Murat"),
    ("Retard"),
    ("Idiot");