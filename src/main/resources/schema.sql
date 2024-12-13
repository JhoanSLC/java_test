CREATE TABLE category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL CHECK (price > 0),
    categoryId INTEGER REFERENCES category(id)
);
