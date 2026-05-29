
package moteurJeu;

import main.JeuPerso;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DessinPerso implements DessinJeu{
    JeuPerso jeu;

    public void  dessiner(BufferedImage im){

        Graphics g = im.getGraphics();

        g.drawRectangle(jeu.x*50,jeu.y*50,
        jeu.x*50+10, jeu,y*50+10);

    }
    
}

