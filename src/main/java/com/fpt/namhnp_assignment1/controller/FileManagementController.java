package com.fpt.namhnp_assignment1.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fpt.namhnp_assignment1.CustomMessageError;
import com.fpt.namhnp_assignment1.dto.FileDownloadRequestDTO;
import com.fpt.namhnp_assignment1.dto.FileUploadResponseDTO;
import com.fpt.namhnp_assignment1.service.FileManagementService;

@RestController
@RequestMapping(value="/api/v1/file")
public class FileManagementController {
	
	@Autowired
	FileManagementService fileManagementService;
	
	@PostMapping(value="/upload")
	ResponseEntity<FileUploadResponseDTO> uploadFile(@RequestBody MultipartFile file, Authentication authentication) throws IOException, CustomMessageError {
		return ResponseEntity.ok().body(fileManagementService.upload(file, authentication));
	}
	
	@GetMapping(value="/download")
	ResponseEntity<Resource> downloadFile(@RequestBody FileDownloadRequestDTO fileDownloadRequestDTO, Authentication authentication, HttpServletRequest request) throws CustomMessageError, IOException {
		Resource resource = fileManagementService.download(fileDownloadRequestDTO, authentication);
		String contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

        if (contentType == null) {
            contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
	}
	
}
