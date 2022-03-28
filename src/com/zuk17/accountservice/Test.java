package com.zuk17.accountservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class Test {
    public static void main(String[] args) {
//        Account[] accounts =
//        test1();


    }

    public static void test1() {
        Account[] accounts = new Account[10];
        User owner = new User(1, "stress", "sre");

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i + 1, (long) (Math.random() * 100000000), owner);
        }

        for (Account a : accounts) {
            System.out.println(a.getId() + "\t" + a.getBalance() + "\t" + a.getOwner().getLastName());
        }

        AccountService service = new AccountServiceImpl(accounts);
        System.out.println(service.findAccountByOwnerId(10));
        System.out.println(service.countAccountsWithBalanceGreaterThan(69470642L));


    }
}
