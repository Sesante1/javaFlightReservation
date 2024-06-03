
package users;

import config.dbConnector;
import java.awt.Color;
import java.awt.Font;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaflightreservation.LogIn;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class registrationForm extends javax.swing.JFrame {

    public registrationForm() {
        initComponents();
    }
    
    Border border = BorderFactory.createLineBorder(new Color(255, 127, 127));
    Border defaultBorder = BorderFactory.createLineBorder(new Color(204,204,204));
    public String userEmail;
    public String userUsername;
    
    public boolean isDuplicate(){
        dbConnector connector = new dbConnector();
        try{
            String query = "SELECT * FROM users_table  WHERE Username = '" + username.getText() + "' OR Email = '" + email.getText() + "'";
            ResultSet resultSet = connector.getData(query);
            
            if (resultSet.next()){
                
                userEmail = resultSet.getString("Email");
                if (userEmail.equalsIgnoreCase(email.getText())){
                    JOptionPane.showMessageDialog(null, "Email already used!");
                }
                
                userUsername = resultSet.getString("Username");
                if (userUsername.equalsIgnoreCase(username.getText())){
                    JOptionPane.showMessageDialog(null, "Username already used!");
                }
                
                return true;
            } else {
                return false;
            }
        }catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public static String hashing(String Password){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            
            messageDigest.update(Password.getBytes());
            
            byte[] resultByteArray = messageDigest.digest();
            
            StringBuilder sb = new StringBuilder();
            
            for (byte b : resultByteArray){
                sb.append(String.format("%02x", b));
            }
            
            return sb.toString();
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(registrationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        signIn = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        userType = new designComponents.Combobox();
        jLabel7 = new javax.swing.JLabel();
        phoneNumber = new javax.swing.JTextField();
        registerButton = new panelRoundComponents.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        PhoneNumber1 = new javax.swing.JLabel();
        PhoneNumber2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        passwordWarning = new javax.swing.JLabel();
        fnameWarning = new javax.swing.JLabel();
        lnameWarning = new javax.swing.JLabel();
        emailWarning = new javax.swing.JLabel();
        phoneNumberWarning = new javax.swing.JLabel();
        usernameWarning = new javax.swing.JLabel();

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("You can't leave this empty");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(41, 123, 250));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sign up");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 820, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("First Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Last Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, -1, -1));

        signIn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        signIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signIn.setText("Sign in");
        signIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signInMouseClicked(evt);
            }
        });
        jPanel1.add(signIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 600, 50, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Username");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        fname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fname.setForeground(new java.awt.Color(153, 153, 153));
        fname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        fname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fnameFocusLost(evt);
            }
        });
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 290, 40));

        password.setForeground(new java.awt.Color(153, 153, 153));
        password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 290, 40));

        lname.setForeground(new java.awt.Color(153, 153, 153));
        lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lnameFocusGained(evt);
            }
        });
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 290, 40));

        email.setForeground(new java.awt.Color(153, 153, 153));
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 290, 40));

        username.setForeground(new java.awt.Color(153, 153, 153));
        username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 290, 40));

        userType.setForeground(new java.awt.Color(153, 153, 153));
        userType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "User" }));
        userType.setSelectedIndex(-1);
        userType.setLabeText("User Type");
        userType.setLineColor(new java.awt.Color(41, 123, 250));
        jPanel1.add(userType, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 290, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Email Address");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        phoneNumber.setForeground(new java.awt.Color(153, 153, 153));
        phoneNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(phoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 290, 40));

        registerButton.setBackground(new java.awt.Color(91, 164, 252));
        registerButton.setRoundBottomLeft(60);
        registerButton.setRoundBottomRight(60);
        registerButton.setRoundTopLeft(60);
        registerButton.setRoundTopRight(60);
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                registerButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                registerButtonMouseReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REGISTER");

        javax.swing.GroupLayout registerButtonLayout = new javax.swing.GroupLayout(registerButton);
        registerButton.setLayout(registerButtonLayout);
        registerButtonLayout.setHorizontalGroup(
            registerButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );
        registerButtonLayout.setVerticalGroup(
            registerButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, 270, 70));

        PhoneNumber1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PhoneNumber1.setForeground(new java.awt.Color(153, 153, 153));
        PhoneNumber1.setText("Phone Number");
        jPanel1.add(PhoneNumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, -1, -1));

        PhoneNumber2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PhoneNumber2.setForeground(new java.awt.Color(153, 153, 153));
        PhoneNumber2.setText("Already have an account?");
        jPanel1.add(PhoneNumber2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 600, -1, -1));

        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("____________________________________________________________________________________________________________________________________");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 800, -1));

        passwordWarning.setBackground(new java.awt.Color(255, 255, 255));
        passwordWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        passwordWarning.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(passwordWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 290, 20));

        fnameWarning.setBackground(new java.awt.Color(255, 255, 255));
        fnameWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        fnameWarning.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(fnameWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 290, 20));

        lnameWarning.setBackground(new java.awt.Color(255, 255, 255));
        lnameWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        lnameWarning.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lnameWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 290, 20));

        emailWarning.setBackground(new java.awt.Color(255, 255, 255));
        emailWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        emailWarning.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(emailWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 290, 20));

        phoneNumberWarning.setBackground(new java.awt.Color(255, 255, 255));
        phoneNumberWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        phoneNumberWarning.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(phoneNumberWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 290, 20));

        usernameWarning.setBackground(new java.awt.Color(255, 255, 255));
        usernameWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        usernameWarning.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(usernameWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 290, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fnameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameFocusGained

    private void fnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameFocusLost

    private void lnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lnameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameFocusGained

    private void registerButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMousePressed
        registerButton.setBackground(new Color(88,151,238));
    }//GEN-LAST:event_registerButtonMousePressed

    private void registerButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseReleased
        registerButton.setBackground(new Color(91,164,252));
    }//GEN-LAST:event_registerButtonMouseReleased

    private void signInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInMouseClicked
        LogIn signIn = new LogIn();
        signIn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signInMouseClicked

    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseClicked
        
        dbConnector dbc = new dbConnector();
        String selectedItem = (String) userType.getSelectedItem();
        
        if (fname.getText().isEmpty() || lname.getText().isEmpty() || email.getText().isEmpty() || phoneNumber.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty() || selectedItem == null){

            if (fname.getText().isEmpty()){
                fname.setBorder(border);
                fnameWarning.setText("You cant leave this empty");
            } else {
                fname.setBorder(defaultBorder);
                fnameWarning.setText(" ");
            }
            
            if (lname.getText().isEmpty()){
                lname.setBorder(border);
                lnameWarning.setText("You cant leave this empty");
            } else {
                lname.setBorder(defaultBorder);
                lnameWarning.setText(" ");
            }
            
            if (email.getText().isEmpty()){
                email.setBorder(border);
                emailWarning.setText("You cant leave this empty");
            } else {
                email.setBorder(defaultBorder);
                emailWarning.setText(" ");
            }
            
            if (phoneNumber.getText().isEmpty()){
                phoneNumber.setBorder(border);
                phoneNumberWarning.setText("You cant leave this empty");
            } else {
                phoneNumber.setBorder(defaultBorder);
                phoneNumberWarning.setText(" ");
            }
            
            if (username.getText().isEmpty()){
                username.setBorder(border);
                usernameWarning.setText("You cant leave this empty");
            } else {
                username.setBorder(defaultBorder);
                usernameWarning.setText(" ");
            }
            
            if (password.getText().isEmpty()){
                password.setBorder(border);
                passwordWarning.setText("You cant leave this empty");
            } else {
                password.setBorder(defaultBorder);
                passwordWarning.setText(" ");
            }
            
        } else if (password.getText().length() < 8){
            
            password.setBorder(border);
            passwordWarning.setText("Password must be 8 above");
            
            if (password.getText().length() > 8){
                password.setBorder(defaultBorder);
                passwordWarning.setText(" ");
            }
            
        } else if (isDuplicate()){
            System.out.println("Duplicate");
        } else {
            
            String destination = "";
            
            if (dbc.insertData("INSERT INTO users_table(First_Name, Last_Name, Email, Username, Password, Contact, User_type, profile, Status) "
                + "VALUES('" + fname.getText() + "','" + lname.getText() + "','" + email.getText() + "','" + username.getText() + "','" + hashing(password.getText()) + "','" + phoneNumber.getText() + "','" + userType.getSelectedItem() + "','" + destination + "', 'Pending')"))
            {
                JOptionPane.showMessageDialog(null, "Inserted Successfully.");

                LogIn logOut = new LogIn();
                logOut.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Connection Error!");
            }
        }
    }//GEN-LAST:event_registerButtonMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <=1.0; i = i+0.1) {
            String val = i+ "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e){
                
            }
        }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(registrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PhoneNumber1;
    private javax.swing.JLabel PhoneNumber2;
    private javax.swing.JTextField email;
    private javax.swing.JLabel emailWarning;
    public javax.swing.JTextField fname;
    public javax.swing.JLabel fnameWarning;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lname;
    private javax.swing.JLabel lnameWarning;
    private javax.swing.JTextField password;
    private javax.swing.JLabel passwordWarning;
    private javax.swing.JTextField phoneNumber;
    private javax.swing.JLabel phoneNumberWarning;
    private panelRoundComponents.PanelRound registerButton;
    private javax.swing.JLabel signIn;
    private designComponents.Combobox userType;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernameWarning;
    // End of variables declaration//GEN-END:variables
}
