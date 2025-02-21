package com.example.Pegaso.Data.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Pegaso.Data.Models.Dica;
import com.example.Pegaso.Data.Models.Postagem;
import com.example.Pegaso.Data.Models.Usuario;


@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    static Page<Postagem> findAllByOrderByDataCriacaoDesc(PageRequest pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByOrderByDataCriacaoDesc'");
    }
      
        public List<Postagem> findByUsuarioIdUsuario(Long id);
        public List<Postagem> findByUsuarioEquals(Usuario usuario);

}
