--liquibase formatted sql
--changeset bharath:001-changeset1.sql splitStatements:false

CREATE TABLE IF NOT EXISTS Customers
(
    customer UUID SERIAL UNIQUE,
    name VARCHAR(64) NOT NULL,
    surname VARCHAR (64) NOT NULL,
    email VARCHAR(320) NOT NULL,
    created timestamp with tz NOT NULL,
    updated timestamp with tz NOT NULL,
    address UUID,
    CONSTRAINT address_fk FOREIGN KEY (address) REFERENCES Addresses(address_id)
);
