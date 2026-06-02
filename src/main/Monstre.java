package main;

public class Monstre extends Personnage{

    public Monstre(int x, int y, int vie) {
        super(x, y, vie);
    }

    public Position getPos(){
        return pos;
    }

    public void subirdegat(int degat) {
        this.vie = this.vie - degat;
        if (this.vie < 0) {
            this.vie = 0; 
        }
    }

}
