package com.aop.AOPDemo.dao;

import com.aop.AOPDemo.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> findAccounts();

    void addAccount(Account account, boolean vip);

    boolean doWork();

    public String getName();
    public void setName(String name);
    public String getServiceCode();
    public void setServiceCode(String serviceCode);
}
