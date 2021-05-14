package com.travel.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sun.mail.iap.Response;
import com.travel.model.Image;
import com.travel.service.storeFileService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FileUploadController {
	@Autowired
	   public  storeFileService fileStorageService;

	    @PostMapping("/uploadFile")
	    public Response uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
	    	System.out.print("filename"+file.getOriginalFilename());
	      Image fileName = fileStorageService.storeFile(file);

	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	            .path("/downloadFile/")
	            .path(fileName.getFileName())
	            .toUriString();

	        return new Response(fileName.getFileName()+fileDownloadUri+
	            file.getContentType()+ file.getSize());
	    }

	    @PostMapping(path="/uploadMultipleFiles",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	    public List<Response> uploadMultipleFiles(@RequestParam("file") MultipartFile[] files) {
	        return Arrays.asList(files)
	            .stream()
	            .map(file -> {
					try {
						return uploadFile(file);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				})
	            .collect(Collectors.toList());
	    }
}
