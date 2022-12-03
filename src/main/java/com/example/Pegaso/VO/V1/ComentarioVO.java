package com.example.Pegaso.VO.V1;

import java.io.Serializable;
import org.springframework.hateoas.RepresentationModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({"idComentario", "corpo", "curtidas"})
public class ComentarioVO extends RepresentationModel<ComentarioVO> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @JsonProperty("idComentario")
    @Mapping("idComentario")
    private Long key;
    private String corpo;
    private int curtidas = 0;
    
    public ComentarioVO() { }

    public Long getKey() { return key; }
    
    public void setKey(Long key) { this.key = key; }
    
    public String getCorpo() { return corpo; }
    
    public void setCorpo(String corpo) { this.corpo = corpo; }
    
    public int getCurtidas() { return curtidas; }
    
    public void setCurtidas(int curtidas) { this.curtidas = curtidas; }
    
    @Override
    public int hashCode() {
    	
        final int prime = 31;
        int result = 1;
        
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((corpo == null) ? 0 : corpo.hashCode());
        result = prime * result + curtidas;
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
    	
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if (getClass() != obj.getClass())
            return false;
        
        ComentarioVO other = (ComentarioVO) obj;
        
        if (key == null) {
        	if (other.key != null)
                return false;
        }
        
        else if (!key.equals(other.key))
            return false;
        
        if (corpo == null) {
            if (other.corpo != null)
                return false;
        }
        
        else if (!corpo.equals(other.corpo))
            return false;
           
        if (curtidas != other.curtidas)
            return false;
        
        return true;
    }

}