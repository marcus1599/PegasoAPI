package com.example.Pegaso.Models;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
@Entity
public class Postagem  implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idPostagem;

    @Column (nullable = false)
    String   nome;

    @Column (nullable = false)
    String   descricao;
    
    @Column (nullable = true)
    ArrayList<Dica> dicas;

    @Column (nullable = true)
    ArrayList<Imagem> imagems;

    @Column (nullable = true)
    ArrayList<Video>videos;

    @Column (nullable = true)
    ArrayList<Comentario> comentarios;

    @Column(nullable = true)
    int curtidas =0;

    
}

