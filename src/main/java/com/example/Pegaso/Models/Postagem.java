package com.example.Pegaso.Models;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    private Long idPostagem;

    @Column (nullable = false)
    private String   nome;

    @Column (nullable = false)
    private String   descricao;
    
    @Column (nullable = true)
    @OneToMany
    private ArrayList<Dica> dicas;

    @Column (nullable = true)
    private ArrayList<Imagem> imagems;

    @Column (nullable = true)
    private ArrayList<Video>videos;

    @Column(nullable = true)
    private int curtidas =0;

    
}

