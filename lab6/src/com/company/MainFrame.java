package com.company;

import javax.naming.ldap.Control;
import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame(){
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //create components
        configPanel = new ConfigPanel(this);

        controlPanel= new com.company.ControlPanel(this);

        canvas = new DrawingPanel(this);



        //arrange the components in the container(frame)
        //JFrame uses a BorderLayout by default
        this.add(canvas, CENTER); //this is BorderLayout.CENTER

        this.add(configPanel, BorderLayout.NORTH);

        this.add(controlPanel,BorderLayout.SOUTH);
        //invoke the layout manager
        pack();
    }

    public MainFrame getMainFrame(){
        return this;
    }
}
