package com.example.Pegaso.Controller;

import com.example.Pegaso.Controller.DTO.ImagemDTO;
import com.example.Pegaso.Models.Imagem;
import com.example.Pegaso.Service.ImagensService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/imagens/v1")
public class ImagensController {

    @Autowired
    private ImagensService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Imagem salvar( @RequestBody @Valid ImagemDTO imagem){
        return service.salvar(imagem);
    }




}
