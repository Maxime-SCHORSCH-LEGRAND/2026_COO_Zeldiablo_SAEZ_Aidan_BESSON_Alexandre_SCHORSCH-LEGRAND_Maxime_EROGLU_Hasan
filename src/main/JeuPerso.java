package main;

import moteurJeu.Commande;
import moteurJeu.Jeu;

public class JeuPerso implements Jeu {

     public int x=1;
    public int y=1;

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
}
