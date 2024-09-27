CREATE TABLE item (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price INT NOT NULL,
    stockquantity INT NOT NULL,
    PRIMARY KEY (id)
);