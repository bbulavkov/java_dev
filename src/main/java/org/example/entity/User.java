package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
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

    @OneToMany(mappedBy = "user")
    private Set<Account> accounts = new HashSet<>();


    @JoinTable(
            schema = "java_lessons",
            name = "user_course",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @ManyToMany
    private Set<Course> courses = new HashSet<>();

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", accounts=" + accounts +
                ", courses=" + courses.size() +
                '}';
    }
}
