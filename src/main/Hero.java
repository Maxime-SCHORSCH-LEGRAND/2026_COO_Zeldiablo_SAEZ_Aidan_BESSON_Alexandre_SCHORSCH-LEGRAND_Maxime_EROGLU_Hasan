package main;

public class Hero extends Personnage {

    private int degatPhysique = 5;
    private int degatMagique = 4;
    private boolean modeMagique = false; // false = Physique, true = Magique

    public Hero(int x, int y, int vie) {
        super(x, y, 30);
    }

    public void alterModeAttaque() {
        this.modeMagique = !this.modeMagique;
        if (this.modeMagique) {
            System.out.println("🔮 Mode Magique activé ! En avant les sorts !");
        } else {
            System.out.println("⚔️ Mode Physique activé ! Sortez les muscles !");
        }
    }

    public void deplacer(int x, int y) {
        pos.x = x;
        pos.y = y;
    }

    public void attaquer(Personnage cible, int dx, int dy) {
        if (cible == null || !cible.estVivant()) {
            return;
        }

        int tx = pos.x + dx;
        int ty = pos.y + dy;

        if (cible.getPos().x == tx && cible.getPos().y == ty) {
            if (this.modeMagique) {
                System.out.println("Le héros lance une décharge magique !");
                cible.subirDegatMagique(degatMagique, this);
            } else {
                System.out.println("Le héros donne un coup de dague !");
                cible.subirDegatPhysique(degatPhysique, this);
            }
        } else {
            System.out.println("Attaque ratée !");
        }
    }

    public void perdreVie(int d) {
        this.vie -= d;
        if (this.vie < 0) {
            this.vie = 0;
        }
        System.out.println("Le héros a pris " + d + " dégâts ! Vie restante : " + this.vie);
    }

    public int subirDegatPhysique(int coup, Personnage attaquant) {
        perdreVie(coup);
        return this.vie;
    }

    public int subirDegatMagique(int sort, Personnage attaquant) {
        perdreVie(sort);
        return this.vie;
    }

    public void Charge(int direction, Labyrinthe lab, Monstre monstre) {
        int dx = 0, dy = 0;
        switch (direction) {
            case 1: dx = -1; break;
            case 2: dx = 1;  break;
            case 3: dy = -1; break;
            case 4: dy = 1;  break;
        }

        for (int i = 0; i < 3; i++) {
            int caseSuivanteX = pos.x + dx;
            int caseSuivanteY = pos.y + dy;

            if (!lab.estLibre(caseSuivanteX, caseSuivanteY)) break;
            if (monstre != null && monstre.estVivant() && monstre.getPos().x == caseSuivanteX && monstre.getPos().y == caseSuivanteY) {
                break;
            }
            this.deplacer(caseSuivanteX, caseSuivanteY);
        }
    }
}