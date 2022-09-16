package net.koonts;

import javax.swing.*;
import java.awt.*;

public class Controls {
    ParticlePanel particlePanel;
    JPanel controlPanel = new JPanel();
    public Button resetButton = new Button();
    public Button randomResetButton = new Button();
    Controls(ParticlePanel particlePanel) {
        this.particlePanel = particlePanel;
        //
        //reset button
        resetButton.setLabel("Reset");
        resetButton.addActionListener(particlePanel);
        resetButton.setPreferredSize(new Dimension(60,20));
        resetButton.setVisible(true);
        controlPanel.add(resetButton);
        //
        //random reset button
        randomResetButton.setLabel("Random Reset");
        randomResetButton.addActionListener(particlePanel);
        randomResetButton.setPreferredSize(new Dimension(60,20));
        randomResetButton.setVisible(true);
        controlPanel.add(randomResetButton);
        //
    }

    //Controls//



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
