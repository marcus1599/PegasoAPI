package com.example.Pegaso.Controller;

import com.example.Pegaso.Controller.DTO.ImagemDTO;
import com.example.Pegaso.Models.Imagem;
import com.example.Pegaso.Service.ImagensService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

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

    @PutMapping("{id}/figure")
    public byte[] addPhoto( @PathVariable Long id,
                            @RequestParam("figure") Part arquivo){
        return service.addPhoto(id, arquivo);
    }




}
