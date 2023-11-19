package com.aop.AOPDemo.dao;

import com.aop.AOPDemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("Manual exception thrown.");
        }

        Account account1 = new Account("Madhu", "Silver");
        Account account2 = new Account("John", "Platinum");
        Account account3 = new Account("Luca", "Gold");

        return Arrays.asList(account1, account2, account3);
    }

    @Override
    public void addAccount(Account account, boolean vip) {
        System.out.println(getClass() + ": Adding account to the DB");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": getName()");

        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
