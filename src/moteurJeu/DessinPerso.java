
package moteurJeu;

import main.JeuPerso;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DessinPerso implements DessinJeu{

    private JeuPerso jeu;

    public void  dessiner(BufferedImage im){

        Graphics g = im.getGraphics();

        g.drawRect(jeu.x*50,jeu.y*50,
        50, 50);

    }

    public JeuPerso getJeu(){
        return this.jeu;
    }
    
}

