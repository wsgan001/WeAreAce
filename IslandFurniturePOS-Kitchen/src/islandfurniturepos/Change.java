/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package islandfurniturepos;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sessionbean.km.KitchenOrderEntity;

/**
 *
 * @author hangsun
 */
public class Change extends javax.swing.JFrame {

    private String POSid;
    private String storeStaffId;
    private Long orderId;
    private Double moneyChange;
    private String partnerPoleDisplayCOMPort = "COM5";
    private OutputStream partnerPoleDisplayOutputStream;
    SerialPort serialPort;

    /**
     * Creates new form Change
     */
    public Change() {
        initComponents();
    }

    public Change(String POSid, String storeStaffId, Long orderId) {
        this();

        this.POSid = POSid;
        this.storeStaffId = storeStaffId;
        this.orderId = orderId;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTitle = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelThanks = new javax.swing.JLabel();
        jLabelMoneyChange = new javax.swing.JLabel();
        jLabelChange = new javax.swing.JLabel();
        jButtonGoBackToMain = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanelTitle.setBackground(new java.awt.Color(255, 51, 51));
        jPanelTitle.setPreferredSize(new java.awt.Dimension(647, 119));

        jLabelTitle.setFont(new java.awt.Font("New Peninim MT", 3, 48)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setText("     Island Furniture POS");
        jLabelTitle.setToolTipText("");
        jLabelTitle.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelThanks.setFont(new java.awt.Font("Times", 3, 24)); // NOI18N
        jLabelThanks.setText("Thank you for shopping with us!");

        jLabelMoneyChange.setFont(new java.awt.Font("Times", 3, 18)); // NOI18N
        jLabelMoneyChange.setText("Change : (S$)");

        jLabelChange.setFont(new java.awt.Font("Times", 3, 18)); // NOI18N
        jLabelChange.setText("Change");

        jButtonGoBackToMain.setBackground(new java.awt.Color(255, 255, 255));
        jButtonGoBackToMain.setFont(new java.awt.Font("Times", 3, 18)); // NOI18N
        jButtonGoBackToMain.setText("Go Back to Main");
        jButtonGoBackToMain.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonGoBackToMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoBackToMainActionPerformed(evt);
            }
        });

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/singapore-logo0.1.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelLogo))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelThanks)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelMoneyChange)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelChange, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jButtonGoBackToMain, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelLogo)
                .addGap(19, 19, 19)
                .addComponent(jLabelThanks)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMoneyChange, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelChange, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButtonGoBackToMain)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

        KitchenOrderEntity order = findOrderById(orderId);
        moneyChange = order.getDue();
        jLabelChange.setText(Double.toString(moneyChange));
//        initPartnerPoleDisplay();
//        poleDisplay(moneyChange);


    }//GEN-LAST:event_formWindowOpened

    private void jButtonGoBackToMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoBackToMainActionPerformed
        // TODO add your handling code here:
        jLabelChange.setText("");

        closePort();
        this.setVisible(false);
        this.dispose();

        MainMenu mainMenu = new MainMenu(POSid, storeStaffId);
        mainMenu.setVisible(true);
        mainMenu.setExtendedState(JFrame.NORMAL);

    }//GEN-LAST:event_jButtonGoBackToMainActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:

        if (serialPort != null) {
            try {
                byte[] clear = {0x0C};
                partnerPoleDisplayOutputStream.write(clear);
                partnerPoleDisplayOutputStream.close();
                serialPort.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(Change.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Change.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Change.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Change.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Change().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGoBackToMain;
    private javax.swing.JLabel jLabelChange;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelMoneyChange;
    private javax.swing.JLabel jLabelThanks;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelTitle;
    // End of variables declaration//GEN-END:variables

    private void initPartnerPoleDisplay() {
        Enumeration commPortList = CommPortIdentifier.getPortIdentifiers();

        while (commPortList.hasMoreElements()) {
            CommPortIdentifier commPort = (CommPortIdentifier) commPortList.nextElement();

            if (commPort.getPortType() == CommPortIdentifier.PORT_SERIAL
                    && commPort.getName().equals(partnerPoleDisplayCOMPort)) {
                try {
                    serialPort = (SerialPort) commPort.open("UnifiedPointOfSale", 5000);
                    partnerPoleDisplayOutputStream = serialPort.getOutputStream();
                } catch (PortInUseException ex) {
                    JOptionPane.showMessageDialog(null, "Unable to initialize Partner Pole Display: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Unable to initialize Partner Pole Display: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void poleDisplay(Double moneyChange) {
        byte[] clear = {0x0C};
        byte[] newLine = {0x0A};
        byte[] carriageReturn = {0x0D};
        byte[] message1 = new String("Thank You!").getBytes();
        byte[] message2 = new String("Your Change: S$ " + String.valueOf(moneyChange)).getBytes();

        try {
            partnerPoleDisplayOutputStream.write(clear);
            partnerPoleDisplayOutputStream.write(message1);
            partnerPoleDisplayOutputStream.write(newLine);
            partnerPoleDisplayOutputStream.write(carriageReturn);
            partnerPoleDisplayOutputStream.write(message2);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Unable to write to Partner Pole Display: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void closePort() {
        System.err.println("Window closed");
        if (serialPort != null) {
            try {
                byte[] clear = {0x0C};
                partnerPoleDisplayOutputStream.write(clear);
                partnerPoleDisplayOutputStream.close();
                serialPort.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    private static KitchenOrderEntity findOrderById(java.lang.Long arg0) {
        sessionbean.km.CustomerOrderFulfillmentModuleService service = new sessionbean.km.CustomerOrderFulfillmentModuleService();
        sessionbean.km.CustomerOrderFulfillmentModule port = service.getCustomerOrderFulfillmentModulePort();
        return port.findOrderById(arg0);
    }

}
