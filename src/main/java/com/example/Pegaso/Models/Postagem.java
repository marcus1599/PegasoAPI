package com.example.Pegaso.Models;

import java.util.ArrayList;

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
public class Postagem {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idPostagem;

    @Column(nullable = false)
    String nome;

    @Column(nullable = false)
    String descricao;

    @Column(nullable = true)
    ArrayList<Dica> dicas;

    @Column(nullable = true)
    ArrayList<Imagem> imagems;

    @Column(nullable = true)
    ArrayList<Video>videos;

    @Column(nullable = true)
    ArrayList<Comentario> comentarios;
    @Column
    int curtidas;

    
}
