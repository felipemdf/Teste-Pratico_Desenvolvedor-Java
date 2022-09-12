package com.felipemdf.server.dto;

public class ResponseDto {
	private boolean isError;
    private String message;
    
    public ResponseDto(boolean isError, String message) {
        this.isError = isError;
        this.message = message;
    }

    public boolean isIsError() {
        return isError;
    }

    public String getMessage() {
        return message;
    }
    

}
