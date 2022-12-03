package com.example.Pegaso.Models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * - IdDica : Int
- titulo : String
- descricao : String
- curtidas: int
 */



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

    @ManyToOne(fetch = FetchType.LAZY)
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

    @JsonManagedReference
    @JsonBackReference
    public Postagem getPostagem() {
        return (Postagem)this.postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = (Postagem)postagem;
    }
}
