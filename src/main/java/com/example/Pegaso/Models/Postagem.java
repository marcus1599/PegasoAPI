package com.example.Pegaso.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "usuario")
@Entity
public class Postagem  implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_postagem")
    private Long idPostagem;

    @Column (nullable = false)
    private String   nome;

    @Column (nullable = true)
    private String   descricao;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "postagem")
    private List<Dica> dicas = new ArrayList<>();


    @ManyToOne()
    @JoinColumn(name = "id_usuario")
   
    private Usuario usuario;
    @JsonBackReference

    public Usuario getUsuario() {
        return (Usuario)usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = (Usuario)usuario;
    }
    @Column (nullable = true)
    private ArrayList<Imagem> imagems;

    @Column (nullable = true)
    private ArrayList<Video>videos;


    public void addDica(Dica dica){

        setDicas(dicas);
        this.dicas.add(dica);
    }
    @JsonManagedReference
    public List<Dica> getDicas(){
        // List<DicaVO_OutPut> dicas2 = new ArrayList<>();
        
        // for( Dica dica : this.dicas){
        //     DicaVO_OutPut dicaAux = new DicaVO_OutPut();
        //     dicaAux.setIdDica(dica.getIdDica());
        //     dicaAux.setCurtidas(dica.getCurtidas());
        //     dicaAux.setTitle(dica.getTitle());
        //     dicas2.add(dicaAux);
      
        // }
       
        return this.dicas;
    }
    public void setDicas(List<Dica> dica){
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

