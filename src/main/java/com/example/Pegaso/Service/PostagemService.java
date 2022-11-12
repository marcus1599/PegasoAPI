package com.example.Pegaso.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Pegaso.Models.Postagem;
import com.example.Pegaso.Repository.PostagemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostagemService {
    
    @Autowired
    private PostagemRepository repository;

    public Object savePostagem(Postagem postagem){
            return repository.save(postagem);
    }
    public List<Postagem> findAllPost(){
        return repository.findAll();
    }
    public Optional<Postagem> findPostById(Long id){
        return repository.findById(id);
    }
    
    public void deletePost(Long id){
        repository.deleteById(id);
    }

}
