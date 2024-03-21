package jeu;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Village extends Zone {

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
		commandes.add("BOIRE AU PUIT");
		commandes.add("PARLER AU CHEF DU VILLAGE");
		return commandes;
	}

	@Override
	public void executerCommandeSpecifique(String commande) {
		
		
		 switch (commande) {
         case "PARLER AU CHEF DU VILLAGE":
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
         /*case "VERS LA FORET":
         	Main.jeu.getGUI().afficheImage("foret.png");
         	
         	sorties.remove("VERS LA FORET");
         	
         	break;*/
         default:
         	 Main.jeu.afficher("Commande inconnue");
             break;
         
     }
		 
		
	}
	
	private String lireReponseGUI() {
	    return JOptionPane.showInputDialog("Quelle est la capitale de Djibouti?");
	}
}

