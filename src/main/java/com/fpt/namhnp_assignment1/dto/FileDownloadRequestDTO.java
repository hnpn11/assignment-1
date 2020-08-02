package com.fpt.namhnp_assignment1.dto;

public class FileDownloadRequestDTO {

	private String fileName;

	public FileDownloadRequestDTO() {
		super();
	}

	public FileDownloadRequestDTO(String fileName) {
		super();
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
