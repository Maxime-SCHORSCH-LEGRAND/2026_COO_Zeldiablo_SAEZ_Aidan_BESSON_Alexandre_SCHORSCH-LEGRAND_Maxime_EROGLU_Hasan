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


    public void dessiner(BufferedImage image) {

        Graphics2D g = (Graphics2D) image.getGraphics();

        char[][] grille = jeu.getLabyrinthe().getGrille();

        // Fond noir
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());

        // Dessin du labyrinthe
        for (int y = 0; y < grille.length; y++) {
            for (int x = 0; x < grille[y].length; x++) {

                if (grille[y][x] == '#') {
                    g.setColor(Color.GRAY);
                } else {
                    g.setColor(Color.WHITE);
                }

                g.fillRect(
                        x * TAILLE,
                        y * TAILLE,
                        TAILLE,
                        TAILLE
                );
            }
        }

        // Dessin du héros
        Hero h = jeu.getHero();

        g.setColor(Color.BLUE);
        g.fillOval(
                h.getPos().x * TAILLE,
                h.getPos().y * TAILLE,
                TAILLE,
                TAILLE
        );


        g.setColor(Color.LIGHT_GRAY);
        g.drawString(
                "PV : " + h.getVie(),
                10,
                20
        );

        Monstre m = jeu.getMonstre();

        g.setColor(Color.RED);
        g.fillOval(
                m.getPos().x * TAILLE,
                m.getPos().y * TAILLE,
                TAILLE,
                TAILLE
        );


        g.setColor(Color.RED);
        g.drawString(
                "PV : " + h.getVie(),
                10,
                20
        );

        g.dispose();
    }
}