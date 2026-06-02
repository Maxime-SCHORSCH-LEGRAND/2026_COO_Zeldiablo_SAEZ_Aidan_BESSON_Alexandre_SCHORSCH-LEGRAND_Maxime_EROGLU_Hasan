package main;

import moteurJeu.Commande;
import moteurJeu.Jeu;

public class JeuPerso implements Jeu {

    private Labyrinthe labyrinthe;
    private Hero hero;
    private Monstre monstre;


    private int animX = -1;
    private int animY = -1;
    private int animTimer = 0;

    public JeuPerso(Labyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        this.hero = labyrinthe.getHero();
        this.monstre = labyrinthe.getMonstre();
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


        if (c.f) {
            hero.attaquer(monstre, -1, 0);
            animX = hero.getPos().x - 1;
            animY = hero.getPos().y;
            animTimer = 10;
        }

        if (c.t) {
            hero.attaquer(monstre, 0, -1);
            animX = hero.getPos().x;
            animY = hero.getPos().y - 1;
            animTimer = 10;
        }


        if (c.g) {
            hero.attaquer(monstre, 0, 1);
            animX = hero.getPos().x;
            animY = hero.getPos().y + 1;
            animTimer = 10;
        }


        if (c.h) {
            hero.attaquer(monstre, 1, 0);
            animX = hero.getPos().x + 1;
            animY = hero.getPos().y;
            animTimer = 10;
        }


        if (animTimer > 0) {
            animTimer--;
        }

        if (monstre != null && monstre.estVivant()) {
            monstre.Dash(labyrinthe, hero);
        }
    }
    
    public boolean etreFini() {
        return !hero.estVivant();
    }

    public Labyrinthe getLabyrinthe() {
        return labyrinthe;
    }

    public Hero getHero() {
        return hero;
    }

    public Monstre getMonstre() {
        return monstre;
    }

    public int getAnimX() {
        return animX;
    }

    public int getAnimY() {
        return animY;
    }

    public int getAnimTimer() {
        return animTimer;
    }
}