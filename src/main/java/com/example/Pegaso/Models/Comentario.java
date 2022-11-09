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
 * - idComentario : Int
- idPostagem : Int
- Texto : String
- curtidas : Int

 */
@Setter
@Getter
@AllArgsConstructor
@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_Comentario;

    @Column(nullable = false)
    String corpo;

    @Column
    int curtidas;
    
}
