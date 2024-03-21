package jeu;

import java.util.List;

public class Temple extends Zone {

    public Temple() {
        super("Temple");
        ajouterImage("temple.png");
       
    }

    @Override
    public List<String> getCommandesSpecifiques() {
        return null;
    }

    @Override
    public void executerCommandeSpecifique(String commande) {

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
}

