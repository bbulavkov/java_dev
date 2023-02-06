package org.example.notes;

import org.example.notes.dao.AccountDAO;
import org.example.notes.dao.UserDAO;
import org.example.notes.service.AccountService;
import org.example.notes.util.AgeGenerator;
import org.example.notes.util.ArrayUtil;
import org.example.notes.util.NamesGenerator;
import org.example.storage.DataSource;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new DataSource();
        UserDAO userDAO = new UserDAO(dataSource);
//        long executionStart = System.currentTimeMillis();
//
//        String[] randomNames = NamesGenerator.generateRandomNames(10_000);
//        int[] randomNumbers = AgeGenerator.getRandomNumbers(10_000);
//
//        System.out.println("Generation took " + (System.currentTimeMillis() - executionStart) / 1000 + " sec");
//
//        int[][] numbersSplit = ArrayUtil.splitArray(randomNumbers, 100);
//        String[][] namesSplit = ArrayUtil.splitArray(randomNames, 100);
//        //butch size 10 - 200 ms +-
//        //butch size 50 - 150 ms
//        // butch size 100 - 100 ms
//
//
//        long insertStart = System.currentTimeMillis();
//        for (int i = 0; i < namesSplit.length; i++) {
//            String[] nameButch = namesSplit[i];
//            int[] ageButch = numbersSplit[i];
//            userDAO.create(nameButch, ageButch);
//        }
//        long insertTook = System.currentTimeMillis() - insertStart;
//        System.out.println("Insert took " + insertTook);

        //650 ms +-
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10_000; i++) {
//            userDAO.create(i + " ", i);
//        }
//        long executionTime = System.currentTimeMillis() - start;
//        System.out.println("Inset time took " + executionTime);

        AccountDAO accountDAO = new AccountDAO(dataSource);
        AccountService accountService = new AccountService(accountDAO, dataSource);

        accountService.makeTransfer(1, 2, 100);

    }
}