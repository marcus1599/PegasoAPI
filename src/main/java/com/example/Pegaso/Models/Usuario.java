package com.example.Pegaso.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = true)
    private String biografia;

    @Column(nullable = false)
    private String email;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "usuario")
    
    private List<Comentario> comentarios;
    
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }
    
    public void addComentario(Comentario comentario){

        setComentario(comentarios);
        this.comentarios.add(comentario);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @JsonBackReference
    public List<Comentario> getComentario() {
        return this.comentarios;
    }

    public void setComentario(List<Comentario> comentario) {
        this.comentarios = comentario;
    }

}