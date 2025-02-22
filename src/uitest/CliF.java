package uitest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;


public class CliF extends javax.swing.JFrame {
    
    private static final String USERNAME= "root";  //Username for MySQL.
    private static final String PASSWORD= "1234";  //Password for MySQL.
    private static final String CONN_STRING= "jdbc:mysql://localhost:3306/tron"; //Path given to the created database
    
    
    String username, address = "localhost";
    ArrayList<String> users = new ArrayList();
    int port = 2222;
    Boolean isConnected = false;
    
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    
      public void ListenThread() 
    {
         Thread IncomingReader = new Thread(new IncomingReader());
         IncomingReader.start();
    }
    
     public void userAdd(String data) 
    {
         users.add(data);
    }
    
     public void userRemove(String data) 
    {
         ta_chat.append(data + " is now offline.\n");
    }
     
     
      public void writeUsers() 
    {
         String[] tempList = new String[(users.size())];
         users.toArray(tempList);
         for (String token:tempList) 
         {
             //users.append(token + "\n");
         }
    }
      
      public void sendDisconnect() 
    {
        String bye = (username + ": :Disconnect");
        try
        {
            writer.println(bye); 
            writer.flush(); 
        } catch (Exception e) 
        {
            ta_chat.append("Could not send Disconnect message.\n");
        }
    }
      
          public void Disconnect() 
    {
        try 
        {
            ta_chat.append("Disconnected.\n");
            sock.close();
        } catch(IOException ex) {
            ta_chat.append("Failed to disconnect. \n");
        }
        isConnected = false;
        username_textfield.setEditable(true);

    }

    public CliF() {
        initComponents();
        this.setLocationRelativeTo(null);//Center Form In The Screen
    }
    
    
     public class IncomingReader implements Runnable
    {
        @Override
        public void run() 
        {
            String[] data;
            String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";

            try 
            {
                while ((stream = reader.readLine()) != null) 
                {
                     data = stream.split(":");

                     if (data[2].equals(chat)) 
                     {
                        ta_chat.append(data[0] + ": " + data[1] + "\n");
                        ta_chat.setCaretPosition(ta_chat.getDocument().getLength());
                     } 
                     else if (data[2].equals(connect))
                     {
                        ta_chat.removeAll();
                        userAdd(data[0]);
                     } 
                     else if (data[2].equals(disconnect)) 
                     {
                         userRemove(data[0]);
                     } 
                     else if (data[2].equals(done)) 
                     {
                        //users.setText("");
                        writeUsers();
                        users.clear();
                     }
                }
           }catch(IOException ex) { }
        }
    }
     
     

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        localhost_textfield = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        message_textfield = new javax.swing.JTextField();
        address_label = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        port_label = new javax.swing.JLabel();
        port_textfield = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        password_textfield = new javax.swing.JTextField();
        username_textfield = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        connect_button = new javax.swing.JLabel();
        disconnect_button = new javax.swing.JLabel();
        anonymous_button = new javax.swing.JLabel();
        send_button = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_chat = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(20, 40, 80));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\shrey\\Pictures\\community_people.png")); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );

        localhost_textfield.setBackground(new java.awt.Color(20, 40, 80));
        localhost_textfield.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        localhost_textfield.setForeground(new java.awt.Color(255, 255, 255));
        localhost_textfield.setText("localhost");
        localhost_textfield.setBorder(null);
        localhost_textfield.setOpaque(false);
        localhost_textfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                localhost_textfieldFocusGained(evt);
            }
        });
        localhost_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localhost_textfieldActionPerformed(evt);
            }
        });

        message_textfield.setBackground(new java.awt.Color(20, 40, 80));
        message_textfield.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        message_textfield.setForeground(new java.awt.Color(153, 153, 153));
        message_textfield.setText("Enter Message Here");
        message_textfield.setBorder(null);
        message_textfield.setOpaque(false);
        message_textfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                message_textfieldFocusGained(evt);
            }
        });

        address_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        address_label.setForeground(new java.awt.Color(255, 255, 255));
        address_label.setText("Address");

        port_label.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        port_label.setForeground(new java.awt.Color(255, 255, 255));
        port_label.setText("Port");

        port_textfield.setBackground(new java.awt.Color(20, 40, 80));
        port_textfield.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        port_textfield.setForeground(new java.awt.Color(255, 255, 255));
        port_textfield.setText("2222");
        port_textfield.setBorder(null);
        port_textfield.setOpaque(false);
        port_textfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                port_textfieldFocusGained(evt);
            }
        });
        port_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                port_textfieldActionPerformed(evt);
            }
        });

        password_textfield.setBackground(new java.awt.Color(20, 40, 80));
        password_textfield.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        password_textfield.setForeground(new java.awt.Color(153, 153, 153));
        password_textfield.setText("Password");
        password_textfield.setBorder(null);
        password_textfield.setOpaque(false);
        password_textfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                password_textfieldFocusGained(evt);
            }
        });

        username_textfield.setBackground(new java.awt.Color(20, 40, 80));
        username_textfield.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        username_textfield.setForeground(new java.awt.Color(153, 153, 153));
        username_textfield.setText(" Username");
        username_textfield.setBorder(null);
        username_textfield.setOpaque(false);
        username_textfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                username_textfieldFocusGained(evt);
            }
        });
        username_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_textfieldActionPerformed(evt);
            }
        });

        connect_button.setIcon(new javax.swing.ImageIcon("C:\\Users\\shrey\\Pictures\\connect4.png")); // NOI18N
        connect_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                connect_buttonMouseClicked(evt);
            }
        });

        disconnect_button.setIcon(new javax.swing.ImageIcon("C:\\Users\\shrey\\Pictures\\disconnect1.png")); // NOI18N
        disconnect_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disconnect_buttonMouseClicked(evt);
            }
        });

        anonymous_button.setIcon(new javax.swing.ImageIcon("C:\\Users\\shrey\\Pictures\\anonymous.png")); // NOI18N
        anonymous_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anonymous_buttonMouseClicked(evt);
            }
        });

        send_button.setIcon(new javax.swing.ImageIcon("C:\\Users\\shrey\\Pictures\\send1.png")); // NOI18N
        send_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                send_buttonMouseClicked(evt);
            }
        });

        jLabelMin.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setIcon(new javax.swing.ImageIcon("C:\\Users\\shrey\\Pictures\\minimize.png")); // NOI18N
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setIcon(new javax.swing.ImageIcon("C:\\Users\\shrey\\Pictures\\shutdown_35px.png")); // NOI18N
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });

        ta_chat.setBackground(new java.awt.Color(20, 40, 80));
        ta_chat.setColumns(20);
        ta_chat.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        ta_chat.setForeground(new java.awt.Color(255, 255, 255));
        ta_chat.setRows(5);
        ta_chat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(ta_chat);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(port_label)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(address_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator3)
                                    .addComponent(jSeparator2)
                                    .addComponent(localhost_textfield)
                                    .addComponent(port_textfield))))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(connect_button)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator4)
                                    .addComponent(username_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(password_textfield)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(disconnect_button)
                        .addGap(18, 18, 18)
                        .addComponent(anonymous_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jLabelClose)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator1)
                                .addComponent(message_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(send_button)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(localhost_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(address_label, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(connect_button))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(disconnect_button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(port_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(port_label, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(password_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(username_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabelClose, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(anonymous_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabelMin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(message_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(send_button))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void localhost_textfieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_localhost_textfieldFocusGained
        // TODO add your handling code here:
        //localhost_textfield.setText("");
    }//GEN-LAST:event_localhost_textfieldFocusGained

    private void message_textfieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_message_textfieldFocusGained
        // TODO add your handling code here:
        message_textfield.setText("");
    }//GEN-LAST:event_message_textfieldFocusGained

    private void localhost_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localhost_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_localhost_textfieldActionPerformed

    private void port_textfieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_port_textfieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_port_textfieldFocusGained

    private void port_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_port_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_port_textfieldActionPerformed

    private void password_textfieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_textfieldFocusGained
        // TODO add your handling code here:
        //username_field.setText("");
    }//GEN-LAST:event_password_textfieldFocusGained

    private void username_textfieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_username_textfieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_username_textfieldFocusGained

    private void username_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_textfieldActionPerformed

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked
        
        //LoginForm Minimize Button Code;
        this.setState(JFrame.ICONIFIED);
        System.out.println("Minimized");
        
    }//GEN-LAST:event_jLabelMinMouseClicked

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
  
        //Login Form Close Button Code;
        System.out.println("Login Form CLosed");
        System.exit(0);
        
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void connect_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_connect_buttonMouseClicked
        // TODO add your handling code here:
             Connection conn = null;
        try{
            conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Conected!");
            Statement stmt = (Statement) conn.createStatement();
            String prt = port_textfield.getText();
            String add = localhost_textfield.getText();
            String user = username_textfield.getText();
            //String txt = tf_chat.getText();
            String insert = "INSERT INTO connected (port,address,username) VALUES ('"+prt+"','"+add+"','"+user+"')";
            stmt.executeUpdate(insert);
            
            
        }catch(SQLException e){
            System.err.println(e);   
        }
        
        
        
        if (isConnected == false) 
        {
            username = username_textfield.getText();
            username_textfield.setEditable(false);

            try 
            {
                sock = new Socket(address, port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println(username + ":has connected.:Connect");
                writer.flush(); 
                isConnected = true; 
            } 
            catch (IOException ex) 
            {
                ta_chat.append("Cannot Connect! Try Again. \n");
                username_textfield.setEditable(true);
            }
            
            ListenThread();
            
        } else if (isConnected == true) 
        {
            ta_chat.append("You are already connected. \n");
        }
    }//GEN-LAST:event_connect_buttonMouseClicked

    private void disconnect_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disconnect_buttonMouseClicked
        // TODO add your handling code here:
        sendDisconnect();
        Disconnect();
    }//GEN-LAST:event_disconnect_buttonMouseClicked

    private void anonymous_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anonymous_buttonMouseClicked
        // TODO add your handling code here:
             Connection conn = null;
        try{
            conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Conected!");
            Statement stmt = (Statement) conn.createStatement();
            String prt = port_textfield.getText();
            String add = localhost_textfield.getText();
            String user = username_textfield.getText();
            //String txt = tf_chat.getText();
            String insert = "INSERT INTO connected (port,address,username) VALUES ('"+prt+"','"+add+"','"+user+"')";
            stmt.executeUpdate(insert);
            
            
        }catch(SQLException e){
            System.err.println(e);   
        }
        
         username_textfield.setText("");
        if (isConnected == false) 
        {
            String anon="anon";
            Random generator = new Random(); 
            int i = generator.nextInt(999) + 1;
            String is=String.valueOf(i);
            anon=anon.concat(is);
            username=anon;
            
            username_textfield.setText(anon);
            username_textfield.setEditable(false);

            try 
            {
                sock = new Socket(address, port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println(anon + ":has connected.:Connect");
                writer.flush(); 
                isConnected = true; 
            } 
            catch (IOException ex) 
            {
                ta_chat.append("Cannot Connect! Try Again. \n");
                username_textfield.setEditable(true);
            }
            
            ListenThread();
            
        } else if (isConnected == true) 
        {
            ta_chat.append("You are already connected. \n");
        }    
    }//GEN-LAST:event_anonymous_buttonMouseClicked

    private void send_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_send_buttonMouseClicked
        // TODO add your handling code here:
            Connection conn = null;
        try{
            conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Conected!");
            Statement stmt = (Statement) conn.createStatement();
            String prt = port_textfield.getText();
            String add = localhost_textfield.getText();
            String user = username_textfield.getText();
            String txt = message_textfield.getText();
            String insert = "INSERT INTO server (port,address,username,text) VALUES ('"+prt+"','"+add+"','"+user+"','"+txt+"')";
            stmt.executeUpdate(insert);
            
        }catch(SQLException e){
            System.err.println(e);   
        }
        
          String nothing = "";
        if ((message_textfield.getText()).equals(nothing)) {
            message_textfield.setText("");
            message_textfield.requestFocus();
        } else {
            try {
               writer.println(username + ":" + message_textfield.getText() + ":" + "Chat");
               writer.flush(); // flushes the buffer
            } catch (Exception ex) {
                ta_chat.append("Message was not sent. \n");
            }
            message_textfield.setText("");
            message_textfield.requestFocus();
        }

        message_textfield.setText("");
        message_textfield.requestFocus();
    }//GEN-LAST:event_send_buttonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CliF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CliF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CliF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CliF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CliF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address_label;
    private javax.swing.JLabel anonymous_button;
    private javax.swing.JLabel connect_button;
    private javax.swing.JLabel disconnect_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField localhost_textfield;
    private javax.swing.JTextField message_textfield;
    private javax.swing.JTextField password_textfield;
    private javax.swing.JLabel port_label;
    private javax.swing.JTextField port_textfield;
    private javax.swing.JLabel send_button;
    private javax.swing.JTextArea ta_chat;
    private javax.swing.JTextField username_textfield;
    // End of variables declaration//GEN-END:variables
}
