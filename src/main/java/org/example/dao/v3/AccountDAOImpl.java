package org.example.dao.v3;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.AccountDAO;
import org.example.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountDAOImpl implements AccountDAO {
    SessionFactory sessionFactory;

    @Override
    public Account getById(int id) {
        Session session = sessionFactory.openSession();
        return session.get(Account.class, id);
    }

    @Override
    public void persist(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(account);
        transaction.commit();
    }

    @Override
    public void merge(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(account);
        transaction.commit();
    }
}
