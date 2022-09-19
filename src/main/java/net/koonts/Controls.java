package net.koonts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class Controls extends JPanel{
    ParticlePanel particlePanel;
//    JPanel controlPanel = new JPanel();
    public JButton resetButton = new JButton();
    public JButton randomResetButton = new JButton();
    public JLabel totalAtoms = new JLabel();
    Controls(ParticlePanel particlePanel) {
        this.particlePanel = particlePanel;
//        this.setLayout(new GridLayout(6,1));
        this.setLayout(new GridLayout(6,2));
//        this.setBounds(600,0,200,600);
        this.setPreferredSize(new Dimension(200,600));
        this.setVisible(true);
//        this.setBackground(Color.black);//debug
    }

    //Controls//
    public void makeGUI(ActionListener actionListener) {
        //reset button
        resetButton.setText("Reset");
        resetButton.addActionListener(actionListener);
        resetButton.setPreferredSize(new Dimension(60,20));
//        resetButton.setBounds(600,0,60,40);
        resetButton.setVisible(true);
        this.add(resetButton);
        //
        //random reset button
        randomResetButton.setText("Random Reset");
        randomResetButton.addActionListener(actionListener);
        randomResetButton.setPreferredSize(new Dimension(60,20));
//        resetButton.setBounds(0,0,60,40);
        randomResetButton.setVisible(true);
        this.add(randomResetButton);

        //number of atoms
        JPanel atomsPanel = new JPanel();
        atomsPanel.setLayout(new BorderLayout());
        JLabel atomsName = new JLabel();
        atomsPanel.setPreferredSize(new Dimension(160,20));
        totalAtoms.setPreferredSize(new Dimension(80,20));
        atomsName.setPreferredSize(new Dimension(80,20));
        atomsName.setText("Total Atoms: ");
        totalAtoms.setVisible(true);
        atomsName.setVisible(true);
        atomsPanel.add(atomsName, BorderLayout.WEST);
        atomsPanel.add(totalAtoms, BorderLayout.EAST);


        this.add(atomsPanel);
        //number of rules
        //




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
