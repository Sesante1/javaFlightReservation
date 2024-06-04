
package admins;

import config.dbConnector;
import java.awt.Color;
import javax.swing.JOptionPane;


public class airlinesForm extends javax.swing.JFrame {


    public airlinesForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        airlineName = new javax.swing.JTextField();
        airlineCountry = new javax.swing.JTextField();
        submitButton = new panelRoundComponents.PanelRound();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        airlineName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        airlineName.setForeground(new java.awt.Color(130, 130, 130));
        airlineName.setText("  Airline Name");
        airlineName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        airlineName.setPreferredSize(new java.awt.Dimension(6, 30));
        airlineName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                airlineNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                airlineNameFocusLost(evt);
            }
        });
        airlineName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airlineNameActionPerformed(evt);
            }
        });

        airlineCountry.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        airlineCountry.setForeground(new java.awt.Color(130, 130, 130));
        airlineCountry.setText("  Location");
        airlineCountry.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        airlineCountry.setPreferredSize(new java.awt.Dimension(6, 30));
        airlineCountry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                airlineCountryFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                airlineCountryFocusLost(evt);
            }
        });
        airlineCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airlineCountryActionPerformed(evt);
            }
        });

        submitButton.setBackground(new java.awt.Color(83, 215, 105));
        submitButton.setRoundBottomLeft(10);
        submitButton.setRoundBottomRight(10);
        submitButton.setRoundTopLeft(10);
        submitButton.setRoundTopRight(10);
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                submitButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                submitButtonMouseReleased(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Submit");

        javax.swing.GroupLayout submitButtonLayout = new javax.swing.GroupLayout(submitButton);
        submitButton.setLayout(submitButtonLayout);
        submitButtonLayout.setHorizontalGroup(
            submitButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, submitButtonLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(36, 36, 36))
        );
        submitButtonLayout.setVerticalGroup(
            submitButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(airlineName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(airlineCountry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(airlineName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(airlineCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void airlineNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_airlineNameFocusGained
        if (airlineName.getText().equals("  Airline Name")){
            airlineName.setText("");
            airlineName.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_airlineNameFocusGained

    private void airlineNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_airlineNameFocusLost
        if (airlineName.getText().equals("")){
            airlineName.setText("  Airline Name");
            airlineName.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_airlineNameFocusLost

    private void airlineNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airlineNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_airlineNameActionPerformed

    private void airlineCountryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_airlineCountryFocusGained
        if (airlineCountry.getText().equals("  Country")){
            airlineCountry.setText("");
            airlineCountry.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_airlineCountryFocusGained

    private void airlineCountryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_airlineCountryFocusLost
        if (airlineCountry.getText().equals("")){
            airlineCountry.setText("  Country");
            airlineCountry.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_airlineCountryFocusLost

    private void airlineCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airlineCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_airlineCountryActionPerformed

    private void submitButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMousePressed
        submitButton.setBackground(new Color(70,194,99));
    }//GEN-LAST:event_submitButtonMousePressed

    private void submitButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseReleased
        submitButton.setBackground(new Color(83,215,105));
    }//GEN-LAST:event_submitButtonMouseReleased

    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseClicked
        dbConnector dbc = new dbConnector();
        if (airlineName.getText().isEmpty() || airlineCountry.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "All fields are required!");
        } else {
            if (dbc.insertData("INSERT INTO airlines (Airline, Country)"   
                + "VALUES('" + airlineName.getText() + "','" + airlineCountry.getText() + "')"))
            {
                JOptionPane.showMessageDialog(null, "Added Successfully.");               
            } else {
                JOptionPane.showMessageDialog(null, "Connection Error!");
            }
            
            this.dispose();   
        }
    }//GEN-LAST:event_submitButtonMouseClicked

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
            java.util.logging.Logger.getLogger(airlinesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(airlinesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(airlinesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(airlinesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new airlinesForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField airlineCountry;
    private javax.swing.JTextField airlineName;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private panelRoundComponents.PanelRound submitButton;
    // End of variables declaration//GEN-END:variables
}
