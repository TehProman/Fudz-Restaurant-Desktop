/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
