package com.fudz.custom;

import com.fudz.restau.Fudz;
import static com.fudz.restau.WindowFrame.isResizingWindowOnDrag;
import java.awt.Cursor;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

/**
 *
 * @author Rene Tajos Jr.
 */
public class FudzFrame extends JFrame {
    
    private static boolean isResizable = true;
    
    public static int lastWindowState = -1;
    
    private MouseMotionListener mouseMotionListener;
    private MouseListener mouseListener;
    
    protected int cursorState = Fudz.DEFAULT_STATE;
    protected static int rightBoundXOnScrn, bottomBoundYOnScrn;
    
    private FudzMouseListener fudzMouseListener;
    
    public interface FudzMouseListener {
        void onPressed();
        void onDragged();
    }
    
    public FudzFrame() {
        _initMouseListeners();
        
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseMotionListener);
    }
    
    public void setFudzMouseListener(FudzMouseListener listener) {
        fudzMouseListener = listener;
    }
    
    public void setResizable(boolean _isResizable) {
        isResizable = _isResizable;
    }
    
    public static boolean isFrameResizable() {
        return isResizable;
    }
    
    private void _initMouseListeners() {
        mouseListener = new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!isResizable)
                    return;
                
                rightBoundXOnScrn = FudzFrame.this.getX() + FudzFrame.this.getWidth();
                bottomBoundYOnScrn = FudzFrame.this.getY() + FudzFrame.this.getHeight();
                fudzMouseListener.onPressed();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (!isResizable)
                    return;
                
                isResizingWindowOnDrag[0] = false;
                FudzFrame.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                _recorrectWindowFrame();
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
                if (!isResizable)
                    return;
                
                _resizeWindow(e);
                fudzMouseListener.onDragged();
                _recorrectWindowFrame();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (!isResizable)
                    return;
                
                _detectBounds(e);
            }
            
        };
    }
    /*
    * This will detect the bounds of the frame and depending of where the
    * mouse pointer is located, it will change the cursor image
    */
    protected void _detectBounds(java.awt.event.MouseEvent evt) {
        final int cursorX = evt.getX();
        final int cursorY = evt.getY();
        final int heightThreshold = 8; // mouse point height threshold
        final int widthThreshold = 3; // mouse point width threshold
        final int frameHeight = this.getBounds().height;
        final int frameWidth = this.getBounds().width;
        
         //detects left bound
        if (cursorX >= 0 && cursorX <= widthThreshold && cursorY < frameHeight-heightThreshold && cursorY > heightThreshold) {
            cursorState = Fudz.LEFT_RESIZE_STATE;
            this.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
        //detects bottomLeft point
        } else if(cursorX >= 0 && cursorX <= 4 && cursorY >= frameHeight-heightThreshold && cursorY <= frameHeight) {
            cursorState = Fudz.BOTTOMLEFT_RESIZE_STATE;
            this.setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
        //detects right bound
        } else if(cursorX >= frameWidth - widthThreshold && cursorX <= frameWidth && cursorY < frameHeight-heightThreshold && cursorY > heightThreshold) {
            cursorState = Fudz.RIGHT_RESIZE_STATE;
            this.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
        //detects bottomRight point
        } else if(cursorX >= frameWidth - widthThreshold && cursorX <= frameWidth && cursorY >= frameHeight-heightThreshold && cursorY <= frameHeight) {
            cursorState = Fudz.BOTTOMRIGHT_RESIZE_STATE;
            this.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
        //detects bottom bound
        } else if (cursorY >= frameHeight-heightThreshold && cursorY <= frameHeight && cursorX >= widthThreshold) {
            cursorState = Fudz.BOTTOM_RESIZE_STATE;
            this.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
        //detects top right point
        } else if(cursorX >= frameWidth - widthThreshold && cursorX <= frameWidth && cursorY >= 0 && cursorY <= heightThreshold) {
            cursorState = Fudz.TOPRIGHT_RESIZE_STATE;
            this.setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
        //detects top bound
        } else if(cursorY >= 0 && cursorY <= heightThreshold && cursorX > widthThreshold && cursorX < frameWidth - widthThreshold) {
            cursorState = Fudz.TOP_RESIZE_STATE;
            this.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
        //detects topLeft point
        } else if(cursorX >= 0 && cursorX <= widthThreshold && cursorY >= 0 && cursorY <= heightThreshold) {
            cursorState = Fudz.TOPLEFT_RESIZE_STATE;
            this.setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
        } else {
            cursorState = Fudz.DEFAULT_STATE;
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    private void _resizeWindow(java.awt.event.MouseEvent evt) {
        final int cursorX = evt.getX();
        final int cursorY = evt.getY();
        final int windowWidth = this.getWidth();
        final int windowHeight = this.getHeight();
        
        int newWidth=0, newHeight=0;
        
        switch (cursorState) {
            // resize from right bound
            case Fudz.RIGHT_RESIZE_STATE:
                isResizingWindowOnDrag[0] = true;
                newWidth = (int)(windowWidth * (cursorX / (float)windowWidth));
                this.setBounds(new Rectangle(this.getBounds().x, this.getBounds().y, newWidth, this.getHeight()));
                break;
            // resize from left bound
            case Fudz.LEFT_RESIZE_STATE:
                isResizingWindowOnDrag[0] = true;
                if (cursorX < 0) {
                    final int x = evt.getXOnScreen();
                    newWidth = (int)(windowWidth * (Math.abs(cursorX*1.05f-windowWidth) / (float)windowWidth));
                    this.setBounds(new Rectangle(x-0, this.getBounds().y, newWidth, this.getHeight()));
                }
                
                if (cursorX > 0 && windowWidth != this.getMinimumSize().width) {
                    final int x = evt.getXOnScreen();
                    newWidth = (int)(windowWidth * (Math.abs(cursorX-windowWidth) / (float)windowWidth));
                    this.setBounds(new Rectangle(x-0, this.getBounds().y, newWidth, this.getHeight()));
                }
                break;
            // resize from bottom bound
            case Fudz.BOTTOM_RESIZE_STATE:
                isResizingWindowOnDrag[0] = true;
                newHeight = (int)(windowHeight * (cursorY / (float)windowHeight));
                this.setBounds(new Rectangle(this.getBounds().x, this.getBounds().y, this.getWidth(), newHeight));
                break;
            // resize from top bound
            case Fudz.TOP_RESIZE_STATE:
                isResizingWindowOnDrag[0] = true;
                if (cursorY < 0) {
                    final int y = evt.getYOnScreen();
                    newHeight = (int)(windowHeight * (Math.abs(cursorY*1.05f-windowHeight) / (float)windowHeight));
                    this.setBounds(new Rectangle(this.getBounds().x, y-0, windowWidth, newHeight));
                }
                
                if (cursorY > 0 && windowHeight != this.getMinimumSize().height) {
                    final int y = evt.getYOnScreen();
                    newHeight = (int)(windowHeight * (Math.abs(cursorY-windowHeight) / (float)windowHeight));
                    this.setBounds(new Rectangle(this.getBounds().x, y-0, windowWidth, newHeight));
                }
                break;
            case Fudz.BOTTOMRIGHT_RESIZE_STATE:
                newWidth = (int)(windowWidth * (cursorX / (float)windowWidth));
                newHeight = (int)(windowHeight * (cursorY / (float)windowHeight));
                this.setBounds(new Rectangle(this.getBounds().x, this.getBounds().y, newWidth, newHeight));
                break;
            case Fudz.BOTTOMLEFT_RESIZE_STATE:
                isResizingWindowOnDrag[0] = true;
                if (cursorX < 0) {
                    int x = evt.getXOnScreen();
                    newWidth = (int)(windowWidth * (Math.abs(cursorX*1.05f-windowWidth) / (float)windowWidth));
                    newHeight = (int)(windowHeight * (cursorY / (float)windowHeight));
                    this.setBounds(new Rectangle(x-0, this.getBounds().y, newWidth, newHeight));
                }
                
                if (cursorX >= 0) {
                    int x = evt.getXOnScreen();
                    
                    if (windowWidth != this.getMinimumSize().width)
                        newWidth = (int)(windowWidth * (Math.abs(cursorX-windowWidth) / (float)windowWidth));
                    
                    if (windowHeight != this.getMinimumSize().height)
                        newHeight = (int)(windowHeight * (cursorY / (float)windowHeight));
                    
                    this.setBounds(new Rectangle(newWidth==0?this.getBounds().x:x-0, this.getBounds().y, newWidth==0?windowWidth:newWidth, newHeight==0?windowHeight:newHeight));
                }
                break;
            case Fudz.TOPRIGHT_RESIZE_STATE:
                isResizingWindowOnDrag[0] = true;
                isResizingWindowOnDrag[1] = true;
                if (cursorY < 0) {
                    final int y = evt.getYOnScreen();
                    newHeight = (int)(windowHeight * (Math.abs(cursorY*1.05f-windowHeight) / (float)windowHeight));
                    newWidth = (int)(windowWidth * (cursorX / (float)windowWidth));
                    this.setBounds(new Rectangle(this.getBounds().x, y-0, newWidth, newHeight));
                }
                
                if (cursorY >= 0) {
                    final int y = evt.getYOnScreen();
                    
                    if (windowHeight != this.getMinimumSize().height)
                        newHeight = (int)(windowHeight * (Math.abs(cursorY-windowHeight) / (float)windowHeight));
                    
                    if (windowWidth != this.getMinimumSize().width)
                        newWidth = (int)(windowWidth * (cursorX / (float)windowWidth));
                    
                    this.setBounds(new Rectangle(this.getBounds().x, newHeight==0?this.getBounds().y:y-0, newWidth==0?windowWidth:newWidth, newHeight==0?windowHeight:newHeight));
                }
                
                break;
            case Fudz.TOPLEFT_RESIZE_STATE:
                isResizingWindowOnDrag[0] = true;
                isResizingWindowOnDrag[1] = true;
                
                // left resize
                if (cursorX < 0) {
                    final int x = evt.getXOnScreen();
                    newWidth = (int)(windowWidth * (Math.abs(cursorX*1.02f-windowWidth) / (float)windowWidth));
                    this.setBounds(new Rectangle(x-0, this.getBounds().y, newWidth, this.getHeight()));
                }
                
                if (cursorX > 0 && windowWidth != this.getMinimumSize().width) {
                    final int x = evt.getXOnScreen();
                    newWidth = (int)(windowWidth * (Math.abs(cursorX-windowWidth) / (float)windowWidth));
                    this.setBounds(new Rectangle(x-0, this.getBounds().y, newWidth, this.getHeight()));
                }
                
                // top resize
                if (cursorY < 0) {
                    final int y = evt.getYOnScreen();
                    newHeight = (int)(windowHeight * (Math.abs(cursorY*1.02f-windowHeight) / (float)windowHeight));
                    this.setBounds(new Rectangle(this.getBounds().x, y-0, windowWidth, newHeight));
                    return;
                }   
                
                if (cursorY > 0 && windowHeight != this.getMinimumSize().height) {
                    final int y = evt.getYOnScreen();
                    newHeight = (int)(windowHeight * (Math.abs(cursorY-windowHeight) / (float)windowHeight));
                    this.setBounds(new Rectangle(this.getBounds().x, y-0, windowWidth, newHeight));
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
            if (this.getX() + this.getWidth() < rightBoundXOnScrn) {
                final int numAdd = Math.abs(rightBoundXOnScrn - (this.getX() + this.getWidth()));
                this.setBounds(new Rectangle(this.getBounds().x, this.getBounds().y, this.getWidth()+numAdd, this.getHeight()));
                return;
            }
        
            if (this.getX() + this.getWidth() > rightBoundXOnScrn) {
                final int deduct = Math.abs(rightBoundXOnScrn - (this.getX() + this.getWidth()));
                this.setBounds(new Rectangle(this.getBounds().x, this.getBounds().y, this.getWidth()-deduct, this.getHeight()));
                return;
            }
        }
        
        if (cursorState == Fudz.BOTTOMLEFT_RESIZE_STATE) // dont recorrect the frame height if the resizing is coming from bottom left
            return;
        
        // bottomYOnScrn
        if (this.getY() + this.getHeight() < bottomBoundYOnScrn) {
            final int numAdd = Math.abs(bottomBoundYOnScrn - (this.getY()+ this.getHeight()));
            this.setBounds(new Rectangle(this.getBounds().x, this.getBounds().y, this.getWidth(), this.getHeight()+numAdd));
            return;
        }
        
        if (this.getY()+ this.getHeight() > bottomBoundYOnScrn) {
            final int deduct = Math.abs(bottomBoundYOnScrn - (this.getY()+ this.getHeight()));
            this.setBounds(new Rectangle(this.getBounds().x, this.getBounds().y, this.getWidth(), this.getHeight()-deduct));
        }
    }
    
    public static void maximizeFrame(FudzFrame _frame) {
        lastWindowState = Fudz.WINDOW_MAXIMIZE;
        _frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();  
        _frame.setMaximizedBounds(env.getMaximumWindowBounds());
    }
}
