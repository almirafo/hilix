package br;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name="file")
@SessionScoped
public class FileBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileBean() {
	}

	@SuppressWarnings("unused")
	public void handleFileUpload(FileUploadEvent event) {
		UploadedFile file = event.getFile();
		// application code
	}

	@SuppressWarnings("unused")
	public String Upload(FileUploadEvent event) {
		UploadedFile file = event.getFile();
		// application code
		return "sucesso";
	}
	
	public String getUpload(){
		
	    return null;
	}
}