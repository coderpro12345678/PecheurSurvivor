package jeu;
import java.util.ArrayList;
import java.util.List;

public class Plage extends Zone {
    
	private Objet couteau;
    private Objet Sac;
    public Plage(String description) {
        super(description);
        this.couteau = new Objet("Couteau");
        this.Sac = new Objet("Sac");
        super.getObjets().add(Sac);
        super.getObjets().add(couteau);
        
        commandes = new ArrayList<String>();
        commandes.add("EPAVE");

        sorties.add("VERS LA FORET");
        
        
    }

    public List<String> getCommandesSpecifiques() {
        

        return commandes;
    }
    public List<String> ajoutSorties(){
    	sorties.add("VERS LA FORET-V");
    	return sorties;
    }
    
    @Override
    public void executerCommandeSpecifique(String commande) {
        switch (commande) {
            case "EPAVE":
                // Afficher l'image et le message à la console
                Main.jeu.getGUI().afficheImage("plageSac.png");
                Main.jeu.afficher("Vous êtes devant ce qui reste de votre bateau. \n"
                		+ "Vous ramassé ce qui en reste à savoir un sac qui vous servira d'inventaire. Nombre d'emplacements dans le sac :6");
               
                
                commandes.add("ROCHER");
                commandes.remove("EPAVE");
                break;
            case "ROCHER":
                Main.jeu.getGUI().afficheImage("plageCouteau.png");
                Main.jeu.afficher("Vous regardez sous le rocher et vous apercevez un objet.");
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