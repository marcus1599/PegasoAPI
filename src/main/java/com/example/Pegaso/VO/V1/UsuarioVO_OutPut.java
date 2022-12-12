package com.example.Pegaso.VO.V1;

import com.example.Pegaso.Models.Comentario;

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
public class UsuarioVO_OutPut {

	Long idUsuario;
	String nome;
    String biografia;
    String email;
    Comentario comentario;
}