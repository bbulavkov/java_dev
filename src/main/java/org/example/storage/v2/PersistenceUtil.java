package org.example.storage.v2;

import org.example.entity.Account;
import org.example.entity.AccountInfo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class PersistenceUtil {

    private static SessionFactory INSTANCE;

    private PersistenceUtil() {
    }

    public static SessionFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Configuration()
                    .addAnnotatedClass(Account.class)
                    .addAnnotatedClass(AccountInfo.class)
                    .buildSessionFactory();
        }
        return INSTANCE;
    }

}
