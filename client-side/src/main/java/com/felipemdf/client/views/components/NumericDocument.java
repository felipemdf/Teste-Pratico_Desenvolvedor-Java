package com.felipemdf.client.views.components;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class NumericDocument extends PlainDocument {

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null)
            return;
        String oldString = getText(0, getLength());
        String newString = oldString.substring(0, offs) + str + oldString.substring(offs).replace(",", ".");
        
        try {
            Double.parseDouble(newString);
            super.insertString(offs, str, a);
        } catch (NumberFormatException e) {
        }
    }
    
    
    
}