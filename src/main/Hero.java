package main;

public class Hero extends Personnage {

    private int degat = 5;

    public Hero(int x, int y, int vie) {
        super(x, y, vie);
    }

    public void deplacer(int x, int y) {
        pos.x = x;
        pos.y = y;
    }

    public void perdreVie(int d) {
        vie -= d;
        if (vie < 0) vie = 0;
    }
}