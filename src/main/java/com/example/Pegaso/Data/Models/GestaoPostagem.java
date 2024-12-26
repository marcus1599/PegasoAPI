package com.example.Pegaso.Data.Models;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
public class GestaoPostagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id_gestao;

    @Column(nullable = true)
    ArrayList<Postagem> postagems;

}
