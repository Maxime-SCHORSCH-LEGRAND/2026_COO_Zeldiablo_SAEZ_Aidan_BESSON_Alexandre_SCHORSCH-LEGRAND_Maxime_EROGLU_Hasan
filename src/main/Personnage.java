package main;

public abstract class Personnage {

    protected Position pos;
    protected int vie;

    public Personnage(int x, int y, int vie) {
        this.pos = new Position(x, y);
        this.vie = vie;
    }

    public Position getPos() {
        return pos;
    }

    public int getVie() {
        return vie;
    }

    public boolean estVivant() {
        return vie > 0;
    }
}