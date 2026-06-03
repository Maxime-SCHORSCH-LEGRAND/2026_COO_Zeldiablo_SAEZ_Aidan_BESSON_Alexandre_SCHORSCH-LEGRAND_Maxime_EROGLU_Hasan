package main;

import java.util.Random;

public class Phantome extends Personnage {

    private static int sort = 6;
    private Random random = new Random();
    private int cooldown = 0;
    // creer une nouveau phantome
    public Phantome(int x, int y, int vie){

        super(x, y, vie);
    }
    // renvoie l'attaque au joueur si il fait une attaque au joueur
    public int subirDegatPhysique(int coup, Personnage attaquant) {
        System.out.println("L'attaque physique traverse le Phantome !");
        if (attaquant != null) {
            attaquant.subirDegatPhysique(coup, this);
        }
        return this.vie;
    }
    //retire les point de vie au phantome
    public int subirDegatMagique(int sort, Personnage attaquant) {
        this.vie -= sort;
        if (this.vie < 0) this.vie = 0;
        System.out.println("Le Phantome touché par la magie ! Vie restante : " + this.vie);
        return this.vie;
    }
    // l'attaque du phantome
    public void attaqueMagique(Personnage cible, int dx, int dy){
        if (cible == null || !cible.estVivant()) return;

        if (cible.getPos().x == dx && cible.getPos().y == dy) {
            cible.subirDegatMagique(sort, this);
        }
    }
    // fait déplacer le phantome
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

        if (labyrinthe.estLibrePhantome(nx, ny)) {
            pos.x = nx;
            pos.y = ny;
        }
        cooldown = 4;
    }
}