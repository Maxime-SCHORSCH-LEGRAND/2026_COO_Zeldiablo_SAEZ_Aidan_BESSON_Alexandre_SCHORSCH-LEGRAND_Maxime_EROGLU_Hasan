package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import moteurJeu.DessinJeu;

public class LabyrintheDessin implements DessinJeu {

    public static final int TAILLE = 20;

    private JeuPerso jeu;

    public LabyrintheDessin(JeuPerso j) {
        this.jeu = j;
    }

    //creation de l'image du labyrinthe du héro et de l'attaque et des monstres
    public void dessiner(BufferedImage image) {

        Graphics2D g = (Graphics2D) image.getGraphics();

        char[][] grille = jeu.getLabyrinthe().getGrille();


        g.setColor(Color.BLACK);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());

        for (int y = 0; y < grille.length; y++) {
            for (int x = 0; x < grille[y].length; x++) {

                if (grille[y][x] == '#') {
                    g.setColor(Color.GRAY);
                } else {
                    g.setColor(Color.WHITE);
                }

                g.fillRect(x * TAILLE, y * TAILLE, TAILLE, TAILLE);
            }
        }


        Hero h = jeu.getHero();

        g.setColor(Color.BLUE);
        g.fillOval(
                h.getPos().x * TAILLE,
                h.getPos().y * TAILLE,
                TAILLE,
                TAILLE
        );


        Monstre m = jeu.getMonstre();

        if (m != null && m.estVivant()) {
            g.setColor(Color.RED);
            g.fillOval(
                    m.getPos().x * TAILLE,
                    m.getPos().y * TAILLE,
                    TAILLE,
                    TAILLE
            );
        }

        Phantome p= jeu.getPhantome();

        if (p != null && p.estVivant()) {
            g.setColor(Color.PINK);
            g.fillOval(
                    p.getPos().x * TAILLE,
                    p.getPos().y * TAILLE,
                    TAILLE,
                    TAILLE
            );
        }


        if (jeu.getAnimTimer() > 0) {

            g.setColor(Color.YELLOW);

            g.fillOval(
                    jeu.getAnimX() * TAILLE,
                    jeu.getAnimY() * TAILLE,
                    TAILLE,
                    TAILLE
            );
        }

        g.dispose();
    }
}