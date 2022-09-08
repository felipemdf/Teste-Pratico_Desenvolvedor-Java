package com.felipemdf.client.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JTable;

/**
 *
 * @author fmari_v4rpu9g
 */
public class Utils {
    
    public static boolean isEmpty (String string) {
        return (string == null || string.isBlank());
    }

    public static String getTableColumnValue (JTable table, int pos) {
        Object columnValue = table.getValueAt(table.getSelectedRow(), pos);
        return (columnValue == null) ? "": columnValue.toString();
    }
    
     public static Integer toInteger (String string) {
        return (isEmpty(string) ? 0 : Integer.parseInt(string));
    }
    
     public static Date formatDate(Date date) {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Date formatedDate = null;
         try {
             formatedDate = dateFormat.parse(dateFormat.format(date));
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         return formatedDate;
     }
     
     public static String formatDateToString(Date date) {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         String formatedDate = null;
         try {
             formatedDate = dateFormat.format(date);
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         return formatedDate;
     }
     
     public static byte[] bufferImageToByte (BufferedImage imageBuffer, String format) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(imageBuffer, format, baos);
        byte[] bytes = baos.toByteArray();
        baos.close();
        return bytes;
     } 
    
     public static BufferedImage byteToBufferImage(byte[] bytes) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(bytes);
        BufferedImage bufferImage = ImageIO.read(inputStream);
        return bufferImage;
     }
}
