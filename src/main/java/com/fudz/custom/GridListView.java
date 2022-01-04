/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fudz.custom;

import com.fudz.fragments.CookingFragment;
import com.fudz.fragments.OrdersFragment;
import com.fudz.fragments.Rdy2ServeFragment;
import com.fudz.restau.Fudz;
import static com.fudz.restau.WindowFrame.columnNum;
import static com.fudz.restau.WindowFrame.columnPHolder;
import static com.fudz.restau.WindowFrame.ordersFragmentPanelWidth;
import static com.fudz.restau.WindowFrame.ordersFragmentPanelHeight;
import static com.fudz.restau.WindowFrame.pHolderCount;
import static com.fudz.restau.WindowFrame.viewedScrn;
import static com.fudz.restau.WindowFrame.mainOrderLst;
import static com.fudz.restau.WindowFrame.cookingOrderLst;
import static com.fudz.restau.WindowFrame.ready2ServeLst;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Lenovo
 */
public class GridListView extends JPanel {
    
    private JScrollPane contentScrollPaneReference;
    private int unchangedSize;
    
    private ContentChangeListener listener;
    public interface ContentChangeListener {
        void onContentChanged();
    }
    
    public GridListView() {
        super();
    }
    
    public void setOnContentChangedListener(ContentChangeListener _listener) {
        listener = _listener;
    }
    
    public void notifyItemChanged() {
        this.updateUI();
    }
    
    public void populate(int screen, 
            JScrollPane _contentScrollPane, 
            int _size) {
        
        if (contentScrollPaneReference == null)
            contentScrollPaneReference = _contentScrollPane;
        
        unchangedSize = _size;
        this.removeAll();
        
        switch (screen) {
            case Fudz.ORDERS_SCREEN:
                while (_size != 0) {
                    final OrdersFragment ordersFragment = new OrdersFragment(mainOrderLst, (int position) -> {
                        // on "Cook Now" button Click
                        // TO-DO
                        
                    });
                    
                    _initialize(_size, ordersFragment);
                    _size--;
                }
                break;
            case Fudz.COOKING_SCREEN:
                while (_size != 0) {
                    final CookingFragment cookingFragment = new CookingFragment(cookingOrderLst, new CookingFragment.FragmentBtnsListener() {
                        @Override
                        public void onShowOrdersClick() {
                            
                        }

                        @Override
                        public void onFinishClick() {
                            
                        }
                    });
                    
                    _initialize(_size, cookingFragment);
                    _size--;
                }
                break;
            case Fudz.RTS_SCREEN:
                while (_size != 0) {
                    final Rdy2ServeFragment rdy2ServeFragment = new Rdy2ServeFragment(ready2ServeLst, () -> {
                        // on "Show Orders" button Click
                        
                    });
                    
                    _initialize(_size, rdy2ServeFragment);
                    _size--;
                }
                break;
        }
    }
    
    private void _initialize( int _size, BaseFragment _fragment) {
        final BaseFragment fragment = _fragment;
        fragment.setFragmentPosition(unchangedSize - _size);
        Fudz.log(fragment.getPosition());
        final int column = Fudz.getColumn(contentScrollPaneReference.getWidth(), fragment.getPreferredSize().width);

        columnNum = column; columnPHolder = column;
        int childrensCount = this.getComponentCount() + 1;
        switch (viewedScrn) {
            // when the screen is on ORDERS
            case Fudz.ORDERS_SCREEN:
                _initFragments(fragment, childrensCount, column);
                if (ordersFragmentPanelWidth == 0)
                    ordersFragmentPanelWidth = fragment.getPreferredSize().width;
                if (ordersFragmentPanelHeight == 0)
                    ordersFragmentPanelHeight = fragment.getPreferredSize().height;

                break;
                // when the screen is on COOKING
            case Fudz.COOKING_SCREEN:
                _initFragments(fragment, childrensCount, column);
                break;
            default:
                _initFragments(fragment, childrensCount, column);
                break;
        }
    }
    
    private void _initFragments(final JPanel fragment, final int _childrensCount, final int column) {
            int childrensCount = _childrensCount;
            // if the FragmentPanel's children count is less than or equal 2
            // then, set its layout manager first to flow layout to avoid fragment stretching effect.
            if (childrensCount-pHolderCount <= column) {
                this.setLayout(new FlowLayout());
                this.add(fragment);
                return;
            }
            // else
            
            if (pHolderCount > 0) {
                childrensCount -= pHolderCount;
                this.remove(this.getComponentCount()-1);
                pHolderCount--;
            }
            
            int absChildCount = this.getComponentCount()-pHolderCount;
            _resetGridLayout(this, childrensCount, column);
            this.add(fragment, pHolderCount!=0? absChildCount : this.getComponentCount()-1);
            
            if (pHolderCount > 0) // always return if there's already a place holder
                return;
            
            // this will fix or add placeholders to avoid stretching effect.
            Fudz.fixGridLayout(this, viewedScrn, _pHolderCount(column));
    }
    
    private int _pHolderCount(final int column) {
        while (columnNum < this.getComponentCount())
            columnNum += column;
            
        return pHolderCount = columnNum - this.getComponentCount(); // how many place holder to add
    }
    
    private void _resetGridLayout(Component comp, int size, int column) {
        int row; float remainder;
        
        row = size / column;
        remainder = size % column;

        ((JPanel)comp).setLayout(new GridLayout(remainder!=0.0?row + 1:row, column, 5, 10));
    }
}
