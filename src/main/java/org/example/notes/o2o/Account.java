package org.example.notes.o2o;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.converter.AccountTypesToStringConverter;
import org.example.entity.AccountInfo;
import org.example.entity.AccountType;

import java.util.List;


@Entity
@Table(schema = "java_lessons")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_info_id", referencedColumnName = "id")
    private AccountInfo accountInfo;

    public Account() {
    }

}
