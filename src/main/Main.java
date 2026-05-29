package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Labyrinthe laby =
                new Labyrinthe("labyrinthe.txt");

        Scanner sc = new Scanner(System.in);

        while(laby.hero.estVivant() &&
                laby.monstre.estVivant()) {

            laby.afficher();

            System.out.println(
                    "ZQSD pour bouger, A pour attaquer"
            );

            char c =
                    sc.nextLine().toLowerCase().charAt(0);

            int nx = laby.hero.getPos().x;
            int ny = laby.hero.getPos().y;

            switch(c) {

                case 'z':
                    ny--;
                    break;

                case 's':
                    ny++;
                    break;

                case 'q':
                    nx--;
                    break;

                case 'd':
                    nx++;
                    break;

                case 'a':
                    laby.hero.attaquer(laby.monstre);
                    break;
            }

            if(c!='a' &&
                    laby.getGrille()[ny][nx] != '#') {

                laby.hero.getPos().x = nx;
                laby.hero.getPos().y = ny;
            }

            if(laby.monstre.estVivant()) {
                laby.monstre.deplacer(
                        laby.getGrille()
                );
                laby.monstre.attaquer(
                        laby.hero
                );
            }
        }

        if(laby.hero.estVivant())
            System.out.println("Victoire !");
        else
            System.out.println("Défaite !");
    }
}