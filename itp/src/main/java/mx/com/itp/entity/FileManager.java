package mx.com.itp.entity;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {

	MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
