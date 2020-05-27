/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports_format;

import chefguru.CashierDashboard;
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

/**
 *
 * @author sanda
 */
public class Food_Bill extends javax.swing.JFrame {

    /**
     * Creates new form Guest_Information_Report
     */
    
    Connection conn = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    
    String inv_no;
    String food_amount;
    String food_cash;
    String food_change;
    
    DBConnection obj = DBConnection.getDb();
    
    public Food_Bill() {
        initComponents();
    }
    
    public Food_Bill(String food_amount, String food_cash, String food_change) {
        initComponents();
        
        upper_date.setText(new CashierDashboard().dateForReport());
        
        this.inv_no = inv_no;
        this.food_amount = food_amount;
        this.food_cash = food_cash;
        this.food_change = food_change;
        
        viewBillDetails();
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
        close_btn = new javax.swing.JButton();
        print_btn = new javax.swing.JButton();
        report_pane = new javax.swing.JPanel();
        upper_line = new javax.swing.JPanel();
        middle_line = new javax.swing.JPanel();
        lower_line = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        heading = new javax.swing.JLabel();
        date_label = new javax.swing.JLabel();
        upper_date = new javax.swing.JLabel();
        thank_you = new javax.swing.JLabel();
        invoice_no_label = new javax.swing.JLabel();
        total_balance_label = new javax.swing.JLabel();
        cash_label = new javax.swing.JLabel();
        change_label = new javax.swing.JLabel();
        invoice_no = new javax.swing.JLabel();
        total_balance = new javax.swing.JLabel();
        cash = new javax.swing.JLabel();
        change = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(102, 0, 0));

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
            .addGap(0, 3, Short.MAX_VALUE)
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

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N

        address.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        address.setText("<html><center>Sri Sangharaja Piriwena Road,<br>Lower Kahattewela,<br>Bandarawela 90100,<br>Sri Lanka<br>Tel: +94 57 22 30 500<br>Email: mevangurusinghe2@gmail.com</center></html>");

        heading.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading.setText("Food Bill");

        date_label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        date_label.setText("Date:");

        upper_date.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N

        thank_you.setFont(new java.awt.Font("Cambria Math", 0, 12)); // NOI18N
        thank_you.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thank_you.setText("Thank You!");

        invoice_no_label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        invoice_no_label.setText("Invoice No:");

        total_balance_label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        total_balance_label.setText("Total Balance:");

        cash_label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cash_label.setText("Cash:");

        change_label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        change_label.setText("Change:");

        invoice_no.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N

        total_balance.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N

        cash.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N

        change.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N

        javax.swing.GroupLayout report_paneLayout = new javax.swing.GroupLayout(report_pane);
        report_pane.setLayout(report_paneLayout);
        report_paneLayout.setHorizontalGroup(
            report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(report_paneLayout.createSequentialGroup()
                .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(report_paneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lower_line, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, report_paneLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(date_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(upper_date, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(middle_line, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(upper_line, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(heading, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thank_you, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(report_paneLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, report_paneLayout.createSequentialGroup()
                .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(report_paneLayout.createSequentialGroup()
                        .addGap(0, 147, Short.MAX_VALUE)
                        .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(change_label, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cash_label, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(change, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(cash, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                    .addGroup(report_paneLayout.createSequentialGroup()
                        .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(report_paneLayout.createSequentialGroup()
                                .addGap(40, 121, Short.MAX_VALUE)
                                .addComponent(invoice_no_label))
                            .addGroup(report_paneLayout.createSequentialGroup()
                                .addGap(0, 101, Short.MAX_VALUE)
                                .addComponent(total_balance_label)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(total_balance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(invoice_no, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))))
                .addGap(75, 75, 75))
        );
        report_paneLayout.setVerticalGroup(
            report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(report_paneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(upper_line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(date_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(upper_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(middle_line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(heading)
                .addGap(18, 18, 18)
                .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(invoice_no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(invoice_no_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total_balance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(total_balance_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cash_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(report_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(change, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(change_label, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addGap(72, 72, 72)
                .addComponent(lower_line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thank_you)
                .addContainerGap())
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(print_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(close_btn)
                .addContainerGap(340, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(report_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(print_btn)
                    .addComponent(close_btn))
                .addContainerGap(709, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                    .addContainerGap(59, Short.MAX_VALUE)
                    .addComponent(report_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(Food_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Food_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Food_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Food_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Food_Bill().setVisible(true);
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
                graphics2D.scale(0.5, 0.5);
                
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
    
    public void viewBillDetails(){
        
        conn = obj.connect();
        
        try {
                cs = conn.prepareCall("{CALL `lastBillId`()}");
                rs = cs.executeQuery();
                
                while(rs.next()){
                    inv_no = rs.getString("lastBillId");
                }

            } catch (SQLException e) {
                new ErrorMsg().showErr(e.getMessage());
                //JOptionPane.showMessageDialog(null, e.getMessage());
            }
        
        conn = null;
        
        invoice_no.setText(inv_no);
        total_balance.setText(food_amount);
        
        cash.setText(food_cash);
        change.setText(food_change);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JPanel background;
    private javax.swing.JLabel cash;
    private javax.swing.JLabel cash_label;
    private javax.swing.JLabel change;
    private javax.swing.JLabel change_label;
    private javax.swing.JButton close_btn;
    private javax.swing.JLabel date_label;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel invoice_no;
    private javax.swing.JLabel invoice_no_label;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel lower_line;
    private javax.swing.JPanel middle_line;
    private javax.swing.JButton print_btn;
    private javax.swing.JPanel report_pane;
    private javax.swing.JLabel thank_you;
    private javax.swing.JLabel total_balance;
    private javax.swing.JLabel total_balance_label;
    private javax.swing.JLabel upper_date;
    private javax.swing.JPanel upper_line;
    // End of variables declaration//GEN-END:variables
}
