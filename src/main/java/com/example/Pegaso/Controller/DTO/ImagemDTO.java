package com.example.Pegaso.Controller.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImagemDTO {
    private String titulo;
    private String descricao;
    private String endereco;
    private Integer curtidas;
    private Long idPostagem;
}
