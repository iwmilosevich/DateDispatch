package com.ivan.model;

import java.util.concurrent.atomic.AtomicLong;

public class Account {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;
    private static final AtomicLong counter = new AtomicLong(100);

    private Account(AccountBuilder builder){
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.address = builder.address;
    }

    public Account(){
        Account account = new AccountBuilder().id().build();
        this.id = account.getId();
        this.firstName = account.getFirstName();
        this.lastName = account.getLastName();
        this.email = account.getEmail();
        this.address = account.getAddress();
    }

    public Account(long id, String firstName, String lastName,
                    String email, String address){
        Account cust = new AccountBuilder()
                .id()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .address(address)
                .build();
        this.id = cust.getId();
        this.firstName = cust.getFirstName();
        this.lastName = cust.getLastName();
        this.email = cust.getEmail();
        this.address = cust.getAddress();
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

    public String getAddress(){
        return this.address;
    }

    @Override
    public String toString(){
        return "ID: " + id
                + " First: " + firstName
                + " Last: " + lastName + "\n"
                + "EMail: " + email + "\n"
                + "Address: " + address;
    }

    public static class AccountBuilder {
        private long id;
        private String firstName = "";
        private String lastName = "";
        private String email = "";
        private String address = "";

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

        public AccountBuilder address(String address){
            this.address = address;
            return this;
        }

        public Account build(){
            return new Account(this);
        }

    }
}