package com.company;
import javax.swing.*;
import java.awt.*;
import static javax.swing.SwingConstants.*;

/**
 * extends JFrame which is a high-level container that allows you
 * to create a custom container
 * the same is for the other existing classes in the package, besides the Main class.
 * in this class the application interface is set, putting the elements at their place.
 */

public class MainFrame extends JFrame {
    /**
     * @param configPanel is a instance of ConfigPanel class, it retains the configurations  of the current page,
     *                    it is situated at the NORTH of the page(up)
     * @param controlPanel is a instance of ControlPanel class, it contains the actions which the application is capable of
     * @param canvas it represents tha page that we draw on
     * @param shapePanel represents the control panel that sets the shape to be drawn, if none is selected, it draws the shape with the number of selected sizes
     */

    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    ShapePanel shapePanel;

    public MainFrame(){
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //create components
        configPanel = new ConfigPanel(this);

        controlPanel= new com.company.ControlPanel(this);

        shapePanel = new ShapePanel(this);

        canvas = new DrawingPanel(this);

        this.add(canvas, CENTER);

        this.add(configPanel, BorderLayout.NORTH);

        this.add(shapePanel, BorderLayout.EAST);

        this.add(controlPanel,BorderLayout.SOUTH);
        pack();
    }
}
