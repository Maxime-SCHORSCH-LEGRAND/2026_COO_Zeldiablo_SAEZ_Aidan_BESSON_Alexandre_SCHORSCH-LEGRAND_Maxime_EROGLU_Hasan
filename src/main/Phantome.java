package main;



import main.Hero;
import main.Labyrinthe;
import main.Personnage;

import java.util.Random;

public class Phantome extends Personnage {

    private static int sort = 6;
    private Random random = new Random();
    private int cooldown = 0;

    public Phantome(int x, int y, int vie){
        super(x, y, vie);
    }

    public int subirDegatPhysique(int coup) {
        System.out.println("Le hero s'est blésssé en se tapant lui-même");
        return -1;
    }

    public int subirDegatMagique(int sort) {
        this.vie -= sort;
        if (this.vie < 0) this.vie = 0;
        return this.vie;
    }

    public void attaquer(Personnage cible, int dx, int dy){
        if (cible == null || !cible.estVivant()) return;

        int tx = pos.x + dx;
        int ty = pos.y + dy;

        if (cible.getPos().x == tx && cible.getPos().y == ty) {
            cible.subirDegatMagique(this.sort);
            System.out.println("Touché Magique ! Vie cible : " + cible.getVie());
        } else {
            System.out.println("Attaque magique ratée !");
        }
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
