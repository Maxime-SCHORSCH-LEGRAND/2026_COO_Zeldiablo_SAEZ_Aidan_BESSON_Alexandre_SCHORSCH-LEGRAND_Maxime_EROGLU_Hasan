package main;

public class Hero {

    private Position pos;
    public int degat=5;
    int d;

    public Hero(int x, int y) {
        pos = new Position(x, y);
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