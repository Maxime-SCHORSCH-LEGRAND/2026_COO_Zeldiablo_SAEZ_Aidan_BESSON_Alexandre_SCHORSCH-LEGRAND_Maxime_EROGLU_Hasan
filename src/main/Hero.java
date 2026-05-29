package main;

public class Hero {

    private Position pos;

    public Hero(int x, int y) {
        pos = new Position(x, y);
    }

    public Position getPos() {
        return pos;
    }

    public void deplacer(int x, int y) {
        pos.x = x;
        pos.y = y;
    }
}