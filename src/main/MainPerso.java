package main;

import moteurJeu.MoteurGraphique;

public class MainPerso {

    public static void main(String[] args) throws Exception {

        Labyrinthe lab = new Labyrinthe("labyrinthe.txt");

        JeuPerso jeu = new JeuPerso(lab);

        LabyrintheDessin dessin = new LabyrintheDessin(jeu);

        MoteurGraphique moteur = new MoteurGraphique(jeu, dessin);

        moteur.lancerJeu(800, 600);
    }
}