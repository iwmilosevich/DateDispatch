CREATE DATABASE IF NOT EXISTS DATEDISPATCH;

CREATE TABLE IF NOT EXISTS Account(
    AccountId int,
    FirstName varchar(255),
    LastName varchar(255),
    Email varchar(255),
    Address varchar(255)
);

CREATE TABLE IF NOT EXISTS Event(
    EventId int,
    EventName varchar(255),
    Description varchar(255)
);