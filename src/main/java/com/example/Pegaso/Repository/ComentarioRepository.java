package com.example.Pegaso.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.Pegaso.Models.Comentario;
import com.example.Pegaso.Models.Dica;
import com.example.Pegaso.Models.Usuário;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
	
	public List<Comentario> findByDicaEquals(Dica dica);
	public List<Comentario> findByUsuarioEquals(Usuário usuario);
}