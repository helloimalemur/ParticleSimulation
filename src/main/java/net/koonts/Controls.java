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
    public JButton randomRulesButton = new JButton();
    public JLabel totalAtoms = new JLabel();
    public JLabel totalRules = new JLabel();
    Controls(ParticlePanel particlePanel) {
        this.particlePanel = particlePanel;
        this.setLayout(new GridLayout(12,2));
        this.setPreferredSize(new Dimension(200,600));
        this.setVisible(true);
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

        //randomize rules
        randomRulesButton.setText("Random Rules");
        randomRulesButton.addActionListener(actionListener);
        randomRulesButton.setPreferredSize(new Dimension(60,20));
        randomRulesButton.setVisible(true);
        this.add(randomRulesButton);


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

//        //number of rules
        JPanel rulesPanel = new JPanel();
        rulesPanel.setLayout(new BorderLayout());
        JLabel rulesName = new JLabel();
        rulesPanel.setPreferredSize(new Dimension(160,20));
        totalRules.setPreferredSize(new Dimension(80,20));
        rulesName.setPreferredSize(new Dimension(80,20));
        rulesName.setText("Total Rules: ");
        totalRules.setVisible(true);
        rulesName.setVisible(true);
        rulesPanel.add(rulesName, BorderLayout.WEST);
        rulesPanel.add(totalRules, BorderLayout.EAST);
        this.add(rulesPanel);


        //rules
//        JPanel rulePanel = new JPanel();
//        rulePanel.setLayout(new BorderLayout());
//        JLabel ruleName = new JLabel();
//        rulePanel.setPreferredSize(new Dimension(160,20));
//        ruleName.setPreferredSize(new Dimension(80,20));
//        ruleName.setText("Rules: ");
//        ruleName.setVisible(true);
//        rulePanel.add(ruleName);
//        this.add(rulePanel);

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
        particlePanel.randomRules();
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
        particlePanel.randomRules();
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
