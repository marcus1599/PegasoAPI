package com.example.Pegaso.VO.V1;


import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;


import com.example.Pegaso.Models.Postagem;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;


@JsonPropertyOrder({"idDica","title", "body", "curtidas", "post"})
public class DicaVO extends RepresentationModel<DicaVO>  implements Serializable{
    private static final long serialVersionUID = 1L;
  
    @JsonProperty("idDica")
    @Mapping("idDica")
    private Long key;
    private String title;
    private String   body;
    private int   curtidas =0;
    private Postagem post;
    public DicaVO(){
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public Long getKey() {
        return key;
    }
    public void setKey(Long key) {
        this.key = key;
    }
    public int getCurtidas() {
        return curtidas;
    }
    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Postagem getPost() {
        return post;
    }

    public void setPost(Postagem post) {
        this.post = post;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((body == null) ? 0 : body.hashCode());
        result = prime * result + curtidas;
        result = prime * result + ((post == null) ? 0 : post.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        DicaVO other = (DicaVO) obj;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        if (body == null) {
            if (other.body != null)
                return false;
        } else if (!body.equals(other.body))
            return false;
        if (curtidas != other.curtidas)
            return false;
        if (post == null) {
            if (other.post != null)
                return false;
        } else if (!post.equals(other.post))
            return false;
        return true;
    }


    
}

