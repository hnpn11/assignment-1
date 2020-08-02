package com.fpt.namhnp_assignment1.service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import com.fpt.namhnp_assignment1.CustomMessageError;
import com.fpt.namhnp_assignment1.dto.FileDownloadRequestDTO;
import com.fpt.namhnp_assignment1.dto.FileUploadResponseDTO;

public interface FileManagementService {
	
	public FileUploadResponseDTO upload(MultipartFile file, Authentication authentication) throws IOException, CustomMessageError;
	
	public Resource download(FileDownloadRequestDTO fileDownloadRequestDTO, Authentication authentication) throws CustomMessageError, MalformedURLException;
}
