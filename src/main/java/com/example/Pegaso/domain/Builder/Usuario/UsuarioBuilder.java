package com.example.Pegaso.domain.Builder.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.example.Pegaso.Data.Models.Usuario;
import com.example.Pegaso.domain.VO.V1.UsuarioVO;
import com.example.Pegaso.domain.VO.V1.UsuarioVO_OutPut;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UsuarioBuilder {

    public UsuarioVO convertToVO(Usuario user) {
        UsuarioVO vo = new UsuarioVO();
        vo.setKey(user.getIdUsuario());
        vo.setUsername(user.getUsername());
        vo.setBiografia(user.getBiografia());
        vo.setEmail(user.getEmail());
        vo.setSenha(user.getPassword());
        vo.setComentario(user.getComentarios());
        vo.setPostagem(user.getPostagens());
        return vo;
    }

    public UsuarioVO_OutPut convertToOutPut(Usuario usuario) {
        UsuarioVO_OutPut vo = new UsuarioVO_OutPut();
        vo.setIdUsuario(usuario.getIdUsuario());
        vo.setNome(usuario.getUsername());
        vo.setBiografia(usuario.getBiografia());
        vo.setEmail(usuario.getEmail());
        vo.setComentario(usuario.getComentarios());
    
        return vo;
    }

    public List<UsuarioVO> convertToVO(List<Usuario> list) {
        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    public List<UsuarioVO_OutPut> convertToOutPut(List<Usuario> list) {
        return list.stream().map(this::convertToOutPut).collect(Collectors.toList());
    }
}
