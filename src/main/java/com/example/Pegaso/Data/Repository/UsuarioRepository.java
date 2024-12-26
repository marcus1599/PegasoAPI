package com.example.Pegaso.Data.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.Pegaso.Data.Models.Usuario;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email); // Busca o usuário pelo e-mail para login

    @Query("SELECT u FROM Usuario u WHERE u.username = :username")
    Optional<Usuario> findByUserName(@Param("username") String username);

}
