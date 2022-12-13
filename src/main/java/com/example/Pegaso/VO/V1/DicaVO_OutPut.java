package com.example.Pegaso.VO.V1;


import java.util.List;

import com.example.Pegaso.Models.Comentario;
import com.example.Pegaso.Models.Postagem;
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
public class DicaVO_OutPut {
    Long idDica;
    String   title;
    Postagem postagem;
    List<Comentario> comentario;
    int curtidas =0;
}
