package com.example.Pegaso.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Pegaso.Models.Usuário;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuário, Long> {

}