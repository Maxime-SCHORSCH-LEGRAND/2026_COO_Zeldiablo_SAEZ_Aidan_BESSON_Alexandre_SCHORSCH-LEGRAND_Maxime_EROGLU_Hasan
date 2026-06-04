package main;

public class Hero extends Personnage {

    private int degatPhysique = 5;


    /**

    constructeur par defaut de la classe hero
    @param x
    @param y
    @param vie*/
    public Hero(int x, int y, int vie) {
        super(x, y, 30);}


    /**

     déplace le joueur
     @param x
     @param y
     */
    public void deplacer(int x, int y) {
        pos.x = x;
        pos.y = y;
    }

    /**

    attaque
    @param cible
    @param dx
    @param dy*/
    public void attaquer(Personnage cible, int dx, int dy) {
        if (cible == null || !cible.estVivant()) {
            return;}

        int tx = pos.x + dx;
        int ty = pos.y + dy;

        if (cible.getPos().x == tx && cible.getPos().y == ty) {
                System.out.println("Le héros donne un coup de dague !");
                cible.subirDegatPhysique(degatPhysique);
        } else {
            System.out.println("Attaque ratée !");
        }
    }

    /*
            *fait perdre les points de vie et affiche les point de vie/dégats.
     */
    public void perdreVie(int d) {
        this.vie -= d;
        if (this.vie < 0) {
            this.vie = 0;
        }
        System.out.println("Le héros a pris " + d + " dégâts ! Vie restante : " + this.vie);
    }

    /**

    fait perdre des point de vie (ou non) suite a une attaque magique
    @param coup
@return*/
    public int subirDegatPhysique(int coup) {
        perdreVie(coup);
        return this.vie;}



    /**

     permet au héro de ce déplacer dans une direction de 3 case
     @param direction
     @param lab
     @param monstre*/
    public void Charge(int direction, Labyrinthe lab, Monstre monstre) {
        int dx = 0, dy = 0;
        switch (direction) {
            case 1: dx = -1; break;
            case 2: dx = 1;  break;
            case 3: dy = -1; break;
            case 4: dy = 1;  break;}

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
    public boolean estMort() {
        return this.vie <= 0;
    }

}