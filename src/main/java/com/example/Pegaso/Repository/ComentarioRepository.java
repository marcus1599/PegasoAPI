package com.example.Pegaso.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Pegaso.Models.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}