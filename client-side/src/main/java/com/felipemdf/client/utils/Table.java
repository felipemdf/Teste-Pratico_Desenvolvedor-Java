
package com.felipemdf.client.utils;

import com.felipemdf.client.controllers.CategoryController;
import com.sun.source.tree.SwitchTree;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Table {
        
        public JTable createTable(JPanel jPanel, Object[] width, Class<?> dtoClass) throws NullPointerException {
           
            JTable table = new JTable(new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
                
            });
            
            table.setVisible(true);
            JScrollPane jScrollPane = new JScrollPane(table);
            jScrollPane.setBounds(5, 30, 1080, 225); //1090
            jScrollPane.setVisible(true);
            jPanel.add(jScrollPane);
            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            
            Arrays.asList(dtoClass.getDeclaredFields()).forEach(att -> {
                model.addColumn(att.getName());
            });
                
            DefaultTableCellRenderer center = new DefaultTableCellRenderer();
            DefaultTableCellRenderer rigth = new DefaultTableCellRenderer();
            DefaultTableCellRenderer left = new DefaultTableCellRenderer();
            center.setHorizontalAlignment(SwingConstants.CENTER);
            rigth.setHorizontalAlignment(SwingConstants.RIGHT);
            left.setHorizontalAlignment(SwingConstants.LEFT);
            
            for (int i = 0; i < width.length; i++) {
           
                table.getColumnModel().getColumn(i).setMaxWidth(Integer.parseInt(width[i].toString()));
            }
            
            return table;
        }
    
        public void insertData(DefaultTableModel tableModel, ArrayList<Object[]> data) {
            tableModel.setNumRows(0);
            data.forEach(row -> {
                tableModel.addRow(row);
            });

        }
}
