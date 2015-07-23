package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import org.springframework.web.multipart.MultipartFile;

public class UploadedFile {

	private MultipartFile file;

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public MultipartFile getFile() {
		return file;
	}
}
