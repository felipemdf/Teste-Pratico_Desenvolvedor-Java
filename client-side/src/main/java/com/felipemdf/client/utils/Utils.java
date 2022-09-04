package com.felipemdf.client.utils;

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
}