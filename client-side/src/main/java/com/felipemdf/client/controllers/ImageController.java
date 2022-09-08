/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipemdf.client.controllers;

import com.felipemdf.client.dtos.ImageDto;
import com.felipemdf.client.utils.Utils;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ImageController {
  private int carId;
  public int idTest = 1;
  public ArrayList<ImageDto> carImages;

    public ImageController(int carId) {
        this.carId = carId;
        this.carImages = new ArrayList<>();
    }
  
  
  
  public ArrayList<ImageDto> getAll() {
     return carImages;
  }
  
   public ImageDto get(int id) {
     return  carImages.stream().filter(c -> c.getId() == id).findFirst().get();
  }
   
  public void add(BufferedImage bufferImage, String fileName) {
      try {
        int extensionIndex = fileName.lastIndexOf(".");
        byte[] imageBytes = Utils.bufferImageToByte(bufferImage, fileName.substring(extensionIndex + 1));    
        
      
        carImages.add(new ImageDto(idTest, imageBytes, fileName));
        idTest++;
      } catch (Exception e) {
          System.err.println(e);
      }  
  }

  
  public boolean remove (int id) {
      ImageDto image = carImages.stream().filter(c -> c.getId() == id).findFirst().get();
      carImages.remove(image);
      return true;
  }
  
  
  
}
