package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

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
