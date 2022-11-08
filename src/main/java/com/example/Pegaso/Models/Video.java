package com.example.Pegaso.Models;
import javax.persistence.Entity;
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
    Long idVideo;
    String titulo;
    String descricao;

}
