package main;

import moteurJeu.Commande;
import moteurJeu.Jeu;

public class JeuPerso implements Jeu {

    /**
     * attribut labyrinthe du jeu
     */
    private Labyrinthe labyrinthe;
    private Hero hero;
    private Monstre monstre;
    private Phantome phantome;
    private int direction = 4;

    private int animX = -1;
    private int animY = -1;
    private int animTimer = 0;
    private boolean victoire = false;

    public JeuPerso(Labyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        this.hero = labyrinthe.getHero();
        this.monstre = labyrinthe.getMonstre();
        this.phantome = labyrinthe.getPhantome();
    }

    private Personnage trouverCible(int x, int y) {
        if (monstre != null && monstre.estVivant() && monstre.getPos().x == x && monstre.getPos().y == y) {
            return monstre;
        }
        if (phantome != null && phantome.estVivant() && phantome.getPos().x == x && phantome.getPos().y == y) {
            return phantome;
        }
        return null;
    }

    public void evoluer(Commande c) {
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

        if (labyrinthe.estLibre(nx, ny)) {
            hero.deplacer(nx, ny);
        }

        if (c.f) {
            animX = hero.getPos().x - 1;
            animY = hero.getPos().y;
            hero.attaquer(trouverCible(animX, animY), -1, 0);
            animTimer = 10;
        }
        if (c.t) {
            animX = hero.getPos().x;
            animY = hero.getPos().y - 1;
            hero.attaquer(trouverCible(animX, animY), 0, -1);
            animTimer = 10;
        }
        if (c.g) {
            animX = hero.getPos().x;
            animY = hero.getPos().y + 1;
            hero.attaquer(trouverCible(animX, animY), 0, 1);
            animTimer = 10;
        }
        if (c.h) {
            animX = hero.getPos().x + 1;
            animY = hero.getPos().y;
            hero.attaquer(trouverCible(animX, animY), 1, 0);
            animTimer = 10;
        }

        if (animTimer > 0) animTimer--;

        if (monstre != null && monstre.estVivant()) {
            if (monstre.getPos().y == hero.getPos().y || monstre.getPos().x == hero.getPos().x) {
                monstre.Dash(labyrinthe, hero);
            } else {
                monstre.deplacer(labyrinthe);
            }
        }

        if (phantome != null && phantome.estVivant()) {
            boolean memeLigne = phantome.getPos().y == hero.getPos().y;
            boolean memeColonne = phantome.getPos().x == hero.getPos().x;

            if (memeLigne || memeColonne) {
                phantome.attaque(hero, hero.getPos().x, hero.getPos().y);
            } else {
                phantome.deplacer(labyrinthe);
            }
        }

        if (c.espace) {
            hero.Charge(direction, labyrinthe, monstre);
        }

        Position sortie = labyrinthe.getSortie();

        if (sortie != null && hero.getPos().x == sortie.x && hero.getPos().y == sortie.y) {

            boolean monstreMort = labyrinthe.getMonstre() == null || !labyrinthe.getMonstre().estVivant();

            boolean fantomeMort = labyrinthe.getPhantome() == null || !labyrinthe.getPhantome().estVivant();

            if (monstreMort && fantomeMort) {
                System.out.println("VICTOIRE !");
                victoire = true;
            }
        }
    }

    /**
     * methode qui permet de quitter le jeu quand le hero est mort
     * @return
     */
    public boolean etreFini() {
        return hero.estMort();
    }

    /**
     * methode qui permet de renvoyer le labyrinthe du jeu
     * @return
     */
    public Labyrinthe getLabyrinthe() {
        return labyrinthe;
    }

    /**
     * methode qui renvoie le hero du jeu
     * @return
     */
    public Hero getHero() {
        return hero;
    }

    /**
     * methode qui permet de renvoyer lire le monstre du jeu
     * @return
     */
    public Monstre getMonstre() {
        return monstre;
    }

    /**
     * methode qui permet de lire le phantome duiu jeu
     * @return
     */
    public Phantome getPhantome() {
        return phantome;
    }

    /**
     * qui permet de lire les animations verticale du jeu
     * @return
     */
    public int getAnimX() {
        return animX;
    }

    /**
     * methode qui permet de lire les animations horizontales du jeu
     * @return
     */
    public int getAnimY() {
        return animY;
    }

    /**
     * methode qui permet de lire le temps de l'animation du jeu
     * @return
     */
    public int getAnimTimer() {
        return animTimer;
    }
}