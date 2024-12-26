package com.example.Pegaso.Data.Models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
 * - IdVideo : Int
- titulo : String
- descricao : String
 */

@Setter
@Getter
@AllArgsConstructor
@Entity
public class Video {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idVideo;

    @Column(nullable = false)
    String titulo;
    
    @Column(nullable = true)
    String descricao;

    @Column(nullable = false)
    String endereco;

}
