package com.example.Pegaso.domain.Service.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Pegaso.Controller.UsuarioController;
import com.example.Pegaso.Data.Models.Usuario;
import com.example.Pegaso.Data.Repository.UsuarioRepository;
import com.example.Pegaso.exceptions.ResourceNotFoundException;

import lombok.AllArgsConstructor;

import com.example.Pegaso.domain.Builder.DozerMapper;
import com.example.Pegaso.domain.Builder.Usuario.UsuarioBuilder;
import com.example.Pegaso.domain.Service.File.FileStorageService;
import com.example.Pegaso.domain.VO.V1.UsuarioVO;
import com.example.Pegaso.domain.VO.V1.UsuarioVO_OutPut;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

@Primary
@Service
@AllArgsConstructor
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository repositoryUser;
	private final UsuarioBuilder usuarioBuilder;

	@Override
	public UsuarioVO saveUser(UsuarioVO usuarioVO) throws Exception {

		var entity = DozerMapper.parseObject(usuarioVO, Usuario.class);
		var usuario = repositoryUser.save(entity);
		var vo = usuarioBuilder.convertToVO(usuario);
		vo.add(linkTo(methodOn(UsuarioController.class).getOneUser(vo.getKey())).withSelfRel());
		return vo;
	}

	@Override
	public List<UsuarioVO> findAllUser() {

		var user = repositoryUser.findAll();
		var usuarioVO = usuarioBuilder.convertToVO(user);
		usuarioVO.stream()
				.forEach(p -> {
					try {
						p.add(linkTo(methodOn(UsuarioController.class).getOneUser(p.getKey())).withSelfRel());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
		return usuarioVO;
	}

	@Override
	public UsuarioVO findUserById(Long id) throws Exception {

		var entity = repositoryUser.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Searched user with specified id not found"));
		UsuarioVO vo = DozerMapper.parseObject(entity, UsuarioVO.class);
		vo.add(linkTo(methodOn(UsuarioController.class).getOneUser(id)).withSelfRel());
		return vo;
	}

	@Override
	public UsuarioVO_OutPut findByIdUserCostomized(Long id) {

		var entity = repositoryUser.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Searched user with specified id not found"));
		return usuarioBuilder.convertToOutPut(entity);
	}

	@Override
	public UsuarioVO updateUser(UsuarioVO usuarioVO, Long id) throws Exception {

		var entity = repositoryUser.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Searched user with specified id not found"));
		entity.setUserName(usuarioVO.getUsername());
		entity.setBiografia(usuarioVO.getBiografia());
		entity.setEmail(usuarioVO.getEmail());
		var usuario = repositoryUser.save(entity);
		var vo = DozerMapper.parseObject(usuario, UsuarioVO.class);
		vo.add(linkTo(methodOn(UsuarioController.class).getOneUser(vo.getKey())).withSelfRel());
		return vo;
	}

	@Override
	public void deleteUser(Long id) {

		repositoryUser.deleteById(id);
	}

	@Autowired
	private FileStorageService fileStorageService;

	public Usuario atualizarAvatar(Long userId, MultipartFile avatarFile) throws Exception {
        // Busca o usuário no banco de dados
        Optional<Usuario> usuarioOpt = repositoryUser.findById(userId);

        if (usuarioOpt.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        Usuario usuario = usuarioOpt.get();

        // Salva o avatar no disco
        String avatarPath = fileStorageService.storeFile(avatarFile);

        // Atualiza o avatar do usuário
        usuario.setAvatar(avatarPath);
        return repositoryUser.save(usuario);
    }



}