package com.example.Pegaso.domain.Service.Postagem;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.Pegaso.Data.Models.Postagem;
import com.example.Pegaso.Data.Models.Usuario;
import com.example.Pegaso.domain.VO.V1.DicaVO_OutPut;
import com.example.Pegaso.domain.VO.V1.PostagemVO;
import com.example.Pegaso.domain.VO.V1.PostagemVO_OutPut;
import com.example.Pegaso.domain.VO.V1.UsuarioVO;

public interface PostagemService {

    PostagemVO savePostagem(PostagemVO postagemVO, UsuarioVO usuarioVO) throws Exception;

    List<PostagemVO> findAllPost() throws Exception;
    List<PostagemVO> findAllPostByUser(Long id) throws Exception;

    PostagemVO findPostById(Long id) throws Exception;

      List<PostagemVO_OutPut> findByUsuarioContainin(Usuario usuario) throws Exception;

    PostagemVO_OutPut findByIdPostagemCostomized(Long id) throws Exception;

    PostagemVO update(PostagemVO postagemVO, Long id) throws Exception;

    Page<PostagemVO>listarPostagens(PageRequest pageable) throws Exception;

    void deletePost(Long id) throws Exception;

}