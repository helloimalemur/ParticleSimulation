package net.koonts;
//https://github.com/hunar4321/particle-life
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ParticlePanel extends JPanel implements ActionListener {
    int SCREEN_WIDTH = 500;
    int SCREEN_HEIGHT = 500;
    int UNIT_SIZE = 10;
    int GAME_UNIT = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE);
    int DELAY = 100;
    //simulation variables
    ArrayList<Atom> atoms = new ArrayList<Atom>();
    Random random = new Random();

    ArrayList<Atom> yellow = this.createAtoms(200, 'y');
    ArrayList<Atom> red = this.createAtoms(200, 'r');
    ArrayList<Atom> green = this.createAtoms(200, 'g');
    ArrayList<Atom> blue = this.createAtoms(200, 'b');




    ParticlePanel() {


        Timer timer = new Timer(DELAY, this);
        timer.start();
    }

    public int random(){
        int v = (random.nextInt(100)*5)-10;
        return v;
    }

    public Color getColor(char c) {
        if (c=='g') {return Color.green;}
        if (c=='r') {return Color.red;}
        if (c=='b') {return Color.blue;}
        if (c=='y') {return Color.yellow;}
        return null;
    }
    public void update() {
        interactionRule(green, green, -0.32);
        interactionRule(green, red, -0.17);
        interactionRule(green, yellow, 0.34);
        interactionRule(red, red, -0.1);
        interactionRule(red, green, -0.34);
        interactionRule(yellow, yellow, 0.15);
        interactionRule(yellow, green, -0.2);


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
    public void interactionRule(ArrayList<Atom> atoms1, ArrayList<Atom> atoms2, double g) {
        for (int i = 0; i < atoms1.size(); i++) {
            double fx = 0;
            double fy = 0;
            Atom a = atoms1.get(i);
            for (int j = 0; j < atoms2.size(); j++) {
                a = atoms1.get(i);
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
            a.vx = ((a.vx + fx) * 0.5);
            a.vy = ((a.vy + fy) * 0.5);
            a.x += a.vx;
            a.y += a.vy;
            if (a.x <= 0 || a.x >= 500) {
                a.vx *= -1;
            }
            if (a.y <= 0 || a.y >= 500) {
                a.vy *= -1;
            }
        }
    }


    public void draw(Graphics graphics) {
        for (int i = 0; i < atoms.size(); i++) {
            graphics.setColor(getColor(atoms.get(i).getC()));
            graphics.fillOval((int) atoms.get(i).x,(int) atoms.get(i).y,5,5);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        repaint();
        update();
    }
}
