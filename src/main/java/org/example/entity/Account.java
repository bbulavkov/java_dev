package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.converter.AccountTypesToStringConverter;

import java.util.List;


@Entity
@Table(schema = "java_lessons")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(exclude = "user")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int money;
    @Column(name = "account_type")
    @Enumerated(value = EnumType.STRING)
    AccountType accountType;

//    @ElementCollection
//    @CollectionTable(name = "account_types",
//            schema = "java_lessons",
//            joinColumns = @JoinColumn(name = "account_id"))
//    @Column(name = "type")
//    List<String> accountTypes;

    @Column(name = "account_types")
    @Convert(converter = AccountTypesToStringConverter.class)
    List<String> accountTypes;


    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AccountInfo accountInfo;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    private User user;

    public Account() {
    }

}
