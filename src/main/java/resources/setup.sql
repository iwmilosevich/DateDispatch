CREATE DATABASE IF NOT EXISTS DATEDISPATCH;

CREATE TABLE IF NOT EXISTS account(
    accountId int NOT NULL AUTO_INCREMENT,
    firstName varchar(255),
    lastName varchar(255),
    email varchar(255),
    address varchar(255),
    primary key (accountId)
);

CREATE TABLE IF NOT EXISTS event(
    eventId int NOT NULL AUTO_INCREMENT,
    eventName varchar(255),
    description varchar(255),
    primary key (eventId)
);