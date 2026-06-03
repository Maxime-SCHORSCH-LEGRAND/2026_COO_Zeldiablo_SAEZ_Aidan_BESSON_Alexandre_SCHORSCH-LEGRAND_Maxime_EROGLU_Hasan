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

    public void subirdegat(int d){
        this.vie -= d;
        if (this.vie < 0) {
            this.vie = 0;
        }
    }
    public boolean estVivant() {
        return vie > 0;
    }

    public abstract int subirDegatPhysique(int coup);

    public abstract int subirDegatMagique(int sort);

}