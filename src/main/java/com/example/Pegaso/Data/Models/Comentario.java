package com.example.Pegaso.Data.Models;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_comentario")
    private Long idComentario;

    @Column(nullable = false)
    private String corpo;

    @Column
    private int curtidas;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "id_Dica")
    private Dica dica;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Long getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Long idComentario) {
        this.idComentario = idComentario;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }

    public Dica getDica() {
        return (Dica) this.dica;
    }

    public void setDica(Dica dica) {
        this.dica = (Dica) dica;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = (Usuario) usuario;
    }
}