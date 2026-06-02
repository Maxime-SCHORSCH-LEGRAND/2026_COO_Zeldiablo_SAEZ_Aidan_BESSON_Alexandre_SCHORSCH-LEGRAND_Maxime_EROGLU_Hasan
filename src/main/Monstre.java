package main;

import java.util.Random;

public class Monstre extends Personnage {
    private Random random = new Random();
    private int cooldown = 0;

    public Monstre(int x, int y, int vie) {
        super(x, y, vie); // Appelle le constructeur de Personnage
    }

    public void deplacer(Labyrinthe labyrinthe) {
        if (!estVivant()) return;

        if (cooldown > 0) {
            cooldown--;
            return;
        }

        int[][] directions = {{0,-1}, {0,1}, {-1,0}, {1,0}};
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