package com.fudz.custom;

import com.fudz.fragments.OrdersItemFragment;
import java.awt.GridLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Rene Tajos Jr.
 * This class will replace the built-in JList of swing
 * Instead of using JList, we will use this class that extends JPanel
 * to provide more functions and have flexibility in designing our UI.
 */
public class FudzJList extends JPanel implements Serializable {
    /*
    * mData keys
    * @item_name: string value
    * @item_qty: integer value
    */
    public static final String ITEM_NAME_KEY = "item_name";
    public static final String ITEM_QTY_KEY = "item_qty";
    
    private List<HashMap<String, Object>> mData = new ArrayList<>();
    
    public FudzJList() {
        super();
    }
    
    /*
    * We will set the data for this List or fragment, we will store the data to "mData" variable.
    * Example sa laman ng "mData":
    * -----------------------------------------
    *   ID        keys               value
    * -----------------------------------------
    *   #1     "item_name":      CheeseBurger
    *          "item_qty":             3
    * -----------------------------------------
    *   #2      "item_name":        Hotdog
    *           "item_qty":            3
    */
    public void setData(List<HashMap<String, Object>> _data) {
        mData = _data;
        this.setLayout(new GridLayout(mData.size(), 1));
        
        // now we will add each items/data from variable "mData" to this "FudzJList" / JPanel
        // para ma view natin sa screen ang mga items na inorder ng customers per table
        // example: Merong 5 items na laman ng variable na "mData" ,so we will create 5 fragments/JPanels
        // with its itemName and itemQuantity for each data/item.
        mData.forEach(data -> {
            this.add(new OrdersItemFragment()
                    .setItemName(data.get(ITEM_NAME_KEY).toString())
                    .setQty((int)data.get(ITEM_QTY_KEY)));
        });
    }
}
