package com.example.Pegaso.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Pegaso.Config.FileStorageConfig;
import com.example.Pegaso.exceptions.FileStorageException;


@Service
public class FileStorageService {

    private final Path fileStorageLocation;
    
    @Autowired
    public FileStorageService(FileStorageConfig fileStorageConfig) {
        Path path= Paths.get(fileStorageConfig.getUploadDir()).toAbsolutePath().normalize();
        
        this.fileStorageLocation= path;
        try{
            Files.createDirectories(this.fileStorageLocation);
        } catch(Exception e) {
            throw new FileStorageException(
                "Could not create the directory where the uploaded files will be stored!", e);}
    
}

}