package main;

import java.util.Random;

public class Phantome extends Personnage {

    private static int sort = 6;
    private Random random = new Random();
    private int cooldown = 0;

    /**
     * constructeur du Phantome
     * @param x
     * @param y
     * @param vie
     */
    public Phantome(int x, int y, int vie){

        super(x, y, vie);
    }

    /**
     * methode qui lit les degats du coup et l'attquant et renvoie les degats physiques au Phantome
     * le hero ne peut pas faire d'attaque physique sur le Phantome et se fait contrer
     * @param coup
     * @param attaquant
     * @return
     */
    public int subirDegatPhysique(int coup, Personnage attaquant) {
        System.out.println("L'attaque physique traverse le Phantome !");
        if (attaquant != null) {
            attaquant.subirDegatPhysique(coup, this);
        }
        return this.vie;
    }

    /**
     * methode qui lit les degats du sort et l'attquant et renvoie les degats magiques au Phantome
     * @param sort
     * @param attaquant
     * @return
     */
    public int subirDegatMagique(int sort, Personnage attaquant) {
        this.vie -= sort;
        if (this.vie < 0) this.vie = 0;
        System.out.println("Le Phantome touché par la magie ! Vie restante : " + this.vie);
        return this.vie;
    }

    /**
     * methode qui lit la cible et sa postion et renvoie les degats fait
     * @param cible
     * @param dx
     * @param dy
     */
    public void attaqueMagique(Personnage cible, int dx, int dy){
        if (cible == null || !cible.estVivant()) return;

        if (cible.getPos().x == dx && cible.getPos().y == dy) {
            cible.subirDegatMagique(sort, this);
        }
    }

    /**
     *methode qui lit le labyrinthe et permet au Phantome de s'y deplacer
     * le Phantome traverse les murs au sein du labyrinthe mais n'en sort pas
     * @param labyrinthe
     */
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