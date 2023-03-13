package org.example.notes.o2n;

import jakarta.persistence.*;
import lombok.Data;
import org.example.entity.Account;
import org.example.notes.n2n.Course;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users", schema = "java_lessons")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String name;
    private int age;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<Account> accounts;
    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
