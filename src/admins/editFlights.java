
package admins;

import config.dbConnector;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;


public class editFlights extends javax.swing.JFrame {


    public editFlights() {
        initComponents();
        airlineList();
        
    }
    public int flightId = 0;
    public int airlineId = 0;
    Border border = BorderFactory.createLineBorder(new Color(255, 127, 127));
    Border defaultBorder = BorderFactory.createLineBorder(new Color(204,204,204));
    
    public void airlineList(){
        try{
            dbConnector dbc = new dbConnector();
            String query = "SELECT Airline FROM airlines";
            ResultSet resultSet = dbc.getData(query);
            
            while (resultSet.next()){
                String airline = resultSet.getString("airline");
                airlines.addItem(airline);
            }
            
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
    
    public static boolean isValidTime(String timeStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        sdf.setLenient(false);
        try {
            Date time = sdf.parse(timeStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        departure = new com.raven.datechooser.DateChooser();
        arrival = new com.raven.datechooser.DateChooser();
        panelRound1 = new panelRoundComponents.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        departureDate = new javax.swing.JTextField();
        departureTime = new javax.swing.JTextField();
        fare = new javax.swing.JTextField();
        flyingFrom = new javax.swing.JTextField();
        arrivalDate = new javax.swing.JTextField();
        arrivalTime = new javax.swing.JTextField();
        FlyingTo = new javax.swing.JTextField();
        seats = new javax.swing.JTextField();
        addButton = new panelRoundComponents.PanelRound();
        jLabel10 = new javax.swing.JLabel();
        cancelButton = new panelRoundComponents.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        airlines = new combo_suggestion.ComboBoxSuggestion();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        departureDateWarning = new javax.swing.JLabel();
        departureTimeWarning = new javax.swing.JLabel();
        arrivalDateWarning = new javax.swing.JLabel();
        arrivalTimeWarning = new javax.swing.JLabel();
        flyingFromWarning = new javax.swing.JLabel();
        flyingToWarning = new javax.swing.JLabel();
        fareWarning = new javax.swing.JLabel();
        seatsWarning = new javax.swing.JLabel();

        departure.setTextRefernce(departureDate);

        arrival.setTextRefernce(arrivalDate);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        panelRound1.setPreferredSize(new java.awt.Dimension(966, 600));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 87, 228));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EDIT FLIGHT DETAILS");
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 40, 938, -1));

        departureDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        departureDate.setForeground(new java.awt.Color(130, 130, 130));
        departureDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        departureDate.setPreferredSize(new java.awt.Dimension(6, 30));
        departureDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                departureDateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                departureDateFocusLost(evt);
            }
        });
        departureDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departureDateActionPerformed(evt);
            }
        });
        panelRound1.add(departureDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 202, 376, 40));

        departureTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        departureTime.setForeground(new java.awt.Color(153, 153, 153));
        departureTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        departureTime.setPreferredSize(new java.awt.Dimension(6, 30));
        departureTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                departureTimeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                departureTimeFocusLost(evt);
            }
        });
        panelRound1.add(departureTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 202, 375, 40));

        fare.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fare.setForeground(new java.awt.Color(153, 153, 153));
        fare.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        fare.setPreferredSize(new java.awt.Dimension(6, 30));
        fare.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fareFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fareFocusLost(evt);
            }
        });
        panelRound1.add(fare, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 524, 176, 40));

        flyingFrom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        flyingFrom.setForeground(new java.awt.Color(153, 153, 153));
        flyingFrom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        flyingFrom.setPreferredSize(new java.awt.Dimension(6, 30));
        flyingFrom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                flyingFromFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                flyingFromFocusLost(evt);
            }
        });
        panelRound1.add(flyingFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 412, 376, 40));

        arrivalDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        arrivalDate.setForeground(new java.awt.Color(153, 153, 153));
        arrivalDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        arrivalDate.setPreferredSize(new java.awt.Dimension(6, 30));
        arrivalDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                arrivalDateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                arrivalDateFocusLost(evt);
            }
        });
        panelRound1.add(arrivalDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 308, 376, 40));

        arrivalTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        arrivalTime.setForeground(new java.awt.Color(153, 153, 153));
        arrivalTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        arrivalTime.setPreferredSize(new java.awt.Dimension(6, 30));
        arrivalTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                arrivalTimeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                arrivalTimeFocusLost(evt);
            }
        });
        panelRound1.add(arrivalTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 308, 375, 40));

        FlyingTo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        FlyingTo.setForeground(new java.awt.Color(153, 153, 153));
        FlyingTo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        FlyingTo.setPreferredSize(new java.awt.Dimension(6, 30));
        FlyingTo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                FlyingToFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                FlyingToFocusLost(evt);
            }
        });
        panelRound1.add(FlyingTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 412, 375, 40));

        seats.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        seats.setForeground(new java.awt.Color(153, 153, 153));
        seats.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        seats.setPreferredSize(new java.awt.Dimension(6, 30));
        seats.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                seatsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                seatsFocusLost(evt);
            }
        });
        panelRound1.add(seats, new org.netbeans.lib.awtextra.AbsoluteConstraints(693, 524, 181, 40));

        addButton.setBackground(new java.awt.Color(83, 215, 105));
        addButton.setToolTipText("Refresh");
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

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Continue");

        javax.swing.GroupLayout addButtonLayout = new javax.swing.GroupLayout(addButton);
        addButton.setLayout(addButtonLayout);
        addButtonLayout.setHorizontalGroup(
            addButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addButtonLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(44, 44, 44))
        );
        addButtonLayout.setVerticalGroup(
            addButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        panelRound1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 616, -1, -1));

        cancelButton.setBackground(new java.awt.Color(252, 61, 57));
        cancelButton.setToolTipText("Delete");
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

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Cancel");

        javax.swing.GroupLayout cancelButtonLayout = new javax.swing.GroupLayout(cancelButton);
        cancelButton.setLayout(cancelButtonLayout);
        cancelButtonLayout.setHorizontalGroup(
            cancelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cancelButtonLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(51, 51, 51))
        );
        cancelButtonLayout.setVerticalGroup(
            cancelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cancelButtonLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelRound1.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 616, -1, -1));

        airlines.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                airlinesMouseClicked(evt);
            }
        });
        panelRound1.add(airlines, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 526, 376, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Departure Date");
        panelRound1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 177, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Arrival Date");
        panelRound1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 286, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Departure Time");
        panelRound1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 177, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Arrival Time");
        panelRound1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 286, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Flying From");
        panelRound1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 393, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Flying To");
        panelRound1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 393, -1, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Airline");
        panelRound1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 502, -1, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Fare");
        panelRound1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 502, -1, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Seats");
        panelRound1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(693, 502, -1, -1));

        departureDateWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        departureDateWarning.setForeground(new java.awt.Color(255, 0, 0));
        panelRound1.add(departureDateWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 370, 20));

        departureTimeWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        departureTimeWarning.setForeground(new java.awt.Color(255, 0, 0));
        panelRound1.add(departureTimeWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 370, 20));

        arrivalDateWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        arrivalDateWarning.setForeground(new java.awt.Color(255, 0, 0));
        panelRound1.add(arrivalDateWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 370, 20));

        arrivalTimeWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        arrivalTimeWarning.setForeground(new java.awt.Color(255, 0, 0));
        panelRound1.add(arrivalTimeWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 370, 20));

        flyingFromWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        flyingFromWarning.setForeground(new java.awt.Color(255, 0, 0));
        panelRound1.add(flyingFromWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 370, 20));

        flyingToWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        flyingToWarning.setForeground(new java.awt.Color(255, 0, 0));
        panelRound1.add(flyingToWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 370, 20));

        fareWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        fareWarning.setForeground(new java.awt.Color(255, 0, 0));
        panelRound1.add(fareWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 570, 170, 20));

        seatsWarning.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        seatsWarning.setForeground(new java.awt.Color(255, 0, 0));
        panelRound1.add(seatsWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 570, 170, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void departureDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_departureDateFocusGained
        /*if (departureDate.getText().equals("  Departure")){
            departureDate.setText("");
            departureDate.setForeground(new Color(153,153,153));
        }*/
    }//GEN-LAST:event_departureDateFocusGained

    private void departureDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_departureDateFocusLost
        /*if (departureDate.getText().equals("")){
            departureDate.setText("  Departure");
            departureDate.setForeground(new Color(153,153,153));
        }*/
    }//GEN-LAST:event_departureDateFocusLost

    private void departureDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departureDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departureDateActionPerformed

    private void departureTimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_departureTimeFocusGained
        /*if (departureTime.getText().equals("  Departure Time")){
            departureTime.setText("");
            departureTime.setForeground(new Color(153,153,153));
        }*/
    }//GEN-LAST:event_departureTimeFocusGained

    private void departureTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_departureTimeFocusLost
        /*if (departureTime.getText().equals("")){
            departureTime.setText("  Departure Time");
            departureTime.setForeground(new Color(153,153,153));
        }*/
    }//GEN-LAST:event_departureTimeFocusLost

    private void fareFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fareFocusGained
        /*if (fare.getText().equals("  Price")){
            fare.setText("");
            fare.setForeground(new Color(153,153,153));
        }*/
    }//GEN-LAST:event_fareFocusGained

    private void fareFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fareFocusLost
        /*if (fare.getText().equals("")){
            fare.setText("  Price");
            fare.setForeground(new Color(153,153,153));
        }*/
    }//GEN-LAST:event_fareFocusLost

    private void flyingFromFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_flyingFromFocusGained
        /*if (flyingFrom.getText().equals("  Flying from")){
            flyingFrom.setText("");
            flyingFrom.setForeground(new Color(153,153,153));
        }*/
    }//GEN-LAST:event_flyingFromFocusGained

    private void flyingFromFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_flyingFromFocusLost
        /*if (flyingFrom.getText().equals("")){
            flyingFrom.setText("  Flying from");
            flyingFrom.setForeground(new Color(153,153,153));
        }*/
    }//GEN-LAST:event_flyingFromFocusLost

    private void arrivalDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_arrivalDateFocusGained
        /*if (arrivalDate.getText().equals("  Arrival")){
            arrivalDate.setText("");
            arrivalDate.setForeground(new Color(153,153,153));
        }*/
    }//GEN-LAST:event_arrivalDateFocusGained

    private void arrivalDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_arrivalDateFocusLost
        /*if (arrivalDate.getText().equals("")){
            arrivalDate.setText("  Arrival");
            arrivalDate.setForeground(new Color(153,153,153));
        }*/
    }//GEN-LAST:event_arrivalDateFocusLost

    private void arrivalTimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_arrivalTimeFocusGained
        /*if (arrivalTime.getText().equals("  Arrival Time")){
            arrivalTime.setText("");
            arrivalTime.setForeground(new Color(153,153,153));
        }*/
    }//GEN-LAST:event_arrivalTimeFocusGained

    private void arrivalTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_arrivalTimeFocusLost
        /*if (arrivalTime.getText().equals("")){
            arrivalTime.setText("  Arrival Time");
            arrivalTime.setForeground(new Color(153,153,153));
        }*/
    }//GEN-LAST:event_arrivalTimeFocusLost

    private void FlyingToFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FlyingToFocusGained
        /*if (FlyingTo.getText().equals("  Flying to")){
            FlyingTo.setText("");
            FlyingTo.setForeground(new Color(153,153,153));
        }*/
    }//GEN-LAST:event_FlyingToFocusGained

    private void FlyingToFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FlyingToFocusLost
        /*if (FlyingTo.getText().equals("")){
            FlyingTo.setText("  Flying to");
            FlyingTo.setForeground(new Color(153,153,153));
        }*/
    }//GEN-LAST:event_FlyingToFocusLost

    private void seatsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_seatsFocusGained
        /*if (seats.getText().equals("  Seats")){
            seats.setText("");
            seats.setForeground(new Color(153,153,153));
        }*/
    }//GEN-LAST:event_seatsFocusGained

    private void seatsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_seatsFocusLost
        /*if (seats.getText().equals("")){
            seats.setText("  Seats");
            seats.setForeground(new Color(153,153,153));
        }*/
    }//GEN-LAST:event_seatsFocusLost

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked

        dbConnector dbc = new dbConnector();

        if (departureDate.getText().isEmpty() || departureTime.getText().isEmpty() || arrivalDate.getText().isEmpty() || arrivalTime.getText().isEmpty()
            || flyingFrom.getText().isEmpty() || FlyingTo.getText().isEmpty()
            || fare.getText().isEmpty() || seats.getText().isEmpty()){

            if (departureTime.getText().isEmpty()){
                departureTime.setBorder(border);
                departureTimeWarning.setText("You cant leave this empty");
            } else {
                departureTimeWarning.setText(" ");
                departureTime.setBorder(defaultBorder);
            }

            if (arrivalTime.getText().isEmpty()){
                arrivalTime.setBorder(border);
                arrivalTimeWarning.setText("You cant leave this empty");
            } else {
                arrivalTimeWarning.setText(" ");
                arrivalTime.setBorder(defaultBorder);
            }

            if (fare.getText().isEmpty()){
                fare.setBorder(border);
                fareWarning.setText("You cant leave this empty");
            } else {
                fare.setBorder(defaultBorder);
                fareWarning.setText(" ");
            }

            if (seats.getText().isEmpty()){
                seats.setBorder(border);
                seatsWarning.setText("You cant leave this empty");
            } else {
                seats.setBorder(defaultBorder);
                seatsWarning.setText(" ");
            }

            if (flyingFrom.getText().isEmpty()){
                flyingFrom.setBorder(border);
                flyingFromWarning.setText("You cant leave this empty");
            } else {
                flyingFrom.setBorder(defaultBorder);
                flyingFromWarning.setText(" ");
            }

            if (FlyingTo.getText().isEmpty()){
                FlyingTo.setBorder(border);
                flyingToWarning.setText("You cant leave this empty");
            } else {
                FlyingTo.setBorder(defaultBorder);
                flyingToWarning.setText(" ");
            }
        } else if (!isValidTime(arrivalTime.getText())){
            
            if (!isValidTime(arrivalTime.getText())){
                arrivalTime.setBorder(border);
                arrivalTimeWarning.setText("Please follow the time format '12:00 pm'");
                
            } else {
                arrivalTime.setBorder(defaultBorder);
                arrivalTimeWarning.setText(" ");
                
            }

        } else if (!isValidTime(departureTime.getText())){
            if (!isValidTime(departureTime.getText())){
                departureTime.setBorder(border);
                departureTimeWarning.setText("Please follow the time format '12:00 pm'");
                
            } else {
                departureTime.setBorder(defaultBorder);
                departureTimeWarning.setText(" ");
                
            }
        }
        else if (!isInteger(fare.getText()) || !isInteger(seats.getText())) {
            if (!isInteger(fare.getText())){
                fare.setBorder(border);
                fareWarning.setText("Invalid Input");
            } else {
                fare.setBorder(defaultBorder);
                fareWarning.setText(" ");
            }

            if (!isInteger(seats.getText())){
                seats.setBorder(border);
                seatsWarning.setText("Invalid Input");
            } else {
                fare.setBorder(defaultBorder);
                seatsWarning.setText(" ");
            }
        } else {
            
            try{
                String query = "SELECT * FROM airlines WHERE Airline = '"+ airlines.getSelectedItem() +"'";
                ResultSet resultSet = dbc.getData(query);

                if (resultSet.next()){
                    airlineId = resultSet.getInt("Id");
                } 
                if (airlineId == 0){
                    JOptionPane.showMessageDialog(this, "Please select an airline");
                } else {
                     System.out.println("airline " + airlineId);
                     System.out.println("flight "+ flightId);
            dbc.updateData("UPDATE flights_table SET Departure = '"+ departureDate.getText() +"', Departure_Time = '"+ departureTime.getText() +"', Arrival = '"+ arrivalDate.getText() +"', "
                + "Arrival_time = '"+ arrivalTime.getText() +"', Flying_From = '"+ flyingFrom.getText() +"', Flying_To = '"+ FlyingTo.getText()+"',"
                        + " airline_Id = '"+ airlineId +"',Price = '"+ fare.getText() +"', Seats = '"+ seats.getText() +"' WHERE flight_Id = '"+ flightId +"'");
                }
                this.dispose();
            }catch (SQLException ex) {
                System.out.println(ex);
            }
        }
       
    }//GEN-LAST:event_addButtonMouseClicked

    private void addButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMousePressed
        addButton.setBackground(new Color(70,194,99));
    }//GEN-LAST:event_addButtonMousePressed

    private void addButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseReleased
        addButton.setBackground(new Color(83,215,105));
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

    private void airlinesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_airlinesMouseClicked

    }//GEN-LAST:event_airlinesMouseClicked

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
            java.util.logging.Logger.getLogger(editFlights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editFlights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editFlights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editFlights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editFlights().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField FlyingTo;
    private panelRoundComponents.PanelRound addButton;
    public combo_suggestion.ComboBoxSuggestion airlines;
    private com.raven.datechooser.DateChooser arrival;
    public javax.swing.JTextField arrivalDate;
    private javax.swing.JLabel arrivalDateWarning;
    public javax.swing.JTextField arrivalTime;
    private javax.swing.JLabel arrivalTimeWarning;
    private panelRoundComponents.PanelRound cancelButton;
    private com.raven.datechooser.DateChooser departure;
    public javax.swing.JTextField departureDate;
    private javax.swing.JLabel departureDateWarning;
    public javax.swing.JTextField departureTime;
    private javax.swing.JLabel departureTimeWarning;
    public javax.swing.JTextField fare;
    private javax.swing.JLabel fareWarning;
    public javax.swing.JTextField flyingFrom;
    private javax.swing.JLabel flyingFromWarning;
    private javax.swing.JLabel flyingToWarning;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private panelRoundComponents.PanelRound panelRound1;
    public javax.swing.JTextField seats;
    private javax.swing.JLabel seatsWarning;
    // End of variables declaration//GEN-END:variables
}
