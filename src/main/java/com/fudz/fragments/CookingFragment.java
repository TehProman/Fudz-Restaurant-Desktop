package com.fudz.fragments;

import com.fudz.custom.RoundedPanel;
import java.awt.Color;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Rene Tajos Jr.
 */
public class CookingFragment extends RoundedPanel {
    
    private FragmentBtnsListener listener;
    public interface FragmentBtnsListener {
        void onShowOrdersClick();
        void onFinishClick();
    }

    /**
     * Creates new form CookingFragment
     */
    public CookingFragment() {
        _init();
        initComponents();
    }
    
    public CookingFragment(List<HashMap<String, Object>> cookingNowLst, FragmentBtnsListener _listener) {
        listener = _listener;
        _init();
        initComponents();
    }
    
    private void _init() {
        bgColor = new Color(255,255,255);
        cornerRadius = 25;
        haveBorder = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        tableNum = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        timeLbl = new javax.swing.JLabel();
        preparingTxtLbl = new javax.swing.JLabel();
        tableLbl = new javax.swing.JLabel();
        showOrdersBtn = new com.fudz.custom.RoundedPanel();
        showOrdersLbl = new javax.swing.JLabel();
        finishBtn = new com.fudz.custom.RoundedPanel();
        finishLbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLayeredPane1.setLayout(new javax.swing.OverlayLayout(jLayeredPane1));

        tableNum.setFont(new java.awt.Font("Dubai Medium", 1, 48)); // NOI18N
        tableNum.setForeground(new java.awt.Color(51, 51, 51));
        tableNum.setText("12");
        jLayeredPane1.add(tableNum);

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/circled_notch_90px.png"))); // NOI18N
        jLayeredPane1.add(icon);

        timeLbl.setFont(new java.awt.Font("Californian FB", 1, 14)); // NOI18N
        timeLbl.setForeground(new java.awt.Color(135, 102, 0));
        timeLbl.setText("12 min 00 secs.");

        preparingTxtLbl.setFont(new java.awt.Font("Californian FB", 1, 24)); // NOI18N
        preparingTxtLbl.setForeground(new java.awt.Color(51, 51, 51));
        preparingTxtLbl.setText("Preparing...");

        tableLbl.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 14)); // NOI18N
        tableLbl.setForeground(new java.awt.Color(51, 51, 51));
        tableLbl.setText("TABLE");

        showOrdersBtn.setBackground(new java.awt.Color(231, 231, 231));
        showOrdersBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showOrdersBtnMouseClicked(evt);
            }
        });
        showOrdersBtn.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));
        showOrdersBtn.setCornerRadius(30);
        showOrdersBtn.setBorderColor(new java.awt.Color(218,164,0));

        showOrdersLbl.setFont(new java.awt.Font("Californian FB", 1, 16)); // NOI18N
        showOrdersLbl.setForeground(new java.awt.Color(51, 51, 51));
        showOrdersLbl.setText("Show Orders");
        showOrdersBtn.add(showOrdersLbl);

        finishBtn.setBackground(new java.awt.Color(255, 51, 51));
        finishBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finishBtnMouseClicked(evt);
            }
        });
        finishBtn.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));
        finishBtn.setCornerRadius(30);

        finishLbl.setFont(new java.awt.Font("Californian FB", 1, 16)); // NOI18N
        finishLbl.setForeground(new java.awt.Color(255, 255, 255));
        finishLbl.setText("Finish");
        finishBtn.add(finishLbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(finishBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tableLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addComponent(showOrdersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(timeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(preparingTxtLbl)))
                        .addGap(22, 22, 22)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(tableLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(preparingTxtLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timeLbl)
                .addGap(18, 18, 18)
                .addComponent(showOrdersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finishBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void showOrdersBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showOrdersBtnMouseClicked
        listener.onShowOrdersClick();
    }//GEN-LAST:event_showOrdersBtnMouseClicked

    private void finishBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finishBtnMouseClicked
        listener.onFinishClick();
    }//GEN-LAST:event_finishBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fudz.custom.RoundedPanel finishBtn;
    private javax.swing.JLabel finishLbl;
    private javax.swing.JLabel icon;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel preparingTxtLbl;
    private com.fudz.custom.RoundedPanel showOrdersBtn;
    private javax.swing.JLabel showOrdersLbl;
    private javax.swing.JLabel tableLbl;
    private javax.swing.JLabel tableNum;
    private javax.swing.JLabel timeLbl;
    // End of variables declaration//GEN-END:variables
}
