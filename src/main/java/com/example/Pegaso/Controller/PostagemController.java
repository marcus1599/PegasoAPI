package com.example.Pegaso.Controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pegaso.Service.PostagemService;
import com.example.Pegaso.VO.V1.PostagemVO;


import java.util.List;


@RestController
@RequestMapping("Postagem/v1")
public class PostagemController {
    
    @Autowired
    private PostagemService service;

    @PostMapping(value = "/Adicionar",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
                consumes ={ MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
   public  ResponseEntity<Object>savePostagem(@RequestBody @Valid PostagemVO postagem)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.savePostagem(postagem));
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<PostagemVO>>getPosts(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllPost());
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> getOnePost(@PathVariable(value = "id") Long id){
       

        return ResponseEntity.status(HttpStatus.OK).body(service.findPostById(id));
    }
    @GetMapping(value = "/vo/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> getOnePostCostom(@PathVariable(value = "id") Long id){
       

        return ResponseEntity.status(HttpStatus.OK).body(service.findByIdPostagemCostomized(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable(value = "id") Long id){

        service.deletePost(id);
        return ResponseEntity.status(HttpStatus.OK).body("Post deleted Sucefully");
    }

    @PutMapping(value = "/Update/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
                consumes ={ MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> updatePost(@PathVariable(value = "id") Long id,
     @RequestBody @Valid PostagemVO post)
     {
        

        return ResponseEntity.status(HttpStatus.OK).body(service.update(post,id));
    }

    
}
