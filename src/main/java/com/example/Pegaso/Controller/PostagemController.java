package com.example.Pegaso.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pegaso.Models.Postagem;
import com.example.Pegaso.Service.PostagemService;

import java.util.List;

@RestController("/Postagem")
public class PostagemController {
    
    @Autowired
    private PostagemService service;

    @PostMapping("/Adicionar")
    ResponseEntity<Object>savePostagem(@RequestBody @Valid Postagem postagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.savePostagem(postagem));
    }

    @GetMapping()
    ResponseEntity<List<Postagem>>getPosts(@RequestBody @Valid Postagem postagem){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllPost());
    }

    
}
