package jeu;

import java.util.ArrayList;
import java.util.List;

public class Foret extends Zone {

    public Foret(String description) {
        super(description);
        commandes = new ArrayList<String>();
        sorties.add("NORD-N");
        
       
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


		
		return commandes;
	}

	@Override
	public void executerCommandeSpecifique(String commande) {
		// TODO Auto-generated method stub
		
	}
}

