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
        vo.setNome(user.getNome());
        vo.setBiografia(user.getBiografia());
        vo.setEmail(user.getEmail());
        vo.setComentario(user.getComentario());
        vo.setPostagem(user.getPostagems());
        return vo;
    }

    public UsuarioVO_OutPut convertToOutPut(Usuario usuário) {

        UsuarioVO_OutPut vo = new UsuarioVO_OutPut();
        vo.setIdUsuario(usuário.getIdUsuario());
        vo.setNome(usuário.getNome());
        vo.setBiografia(usuário.getBiografia());
        vo.setEmail(usuário.getEmail());
        vo.setComentario(usuário.getComentario());
        return vo;
    }

    public List<UsuarioVO> convertToVO(List<Usuario> list) {

        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    public List<UsuarioVO_OutPut> convertToOutPut(List<Usuario> list) {

        return list.stream().map(this::convertToOutPut).collect(Collectors.toList());
    }

}
