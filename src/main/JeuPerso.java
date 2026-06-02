package main;

import moteurJeu.Commande;
import moteurJeu.Jeu;

public class JeuPerso implements Jeu {
    private Labyrinthe labyrinthe;
    private Hero hero;
    private Monstre monstre;
    private int direction = 4;

    private int animX = -1, animY = -1, animTimer = 0;

    public JeuPerso(Labyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        this.hero = labyrinthe.getHero();
        this.monstre = labyrinthe.getMonstre();
    }

    @Override
    public void evoluer(Commande c) {
        // 1. Déplacement du Héros
        int nx = hero.getPos().x;
        int ny = hero.getPos().y;


        if (c.gauche) {
            nx--;
            direction = 1;
        }
        if (c.droite) {
            nx++;
            direction = 2;
        }
        if (c.haut) {
            ny--;
            direction = 3;
        }
        if (c.bas) {
            ny++;
            direction = 4;
        }

        if (c.gauche) nx--;
        if (c.droite) nx++;
        if (c.haut)   ny--;
        if (c.bas)    ny++;


        if (labyrinthe.estLibre(nx, ny)) {
            hero.deplacer(nx, ny);
        }

        int adx = 0, ady = 0;
        boolean attaque = false;

        if (c.f) { adx = -1; attaque = true; } // Gauche
        if (c.t) { ady = -1; attaque = true; } // Haut
        if (c.g) { ady = 1;  attaque = true; } // Bas
        if (c.h) { adx = 1;  attaque = true; } // Droite

        if (attaque) {
            hero.attaquer(monstre, adx, ady);
            animX = hero.getPos().x + adx;
            animY = hero.getPos().y + ady;
            animTimer = 10;
        }

        if (animTimer > 0) animTimer--;

        if (monstre != null && monstre.estVivant()) {
            monstre.deplacer(labyrinthe);
        }
        if (c.espace) {
            hero.Charge(direction, labyrinthe, monstre);
        }
    }

    @Override
    public boolean etreFini() { return !hero.estVivant(); }

    // Getters
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