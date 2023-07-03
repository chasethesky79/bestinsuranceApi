--liquibase formatted sql
--changeset bharath:001-changeset1.sql splitStatements:false
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS Customers
(
    customer UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(64) NOT NULL,
    surname VARCHAR (64) NOT NULL,
    email VARCHAR(320) NOT NULL,
    created timestamp with tz NOT NULL,
    updated timestamp with tz NOT NULL,
    address UUID,
    CONSTRAINT address_fk FOREIGN KEY (address) REFERENCES Addresses(address_id)
);

CREATE TABLE IF NOT EXISTS Subscriptions
(
  policy_id UUID uuid_generate_v4(),
  customer_id UUID uuid_generate_v4(),
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  paid_price NUMERIC(4,2) NOT NULL,
  created timestamp with tz NOT NULL,
  updated timestamp with tz NOT NULL,
  PRIMARY KEY(policy_id, customer_id)
  CONSTRAINT customer_fk FOREIGN KEY (customer_id) REFERENCES Customers(customer)
)
