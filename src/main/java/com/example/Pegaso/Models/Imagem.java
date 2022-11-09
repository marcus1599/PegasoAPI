package com.example.Pegaso.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@Entity
public class Imagem {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    Long id_Imagem;

    @Column(nullable = false)
    String titulo;

    @Column(nullable = true)
    String descricao;

    @Column
    String endereco;

    @Column
    int curtidas;


    
}
