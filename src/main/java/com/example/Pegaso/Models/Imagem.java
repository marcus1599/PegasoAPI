package com.example.Pegaso.Models;

import javax.persistence.*;


import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id_Imagem;

    @ManyToOne
    @JoinColumn(name = "id_postagem")
    Postagem postagem;

    @Column(nullable = false)
    String titulo;

    @Column(nullable = true)
    String descricao;

    @Column
    String endereco;

    @Column
    Integer curtidas;

    @Column
    @Lob
    private byte[] figure;


    
}
