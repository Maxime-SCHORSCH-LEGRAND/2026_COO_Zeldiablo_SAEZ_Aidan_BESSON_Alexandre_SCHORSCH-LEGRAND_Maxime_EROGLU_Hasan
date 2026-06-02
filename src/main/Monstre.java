package main;

public class Monstre extends Personnage{

    public Monstre(int x, int y, int vie) {
        super(x, y, vie);
    }

    public Position getPos(){
        return pos;
    }

}
