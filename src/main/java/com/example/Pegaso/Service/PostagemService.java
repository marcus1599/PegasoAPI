package com.example.Pegaso.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.Pegaso.Controller.DicaController;
import com.example.Pegaso.Controller.PostagemController;
import com.example.Pegaso.Mapper.DozerMapper;

import com.example.Pegaso.Models.Postagem;
import com.example.Pegaso.Repository.PostagemRepository;
import com.example.Pegaso.VO.V1.PostagemVO;
import com.example.Pegaso.VO.V1.PostagemVO_OutPut;
import com.example.Pegaso.exceptions.ResourceNotFoundException;

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
                vo.add(linkTo(methodOn(PostagemController.class).getOnePost(vo.getKey())).withSelfRel());
                return vo;
        }

    public List<PostagemVO> findAllPost()
        {
            var post = repository.findAll();
            var postagemVO = DozerMapper.parseListObjects(post, PostagemVO.class);

            postagemVO.stream()
            .forEach(p-> p.add(linkTo(methodOn(PostagemController.class)
            .getOnePost(p.getKey())).withRel("Detalhes")));
            postagemVO.stream()
            .forEach(p-> p.add(linkTo(methodOn(DicaController.class)
            .getDicasByPostagem(p.getKey())).withRel("Dicas")));

            return postagemVO;
        }

    public PostagemVO findPostById(Long id)
        {

            var entity =  repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Searched post with specified id not found")
            );
            PostagemVO vo = DozerMapper.parseObject(entity, PostagemVO.class);
            vo.add(linkTo(methodOn(PostagemController.class).getOnePost(id)).withSelfRel());
            return vo;
        }

    public PostagemVO_OutPut findByIdPostagemCostomized(Long id)
        {
            var entity =  repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Searched post with specified id not found"));

            return DozerMapper.convertPostEntitityOutPut(entity);
        }

    public PostagemVO update(PostagemVO postagemVO, Long id)
        {
            var entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Searched post with specified id not found")
            );

            entity.setNome(postagemVO.getNome());
            entity.setDescricao(postagemVO.getDescricao());

            var postagem = repository.save(entity);

            var vo = DozerMapper.parseObject(postagem, PostagemVO.class);
            vo.add(linkTo(methodOn(PostagemController.class).getOnePost(vo.getKey())).withSelfRel());
            return vo;
            
        }

    public void deletePost(Long id)
        {
            repository.deleteById(id);
        }

    

}
