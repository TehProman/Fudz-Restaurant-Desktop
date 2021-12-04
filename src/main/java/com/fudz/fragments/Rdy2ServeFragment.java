package com.fudz.fragments;

import com.fudz.custom.RoundedPanel;
import java.awt.Color;

/**
 *
 * @author Rene Tajos Jr.
 */
public class Rdy2ServeFragment extends RoundedPanel {

    /**
     * Creates new form Rdy2ServeFragment
     */
    public Rdy2ServeFragment() {
        bgColor = new Color(252,243,236);
        cornerRadius = 25;
        haveBorder = false;
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tableLbl = new javax.swing.JLabel();
        iconPanel = new javax.swing.JPanel();
        numLbl = new javax.swing.JLabel();
        dishIcon = new javax.swing.JLabel();
        readyTxtLbl = new javax.swing.JLabel();
        showOrdersBtn = new com.fudz.custom.RoundedPanel();
        showOrdersLbl = new javax.swing.JLabel();
        callWaiterBtn = new com.fudz.custom.RoundedPanel();
        callWaiterLbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(252, 243, 236));
        setMaximumSize(new java.awt.Dimension(192, 279));
        setMinimumSize(new java.awt.Dimension(192, 279));
        setName(""); // NOI18N

        tableLbl.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        tableLbl.setForeground(new java.awt.Color(135, 102, 0));
        tableLbl.setText("TABLE");

        iconPanel.setBackground(new java.awt.Color(252, 242, 230));
        iconPanel.setLayout(new java.awt.GridBagLayout());

        numLbl.setBackground(new java.awt.Color(135, 102, 0));
        numLbl.setFont(new java.awt.Font("Dubai Medium", 1, 48)); // NOI18N
        numLbl.setForeground(new java.awt.Color(135, 102, 0));
        numLbl.setText("12");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 40, 1, 0);
        iconPanel.add(numLbl, gridBagConstraints);

        dishIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dish_ic_80px.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, -100, 0, 0);
        iconPanel.add(dishIcon, gridBagConstraints);

        readyTxtLbl.setFont(new java.awt.Font("Californian FB", 1, 24)); // NOI18N
        readyTxtLbl.setForeground(new java.awt.Color(135, 102, 0));
        readyTxtLbl.setText("Ready");

        showOrdersBtn.setBackground(new java.awt.Color(231, 231, 231));
        showOrdersBtn.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));
        showOrdersBtn.setCornerRadius(30);
        showOrdersBtn.setBorderColor(new java.awt.Color(218,164,0));

        showOrdersLbl.setFont(new java.awt.Font("Californian FB", 1, 16)); // NOI18N
        showOrdersLbl.setForeground(new java.awt.Color(135, 102, 0));
        showOrdersLbl.setText("Show Orders");
        showOrdersBtn.add(showOrdersLbl);

        callWaiterBtn.setBackground(new java.awt.Color(255, 51, 51));
        callWaiterBtn.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));
        callWaiterBtn.setCornerRadius(30);

        callWaiterLbl.setFont(new java.awt.Font("Californian FB", 1, 16)); // NOI18N
        callWaiterLbl.setForeground(new java.awt.Color(255, 255, 255));
        callWaiterLbl.setText("Call Waiter");
        callWaiterBtn.add(callWaiterLbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tableLbl)
                    .addComponent(readyTxtLbl)
                    .addComponent(showOrdersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(callWaiterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableLbl)
                .addGap(1, 1, 1)
                .addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(readyTxtLbl)
                .addGap(18, 18, 18)
                .addComponent(showOrdersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(callWaiterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fudz.custom.RoundedPanel callWaiterBtn;
    private javax.swing.JLabel callWaiterLbl;
    private javax.swing.JLabel dishIcon;
    private javax.swing.JPanel iconPanel;
    private javax.swing.JLabel numLbl;
    private javax.swing.JLabel readyTxtLbl;
    private com.fudz.custom.RoundedPanel showOrdersBtn;
    private javax.swing.JLabel showOrdersLbl;
    private javax.swing.JLabel tableLbl;
    // End of variables declaration//GEN-END:variables
}
