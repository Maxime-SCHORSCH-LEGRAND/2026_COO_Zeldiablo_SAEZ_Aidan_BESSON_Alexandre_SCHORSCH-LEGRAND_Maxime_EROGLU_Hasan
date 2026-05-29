package main;

public class Hero extends Personnage{

    private Position pos;

    public int degat=5;
    int d;

    public int vie ;


    public Hero(int x, int y , int vie ) {
        super(x,y,vie);
    }

    public Position getPos() {
        return pos;
    }

    public void deplacer(int x, int y) {
        pos.x = x;
        pos.y = y;

        void attaquer(int degat){
            this.degat=d;
        }
    }
}