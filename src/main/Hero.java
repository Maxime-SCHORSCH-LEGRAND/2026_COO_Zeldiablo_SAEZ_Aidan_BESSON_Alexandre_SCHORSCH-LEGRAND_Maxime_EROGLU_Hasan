package main;

public class Hero extends Personnage {

    private int degat = 5;

    public Hero(int x, int y, int vie) {
        super(x, y, vie);
    }

    public void deplacer(int x, int y) {
        pos.x = x;
        pos.y = y;
    }

    public void attaquer(Monstre monstre, int dx, int dy) {

        if (monstre == null || !monstre.estVivant()) {
            return;
        }

        int tx = pos.x + dx;
        int ty = pos.y + dy;

        if (monstre.getPos().x == tx &&
                monstre.getPos().y == ty) {

            monstre.subirDegats(5);
            System.out.println("Touché ! Vie monstre : " + monstre.getVie());

        } else {
            System.out.println("Attaque ratée !");
        }
    }

    //j'ai envie de mourrir
    public void perdreVie(int degats) {
        vie -= degats;

        if (vie < 0) {
            vie = 0;
        }
    }
}