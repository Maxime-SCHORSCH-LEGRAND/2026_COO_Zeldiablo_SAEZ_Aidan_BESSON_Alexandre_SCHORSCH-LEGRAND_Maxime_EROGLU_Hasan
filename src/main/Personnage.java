package main;

public abstract class Personnage {

    protected Position pos;
    protected int vie;

    /**
     * constructeur du Personnage
     * @param x
     * @param y
     * @param vie
     */
    public Personnage(int x, int y, int vie) {
        this.pos = new Position(x, y);
        this.vie = vie;
    }
    // renvoie la position
    public Position getPos() {
        return pos;
    }
    // renvoie si la cible est vivante ou pas
    public boolean estVivant() {
        return vie > 0;
    }
    // fait perdre les point de vie
    public abstract int subirDegatPhysique(int coup);


}