package org.example.notes.o2o;

import jakarta.persistence.*;
import lombok.Data;
import org.example.entity.Account;

@Data
@Table(name = "account_info", schema = "java_lessons")
@Entity
public class AccountInfo {
    @Id
    private int id;

    private String info;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_info_id", referencedColumnName = "id")
    private Account account;


    @Override
    public String toString() {
        return "AccountInfo{" +
                "id=" + id +
                "info=" + info +
                '}';
    }
}
