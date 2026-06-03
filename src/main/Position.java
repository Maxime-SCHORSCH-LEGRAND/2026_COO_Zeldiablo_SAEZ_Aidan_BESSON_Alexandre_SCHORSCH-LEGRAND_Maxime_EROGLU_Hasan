package main;

public class Position {
    public int x;
    public int y;
    //permet de manipuler les position des personnages sur la grille
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