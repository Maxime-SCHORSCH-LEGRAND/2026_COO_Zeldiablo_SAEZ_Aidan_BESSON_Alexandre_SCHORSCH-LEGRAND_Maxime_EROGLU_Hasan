package main;

import java.io.*;
import java.util.*;

public class Labyrinthe {

    private char[][] grille;

    public Hero hero;
    public Monstre monstre;

    public Labyrinthe(String fichier) throws IOException {

        List<String> lignes = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(fichier));

        String ligne;

        while((ligne = br.readLine()) != null) {
            lignes.add(ligne);
        }

        grille = new char[lignes.size()][lignes.get(0).length()];

        for(int y=0;y<lignes.size();y++) {

            for(int x=0;x<lignes.get(y).length();x++) {

                char c = lignes.get(y).charAt(x);

                grille[y][x] = c;

                if(c == 'H') {
                    hero = new Hero(x,y);
                    grille[y][x] = '.';
                }

                if(c == 'M') {
                    monstre = new Monstre(x,y);
                    grille[y][x] = '.';
                }
            }
        }
    }

    public char[][] getGrille() {
        return grille;
    }

    public void afficher() {

        for(int y=0;y<grille.length;y++) {

            for(int x=0;x<grille[0].length;x++) {

                if(hero.estVivant() &&
                        hero.getPos().x == x &&
                        hero.getPos().y == y)
                    System.out.print("H");

                else if(monstre.estVivant() &&
                        monstre.getPos().x == x &&
                        monstre.getPos().y == y)
                    System.out.print("M");

                else
                    System.out.print(grille[y][x]);
            }

            System.out.println();
        }

        System.out.println(
                "Vie héros : " + hero.getVie()
        );

        System.out.println(
                "Vie monstre : " + monstre.getVie()
        );
    }
}