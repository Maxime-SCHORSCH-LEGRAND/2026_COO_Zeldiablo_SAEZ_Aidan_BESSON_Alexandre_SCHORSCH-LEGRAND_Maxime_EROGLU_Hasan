package main;

public abstract class Personnage {

    private Position pos;
    public int vie ;

    public Personnage(int x, int y, int vie ) {
        this.pos = new Position(x, y);
        this.vie = vie ;
    }





    public Position getPos() {
        return pos;
    }


}