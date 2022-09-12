package com.felipemdf.client.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.felipemdf.client.dtos.BrandDto;
import com.felipemdf.client.dtos.ResponseDto;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JTable;
import javax.swing.text.MaskFormatter;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

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
        return (columnValue == null) ? null : columnValue.toString();
    }
    
    public static Integer toInteger (String string) {
        return (isEmpty(string) ? null : Integer.valueOf(string));
    }
    
    public static String longToString (Long value) {
        return (value == null) ? null : value.toString();
    }
     
     public static Long toLong (String string) {
        return (isEmpty(string) ? null : Long.valueOf(string));
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
     
     public static String bufferImageToBase64 (BufferedImage imageBuffer, String format) throws IOException {
       byte[] byteArray = bufferImageToByte(imageBuffer, format);
       return Base64.getEncoder().encodeToString(byteArray);
     } 
    
     public static BufferedImage byteToBufferImage(byte[] bytes) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(bytes);
        BufferedImage bufferImage = ImageIO.read(inputStream);
        return bufferImage;
     }
     public static byte[] base64ToByteArray(String base64) throws IOException {
       return Base64.getDecoder().decode(base64);
     }
     
     public static MaskFormatter getMonetaryMask () {
        try {
            
            return new MaskFormatter("#.###,##");
        } catch (ParseException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
     }
     
     public static ResponseDto getResponseDto (CloseableHttpResponse response) throws IOException {
        if(response.getStatusLine().getStatusCode() != 201 && response.getStatusLine().getStatusCode() != 200)
            return new ResponseDto(true, EntityUtils.toString(response.getEntity()));
        
        return new ResponseDto(false,  EntityUtils.toString(response.getEntity()));

     }

     
}
