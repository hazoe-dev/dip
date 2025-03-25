CREATE TABLE users (
                       id BIGINT PRIMARY KEY,
                       name VARCHAR(255),
                       email VARCHAR(255)
);

INSERT INTO users (id, name, email) VALUES (1, 'Alice', 'alice@example.com');
INSERT INTO users (id, name, email) VALUES (2, 'Bob', 'bob@example.com');
