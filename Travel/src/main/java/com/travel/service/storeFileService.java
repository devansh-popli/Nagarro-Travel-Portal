package com.travel.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.travel.model.Image;
import com.travel.repository.DatabaseFileRepository;

@Service
public class storeFileService {
	

	    @Autowired
	    private DatabaseFileRepository dbFileRepository;

	    public Image storeFile(MultipartFile file) throws Exception {
	        // Normalize file name
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        try {
	            // Check if the file's name contains invalid characters
	            if (fileName.contains("..")) {
	                throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
	            }

	            Image dbFile = new Image(fileName, file.getContentType(), file.getBytes());

	            return dbFileRepository.save(dbFile);
	        } catch (IOException ex) {
	            throw new FileSystemNotFoundException("Could not store file " + fileName + ". Please try again!");
	        }
	    }

	    public Optional<Image> getFile(String fileId) {
	        return dbFileRepository.findById(fileId);//.orElseThrow(() - > new FileNotFoundException("File not found with id " + fileId));
	    }
	}

