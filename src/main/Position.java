package main;

public class Position {
    public int x;
    public int y;
    //permet de manipuler les position des personnages sur la grille
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}