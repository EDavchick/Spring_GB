CREATE TABLE IF NOT EXISTS "user"
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    age INT NOT NULL,
    email varchar(50) NOT NULL
);

INSERT INTO "user" (name, age, email) VALUES ('Ivan', 25, 'ivan@gmail.com');
INSERT INTO "user" (name, age, email) VALUES ('Sergey', 35, 'sergey@gmail.com');
INSERT INTO "user" (name, age, email) VALUES ('Maria', 45, 'maria@gmail.com');