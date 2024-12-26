package com.example.Pegaso.Data.Models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dica implements Serializable {

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

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dica")
    private List<Comentario> comentarios;


    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "id_postagem")
    private Postagem postagem;

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

    public Postagem getPostagem() {
        return this.postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = (Postagem) postagem;
    }

    public void addComentario(Comentario comentario) {

        setComentario(comentarios);
        this.comentarios.add(comentario);
    }

   @JsonIgnore
    public List<Comentario> getComentario() {
        return this.comentarios;
    }

    public void setComentario(List<Comentario> comentarios) {
        this.comentarios = comentarios;

    }
}