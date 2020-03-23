package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * a class that permits to drawn a certain shapes on the canvas 
 * the method createOffScreen() creates the background that is going to be painted
 * the mothod init() draws at the coordonates of the action performed (click in this case)
 * it uses the drawShape() method to draw shapes based on a random/selected color
 * with a random size, with a selected number of sides
 * the method update was overrided because if we didn't it would have had a different behaviour
 * because it would have appealed the method from the parent class
 * the other method that was overrided, the paintComponent() was overrided to paint what we need to, with the parameters that we set
 * -->Draws as much of the specified image as has already been scaled to fit inside the specified rectangle.<-- the usage of the paintComponent
 */

public class DrawingPanel extends JPanel {
    /**
     * @param frame the main frame
     * @param W the weight of the page
     * @param H the height of the page
     * @param image the background image, basically the canvas
     * @param graphics a graphics2D component that allows the drawing of certain shapes based on certain specifications
     *                 in that specification, the color may be random or selected between red or black
     *                 the dimension is random
     *                 and the shape may be set by setting the number of sides of the shape
     */
    final MainFrame frame;
    final static int W = 800, H=600;

    BufferedImage image;
    Graphics2D graphics;
    public DrawingPanel(MainFrame frame){
        this.frame= frame;
        createOffScreenImage();
        init();
    }

    void createOffScreenImage(){
        image= new BufferedImage(W,H,BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,W,H);
    }

    private void init(){
        setPreferredSize(new Dimension(W,H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(),e.getY()); repaint();
            }
        });
    }
    private void drawShape(int x, int y){
        Random rand=new Random();
        int radius=rand.nextInt(100);
        int sides = (int)frame.configPanel.sidesField.getValue();
        if(frame.configPanel.colorCombo.getSelectedItem()!=null)
        {
            if(frame.configPanel.colorCombo.getSelectedItem().equals("Red")){
                graphics.setColor(Color.RED);
            }
            else
                if(frame.configPanel.colorCombo.getSelectedItem().equals("Black")){
                graphics.setColor(Color.BLACK);
            }
                else{
                    Color color=new Color( rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), rand.nextInt(200));
                    graphics.setColor(color);
                }
        }
        graphics.fill(new RegularPolygon(x, y, radius, sides));    }


    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image,0,0,this);
    }
}
