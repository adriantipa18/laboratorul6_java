package com.company;
import javax.swing.*;
/**
 * in this class the shape panel is created,
 * it contains a button that retains the shape wanted to be drawn
 */

public class ShapePanel extends JPanel {
    /**
     * @param frame is the main frame, the frame that contains everything
     * @param shapeCombo represents a JComboBox that contains the options for a shape to be drawn
     */
    final MainFrame frame;
    JComboBox<String> shapesCombo;

    public ShapePanel(MainFrame frame){
        this.frame=frame;
        init();
    }

    private void init(){
        JLabel shapesLabel = new JLabel("Shapes:");

        String[] shapes = {"none","square", "circle","shape"};
        shapesCombo=new JComboBox<String>(shapes);

        add(shapesLabel);
        add(shapesCombo);

    }

}
