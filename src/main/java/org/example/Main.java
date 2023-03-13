package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.AccountDAO;
import org.example.dao.v3.AccountDAOImpl;
import org.example.entity.Account;
import org.example.entity.AccountInfo;
import org.example.entity.AccountType;
import org.example.storage.v2.PersistenceUtil;
import org.flywaydb.core.Flyway;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

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

        Session session = sessionFactory.openSession();
//        Query<Account> query = session.createQuery("from Account where id = :id", Account.class);
//        Query<Account> query = session.createNativeQuery("select  * from java_lessons.account where id = :id", Account.class);
//
//        query.setParameter("id", 7);
//        Account account = query.getSingleResult();
//        log.debug("Found account {}", account);

//        AccountDAO accountDAO = new AccountDAOImpl(sessionFactory);

        Account account = session.get(Account.class, 6);
//        account.setMoney(-100);
//        account.setAccountType(AccountType.Direct);
//
//        AccountInfo accountInfo = new AccountInfo();
//
//        accountInfo.setId(account.getId());
//        accountInfo.setInfo("Text");
//        accountInfo.setAccount(account);
//
////        session.persist(accountInfo);
//
//        account.setAccountInfo(accountInfo);
//
//        account.setAccountTypes(List.of("AccountTypeA", "AccountTypeB"));

//        session.merge(account);
//        accountDAO.merge(account);
        log.debug("Found account {}", account);

    }
}