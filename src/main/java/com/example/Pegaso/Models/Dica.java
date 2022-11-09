package com.example.Pegaso.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
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
@Entity
public class Dica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id_Dica;

    @Column(nullable = false)
    String body;

    @Column
    int curtidas;
}
