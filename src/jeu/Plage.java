package jeu;
import java.util.ArrayList;
import java.util.List;

public class Plage extends Zone {
    
	private Objet couteau;
    public Plage(String description) {
        super(description);
        this.couteau = new Objet("Couteau");
        
        commandes = new ArrayList<String>();
        
        
    }

    public List<String> getCommandesSpecifiques() {
        
        commandes.add("EPAVE");
        
        sorties.add("VERS LA FORET");
        return commandes;
    }
    public List<String> ajoutSorties(){
    	sorties.add("VERS LA FORET");
    	return sorties;
    }
    
    @Override
    public void executerCommandeSpecifique(String commande) {
        switch (commande) {
            case "EPAVE":
                // Afficher l'image et le message à la console
                Main.jeu.getGUI().afficheImage("plageSac.png");
                Main.jeu.afficher("Vous êtes devant ce qui reste de votre bateau. \n"
                		+ "Vous ramassé ce qui en reste à savoir un sac qui vous servira d'inventaire.");
               
                
                commandes.add("ROCHER");
                commandes.remove("EPAVE");
                break;
            case "ROCHER":
                Main.jeu.getGUI().afficheImage("plageCouteau.png");
                Main.jeu.afficher("Vous avez trouver un rocher");
                Main.jeu.getJoueur().ramasserObjet(couteau);
                commandes.remove("ROCHER");
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
}