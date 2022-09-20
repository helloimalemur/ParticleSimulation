package net.koonts;

import java.awt.*;
import java.util.ArrayList;

public class Utils {
    ParticlePanel particlePanel;
    Utils(ParticlePanel particlePanel) {
        this.particlePanel = particlePanel;
    }

    public int random(ParticlePanel particlePanel){
        //used for placement of new atoms
        int v = (particlePanel.random.nextInt(100)*6);
        return v;
    }

    public double randomDouble(ParticlePanel particlePanel) {/// believe we're only getting postive
        double d;
        double upper = .3;
        double lower = -0.3;
        d = Math.random() * (upper-lower) + lower;
//        d = particlePanel.random.nextDouble();
//        if (d%2==0) {
//            d = d * -1;
//        }
        return d;
    }

    //CREATE METHOD generate random seed to derive params
    //implement ability to save/reuse seeds

    public Color getColor(char c) {
        //transcribe char to Java color object
        if (c=='g'||c==0) {return Color.green;}
        if (c=='r'||c==1) {return Color.red;}
        if (c=='b'||c==2) {return Color.blue;}
        if (c=='y'||c==3) {return Color.yellow;}
        if (c=='m'||c==4) {return Color.magenta;}

        return null;
    }

    public char randomColor(ParticlePanel particlePanel) {
        int ran = particlePanel.random.nextInt(5);
        if (ran==0) {return 'g';}
        if (ran==1) {return 'r';}
        if (ran==2) {return 'b';}
        if (ran==3) {return 'y';}
        if (ran==4) {return 'm';}
        return 'c';
    }

    public ArrayList<Atom> randomGroupofAtoms(ParticlePanel particlePanel) {
        int ran = particlePanel.random.nextInt(5);
        if (ran==0) {return particlePanel.green;}
        if (ran==1) {return particlePanel.red;}
        if (ran==2) {return particlePanel.blue;}
        if (ran==3) {return particlePanel.yellow;}
        return particlePanel.magenta;
    }
}
