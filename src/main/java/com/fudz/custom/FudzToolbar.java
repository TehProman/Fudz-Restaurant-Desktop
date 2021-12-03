package com.fudz.custom;

import com.fudz.restau.Fudz;
import static com.fudz.restau.WindowFrame.isResizingWindowOnDrag;
import java.awt.Cursor;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class FudzToolbar extends JPanel {
    
    private FudzFrame windowFrame;
    
    private MouseMotionListener mouseMotionListener;
    private MouseListener mouseListener;
    
    protected int cursorState = Fudz.DEFAULT_STATE;
    protected static int rightBoundXOnScrn, bottomBoundYOnScrn;
    
    private FudzToolbarMouseListener fudzMouseListener;
    
    private int xx, yy;
    
    public interface FudzToolbarMouseListener {
        void onDragged(int frameX, int frameY);
    }
    
    public FudzToolbar(FudzFrame frame) {
        super();
        windowFrame = frame;
        _initMouseListeners();
        
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseMotionListener);
    }
    
    public FudzToolbar(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public FudzToolbar(LayoutManager layout) {
        super(layout);
    }
    
    public FudzToolbar(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }
    
    public FudzToolbar() {}
    
    public void setFudzToolbarMouseListener(FudzToolbarMouseListener listener) {
        fudzMouseListener = listener;
    }
    
    private void _initMouseListeners() {
        mouseListener = new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                xx = e.getX();
                yy = e.getY();
                
                if (!FudzFrame.isFrameResizable())
                    return;
                
                rightBoundXOnScrn = windowFrame.getX() + windowFrame.getWidth();
                bottomBoundYOnScrn = windowFrame.getY() + windowFrame.getHeight();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (!FudzFrame.isFrameResizable())
                    return;
                
                windowFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                if (isResizingWindowOnDrag[0])
                    _recorrectWindowFrame();
                isResizingWindowOnDrag[1] = false;
            }

            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            
            
        };
        
        mouseMotionListener = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int cursorOnScrnX = e.getXOnScreen();
                int cursorOnScrnY = e.getYOnScreen();

                if (FudzFrame.isFrameResizable()) {
                    // resize the window if the cursor's location is on certain bounds
                    _resizeWindow(e);

                    if (isResizingWindowOnDrag[0]) {
                        _recorrectWindowFrame();
                        isResizingWindowOnDrag[0] = false;
                        return;
                    }
                }
                
                fudzMouseListener.onDragged(cursorOnScrnX-xx, cursorOnScrnY-yy);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (!FudzFrame.isFrameResizable())
                    return;
                
                _detectBounds(e);
            }
            
        };
    }
    
    protected void _detectBounds(java.awt.event.MouseEvent evt) {
        final int cursorX = evt.getX();
        final int cursorY = evt.getY();
        final int heightThreshold = 8; // mouse point height threshold
        final int widthThreshold = 3; // mouse point width threshold
        final int frameHeight = windowFrame.getBounds().height;
        final int frameWidth = windowFrame.getBounds().width;
        
         //detects left bound
        if (cursorX >= 0 && cursorX <= widthThreshold && cursorY < frameHeight-heightThreshold && cursorY > heightThreshold) {
            cursorState = Fudz.LEFT_RESIZE_STATE;
            windowFrame.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
        //detects bottomLeft point
        } else if(cursorX >= 0 && cursorX <= 4 && cursorY >= frameHeight-heightThreshold && cursorY <= frameHeight) {
            cursorState = Fudz.BOTTOMLEFT_RESIZE_STATE;
            windowFrame.setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
        //detects right bound
        } else if(cursorX >= frameWidth - widthThreshold && cursorX <= frameWidth && cursorY < frameHeight-heightThreshold && cursorY > heightThreshold) {
            cursorState = Fudz.RIGHT_RESIZE_STATE;
            windowFrame.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
        //detects bottomRight point
        } else if(cursorX >= frameWidth - widthThreshold && cursorX <= frameWidth && cursorY >= frameHeight-heightThreshold && cursorY <= frameHeight) {
            cursorState = Fudz.BOTTOMRIGHT_RESIZE_STATE;
            windowFrame.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
        //detects bottom bound
        } else if (cursorY >= frameHeight-heightThreshold && cursorY <= frameHeight && cursorX >= widthThreshold) {
            cursorState = Fudz.BOTTOM_RESIZE_STATE;
            windowFrame.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
        //detects top right point
        } else if(cursorX >= frameWidth - widthThreshold && cursorX <= frameWidth && cursorY >= 0 && cursorY <= heightThreshold) {
            cursorState = Fudz.TOPRIGHT_RESIZE_STATE;
            windowFrame.setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
        //detects top bound
        } else if(cursorY >= 0 && cursorY <= heightThreshold && cursorX > widthThreshold && cursorX < frameWidth - widthThreshold) {
            cursorState = Fudz.TOP_RESIZE_STATE;
            windowFrame.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
        //detects topLeft point
        } else if(cursorX >= 0 && cursorX <= widthThreshold && cursorY >= 0 && cursorY <= heightThreshold) {
            cursorState = Fudz.TOPLEFT_RESIZE_STATE;
            windowFrame.setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
        } else {
            cursorState = Fudz.DEFAULT_STATE;
            windowFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    private void _resizeWindow(java.awt.event.MouseEvent evt) {
        final int cursorX = evt.getX();
        final int cursorY = evt.getY();
        final int windowWidth = windowFrame.getWidth();
        final int windowHeight = windowFrame.getHeight();
        
        int newWidth=0, newHeight=0;
        
        switch (cursorState) {
            // resize from right bound
            case Fudz.RIGHT_RESIZE_STATE:
                isResizingWindowOnDrag[0] = true;
                newWidth = (int)(windowWidth * (cursorX / (float)windowWidth));
                windowFrame.setBounds(new Rectangle(windowFrame.getBounds().x, windowFrame.getBounds().y, newWidth, windowFrame.getHeight()));
                break;
            // resize from left bound
            case Fudz.LEFT_RESIZE_STATE:
                isResizingWindowOnDrag[0] = true;
                if (cursorX < 0) {
                    final int x = evt.getXOnScreen();
                    newWidth = (int)(windowWidth * (Math.abs(cursorX*1.05f-windowWidth) / (float)windowWidth));
                    windowFrame.setBounds(new Rectangle(x-0, windowFrame.getBounds().y, newWidth, windowFrame.getHeight()));
                }
                
                if (cursorX > 0 && windowWidth != windowFrame.getMinimumSize().width) {
                    final int x = evt.getXOnScreen();
                    newWidth = (int)(windowWidth * (Math.abs(cursorX-windowWidth) / (float)windowWidth));
                    windowFrame.setBounds(new Rectangle(x-0, windowFrame.getBounds().y, newWidth, windowFrame.getHeight()));
                }
                break;
            // resize from bottom bound
            case Fudz.BOTTOM_RESIZE_STATE:
                isResizingWindowOnDrag[0] = true;
                newHeight = (int)(windowHeight * (cursorY / (float)windowHeight));
                windowFrame.setBounds(new Rectangle(windowFrame.getBounds().x, windowFrame.getBounds().y, windowFrame.getWidth(), newHeight));
                break;
            // resize from top bound
            case Fudz.TOP_RESIZE_STATE:
                isResizingWindowOnDrag[0] = true;
                if (cursorY < 0) {
                    final int y = evt.getYOnScreen();
                    newHeight = (int)(windowHeight * (Math.abs(cursorY*1.05f-windowHeight) / (float)windowHeight));
                    windowFrame.setBounds(new Rectangle(windowFrame.getBounds().x, y-0, windowWidth, newHeight));
                }
                
                if (cursorY > 0 && windowHeight != windowFrame.getMinimumSize().height) {
                    final int y = evt.getYOnScreen();
                    newHeight = (int)(windowHeight * (Math.abs(cursorY-windowHeight) / (float)windowHeight));
                    windowFrame.setBounds(new Rectangle(windowFrame.getBounds().x, y-0, windowWidth, newHeight));
                }
                break;
            case Fudz.BOTTOMRIGHT_RESIZE_STATE:
                newWidth = (int)(windowWidth * (cursorX / (float)windowWidth));
                newHeight = (int)(windowHeight * (cursorY / (float)windowHeight));
                windowFrame.setBounds(new Rectangle(windowFrame.getBounds().x, windowFrame.getBounds().y, newWidth, newHeight));
                break;
            case Fudz.BOTTOMLEFT_RESIZE_STATE:
                isResizingWindowOnDrag[0] = true;
                if (cursorX < 0) {
                    int x = evt.getXOnScreen();
                    newWidth = (int)(windowWidth * (Math.abs(cursorX*1.05f-windowWidth) / (float)windowWidth));
                    newHeight = (int)(windowHeight * (cursorY / (float)windowHeight));
                    windowFrame.setBounds(new Rectangle(x-0, windowFrame.getBounds().y, newWidth, newHeight));
                }
                
                if (cursorX >= 0) {
                    int x = evt.getXOnScreen();
                    
                    if (windowWidth != windowFrame.getMinimumSize().width)
                        newWidth = (int)(windowWidth * (Math.abs(cursorX-windowWidth) / (float)windowWidth));
                    
                    if (windowHeight != windowFrame.getMinimumSize().height)
                        newHeight = (int)(windowHeight * (cursorY / (float)windowHeight));
                    
                    windowFrame.setBounds(new Rectangle(newWidth==0?windowFrame.getBounds().x:x-0, windowFrame.getBounds().y, newWidth==0?windowWidth:newWidth, newHeight==0?windowHeight:newHeight));
                }
                break;
            case Fudz.TOPRIGHT_RESIZE_STATE:
                isResizingWindowOnDrag[0] = true;
                isResizingWindowOnDrag[1] = true;
                if (cursorY < 0) {
                    final int y = evt.getYOnScreen();
                    newHeight = (int)(windowHeight * (Math.abs(cursorY*1.05f-windowHeight) / (float)windowHeight));
                    newWidth = (int)(windowWidth * (cursorX / (float)windowWidth));
                    windowFrame.setBounds(new Rectangle(windowFrame.getBounds().x, y-0, newWidth, newHeight));
                }
                
                if (cursorY >= 0) {
                    final int y = evt.getYOnScreen();
                    
                    if (windowHeight != windowFrame.getMinimumSize().height)
                        newHeight = (int)(windowHeight * (Math.abs(cursorY-windowHeight) / (float)windowHeight));
                    
                    if (windowWidth != windowFrame.getMinimumSize().width)
                        newWidth = (int)(windowWidth * (cursorX / (float)windowWidth));
                    
                    windowFrame.setBounds(new Rectangle(windowFrame.getBounds().x, newHeight==0?windowFrame.getBounds().y:y-0, newWidth==0?windowWidth:newWidth, newHeight==0?windowHeight:newHeight));
                }
                
                break;
            case Fudz.TOPLEFT_RESIZE_STATE:
                isResizingWindowOnDrag[0] = true;
                isResizingWindowOnDrag[1] = true;
                
                // left resize
                if (cursorX < 0) {
                    final int x = evt.getXOnScreen();
                    newWidth = (int)(windowWidth * (Math.abs(cursorX*1.02f-windowWidth) / (float)windowWidth));
                    windowFrame.setBounds(new Rectangle(x-0, windowFrame.getBounds().y, newWidth, windowFrame.getHeight()));
                }
                
                if (cursorX > 0 && windowWidth != windowFrame.getMinimumSize().width) {
                    final int x = evt.getXOnScreen();
                    newWidth = (int)(windowWidth * (Math.abs(cursorX-windowWidth) / (float)windowWidth));
                    windowFrame.setBounds(new Rectangle(x-0, windowFrame.getBounds().y, newWidth, windowFrame.getHeight()));
                }
                
                // top resize
                if (cursorY < 0) {
                    final int y = evt.getYOnScreen();
                    newHeight = (int)(windowHeight * (Math.abs(cursorY*1.02f-windowHeight) / (float)windowHeight));
                    windowFrame.setBounds(new Rectangle(windowFrame.getBounds().x, y-0, windowWidth, newHeight));
                    return;
                }   
                
                if (cursorY > 0 && windowHeight != windowFrame.getMinimumSize().height) {
                    final int y = evt.getYOnScreen();
                    newHeight = (int)(windowHeight * (Math.abs(cursorY-windowHeight) / (float)windowHeight));
                    windowFrame.setBounds(new Rectangle(windowFrame.getBounds().x, y-0, windowWidth, newHeight));
                    return;
                }
                break;
            default:
                break;
        }
    }
    
    private void _recorrectWindowFrame() {
        if (cursorState == Fudz.BOTTOMRIGHT_RESIZE_STATE ||
            cursorState == Fudz.RIGHT_RESIZE_STATE ||
            cursorState == Fudz.BOTTOM_RESIZE_STATE)          // dont recorrect the frame height if the resizing is coming from bottom right or right
            return;
        
        if (cursorState != Fudz.TOPRIGHT_RESIZE_STATE) {
            // rightXOnScrn
            if (windowFrame.getX() + windowFrame.getWidth() < rightBoundXOnScrn) {
                final int numAdd = Math.abs(rightBoundXOnScrn - (windowFrame.getX() + windowFrame.getWidth()));
                windowFrame.setBounds(new Rectangle(windowFrame.getBounds().x, windowFrame.getBounds().y, windowFrame.getWidth()+numAdd, windowFrame.getHeight()));
                return;
            }
        
            if (windowFrame.getX() + windowFrame.getWidth() > rightBoundXOnScrn) {
                final int deduct = Math.abs(rightBoundXOnScrn - (windowFrame.getX() + windowFrame.getWidth()));
                windowFrame.setBounds(new Rectangle(windowFrame.getBounds().x, windowFrame.getBounds().y, windowFrame.getWidth()-deduct, windowFrame.getHeight()));
                return;
            }
        }
        
        if (cursorState == Fudz.BOTTOMLEFT_RESIZE_STATE) // dont recorrect the frame height if the resizing is coming from bottom left
            return;
        
        // bottomYOnScrn
        if (windowFrame.getY() + windowFrame.getHeight() < bottomBoundYOnScrn) {
            final int numAdd = Math.abs(bottomBoundYOnScrn - (windowFrame.getY()+ windowFrame.getHeight()));
            windowFrame.setBounds(new Rectangle(windowFrame.getBounds().x, windowFrame.getBounds().y, windowFrame.getWidth(), windowFrame.getHeight()+numAdd));
            return;
        }
        
        if (windowFrame.getY()+ windowFrame.getHeight() > bottomBoundYOnScrn) {
            final int deduct = Math.abs(bottomBoundYOnScrn - (windowFrame.getY()+ windowFrame.getHeight()));
            windowFrame.setBounds(new Rectangle(windowFrame.getBounds().x, windowFrame.getBounds().y, windowFrame.getWidth(), windowFrame.getHeight()-deduct));
        }
    }
}
