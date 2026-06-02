package main;

import java.io.*;
import java.util.*;

public class Labyrinthe {

    private final char[][] grille;

    private Hero hero;
    private Monstre monstre;

    public Labyrinthe(String fichier) throws IOException {

        List<String> lignes = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(fichier));
        String ligne;

        while ((ligne = br.readLine()) != null) {
            lignes.add(ligne);
        }
        br.close();

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
            }
        }
    }

    public boolean estLibre(int x, int y) {
        return grille[y][x] != '#';
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
}