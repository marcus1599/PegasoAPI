package com.example.Pegaso.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.Pegaso.Controller.DicaController;
import com.example.Pegaso.Mapper.DozerMapper;
import com.example.Pegaso.Models.Dica;
import com.example.Pegaso.Models.Postagem;
import com.example.Pegaso.Repository.DicaRepository;
import com.example.Pegaso.Repository.PostagemRepository;
import com.example.Pegaso.VO.V1.DicaVO;
import com.example.Pegaso.VO.V1.DicaVO_OutPut;
import com.example.Pegaso.VO.V1.PostagemVO;
import com.example.Pegaso.exceptions.ResourceNotFoundException;

import ch.qos.logback.classic.Logger;

import java.util.List;


@Service
public class DicaService {
    
    @Autowired
    private DicaRepository repository;
    @Autowired
    private PostagemRepository postRepository;


    public DicaVO saveDica(DicaVO dicaVO,Long idPost)
        {   

            var entityPost = postRepository.findById(idPost).orElseThrow(
                () -> new ResourceNotFoundException("Searched post with specified id not found")
                );

                dicaVO.setPostagem(entityPost);
                //Conversão de VO para entidade
                var entity = DozerMapper.parseObject(dicaVO,Dica.class);
                
                //Adicionando a Dica a Postagem
                
              //  entity.setPostagem((Postagem)entityPost);
                entityPost.addDica(entity);
                postRepository.save(entityPost);
                
                
                //Salvando no banco de dados e adicionando em uma variável
                var dica = repository.save(entity);

                //Convertendo para Vo para exibir para usuário
                var vo = DozerMapper.convertDicaEntitityToVo(dica);
                vo.add(linkTo(methodOn(DicaController.class).getOneDica(vo.getKey())).withSelfRel());
                return vo;
        }

    public List<DicaVO> findAllDicas()
        {
            var dica = repository.findAll();
            var dicaVO = DozerMapper.convertListofDicaEntitityToVo(dica);

            dicaVO.stream()
            .forEach(p-> p.add(linkTo(methodOn(DicaController.class)
            .getOneDica(p.getKey())).withSelfRel()));

            return dicaVO;
        }

    public DicaVO findById(Long id)
        {

            var entity =  repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Searched dica with specified id not found")
            );
            DicaVO vo = DozerMapper.parseObject(entity, DicaVO.class);
            vo.add(linkTo(methodOn(DicaController.class).getOneDica(id)).withSelfRel());
            return vo;
        }

  

    public DicaVO update(DicaVO dicaVo, Long id)
        {
            var entity = repository.findById(dicaVo.getKey()).orElseThrow(
                () -> new ResourceNotFoundException("Searched dica with specified id not found")
            );

            entity.setTitle(dicaVo.getTitle());
            entity.setBody(dicaVo.getBody());

            var dica = repository.save(entity);

            var vo = DozerMapper.parseObject(dica, DicaVO.class);
            vo.add(linkTo(methodOn(DicaController.class).getOneDica(vo.getKey())).withSelfRel());
            return vo;
            
        }
        public DicaVO_OutPut findByIdDicaCostomized(Long id)
        {
            var entity =  repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Searched post with specified id not found"));

            return DozerMapper.convertDicaEntitityOutPut(entity);
        }

    public void deleteDica(Long id)
        {
            repository.deleteById(id);
        }

    

}
