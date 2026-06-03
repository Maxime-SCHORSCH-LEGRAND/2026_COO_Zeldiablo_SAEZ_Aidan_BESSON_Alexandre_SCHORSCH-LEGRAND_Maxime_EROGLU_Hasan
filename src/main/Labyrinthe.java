package main;

import main.Hero;

import java.io.*;
import java.util.*;


public class Labyrinthe {

    private final char[][] grille;
    private Position sortie;
    private Hero hero;
    private Monstre monstre;
    private Phantome phantome;

    /**
     * constructeur par defaut  du Labyrinthe
     * @param fichier
     * @throws IOException
     */
    public Labyrinthe(String fichier) throws IOException {

        List<String> lignes = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(fichier));
        String ligne;

        while ((ligne = br.readLine()) != null) {
            lignes.add(ligne);
        }

        grille = new char[lignes.size()][lignes.get(0).length()];

        for (int y = 0; y < lignes.size(); y++) {
            for (int x = 0; x < lignes.get(y).length(); x++) {

                char c = lignes.get(y).charAt(x);
                grille[y][x] = c;

                if (c == 'H') {
                    hero = new Hero(x, y, 20);
                    grille[y][x] = '.';
                }

                if (c == 'M') {
                    monstre = new Monstre(x, y, 20);
                    grille[y][x] = '.';
                }

                if (c == 'P') {
                    phantome = new Phantome(x, y, 20);
                    grille[y][x] = '.';
                }
                if (c == 'S') {
                    sortie = new Position(x, y);
                    grille[y][x] = '.';
                }
            }
        }
    }

    /**
     * methode qui lit un point sur l'axe des abscisses et ordonnées et nous dit si la case est libre ou pas
     * @param x
     * @param y
     * @return
     */
    public boolean estLibre(int x, int y) {
        return grille[y][x] != '#';
    }

    /**
     * methode qui lit un point sur l'axe des abscisses et ordonnées et nous dit si la case est libre
     * @param x
     * @param y
     * @return
     */
    public boolean estLibrePhantome(int x, int y){
        return grille[y][x] != '@';
    }

    /**
     * methode qui renvoie la grille du Labyrinthe
     * @return
     */
    public char[][] getGrille() {
        return grille;
    }

    /**
     * methode qui renvoie le hero du Labyrinthe
     * @return
     */
    public Hero getHero() {
        return hero;
    }

    /**
     * methode qui renvoie le monstre du Labyrinth
     * @return
     */
    public Monstre getMonstre() {
        return monstre;
    }

    /**
     * methode qui renvoie le phantome du Labyrinthe
     * @return
     */
    public Phantome getPhantome(){
        return phantome;
    }

    /**
     * methode qui renvoie la sortie du Labyrinthe
     * @return
     */
    public Position getSortie() {
        return sortie;
    }


}