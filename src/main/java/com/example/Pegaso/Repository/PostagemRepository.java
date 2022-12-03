package com.example.Pegaso.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Pegaso.Models.Postagem;



public interface PostagemRepository extends JpaRepository<Postagem,Long> {

   
    
}
