package com.aop.AOPDemo.dao;

import com.aop.AOPDemo.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vip);

    boolean doWork();
}
