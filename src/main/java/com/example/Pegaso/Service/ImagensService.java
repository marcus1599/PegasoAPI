package com.example.Pegaso.Service;

import com.example.Pegaso.Controller.DTO.ImagemDTO;
import com.example.Pegaso.Models.Imagem;
import com.example.Pegaso.Models.Postagem;
import com.example.Pegaso.Repository.ImagensRepositiry;
import com.example.Pegaso.Repository.PostagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImagensService {

    @Autowired
    private final ImagensRepositiry repositiry;
    private final PostagemRepository postRepository;


    public Imagem salvar( ImagemDTO dto){
        Imagem imagem = new Imagem();

        Long idPostagem = dto.getIdPostagem();

        postRepository.findById(idPostagem);

        Postagem postagem =
                postRepository
                        .findById(idPostagem)
                        .orElseThrow( () ->
                                new ResponseStatusException(
                                        HttpStatus.BAD_REQUEST, "Postagem inexistente."));

        imagem.setTitulo(dto.getTitulo());
        imagem.setDescricao(dto.getDescricao());
        imagem.setEndereco(dto.getEndereco());
        imagem.setCurtidas(dto.getCurtidas());
        imagem.setPostagem(postagem);

        return repositiry.save(imagem);
    }


    public List<Imagem> findTudo(){
        return repositiry.findAll();
    }




    private Postagem postExiste(Long idPost){

        Postagem postagem =
                postRepository
                        .findById(idPost)
                        .orElseThrow( () ->
                                new ResponseStatusException(
                                        HttpStatus.BAD_REQUEST, "Postagem inexistente."));

        return postagem;
    }



}
