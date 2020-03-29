package com.company;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * in this class the control panel is created,
 * the buttons are created and the action for each button is set
 */
public class ControlPanel extends JPanel {
    /**
     * @param frame the main frame
     * @param saveBtn a button, when pressed it saves the drawn at a specific location
     * @param loadBtn a button, when pressed it loads a specific drawn, and allows you to keep drawing
     * @param resetBtn a button, when pressed resets the canvas to a blank white space
     * @param exitBtn a button, when pressed it closes the application
     */
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn= new JButton("Load");
    JButton resetBtn= new JButton("Reset");
    JButton exitBtn= new JButton("Exit");
    //create all buttons (Load, Reset, Exit)

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);

    }
    private void save(ActionEvent e) {
        try {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            int returnValue = jfc.showOpenDialog(null);
            // int returnValue = jfc.showSaveDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                ImageIO.write(frame.canvas.image, "PNG",selectedFile);

            }
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void load(ActionEvent e){
        BufferedImage image = null;
        try {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            int returnValue = jfc.showOpenDialog(null);
            // int returnValue = jfc.showSaveDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                image = ImageIO.read(selectedFile);

            }

            this.frame.canvas.image = image;
            assert this.frame.canvas.image != null;
            this.frame.canvas.graphics = this.frame.canvas.image.createGraphics();
            frame.canvas.validate();
            frame.canvas.repaint();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private void reset(ActionEvent e){
        frame.canvas.createOffScreenImage();
        frame.canvas.validate();
        frame.canvas.repaint();
    }

    private void exit(ActionEvent e) {
        System.exit(0);
    }
}
