package com.example.Pegaso.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Pegaso.Models.Usuário;

public interface UsuarioRepository extends JpaRepository<Usuário, Long> {

}