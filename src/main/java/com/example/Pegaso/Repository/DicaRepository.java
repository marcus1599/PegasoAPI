package com.example.Pegaso.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Pegaso.Models.Dica;
import com.example.Pegaso.Models.Postagem;

@Repository
public interface DicaRepository extends JpaRepository<Dica,Long> {

    List<Dica>findAllDicaByPostagem(Postagem postagem);
    
}
