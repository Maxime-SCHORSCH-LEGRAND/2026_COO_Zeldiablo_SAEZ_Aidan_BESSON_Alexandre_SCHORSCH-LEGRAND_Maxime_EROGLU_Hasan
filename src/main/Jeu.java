package main;

import moteurJeu.MoteurGraphique;

public class Jeu {
/** bababoy **/
    public static void main(String[] args) throws Exception {

        Labyrinthe lab = new Labyrinthe("labyrinthe.txt");

        LabyrintheJeu jeu = new LabyrintheJeu(lab);

        LabyrintheDessin dessin = new LabyrintheDessin(jeu);

        MoteurGraphique moteur =
                new MoteurGraphique(jeu, dessin);

        moteur.lancerJeu(800, 600);
    }
}