package org.example.notes.n2n;

import jakarta.persistence.*;
import lombok.Data;
import org.example.entity.Account;

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
    @ManyToMany(mappedBy = "users",
            cascade = CascadeType.ALL)
    private Set<Course> courses;

    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
