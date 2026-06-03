package main;

public class Hero extends Personnage {

    private int degat = 5;

    public Hero(int x, int y, int vie) {
        super(x, y, 30);
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

            monstre.subirDegatPhysique(5);
            System.out.println("Touché ! Vie monstre : " + monstre.getVie());

        } else {
            System.out.println("Attaque ratée !");
        }
    }


    public void perdreVie(int degatFixe) {
        vie -= degatFixe;
        if (vie < 0) {
            vie = 0;
        }
        System.out.println("Le héros a pris " + degatFixe + " dégâts ! Vie restante : " + this.vie);
    }

    public void Charge(int direction, Labyrinthe lab, Monstre monstre) {
        int dx = 0;
        int dy = 0;

        switch (direction) {
            case 1: dx = -1; break;
            case 2: dx = 1;  break;
            case 3: dy = -1; break;
            case 4: dy = 1;  break;
        }

        for (int i = 0; i < 3; i++) {
            int caseSuivanteX = pos.x + dx;
            int caseSuivanteY = pos.y + dy;

            if (!lab.estLibre(caseSuivanteX, caseSuivanteY)) {
                break;
            }
            if (monstre != null && monstre.estVivant()) {
                if (monstre.getPos().x == caseSuivanteX && monstre.getPos().y == caseSuivanteY) {
                    break;
                }
            }
            this.deplacer(caseSuivanteX, caseSuivanteY);
        }
    }

    public int subirDegatPhysique(int coup) {
        this.vie = Math.max(0, this.vie - coup);
        System.out.println("Pv héro :"+this.vie);
        return this.vie;
    }

    public int subirDegatMagique(int sort) {
        return 1;
    }
}