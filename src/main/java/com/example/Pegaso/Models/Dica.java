package com.example.Pegaso.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dica implements Serializable{
    
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_dica")
    private Long idDica;

    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String body;

    @Column
    private int curtidas;

    @OneToMany()
    @JoinColumn(name = "id_comentario")
    private Comentario comentario;
    
    @ManyToOne()
    @JoinColumn(name = "id_postagem")
    private Postagem postagem ;

    public Long getIdDica() {
        return idDica;
    }

    public void setIdDica(Long idDica) {
        this.idDica = idDica;
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

    public void setBody(String body) {
        this.body = body;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }

    
    @JsonBackReference
    public Postagem getPostagem() {
        return this.postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = (Postagem)postagem;
    }
    
    @JsonBackReference
    public Comentario getComentario() {
        return this.comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = (Comentario)comentario;
    }
}