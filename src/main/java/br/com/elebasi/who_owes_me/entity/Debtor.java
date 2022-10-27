package br.com.elebasi.who_owes_me.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "debtor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Debtor {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private long id;
    private String name;

    public Debtor(String name){
        this.name = name;
    }
}
