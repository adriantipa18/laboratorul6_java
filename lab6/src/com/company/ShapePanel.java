package com.company;
import javax.swing.*;


public class ShapePanel extends JPanel {
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
