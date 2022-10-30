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
    int rulesLimit = 20;
    Controls controls = new Controls(this);
    Utils utils = new Utils(this);
    Timer timer = new Timer(DELAY, this);//start timer which activates action listener on DELAY interval
    ArrayList<Atom> atoms = new ArrayList<Atom>();
    ArrayList<Rule> rules = new ArrayList<>(12);


    //create atoms
    ArrayList<Atom> yellow;
    ArrayList<Atom> red;
    ArrayList<Atom> green;
    ArrayList<Atom> blue;
    ArrayList<Atom> magenta;



    ParticlePanel() {
        controls.makeGUI(this);
        this.setBounds(0,0,600,600);
//        createAtoms();
        createRandomAtoms();
        randomRules();
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
        }
        return atomgroup;
    }
    public void createRandomAtoms(){
        yellow = generateAtoms(random.nextInt(500), utils.randomColor(this));
        red = generateAtoms(random.nextInt(500), utils.randomColor(this));
        green = generateAtoms(random.nextInt(500), utils.randomColor(this));
        blue = generateAtoms(random.nextInt(500), utils.randomColor(this));
        magenta = generateAtoms(random.nextInt(500), utils.randomColor(this));
    }

    public void updateInteraction() {

        for (int i=0;i<rules.size();i++) {
            interactionRule(rules.get(i));
        }
        controls.totalAtoms.setText(String.valueOf(atoms.size()));
        controls.totalRules.setText(String.valueOf(rules.size()));
    }

    public void randomRules(){
        rules.clear();
        int numRule = random.nextInt(rulesLimit);// rules limit
        if (numRule > 5 && numRule < 20 && !(numRule % 2 == 0)) {
            for (int i=0;i<numRule;i++) {
                Rule rule = new Rule();
                rule.color1 = utils.randomGroupofAtoms(this);
                rule.color2 = utils.randomGroupofAtoms(this);
                rule.g = utils.randomDouble(this);
                rules.add(i, rule);
            }
        } else {randomRules();}
        controls.totalRules.setText(String.valueOf(numRule));
    }

    //atom interaction rules

    public void interactionRule(Rule rule) {
        ArrayList<Atom> atoms1 = rule.color1;
        ArrayList<Atom> atoms2 = rule.color1;
        double g = rule.g;

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
            graphics.fillOval(Math.abs((int) atoms.get(i).x),Math.abs((int) atoms.get(i).y),5,5);// cast x/y from double to int to draw atoms
            //definitely not ideal casting double to int
        }
    }

    @Override
    public void paintComponent(Graphics g) { //override abstract method inherited from extending JPanel
        super.paintComponent(g);
        draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) { //override abstract method inherited from implementing actionlistener
        //we activate this using timer
        repaint(); //repaint the graphics
        updateInteraction(); //update atom interactions
        if (actionEvent.getSource()==controls.resetButton) {
            controls.resetSim();
        }

        if (actionEvent.getSource()==controls.randomResetButton) {
            controls.resetRandom();
        }

        if (actionEvent.getSource()==controls.randomRulesButton) {
            randomRules();
        }
    }
}
