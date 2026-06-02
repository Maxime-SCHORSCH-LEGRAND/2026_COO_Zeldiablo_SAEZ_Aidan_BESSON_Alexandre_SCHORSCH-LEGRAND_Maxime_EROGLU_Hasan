package main;

import moteurJeu.Commande;
import moteurJeu.Jeu;

public class JeuPerso implements Jeu {

    private Labyrinthe labyrinthe;
    private Hero hero;

    private int direction = 4;

    public JeuPerso(Labyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        this.hero = labyrinthe.getHero();
    }

    @Override
    public void evoluer(Commande c) {

        int nx = hero.getPos().x;
        int ny = hero.getPos().y;

        if (c.gauche) { nx--; direction = 1; }
        if (c.droite) { nx++; direction = 2; }
        if (c.haut)   { ny--; direction = 3; }
        if (c.bas)    { ny++; direction = 4; }

        if (labyrinthe.estLibre(nx, ny)) {
            hero.deplacer(nx, ny);
        }

        if (c.espace) {
            hero.attaquer(labyrinthe.getMonstre(), direction);
        }

        // monstre bouge
        if (labyrinthe.getMonstre() != null &&
                labyrinthe.getMonstre().estVivant()) {

            labyrinthe.getMonstre().deplacer(labyrinthe);
        }
    }

    @Override
    public boolean etreFini() {
        return !hero.estVivant();
    }

    public Labyrinthe getLabyrinthe() {
        return labyrinthe;
    }

    public Hero getHero() {
        return hero;
    }
}