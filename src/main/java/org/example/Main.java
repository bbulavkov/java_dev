package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.AccountDAO;
import org.example.dao.v3.AccountDAOImpl;
import org.example.entity.*;
import org.example.storage.v2.PersistenceUtil;
import org.flywaydb.core.Flyway;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "postgres")
                .load();
        flyway.migrate();


        SessionFactory sessionFactory = PersistenceUtil.getInstance();
        Session session = sessionFactory.openSession();
//
//        Account account = new Account();
//
//        account.setMoney(5000);
//        account.setAccountType(AccountType.Direct);
//
//        AccountInfo accountInfo = new AccountInfo();
//        accountInfo.setInfo("Якась дуже важлива інформація.");
//
//        accountInfo.setAccount(account);
//        account.setAccountInfo(accountInfo);
//
//
//        Transaction transaction = session.beginTransaction();
//
//        session.persist(account);
//
//        transaction.commit();

//        Account account = session.get(Account.class, 1);
//        log.debug("Account {}", account);
//
//        AccountInfo accountInfo = account.getAccountInfo();
//        log.debug("AccountInfo {}", accountInfo);
//
//
//        Transaction transaction = session.beginTransaction();
//        session.remove(account);
//        transaction.commit();


        //1-n
//        User user = new User();
//        user.setName("John");
//        user.setAge(21);
//
//        Account account1 = new Account();
//        account1.setMoney(1000);
//        account1.setAccountType(AccountType.Direct);
//        account1.setUser(user);
//
//        Account account2 = new Account();
//        account2.setMoney(2000);
//        account2.setAccountType(AccountType.SubDirect);
//        account2.setUser(user);
//
//        user.setAccounts(Set.of(account1, account2));
//
//        Transaction transaction = session.beginTransaction();
//        session.persist(user);
//        session.persist(account1);
//        session.persist(account2);

//        User user = session.get(User.class, 3);
//
//        log.debug("User {} ", user);
//
//        session.close();
//
//        Set<Account> accounts = user.getAccounts();
//        log.debug("Accounts {} ", accounts);


        Course javaDevPro = new Course();
        javaDevPro.setName("Java dev pro1");

        User user = new User();
        user.setName("Bil");
        user.setAge(21);

        Set<Course> courses = new HashSet<>();
        courses.add(javaDevPro);

        user.setCourses(courses);

        User user1 = new User();
        user1.setName("Jack");
        user1.setAge(20);

        user1.setCourses(Set.of(javaDevPro));

        javaDevPro.setUsers(Set.of(user, user1));

        Transaction transaction = session.beginTransaction();

        session.persist(user);
        session.persist(user1);
        session.persist(javaDevPro);

        transaction.commit();

        session.close();
    }
}