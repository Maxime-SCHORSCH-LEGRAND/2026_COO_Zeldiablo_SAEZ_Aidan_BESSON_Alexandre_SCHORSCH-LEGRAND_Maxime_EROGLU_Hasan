package moteurJeu;

/**
 * permet de représenter une commande de l'utilisateur
 */
public class Commande {

	public boolean gauche;
	public boolean droite;
	public boolean haut;
	public boolean bas;
	public boolean espace;
	public boolean f;
	public boolean t;
	public boolean g;
	public boolean h;
	public boolean a;



	public boolean attaque;

	public Commande() {
	}

	/**
	 * constructeur par copie
	 */
	public Commande(Commande commandeACopier) {

		this.bas = commandeACopier.bas;
		this.haut = commandeACopier.haut;
		this.gauche = commandeACopier.gauche;
		this.droite = commandeACopier.droite;
		this.espace = commandeACopier.espace;
		this.a = commandeACopier.a;


		this.attaque = commandeACopier.attaque;
	}
}