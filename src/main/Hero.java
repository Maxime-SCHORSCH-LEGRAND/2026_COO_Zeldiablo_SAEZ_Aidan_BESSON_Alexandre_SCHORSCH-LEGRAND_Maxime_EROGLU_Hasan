package main;

public class Hero extends Personnage{

    private Position pos;
<<<<<<< HEAD
    public int degat=5;
    int d;
=======
    public int vie ;
>>>>>>> 77e8effb9d5b4e4d0d45f788bace755686a29b6f

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