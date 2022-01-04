package com.fudz.restau;

import com.fudz.fragments.CookingFragment;
import com.fudz.fragments.OrdersFragment;
import com.fudz.fragments.Rdy2ServeFragment;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Rene Tajos Jr.
 */
public class Fudz {
    
    public static final int DEFAULT_STATE = 0;
    public static final int LEFT_RESIZE_STATE = 1;
    public static final int RIGHT_RESIZE_STATE = 2;
    public static final int TOP_RESIZE_STATE = 3;
    public static final int BOTTOM_RESIZE_STATE = 4;
    public static final int TOPLEFT_RESIZE_STATE = 5;
    public static final int TOPRIGHT_RESIZE_STATE = 6;
    public static final int BOTTOMLEFT_RESIZE_STATE = 7;
    public static final int BOTTOMRIGHT_RESIZE_STATE = 8;
    
    public static final int WINDOW_MAXIMIZE = JFrame.MAXIMIZED_BOTH;
    public static final int WINDOW_MINIMIZE = JFrame.ICONIFIED;
    public static final int WINDOW_NORMAL = JFrame.NORMAL;
    
    public static final int ORDERS_SCREEN = 0;
    public static final int COOKING_SCREEN = 1;
    public static final int RTS_SCREEN = 2;
    
    public static final int MOUSE_LEFT_BTN = 1;
    public static final int MOUSE_RIGHT_BTN = 3;
    
    public static final String ORDERS_LIST_KEY = "ordersLst";
    public static final String ADDONS_LIST_KEY = "addonsLst";
    
    public static final Color mouseEnteredOnMenuTabs_COLOR = new Color(255,214,90);
    public static final Color mouseExitedOnMenuTabs_COLOR = new Color(218,164,0);
    public static final Color mouseClickedOnMenuTabs_COLOR = new Color(252,243,236);
    
    public static void log(final Object obj) {
        System.out.println(obj);
    }
    
    public static double getScreenWidth() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return screenSize.getWidth();
    }
    
    public static double getScreenHeight() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return screenSize.getHeight();
    }
    
    public static int getColumn(final int rootWidth, final int fragmentWidth) {
        int column = rootWidth / fragmentWidth;
        float rem = rootWidth % fragmentWidth;
        
        return rem > fragmentWidth/2 ? column+1 : column;
    }
    
    public static void fixGridLayout(JPanel root, final int viewedScreen, final int pHolderCount) {
        switch (viewedScreen) {
            case Fudz.ORDERS_SCREEN:
                for (int i=0; i<pHolderCount; i++) {
                    final OrdersFragment pHolderPanel = new OrdersFragment();
                    pHolderPanel.setVisible(false);
                    root.add(pHolderPanel);
                }
                break;
            case Fudz.COOKING_SCREEN:
                for (int i=0; i<pHolderCount; i++) {
                    final CookingFragment pHolderPanel = new CookingFragment();
                    pHolderPanel.setVisible(false);
                    root.add(pHolderPanel);
                }
                break;
            case Fudz.RTS_SCREEN:
                for (int i=0; i<pHolderCount; i++) {
                    final Rdy2ServeFragment pHolderPanel = new Rdy2ServeFragment();
                    pHolderPanel.setVisible(false);
                    root.add(pHolderPanel);
                }
                break;
        }
    }
}
