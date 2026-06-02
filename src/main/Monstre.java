package main;

import java.util.Random;

public class Monstre {

    private Position pos;
    private Random random;

    private int vie;

    private int cooldown = 0;

    public Monstre(int x, int y,int vie) {
        pos = new Position(x, y);
        random = new Random();
        this.vie = vie ;
    }

    public Position getPos() {
        return pos;
    }

    public int getVie() {
        return vie;
    }

    public boolean estVivant() {
        return vie > 0;
    }

    public void subirDegats(int degats) {
        vie -= degats;

        if (vie < 0) {
            vie = 0;
        }
    }

    public void deplacer(Labyrinthe labyrinthe) {

        if (!estVivant()) return;

        if (cooldown > 0) {
            cooldown--;
            return;
        }

        int[][] directions = {
                {0,-1},
                {0,1},
                {-1,0},
                {1,0}
        };

        int choix = random.nextInt(4);

        int nx = pos.x + directions[choix][0];
        int ny = pos.y + directions[choix][1];

        if (labyrinthe.estLibre(nx, ny)) {
            pos.x = nx;
            pos.y = ny;
        }

        cooldown = 8;
    }
}