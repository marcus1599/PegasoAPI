package com.example.Pegaso.Data.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "usuario")
@Entity
public class Postagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postagem_seq")
    @SequenceGenerator(name = "postagem_seq", sequenceName = "postagem_seq", allocationSize = 1)
    @Column(name = "id_postagem")
    private Long idPostagem;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = true)
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private Date dataCriacao;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "postagem")
    private List<Dica> dicas = new ArrayList<>();

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    
    public Usuario getUsuario() {
        return (Usuario) usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = (Usuario) usuario;
    }

    @JsonIgnore
    @Column(nullable = true)
    private ArrayList<Imagem> imagems;


    @Column(nullable = true)
    private ArrayList<Video> videos;

    public void addDica(Dica dica) {

        setDicas(dicas);
        this.dicas.add(dica);
    }

 
    public List<Dica> getDicas() {

        return this.dicas;
    }

    public void setDicas(List<Dica> dica) {
        this.dicas = dica;

    }

    public Long getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(Long idPostagem) {
        this.idPostagem = idPostagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Imagem> getImagems() {
        return imagems;
    }

    public void setImagems(ArrayList<Imagem> imagems) {
        this.imagems = imagems;
    }

    public ArrayList<Video> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Video> videos) {
        this.videos = videos;
    }

}
