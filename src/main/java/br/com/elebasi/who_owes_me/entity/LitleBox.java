package br.com.elebasi.who_owes_me.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(schema = "litle_box")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LitleBox {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;
    private String title;

    public LitleBox(String title) {
        this.title = title;
    }
}
