package com.fudz.fragments;

import com.fudz.custom.RoundedPanel;
import java.awt.Color;

/**
 *
 * @author Rene Tajos Jr.
 */
public class CookingInProgFragment extends RoundedPanel {
    
    private javax.swing.JPanel btnsRootPanel;
    private javax.swing.JPanel finishBtn;
    private javax.swing.JLabel finishLbl;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel seeOrdersBtn;
    private javax.swing.JLabel seeOrdersLbl;
    private javax.swing.JLabel tableNum;
    private javax.swing.JLabel timeLbl;
    
    public CookingInProgFragment() {
        bgColor = new Color(255,255,255);
        cornerRadius = 20;
        haveBorder = false;
        _initComponents();
    }
    
    private void _initComponents() {
        jLayeredPane1 = new javax.swing.JLayeredPane();
        tableNum = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        timeLbl = new javax.swing.JLabel();
        btnsRootPanel = new javax.swing.JPanel();
        seeOrdersBtn = new javax.swing.JPanel();
        seeOrdersLbl = new javax.swing.JLabel();
        finishBtn = new javax.swing.JPanel();
        finishLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        this.setBackground(bgColor);
        this.setMaximumSize(new java.awt.Dimension(192, 251));
        this.setMinimumSize(new java.awt.Dimension(192, 251));
        this.setPreferredSize(new java.awt.Dimension(192, 251));

        jLayeredPane1.setLayout(new javax.swing.OverlayLayout(jLayeredPane1));
        
        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(183,138,0));
        jLabel2.setText("TABLE");

        tableNum.setFont(new java.awt.Font("Dubai Medium", 1, 48)); // NOI18N
        tableNum.setForeground(new java.awt.Color(64,63,63));
        tableNum.setText("12");
        jLayeredPane1.add(tableNum);

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/circled_notch_90px.png"))); // NOI18N
        jLayeredPane1.add(icon);
        
        jLabel1.setFont(new java.awt.Font("Californian FB", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(64,63,63));
        jLabel1.setText("Preparing...");

        timeLbl.setFont(new java.awt.Font("Californian FB", 1, 15)); // NOI18N
        timeLbl.setForeground(new java.awt.Color(135,102,0));
        timeLbl.setText("12 min 00 secs.");

        btnsRootPanel.setLayout(new java.awt.GridLayout(1, 2));

        seeOrdersBtn.setBackground(new java.awt.Color(231,231,231));

        seeOrdersLbl.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        seeOrdersLbl.setForeground(new java.awt.Color(64,63,63));
        seeOrdersLbl.setText("See Orders");
        
        finishBtn.setBackground(new java.awt.Color(221,179,24));
        finishLbl.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        finishLbl.setForeground(new java.awt.Color(255,255,255));
        finishLbl.setText("Finish");

        javax.swing.GroupLayout seeOrdersBtnLayout = new javax.swing.GroupLayout(seeOrdersBtn);
        seeOrdersBtn.setLayout(seeOrdersBtnLayout);
        seeOrdersBtnLayout.setHorizontalGroup(
            seeOrdersBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
            .addGroup(seeOrdersBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(seeOrdersBtnLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(seeOrdersLbl)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        seeOrdersBtnLayout.setVerticalGroup(
            seeOrdersBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
            .addGroup(seeOrdersBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(seeOrdersBtnLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(seeOrdersLbl)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        btnsRootPanel.add(seeOrdersBtn);

        javax.swing.GroupLayout finishBtnLayout = new javax.swing.GroupLayout(finishBtn);
        finishBtn.setLayout(finishBtnLayout);
        finishBtnLayout.setHorizontalGroup(
            finishBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
            .addGroup(finishBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(finishBtnLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(finishLbl)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        finishBtnLayout.setVerticalGroup(
            finishBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
            .addGroup(finishBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(finishBtnLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(finishLbl)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        btnsRootPanel.add(finishBtn);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnsRootPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(timeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timeLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnsRootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }
}
