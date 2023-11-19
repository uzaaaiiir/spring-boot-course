package com.aop.AOPDemo.dao;

import com.aop.AOPDemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount(Account account, boolean vip) {
        System.out.println(getClass() + ": Adding account to the DB");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
