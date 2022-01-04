package com.fudz.custom;

import javax.swing.JPanel;

/**
 *
 * @author Rene Tajos Jr.
 */
public abstract class BaseFragment extends JPanel {
    protected int position;
    
    public abstract void setFragmentPosition(int _pos);
    
    public BaseFragment() {
    }
    
    public int getPosition() {
        return position;
    }
}
