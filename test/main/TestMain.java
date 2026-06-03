package main;

public class TestMain {

    public static void main(String[] args) throws Exception {


        Labyrinthe lab = new Labyrinthe("labyrinthe.txt");

        Hero hero = lab.getHero();
        Monstre monstre = lab.getMonstre();
        Phantome phantome = lab.getPhantome();

        System.out.println("=== DEBUT TEST ===");


        System.out.println("\n Monstre avant déplacement ");
        System.out.println("Pos: " + monstre.getPos().x + "," + monstre.getPos().y);

        monstre.deplacer(lab);

        System.out.println(" Monstre après déplacement");
        System.out.println("Pos: " + monstre.getPos().x + "," + monstre.getPos().y);

        System.out.println("\n-- Test Dash --");
        monstre.Dash(lab, hero);
        System.out.println("Vie héro après dash: " + hero.getVie());


        System.out.println("\n Attaque héros sur monstre ");
        hero.attaquer(monstre, -1, 0);
        System.out.println("Vie monstre: " + monstre.getVie());


        System.out.println("\n Attaque phantome ");
        phantome.attaque(hero, hero.getPos().x, hero.getPos().y);
        System.out.println("Vie héro après attaque phantome: " + hero.getVie());


        System.out.println("\n TEST MORT ");
        System.out.println("Monstre mort ? " + !monstre.estVivant());
        System.out.println("Héro mort ? " + hero.estMort());

        System.out.println("\n FIN TEST ");
    }
}