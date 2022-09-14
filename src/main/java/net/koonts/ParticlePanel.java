package net.koonts;
//https://github.com/hunar4321/particle-life
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ParticlePanel extends JPanel implements ActionListener {
    int SCREEN_WIDTH = 600;
    int SCREEN_HEIGHT = 600;
    int UNIT_SIZE = 10;
    int GAME_UNIT = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE);
    int DELAY = 100;
    //simulation variables
    ArrayList<Atom> atoms = new ArrayList<Atom>();
    Random random = new Random();


    Timer timer = new Timer(DELAY, this);

    ParticlePanel() {
        timer.start();
    }

    public int random(){
        int v = (random.nextInt(100)*4)+50;
        return v;
    }

    //create atoms
    public ArrayList<Atom> createAtoms(int number, char color) {
        ArrayList<Atom> atomgroup = new ArrayList<>();
        for (int i=0;i<number;i++) {
            Atom atom = new Atom(random(), random(), color);
            atomgroup.add(i, atom);
            atoms.add(atomgroup.get(i));
        }
        return atomgroup;
    }

    //atom interaction rules
    public void interactionRule(ArrayList<Atom> atoms1, ArrayList<Atom> atoms2, int g) {
        for (int i = 0; i < atoms1.size(); i++) {
            int fx = 0;
            int fy = 0;
            Atom a = atoms1.get(i);
            for (int j = 0; j < atoms2.size(); j++) {

                Atom b = atoms2.get(j);
                double dx = a.x - b.x;
                double dy = a.y - b.y;
                double d = Math.sqrt(dx * dx + dy * dy);
                if (d > 0 && d < 80) {
                    double F = (g * 1) / d;
                    fx += F * dx;
                    fy += F * dy;
                }
            }
            a.vx = (int) ((a.vx + fx) * 0.5);// casted to int -prob??
            a.vy = (int) ((a.vy + fy) * 0.5);
            a.x += a.vx;
            a.y += a.vy;
            if (a.x <= 0 || a.x >= 500) { a.vx *= -1; }
            if (a.y <= 0 || a.y >= 500) { a.vy *= -1; }
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
