package com.example.Pegaso.Controller;


import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.Pegaso.Service.FileStorageService;
import com.example.Pegaso.VO.V1.UploadFileResponseVO;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "File Endpoint")
@RestController
@RequestMapping("/api/file/v1")
public class FileController {

    private Logger logger= Logger.getLogger(FileController.class.getName());

    @Autowired
    private FileStorageService service;

    @PostMapping("/uploadFile")
    public UploadFileResponseVO uploadFile(@RequestParam("file") MultipartFile file) {
        logger.info("Storingfile todisk");

        var filename= service.storeFile(file);

        String fileDownloadUri= ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/file/v1/downloadFile/")
        .path(filename)
        .toUriString();

        return new UploadFileResponseVO(filename, fileDownloadUri, file.getContentType(), file.getSize());
    }
    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponseVO> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        logger.info("Storingfiles todisk");
        return Arrays.asList(files)
        .stream()
        .map(file-> uploadFile(file))
        .collect(Collectors.toList());
    }
    


}
