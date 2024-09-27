CREATE TABLE order_item (
    id BIGINT NOT NULL AUTO_INCREMENT,
    item_id BIGINT NOT NULL,
    order_id BIGINT NOT NULL,
    orderprice INT NOT NULL,
    count INT NOT NULL,
    PRIMARY KEY (id)
);