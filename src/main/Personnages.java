package main;

public abstract class Personnages implements Victime {

    private String nom;
    private int vie;

    public Personnages(String nom, int vie) {
        this.nom = nom;
        this.vie = vie;
    }

    public String getNom() {
        return nom;
    }

    public int getVie() {
        return vie;
    }

    public void ajouterVie(int n) {
        vie += n;
    }

    public boolean etreMort() {
        return vie <= 0;
    }

    public abstract void attaquer(Victime v);



    public String toString() {
        if (etreMort())
            return nom + " est mort.";
        return "Je m'appelle " + nom +
                " et j'ai " + vie + " points de vie.";
    }
}
