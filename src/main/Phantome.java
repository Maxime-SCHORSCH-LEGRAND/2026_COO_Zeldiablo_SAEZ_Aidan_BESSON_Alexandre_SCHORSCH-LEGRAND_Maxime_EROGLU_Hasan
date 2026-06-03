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
     * methode qui lit la cible et sa postion et renvoie les degats fait
     * @param cible
     * @param dx
     * @param dy
     */
    public void attaque(Personnage cible, int dx, int dy){
        if (cible == null || !cible.estVivant()) return;

        if (cible.getPos().x == dx && cible.getPos().y == dy) {
            cible.subirDegatPhysique(sort);
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
    /** fait perdre des pv au phantome
     *
     * **/
    public  int subirDegatPhysique(int coup){
        this.vie-=coup;
        return this.vie;
    }
}