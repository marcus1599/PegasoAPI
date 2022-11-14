package com.example.Pegaso.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Pegaso.Mapper.DozerMapper;
import com.example.Pegaso.Models.Postagem;
import com.example.Pegaso.Repository.PostagemRepository;
import com.example.Pegaso.VO.V1.PostagemVO;

import java.util.List;


@Service
public class PostagemService {
    
    @Autowired
    private PostagemRepository repository;

    public PostagemVO savePostagem(PostagemVO postagemVO)
    {

            //Conversão de VO para entidade
            var entity = DozerMapper.parseObject(postagemVO, Postagem.class);

            //Salvando no banco de dados e adicionando em uma variável
            var postagem = repository.save(entity);

            //Convertendo para Vo para exibir para usuário
            var vo = DozerMapper.parseObject(postagem, PostagemVO.class);
            return vo;
    }

    public List<PostagemVO> findAllPost()
    {
        var post = repository.findAll();
        var postagemVO = DozerMapper.parseListObjects(post, PostagemVO.class);
        return postagemVO;
    }
    public PostagemVO findPostById(Long id)
    {

        var entity =  repository.findById(id);
        return DozerMapper.parseObject(entity, PostagemVO.class);
    }
    public PostagemVO update(PostagemVO postagemVO, Long id){
        var entity = repository.findById(id).orElseThrow();

        
        entity.setNome(postagemVO.getNome());
        entity.setDescricao(postagemVO.getDescricao());

        var postagem = repository.save(entity);

        var vo = DozerMapper.parseObject(postagem, PostagemVO.class);
        return vo;
        
    }
    public void deletePost(Long id)
    {
        repository.deleteById(id);
    }

}
