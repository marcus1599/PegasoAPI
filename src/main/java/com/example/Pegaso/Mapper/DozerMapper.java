package com.example.Pegaso.Mapper;
import java.util.ArrayList;
import java.util.List;

import com.example.Pegaso.Models.Dica;
import com.example.Pegaso.Models.Postagem;
import com.example.Pegaso.VO.V1.DicaVO_OutPut;
import com.example.Pegaso.VO.V1.PostagemVO_OutPut;
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
    public static PostagemVO_OutPut convertPostEntitityOutPut(Postagem postagem){
        PostagemVO_OutPut vo = new PostagemVO_OutPut();
        
        vo.setIdPostagem(postagem.getIdPostagem());
        vo.setNome(postagem.getNome());
        vo.setDescricao(postagem.getDescricao());
        vo.setCurtidas(postagem.getCurtidas());
        return vo;
    }
    public static DicaVO_OutPut convertDicaEntitityOutPut(Dica dica){
        DicaVO_OutPut vo = new DicaVO_OutPut();
        
        vo.setIdDica(dica.getIdDica());
        vo.setTitle(dica.getTitle());
        vo.setCurtidas(dica.getCurtidas());
        return vo;
    }
}
