package com.fudz.fragments;

import javax.swing.BorderFactory;

/**
 *
 * @author Rene Tajos Jr.
 * This is a fragment/JPanel to be used
 * for our custom FudzJList class
 */
public class OrdersItemFragment extends javax.swing.JPanel {

    /**
     * Creates new form OrdersItemFragment2
     */
    public OrdersItemFragment() {
        initComponents();
        
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0));
        
        itemNameLbl.setText("Item Name Here");
        itemQtyLbl.setText("Qty Here");
    }
    
    public OrdersItemFragment setItemName(String name) {
        itemNameLbl.setText(name);
        return this;
    }
    
    public OrdersItemFragment setQty(int qty) {
        itemQtyLbl.setText("x" + String.valueOf(qty));
        return this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemQtyLbl = new javax.swing.JLabel();
        itemNameLbl = new javax.swing.JLabel();

        itemQtyLbl.setText("Qty Here");

        itemNameLbl.setText("Item Name Here");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(itemNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(73, 73, 73)
                .addComponent(itemQtyLbl)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemQtyLbl))
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel itemNameLbl;
    private javax.swing.JLabel itemQtyLbl;
    // End of variables declaration//GEN-END:variables
}
