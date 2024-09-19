/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package college;
import java.awt.Color;
import java.util.*;
import java.sql.*;

class Employee
{
    int eid;
    int empid;
    String empnm;
    int age;
    String desig;
    
    
    
    public void reg(String enm, int eage, String edesg)
            
    {
        //empid=eid;
        empnm=enm;
        age=eage;
        desig=edesg;
        int count=0;
        int t=0;
        
      for(eid=1000; eid<1020; eid++)
        {
            
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
            
            
                 ResultSet r0=st.executeQuery("Select * from emps");
                 while (r0.next())
                     {
                          count++;
                          int emid=r0.getInt("empid");
                          
                         if (emid!=eid)
                          {
                          
                          
                          try
                          {
                          Class.forName("com.mysql.cj.jdbc.Driver");            
                          Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/emssystem","root","");
                          Statement st1=con.createStatement();
                          System.out.println("Connected"); 
                          
                          int r=st.executeUpdate("insert into emps(empid, empnm, age, desig) values("+eid+",'"+empnm+"',"+age+",'"+desig+"' )");            
                          
                           t=1;
                          }
                          catch(Exception ex)
                          {
                           System.out.println("Server Failed"+ex);
                          }
                          
                          }
                         else
                         {
                             continue;
                             
                         }
                          if(t==1)
                          {
                              break;
                          }
                         
                       
            
                     }
        
            
           /* if(r>0)
            {
                System.out.println("Record Inserted Successfully");
            }
            else
            {
                    System.out.println("Record not Inserted");
            }  */  
            
        
        con.close();
        }        
        
        catch(Exception ex)
        {
            System.out.println("Server Failed"+ex);
        }
         
        if(t==1)
        {
            break;
        }
    
        }
    }
            
    public void view()
    {
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
           
            Scanner sc1=new Scanner(System.in);
            System.out.println("1-View All Record \n2-View Individual Record");
        System.out.println("Enter your Choice");
        int sh=sc1.nextInt();
           
        
        switch (sh)
            {        
            case 1:
            
               int count=0;
               ResultSet rs1=st.executeQuery("Select * From emps"); 
               while (rs1.next())
               
               {
                   count++;
                   String emid=rs1.getString("empid");
                   String enm=rs1.getString("empnm");
                   int eage=Integer.parseInt(rs1.getString("age"));
                   String edesg=rs1.getString("desig");
                   System.out.println(count+". Employee Record");
                   System.out.println("Empid="+emid);
                   System.out.println("Name="+enm);
                   System.out.println("age="+eage);
                   System.out.println("Designation="+edesg);
               }
            
            
             break;
           
           case 2:
                Scanner sc2=new Scanner(System.in);
                System.out.println("Enter Employee id");
                int empid2=sc2.nextInt();
                int count1=0;
               ResultSet rs=st.executeQuery("Select * From emps where empid="+empid2+""); 
               while (rs.next())
               {
                   count1++;
                   String emid=rs.getString("empid");
                   String enm=rs.getString("empnm");
                   int eage=Integer.parseInt(rs.getString("age"));
                   String edesg=rs.getString("desig");
                   System.out.println(count1+". Employee Record");
                   System.out.println("Empid="+emid);
                   System.out.println("Name="+enm);
                   System.out.println("age="+eage);
                   System.out.println("Designation="+edesg);
               }
               
            break;    
            
            default:
                
            System.out.println("Enter Valid Choice");
              
            
            
            }           
           
               
        con.close();
        }   
        catch(Exception ex)
        {
            System.out.println("Server Failed"+ex);
        }
    }
    
    
    
    public void update(int eid, String enm, int eage, String edesg)
    {
        
           int r1;
           
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
            r1=st.executeUpdate("Update emps set empnm='"+enm+"', age="+eage+", desig='"+edesg+"' where empid="+eid+"");
            
            if(r1>0)
            {
                System.out.println("Record Updated Successfully");
            }
            else
            {
                    System.out.println("Record not Updated");
            }        
        con.close();
        }        
        
        catch(Exception ex)
        {
            System.out.println("Server Failed"+ex);
        }
    }                 
         
    
       
        
  /* public void Update()
    {
        int eid;
        String new_nm;
        int age;
        String str3;  
        String desg;
        int r1;                                 // defining global variable for method, instead of defining seperately in each case
        
        
        
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
           
            Scanner sc1=new Scanner(System.in);                        
            
           System.out.println("Update Record Panel");
            System.out.println("1-Name \n2-age \n3-Designation");
        System.out.println("Enter your Choice");
        int dh=sc1.nextInt();
        
        
        
        switch(dh)
        {
            case 1:
                sc1=new Scanner(System.in);
                System.out.println("Enter New Name: ");
                new_nm=sc1.nextLine();
                
                System.out.println("Enter Employee ID: ");
                eid=sc1.nextInt();
                
                str3="Update emps set empnm='"+new_nm+"' where empid="+eid+"";
                
                r1=st.executeUpdate(str3);
                
                if(r1>0)
                {
                    System.out.println("Record Updated");
                }
                
               else
                {
                    System.out.println("Record Not Updated");
                                                
                }
                       
            break;
                
            case 2:
                sc1=new Scanner(System.in);
                System.out.println("Enter New age: ");
                age=sc1.nextInt();
                
                System.out.println("Enter Employee ID: ");
                eid=sc1.nextInt();
                
                str3="Update emp set age="+age+" where empid="+eid+"";
                
                r1=st.executeUpdate(str3);
                
                if(r1>0)
                {
                    System.out.println("Record Updated");
                }
                
               else
                {
                    System.out.println("Record Not Updated");
                                                
                }
                
                
            break;
                
            case 3:
                
                sc1=new Scanner(System.in);
                System.out.println("Enter New Designation: ");
                desg=sc1.nextLine();
                
                System.out.println("Enter Employee ID: ");
                eid=sc1.nextInt();
                                    
                r1=st.executeUpdate("Update emps set desig="+desg+" where empid="+eid+"");
                
                if(r1>0)
                {
                    System.out.println("Record Updated");
                }
                
               else
                {
                    System.out.println("Record Not Updated");
                                                
                }
                
                break;    
              
            default:
                System.out.println("Enter Valid Choice");
                        
                    
                        
        }     
        
        con.close();
        }   
        catch(Exception ex)
        {
            System.out.println("Server Failed"+ex);
        }
    }
           
    */
    public void delete()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emssystem","root","");
            Statement st=con.createStatement();
            System.out.println("Connected");
            
            Scanner sc2=new Scanner(System.in);
            System.out.println("Delete Record Panel");
           
                System.out.println("Enter Employee ID to Delete Record: ");
                int eid=sc2.nextInt();
                                             
               int r1=st.executeUpdate("Delete From emps where empid="+eid+"");
                
                if(r1>0)
                {
                    System.out.println("Record Deleted");
                }                
               else
                {
                    System.out.println("Record Not Deleted");                                               
                }        
                         
        }
    
        catch(Exception ex)
                {
                    System.out.println("Server Failed"+ex);
                }
    
    }
    

}
public class emssystem extends javax.swing.JFrame {

    /**
     * Creates new form emssystem
     */
    
    
    int eid1;
    public emssystem() {
        initComponents();
        txteid.hide();
        bview.hide();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BSVE = new javax.swing.JButton();
        txteid = new javax.swing.JTextField();
        txtenm = new javax.swing.JTextField();
        txtage = new javax.swing.JTextField();
        txtdesg = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lbsuccess = new javax.swing.JLabel();
        bview = new javax.swing.JButton();
        lblinvalid = new javax.swing.JLabel();
        lblenter = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(244, 255, 211));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 51));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setMinimumSize(new java.awt.Dimension(70, 23));
        jPanel2.setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EMPLOYEE REGISTERATION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(228, 228, 228))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblname.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        lblname.setText("EMPLOYEE NAME");

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel4.setText("AGE");

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel5.setText("DESIGNATION");

        BSVE.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BSVE.setText("SAVE");
        BSVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSVEActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("CLEAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbsuccess.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        bview.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bview.setText("SEARCH");
        bview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bviewActionPerformed(evt);
            }
        });

        lblenter.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setText("Single");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setText("Multiple");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Record");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(BSVE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(lbsuccess, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblname)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdesg, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtenm, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblenter, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblinvalid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txteid, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bview)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txteid, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblenter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bview))
                        .addGap(3, 3, 3)
                        .addComponent(lblinvalid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblname)
                            .addComponent(txtenm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdesg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(38, 38, 38)
                        .addComponent(lbsuccess, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BSVE)
                            .addComponent(jButton1))
                        .addGap(62, 62, 62))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BSVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSVEActionPerformed
        // TODO add your handling code here:
        int eid;
        String enm;
        int eage;
        String edesg;
               
        
        eid=0; //Integer.parseInt(txteid.getText());
        
        enm=txtenm.getText();
        
        eage=Integer.parseInt(txtage.getText());
        
        edesg=txtdesg.getText(); 
         
        Employee ob=new Employee();  
          
       {       
       ob.reg(enm, eage, edesg);
       }
       
        lbsuccess.setText("Record Inserted Successfully");
       /* {
              
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
            String str="insert into emp(empid, empnm, age, desig) values("+eid+",'"+enm+"',"+eage+",'"+edesg+"' )";            
            int r=st.executeUpdate(str);
            if(r>0)
            {
                 lbsuccess.setText("Record Inserted Successfully");
            }
            else
            {
                     lbsuccess.setText("Record Not Inserted ");
            }        
        con.close();
        }        
        
        catch(Exception ex)
        {
            System.out.println("Server Failed"+ex);
        }
    }
        */
      
        
    }//GEN-LAST:event_BSVEActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here       
        
        txteid.hide();
        lblenter.hide();
        bview.hide();
        
        txtenm.setText("");
        txtage.setText("");
        txtdesg.setText("");
        txtenm.enable();
        txtage.enable();
        txtdesg.enable();
        txtenm.setBackground(Color.WHITE);
        txtage.setBackground(Color.WHITE);
        txtdesg.setBackground(Color.WHITE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bviewActionPerformed
        // TODO add your handling code here:
        
      int eid1=Integer.parseInt(txteid.getText());
      String emid;
      
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
               ResultSet rs=st.executeQuery("Select * From emps where empid="+eid1+""); 
               while (rs.next())
               {
                   count1++;
                   emid=rs.getString("empid");
               }
           if (count1>0)
                  
           {        
            empdetails ob2=new empdetails(eid1);
            ob2.show();
            this.hide();
           }
          else
          {
              lblinvalid.setText("Invalid ID");
          }
               
           /*
           if(r>0)
            {
                System.out.println("Record Inserted Successfully");
            }
            else
            {
                    System.out.println("Record not Inserted");
            }        
               */
        con.close();
        }        
        
        catch(Exception ex)
        {
            System.out.println("Server Failed"+ex);
        }
     
            
    }//GEN-LAST:event_bviewActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        lblenter.setText("ENTER EMPLOYEE ID");
        bview.show();
        txteid.show();
        txtenm.disable();
        txtenm.setBackground(Color.LIGHT_GRAY);
        txtage.disable();
        txtage.setBackground(Color.LIGHT_GRAY);
        txtdesg.disable();
        txtdesg.setBackground(Color.LIGHT_GRAY);
        
        
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    int empid=0;
    String empnm="";
    int age=0;
    String desig="";
        
        
        
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
               ResultSet rs=st.executeQuery("Select * From emps "); 
               while (rs.next())
               {
                   count1++;
                 //String data[][]={{rs.getString("empid"),rs.getString("age"),rs.getString("empnm"),rs.getString("desig")}};
                 //break;
                 
                   
               }
                   
               if (count1>1)
                   {
                    college.viewall ob2=new viewall(empid,age,empnm,desig);
                    ob2.show();
                    
                   }
               
                
        con.close();
        }        
        
        catch(Exception ex)
        {
            System.out.println("Server Failed"+ex);
        } 
      
       
       
    }//GEN-LAST:event_jButton3ActionPerformed

    
    /*
    private void BUPDATE1ActionPerformed(java.awt.event.ActionEvent evt) {                      Update Button                   
        // TODO add your handling code here:
        int eid;
        String enm;
        int eage;
        String edesg;

        eid=Integer.parseInt(txteid.getText());
        enm=txtenm.getText();
        eage=Integer.parseInt(txtage.getText());
        edesg=txtdesg.getText();

        Employee ob=new Employee();

        {
            ob.update(eid, enm, eage, edesg);
        }

        lbsuccess.setText("Record Updated Successfully");
        */
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
     /*  Scanner sc=new Scanner(System.in);
        int eid;
        String enm;
        int eage;
        String edesg;
        
       
        System.out.println("Welcome To Employee Management System");
        
        System.out.println("1- Insert Record \n2- View Record \n3- Update Record \n4- Delete Record");
        System.out.println("Enter your Choice");
        int ch=sc.nextInt();
        
        Employee ob=new Employee();
        
        switch(ch)
        {
            case 1:
                
                System.out.println("Insert Record Panel");
                
                System.out.println("Enter Employee Id");
                eid=sc.nextInt();
                sc=new Scanner(System.in);
                System.out.println("Enter Employee Name");
                enm=sc.nextLine();
                System.out.println("Enter Employee age");
                eage=sc.nextInt();
                sc=new Scanner(System.in);
                System.out.println("Enter Employee Designation");
                edesg=sc.nextLine();
                ob.reg(eid, enm, eage, edesg);
        
            break;
            
            case 2:
                System.out.println("Search Record Panel");
                ob.view();
                
            break;
            
            case 3:
                System.out.println("Update Record Panel");
                ob.Update();
                break;
                
            case 4:
                System.out.println("Delete Record Panel");
                ob.delete();
                break;
                             
            default:
                System.out.println("Enter Valid Choice");
        
        }
        
        */
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new emssystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BSVE;
    private javax.swing.JButton bview;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblenter;
    private javax.swing.JLabel lblinvalid;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lbsuccess;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtdesg;
    private javax.swing.JTextField txteid;
    private javax.swing.JTextField txtenm;
    // End of variables declaration//GEN-END:variables
}
