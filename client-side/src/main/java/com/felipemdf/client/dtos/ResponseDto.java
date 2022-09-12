/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipemdf.client.dtos;

/**
 *
 * @author fmari_v4rpu9g
 */
public class ResponseDto {
    private boolean isError;
    private String message;

    public ResponseDto() {
    }

    
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
