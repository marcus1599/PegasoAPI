package com.example.Pegaso.VO.V1;


import java.io.Serializable;
import java.util.ArrayList;

import com.example.Pegaso.Models.Comentario;
import com.example.Pegaso.Models.Dica;
import com.example.Pegaso.Models.Imagem;
import com.example.Pegaso.Models.Video;



public class PostagemVO  implements Serializable{
    private static final long serialVersionUID = 1L;
  
   
    Long idPostagem;
    String   nome;
    String   descricao;
    ArrayList<Dica> dicas;
    ArrayList<Imagem> imagems;
    ArrayList<Video>videos;
    ArrayList<Comentario> comentarios;
    int curtidas =0;
    public PostagemVO(){
        
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
    public ArrayList<Dica> getDicas() {
        return dicas;
    }
    public void setDicas(ArrayList<Dica> dicas) {
        this.dicas = dicas;
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
    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }
    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    public int getCurtidas() {
        return curtidas;
    }
    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idPostagem == null) ? 0 : idPostagem.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((dicas == null) ? 0 : dicas.hashCode());
        result = prime * result + ((imagems == null) ? 0 : imagems.hashCode());
        result = prime * result + ((videos == null) ? 0 : videos.hashCode());
        result = prime * result + ((comentarios == null) ? 0 : comentarios.hashCode());
        result = prime * result + curtidas;
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
        PostagemVO other = (PostagemVO) obj;
        if (idPostagem == null) {
            if (other.idPostagem != null)
                return false;
        } else if (!idPostagem.equals(other.idPostagem))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (dicas == null) {
            if (other.dicas != null)
                return false;
        } else if (!dicas.equals(other.dicas))
            return false;
        if (imagems == null) {
            if (other.imagems != null)
                return false;
        } else if (!imagems.equals(other.imagems))
            return false;
        if (videos == null) {
            if (other.videos != null)
                return false;
        } else if (!videos.equals(other.videos))
            return false;
        if (comentarios == null) {
            if (other.comentarios != null)
                return false;
        } else if (!comentarios.equals(other.comentarios))
            return false;
        if (curtidas != other.curtidas)
            return false;
        return true;
    }

    
}


