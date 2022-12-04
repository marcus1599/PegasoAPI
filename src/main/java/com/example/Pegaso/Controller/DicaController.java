package com.example.Pegaso.Controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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

import com.example.Pegaso.Mapper.DozerMapper;
import com.example.Pegaso.Models.Dica;
import com.example.Pegaso.Models.Postagem;
import com.example.Pegaso.Repository.PostagemRepository;
import com.example.Pegaso.Service.DicaService;

import com.example.Pegaso.VO.V1.DicaVO;
import com.example.Pegaso.VO.V1.PostagemVO;
import com.example.Pegaso.exceptions.ResourceNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Dicas")
@Tag(name = "Dicas", description = "Endpoints for Managing Dicas")
public class DicaController {
    
    @Autowired
    private DicaService service;
    @Autowired
    private PostagemRepository postRepository;

 //--------------------Adicionar Dica----------------------------------//

    @PostMapping(value = "/{idPostagem}/Adicionar",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
                consumes ={ MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Adds a new Dica", description = "Adds a new Dica by passing in a JSON or XML representation of the post",tags= {"Post"},responses ={
                    @ApiResponse(description = "Success", responseCode= "200",
                    content= {
                            @Content(schema = @Schema(implementation = DicaVO.class))
                         }),
                    @ApiResponse(description = "BadRequest",    responseCode= "400", content =  @Content),
                    @ApiResponse(description = "Unauthorized",  responseCode= "401", content =  @Content),
                    @ApiResponse(description = "InternalError", responseCode= "500", content =  @Content),
                }
            )
   public  ResponseEntity<Object>saveDica(@RequestBody @Valid DicaVO dica,@PathVariable(value = "idPostagem") Long idPostagem)
    {
        // Optional<Postagem> entityPostOptional = postRepository.findById(idPostagem);
        // if(!entityPostOptional.isPresent())
        // {
        //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post Not Found");
        // }
    
  //       var postagem = postRepository.findById(idPostagem);

        // BeanUtils.copyProperties(entityPostOptional, postagem);
        var dicaEntity = DozerMapper.parseObject(dica, Dica.class);
        var entityPost =  postRepository.findById(idPostagem).orElseThrow(
                () -> new ResourceNotFoundException("Searched post with specified id not found")
            );
            
            entityPost.addDica(dicaEntity);
            dica.setPostagem(entityPost);
         
            
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveDica(dica));
    }
//-----------------------------------Buscar Todas Dicas--------------------------//
    @GetMapping( produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Finds all Dicas", description = "Finds all Dicas",tags= {"Dica"},responses ={
        @ApiResponse(description = "Success", responseCode= "200",
        content= {
            @Content(mediaType= "application/json",
             array = @ArraySchema(schema = @Schema(implementation = DicaVO.class))
             )
             }),
        @ApiResponse(description = "BadRequest",    responseCode= "400", content =  @Content),
        @ApiResponse(description = "Unauthorized",  responseCode= "401", content =  @Content),
        @ApiResponse(description = "Not Found",     responseCode= "404", content =  @Content),
        @ApiResponse(description = "InternalError", responseCode= "500", content =  @Content),
    })
    public ResponseEntity<List<DicaVO>>getDicas(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllDicas());
    }
//---------------------------------Buscar todas de uma Postagem--------------------------------//

@GetMapping(value = "/{idPostagem}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
@Operation(summary = "Finds all Dicas", description = "Finds all Dicas",tags= {"Dica"},responses ={
    @ApiResponse(description = "Success", responseCode= "200",
    content= {
        @Content(mediaType= "application/json",
         array = @ArraySchema(schema = @Schema(implementation = DicaVO.class))
         )
         }),
    @ApiResponse(description = "BadRequest",    responseCode= "400", content =  @Content),
    @ApiResponse(description = "Unauthorized",  responseCode= "401", content =  @Content),
    @ApiResponse(description = "Not Found",     responseCode= "404", content =  @Content),
    @ApiResponse(description = "InternalError", responseCode= "500", content =  @Content),
})
public ResponseEntity<List<DicaVO>> getDicasByPostagem(@PathVariable(value = "idPostagem")Long idPostagem){
    Optional<Postagem> entityPostOptional = postRepository.findById(idPostagem);
    if(!entityPostOptional.isPresent())
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    var postagem = new Postagem();
    BeanUtils.copyProperties(postagem, entityPostOptional);
    return ResponseEntity.status(HttpStatus.OK).body(service.findAllDicasByPostagem(postagem));
}
   
    @GetMapping(value = "/Dica/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Find a Dica", description = "Find a Dica",tags= {"Dica"},responses ={
        @ApiResponse(description = "Success", responseCode= "200",
        content= {
            @Content(schema = @Schema(implementation = DicaVO.class))
             
             }),
        @ApiResponse(description = "BadRequest",    responseCode= "400", content =  @Content),
        @ApiResponse(description = "Unauthorized",  responseCode= "401", content =  @Content),
        @ApiResponse(description = "Not Found",     responseCode= "404", content =  @Content),
        @ApiResponse(description = "InternalError", responseCode= "500", content =  @Content),
    })

    public ResponseEntity<Object> getOneDica(@PathVariable(value = "id") Long id){
       

        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    @GetMapping(value = "/vo/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Find a Dica", description = "Find a Dica",tags= {"Dica"},responses ={
        @ApiResponse(description = "Success", responseCode= "200",
        content= {
            @Content(schema = @Schema(implementation = DicaVO.class))
             
             }),
        @ApiResponse(description = "BadRequest",    responseCode= "400", content =  @Content),
        @ApiResponse(description = "Unauthorized",  responseCode= "401", content =  @Content),
        @ApiResponse(description = "Not Found",     responseCode= "404", content =  @Content),
        @ApiResponse(description = "InternalError", responseCode= "500", content =  @Content),
    })
    public ResponseEntity<Object> getOneDicaCostom(@PathVariable(value = "id") Long id){
       

        return ResponseEntity.status(HttpStatus.OK).body(service.findByIdDicaCostomized(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes a Dica", description = "Deletes a Dica by passing id",
               tags= {"Dica"},
               responses ={
        @ApiResponse(description = "No Content",    responseCode= "204", content =  @Content),
        @ApiResponse(description = "BadRequest",    responseCode= "400", content =  @Content),
        @ApiResponse(description = "Unauthorized",  responseCode= "401", content =  @Content),
        @ApiResponse(description = "Not Found",     responseCode= "404", content =  @Content),
        @ApiResponse(description = "InternalError", responseCode= "500", content =  @Content),
    })
    public ResponseEntity<Object> deleteDica(@PathVariable(value = "id") Long id){

        service.deleteDica(id);
        return ResponseEntity.status(HttpStatus.OK).body("Dica deleted Sucefully");
    }

    @PutMapping(value = "/Update/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
                consumes ={ MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Updates a Post",
             description = "Updates a Post by passing in a JSON or XML representation of the post!",
             tags= {"Post"},responses ={
                    @ApiResponse(description = "Success", responseCode= "200",
                    content= {
                        @Content(schema = @Schema(implementation = DicaVO.class))
                         
                         }),
                    @ApiResponse(description = "BadRequest",    responseCode= "400", content =  @Content),
                    @ApiResponse(description = "Unauthorized",  responseCode= "401", content =  @Content),
                    @ApiResponse(description = "Not Found",     responseCode= "404", content =  @Content),
                    @ApiResponse(description = "InternalError", responseCode= "500", content =  @Content),
                })
    public ResponseEntity<Object> updateDica(@PathVariable(value = "id") Long id,
     @RequestBody @Valid DicaVO dica)
     {
        

        return ResponseEntity.status(HttpStatus.OK).body(service.update(dica,id));
    }

    
}
