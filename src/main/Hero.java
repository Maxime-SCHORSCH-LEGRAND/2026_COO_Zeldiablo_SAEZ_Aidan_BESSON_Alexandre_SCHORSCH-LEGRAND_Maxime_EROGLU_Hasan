package main;

public class Hero extends Personnage {

    private int degat = 5;

    public Hero(int x, int y, int vie) {
        super(x, y, vie);
    }

    public void deplacer(int x, int y) {
        getPos().x = x;
        getPos().y = y;
    }

    public void subirdegat(int d) {
        this.vie -= d;
        if (this.vie < 0) this.vie = 0;
    }

    public int getDegat() {
        return degat;
    }

    public void attaquer(Monstre monstre, int direction) {

        if (monstre == null || !monstre.estVivant()) return;

        int cibleX = getPos().x;
        int cibleY = getPos().y;

        switch (direction) {
            case 1: cibleX--; break;
            case 2: cibleX++; break;
            case 3: cibleY--; break;
            case 4: cibleY++; break;
        }

        if (monstre.getPos().x == cibleX &&
                monstre.getPos().y == cibleY) {

            monstre.subirDegats(degat);
        }
    }
}