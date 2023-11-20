/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Properties;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author User
 */
public class JBtn extends JButton {
    private boolean over;
    private Color fill;
    private Color line;
    
    private Color filloriginal;
    private Color fillover;
    private Color fillClick;
    private Color lineOriginal;
    private Color lineOver;
    private int strokeWidth;

    public JBtn() {
        filloriginal = new Color(178,111,96);
        fillover = new Color(126,111,96);
        fillClick = new Color(253, 203, 110);
        lineOriginal = new Color(126,111,96);
        lineOver = new Color(178,111,96);
        fill = filloriginal;
        line = lineOriginal;
        strokeWidth = 2;
        setOpaque(false);
        setBorder(null);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBackground(filloriginal);
        setForeground(Color.white);
        setFont(getFont().deriveFont(Font.BOLD));
        setFont(getFont().deriveFont(14.0f));
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseExited(MouseEvent e) {
                fill = filloriginal;
                line = lineOriginal;
                over = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                fill = fillover;
                line = lineOver;
                over = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(over){
                    fill = fillover;
                    line = lineOver;
                }else{
                    fill = filloriginal;
                    line = lineOriginal;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                fill = fillClick;
            }
            
        });        
              
    }

    public Color getFilloriginal() {
        return filloriginal;
    }

    public void setFilloriginal(Color filloriginal) {
        this.filloriginal = filloriginal;
    }

    public Color getFillover() {
        return fillover;
    }

    public void setFillover(Color fillover) {
        this.fillover = fillover;
    }

    public Color getFillClick() {
        return fillClick;
    }

    public void setFillClick(Color fillClick) {
        this.fillClick = fillClick;
    }

    public Color getLineOriginal() {
        return lineOriginal;
    }

    public void setLineOriginal(Color lineOriginal) {
        this.lineOriginal = lineOriginal;
    }

    public Color getLineOver() {
        return lineOver;
    }

    public void setLineOver(Color lineOver) {
        this.lineOver = lineOver;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
    
    
    
    
    @Override
    protected void paintComponent(Graphics g){
        if(!isOpaque()){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int s = strokeWidth;
            int w = getWidth() - ( 2 * s );
            int h = getHeight() - ( 2 * s );
            //gambar background
            g2d.setColor(fill);
            g2d.fillRoundRect(s, s, w, h, h, h);
            //gambar border
            g2d.setStroke(new BasicStroke(s));
            g2d.setColor(line);
            g2d.drawRoundRect(s, s, w, h, h, h);
        }
        super.paintComponent(g);
    }
}
