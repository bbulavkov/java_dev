package org.example.notes.n2n;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.entity.User;

import java.util.Set;

@Data
@Table(schema = "java_lessons")
@Entity
@EqualsAndHashCode(exclude = {"users"})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(schema = "java_lessons",
            name = "user_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;

}
