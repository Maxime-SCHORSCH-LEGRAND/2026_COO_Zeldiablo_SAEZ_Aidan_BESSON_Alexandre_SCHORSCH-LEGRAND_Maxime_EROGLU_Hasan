package moteurJeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * classe qui represente un controleur en lien avec un KeyListener
 */
public class Controleur implements KeyListener {

	private Commande commandeEnCours;
	private Commande commandeARetourner;

	public Controleur() {
		this.commandeEnCours = new Commande();
		this.commandeARetourner = new Commande();
	}

	public Commande getCommande() {
		Commande aRetourner = this.commandeARetourner;
		this.commandeARetourner = new Commande(this.commandeEnCours);
		return (aRetourner);
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyChar()) {


			case 'q':
				this.commandeEnCours.gauche = true;
				this.commandeARetourner.gauche = true;
				break;

			case 'd':
				this.commandeEnCours.droite = true;
				this.commandeARetourner.droite = true;
				break;

			case 'z':
				this.commandeEnCours.haut = true;
				this.commandeARetourner.haut = true;
				break;

			case 's':
				this.commandeEnCours.bas = true;
				this.commandeARetourner.bas = true;
				break;

			case ' ':
				this.commandeEnCours.espace = true;
				this.commandeARetourner.espace = true;
				break;


			case 'f':
				this.commandeEnCours.f = true;
				this.commandeARetourner.f = true;
				break;

			case 't':
				this.commandeEnCours.t = true;
				this.commandeARetourner.t = true;
				break;

			case 'g':
				this.commandeEnCours.g = true;
				this.commandeARetourner.g = true;
				break;

			case 'h':
				this.commandeEnCours.h = true;
				this.commandeARetourner.h = true;
				break;

			case 'a':
				this.commandeEnCours.a = true;
				this.commandeARetourner.a = true;
				break;
		}
	}


	public void keyReleased(KeyEvent e) {

		switch (e.getKeyChar()) {

			case 'q':
				this.commandeEnCours.gauche = false;
				break;

			case 'd':
				this.commandeEnCours.droite = false;
				break;

			case 'z':
				this.commandeEnCours.haut = false;
				break;

			case 's':
				this.commandeEnCours.bas = false;
				break;

			case ' ':
				this.commandeEnCours.espace = false;
				break;


			case 'f':
				this.commandeEnCours.f = false;
				break;

			case 't':
				this.commandeEnCours.t = false;
				break;

			case 'g':
				this.commandeEnCours.g = false;
				break;

			case 'h':
				this.commandeEnCours.h = false;
				break;

			case 'a':
				this.commandeEnCours.a = false;
				break;
		}
	}


	public void keyTyped(KeyEvent e) {

	}
}