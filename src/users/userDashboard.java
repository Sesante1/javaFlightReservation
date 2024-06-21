
package users;

import static admins.updateUser.getHeightFromWidth;
import admins.viewProfile;
import config.Session;
import designComponents.EventNavigationBar;
import java.awt.Color;
import java.awt.Image;
import javaflightreservation.LogIn;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class userDashboard extends javax.swing.JFrame {

    public userDashboard() {
        initComponents();
        
        getContentPane().setBackground(new Color(41,123,250));
        
        navigationBar1.addItem(new ImageIcon(getClass().getResource("/navigationIcons/book-flight.png")));
        navigationBar1.addItem(new ImageIcon(getClass().getResource("/navigationIcons/flight-list_1.png")));
        navigationBar1.addItem(new ImageIcon(getClass().getResource("/navigationIcons/ticket.png")));
        navigationBar1.addEvent(new EventNavigationBar() {
            @Override
            public void beforeSelected(int index) {
                
                switch (index) {
                    case 0:
                        image.setVisible(false);
                        welcomeTxt.setVisible(false);
                        panelTransitions1.display(new bookedFlights(), navigationBar1.getAnimator());
                        break;
                    case 1:
                        image.setVisible(false);
                        welcomeTxt.setVisible(false);
                        panelTransitions1.display(new flightList(), navigationBar1.getAnimator());
                        break;
                    case 2:
                        image.setVisible(false);
                        welcomeTxt.setVisible(false);
                        panelTransitions1.display(new printTickets(), navigationBar1.getAnimator());
                        break;
                    default:
                        break;
                } 
            }

            @Override
            public void afterSelected(int index) {

            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        welcomeTxt = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        navigationBar1 = new designComponents.NavigationBar();
        panelTransitions1 = new transition.PanelTransitions();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        panelRound1 = new panelRoundComponents.PanelRound();
        logOutButton = new javax.swing.JLabel();
        userProfile = new avatar.ImageAvatar();
        viewProfile = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        account_name = new javax.swing.JLabel();
        user_type = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(41, 123, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(1030, 7));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        welcomeTxt.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        welcomeTxt.setForeground(new java.awt.Color(128, 128, 128));
        welcomeTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeTxt.setText("WELCOME USER");
        jPanel1.add(welcomeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 880, 60));

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backGroundImage/welcome.png"))); // NOI18N
        jPanel1.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 730, 350));

        navigationBar1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout navigationBar1Layout = new javax.swing.GroupLayout(navigationBar1);
        navigationBar1.setLayout(navigationBar1Layout);
        navigationBar1Layout.setHorizontalGroup(
            navigationBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        navigationBar1Layout.setVerticalGroup(
            navigationBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        jPanel1.add(navigationBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 632, 1030, -1));

        panelTransitions1.setBackground(new java.awt.Color(255, 255, 255));
        panelTransitions1.setOpaque(true);
        jPanel1.add(panelTransitions1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1030, 490));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(41, 123, 250));
        jLabel2.setText("Book Flight");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(41, 123, 250));
        jLabel3.setText("Flight List");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(41, 123, 250));
        jLabel4.setText("Ticketing");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel2)
                .addGap(207, 207, 207)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(177, 177, 177))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 770, 1030, 40));

        jPanel3.setBackground(new java.awt.Color(230, 230, 230));

        exit.setBackground(new java.awt.Color(230, 230, 230));
        exit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit.setText("X");
        exit.setToolTipText("Exit");
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setOpaque(true);
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 989, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, -1));

        panelRound1.setBackground(new java.awt.Color(41, 123, 250));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logOutButton.setBackground(new java.awt.Color(255, 255, 255));
        logOutButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
        logOutButton.setText("LOG OUT");
        logOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutButtonMouseExited(evt);
            }
        });
        panelRound1.add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 28, -1, 60));
        panelRound1.add(userProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 80, 80));

        viewProfile.setBackground(new java.awt.Color(41, 123, 250));
        viewProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewProfileMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_profile.png"))); // NOI18N

        javax.swing.GroupLayout viewProfileLayout = new javax.swing.GroupLayout(viewProfile);
        viewProfile.setLayout(viewProfileLayout);
        viewProfileLayout.setHorizontalGroup(
            viewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        viewProfileLayout.setVerticalGroup(
            viewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelRound1.add(viewProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 88));

        account_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        account_name.setForeground(new java.awt.Color(255, 255, 255));
        panelRound1.add(account_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 37, 251, 24));

        user_type.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        user_type.setForeground(new java.awt.Color(255, 255, 255));
        panelRound1.add(user_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 67, 251, 20));

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1030, 110));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1030, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logOutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseClicked
        LogIn logOut = new LogIn();
        logOut.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOutButtonMouseClicked

    private void logOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseEntered
        logOutButton.setForeground(new Color(255,196,54));
    }//GEN-LAST:event_logOutButtonMouseEntered

    private void logOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseExited
        logOutButton.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_logOutButtonMouseExited

    private void viewProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewProfileMouseClicked
        viewProfile view = new viewProfile();
        view.setVisible(true);
    }//GEN-LAST:event_viewProfileMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        exit.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        exit.setBackground(new Color(230,230,230));
    }//GEN-LAST:event_exitMouseExited

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session session = Session.getInstance();
        account_name.setText(session.getFname() + " " + session.getLname());
        user_type.setText(session.getType());
        
        
        if (!session.getImagePath().isEmpty()){
            userProfile.setIcon(new ImageIcon(session.getImagePath()));
        }
    }//GEN-LAST:event_formWindowActivated


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
            java.util.logging.Logger.getLogger(userDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel account_name;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel logOutButton;
    private designComponents.NavigationBar navigationBar1;
    private panelRoundComponents.PanelRound panelRound1;
    private transition.PanelTransitions panelTransitions1;
    private avatar.ImageAvatar userProfile;
    private javax.swing.JLabel user_type;
    private javax.swing.JPanel viewProfile;
    private javax.swing.JLabel welcomeTxt;
    // End of variables declaration//GEN-END:variables
}
