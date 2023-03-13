package org.example.notes;

import lombok.extern.slf4j.Slf4j;
import org.example.storage.v2.PersistenceUtil;
import org.flywaydb.core.Flyway;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

@Slf4j
public class Main {
    public static void main(String[] args) throws SQLException {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "postgres")
                .load();
        flyway.migrate();


        SessionFactory sessionFactory = PersistenceUtil.getInstance();

//        Session session = sessionFactory.openSession();
//        Account account = session.get(Account.class, 1);
//        log.debug("Found account {}", account);


        //create entity with one to one rel

//        Account account = new Account();
//        AccountInfo accountInfo = new AccountInfo();
//
//        accountInfo.setId(account.getId());
//        accountInfo.setInfo("Text");
//
//        accountInfo.setAccount(account);
//        account.setAccountInfo(accountInfo);
//
//        Transaction transaction = session.beginTransaction();
//        session.persist(account);
//        transaction.commit();

//delete child entity
//        Account account = session.get(Account.class, 5);
//        AccountInfo accountInfo = account.getAccountInfo();
//
//        accountInfo.setAccount(null);
//        account.setAccountInfo(null);
//
//        Transaction transaction = session.beginTransaction();
//        session.remove(accountInfo);
//        session.persist(account);
//        transaction.commit();


        //add one to one entity to parent entity
//        Account account = session.get(Account.class, 5);
//        AccountInfo accountInfo = new AccountInfo();
//        accountInfo.setInfo("Text");
//        accountInfo.setAccount(account);
//        account.setAccountInfo(accountInfo);
//
//        Transaction transaction = session.beginTransaction();
//        session.persist(accountInfo);
//        transaction.commit();
//
//
//        session.close();


        Session session = sessionFactory.openSession();

        //create new user with 1-N rel;
//        User user = session.get(User.class, 2);
//        session.close();
//        Account account = new Account();
//        account.setMoney(120);
//        account.setUser(user);
//
//        List<Account> accounts = user.getAccounts();
//        accounts.add(account);
//        user.setAccounts(accounts);
//
//        Transaction transaction = session.beginTransaction();
//        session.persist(user);
//        session.persist(account);
//        transaction.commit();
//        List<Account> accounts = user.getAccounts();
//        log.debug("Accounts {}", accounts);

        // n-n
//        User user1 = session.get(User.class, 1);
//
//        User user2 = session.get(User.class, 2);
//
//        Course course = new Course();
//        course.setName("Java Dev1");
//
//        course.setUsers(Set.of(user1, user2));
//        user1.setCourses(Set.of(course));
//        user2.setCourses(Set.of(course));
//
//        Transaction transaction = session.beginTransaction();
//        session.persist(course);
//        transaction.commit();

        session.close();
    }
}