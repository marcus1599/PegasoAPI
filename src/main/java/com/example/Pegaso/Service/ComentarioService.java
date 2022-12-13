package com.example.Pegaso.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Pegaso.Controller.ComentarioController;
import com.example.Pegaso.exceptions.ResourceNotFoundException;
import com.example.Pegaso.Mapper.DozerMapper;
import com.example.Pegaso.Models.Comentario;
import com.example.Pegaso.Models.Dica;
import com.example.Pegaso.Models.Usuário;
import com.example.Pegaso.Repository.ComentarioRepository;
import com.example.Pegaso.Repository.DicaRepository;
import com.example.Pegaso.VO.V1.ComentarioVO;
import com.example.Pegaso.VO.V1.ComentarioVO_OutPut;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.List;

@Service
public class ComentarioService {
	
	@Autowired
    private ComentarioRepository repositoryComment;
	
	 public List<ComentarioVO> findByDicaContainin(Dica dica) {
         
		 var comentario = repositoryComment.findByDicaEquals(dica);
         var comentarioVO = DozerMapper.convertListofComentarioEntitityToVo(comentario);
         comentarioVO.stream().forEach(p-> p.add(linkTo(methodOn(ComentarioController.class).getOneComment(p.getKey())).withSelfRel()));
         return comentarioVO;
     }
	 
	 public List<ComentarioVO> findByUserContainin(Usuário usuario) {
         
		 var comentario = repositoryComment.findByUsuarioEquals(usuario);
		 var comentarioVO = DozerMapper.convertListofComentarioEntitityToVo(comentario);
         comentarioVO.stream().forEach(p-> p.add(linkTo(methodOn(ComentarioController.class).getOneComment(p.getKey())).withSelfRel()));
         return comentarioVO;
     }
	 
	public ComentarioVO saveComment(ComentarioVO comentarioVO) {
		
		var entity = DozerMapper.parseObject(comentarioVO, Comentario.class);
    	var comentario = repositoryComment.save(entity);
    	var vo = DozerMapper.parseObject(comentario, ComentarioVO.class);
        vo.add(linkTo(methodOn(ComentarioController.class).getOneComment(vo.getKey())).withSelfRel());
        return vo;
	}
	
	public List<ComentarioVO> findAllComment() {
		
		var comment = repositoryComment.findAll();
        var comentarioVO = DozerMapper.parseListObjects(comment, ComentarioVO.class);
        comentarioVO.stream().forEach(p-> p.add(linkTo(methodOn(ComentarioController.class).getOneComment(p.getKey())).withSelfRel()));
        return comentarioVO;
	}
	
	public ComentarioVO findCommentById(Long id) {
    	
    	var entity =  repositoryComment.findById(id).orElseThrow( () -> new ResourceNotFoundException("Searched comment with specified id not found"));
        ComentarioVO vo = DozerMapper.parseObject(entity, ComentarioVO.class);
        vo.add(linkTo(methodOn(ComentarioController.class).getOneComment(id)).withSelfRel());
        return vo;
    }
	
	public ComentarioVO_OutPut findByIdCommentCostomized(Long id) {
        
    	var entity =  repositoryComment.findById(id).orElseThrow( () -> new ResourceNotFoundException("Searched comment with specified id not found"));
    	return DozerMapper.convertCommentEntitityOutPut(entity);
    }

    public ComentarioVO updateComment(ComentarioVO comentarioVO, Long id) {
        
    	var entity = repositoryComment.findById(id).orElseThrow( () -> new ResourceNotFoundException("Searched comment with specified id not found"));
    	entity.setCorpo(comentarioVO.getCorpo());
    	entity.setCurtidas(comentarioVO.getCurtidas());
        var comentario = repositoryComment.save(entity);
        var vo = DozerMapper.parseObject(comentario, ComentarioVO.class);
        vo.add(linkTo(methodOn(ComentarioController.class).getOneComment(vo.getKey())).withSelfRel());
        return vo;
    }
	
	public void deleteComment (Long id) {
		
		repositoryComment.deleteById(id);
	}

}