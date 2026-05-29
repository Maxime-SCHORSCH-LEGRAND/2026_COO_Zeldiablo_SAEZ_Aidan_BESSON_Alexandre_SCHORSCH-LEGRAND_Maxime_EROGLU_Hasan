package main;

public abstract class Personnage {

    private Position pos;


    public Personnage(int x, int y) {
        this.pos = new Position(x, y);

    }





    public Position getPos() {
        return pos;
    }


}