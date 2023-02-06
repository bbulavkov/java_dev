package org.example.notes.entity;

public class Account {
    int id;

    public Account(int id, int money) {
        this.id = id;
        this.money = money;
    }

    int money;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
