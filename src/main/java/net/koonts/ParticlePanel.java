package net.koonts;
//https://github.com/hunar4321/particle-life
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ParticlePanel extends JPanel implements ActionListener {
    int SCREEN_WIDTH = 600;
    int SCREEN_HEIGHT = 600;
    int UNIT_SIZE = 10;
    int GAME_UNIT = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE);
    int DELAY = 100;
    //simulation variables
    ArrayList<Atom> atoms = new ArrayList<>();
    ArrayList<Object> atomgroup = new ArrayList<>();


    Timer timer = new Timer(DELAY, this);

    ParticlePanel() {
        timer.start();
    }




    public void draw(Graphics g) {
        for (int i=0;i<SCREEN_WIDTH/UNIT_SIZE;i++) {
            g.drawLine(i * UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }


}
