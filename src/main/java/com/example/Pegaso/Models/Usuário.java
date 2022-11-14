package com.example.Pegaso.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*- Id_user : Int
- nome : String
- biografia : String
- email : String
 */
@Setter
@Getter
@AllArgsConstructor
@Entity
public class Usuário {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idUsuario;

    @Column(nullable = false)
    String nome;

    @Column(nullable = true)
    String biografia;

    @Column(nullable = false)
    String email;

    // @Column(nullable = true)
    // GestaoPostagem userPostagens;
    
}
