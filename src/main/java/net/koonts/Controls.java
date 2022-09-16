package net.koonts;

import java.awt.*;

public class Controls {
    ParticlePanel particlePanel;
    public Button resetButton = new Button();
    Controls(ParticlePanel particlePanel) {
        this.particlePanel = particlePanel;
        //buttons

        resetButton.addActionListener(particlePanel);
        resetButton.setPreferredSize(new Dimension(60,20));
        resetButton.setVisible(true);
        particlePanel.add(resetButton);
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
