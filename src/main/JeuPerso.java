package main;

import moteurJeu.Commande;
import moteurJeu.Jeu;

public class JeuPerso implements Jeu {
    private int direction;
    private Labyrinthe labyrinthe;
    private Hero hero;
    private Monstre monstre;


    public JeuPerso(Labyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        this.hero = labyrinthe.getHero();
    }

    private int x=1;
    private int y=1;



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
    }

    private void attaquer() {
        int cibleX = hero.getPos().x;
        int cibleY = hero.getPos().y;

        switch (direction) {
            case 1: cibleX--; break;
            case 2: cibleX++; break;
            case 3: cibleY--; break;
            case 4: cibleY++; break;
        }

        for (Monstre monstre : labyrinthe.getMonstre()) {
            if (monstre.getPos().x == cibleX && monstre.getPos().y == cibleY) {
                monstre.subirdegat(hero.getDegat());
                break;
            }
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
    public Monstre getMonstre(){return monstre;}
}


