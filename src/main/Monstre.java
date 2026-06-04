package main;

import java.util.LinkedList;
import java.util.Queue;


public class Monstre extends Personnage {


    private int cooldown = 0;

    private int degatFixe = 5;
    private int etatDash = 0;
    private int dashX = 0;
    private int dashY = 0;
    private int etapesDash = 0;

    /**
     * constructeur du Monstre
     * @param x
     * @param y
     * @param vie
     */
    public Monstre(int x, int y, int vie) {
        super(x,y,vie);
    }

    /**
     * methode qui lit la postion du Monstre
     * @return
     */
    public Position getPos() {
        return pos;
    }

    /**
     * methode qui lit le Labyrinthe et de deplacer le monstre en son sein
     * @param labyrinthe
     */
    public void deplacer(Labyrinthe labyrinthe) {
        if (!estVivant()) return;

        if (cooldown > 0) {
            cooldown--;
            return;
        }
        /**
         * commencement , on enregistre les coordonées de début dans des variables startX et startY
         */
        int startX = pos.x;
        int startY = pos.y;
        int targetX = labyrinthe.getHero().getPos().x;
        int targetY = labyrinthe.getHero().getPos().y;

        if (startX != targetX || startY != targetY) {
            char[][] grille = labyrinthe.getGrille();
            int hauteur = grille.length;
            int largeur = grille[0].length;

            /**
             *début belman-ford
             */
            Queue<Position> file = new LinkedList<>();
            boolean[][] visite = new boolean[hauteur][largeur];
            Position[][] parent = new Position[hauteur][largeur];

            Position depart = new Position(startX, startY);
            file.add(depart);
            visite[startY][startX] = true;

            /**
             * on indique ou sont les case potentielle a exploré par rapport au monstre
             */
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


                /**
                 * cette partie est la progression (ce que je n'aurai pas reussi a refaire ,
                 * je sais ce que sait , je comprend comment ça marche mais je naurai pas le refaire actuelement
                 */
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
            /**
             * partie compliqué  : tant que la partie actuelle a un parent , il devient son propre parent
             */
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


    /**
     * methode qui permet au monstre de dash
     * ce dash met des degats au hero
     * @param labyrinthe
     * @param hero
     */
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

    /**
     * methode qui fait subir des degats au monstres
     * @param coup
     * @return
     */
    public int subirDegatPhysique(int coup) {
        this.vie = Math.max(0, this.vie - coup);
        return this.vie;
    }



}