package jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Village extends Zone {
	private boolean dragontuée = false;
    public Village(String description) {
        super(description);
        commandes = new ArrayList<String>();

       
    }

    @Override
    public void traiterCommandeZone(String commande) {
        switch (commande.toUpperCase()) {
            case "COUPER_ARBRE":
                couperArbre();
                break;
            default:
                super.traiterCommandeZone(commande);
        }
    }

    private void couperArbre() {
       
    }

	@Override
	public List<String> getCommandesSpecifiques() {
		commandes.add("PARLER AU VILLAGEOIS");
		commandes.add("PARLER AU CHEF DU VILLAGE");
		sorties.add("OUEST-O");

		return commandes;
	}

	@Override
	public void executerCommandeSpecifique(String commande) {
		
		
		 switch (commande) {
         case "PARLER AU CHEF DU VILLAGE":
			if (!dragontuée){
             // Afficher l'image et le message à la console
        	 if(commandes.contains("PARLER AU VILLAGEOIS")) {
        		 Main.jeu.afficher("Vous devez d'abord parler au villageois");
        	 }
        	 else {
        		 Main.jeu.getGUI().afficheImage("village2.png");
        		 Main.jeu.afficher("Bonjour cher voyageur. J'ai cru comprendre que tu t'es échoué sur notre île avec ton animal \n"
        		 		+ " et que tu voulais que je t'aide à reprendre la mer avec lui. Si tu veux que je t'aide il faudra d'abord que tu m'aides.\n"
        		 		+ "Vois-tu dans cette île vit un dragon qui nous cause du tort à moi et mon village tue-e et je t'aiderai à mon tour. \n"
        		 		+ "Je te donne pour cela un arc et 1 flèche très puissante qui viendront à bout du dragon mais attention tu n'auras pas le droit de le rater.\n"
        		 		+ "Maintenant va et puisse la chance etre avec toi.");
        		 commandes.add("TUER LE DRAGON");
				 commandes.remove("PARLER AU CHEF DU VILLAGE");
        	 }}
			else{
				Main.jeu.getGUI().afficheImage("village2.png");
				Main.jeu.afficher("Merci pêcheur! En retour si je me souviens de ce que tu m'as dit tu t'es également \n" +
						"échoué avec ton ane et que tu le cherches aussi. Je l'ai vu se diriger du coté est de l'île vers la plage. \n" +
						"Il se peut qu'il t'attende là-bas");
				commandes.remove("PARLER AU CHEF DU VILLAGE");
			}

             break;
         case "PARLER AU VILLAGEOIS":

        	    Main.jeu.getGUI().afficheImage("village3.png");
        	    Main.jeu.afficher("Bonjour pêcheur, que nous vaut ta visite dans notre village \n "
        	                      + "Tu t'es échoué dans notre île avec ton âne et tu voudrais parler à notre chef? \n"
        	                      + "Avant cela il faudra que tu répondes correctement à cette question.\n");
        	    String reponse = lireReponseGUI(); // Lecture de la réponse du joueur
        	    if (reponse != null && reponse.equalsIgnoreCase("Djibouti")) {
        	        Main.jeu.afficher("Bonne réponse. Vous pouvez maintenant aller parler à notre chef");
        	        commandes.remove("PARLER AU VILLAGEOIS");
        	    } else {
        	        Main.jeu.afficher("Mauvaise réponse");
        	    }
        	    break;
			 case "TUER LE DRAGON":
				 lancerMiniJeuPourTuerLeDragon();
				 commandes.remove("TUER LE DRAGON");
				 commandes.add("PARLER AU CHEF DU VILLAGE");
				 break;

			 default:
         	 Main.jeu.afficher("Commande inconnue");
             break;

     }


	}

	private String lireReponseGUI() {
	    return JOptionPane.showInputDialog("Quelle est la capitale de Djibouti?");
	}
	private String lireReponseGUI1(){
		return JOptionPane.showInputDialog("Quel chiffre se cachait dans la zone?");
	}
	private void lancerMiniJeuPourTuerLeDragon() {
		// Afficher l'image du dragon
		Main.jeu.getGUI().afficheImage("monstre.png");
		Main.jeu.getGUI().stopperSaisieUtilisateur();


		// Afficher le chiffre "3" dans la zone
		Main.jeu.getGUI().afficher("Trouvez le chiffre caché. Regardez attentivement la zone pendant 15 secondes...\n");

		// Démarrer un Timer pour effectuer une action après 10 secondes
		Timer timer = new Timer(15000, e -> {
			// Effacer la zone après 10 secondes
			Main.jeu.getGUI().effacerImage();
			Main.jeu.getGUI().activerSaisieUtilisateur();
			// Demander au joueur de taper le chiffre
			String reponse = lireReponseGUI1();

			// Vérifier si le chiffre saisi par le joueur est correct
			if (reponse.equals("3")) {
				Main.jeu.afficher("Félicitations ! Vous avez trouvé le chiffre correct pour tuer le dragon.");
				dragontuée = true;

				// Autres actions pour tuer le dragon...
			} else {
				Main.jeu.afficher("Désolé, le chiffre que vous avez saisi est incorrect. Le dragon vous attaque ! Vous avez perdu");
				Main.jeu.terminer();
				// Autres actions en cas de réponse incorrecte...
			}
		});
		timer.setRepeats(false); // Ne répéter qu'une seule fois
		timer.start();
	}


}

