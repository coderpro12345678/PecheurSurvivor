package jeu;

import java.util.ArrayList;
import java.util.List;

public class Foret extends Zone {

    public Foret(String description) {
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
		commandes.add("NORD");
		commandes.add("EST");
		commandes.add("OUEST");
		
		return commandes;
	}

	@Override
	public void executerCommandeSpecifique(String commande) {
		// TODO Auto-generated method stub
		
	}
}

