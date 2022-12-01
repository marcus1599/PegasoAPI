package com.example.Pegaso.VO.V1;

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
public class ComentarioVO_OutPut {
	
	Long idComentario;
	String corpo;
    int curtidas = 0;
}