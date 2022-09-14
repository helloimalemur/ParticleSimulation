package net.koonts;

public class Atom {
    int x;
    int y;
    char c;
    Atom(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
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

    public char getC() {
        return c;
    }

}
