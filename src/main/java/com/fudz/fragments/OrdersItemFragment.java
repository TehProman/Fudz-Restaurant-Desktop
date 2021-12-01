package com.fudz.fragments;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rene Tajos Jr.
 * This is a fragment/JPanel to be used
 * for our custom FudzJList class
 */
public class OrdersItemFragment extends JPanel {
    
    private final JLabel itemNameLbl = new JLabel();
    private final JLabel itemQtyLbl = new JLabel();
    
    public OrdersItemFragment() {
        super();
        _init();
    }
    
    public OrdersItemFragment setItemName(String name) {
        itemNameLbl.setText(name);
        return this;
    }
    
    public OrdersItemFragment setQty(int qty) {
        itemQtyLbl.setText("x" + String.valueOf(qty));
        return this;
    }
    
    private void _init() {
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0));
        
        itemNameLbl.setText("Item Name Here");
        itemQtyLbl.setText("Qty Here");
        
        javax.swing.GroupLayout ordersItemFragmentLayout = new javax.swing.GroupLayout(this);
        this.setLayout(ordersItemFragmentLayout);
        ordersItemFragmentLayout.setHorizontalGroup(
            ordersItemFragmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordersItemFragmentLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(itemNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(73, 73, 73)
                .addComponent(itemQtyLbl)
                .addGap(43, 43, 43))
        );
        ordersItemFragmentLayout.setVerticalGroup(
            ordersItemFragmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordersItemFragmentLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(ordersItemFragmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemQtyLbl))
                .addGap(8, 8, 8))
        );
    }
}
