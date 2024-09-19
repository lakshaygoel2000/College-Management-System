/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package college;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
/**
 *
 * @author laksh
 */
public class viewall extends javax.swing.JFrame {

    /**
     * Creates new form viewall
     */
     
    public viewall() {
        initComponents();
        String data[][];
    }
    
    public viewall(int empid, int age, String empnm, String desig)
    {
      initComponents();
     
      
       try
        {
          Class.forName("com.mysql.cj.jdbc.Driver");            
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emssystem","root","");        
        // Employee-> Database Name
        //root-> Username
        //""-> Password
        // Connection class is use to find the connection with mysql server        
            Statement st=con.createStatement();
            //Statement class Established the connection for insert, update, search record
            System.out.println("Connected");            
          
               int count1=0;
               ResultSet rs=st.executeQuery("Select * From emp"); 
               
               while (rs.next())
               {
                  String data1 [][]={{rs.getString("empid"),rs.getString("age"),rs.getString("empnm"),rs.getString("desig")}};
                     
                  String column[]= {"Employee ID", "Employee Name", "Age", "Designation"};
            
    jTable1.setModel(new javax.swing.table.DefaultTableModel(data1,column));
         count1++;
    
/*jTable1.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
    },
    new String [] {
        "Employee ID", "Employee Name", "Age", "Designation"
    }
));*/

          
               }
        
        con.close();
        }        
        
        catch(Exception ex)
        {
            System.out.println("Server Failed"+ex);
        }
        
    }

      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Employee Name", "Age", "Designation"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("VIEW");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        try
        {
       
          Class.forName("com.mysql.cj.jdbc.Driver");            
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emssystem","root","");        
        // Employee-> Database Name
        //root-> Username
        //""-> Password
        // Connection class is use to find the connection with mysql server        
            Statement st=con.createStatement();
            //Statement class Established the connection for insert, update, search record
            System.out.println("Connected");            
          
               int count1=0;
               ResultSet rs=st.executeQuery("Select * From emp"); 
               DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
               
               while (rs.next())
               {
                   
                  model.addRow(new String[]{rs.getString("empid"),rs.getString("age"),rs.getString("empnm"),rs.getString("desig")});
                  
                  
                  /*  count1++;
                  String data1 [][]={{rs.getString("empid"),rs.getString("age"),rs.getString("empnm"),rs.getString("desig")}};
                        
                  String column[]= {"Employee ID", "Employee Name", "Age", "Designation"};
                  
                 
                  
                 jTable1.setModel(new javax.swing.table.DefaultTableModel(data1,column));
                
                  
                  count1=0;
                  
                        */        
               }
        con.close();
        }        
        
        catch(Exception ex)
        {
            System.out.println("Server Failed"+ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    
      
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewall().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
