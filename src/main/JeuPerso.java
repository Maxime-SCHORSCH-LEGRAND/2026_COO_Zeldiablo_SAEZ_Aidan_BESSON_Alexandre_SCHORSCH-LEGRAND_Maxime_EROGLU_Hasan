package main;

import moteurJeu.Commande;
import moteurJeu.Jeu;

public class JeuPerso implements Jeu {

    private Labyrinthe labyrinthe;
    private Hero hero;


    public JeuPerso(Labyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        this.hero = labyrinthe.getHero();
    }

    private int x=1;
    private int y=1;



    public void evoluer(Commande c) {

        int nx = hero.getPos().x;
        int ny = hero.getPos().y;

        if (c.gauche) nx--;
        if (c.droite) nx++;
        if (c.haut) ny--;
        if (c.bas) ny++;

        if (labyrinthe.estLibre(nx, ny)) {
            hero.deplacer(nx, ny);
        }
    }



    public boolean etreFini() {
        return false;
    }


    public Labyrinthe getLabyrinthe() {
        return labyrinthe;
    }

    public Hero getHero() {
        return hero;
    }
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

}


