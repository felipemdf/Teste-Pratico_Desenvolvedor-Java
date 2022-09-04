/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipemdf.client.utils;

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
    
    public static void DialogError(String message) {
       
        JPanel panel = new JPanel();
        panel.setSize(new Dimension(200, 64));
        panel.setLayout(null);
        
        JLabel label = new JLabel(message, JLabel.CENTER);
        label.setBounds(0, 0, 200, 64);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setForeground(Color.red);
        //label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);
        
        UIManager.put("OptionPane.minimumSize",new Dimension(300, 120)); 
        JOptionPane.showMessageDialog(null, panel, "Error Message", JOptionPane.ERROR_MESSAGE);
    }
}
