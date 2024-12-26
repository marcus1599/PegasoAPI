package com.example.Pegaso.Data.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Usuario")
public class Usuario implements  UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = true)
    private String biografia;

    @Column(length = 255)
    private String avatar;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Comentario> comentarios;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Postagem> postagens;

    @Column(nullable = false)
    @JsonIgnore
    private String senha;

    // Getters e Setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public void addComentario(Comentario comentario) {
        if (comentarios != null) {
            comentarios.add(comentario);
        }
    }

    @JsonIgnore
    public List<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Métodos da interface UserDetails
    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(); // Retornar lista de autoridades, se aplicável
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true; // Lógica para expiração de conta
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true; // Lógica para bloqueio de conta
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true; // Lógica para expiração de credenciais
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true; // Lógica para ativação de conta
    }
}
