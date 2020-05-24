/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports_format;

import chefguru.AdminDashboard;
import chefguru.ErrorMsg;
import dbconnection.DBConnection;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author sanda
 */
public class Room_Information_Report extends javax.swing.JFrame {

    /**
     * Creates new form Guest_Information_Report
     */
    
    Connection conn = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    
    DBConnection obj = DBConnection.getDb();
    
    public Room_Information_Report() {
        initComponents();
        
        upper_date.setText(new AdminDashboard().dateForUse());
        
        viewRoomDetails();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        report_scrollpane = new javax.swing.JScrollPane();
        report_pane = new javax.swing.JPanel();
        upper_line = new javax.swing.JPanel();
        middle_line = new javax.swing.JPanel();
        lower_line = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        heading = new javax.swing.JLabel();
        date_label = new javax.swing.JLabel();
        upper_date = new javax.swing.JLabel();
        note = new javax.swing.JLabel();
        table_scrollpane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        date_line = new javax.swing.JLabel();
        signature_line = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        signature = new javax.swing.JLabel();
        close_btn = new javax.swing.JButton();
        print_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(102, 0, 0));

        report_pane.setBackground(new java.awt.Color(255, 255, 255));
        report_pane.setPreferredSize(new java.awt.Dimension(570, 730));

        upper_line.setBackground(new java.awt.Color(102, 0, 0));

        javax.swing.GroupLayout upper_lineLayout = new javax.swing.GroupLayout(upper_line);
        upper_line.setLayout(upper_lineLayout);
        upper_lineLayout.setHorizontalGroup(
            upper_lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        upper_lineLayout.setVerticalGroup(
            upper_lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        middle_line.setBackground(new java.awt.Color(102, 0, 0));

        javax.swing.GroupLayout middle_lineLayout = new javax.swing.GroupLayout(middle_line);
        middle_line.setLayout(middle_lineLayout);
        middle_lineLayout.setHorizontalGroup(
            middle_lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        middle_lineLayout.setVerticalGroup(
            middle_lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        lower_line.setBackground(new java.awt.Color(102, 0, 0));

        javax.swing.GroupLayout lower_lineLayout = new javax.swing.GroupLayout(lower_line);
        lower_line.setLayout(lower_lineLayout);
        lower_lineLayout.setHorizontalGroup(
            lower_lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        lower_lineLayout.setVerticalGroup(
            lower_lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo_small.png"))); // NOI18N

        address.setFont(new java.awt.Font("Cambria Math", 0, 11)); // NOI18N
        address.setText("<html>Sri Sangharaja Piriwena Road,<br>Lower Kahattewela,<br>Bandarawela 90100,<br>Sri Lanka<br>Tel: +94 57 22 30 500<br>Email: mevangurusinghe2@gmail.com<html>");

        heading.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading.setText("Room Information Report");

        date_label.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        date_label.setText("Date:");

        upper_date.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        note.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        note.setText("Note");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Room Type", "Status"
            }
        ));
        table.setGridColor(new java.awt.Color(102, 0, 0));
        table.setRowHeight(20);
        table_scrollpane.setViewportView(table);

        date_line.setText("__________________");

        signature_line.setText("__________________");

        date.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date.setText("Date");

        signature.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        signature.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signature.setText("Signature");

        javax.swing.GroupLayout report_paneLayout = new javax.swing.GroupLayout(report_pane);
        report_pane.setLayout(report_paneLayout);
        report_paneLayout.setHorizontalGroup(
            report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(report_paneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lower_line, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(middle_line, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(upper_line, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, report_paneLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addGroup(report_paneLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(table_scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heading, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
                .addGap(38, 38, 38))
            .addGroup(report_paneLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(date_line, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(signature_line, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(78, 78, 78))
            .addGroup(report_paneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(note)
                    .addGroup(report_paneLayout.createSequentialGroup()
                        .addComponent(date_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upper_date, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        report_paneLayout.setVerticalGroup(
            report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(report_paneLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(upper_line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(report_paneLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(report_paneLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(logo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(middle_line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(date_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(upper_date, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(table_scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date_line)
                    .addComponent(signature_line))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date)
                    .addComponent(signature))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lower_line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(note)
                .addGap(31, 31, 31))
        );

        report_scrollpane.setViewportView(report_pane);

        close_btn.setBackground(new java.awt.Color(255, 96, 92));
        close_btn.setForeground(new java.awt.Color(255, 255, 255));
        close_btn.setText("Close");
        close_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_btnActionPerformed(evt);
            }
        });

        print_btn.setBackground(new java.awt.Color(0, 202, 78));
        print_btn.setForeground(new java.awt.Color(255, 255, 255));
        print_btn.setText("Print");
        print_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(print_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(close_btn)
                .addContainerGap(440, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(report_scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(print_btn)
                    .addComponent(close_btn))
                .addContainerGap(541, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                    .addGap(0, 44, Short.MAX_VALUE)
                    .addComponent(report_scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void print_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_btnActionPerformed
        printRecord(report_pane);
    }//GEN-LAST:event_print_btnActionPerformed

    private void close_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_btnActionPerformed
        this.dispose();
    }//GEN-LAST:event_close_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Room_Information_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Room_Information_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Room_Information_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Room_Information_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Room_Information_Report().setVisible(true);
            }
        });
    }
    
    private void printRecord(JPanel panel){
        // Create PrinterJob Here
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        // Set Printer Job Name
        printerJob.setJobName("Print Record");
        // Set Printable
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                // Check If No Printable Content
                if(pageIndex > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                // Make 2D Graphics to map content
                Graphics2D graphics2D = (Graphics2D)graphics;
                // Set Graphics Translations
                // A Little Correction here Multiplication was not working so I replaced with addition
                graphics2D.translate(pageFormat.getImageableX()+10, pageFormat.getImageableY()+10);
                // This is a page scale. Default should be 0.3 I am using 0.5
                graphics2D.scale(1, 1);
                
                // Now paint panel as graphics2D
                panel.paint(graphics2D);
                
                // return if page exists
                return Printable.PAGE_EXISTS;
            }
        });
        // Store printerDialog as boolean
        boolean returningResult = printerJob.printDialog();
        // check if dilog is showing
        if(returningResult){
            // Use try catch exeption for failure
            try{
                // Now call print method inside printerJob to print
                printerJob.print();
            }catch (PrinterException printerException){
                JOptionPane.showMessageDialog(this, "Print Error: " + printerException.getMessage());
            }
        }
        
        this.dispose();
    }
    
    public void viewRoomDetails(){
        
        conn = obj.connect();
        
        try {
                cs = conn.prepareCall("{CALL `viewRoomDetails`()}");
                rs = cs.executeQuery();

                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (SQLException e) {
                new ErrorMsg().showErr(e.getMessage());
                //JOptionPane.showMessageDialog(null, e.getMessage());
            }
        
        conn = null;
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JPanel background;
    private javax.swing.JButton close_btn;
    private javax.swing.JLabel date;
    private javax.swing.JLabel date_label;
    private javax.swing.JLabel date_line;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel lower_line;
    private javax.swing.JPanel middle_line;
    private javax.swing.JLabel note;
    private javax.swing.JButton print_btn;
    private javax.swing.JPanel report_pane;
    private javax.swing.JScrollPane report_scrollpane;
    private javax.swing.JLabel signature;
    private javax.swing.JLabel signature_line;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane table_scrollpane;
    private javax.swing.JLabel upper_date;
    private javax.swing.JPanel upper_line;
    // End of variables declaration//GEN-END:variables
}