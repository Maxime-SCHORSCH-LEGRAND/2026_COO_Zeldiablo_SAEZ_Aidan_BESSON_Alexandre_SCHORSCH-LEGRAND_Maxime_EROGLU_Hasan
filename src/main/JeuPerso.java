package main;

import moteurJeu.Commande;
import moteurJeu.Jeu;

public class JeuPerso implements Jeu {

    private int x=1;
    private int y=1;

    public void evoluer(Commande c){
        if(c.gauche)
            x--;
        if(c.droite)
            x++;
        if(c.haut)
            y++;
        if(c.bas)
            y--;
    }

    @Override
    public boolean etreFini() {
        return false;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
