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
    // créer le labyrinthe et le lit depuis un fichier donné
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
    // bloc les case pour tous personnages sauf le phantome
    public boolean estLibre(int x, int y) {
        return grille[y][x] != '#';
    }
    //vérifie les cases pour savoir si le phantome peut y passer
    public boolean estLibrePhantome(int x, int y){
        return grille[y][x] != '@';
    }

    public char[][] getGrille() {
        return grille;
    }

    public Hero getHero() {
        return hero;
    }

    public Monstre getMonstre() {
        return monstre;
    }

    public Phantome getPhantome(){
        return phantome;
    }
    public Position getSortie() {
        return sortie;
    }


}