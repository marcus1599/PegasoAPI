package com.example.Pegaso.Mapper;
import java.util.ArrayList;
import java.util.List;

import com.example.Pegaso.Models.Dica;
import com.example.Pegaso.Models.Postagem;
import com.example.Pegaso.VO.V1.DicaVO_OutPut;
import com.example.Pegaso.Models.Comentario;
import com.example.Pegaso.Models.Usuário;
import com.example.Pegaso.VO.V1.ComentarioVO;
import com.example.Pegaso.VO.V1.ComentarioVO_OutPut;
import com.example.Pegaso.VO.V1.DicaVO;
import com.example.Pegaso.VO.V1.PostagemVO_OutPut;
import com.example.Pegaso.VO.V1.UsuarioVO_OutPut;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;


public class DozerMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    
    public static <O,D> D parseObject(O origin,Class<D> destination){
        return mapper.map(origin,destination);

    }
    
    public static <O,D> List<D> parseListObjects(List<O> origin,Class<D> destination){
        List<D> destinationObjects = new ArrayList<>();

        for(O o : origin){
            destinationObjects.add(mapper.map(o,destination));
        }

        return destinationObjects;

    }
    // public static <Dica,DicaVo> List<DicaVo> parseDicasObjects(List<Dica> origin,Class<DicaVo> destination){
    //     List<DicaVo> destinationObject;
        
    //     // ((com.example.Pegaso.Models.Dica) destinationObject).setIdDica(((com.example.Pegaso.Models.Dica) origin).getIdDica());
    //     // ((com.example.Pegaso.Models.Dica) destinationObject).setTitle(((com.example.Pegaso.Models.Dica) origin).getTitle());
    //     // ((com.example.Pegaso.Models.Dica) destinationObject).setCurtidas(((com.example.Pegaso.Models.Dica) origin).getCurtidas());
    //     // ((com.example.Pegaso.Models.Dica) destinationObject).setPostagem(((com.example.Pegaso.Models.Dica) origin).getPostagem());

    //     return destinationObject;


    // }
   

    public static ComentarioVO_OutPut convertCommentEntitityOutPut(Comentario comentario) {
    	
    	ComentarioVO_OutPut vo = new ComentarioVO_OutPut();
    	vo.setIdComentario(comentario.getIdComentario());
    	vo.setCorpo(comentario.getCorpo());
    	vo.setCurtidas(comentario.getCurtidas());
    	vo.setDica(comentario.getDica());
    	vo.setUsuario(comentario.getUsuário());
    	return vo;
    }
    
    public static PostagemVO_OutPut convertPostEntitityOutPut(Postagem postagem){
        PostagemVO_OutPut vo = new PostagemVO_OutPut();
        
        vo.setIdPostagem(postagem.getIdPostagem());
        vo.setNome(postagem.getNome());
        vo.setDescricao(postagem.getDescricao());
     
        vo.setDicas(postagem.getDicas());
        
        return vo;
    }

    public static DicaVO_OutPut convertDicaEntitityOutPut(Dica dica){
        DicaVO_OutPut vo = new DicaVO_OutPut();
        vo.setIdDica(dica.getIdDica());
        vo.setTitle(dica.getTitle());
        vo.setCurtidas(dica.getCurtidas());
        vo.setComentario(dica.getComentario());
        vo.setPostagem(dica.getPostagem());
        return vo;
    }
    
  public static UsuarioVO_OutPut convertUserEntitityOutPut(Usuário usuário) {
    	
    	UsuarioVO_OutPut vo = new UsuarioVO_OutPut();
    	vo.setIdUsuario(usuário.getIdUsuario());
    	vo.setNome(usuário.getNome());
    	vo.setBiografia(usuário.getBiografia());
    	vo.setEmail(usuário.getEmail());
    	vo.setComentario(usuário.getComentario());
    	return vo;
  }
    
    public static DicaVO convertDicaEntitityToVo(Dica dica){
        DicaVO vo = new DicaVO();
        Postagem post = dica.getPostagem();
        vo.setKey(dica.getIdDica());
        vo.setTitle(dica.getTitle());
        vo.setBody(dica.getBody());
        vo.setCurtidas(dica.getCurtidas());
        vo.setPostagem(post);
        return vo;
    }
    public static List<DicaVO> convertListofDicaEntitityToVo(List<Dica> origin){
        List<DicaVO> vo = new ArrayList();


        for( Dica dica : origin){
            DicaVO dicaAux = new DicaVO();
            dicaAux.setKey(dica.getIdDica());
            dicaAux.setCurtidas(dica.getCurtidas());
            dicaAux.setTitle(dica.getTitle());
            dicaAux.setPostagem(dica.getPostagem());
            dicaAux.setBody(dica.getBody());
            vo.add(dicaAux);
      
        }

        return vo;
    }
    
    public static List<ComentarioVO> convertListofComentarioEntitityToVo(List<Comentario> origin){
        List<ComentarioVO> vo = new ArrayList();

        for(Comentario comentario : origin){
            ComentarioVO comentarioAux = new ComentarioVO();
            comentarioAux.setKey(comentario.getIdComentario());
            comentarioAux.setCurtidas(comentario.getCurtidas());
            comentarioAux.setCorpo(comentario.getCorpo());
            comentarioAux.setDica(comentario.getDica());
            comentarioAux.setUsuário(comentario.getUsuário());
            vo.add(comentarioAux);
        }

        return vo;
    }
    
    public static Dica convertDicaVoToEntity(DicaVO dica){
        Dica vo = new Dica();
        Postagem post = dica.getPostagem();
        vo.setIdDica(dica.getKey());
        vo.setTitle(dica.getTitle());
        vo.setBody(dica.getBody());
        vo.setCurtidas(dica.getCurtidas());
        vo.setPostagem(post);
        return vo;
    }

}
