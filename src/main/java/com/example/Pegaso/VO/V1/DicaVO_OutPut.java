package com.example.Pegaso.VO.V1;


import java.io.Serializable;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.example.Pegaso.Models.Comentario;
import com.example.Pegaso.Models.Postagem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id_dica","title", "idPostagem", "curtidas", "quantComentario"})
public class DicaVO_OutPut extends RepresentationModel<DicaVO_OutPut>  implements Serializable{
    private static final long serialVersionUID = 1L;
    @JsonProperty("id_dica")
    @Mapping("idDica")
    private Long key;
    String   title;
    Long idPostagem;
    int quantComentario;
    int curtidas =0;

}
