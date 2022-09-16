package net.koonts;

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
