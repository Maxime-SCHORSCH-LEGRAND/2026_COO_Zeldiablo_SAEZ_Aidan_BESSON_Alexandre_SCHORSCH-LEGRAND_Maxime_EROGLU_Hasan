package main;

import java.util.Random;

public class Monstre extends Personnage {

    private Random random;

    // Cooldowns distincts pour éviter les conflits dans la machine à états
    private int cooldownDeplacement = 0;
    private int cooldownPostDash = 0;

    private int degatFixe = 5;
    private int etatDash = 0; // 0: Normal, 1: Dash en cours, 2: Récupération
    private int dashX = 0;
    private int dashY = 0;
    private int etapesDash = 0;

    public Monstre(int x, int y, int vie) {
        super(x, y, vie);
        random = new Random();
    }

    public int subirDegatPhysique(int coup, Personnage attaquant) {
        this.vie -= coup;
        if (this.vie < 0) this.vie = 0;
        System.out.println("Monstre touché par une attaque physique ! Vie restante : " + this.vie);
        return this.vie;
    }

    public int subirDegatMagique(int sort, Personnage attaquant) {
        this.vie -= sort;
        if (this.vie < 0) this.vie = 0;
        System.out.println("Monstre brûlé par la magie ! Vie restante : " + this.vie);
        return this.vie;
    }

    public void deplacer(Labyrinthe labyrinthe) {
        if (!estVivant()) return;

        if (cooldownDeplacement > 0) {
            cooldownDeplacement--;
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
        cooldownDeplacement = 8;
    }

    public void Dash(Labyrinthe labyrinthe, Hero hero) {
        if (!estVivant()) return;

        if (etatDash == 2) {
            cooldownPostDash++;
            if (cooldownPostDash >= 30) {
                etatDash = 0;
                cooldownPostDash = 0;
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
                    hero.subirDegatPhysique(degatFixe, this);
                    etatDash = 2;
                    cooldownPostDash = 0;
                }
            } else {
                etatDash = 2;
                cooldownPostDash = 0;
            }

            if (etapesDash >= 7) {
                etatDash = 2;
                cooldownPostDash = 0;
            }
        }
    }
}