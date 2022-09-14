package net.koonts;
//https://github.com/hunar4321/particle-life
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ParticlePanel extends JPanel implements ActionListener {
    int SCREEN_WIDTH = 600;
    int SCREEN_HEIGHT = 600;
    int DELAY = 100;
    Random random = new Random();

    //simulation variables
    ArrayList<Atom> atoms = new ArrayList<Atom>();


    //create atoms
    ArrayList<Atom> yellow = this.createAtoms(300, 'y');
    ArrayList<Atom> red = this.createAtoms(300, 'r');
    ArrayList<Atom> green = this.createAtoms(300, 'g');
    ArrayList<Atom> blue = this.createAtoms(300, 'b');




    ParticlePanel() {
        //start timer which activates action listener on DELAY interval
        Timer timer = new Timer(DELAY, this);
        timer.start();
    }

    public int random(){
        //used for placement of new atoms
        int v = (random.nextInt(100)*6);
        return v;
    }

    public Color getColor(char c) {
        //transcribe char to Java color object
        if (c=='g') {return Color.green;}
        if (c=='r') {return Color.red;}
        if (c=='b') {return Color.blue;}
        if (c=='y') {return Color.yellow;}
        return null;
    }
    public void update() {
        //run interaction rules on atoms
        interactionRule(green, green, -0.28);
        interactionRule(green, red, -0.17);
        interactionRule(green, yellow, 0.5);
        interactionRule(red, red, -0.1);
        interactionRule(red, green, -0.34);
        interactionRule(yellow, yellow, 0.15);
        interactionRule(yellow, green, -0.2);
        interactionRule(blue, blue, -0.1);
        interactionRule(green, blue, -0.2);
        interactionRule(yellow, blue, 0.2);
    }


    public ArrayList<Atom> createAtoms(int number, char color) {
        //create atoms and pack into ArrayList(s), 'atomgroup' and 'atoms'
        ArrayList<Atom> atomgroup = new ArrayList<>(); //used to pass atoms to individual color array(s), reference for ALL atoms packed into 'atoms' array
        for (int i=0;i<number;i++) { //with separate arrays for each color we can run interactions on each, then paint all atoms using 'atoms'
            Atom atom = new Atom(random(), random(), color);
            atomgroup.add(i, atom);
            atoms.add(atomgroup.get(i));
            //atoms.add(i, atom);
        }
        return atomgroup;
        //return atoms;
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
            if (a.x <= 0 || a.x >= SCREEN_WIDTH) {
                a.vx *= -1;
            }
            if (a.y <= 0 || a.y >= SCREEN_HEIGHT) {
                a.vy *= -1;
            }
        }
    }


    public void draw(Graphics graphics) {
        for (int i = 0; i < atoms.size(); i++) {
            graphics.setColor(getColor(atoms.get(i).getC()));
            graphics.fillOval((int) atoms.get(i).x,(int) atoms.get(i).y,5,5);// cast x/y to int to draw atoms
        }
    }

    @Override
    public void paintComponent(Graphics g) { //override abstract method inhereted from extending JPanel
        super.paintComponent(g);
        draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) { //override abstract method inhereted from implementing actionlistener
        //we activate this using timer
        repaint(); //repaint the graphics
        update(); //update atom interactions
    }
}
