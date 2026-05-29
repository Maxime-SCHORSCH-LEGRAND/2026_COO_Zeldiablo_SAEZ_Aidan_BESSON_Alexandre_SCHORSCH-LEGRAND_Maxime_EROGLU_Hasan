package main;

public class Hero extends Personnage {

    public Hero(int x, int y) {
        super(x, y, 20);
    }

    public void attaquer(Monstre m) {

        int dx = Math.abs(pos.x - m.getPos().x);
        int dy = Math.abs(pos.y - m.getPos().y);

        if(dx + dy == 1) {
            m.subirDegats(5);
            System.out.println("Le héros attaque !");
        }
    }
}