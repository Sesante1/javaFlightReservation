    
package admins;

import config.dbConnector;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;


public class reportsBody extends javax.swing.JPanel {

    public reportsBody() {
        initComponents();
        //init();
        //displayBookedFlights();
        airlineList();
        todaysFlight();
        departedToday();
        flightsArrived();
        totalFlight();
        airlineTotal();
    }
    
    public void totalBookedFlights(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT COUNT(*) AS NROWS FROM flights_table");
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt("NROWS");
            }
            totalBooked.setText(""+rowCount);
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
    
    public void airlineTotal(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT COUNT(*) AS NROWS FROM airlines");
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt("NROWS");
            }
            totalAirline.setText(""+rowCount);
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
    
    public void totalFlight(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT COUNT(*) AS NROWS FROM flights_table");
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt("NROWS");
            }
            totalFlight.setText(""+rowCount);
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
    
    public void flightsArrived(){
        try {
            dbConnector dbc = new dbConnector();
            String query = "SELECT flights_table.Flight_Id, flights_table.Arrival, flights_table.Departure, " +
                           "flights_table.Flying_To, flights_table.Flying_From, airlines.Airline " +
                           "FROM airlines " +
                           "INNER JOIN flights_table ON airlines.Id = flights_table.airline_Id " +
                           "WHERE flights_table.Status = 'Arrived'";
            ResultSet rs = dbc.getData(query);
            flightsArrived.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
    }
    
    public void departedToday(){
        //ResultSet rs = dbc.getData("SELECT Flight_Id, Arrival, Departure, Flying_To, Flying_From, Airline FROM flights_table WHERE Status = '"+ "Departed" +"'");
        try {
            dbConnector dbc = new dbConnector();
            String query = "SELECT flights_table.Flight_Id, flights_table.Arrival, flights_table.Departure, " +
                           "flights_table.Flying_To, flights_table.Flying_From, airlines.Airline " +
                           "FROM airlines " +
                           "INNER JOIN flights_table ON airlines.Id = flights_table.airline_Id " +
                           "WHERE flights_table.Status = 'Departed'";
            ResultSet rs = dbc.getData(query);
            flightsDeparted.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
    }
    
    public void todaysFlight(){
        try {
            dbConnector dbc = new dbConnector();
            String query = "SELECT flights_table.Flight_Id, flights_table.Arrival, flights_table.Departure, " +
                           "flights_table.Flying_To, flights_table.Flying_From, airlines.Airline " +
                           "FROM airlines " +
                           "INNER JOIN flights_table ON airlines.Id = flights_table.airline_Id";
            ResultSet rs = dbc.getData(query);
            todaysFlight.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
    }
    
    public void airlineList(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT * FROM airlines");
            airlineList.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }

    private void init(){
        todaysFlight.fixTable(jScrollPane1);
        flightsDeparted.fixTable(jScrollPane1);
    }
    
    public void displayDatas(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT * FROM users_table");
            todaysFlight.setModel(DbUtils.resultSetToTableModel(rs)); 
            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
    
    public void displayBookedFlights(){
        try{
            dbConnector dbc = new dbConnector();
                ResultSet rs = dbc.getData("SELECT customer_table.First_Name, customer_table.Last_Name, flights_table.Departure, flights_table.Arrival, flights_table.Airline "
                        + "FROM customer_table  "
                        + "INNER JOIN flights_table ON customer_table.Flight_Id = flights_table.Flight_Id ");
            bookedFlights.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        }catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new panelRoundComponents.RoundPanel();
        lbDescription = new javax.swing.JLabel();
        totalAirline = new javax.swing.JLabel();
        roundPanel2 = new panelRoundComponents.RoundPanel();
        lbDescription1 = new javax.swing.JLabel();
        totalBooked = new javax.swing.JLabel();
        roundPanel5 = new panelRoundComponents.RoundPanel();
        jScrollPane1 = new scrollPane.ScrollPaneWin11();
        todaysFlight = new table.Table();
        jLabel5 = new javax.swing.JLabel();
        departButton = new panelRoundComponents.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        roundPanel6 = new panelRoundComponents.RoundPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new scrollPane.ScrollPaneWin11();
        flightsDeparted = new table.Table();
        arrivedButton = new panelRoundComponents.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        roundPanel8 = new panelRoundComponents.RoundPanel();
        jScrollPane4 = new scrollPane.ScrollPaneWin11();
        bookedFlights = new table.Table();
        jLabel8 = new javax.swing.JLabel();
        roundPanel3 = new panelRoundComponents.RoundPanel();
        lbDescription2 = new javax.swing.JLabel();
        totalFlight = new javax.swing.JLabel();
        roundPanel4 = new panelRoundComponents.RoundPanel();
        income = new javax.swing.JLabel();
        lbDescription3 = new javax.swing.JLabel();
        roundPanel9 = new panelRoundComponents.RoundPanel();
        jScrollPane5 = new scrollPane.ScrollPaneWin11();
        airlineList = new table.Table();
        jLabel12 = new javax.swing.JLabel();
        deleteButton2 = new panelRoundComponents.PanelRound();
        jLabel13 = new javax.swing.JLabel();
        updateButton2 = new panelRoundComponents.PanelRound();
        jLabel14 = new javax.swing.JLabel();
        roundPanel10 = new panelRoundComponents.RoundPanel();
        jScrollPane6 = new scrollPane.ScrollPaneWin11();
        flightsArrived = new table.Table();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 245, 245));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setRound(15);

        lbDescription.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDescription.setForeground(new java.awt.Color(153, 153, 153));
        lbDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDescription.setText("Available Airlines");

        totalAirline.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        totalAirline.setForeground(new java.awt.Color(128, 128, 128));
        totalAirline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalAirline.setText(" 0");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(totalAirline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalAirline)
                .addGap(18, 18, 18)
                .addComponent(lbDescription)
                .addContainerGap())
        );

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel2.setRound(15);

        lbDescription1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDescription1.setForeground(new java.awt.Color(153, 153, 153));
        lbDescription1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDescription1.setText("Total Booked");

        totalBooked.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        totalBooked.setForeground(new java.awt.Color(128, 128, 128));
        totalBooked.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalBooked.setText(" 0");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescription1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(totalBooked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalBooked)
                .addGap(18, 18, 18)
                .addComponent(lbDescription1)
                .addContainerGap())
        );

        roundPanel5.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel5.setRound(10);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        todaysFlight.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        todaysFlight.setForeground(new java.awt.Color(153, 153, 153));
        todaysFlight.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        todaysFlight.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        todaysFlight.setShowVerticalLines(false);
        jScrollPane1.setViewportView(todaysFlight);

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Today's Flight");

        departButton.setBackground(new java.awt.Color(91, 164, 252));
        departButton.setToolTipText("Add");
        departButton.setRoundBottomLeft(10);
        departButton.setRoundBottomRight(10);
        departButton.setRoundTopLeft(10);
        departButton.setRoundTopRight(10);
        departButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                departButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                departButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                departButtonMouseReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Departed");

        javax.swing.GroupLayout departButtonLayout = new javax.swing.GroupLayout(departButton);
        departButton.setLayout(departButtonLayout);
        departButtonLayout.setHorizontalGroup(
            departButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );
        departButtonLayout.setVerticalGroup(
            departButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(roundPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(departButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel6.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel6.setRound(10);

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Flight's Departed Today");

        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jScrollPane3.setOpaque(false);

        flightsDeparted.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        flightsDeparted.setForeground(new java.awt.Color(153, 153, 153));
        flightsDeparted.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        flightsDeparted.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        flightsDeparted.setOpaque(false);
        flightsDeparted.setShowVerticalLines(false);
        jScrollPane3.setViewportView(flightsDeparted);

        arrivedButton.setBackground(new java.awt.Color(252, 61, 57));
        arrivedButton.setToolTipText("Delete");
        arrivedButton.setRoundBottomLeft(10);
        arrivedButton.setRoundBottomRight(10);
        arrivedButton.setRoundTopLeft(10);
        arrivedButton.setRoundTopRight(10);
        arrivedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrivedButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                arrivedButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                arrivedButtonMouseReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Arrived");

        javax.swing.GroupLayout arrivedButtonLayout = new javax.swing.GroupLayout(arrivedButton);
        arrivedButton.setLayout(arrivedButtonLayout);
        arrivedButtonLayout.setHorizontalGroup(
            arrivedButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );
        arrivedButtonLayout.setVerticalGroup(
            arrivedButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roundPanel6Layout = new javax.swing.GroupLayout(roundPanel6);
        roundPanel6.setLayout(roundPanel6Layout);
        roundPanel6Layout.setHorizontalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
                    .addGroup(roundPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(arrivedButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel6Layout.setVerticalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arrivedButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        roundPanel8.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel8.setRound(10);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        bookedFlights.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bookedFlights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        bookedFlights.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bookedFlights.setShowVerticalLines(false);
        jScrollPane4.setViewportView(bookedFlights);

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Booked Flights");

        javax.swing.GroupLayout roundPanel8Layout = new javax.swing.GroupLayout(roundPanel8);
        roundPanel8.setLayout(roundPanel8Layout);
        roundPanel8Layout.setHorizontalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
                    .addComponent(jLabel8))
                .addContainerGap())
        );
        roundPanel8Layout.setVerticalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel3.setRound(15);

        lbDescription2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDescription2.setForeground(new java.awt.Color(153, 153, 153));
        lbDescription2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDescription2.setText("Total Flight");

        totalFlight.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        totalFlight.setForeground(new java.awt.Color(128, 128, 128));
        totalFlight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalFlight.setText(" 0");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescription2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(totalFlight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(totalFlight)
                .addGap(18, 18, 18)
                .addComponent(lbDescription2)
                .addContainerGap())
        );

        roundPanel4.setBackground(new java.awt.Color(255, 255, 255));

        income.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        income.setForeground(new java.awt.Color(128, 128, 128));
        income.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        income.setText(" 0");

        lbDescription3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDescription3.setForeground(new java.awt.Color(153, 153, 153));
        lbDescription3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDescription3.setText("Total Passengers");

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescription3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(income, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(income)
                .addGap(18, 18, 18)
                .addComponent(lbDescription3)
                .addContainerGap())
        );

        roundPanel9.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel9.setRound(10);

        jScrollPane5.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        airlineList.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        airlineList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        airlineList.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        airlineList.setShowVerticalLines(false);
        jScrollPane5.setViewportView(airlineList);

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Airline's");

        deleteButton2.setBackground(new java.awt.Color(252, 61, 57));
        deleteButton2.setToolTipText("Delete");
        deleteButton2.setRoundBottomLeft(10);
        deleteButton2.setRoundBottomRight(10);
        deleteButton2.setRoundTopLeft(10);
        deleteButton2.setRoundTopRight(10);
        deleteButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButton2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteButton2MouseReleased(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-18.png"))); // NOI18N

        javax.swing.GroupLayout deleteButton2Layout = new javax.swing.GroupLayout(deleteButton2);
        deleteButton2.setLayout(deleteButton2Layout);
        deleteButton2Layout.setHorizontalGroup(
            deleteButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );
        deleteButton2Layout.setVerticalGroup(
            deleteButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deleteButton2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        updateButton2.setBackground(new java.awt.Color(83, 215, 105));
        updateButton2.setToolTipText("Update");
        updateButton2.setRoundBottomLeft(10);
        updateButton2.setRoundBottomRight(10);
        updateButton2.setRoundTopLeft(10);
        updateButton2.setRoundTopRight(10);
        updateButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButton2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updateButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                updateButton2MouseReleased(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-update-18.png"))); // NOI18N

        javax.swing.GroupLayout updateButton2Layout = new javax.swing.GroupLayout(updateButton2);
        updateButton2.setLayout(updateButton2Layout);
        updateButton2Layout.setHorizontalGroup(
            updateButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateButton2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addContainerGap())
        );
        updateButton2Layout.setVerticalGroup(
            updateButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roundPanel9Layout = new javax.swing.GroupLayout(roundPanel9);
        roundPanel9.setLayout(roundPanel9Layout);
        roundPanel9Layout.setHorizontalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(roundPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel9Layout.setVerticalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        roundPanel10.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel10.setRound(10);

        jScrollPane6.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        flightsArrived.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        flightsArrived.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        flightsArrived.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        flightsArrived.setShowVerticalLines(false);
        jScrollPane6.setViewportView(flightsArrived);

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Flgiht's Arrived Today");

        javax.swing.GroupLayout roundPanel10Layout = new javax.swing.GroupLayout(roundPanel10);
        roundPanel10.setLayout(roundPanel10Layout);
        roundPanel10Layout.setHorizontalGroup(
            roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addComponent(jLabel9))
                .addContainerGap())
        );
        roundPanel10Layout.setVerticalGroup(
            roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(roundPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(roundPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(roundPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(roundPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void departButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departButtonMouseClicked
        
        dbConnector dbc = new dbConnector();
        
        String depart = "Departed";
        int rowIndex = todaysFlight.getSelectedRow();

        if (rowIndex < 0){
            JOptionPane.showMessageDialog(null, "Please select row to update");
        } else{
            TableModel tbl = todaysFlight.getModel();
            
            dbc.updateData("UPDATE flights_table SET Status = '"+ depart +"'WHERE Flight_Id = '"+tbl.getValueAt(rowIndex, 0)+"'");
            
            flightsArrived();
            departedToday();
        }
    }//GEN-LAST:event_departButtonMouseClicked

    private void departButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departButtonMousePressed
        departButton.setBackground(new Color(88,151,238));
    }//GEN-LAST:event_departButtonMousePressed

    private void departButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departButtonMouseReleased
        departButton.setBackground(new Color(91,164,252));
    }//GEN-LAST:event_departButtonMouseReleased

    private void deleteButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton2MouseClicked

    private void deleteButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton2MousePressed

    private void deleteButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton2MouseReleased

    private void updateButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton2MouseClicked

    private void updateButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButton2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton2MousePressed

    private void updateButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButton2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton2MouseReleased

    private void arrivedButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arrivedButtonMouseReleased
        arrivedButton.setBackground(new Color(252,61,57));
    }//GEN-LAST:event_arrivedButtonMouseReleased

    private void arrivedButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arrivedButtonMousePressed
        arrivedButton.setBackground(new Color(227,52,55));
    }//GEN-LAST:event_arrivedButtonMousePressed

    private void arrivedButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arrivedButtonMouseClicked
        dbConnector dbc = new dbConnector();
        
        String depart = "Arrived";
        int rowIndex = flightsDeparted.getSelectedRow();

        if (rowIndex < 0){
            JOptionPane.showMessageDialog(null, "Please select row to update");
        } else{
            TableModel tbl = flightsDeparted.getModel();
            
            dbc.updateData("UPDATE flights_table SET Status = '"+ depart +"'WHERE flight_Id = '"+tbl.getValueAt(rowIndex, 0)+"'");
            
            departedToday();
            flightsArrived();
        }
    }//GEN-LAST:event_arrivedButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private table.Table airlineList;
    private panelRoundComponents.PanelRound arrivedButton;
    private table.Table bookedFlights;
    private panelRoundComponents.PanelRound deleteButton2;
    private panelRoundComponents.PanelRound departButton;
    private table.Table flightsArrived;
    private table.Table flightsDeparted;
    private javax.swing.JLabel income;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lbDescription;
    private javax.swing.JLabel lbDescription1;
    private javax.swing.JLabel lbDescription2;
    private javax.swing.JLabel lbDescription3;
    private panelRoundComponents.RoundPanel roundPanel1;
    private panelRoundComponents.RoundPanel roundPanel10;
    private panelRoundComponents.RoundPanel roundPanel2;
    private panelRoundComponents.RoundPanel roundPanel3;
    private panelRoundComponents.RoundPanel roundPanel4;
    private panelRoundComponents.RoundPanel roundPanel5;
    private panelRoundComponents.RoundPanel roundPanel6;
    private panelRoundComponents.RoundPanel roundPanel8;
    private panelRoundComponents.RoundPanel roundPanel9;
    private table.Table todaysFlight;
    private javax.swing.JLabel totalAirline;
    private javax.swing.JLabel totalBooked;
    private javax.swing.JLabel totalFlight;
    private panelRoundComponents.PanelRound updateButton2;
    // End of variables declaration//GEN-END:variables
}
