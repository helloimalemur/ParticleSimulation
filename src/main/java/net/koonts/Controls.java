package net.koonts;

import javax.swing.*;

public class Controls {
    ParticlePanel particlePanel;
    Controls(ParticlePanel particlePanel) {
        this.particlePanel = particlePanel;
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
        create();

    }
    public void create(){
        particlePanel.yellow = particlePanel.createAtoms(300, 'y');
        particlePanel.red = particlePanel.createAtoms(300, 'r');
        particlePanel.green = particlePanel.createAtoms(300, 'g');
        particlePanel.blue = particlePanel.createAtoms(300, 'b');
        particlePanel.magenta = particlePanel.createAtoms(300, 'm');
    }
    //start
//    public void start(){
//        timer.start();
//    }
    //stop
    public void stop(){
        particlePanel.timer.stop();
    }
    //randomize rules//manual rules
    //random number of rules//set number of rules


    public void start(){
        particlePanel.timer.start();

    }

}
