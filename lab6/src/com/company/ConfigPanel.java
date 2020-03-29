package com.company;
import javax.swing.*;

/**
 * a class that deals with the option for drawing the canvas
 */
public class ConfigPanel extends  JPanel{
    /**
     * @param frame is the main frame, the frame that contains everything
     * @param sidesField represents the sides of the shape that is going to be drawn
     * @param colorCombo represents the list of diponible colors
     */
    final MainFrame frame;
    JSpinner sidesField;
    JComboBox colorCombo;


    public ConfigPanel(MainFrame frame){
        this.frame=frame;
        init();
    }

    private void init(){

        JLabel sidesLabel = new JLabel("Number of sides:");
        JLabel colorLabel = new JLabel("Color:");

        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(3);

        String[] colors={"Random","Red","Black"};
        colorCombo=new JComboBox(colors);


        add(sidesLabel);
        add(sidesField);
        add(colorLabel);
        add(colorCombo);



    }
}
