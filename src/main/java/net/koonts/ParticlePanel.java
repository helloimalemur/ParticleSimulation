package net.koonts;
//https://github.com/hunar4321/particle-life
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ParticlePanel extends JPanel implements ActionListener {
    double SCREEN_WIDTH = 600;
    double SCREEN_HEIGHT = 600;
    int DELAY = 60;//
    Random random = new Random();

    //simulation variables
    Controls controls = new Controls(this);
    Utils utils = new Utils(this);
    Timer timer = new Timer(DELAY, this);//start timer which activates action listener on DELAY interval
    ArrayList<Atom> atoms = new ArrayList<Atom>();


    //create atoms
    ArrayList<Atom> yellow;
    ArrayList<Atom> red;
    ArrayList<Atom> green;
    ArrayList<Atom> blue;
    ArrayList<Atom> magenta;



    ParticlePanel() {
//        createAtoms();
        createRandomAtoms();
        controls.start();//start timer
    }

    public void createAtoms(){
        yellow = generateAtoms(300, 'y');
        red = generateAtoms(300, 'r');
        green = generateAtoms(300, 'g');
        blue = generateAtoms(300, 'b');
        magenta = generateAtoms(300, 'm');
    }
    public ArrayList<Atom> generateAtoms(int number, char color) {
        //create atoms and pack into ArrayList(s), 'atomgroup' and 'atoms'
        ArrayList<Atom> atomgroup = new ArrayList<>(); //used to pass atoms to individual color array(s), reference for ALL atoms packed into 'atoms' array
        for (int i=0;i<number;i++) { //with separate arrays for each color we can run interactions on each, then paint all atoms using 'atoms'
            Atom atom = new Atom(utils.random(this), utils.random(this), color);
            atomgroup.add(i, atom);
            atoms.add(atomgroup.get(i));
            //atoms.add(i, atom);
        }
        return atomgroup;
        //return atoms;
    }
    public void createRandomAtoms(){
        yellow = generateAtoms(random.nextInt(300), utils.randomColor(this));
        red = generateAtoms(random.nextInt(300), utils.randomColor(this));
        green = generateAtoms(random.nextInt(300), utils.randomColor(this));
        blue = generateAtoms(random.nextInt(300), utils.randomColor(this));
        magenta = generateAtoms(random.nextInt(300), utils.randomColor(this));
    }

    public void updateInteraction() {
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
        interactionRule(yellow, magenta, 0.3);
        interactionRule(magenta, magenta, -0.3);

    }

//    public void randomRules(){
//        int numRule = random.nextInt(12);
//        for (int i=0;i<numRule;i++) {
//            interactionRule(utils.randomGroupofAtoms(this), utils.randomGroupofAtoms(this), utils.randomDouble(this));
//        }
//    }

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



    /////graphics
    public void draw(Graphics graphics) {
        for (int i = 0; i < atoms.size(); i++) {
            graphics.setColor(utils.getColor(atoms.get(i).getC()));
            graphics.fillOval(Math.abs((int) atoms.get(i).x),Math.abs((int) atoms.get(i).y),5,5);// cast x/y to int to draw atoms
            //System.out.println(atoms.get(i).x+atoms.get(i).y);
            //definitely a bug here casting double to int
            // getting coords outside grid
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
        updateInteraction(); //update atom interactions
    }

}
