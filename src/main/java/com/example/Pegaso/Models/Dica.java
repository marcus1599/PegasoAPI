package com.example.Pegaso.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * - IdDica : Int
- titulo : String
- descricao : String
- curtidas: int
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idDica;

    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    String body;

    @Column
    int curtidas;

    @ManyToOne
    @JoinColumn(name = "idPostagem")
    Postagem post;
}
