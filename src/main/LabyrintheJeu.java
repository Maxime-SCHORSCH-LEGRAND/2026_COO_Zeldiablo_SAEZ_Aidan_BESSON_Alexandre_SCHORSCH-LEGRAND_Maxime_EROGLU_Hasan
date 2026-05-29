package main;

import moteurJeu.Commande;
import moteurJeu.Jeu;

public class LabyrintheJeu implements Jeu {

    private Labyrinthe labyrinthe;
    private Hero hero;

    public LabyrintheJeu(Labyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        this.hero = labyrinthe.getHero();
    }


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
        if (c.espace) {
            hero.attaquer(this);
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
}