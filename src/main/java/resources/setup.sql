CREATE DATABASE IF NOT EXISTS DATEDISPATCH;

CREATE TABLE IF NOT EXISTS Account(
    AccountId int NOT NULL AUTO_INCREMENT,
    FirstName varchar(255),
    LastName varchar(255),
    Email varchar(255),
    Address varchar(255),
    primary key (AccountId)
);

CREATE TABLE IF NOT EXISTS Event(
    EventId int NOT NULL AUTO_INCREMENT,
    EventName varchar(255),
    Description varchar(255),
    primary key (EventId)
);