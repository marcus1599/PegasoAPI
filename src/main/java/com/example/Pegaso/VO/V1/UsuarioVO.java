package com.example.Pegaso.VO.V1;

import java.io.Serializable;
import org.springframework.hateoas.RepresentationModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({"idUsuario", "nome", "biografia", "email"})
public class UsuarioVO extends RepresentationModel<UsuarioVO> implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @JsonProperty("idUsuario")
    @Mapping("idUsuario")
    private Long key;
    private String nome;
    private String biografia;
    private String email;
    
    public UsuarioVO() { }

    public Long getKey() { return key; }
    
    public void setKey(Long key) { this.key = key; }
    
    public String getNome() { return nome; }
    
    public void setNome(String nome) { this.nome = nome; }
    
    public String getBiografia() { return biografia; }
    
    public void setBiografia(String biografia) { this.biografia = biografia; }
    
    public String getEmail() { return email; }
    
    public void setEmail(String email) { this.email = email; }
    
    @Override
    public int hashCode() {
    	
        final int prime = 31;
        int result = 1;
        
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((biografia == null) ? 0 : biografia.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
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
        
        UsuarioVO other = (UsuarioVO) obj;
        
        if (key == null) {
        	if (other.key != null)
                return false;
        } 
        
        else if (!key.equals(other.key))
            return false;
        
        if (nome == null) {
            if (other.nome != null)
                return false;
        }
        
        else if (!nome.equals(other.nome))
            return false;
        
        if (biografia == null) {
            if (other.biografia != null)
                return false;
        }
        
        else if (!biografia.equals(other.biografia))
            return false;
        
        if (email == null) {
            if (other.email != null)
                return false;
        }
        
        else if (!email.equals(other.email))
            return false;
        
        return true;
    }
    
}