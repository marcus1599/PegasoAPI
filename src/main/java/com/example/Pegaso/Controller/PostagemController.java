package com.example.Pegaso.Controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pegaso.Models.Postagem;
import com.example.Pegaso.Service.PostagemService;

import java.security.Provider.Service;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("Postagem")
public class PostagemController {
    
    @Autowired
    private PostagemService service;

    @PostMapping("/Adicionar")
   public  ResponseEntity<Object>savePostagem(@RequestBody @Valid Postagem postagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.savePostagem(postagem));
    }

    @GetMapping
    public ResponseEntity<List<Postagem>>getPosts(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllPost());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePost(@PathVariable(value = "id") Long id){
       

        return ResponseEntity.status(HttpStatus.OK).body(service.findPostById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable(value = "id") Long id){

        service.deletePost(id);
        return ResponseEntity.status(HttpStatus.OK).body("Post deleted Sucefully");
    }
    @PutMapping("/Update/{id}")
    public ResponseEntity<Object> updatePost(@PathVariable(value = "id") Long id,
     @RequestBody @Valid Postagem post)
     {
        Optional<Postagem> postModelOptional = service.findPostById(id);
        if(!postModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post Not Found");
        }

        var postModel = new Postagem();
        BeanUtils.copyProperties(post, postModel);
        postModel.setIdPostagem(postModelOptional.get().getIdPostagem());
        
       

        return ResponseEntity.status(HttpStatus.OK).body(service.savePostagem(postModel));
    }

    
}
