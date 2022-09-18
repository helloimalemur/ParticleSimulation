package net.koonts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class Controls extends JPanel{
    ParticlePanel particlePanel;
//    JPanel controlPanel = new JPanel();
    public Button resetButton = new Button();
    public Button randomResetButton = new Button();
    Controls(ParticlePanel particlePanel) {
        this.particlePanel = particlePanel;
        this.setLayout(new GridLayout(6,1));
        this.setBounds(600,0,200,600);
//        this.setPreferredSize(new Dimension(60,600));
        this.setVisible(true);
//        this.setBackground(Color.black);//debug
    }

    //Controls//
    public void makeGUI(ActionListener actionListener) {
        //reset button
        resetButton.setLabel("Reset");
        resetButton.addActionListener(actionListener);
//        resetButton.setPreferredSize(new Dimension(60,20));
//        resetButton.setBounds(600,0,60,40);
        resetButton.setVisible(true);
        this.add(resetButton);
        //
        //random reset button
        randomResetButton.setLabel("Random Reset");
        randomResetButton.addActionListener(actionListener);
//        randomResetButton.setPreferredSize(new Dimension(60,20));
//        resetButton.setBounds(0,0,60,40);
        randomResetButton.setVisible(true);
        this.add(randomResetButton);
    }


    //reset
    public void resetSim(){
        particlePanel.timer.stop();
        particlePanel.atoms.clear();
        particlePanel.red.clear();
        particlePanel.green.clear();
        particlePanel.blue.clear();
        particlePanel.yellow.clear();
        particlePanel.magenta.clear();
        particlePanel.createAtoms();
        particlePanel.timer.start();
    }
    //resetRandom
    public void resetRandom(){
        particlePanel.timer.stop();
        particlePanel.atoms.clear();
        particlePanel.red.clear();
        particlePanel.green.clear();
        particlePanel.blue.clear();
        particlePanel.yellow.clear();
        particlePanel.magenta.clear();
        particlePanel.createRandomAtoms();
        particlePanel.timer.start();
    }
    //start
    public void start(){
        particlePanel.timer.start();
    }

    //stop
    public void stop(){
        particlePanel.timer.stop();
    }
    //randomize rules//manual rules

    //random number of rules//set number of rules


}
