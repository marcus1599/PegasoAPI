package com.example.Pegaso.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Pegaso.Models.Postagem;


@Repository
public interface PostagemRepository extends JpaRepository<Postagem,Long> {

   
    
}
