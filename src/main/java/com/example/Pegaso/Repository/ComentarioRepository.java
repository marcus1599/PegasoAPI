package com.example.Pegaso.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Pegaso.Models.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}