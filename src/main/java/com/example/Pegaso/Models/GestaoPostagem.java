package com.example.Pegaso.Models;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class GestaoPostagem {

    @Column
    ArrayList<Postagem> postagems;
    
}
