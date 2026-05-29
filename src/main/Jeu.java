package main;

import java.util.Scanner;

public class Jeu {

    public static void main(String[] args) throws Exception {
         boolean t = true ;
        Labyrinthe laby =
                new Labyrinthe("labyrinthe.txt");

        Scanner sc = new Scanner(System.in);

        while(t==true ) {

            laby.afficher();

            System.out.println(
                    "ZQSD pour bouger, A pour attaquer"
            );

            char c = sc.nextLine().toLowerCase().charAt(0);

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


            }

            if(c!='a' &&
                    laby.getGrille()[ny][nx] != '#') {

                laby.hero.getPos().x = nx;
                laby.hero.getPos().y = ny;
            }


        }
            }
}