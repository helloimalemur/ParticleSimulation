package net.koonts;

import javax.swing.*;
import java.awt.*;

public class ParticleFrame extends JFrame {
    ParticleFrame() {
        Box box = new Box(BoxLayout.Y_AXIS);
        box.setAlignmentY(JComponent.RIGHT_ALIGNMENT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(810,610));
        ParticlePanel particlePanel = new ParticlePanel();
        particlePanel.setPreferredSize(new Dimension(600,600));
        this.setResizable(false);
        particlePanel.setVisible(true);
        //gui
        box.add(particlePanel);


        this.add(box);
        box.add(particlePanel.controls.controlPanel);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
//        particlePanel.start();

    }
}
