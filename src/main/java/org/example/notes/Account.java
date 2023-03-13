package org.example.notes;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.entity.AccountType;


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

    public Account() {
    }












//    @ElementCollection
//    @Column(name = "type")
//    @CollectionTable(name = "account_account_types", schema = "java_lessons",
//            joinColumns = @JoinColumn(name = "account_id")
//    )
//    List<AccountType> types;
//
//    @ElementCollection
//    @Column(name = "sub_account")
//    @CollectionTable(name = "account_sub_accounts",
//            schema = "java_lessons",
//            joinColumns = @JoinColumn(name = "account_id"))
//    List<String> subAccounts;


}
