package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "java_lessons")
@Data
public class Account {

    int money;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    public Account(int id, int money) {
        this.id = id;
        this.money = money;
    }

    public Account() {
    }

    public int getMoney() {
        return money;
    }

    public int getId() {
        return id;
    }
}
