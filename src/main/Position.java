package main;

public class Position {
    public int x;
    public int y;

    /**
     * constructeur par defaut de la position
     * @param x
     * @param y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * le getter de x pour récupéré sa position sur l'axe des abscisses
     * @return
     */
    public int getX(){
        return x;
    }

    /**
     * le getter de y pour récupéré sa position sur l'axe des ordonnées
     * @return
     */
    public int getY(){
        return y;
    }
    /**
     * ensemble cela nous permet de récupéré la positon de n'importe quel éléments
     */
}