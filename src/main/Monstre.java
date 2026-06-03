package main;

import java.util.Random;

public class Monstre {

    private Position pos;
    private Random random;

    private int vie;

    private int cooldown = 0;

    private int degatFixe = 5;
    private int etatDash = 0;
    private int dashX = 0;
    private int dashY = 0;
    private int etapesDash = 0;

    public Monstre(int x, int y, int vie) {
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
        int ny = pos.y+ directions[choix][1];

        if (labyrinthe.estLibre(nx, ny)) {
            pos.x =nx ;
            pos.y = ny;
        }

        cooldown = 8;
    }

    public void Dash(Labyrinthe labyrinthe, Hero hero) {
        if (!estVivant()) return;

        if (etatDash == 2) {
            cooldown++;
            if (cooldown >= 30) {
                etatDash = 0;
                cooldown = 0;
            }
            return;
        }

        if (etatDash == 0) {
            int hX = hero.getPos().x;
            int hY = hero.getPos().y;

            if (pos.y == hY && Math.abs(pos.x - hX) <= 5) {
                dashX = (hX > pos.x) ? 1 : -1;
                dashY = 0;
                etatDash = 1;
                etapesDash = 0;
            } else if (pos.x == hX && Math.abs(pos.y - hY) <= 5) {
                dashX = 0;
                dashY = (hY > pos.y) ? 1 : -1;
                etatDash = 1;
                etapesDash = 0;
            } else {
                deplacer(labyrinthe);
            }
        }

        if (etatDash == 1) {
            int nx = pos.x + dashX;
            int ny = pos.y + dashY;

            if (labyrinthe.estLibre(nx, ny)) {
                pos.x = nx;
                pos.y = ny;
                etapesDash++;

                if (pos.x == hero.getPos().x && pos.y == hero.getPos().y) {
                    hero.subirDegatPhysique(degatFixe);
                    etatDash = 2;
                    cooldown = 0;
                }
            } else {
                etatDash = 2;
                cooldown = 0;
            }

            if (etapesDash >= 7) {
                etatDash = 2;
                cooldown = 0;
            }
        }
    }

    public int subirDegatPhysique(int coup) {
        this.vie = Math.max(0, this.vie - coup);
        return this.vie;
    }

    public int subirDegatMagique(int sort) {
        this.vie = Math.max(0, this.vie - sort);
        return this.vie;
    }

}