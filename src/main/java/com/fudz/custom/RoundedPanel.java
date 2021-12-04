package com.fudz.custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Rene Tajos Jr.
 */
public class RoundedPanel extends JPanel {
    
    protected Color bgColor;
    protected int cornerRadius;
    protected boolean haveBorder = true;

    public RoundedPanel() {
        super();
    }
    
    public void setBackgroundColor(Color _bgColor) {
        bgColor = _bgColor;
    }
    
    public void setCornerRadius(int radius) {
        cornerRadius = radius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        /*
        * Draws the rounded panel.
        */
        
        // set the background color
        if (bgColor != null)
            graphics.setColor(bgColor);
        else
            graphics.setColor(getBackground());
        
        graphics.fillRoundRect(0, 0, width, height, arcs.width, arcs.height); //paint background
        
        if (haveBorder) {
            graphics.setColor(new Color(218,164,0)); // set the color for the border
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
        }
    }
}
