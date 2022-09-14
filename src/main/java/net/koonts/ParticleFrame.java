package net.koonts;

import javax.swing.*;
import java.awt.*;

public class ParticleFrame extends JFrame {
    ParticleFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1000,600));
        ParticlePanel particlePanel = new ParticlePanel();
        particlePanel.setPreferredSize(new Dimension(600,600));
        particlePanel.setLocation(50,50);
        this.setResizable(false);
        particlePanel.setVisible(true);
        this.add(particlePanel);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
