package com.ivan.model;

import java.util.concurrent.atomic.AtomicLong;

public class Account {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String city;
    private final String state;
    private final String birthday;
    private static final AtomicLong counter = new AtomicLong(100);

    private Account(AccountBuilder builder){
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.city = builder.city;
        this.state = builder.state;
        this.birthday = builder.birthday;
    }

    public Account(){
        Account account = new AccountBuilder().id().build();
        this.id = account.getId();
        this.firstName = account.getFirstName();
        this.lastName = account.getLastName();
        this.email = account.getEmail();
        this.city = account.getCity();
        this.state = account.getState();
        this.birthday = account.getBirthday();
    }

    public Account(long id, String firstName, String lastName,
                    String email, String city, String state, String birthday){
        Account cust = new AccountBuilder().id()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .city(city)
                .state(state)
                .birthday(birthday)
                .build();
        this.id = cust.getId();
        this.firstName = cust.getFirstName();
        this.lastName = cust.getLastName();
        this.email = cust.getEmail();
        this.city = cust.getCity();
        this.state = cust.getState();
        this.birthday = cust.getBirthday();
    }

    public long getId(){
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getBirthday(){
        return this.birthday;
    }

    @Override
    public String toString(){
        return "ID: " + id
                + " First: " + firstName
                + " Last: " + lastName + "\n"
                + "EMail: " + email + "\n"
                + "City: " + city
                + " State: " + state
                + " Birthday " + birthday;
    }

    public static class AccountBuilder {
        private long id;
        private String firstName = "";
        private String lastName = "";
        private String email = "";
        private String city = "";
        private String state = "";
        private String birthday = "";

        public AccountBuilder id(){
            this.id = Account.counter.getAndIncrement();
            return this;
        }

        public AccountBuilder id(long id){
            this.id = id;
            return this;
        }

        public AccountBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public AccountBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public AccountBuilder email(String email){
            this.email = email;
            return this;
        }

        public AccountBuilder city(String city){
            this.city = city;
            return this;
        }

        public AccountBuilder state(String state){
            this.state = state;
            return this;
        }

        public AccountBuilder birthday(String birthday){
            this.birthday = birthday;
            return this;
        }

        public Account build(){
            return new Account(this);
        }

    }
}