package main;

public class Hero extends Personnage {

    private Position pos;

    public int degat = 5;

    int d;

    public int vie;

    public Hero(int x, int y, int vie) {
        super(x, y, vie);

        pos = new Position(x, y);
    }

    public Position getPos() {
        return pos;
    }

    public void deplacer(int x, int y) {
        pos.x = x;
        pos.y = y;
    }

    public void attaquer(LabyrintheJeu jeu) {

        char[][] grille = jeu.getLabyrinthe().getGrille();

        int x = pos.x;
        int y = pos.y;

        if (y > 0 && grille[y - 1][x] == 'E') {
            grille[y - 1][x] = ' ';
        }

        else if (y < grille.length - 1 && grille[y + 1][x] == 'E') {
            grille[y + 1][x] = ' ';
        }

        else if (x > 0 && grille[y][x - 1] == 'E') {
            grille[y][x - 1] = ' ';
        }

        else if (x < grille[0].length - 1 && grille[y][x + 1] == 'E') {
            grille[y][x + 1] = ' ';
        }
    }
}