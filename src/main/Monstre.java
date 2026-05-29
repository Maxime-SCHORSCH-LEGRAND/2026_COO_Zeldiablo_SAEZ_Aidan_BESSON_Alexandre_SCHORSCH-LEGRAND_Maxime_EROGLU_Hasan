package main;

import java.util.Random;

public class Monstre extends Personnage {

    private Random random = new Random();

    public Monstre(int x, int y) {
        super(x, y, 15);
    }

    public void deplacer(char[][] laby) {

        int[][] directions = {
                {0,-1},
                {0,1},
                {-1,0},
                {1,0}
        };

        int choix = random.nextInt(4);

        int nx = pos.x + directions[choix][0];
        int ny = pos.y + directions[choix][1];

        if(laby[ny][nx] != '#') {
            pos.x = nx;
            pos.y = ny;
        }
    }

    public void attaquer(Hero h) {

        int dx = Math.abs(pos.x - h.getPos().x);
        int dy = Math.abs(pos.y - h.getPos().y);

        if(dx + dy == 1) {
            h.subirDegats(3);
            System.out.println("Le monstre attaque !");
        }
    }
}
