package com.example.Pegaso.VO.V1;


import java.util.List;

import com.example.Pegaso.Models.Dica;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostagemVO_OutPut {
    Long idPostagem;
    String   nome;
    String   descricao;
    List<Dica> dicas;
    
}
