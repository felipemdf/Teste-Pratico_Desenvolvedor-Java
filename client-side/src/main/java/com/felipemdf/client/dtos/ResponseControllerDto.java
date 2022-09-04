/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipemdf.client.dtos;

/**
 *
 * @author fmari_v4rpu9g
 */
public class ResponseControllerDto {
     private boolean isError;
     private String messageError;

    public ResponseControllerDto(boolean isError, String messageError) {
        this.isError = isError;
        this.messageError = messageError;
    }

    public boolean isIsError() {
        return isError;
    }

    public String getMessageError() {
        return messageError;
    }
     
     
}
