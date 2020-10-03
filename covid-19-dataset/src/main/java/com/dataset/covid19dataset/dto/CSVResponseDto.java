package com.dataset.covid19dataset.dto;

import org.springframework.core.io.Resource;

public class CSVResponseDto {

	private String fileName;
	private String fileType;
	private Resource content;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Resource getContent() {
		return content;
	}
	public void setContent(Resource content) {
		this.content = content;
	}
	

}
