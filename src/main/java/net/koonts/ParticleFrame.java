package net.koonts;

import javax.swing.*;
import java.awt.*;

public class ParticleFrame extends JFrame {
    ParticleFrame() {
        //gui
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(810,610));
        this.setResizable(false);

        Box box = new Box(BoxLayout.Y_AXIS);
        box.setSize(new Dimension(600,600));
//        box.setAlignmentY(JComponent.RIGHT_ALIGNMENT);
        this.add(box);
        Insets insetsBox = box.getInsets();

        ParticlePanel particlePanel = new ParticlePanel();
//        particlePanel.controls.controlPanel.setLocation(600,0);
        particlePanel.setPreferredSize(new Dimension(600,600));
        particlePanel.setVisible(true);
        box.add(particlePanel);

        Controls controls = particlePanel.controls;
        controls.makeGUI(particlePanel);
//        controls.setPreferredSize(new Dimension(200,600));
        controls.setBounds(insetsBox.right+20,insetsBox.top+20,60,20);
//        box.add(controls);
        this.add(controls);

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
//        particlePanel.start();

    }
}
