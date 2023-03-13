package org.example.notes.o2o.v2;

import jakarta.persistence.*;
import lombok.Data;
import org.example.entity.Account;

@Data
@Table(name = "account_info", schema = "java_lessons")
@Entity
public class AccountInfo {
    @Id
    @Column(name = "account_id")
    private int id;

    private String info;
    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private Account account;


    @Override
    public String toString() {
        return "AccountInfo{" +
                "id=" + id +
                "info=" + info +
                '}';
    }
}
