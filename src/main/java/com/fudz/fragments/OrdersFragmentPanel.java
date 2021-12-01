package com.fudz.fragments;


import com.fudz.custom.FudzJList;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

/**
 *
 * @author Rene Tajos Jr.
 * This is a fragment/JPanel for the
 * orders of our customer.
 * This is the panel where we can view
 * the orders that the waiters sent
 * from our mobile application
 */
public class OrdersFragmentPanel extends JPanel {
    
    private JScrollPane ordersScrollPane = new JScrollPane();
    private JScrollPane addOnsScrollPane = new JScrollPane();
    private FudzJList ordersLst = new FudzJList();
    private FudzJList addOnsList = new FudzJList();
    private JPanel addOnsPanel = new JPanel();
    
    private final Color bgColor = new Color(252,243,236); // background color for this panel
    private final boolean isAutoScrolls = true; // set the autoscrolls for this panel
    // addOnsLst attributes
    private final Font addOnsLst_font = new Font("Californian FB", 1, 14);
    private final Color addOnsLst_BgColor = new Color(252,243,236);
    private final Border addOnsLst_Border = BorderFactory.createEmptyBorder(1, 1, 1, 1);
    // addOnsScrollPane attributes
    private final Border addOnsScrollPane_Border = BorderFactory.createEmptyBorder(0, 0, 0, 0);
    private final int addOnsScrollPane_scrollSpeed = 16;
    // addOnsLbl attributes
    private final Font addOnsLbl_font = new Font("Californian FB", 1, 14);
    private final String addOnsLbl_text = "Add-ons:";
    // ordersLst attributes
    private final Font ordersLst_font = new Font("Californian FB", 1, 14);
    private final Color ordersLst_BgColor = new Color(252,243,236);
    private final Border ordersLst_Border = new SoftBevelBorder(javax.swing.border.BevelBorder.RAISED);
    // addOnsPanel attributes
    private final Color addOnsPanel_BgColor = new Color(252,243,236);
    private final Border addOnsPanel_Border = new SoftBevelBorder(javax.swing.border.BevelBorder.RAISED);
    // ordersScrollPane attributes
    private final Color ordersScrollPane_BgColor = new Color(0, 0, 0, 0);
    private final Border ordersScrollPane_Border = BorderFactory.createEmptyBorder(0, 0, 0, 0);
    private final int ordersScrollPane_scrollSpeed = 16;
    // ordersLstPanel attributes
    private final Color ordersLstPanel_BgColor = new Color(0, 0, 0, 0);
    private final LayoutManager ordersLstPanel_Layout = new GridLayout(2, 1);
    // cookNowLbl attributes
    private final Color cookNowLbl_FgColor = new Color(255, 255, 255);
    private final Font cookNowLbl_font = new Font("Californian FB", 1, 21);
    private final String cookNowLbl_text = "Cook Now";
    // cookNowBtn attributes
    private final Color cookNowBtn_BgColor = new Color(255, 51, 51);
    // customersLbl attributes
    private final Color customersLbl_FgColor = new Color(0, 0, 0);
    private final Font customersLbl_font = new Font("Californian FB", 1, 16);
    private final String customersLbl_text = "Customers: 2";
    // customers_ic attributes
    private final ImageIcon customers_icPath = new ImageIcon(getClass().getResource("/icons/customers_ic_25px.png"));
    // tableNumLbl attributes
    private final Color tableNumLbl_FgColor = new Color(0, 0, 0);
    private final Font tableNumLbl_font = new Font("Californian FB", 1, 16);
    private final String tableNumLbl_text = "Table No.: 12";
    // table_ic attributes
    private final ImageIcon table_icPath = new ImageIcon(getClass().getResource("/icons/table_ic_25px.png"));
    // JSeparator attributes
    private final Color JSeparator_FgColor = new Color(252, 243, 236);
    private final Color JSeparator_BgColor = new Color(195,168,67);
    // headerPanel attributes
    private final Color headerPanel_BgColor = new Color(252,243,236);

    public OrdersFragmentPanel() {
        super();
        _initPanel();
    }
    
    private void _initPanel() {
        this.setBackground(bgColor);
        this.setAutoscrolls(isAutoScrolls);
        
        JLabel timerLbl = new JLabel();
        timerLbl.setText("Time Approx.: 12 minutes to finish");
        
        addOnsList.setBackground(addOnsLst_BgColor);
        addOnsList.setBorder(addOnsLst_Border);
        addOnsList.setFont(addOnsLst_font);
        List<HashMap<String, Object>> items2 = new ArrayList<>();
        {
            HashMap<String, Object> map = new HashMap<>();
            map.put(FudzJList.ITEM_NAME_KEY, "Cheese Burger King");
            map.put(FudzJList.ITEM_QTY_KEY, 3);
            items2.add(map);
            
            map = new HashMap<>();
            map.put(FudzJList.ITEM_NAME_KEY, "Spaghetti");
            map.put(FudzJList.ITEM_QTY_KEY, 2);
            items2.add(map);
            
            map = new HashMap<>();
            map.put(FudzJList.ITEM_NAME_KEY, "Mammon");
            map.put(FudzJList.ITEM_QTY_KEY, 5);
            items2.add(map);
            
            map = new HashMap<>();
            map.put(FudzJList.ITEM_NAME_KEY, "Fried Chicken");
            map.put(FudzJList.ITEM_QTY_KEY, 5);
            items2.add(map);
        }
        addOnsList.setData(items2);
        
        // addOnsScrollPane
        addOnsScrollPane.setBorder(addOnsScrollPane_Border);
        addOnsScrollPane.getVerticalScrollBar().setUnitIncrement(addOnsScrollPane_scrollSpeed);
        addOnsScrollPane.setViewportView(addOnsList);
        
        // addOnsLbl
        JLabel addOnsLbl = new JLabel();
        addOnsLbl.setFont(addOnsLbl_font);
        addOnsLbl.setText(addOnsLbl_text);
        
        // ordersLst
        ordersLst.setBackground(ordersLst_BgColor);
        ordersLst.setBorder(ordersLst_Border);
        ordersLst.setFont(ordersLst_font);
        List<HashMap<String, Object>> items = new ArrayList<>();
        {
            HashMap<String, Object> map = new HashMap<>();
            map.put(FudzJList.ITEM_NAME_KEY, "Cheese Burger King");
            map.put(FudzJList.ITEM_QTY_KEY, 3);
            items.add(map);
            
            map = new HashMap<>();
            map.put(FudzJList.ITEM_NAME_KEY, "Spaghetti");
            map.put(FudzJList.ITEM_QTY_KEY, 2);
            items.add(map);
            
            map = new HashMap<>();
            map.put(FudzJList.ITEM_NAME_KEY, "Mammon");
            map.put(FudzJList.ITEM_QTY_KEY, 5);
            items.add(map);
            
            map = new HashMap<>();
            map.put(FudzJList.ITEM_NAME_KEY, "Fried Chicken");
            map.put(FudzJList.ITEM_QTY_KEY, 5);
            items.add(map);
        }
        ordersLst.setData(items);
        
        // addOnsPanel
        addOnsPanel.setBackground(addOnsPanel_BgColor);
        addOnsPanel.setBorder(addOnsPanel_Border);
        addOnsPanel.setPreferredSize(addOnsPanel.getPreferredSize());
        javax.swing.GroupLayout addOnsPanelLayout = new javax.swing.GroupLayout(addOnsPanel);
        addOnsPanel.setLayout(addOnsPanelLayout);
        addOnsPanelLayout.setHorizontalGroup(
            addOnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addOnsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addOnsLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(addOnsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
        );
        addOnsPanelLayout.setVerticalGroup(
            addOnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addOnsPanelLayout.createSequentialGroup()
                .addComponent(addOnsLbl)
                .addGap(0, 0, 0)
                .addComponent(addOnsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        
        // ordersScrollPane
        ordersScrollPane.setBackground(ordersScrollPane_BgColor);
        ordersScrollPane.setBorder(ordersScrollPane_Border);
        ordersScrollPane.getVerticalScrollBar().setUnitIncrement(ordersScrollPane_scrollSpeed);
        ordersScrollPane.setViewportView(ordersLst);
        
        // ordersLstPanel
        JPanel ordersLstPanel = new JPanel();
        ordersLstPanel.setBackground(ordersLstPanel_BgColor);
        ordersLstPanel.setLayout(ordersLstPanel_Layout);
        ordersLstPanel.add(ordersScrollPane);
        ordersLstPanel.add(addOnsPanel);
        
        // cookNowLbl
        JLabel cookNowLbl = new JLabel();
        cookNowLbl.setFont(cookNowLbl_font); // NOI18N
        cookNowLbl.setForeground(cookNowLbl_FgColor);
        cookNowLbl.setText(cookNowLbl_text);
        
        // cookNowBtn
        JPanel cookNowBtn = new JPanel();
        cookNowBtn.setBackground(cookNowBtn_BgColor);
        javax.swing.GroupLayout cookNowBtnLayout = new javax.swing.GroupLayout(cookNowBtn);
        cookNowBtn.setLayout(cookNowBtnLayout);
        cookNowBtnLayout.setHorizontalGroup(
            cookNowBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cookNowBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cookNowLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cookNowBtnLayout.setVerticalGroup(
            cookNowBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cookNowBtnLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(cookNowLbl)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        
        // customersLbl
        JLabel customersLbl = new JLabel();
        customersLbl.setFont(customersLbl_font);
        customersLbl.setForeground(customersLbl_FgColor);
        customersLbl.setText(customersLbl_text);
        
        // customers_ic
        final JLabel customers_ic = new JLabel();
        customers_ic.setIcon(customers_icPath);
        
        // tableNumLbl
        final JLabel tableNumLbl = new JLabel();
        tableNumLbl.setFont(tableNumLbl_font); // NOI18N
        tableNumLbl.setForeground(tableNumLbl_FgColor);
        tableNumLbl.setText(tableNumLbl_text);
        
        // table_ic
        final JLabel table_ic = new JLabel();
        table_ic.setIcon(table_icPath);
        
        // JSeparator
        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBackground(JSeparator_BgColor);
        jSeparator1.setForeground(JSeparator_FgColor);
        
        // headerPanel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(headerPanel_BgColor);
        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(table_ic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableNumLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(customers_ic, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customersLbl)
                .addGap(33, 33, 33))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(customersLbl)
                    .addComponent(customers_ic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tableNumLbl)
                    .addComponent(table_ic, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
        );
        
        // orders fragment
        javax.swing.GroupLayout ordersFragmentLayout = new javax.swing.GroupLayout(this);
        this.setLayout(ordersFragmentLayout);
        ordersFragmentLayout.setHorizontalGroup(
            ordersFragmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cookNowBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ordersFragmentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(timerLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ordersFragmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ordersFragmentLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ordersLstPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        ordersFragmentLayout.setVerticalGroup(
            ordersFragmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordersFragmentLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(352, 352, 352)
                .addComponent(timerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cookNowBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
            .addGroup(ordersFragmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ordersFragmentLayout.createSequentialGroup()
                    .addContainerGap(59, Short.MAX_VALUE)
                    .addComponent(ordersLstPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(77, Short.MAX_VALUE)))
        );
        
        // component listener
        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                // this will check if there are less items ordered,
                // if there are, we will remove the JScrollPane so
                // we can mouse scroll on the list efficiently.
                if (!(ordersScrollPane.getHeight() < ordersLst.getHeight())) {
                    ordersLstPanel.remove(ordersScrollPane);
                    
                    ordersLst.setBackground(ordersLst_BgColor);
                    ordersLst.setBorder(ordersLst_Border);
                    ordersLst.setFont(ordersLst_font);
                    
                    ordersLstPanel.add(ordersLst, 0);
                }
                
                if (!(addOnsScrollPane.getHeight() < addOnsList.getHeight())) {
                    addOnsPanel.remove(addOnsScrollPane);
                    
                    addOnsList.setBackground(addOnsLst_BgColor);
                    addOnsList.setBorder(addOnsLst_Border);
                    addOnsList.setFont(addOnsLst_font);
                    
                    addOnsPanel.setBackground(addOnsPanel_BgColor);
                    addOnsPanel.setBorder(addOnsPanel_Border);
                    addOnsPanel.setPreferredSize(addOnsPanel.getPreferredSize());
                    javax.swing.GroupLayout addOnsPanelLayout = new javax.swing.GroupLayout(addOnsPanel);
                    addOnsPanel.setLayout(addOnsPanelLayout);
                    addOnsPanelLayout.setHorizontalGroup(
                        addOnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addOnsPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(addOnsLbl)
                            .addContainerGap(251, Short.MAX_VALUE))
                        .addComponent(addOnsList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    );
                    addOnsPanelLayout.setVerticalGroup(
                        addOnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addOnsPanelLayout.createSequentialGroup()
                            .addComponent(addOnsLbl)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addOnsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                    );
                }
            }

            @Override
            public void componentMoved(ComponentEvent e) {}
            @Override
            public void componentShown(ComponentEvent e) {}
            @Override
            public void componentHidden(ComponentEvent e) {}
        });
    }
    
}
