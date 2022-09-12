/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipemdf.client.views.components;

import com.felipemdf.client.dtos.ResponseDto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 *
 * @author fmari_v4rpu9g
 */
public class Dialogs {
   
    public static void dialogMessage(boolean isError, String message) {
        dialogMessage(new ResponseDto(isError, message));
    }
    public static void dialogMessage(ResponseDto response) {
        String title = "Message Error";
        int image = JOptionPane.ERROR_MESSAGE;
        Color color = Color.red;
        int width = 500;
        int heigth =64;
        
        if(!response.isIsError()){
            title = "Success Error";
            image = JOptionPane.INFORMATION_MESSAGE;
            color = Color.BLACK;
            width = 200;
            heigth = 64;
        }        
        
        
        JPanel panel = new JPanel();
       
        panel.setPreferredSize(new Dimension(width, heigth));
        panel.setLayout(null);

        JLabel label = new JLabel("<HTML>" + response.getMessage() + "</HTML>");
        label.setBounds(0, 0, width, heigth);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel.add(label);

        UIManager.put("OptionPane.minimumSize",new Dimension(width, heigth));  
        JOptionPane.showMessageDialog(null, panel, title, image);
    }
    

}
