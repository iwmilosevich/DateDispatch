package com.ivan.data;

import com.ivan.model.Account;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class AccountList {
    private static final CopyOnWriteArrayList<Account> cList = new CopyOnWriteArrayList<>();

    static {
        // Create list of customers
        cList.add(
                new Account.AccountBuilder().id()
                        .firstName("George")
                        .lastName("Washington")
                        .email("gwash@example.com")
                        .address("11 Street Way")
                        .build()
        );

        cList.add(
                new Account.AccountBuilder().id()
                        .firstName("John")
                        .lastName("Adams")
                        .email("jadams@example.com")
                        .address("22 Park Way")
                        .build()
        );

        cList.add(
                new Account.AccountBuilder().id()
                        .firstName("Thomas")
                        .lastName("Jefferson")
                        .email("tjeff@example.com")
                        .address("33 Board Walk")
                        .build()
        );

        cList.add(
                new Account.AccountBuilder().id()
                        .firstName("James")
                        .lastName("Madison")
                        .email("jmad@example.com")
                        .address("44 Broad Way")
                        .build()
        );

        cList.add(
                new Account.AccountBuilder().id()
                        .firstName("James")
                        .lastName("Monroe")
                        .email("jmo@example.com")
                        .address("55 Street Corner")
                        .build()
        );

    }

    private AccountList(){}

    public static CopyOnWriteArrayList<Account> getInstance(){
        return cList;
    }

    public static void testList(){
        CopyOnWriteArrayList<Account> list = AccountList.getInstance();
        list.forEach(System.out::println);
        String cString = list.stream()
                        .map(Account::toString)
                        .collect(Collectors.joining("\n"));
        System.out.println(cString);
    }

    public static void main(String[] args) {
        AccountList.testList();
    }

}