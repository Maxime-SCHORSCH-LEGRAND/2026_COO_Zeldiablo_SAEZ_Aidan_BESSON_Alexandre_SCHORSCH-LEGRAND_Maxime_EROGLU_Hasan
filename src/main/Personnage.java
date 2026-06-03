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

    /**
     * methode qui renvoie la position du personnage
     * @return
     */
    public Position getPos() {
        return pos;
    }

    /**
     * methode qui permet de savoir si la personnage et en vie
     * @return
     */
    public boolean estVivant() {
        return vie > 0;
    }

    /**
     * methode qui lit les degats d'un coup et les fait subir au personnage
     * @param coup
     * @return
     */
    public abstract int subirDegatPhysique(int coup);


}