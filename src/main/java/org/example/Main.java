package org.example;

import org.example.entity.Account;
import org.example.storage.v2.PersistenceUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = PersistenceUtil.getInstance();
        Account account = null;
        List<Session> sessions = new ArrayList<>();
        for (int i = 0; i < 200; i++) {

            Session session = sessionFactory.openSession();
            account = session.get(Account.class, 0);
            sessions.add(session);
            System.out.println("Session " + i + " " + session);
        }

        System.out.println(account);
        System.out.println(sessions.size());
//        //do work
//        Account account = session.get(Account.class, 0);
//        System.out.println(account);

//        List<Account> accounts = session
//                .createQuery("from Account", Account.class)
//                .list();
//
//        System.out.println("Is empty " + accounts.isEmpty());
//        System.out.println("size() " + accounts.size());

//        Account account = new Account();
//        account.setMoney(0);
//
//        Transaction transaction = session.beginTransaction();
//        session.persist(account);
//        transaction.commit();

//        session.close();


    }
}