package com.example.Pegaso.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Pegaso.Controller.UsuarioController;
import com.example.Pegaso.exceptions.ResourceNotFoundException;
import com.example.Pegaso.Mapper.DozerMapper;
import com.example.Pegaso.Models.Usuario;
import com.example.Pegaso.Repository.UsuarioRepository;
import com.example.Pegaso.VO.V1.UsuarioVO;
import com.example.Pegaso.VO.V1.UsuarioVO_OutPut;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.List;

@Service
public class UsuarioService {
	
	@Autowired
    private UsuarioRepository repositoryUser;
	
	public UsuarioVO saveUser(UsuarioVO usuarioVO) {
		
		var entity = DozerMapper.parseObject(usuarioVO, Usuario.class);
    	var usuario = repositoryUser.save(entity);
    	var vo = DozerMapper.convertUserEntitityToVo(usuario);
        vo.add(linkTo(methodOn(UsuarioController.class).getOneUser(vo.getKey())).withSelfRel());
        return vo;
	}
	
	public List<UsuarioVO> findAllUser() {
		
		var user = repositoryUser.findAll();
        var usuarioVO = DozerMapper.convertListofUserEntitityToVo(user);
        usuarioVO.stream().forEach(p-> p.add(linkTo(methodOn(UsuarioController.class).getOneUser(p.getKey())).withSelfRel()));
        return usuarioVO;
	}
	
	public UsuarioVO findUserById(Long id) {
    	
    	var entity =  repositoryUser.findById(id).orElseThrow( () -> new ResourceNotFoundException("Searched user with specified id not found"));
        UsuarioVO vo = DozerMapper.parseObject(entity, UsuarioVO.class);
        vo.add(linkTo(methodOn(UsuarioController.class).getOneUser(id)).withSelfRel());
        return vo;
    }
	
	public UsuarioVO_OutPut findByIdUserCostomized(Long id) {
        
    	var entity =  repositoryUser.findById(id).orElseThrow( () -> new ResourceNotFoundException("Searched user with specified id not found"));
    	return DozerMapper.convertUserEntitityOutPut(entity);
    }

    public UsuarioVO updateUser(UsuarioVO usuarioVO, Long id) {
        
    	var entity = repositoryUser.findById(id).orElseThrow( () -> new ResourceNotFoundException("Searched user with specified id not found"));
    	entity.setNome(usuarioVO.getNome());
    	entity.setBiografia(usuarioVO.getBiografia());
    	entity.setEmail(usuarioVO.getEmail());
        var usuario = repositoryUser.save(entity);
        var vo = DozerMapper.parseObject(usuario, UsuarioVO.class);
        vo.add(linkTo(methodOn(UsuarioController.class).getOneUser(vo.getKey())).withSelfRel());
        return vo;
    }
	
	public void deleteUser (Long id) {
		
		repositoryUser.deleteById(id);
	}

}