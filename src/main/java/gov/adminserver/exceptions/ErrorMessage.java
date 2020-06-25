package gov.adminserver.exceptions;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorMessage {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timestamp;
    private String message;
    private Integer codError;
    private String path;
    
    public ErrorMessage(Date timestamp, String message, Integer codError, String path) {
    	super();
		this.timestamp = timestamp;
		this.message = message;
		this.codError = codError;
		this.path = path;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public Integer getcodError() {
		return codError;
	}

	public String getPath() {
		return path;
	} 
    
    

}