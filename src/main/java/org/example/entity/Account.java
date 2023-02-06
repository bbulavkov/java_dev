package org.example.entity;

public class Account {

    int money;
    int id;

    public Account(int id, int money) {
        this.id = id;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int getId() {
        return id;
    }
}
