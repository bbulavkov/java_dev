package org.example;

import org.example.dao.AccountDAO;
import org.example.service.AccountService;
import org.example.storage.DataSource;

import java.sql.SQLException;

public class Main {

    //
//        //638 ms 646 ms 617 ms  = 630 ms
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10_000; i++) {
//            userDAO.create(i + " hard name", i);
//        }
//        long executionTime = System.currentTimeMillis() - start;
//        System.out.println("Execution took " + executionTime);

    public static void main(String[] args) throws SQLException {

//        //batch size 10 220 ms  191 ms 187 ms = 195 ms 3 times faster
//        //batch size 50 145 ms 142 ms  109 ms = 130 ms
//
        DataSource dataSource = new DataSource();
//        UserDAO userDAO = new UserDAO(dataSource);
//
//        long generationStart = System.currentTimeMillis();
//
//        String[] names = RandomNameGenerator.generate(10_000);
//        int[] ages = RandomNumberGenerator.generate(10_000);
//
//        long generationTook = System.currentTimeMillis() - generationStart;
//        System.out.println("Generation took " + generationTook / 1000 + " sec");
//
////        long splitStart = System.currentTimeMillis();
////
////        String[][] strings = ArrayUtil.splitArray(names, 50);
////        int[][] splitAges = ArrayUtil.splitArray(ages, 50);
////
////        long splitTook = System.currentTimeMillis() - splitStart;
////        System.out.println("Split took " + splitTook);
//
//
//        long insertStart = System.currentTimeMillis();
////        for (int i = 0; i < strings.length; i++) {
////
////            String[] nameButch = strings[i];
////            int[] ageButch = splitAges[i];
//
//        userDAO.create(names, ages);
////        }
//        long insertExecution = System.currentTimeMillis() - insertStart;
//        System.out.println("Insert took " + insertExecution);
//    }

        AccountDAO accountDAO = new AccountDAO(dataSource);
        AccountService accountService = new AccountService(accountDAO);

        accountService.makeTransfer(1, 2, 100);
    }
}