package main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Monstre {

    private Position pos;
    private Random random;

    private int vie;

    private int cooldown = 0;

    private int degatFixe = 5;
    private int etatDash = 0;
    private int dashX = 0;
    private int dashY = 0;
    private int etapesDash = 0;

    public Monstre(int x, int y, int vie) {
        pos = new Position(x, y);
        random = new Random();
        this.vie = vie ;
    }

    public Position getPos() {
        return pos;
    }

    public int getVie() {
        return vie;
    }

    public boolean estVivant() {
        return vie > 0;
    }



    public void deplacer(Labyrinthe labyrinthe) {
        if (!estVivant()) return;

        if (cooldown > 0) {
            cooldown--;
            return;
        }

        int startX = pos.x;
        int startY = pos.y;
        int targetX = Hero.getPos().x;
        int targetY = Hero.getPos().y;

        if (startX != targetX || startY != targetY) {
            char[][] grille = labyrinthe.getGrille();
            int hauteur = grille.length;
            int largeur = grille[0].length;

            Queue<Position> file = new LinkedList<>();
            boolean[][] visite = new boolean[hauteur][largeur];
            Position[][] parent = new Position[hauteur][largeur];

            Position depart = new Position(startX, startY);
            file.add(depart);
            visite[startY][startX] = true;

            int[][] dirs = {
                    {0,-1},
                    {0,1},
                    {-1,0},
                    {1,0}
            };

            boolean cibleTrouvee = false;

            while (!file.isEmpty()) {
                Position courante = file.poll();

                if (courante.x == targetX && courante.y == targetY) {
                    cibleTrouvee = true;
                    break;
                }

                for (int[] d : dirs) {
                    int nx = courante.x + d[0];
                    int ny = courante.y + d[1];

                    if (nx >= 0 && nx < largeur && ny >= 0 && ny < hauteur) {
                        if (!visite[ny][nx] && labyrinthe.estLibre(nx, ny)) {
                            visite[ny][nx] = true;
                            Position voisin = new Position(nx, ny);
                            parent[ny][nx] = courante;
                            file.add(voisin);
                        }
                    }
                }
            }

            if (cibleTrouvee && parent[targetY][targetX] != null) {
                Position etape = new Position(targetX, targetY);
                while (parent[etape.y][etape.x] != null && (parent[etape.y][etape.x].x != startX || parent[etape.y][etape.x].y != startY)) {
                    etape = parent[etape.y][etape.x];
                }
                pos.x = etape.x;
                pos.y = etape.y;
            }
        }

        cooldown += 8;
    }
    public void Dash(Labyrinthe labyrinthe, Hero hero) {
        if (!estVivant()) return;

        if (etatDash == 2) {
            cooldown++;
            if (cooldown >= 30) {
                etatDash = 0;
                cooldown = 0;
            }
            return;
        }

        if (etatDash == 0) {
            int hX = hero.getPos().x;
            int hY = hero.getPos().y;

            if (pos.y == hY && Math.abs(pos.x - hX) <= 5) {
                dashX = (hX > pos.x) ? 1 : -1;
                dashY = 0;
                etatDash = 1;
                etapesDash = 0;
            } else if (pos.x == hX && Math.abs(pos.y - hY) <= 5) {
                dashX = 0;
                dashY = (hY > pos.y) ? 1 : -1;
                etatDash = 1;
                etapesDash = 0;
            } else {
                deplacer(labyrinthe);
            }
        }

        if (etatDash == 1) {
            int nx = pos.x + dashX;
            int ny = pos.y + dashY;

            if (labyrinthe.estLibre(nx, ny)) {
                pos.x = nx;
                pos.y = ny;
                etapesDash++;

                if (pos.x == hero.getPos().x && pos.y == hero.getPos().y) {
                    hero.subirDegatPhysique(degatFixe);
                    etatDash = 2;
                    cooldown = 0;
                }
            } else {
                etatDash = 2;
                cooldown = 0;
            }

            if (etapesDash >= 7) {
                etatDash = 2;
                cooldown = 0;
            }
        }
    }

    public int subirDegatPhysique(int coup) {
        this.vie = Math.max(0, this.vie - coup);
        return this.vie;
    }

    public int subirDegatMagique(int sort) {
        this.cooldown+=sort/2;
        return this.cooldown;
    }

}