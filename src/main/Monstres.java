package main;

public class Monstres {
    public static void deplacer(Victime v, Victime[][] plateau) {

        int[] pos = getPosition(v, plateau);
        if (pos == null) return;

        int x = pos[0];
        int y = pos[1];

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int[] dir = directions[rand.nextInt(4)];

        int nx = x + dir[0];
        int ny = y + dir[1];


        if (nx < 0 || ny < 0 || nx >= plateau.length || ny >= plateau.length) return;

        Victime cible = plateau[nx][ny];


        if (cible == null) {
            plateau[nx][ny] = v;
            plateau[x][y] = null;
            return;
        }


        if (v instanceof Personnage) {

            Personnage attaquant = (Personnage) v;


            if (!cible.etreMort()) {

                System.out.println("===== COMBAT =====");
                System.out.println("Avant attaque :");
                System.out.println(attaquant.getNom() + " : " + attaquant.getVie() + " PV");
                if (cible instanceof Personnage)
                    System.out.println(((Personnage)cible).getNom() + " : " + ((Personnage)cible).getVie() + " PV");


                attaquant.attaquer(cible);

                System.out.println("Après attaque :");
                System.out.println(attaquant.getNom() + " : " + attaquant.getVie() + " PV");
                if (cible instanceof Personnage)
                    System.out.println(((Personnage)cible).getNom() + " : " + ((Personnage)cible).getVie() + " PV");

                System.out.println("==================");


                if (cible.etreMort()) {
                    plateau[nx][ny] = v;
                    plateau[x][y] = null;
                }
            }
        }
    }
}
