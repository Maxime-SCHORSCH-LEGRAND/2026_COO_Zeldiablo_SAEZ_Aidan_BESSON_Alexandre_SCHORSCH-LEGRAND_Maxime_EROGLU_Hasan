
package moteurJeu;

import main.JeuPerso;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DessinPerso implements DessinJeu{
    JeuPerso jeu;

    public void  dessiner(BufferedImage im){

        Graphics g = im.getGraphics();

        g.drawRect(jeu.rex*50,jeu.rey*50,
        50, 50);

    }
    
}

