package moteurJeu;

public class DessinPerso implements DessinJeu{
    JeuPerso jeu;

    void dessiner(BufferedImageim){
        //Graphics
        Graphics g = im.getGraphics();

        g.drawRectangle(jeu.x*50,jeu.y*50,
        jeu.x*50+10, jeu,y*50+10);

    }
}
