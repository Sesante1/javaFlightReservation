
package admins;

import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import users.registrationForm;

public class updateUser extends javax.swing.JFrame {

    public updateUser() {
        initComponents();
    }
    
    Session session = Session.getInstance();
    public String destination;
    File selectedFile;
    public String oldpath;
    public String path;
    
    
    public String userEmail;
    public String userUsername;
    
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
    
    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
        ImageIcon MyImage = null;
            if(ImagePath !=null){
                MyImage = new ImageIcon(ImagePath);
            }else{
                MyImage = new ImageIcon(pic);
            }

        int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    
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
    
    public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
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
    
    public boolean updateCheck(){
        dbConnector connector = new dbConnector();
        try{
            String query = "SELECT * FROM users_table  WHERE (Username = '" + username.getText() + "' OR Email = '" + email.getText() + "')AND Id != '"+uid.getText()+"'";
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
            Logger.getLogger(updateUser.class.getName()).log(Level.SEVERE, null, ex);
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
        phoneNumber = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        uid = new javax.swing.JTextField();
        updateButton = new panelRoundComponents.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        PhoneNumber1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cancelButton = new panelRoundComponents.PanelRound();
        jLabel9 = new javax.swing.JLabel();
        userStatus = new designComponents.Combobox();
        userType = new designComponents.Combobox();
        username = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panelRound1 = new panelRoundComponents.PanelRound();
        profilePic = new avatar.ImageAvatar();
        removeImage = new javax.swing.JLabel();
        uploadImage = new javax.swing.JLabel();
        image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(41, 123, 250));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update User");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 820, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Contact No");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("First Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Last Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, -1, -1));

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
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 290, 40));

        phoneNumber.setForeground(new java.awt.Color(153, 153, 153));
        phoneNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(phoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, 290, 40));

        lname.setForeground(new java.awt.Color(153, 153, 153));
        lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lnameFocusGained(evt);
            }
        });
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 290, 40));

        email.setForeground(new java.awt.Color(153, 153, 153));
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 290, 40));

        password.setForeground(new java.awt.Color(153, 153, 153));
        password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        password.setEnabled(false);
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 290, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Email Address");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, -1));

        uid.setForeground(new java.awt.Color(153, 153, 153));
        uid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        uid.setEnabled(false);
        jPanel1.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 290, 40));

        updateButton.setBackground(new java.awt.Color(83, 215, 105));
        updateButton.setRoundBottomLeft(10);
        updateButton.setRoundBottomRight(10);
        updateButton.setRoundTopLeft(10);
        updateButton.setRoundTopRight(10);
        updateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updateButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                updateButtonMouseReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Update");

        javax.swing.GroupLayout updateButtonLayout = new javax.swing.GroupLayout(updateButton);
        updateButton.setLayout(updateButtonLayout);
        updateButtonLayout.setHorizontalGroup(
            updateButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );
        updateButtonLayout.setVerticalGroup(
            updateButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 710, 150, 50));

        PhoneNumber1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PhoneNumber1.setForeground(new java.awt.Color(153, 153, 153));
        PhoneNumber1.setText("User ID");
        jPanel1.add(PhoneNumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));

        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("_________________________________________________________________________________________________________________________________");
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

        jPanel1.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 710, -1, 50));

        userStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Pending" }));
        userStatus.setSelectedIndex(-1);
        userStatus.setLabeText("User Status");
        jPanel1.add(userStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 520, 290, 40));

        userType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "User" }));
        userType.setSelectedIndex(-1);
        userType.setLabeText("User Type");
        jPanel1.add(userType, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 590, 290, 40));

        username.setForeground(new java.awt.Color(153, 153, 153));
        username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 290, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Username");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(41, 123, 250));
        jLabel11.setText("Change password");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, 120, -1));

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

        removeImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove-image.png"))); // NOI18N
        removeImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeImageMouseClicked(evt);
            }
        });
        jPanel1.add(removeImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 20, 30));

        uploadImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/upload-image.png"))); // NOI18N
        uploadImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uploadImageMouseClicked(evt);
            }
        });
        jPanel1.add(uploadImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 20, 30));
        jPanel1.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 220, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_cancelButtonMouseClicked

    private void cancelButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMousePressed
        cancelButton.setBackground(new Color(227,52,55));
    }//GEN-LAST:event_cancelButtonMousePressed

    private void cancelButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseReleased
        cancelButton.setBackground(new Color(252,61,57));
    }//GEN-LAST:event_cancelButtonMouseReleased

    private void updateButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseReleased
        updateButton.setBackground(new Color(83,215,105));
    }//GEN-LAST:event_updateButtonMouseReleased
    
    public boolean updateThePassword = false;
    
    private void updateButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMousePressed
        updateButton.setBackground(new Color(70,194,99));
    }//GEN-LAST:event_updateButtonMousePressed

    private void updateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseClicked
        dbConnector dbc =  new dbConnector();
        
        if (fname.getText().isEmpty() || lname.getText().isEmpty() || email.getText().isEmpty() || phoneNumber.getText().isEmpty() || username.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "All fields are required!");
        } else if (!password.getText().isEmpty()){
            if (password.getText().length() < 8){
                JOptionPane.showMessageDialog(null, "Password must be 8 above");
            }
        } else if (updateCheck()){
            System.out.println("Duplicate");
        } else {
            System.out.println("destination: " + destination);
            System.out.println("path: " + path);
            System.out.println("oldpath: " + oldpath);
            
            dbc.updateData("UPDATE users_table SET First_Name = '"+ fname.getText() +"', Last_Name = '"+ lname.getText() +"', Email = '"+ email.getText() +"', "
                + "Username = '"+ username.getText() +"', Contact = '"+ phoneNumber.getText() +"', User_type = '"+ userType.getSelectedItem()+"',"
                        + " Status = '"+ userStatus.getSelectedItem()+"',profile = '"+ destination +"' WHERE Id = '"+ uid.getText()+"'");
            
            if (destination.isEmpty()){
                File existingFile = new File(oldpath);
                System.out.println("true");
                
                if (existingFile.exists()){
                    existingFile.delete();
                    System.out.println("exist");
                }
                
            } else {     
                System.out.println("false");
                if (!(oldpath.equals(path))){
                    imageUpdater(oldpath, path);
                    System.out.println("imageUpdate");
                }
            }
            
            this.dispose();
        }  
    }//GEN-LAST:event_updateButtonMouseClicked
    
    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        //passwords.setEnabled(true);
        //updatePassword update = new updatePassword();
        //update.userId = uid.getText();
        //update.setVisible(true);
        //updateThePassword = true;
        
        /*if (!password.getText().isEmpty()){         
                dbc.updateData("UPDATE users_table SET First_Name = '"+ fname.getText() +"', Last_Name = '"+ lname.getText() +"', Email = '"+ email.getText() +"', "
                + "Username = '"+ username.getText() +"', Contact = '"+ phoneNumber.getText() +"', User_type = '"+ userType.getSelectedItem()+"',"
                        + " Status = '"+ userStatus.getSelectedItem()+"' WHERE Id = '"+ uid.getText()+"'");
                System.out.println("not empty");
                //this.dispose();
            } else {
                dbc.updateData("UPDATE users_table SET First_Name = '"+ fname.getText() +"', Last_Name = '"+ lname.getText() +"', Email = '"+ email.getText() +"', "
                + "Username = '"+ username.getText() +"', Password = '"+ hashing(password.getText()) +"', Contact = '"+ phoneNumber.getText() +"', User_type = '"+ userType.getSelectedItem()+"',"
                        + " Status = '"+ userStatus.getSelectedItem()+"' WHERE Id = '"+ uid.getText()+"'");
                //this.dispose();
                System.out.println("Empty");
            }*/
    }//GEN-LAST:event_jLabel11MouseClicked

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
                            //image.setIcon(ResizeImage(path, null, image));
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
            java.util.logging.Logger.getLogger(updateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PhoneNumber1;
    private panelRoundComponents.PanelRound cancelButton;
    public javax.swing.JTextField email;
    public javax.swing.JTextField fname;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField lname;
    private panelRoundComponents.PanelRound panelRound1;
    public javax.swing.JTextField password;
    public javax.swing.JTextField phoneNumber;
    public avatar.ImageAvatar profilePic;
    public javax.swing.JLabel removeImage;
    public javax.swing.JTextField uid;
    private panelRoundComponents.PanelRound updateButton;
    public javax.swing.JLabel uploadImage;
    public designComponents.Combobox userStatus;
    public designComponents.Combobox userType;
    public javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
