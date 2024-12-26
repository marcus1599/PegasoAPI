package com.example.Pegaso.domain.Service.Postagem;

import java.util.List;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.Pegaso.domain.VO.V1.PostagemVO;
import com.example.Pegaso.domain.VO.V1.PostagemVO_OutPut;

public interface PostagemService {

    PostagemVO savePostagem(PostagemVO postagemVO) throws Exception;

    List<PostagemVO> findAllPost() throws Exception;

    PostagemVO findPostById(Long id) throws Exception;

    PostagemVO_OutPut findByIdPostagemCostomized(Long id) throws Exception;

    PostagemVO update(PostagemVO postagemVO, Long id) throws Exception;

    Page<PostagemVO>listarPostagens(PageRequest pageable) throws Exception;

    void deletePost(Long id) throws Exception;

}