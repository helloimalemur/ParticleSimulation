package net.koonts;

public class Atom {
    int x;
    int y;
    int vx;
    int vy;
    char c;
    Atom(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.vx = 0;
        this.vy = 0;
    }

    public Atom getAtom() {
        return this;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVx() { return vx; }

    public int getVy() { return vy; }

    public char getC() {
        return c;
    }

}
