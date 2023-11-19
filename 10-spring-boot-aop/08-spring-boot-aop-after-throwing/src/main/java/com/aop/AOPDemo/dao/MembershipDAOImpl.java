package com.aop.AOPDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Adding membership account to the DB");
    }

    @Override
    public boolean addMember() {
        System.out.println(getClass() + ": Adding a member");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": Going to sleep.");
    }
}
