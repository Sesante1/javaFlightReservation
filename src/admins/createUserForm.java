
package admins;

import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import users.registrationForm;

public class createUserForm extends javax.swing.JFrame {

    public createUserForm() {
        initComponents();   
    }
    
    Border border = BorderFactory.createLineBorder(new Color(255, 127, 127));
    Border defaultBorder = BorderFactory.createLineBorder(new Color(204,204,204));
    
    Session session = Session.getInstance();
    public String destination = " ";
    File selectedFile;
    public String oldpath;
    public String path;
    
    public String userEmail;
    public String userUsername;
    
    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userProfile", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
    
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
            Logger.getLogger(createUserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        phoneNumber = new javax.swing.JTextField();
        addButton = new panelRoundComponents.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        PhoneNumber1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cancelButton = new panelRoundComponents.PanelRound();
        jLabel9 = new javax.swing.JLabel();
        userStatus = new designComponents.Combobox();
        userType = new designComponents.Combobox();
        panelRound1 = new panelRoundComponents.PanelRound();
        profilePic = new avatar.ImageAvatar();
        uploadImage = new javax.swing.JLabel();
        removeImage = new javax.swing.JLabel();
        fnameWarning = new javax.swing.JLabel();
        lnameWarning = new javax.swing.JLabel();
        emailWarning = new javax.swing.JLabel();
        phoneNumberWarning = new javax.swing.JLabel();
        usernameWarning = new javax.swing.JLabel();
        passwordWarning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 87, 228));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create User");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 820, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("First Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Last Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Username");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, -1, -1));

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
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 290, 40));

        password.setForeground(new java.awt.Color(153, 153, 153));
        password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 490, 290, 40));

        lname.setForeground(new java.awt.Color(153, 153, 153));
        lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lnameFocusGained(evt);
            }
        });
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 290, 40));

        email.setForeground(new java.awt.Color(153, 153, 153));
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 290, 40));

        username.setForeground(new java.awt.Color(153, 153, 153));
        username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 290, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Email Address");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, -1));

        phoneNumber.setForeground(new java.awt.Color(153, 153, 153));
        phoneNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(phoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 290, 40));

        addButton.setBackground(new java.awt.Color(91, 164, 252));
        addButton.setRoundBottomLeft(10);
        addButton.setRoundBottomRight(10);
        addButton.setRoundTopLeft(10);
        addButton.setRoundTopRight(10);
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addButtonMouseReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Add");

        javax.swing.GroupLayout addButtonLayout = new javax.swing.GroupLayout(addButton);
        addButton.setLayout(addButtonLayout);
        addButtonLayout.setHorizontalGroup(
            addButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );
        addButtonLayout.setVerticalGroup(
            addButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 670, 150, 50));

        PhoneNumber1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PhoneNumber1.setForeground(new java.awt.Color(153, 153, 153));
        PhoneNumber1.setText("Phone Number");
        jPanel1.add(PhoneNumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, -1, -1));

        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("_____________________________________________________________________________________________________________________________________");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 800, -1));

        cancelButton.setBackground(new java.awt.Color(252, 61, 57));
        cancelButton.setRoundBottomLeft(10);
        cancelButton.setRoundBottomRight(10);
        cancelButton.setRoundTopLeft(10);
        cancelButton.setRoundTopRight(10);
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelButtonMouseReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Cancel");

        javax.swing.GroupLayout cancelButtonLayout = new javax.swing.GroupLayout(cancelButton);
        cancelButton.setLayout(cancelButtonLayout);
        cancelButtonLayout.setHorizontalGroup(
            cancelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cancelButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );
        cancelButtonLayout.setVerticalGroup(
            cancelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 670, -1, 50));

        userStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Pending" }));
        userStatus.setSelectedIndex(-1);
        userStatus.setLabeText("User Status");
        jPanel1.add(userStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, 290, 40));

        userType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "User" }));
        userType.setSelectedIndex(-1);
        userType.setLabeText("User Type");
        jPanel1.add(userType, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 290, 40));

        panelRound1.setRoundBottomLeft(100);
        panelRound1.setRoundBottomRight(100);
        panelRound1.setRoundTopLeft(100);
        panelRound1.setRoundTopRight(100);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 100, 100));

        uploadImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/upload-image.png"))); // NOI18N
        uploadImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uploadImageMouseClicked(evt);
            }
        });
        jPanel1.add(uploadImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 20, 30));

        removeImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove-image.png"))); // NOI18N
        removeImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeImageMouseClicked(evt);
            }
        });
        jPanel1.add(removeImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 20, 30));

        fnameWarning.setBackground(new java.awt.Color(255, 255, 255));
        fnameWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        fnameWarning.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(fnameWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 290, 20));

        lnameWarning.setBackground(new java.awt.Color(255, 255, 255));
        lnameWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        lnameWarning.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lnameWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 290, 20));

        emailWarning.setBackground(new java.awt.Color(255, 255, 255));
        emailWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        emailWarning.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(emailWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 290, 20));

        phoneNumberWarning.setBackground(new java.awt.Color(255, 255, 255));
        phoneNumberWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        phoneNumberWarning.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(phoneNumberWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, 290, 20));

        usernameWarning.setBackground(new java.awt.Color(255, 255, 255));
        usernameWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        usernameWarning.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(usernameWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 290, 20));

        passwordWarning.setBackground(new java.awt.Color(255, 255, 255));
        passwordWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        passwordWarning.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(passwordWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 530, 290, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
        );

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
 
    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
        manageUsers update = new manageUsers();
        update.refresh = true;
        dbConnector dbc = new dbConnector();
        String selectedType = (String) userType.getSelectedItem();
        String selectedStatus = (String) userStatus.getSelectedItem();
        
        if (fname.getText().isEmpty() || lname.getText().isEmpty() || email.getText().isEmpty() || phoneNumber.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty() || selectedType == null || selectedStatus == null){
                
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
            if (dbc.insertData("INSERT INTO users_table (First_Name, Last_Name, Email, Username, Password, Contact, Status, User_type, profile)"
                + "VALUES('" + fname.getText() + "','" + lname.getText() + "','" + email.getText() + "','" + username.getText() + "','" + hashing(password.getText()) + "','" + phoneNumber.getText() + "','" + userStatus.getSelectedItem() + "','" + userType.getSelectedItem() + "','"+ destination +"')"))
            {
                
                if (selectedFile != null) {
                    try {
                        JOptionPane.showMessageDialog(null, "Registration Success.");
                        Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                        this.dispose();
                    } catch (IOException ex) {
                        Logger.getLogger(createUserForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                /*try {
                    Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    JOptionPane.showMessageDialog(null, "Registration Success.");
                    update.displayData();
                    this.dispose();
                } catch (IOException ex) {
                    Logger.getLogger(createUserForm.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            } else {
                JOptionPane.showMessageDialog(null, "Connection Error!");
            }
        }
    }//GEN-LAST:event_addButtonMouseClicked

    private void addButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMousePressed
        addButton.setBackground(new Color(88,151,238));
    }//GEN-LAST:event_addButtonMousePressed

    private void addButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseReleased
        addButton.setBackground(new Color(91,164,252));
    }//GEN-LAST:event_addButtonMouseReleased

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_cancelButtonMouseClicked

    private void cancelButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMousePressed
        cancelButton.setBackground(new Color(227,52,55));
    }//GEN-LAST:event_cancelButtonMousePressed

    private void cancelButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseReleased
        cancelButton.setBackground(new Color(252,61,57));
    }//GEN-LAST:event_cancelButtonMouseReleased

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

    private void uploadImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadImageMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                destination = "src/userProfile/" + selectedFile.getName();
                path  = selectedFile.getAbsolutePath();

                if(FileExistenceChecker(path) == 1){
                    JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                    destination = "";
                    path="";
                }else{
                    //profilePic.setIcon((Icon) profilePic);
                    profilePic.setIcon(new ImageIcon(path));
                    uploadImage.setVisible(false);
                    removeImage.setVisible(true);
                    //browse.setVisible(true);
                    //browse.setText("REMOVE");
                    //browse1.setVisible(false);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_uploadImageMouseClicked

    private void removeImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeImageMouseClicked
        uploadImage.setVisible(true);
        removeImage.setVisible(false);
        profilePic.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_removeImageMouseClicked

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
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PhoneNumber1;
    private panelRoundComponents.PanelRound addButton;
    private panelRoundComponents.PanelRound cancelButton;
    private javax.swing.JTextField email;
    private javax.swing.JLabel emailWarning;
    private javax.swing.JTextField fname;
    public javax.swing.JLabel fnameWarning;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lname;
    private javax.swing.JLabel lnameWarning;
    private panelRoundComponents.PanelRound panelRound1;
    private javax.swing.JTextField password;
    private javax.swing.JLabel passwordWarning;
    private javax.swing.JTextField phoneNumber;
    private javax.swing.JLabel phoneNumberWarning;
    public avatar.ImageAvatar profilePic;
    public javax.swing.JLabel removeImage;
    public javax.swing.JLabel uploadImage;
    private designComponents.Combobox userStatus;
    private designComponents.Combobox userType;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernameWarning;
    // End of variables declaration//GEN-END:variables
    
}
