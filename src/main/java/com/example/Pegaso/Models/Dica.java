package com.example.Pegaso.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @Column(name = "id_dica")
    Long idDica;

    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    String body;

    @Column
    int curtidas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_postagem")
    private Postagem post;
}
